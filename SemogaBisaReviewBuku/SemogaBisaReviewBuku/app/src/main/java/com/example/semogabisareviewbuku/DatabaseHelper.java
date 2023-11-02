package com.example.semogabisareviewbuku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "ReviewLibrary.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_REVIEWS = "reviews";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_REVIEW = "review";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_REVIEWS +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_REVIEW + " TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REVIEWS);
        onCreate(db);
    }

    public void addReview(String title, String author, String review) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, title);
        values.put(COLUMN_TITLE, author);
        values.put(COLUMN_AUTHOR, review);
        long result = db.insert(TABLE_REVIEWS, null, values);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<Review> readAllData(){
        String query = "SELECT * FROM " + TABLE_REVIEWS;
        SQLiteDatabase db = this.getReadableDatabase();
         ArrayList<Review> reviewList = new ArrayList<Review>();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }

        if (cursor != null && cursor.moveToFirst()) {
            int usernameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_USERNAME);
            int titleIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE);
            int authorIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_AUTHOR);
            int reviewIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_REVIEW);

            do {
                String title = cursor.getString(titleIndex);
                String author = cursor.getString(authorIndex);
                String reviewText = cursor.getString(reviewIndex);
                String username = cursor.getString(usernameIndex);
                Review review = new Review(username, title, author, reviewText);
                reviewList.add(review);
            } while (cursor.moveToNext());
            cursor.close();
            return reviewList;

        }
        return null;
    }
}
