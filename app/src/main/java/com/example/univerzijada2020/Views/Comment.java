package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.R;

public class Comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        final Button sendComment = findViewById(R.id.sendComment);
        sendComment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Uspeh: Uspesno ste ostavili ocenu!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Comment.this, AccomodationInfo.class);
                startActivity(intent);
            }
        });

    }
}
