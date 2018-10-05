package com.example.eric.notepad.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.eric.notepad.data.NoteContract.NoteEntry.*;

/**
 * Database helper for the Notepad app. Manages database creation and version management.
 */
public class NoteDbHelper extends SQLiteOpenHelper {

    // Name of the database file
    private static final String DATABASE_NAME = "user_notes.db";

    // Database version. If you change database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link NoteDbHelper}.
     * @param context of the app
     */
    public NoteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This method is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create a string that contains the SQL statement to create the notes table
        String SQL_CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " TEXT, "
                + COLUMN_NOTE + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_NOTES_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1.0, so there is nothing to do here
    }
}
