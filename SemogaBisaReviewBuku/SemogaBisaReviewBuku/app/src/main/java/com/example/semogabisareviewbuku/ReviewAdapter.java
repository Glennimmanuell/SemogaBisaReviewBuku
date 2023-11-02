package com.example.semogabisareviewbuku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ReviewAdapter extends BaseAdapter {
    private Context context;
    private List<Review> reviewList;

    public ReviewAdapter(Context context, List<Review> reviewList) {
        this.context = context;
        this.reviewList = reviewList;
    }

    @Override
    public int getCount() {
        return reviewList.size();
    }

    @Override
    public Object getItem(int position) {
        return reviewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // Jika convertView belum ada, inflate layout item kustom
            convertView = LayoutInflater.from(context).inflate(R.layout.review_item, parent, false);
        }

        // Dapatkan objek Review yang sesuai dengan posisi saat ini
        Review review = reviewList.get(position);

        // Isi tampilan item dengan data dari objek Review
        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView authorTextView = convertView.findViewById(R.id.authorTextView);

        titleTextView.setText(review.getTitle());
        authorTextView.setText("Penulis: " + review.getAuthor());

        return convertView;
    }
}
