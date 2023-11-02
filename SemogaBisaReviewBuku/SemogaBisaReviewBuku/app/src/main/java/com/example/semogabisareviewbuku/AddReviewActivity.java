package com.example.semogabisareviewbuku;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddReviewActivity extends AppCompatActivity {
    private EditText titleInput;
    private EditText authorInput;
    private EditText reviewInput;
    private Button saveButton;
    private Button cancelButton;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        // Mendapatkan username dari Intent
        username = getIntent().getStringExtra("username");

        titleInput = findViewById(R.id.titleInput);
        authorInput = findViewById(R.id.authorInput);
        reviewInput = findViewById(R.id.reviewInput);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String title = titleInput.getText().toString();
//                String author = authorInput.getText().toString();
//                String review = reviewInput.getText().toString();
//
//                if (title.isEmpty() || author.isEmpty() || review.isEmpty()) {
//                    titleInput.setError("Judul harus diisi");
//                    authorInput.setError("Penulis harus diisi");
//                    reviewInput.setError("Review harus diisi");
//                } else {
//                    // Simpan data ke database SQLite
//                    DatabaseHelper dbHelper = new DatabaseHelper(AddReviewActivity.this);
//                    SQLiteDatabase db = dbHelper.getWritableDatabase();
//                    dbHelper.addReview(titleInput.getText().toString().trim(),
//                            authorInput.getText().toString().trim(),
//                            reviewInput.getText().toString().trim());
//
//
//                    ContentValues values = new ContentValues();
//                    values.put(DatabaseHelper.COLUMN_TITLE, title);
//                    values.put(DatabaseHelper.COLUMN_AUTHOR, author);
//                    values.put(DatabaseHelper.COLUMN_REVIEW, review);
//
//                    long newRowId = db.insert(DatabaseHelper.TABLE_REVIEWS, null, values);
//
//                    // Tutup database
//                    db.close();
//
//                    if (newRowId > 0) {
//                        // Data berhasil dimasukkan ke dalam database
//                        // Kembali ke layar sebelumnya
//                        finish();
//                    } else {
//                        // Gagal memasukkan data ke dalam database
//                        // Tampilkan pesan kesalahan atau tindakan yang sesuai
//                        // Misalnya:
//                        Toast.makeText(AddReviewActivity.this, "Gagal menyimpan data.", Toast.LENGTH_SHORT).show();
//                    }
//
//                }
                DatabaseHelper dbHelper = new DatabaseHelper(AddReviewActivity.this);
                dbHelper.addReview(titleInput.getText().toString().trim(),
                            authorInput.getText().toString().trim(),
                            reviewInput.getText().toString().trim());

                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke layar sebelumnya tanpa menyimpan data
                finish();
            }
        });
    }
}
