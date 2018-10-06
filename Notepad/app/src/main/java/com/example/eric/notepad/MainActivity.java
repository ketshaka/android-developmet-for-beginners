package com.example.eric.notepad;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.eric.notepad.data.NoteContract;
import com.example.eric.notepad.data.NoteDbHelper;

/**
 *  Displays notes that were entered and stored in the app.
 */

public class MainActivity extends AppCompatActivity {

    // Database helper that will provided access to the database
    private NoteDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        // To access our database, we instantiate our subclass of SQLiteOpenHelper and pass the
        // context, which is the current activity.
        mDbHelper = new NoteDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }


    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the notes database.
     */
    private void displayDatabaseInfo() {

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        /**
         *  Old query method. That could facilitate injection attacks.
         */
        // Perform this raw SQL query "SELECT * FROM notes"
        // to get a Cursor that contains all rows from the notes table.
        // Cursor cursor = db.rawQuery("SELECT * FROM " + NoteContract.NoteEntry.TABLE_NAME, null);

        // Define projection that specifies which columns from the database will be used after this
        // query.
        String[] projection = {
                NoteContract.NoteEntry._ID,
                NoteContract.NoteEntry.COLUMN_TITLE,
                NoteContract.NoteEntry.COLUMN_NOTE
        };

        // Perform a query on the notes table
        Cursor cursor = db.query(NoteContract.NoteEntry.TABLE_NAME, // table to query
                projection, // columns to return
                null, // columns for the WHERE clause
                null, // values for the WHERE clause
                null, // avoid grouping by row groups
                null, // avoid filter by row groups
                null); // sort order

        TextView displayView = (TextView) findViewById(R.id.text_view_note);

        try {
            // Create a header in the Text View that looks like this:
            //
            // The notes table contains <number of rows in Cursor> notes.
            // _id
            // title
            // note
            //
            // In the while loop below, iterate through the rows of the cursor and display the
            // information from each column in this order.
            displayView.setText("The notes table contains " + cursor.getCount() + " notes.\n\n");
            displayView.append(NoteContract.NoteEntry._ID + "\n" +
                    NoteContract.NoteEntry.COLUMN_TITLE + "\n" +
                    NoteContract.NoteEntry.COLUMN_NOTE + "\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(NoteContract.NoteEntry._ID);
            int titleColumnIndex = cursor.getColumnIndex(NoteContract.NoteEntry.COLUMN_TITLE);
            int noteColumnIndex = cursor.getColumnIndex(NoteContract.NoteEntry.COLUMN_NOTE);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word at the current
                // row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentTitle = cursor.getString(titleColumnIndex);
                String currentNote = cursor.getString(noteColumnIndex);

                // Display the values from each column of the current row in the cursor in the
                // TextView.
                displayView.append(("\n" + currentID + "\n" +
                        currentTitle + "\n" +
                        currentNote + "\n"));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    private void insertNote() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where the column names are they keys, and the note's
        // content the values.
        ContentValues values = new ContentValues();
        values.put(NoteContract.NoteEntry.COLUMN_TITLE, "Sonnet 18");
        values.put(NoteContract.NoteEntry.COLUMN_NOTE, "Shall I compare thee to a summer’s day?\n" +
                        "Thou art more lovely and more temperate\n" +
                        "Rough winds do shake the darling buds of May,\n" +
                        "And summer’s lease hath all too short a date\n" +
                        "Sometime too hot the eye of heaven shines,\n" +
                        "And often is his gold complexion dimm’d;\n" +
                        "And every fair from fair sometime declines,\n" +
                        "By chance or nature’s changing course untrimm’d;\n" +
                        "But thy eternal summer shall not fade\n" +
                        "Nor lose possession of that fair thou owest;\n" +
                        "Nor shall Death brag thou wander’st in his shade,\n" +
                        "When in eternal lines to time thou growest:\n" +
                        "So long as men can breathe or eyes can see,\n" +
                "So long lives this, and this gives life to thee.\n");

         // Insert a new row for Sonnet 18 in the database, returning the ID of that new row.
        // The first argument for db.insert() is the notes table name.
        // The second argument provides the name of a column in which the framework can insert
        // NULL in the event that the ContentValues is empty (if this is set to "null", then the
        // framework will not insert a row when there are no values).
        // The third argument is the ContentValues object containing the info for Sonnet 18.
        long newRowId = db.insert(NoteContract.NoteEntry.TABLE_NAME, null, values);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xml file.
        // This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the action bar
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertNote();
                displayDatabaseInfo();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_notes:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
