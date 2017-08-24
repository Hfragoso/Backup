package com.example.w2d3ex03;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.w2d3ex03.FeedReaderContract.FeedEntry;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private DBHelper helper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this);
        database = helper.getWritableDatabase();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // saveRecord();
        readRecord();
        updateRecord();
        readRecord();
        deleteRecord();
        readRecord();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
    }

    private void saveRecord() {
        String title = "Record title";
        String subtitle = "Record subtitle";

        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);

        long recordId = database.insert(
                FeedEntry.TABLE_NAME,
                null,
                values
        );
        if(recordId > 0) {
            Log.d(TAG, "saveRecord: Record saved.");
        } else {
            Log.d(TAG, "saveRecord: Record not saved");
        }
    }

    private void readRecord() {
        String[] projection = {
                FeedEntry._ID,
                FeedEntry.COLUMN_NAME_TITLE,
                FeedEntry.COLUMN_NAME_SUBTITLE
        };
        String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
        String[] selectionArg = {
                "Record title"
        };
        String sortOrder = FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";
        Cursor cursor = database.query(
                FeedEntry.TABLE_NAME,       // TABLE
                projection,                 // Projection
                null,                       // Selection (WHERE)
                null,                       // Values for selection
                null,                       // Group by
                null,                       // Filters
                null                        // Sort order
        );
        while(cursor.moveToNext()) {
            long entryId = cursor.getLong(cursor.getColumnIndexOrThrow(FeedEntry._ID));
            String entryTitle = cursor.getString(cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE));
            String entrySubtitle = cursor.getString(cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE));
            Log.d(TAG, "readRecord: id: " + entryId + " title: " + entryTitle + " subtitle: " + entrySubtitle);
        }
    }

    private void deleteRecord() {
        String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
        String[] selectionArgs = {
                "Record new title"
        };
        int deleted = database.delete(
                FeedEntry.TABLE_NAME,
                selection,
                selectionArgs
        );
        if(deleted > 0) {
            Log.d(TAG, "deleteRecord: record deleted");
        } else {
            Log.d(TAG, "deleteRecord: record not deleted");
        }
    }

    private void updateRecord() {
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, "Record new title");

        String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
        String[] selectionArgs = {
                "Record title"
        };

        int count = database.update(
                FeedEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
        if(count > 0 ) {
            Log.d(TAG, "updateRecord: Updated records " + count);
        } else {
            Log.d(TAG, "updateRecord: Records not updated");
        }

    }

}
