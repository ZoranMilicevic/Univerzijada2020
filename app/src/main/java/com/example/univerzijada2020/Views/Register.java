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

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button registerButton = findViewById(R.id.registerReg);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nameField = (EditText)findViewById(R.id.name);
                String name = nameField.getText().toString();

                EditText surnameField = (EditText)findViewById(R.id.surname);
                String surname = surnameField.getText().toString();

                EditText telephoneField = (EditText)findViewById(R.id.telephone);
                String telephone = surnameField.getText().toString();

                EditText addressField = (EditText)findViewById(R.id.address);
                String address = surnameField.getText().toString();

                EditText usernameField = (EditText)findViewById(R.id.usernameReg);
                String username = usernameField.getText().toString();

                EditText passwordField = (EditText)findViewById(R.id.passwordReg);
                String password = usernameField.getText().toString();

                if(name.equals("") || surname.equals("") || telephone.equals("") || address.equals("") || username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(),"Greska: Niste popunili sva polja!",Toast.LENGTH_SHORT).show();
                }
                else if(User.findUserAndCheckPassword(username, password) > 0){
                    Toast.makeText(getApplicationContext(),"Greska: Korisnik sa unetim korisnickim imenom vec postoji!",Toast.LENGTH_SHORT).show();
                }
                else{
                    User.users.add(new User(name, surname, telephone, address, username, password));
                    Toast.makeText(getApplicationContext(),"Greska: Uspesna registracija!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);
    }
}
