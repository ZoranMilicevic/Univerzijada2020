package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.Data.User;
import com.example.univerzijada2020.R;

public class UserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        EditText nameField = (EditText)findViewById(R.id.nameInfo);
        nameField.setText(User.currentUser.getName(), TextView.BufferType.EDITABLE);

        EditText surnameField = (EditText)findViewById(R.id.surnameInfo);
        surnameField.setText(User.currentUser.getSurname(), TextView.BufferType.EDITABLE);

        EditText telephoneField = (EditText)findViewById(R.id.telephoneInfo);
        telephoneField.setText(User.currentUser.getTelephone(), TextView.BufferType.EDITABLE);

        EditText addressField = (EditText)findViewById(R.id.addressInfo);
        addressField.setText(User.currentUser.getAddress(), TextView.BufferType.EDITABLE);

        final Button infoButton = findViewById(R.id.updateInfo);
        infoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nameField = (EditText)findViewById(R.id.nameInfo);
                String name = nameField.getText().toString();

                EditText surnameField = (EditText)findViewById(R.id.surnameInfo);
                String surname = surnameField.getText().toString();

                EditText telephoneField = (EditText)findViewById(R.id.telephoneInfo);
                String telephone = surnameField.getText().toString();

                EditText addressField = (EditText)findViewById(R.id.addressInfo);
                String address = surnameField.getText().toString();

                boolean success = User.updateUserInfo(name, surname, telephone, address);

                if(success){
                    Toast.makeText(getApplicationContext(),"Uspeh: Informacije su uspesno azurirane!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserInfo.this, MainPage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Greska: Informacije nisu uspesno azurirane!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
