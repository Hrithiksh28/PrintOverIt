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

public class loginActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;
    private EditText emailId, password;
    private Button login, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        emailId = findViewById(R.id.txtRegisterEmailId);
        password = findViewById(R.id.txtRegisterPassword);

        signUp = findViewById(R.id.btnSignUp);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(emailId.getText().toString(), password.getText().toString());
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), registerActivity.class);
                startActivity(intent);
            }
        });
    }
    private void signIn (final String Email, final String Password){
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(Email).exists()){
                    User login = dataSnapshot.child(Email).getValue(User.class);
                    if(login.getPassword().equals(Password)){
                        String name =login.getName();
                        Toast.makeText(loginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(loginActivity.this, MainActivity.class);

                        Bundle extras = new Bundle();
                        extras.putString("EmailId", login.getEmailId());
                        extras.putString("Name", name);
                        intent.putExtras(extras);

                        startActivity(intent);
                    }
                    else
                        Toast.makeText(loginActivity.this, "Password is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(loginActivity.this, "User is not Registered", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}