package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.Data.Likes;
import com.example.univerzijada2020.R;
import org.w3c.dom.Text;

public class TouristInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_info);

        int kaleLikes = Likes.getLikes("Kalemegdan");
        int adaLikes = Likes.getLikes("Ada Ciganlija");
        int hramLikes = Likes.getLikes("Hram Svetog Save");

        TextView kaleField = (TextView) findViewById(R.id.kalemegdanLikes);
        kaleField.setText(Integer.toString(kaleLikes));

        TextView adaField = (TextView) findViewById(R.id.adaLikes);
        adaField.setText(Integer.toString(adaLikes));

        TextView hramField = (TextView) findViewById(R.id.hramLikes);
        hramField.setText(Integer.toString(hramLikes));

        final Button kaleBtn = findViewById(R.id.kalemegdanBtn);
        kaleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TouristInfo.this, Kalemegdan.class);
                startActivity(intent);
            }
        });

        final Button adaBtn = findViewById(R.id.adaBtn);
        adaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        final Button hramBtn = findViewById(R.id.hramBtn);
        hramBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

    }
}
