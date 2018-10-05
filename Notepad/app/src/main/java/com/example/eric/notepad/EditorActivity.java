package com.example.eric.notepad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eric.notepad.data.NoteContract;
import com.example.eric.notepad.data.NoteDbHelper;

/**
 *  Allows user to create a new note or edit an existing one.
 */
public class EditorActivity extends AppCompatActivity {

    // EditText field to enter the note's title
    private EditText mTitleEditText;
    // EditText field to enter the note's body
    private EditText mNoteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find relevant views that user input will be read from
        mTitleEditText = (EditText) findViewById(R.id.title);
        mNoteEditText = (EditText) findViewById(R.id.note);
    }

    /**
     * Get user input from editor and save a new note into the database.
     */
    private void insertNote() {
        // Read from input fields
        String titleString = mTitleEditText.getText().toString();
        String noteString = mNoteEditText.getText().toString();

        // Create database helper
        NoteDbHelper mDbHelper = new NoteDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where the column names are they keys, and the note's
        // content the values.
        ContentValues values = new ContentValues();
        values.put(NoteContract.NoteEntry.COLUMN_TITLE, titleString);
        values.put(NoteContract.NoteEntry.COLUMN_NOTE, noteString);

        // Insert a new row for a note in the database, returning the ID of that new row.
        long newRowId = db.insert(NoteContract.NoteEntry.TABLE_NAME, null, values);
        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving note", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Note saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save note to database
                insertNote();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
