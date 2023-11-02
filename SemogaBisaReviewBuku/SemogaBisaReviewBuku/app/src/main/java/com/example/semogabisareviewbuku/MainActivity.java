package com.example.semogabisareviewbuku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.semogabisareviewbuku.ReviewListActivity;

public class MainActivity extends AppCompatActivity {
    private EditText usernameInput;
    private Button beginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.usernameInput);
        beginButton = findViewById(R.id.beginButton);

        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();

                if (!username.isEmpty()) {
                    // Jika input username tidak kosong, lanjutkan ke aktivitas berikutnya
                    Intent intent = new Intent(MainActivity.this, ReviewListActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    // Tampilkan pesan kesalahan jika input kosong
                    usernameInput.setError("Username tidak boleh kosong.");
                }
            }
        });
    }
}
