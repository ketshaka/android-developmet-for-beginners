package com.example.eric.notepad;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.eric.notepad.data.NoteContract.NoteEntry;

/**
 *  Displays notes that were entered and stored in the app.
 */

public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    // Identifier for the note data loader
    private static final int NOTE_LOADER = 0;

    // Adapter for the ListView
    NoteCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        // Find the ListView which will be populated with the note data
        ListView noteListView = (ListView) findViewById(R.id.list);

        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        //View emptyView = findViewById(R.id.empty_view);
        //noteListView.setEmptyView(emptyView);

        // Setup an Adapter to create a list item for each row of note data in the Cursor.
        // There is no note data yet (until the loader finishes) so pass in null for the Cursor.
        mCursorAdapter = new NoteCursorAdapter(this, null);
        noteListView.setAdapter(mCursorAdapter);

        // Setup the item click listener
        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Create new intent to go to {@link EditorActivity}
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);

                // Form the content URI that represents the specific note that was clicked on,
                // by appending the "id" (passed as input to this method) onto the
                // {@link NoteEntry#CONTENT_URI}.
                // For example, the URI would be "content://com.example.eric.notepad/notes/2"
                // if the note with ID 2 was clicked on.
                Uri currentNoteUri = ContentUris.withAppendedId(NoteEntry.CONTENT_URI, id);

                // Set the URI on the data field of the intent
                intent.setData(currentNoteUri);

                // Launch the {@link EditorActivity} to display the data for the current note.
                startActivity(intent);
            }
        });

        // Start the loader
        getSupportLoaderManager().initLoader(NOTE_LOADER, null, this);
    }

    /**
     * Helper method to insert hardcoded notes data into the database. For debugging purposes only.
     */
    private void insertNote() {

        // Create a ContentValues object where the column names are they keys, and the note's
        // content the values.
        ContentValues values = new ContentValues();
        values.put(NoteEntry.COLUMN_TITLE, "Sonnet 18 x William Shakespeare");
        values.put(NoteEntry.COLUMN_NOTE, "Shall I compare thee to a summer’s day?\n" +
                        "Thou art more lovely and more temperate:\n" +
                        "Rough winds do shake the darling buds of May,\n" +
                        "And summer’s lease hath all too short a date:\n" +
                        "Sometime too hot the eye of heaven shines,\n" +
                        "And often is his gold complexion dimm’d;\n" +
                        "And every fair from fair sometime declines,\n" +
                        "By chance or nature’s changing course untrimm’d;\n" +
                        "But thy eternal summer shall not fade:\n" +
                        "Nor lose possession of that fair thou owest;\n" +
                        "Nor shall Death brag thou wander’st in his shade,\n" +
                        "When in eternal lines to time thou growest:\n" +
                        "So long as men can breathe or eyes can see,\n" +
                "So long lives this, and this gives life to thee.\n");

        // Insert a new row for Sonnet 18 into the provider using the ContentResolver.
        // Use the {@link NoteEntry#CONTENT_URI} to indicate that we want to insert
        // into the notes database table.
        // Receive the new content URI that will allow us to access Sonnet 18 data in the future.
        Uri newUri = getContentResolver().insert(NoteEntry.CONTENT_URI, values);
    }

    /**
     * Helper method to delete all notes in the database.
     */
    private void deleteAllNotes() {
        int rowsDeleted = getContentResolver().delete(NoteEntry.CONTENT_URI, null, null);
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
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_notes:
                deleteAllNotes();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {
                NoteEntry._ID,
                NoteEntry.COLUMN_TITLE,
                NoteEntry.COLUMN_NOTE };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,   // Parent activity context
                NoteEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Update {@link NoteCursorAdapter} with this new cursor containing updated note data
        mCursorAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // Callback called when the data needs to be deleted
        mCursorAdapter.swapCursor(null);
    }
}
