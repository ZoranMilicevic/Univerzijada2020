package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.Data.Likes;
import com.example.univerzijada2020.R;

public class Kalemegdan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalemegdan);

        final Button likeBtn = findViewById(R.id.likeBtn);
        likeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Likes.addLike("Kalemegdan");
                Toast.makeText(getApplicationContext(), "Liked!", Toast.LENGTH_SHORT).show();
            }
        });

        final ImageView mainImage = findViewById(R.id.mainField);
        mainImage.setBackgroundResource(R.drawable.kale1);

        final ImageView kale1Pic = findViewById(R.id.kale1Pic);
        kale1Pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainImage.setBackgroundResource(R.drawable.kale1);
            }
        });

        final ImageView kale2Pic = findViewById(R.id.kale2Pic);
        kale2Pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainImage.setBackgroundResource(R.drawable.kale2);
            }
        });

        final ImageView kale3Pic = findViewById(R.id.kale3Pic);
        kale3Pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainImage.setBackgroundResource(R.drawable.kale3);
            }
        });

        final ImageView kale4Pic = findViewById(R.id.kale4Pic);
        kale4Pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainImage.setBackgroundResource(R.drawable.kale4);
            }
        });

        final ImageView kale5Pic = findViewById(R.id.kale5Pic);
        kale5Pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainImage.setBackgroundResource(R.drawable.kale5);
            }
        });

        final ImageView kale6Pic = findViewById(R.id.kale6Pic);
        kale6Pic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mainImage.setBackgroundResource(R.drawable.kale6);
            }
        });

    }
}
