package com.example.eric.notepad.data;

import android.provider.BaseColumns;

/**
 * API Contract for the Notepad app.
 */
public final class NoteContract {
        // final so that it cannot be extended. It is just a class for implementing constants

    // To prevent someone from accidentally instantiating the contract class, give it an empty
    // constructor.
    private NoteContract() {}

    /**
     * Inner class that defines the constant values for the notes database table. Each entry in the
     * table represents a single note.
     */
    public static final class NoteEntry implements BaseColumns {

        //Name of the notes database table
        public final static String TABLE_NAME = "notes";

        // Unique ID number for the note (only for use in the database table).
        // Type: INTEGER PRIMARY KEY AUTOINCREMENT NOT
        public final static String _ID = BaseColumns._ID;

        // Title of the note
        // Type: TEXT
        public final static String COLUMN_TITLE = "title";

        // Body of the note
        //Type: TEXT
        public final static String COLUMN_NOTE =  "note";
    }
}
