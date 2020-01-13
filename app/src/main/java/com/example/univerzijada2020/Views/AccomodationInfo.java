package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.R;
import com.google.android.gms.maps.MapView;


public class AccomodationInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation_info);

        final Button comment1btn = findViewById(R.id.comment1);
        comment1btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AccomodationInfo.this, Comment.class);
                startActivity(intent);
            }
        });

        final Button comment2btn = findViewById(R.id.comment2);
        comment2btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AccomodationInfo.this, Comment.class);
                startActivity(intent);
            }
        });

    }

}
