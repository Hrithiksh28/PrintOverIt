package com.example.printoverit2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.printoverit2.Model.User;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class registerActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;
    private FirebaseAuth mAuth;
    private EditText name, emailId, password;
    private Button register, previousScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        mAuth = FirebaseAuth.getInstance();

        name = findViewById(R.id.txtRegisterName);
        emailId = findViewById(R.id.txtRegisterEmailId);
        password = findViewById(R.id.txtRegisterPassword);

        register = findViewById(R.id.btnRegister);
        previousScreen = findViewById(R.id.btnGoBack);

        previousScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registerActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final User user= new User(name.getText().toString(),
                        emailId.getText().toString(),
                        password.getText().toString());
                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(user.getEmailId()).exists())
                            Toast.makeText(registerActivity.this, "Username Exists", Toast.LENGTH_SHORT).show();
                        else {
                            users.child(user.getEmailId()).setValue(user);
                            Toast.makeText(registerActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(registerActivity.this, loginActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

}