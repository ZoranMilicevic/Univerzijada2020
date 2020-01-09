package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.R;

public class Request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        final Button requestButton = findViewById(R.id.sendRequest);
        requestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText reasonField = (EditText) findViewById(R.id.reason);
                String reason = reasonField.getText().toString();

                if (reason.equals("")) {
                    Toast.makeText(getApplicationContext(), "Greska: Polje razlog ne sme biti prazno!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Uspeh: Zahtev uspesno poslat!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Request.this, MainPage.class);
                    startActivity(intent);
                }
            }
        });

    }
}
