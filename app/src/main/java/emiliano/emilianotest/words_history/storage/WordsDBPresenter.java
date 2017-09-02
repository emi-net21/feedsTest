package emiliano.emilianotest.words_history.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class WordsDBPresenter {

    private WordsDbHelper mDbHelper;

    public WordsDBPresenter(Context context) {
        this.mDbHelper = new WordsDbHelper(context);
    }

    public void addWord(String word) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(WordContract.WordEntry.COLUMN_NAME_TITLE, word);

        // Insert the new row, returning the primary key value of the new row
        db.insert(WordContract.WordEntry.TABLE_NAME, null, values);
    }

    public List<String> getWordsHistory() {
        List<String> result = new ArrayList<>();

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                WordContract.WordEntry.COLUMN_NAME_TITLE
        };

        // How you want the results sorted in the resulting Cursor
        Cursor cursor = db.query(
                WordContract.WordEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                result.add(cursor.getString(cursor.getColumnIndex(WordContract.WordEntry.COLUMN_NAME_TITLE)));
                cursor.moveToNext();
            }
        }
        return result;
    }
}
