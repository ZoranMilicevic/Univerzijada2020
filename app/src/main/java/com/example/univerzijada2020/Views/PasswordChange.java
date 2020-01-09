package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.Data.User;
import com.example.univerzijada2020.R;

public class PasswordChange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        final Button passwordChangeButton = findViewById(R.id.passwordChangeButton);
        passwordChangeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText oldPassField = (EditText)findViewById(R.id.oldPass);
                String oldPass = oldPassField.getText().toString();

                EditText newPassField = (EditText)findViewById(R.id.newPass);
                String newPass = oldPassField.getText().toString();

                EditText new2PassField = (EditText)findViewById(R.id.newPass2);
                String new2Pass = oldPassField.getText().toString();

                if(oldPass.equals("") || newPass.equals("") || new2Pass.equals("")){
                    Toast.makeText(getApplicationContext(), "Greska: Niste popunili sva polja!", Toast.LENGTH_LONG).show();
                }
                else if(!newPass.equals(new2Pass)){
                    Toast.makeText(getApplicationContext(), "Greska: Nova lozinka i ponovljena nova lozinka nisu iste!", Toast.LENGTH_LONG).show();
                }
                else{
                    boolean success = User.changePass(oldPass, newPass);
                    if(success){
                        Toast.makeText(getApplicationContext(), "Uspeh: Lozinka je uspesno promenjena!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(PasswordChange.this, MainPage.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Greska: Stara lozinka je netacna!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
