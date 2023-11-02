package com.example.semogabisareviewbuku;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;
import java.util.ArrayList;

public class ReviewListActivity extends AppCompatActivity {
    private ListView reviewListView;
    private Button addButton;
    private String username;
    private List<Review> reviewList;
    private ReviewAdapter reviewAdapter;
    private DatabaseHelper dbHelper; // Tambahkan ini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        username = getIntent().getStringExtra("username");

        reviewListView = findViewById(R.id.reviewListView);
        addButton = findViewById(R.id.addButton);

        dbHelper = new DatabaseHelper(ReviewListActivity.this);

        reviewList = dbHelper.readAllData();
        reviewAdapter = new ReviewAdapter(this, reviewList);
        reviewListView.setAdapter(reviewAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewListActivity.this, AddReviewActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        reviewList = dbHelper.readAllData();
        reviewAdapter = new ReviewAdapter(this, reviewList);
        reviewListView.setAdapter(reviewAdapter);
    }
}
