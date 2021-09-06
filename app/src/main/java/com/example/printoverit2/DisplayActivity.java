package com.example.printoverit2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.printoverit2.Model.Reminders;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class DisplayActivity extends AppCompatActivity {

    TextView titleText, timeText, dateText;
    DatabaseReference ref, database;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        titleText = findViewById(R.id.titleText);
        timeText = findViewById(R.id.timeText);
        dateText = findViewById(R.id.dateText);

        database = FirebaseDatabase.getInstance().getReference();
        ref = database.child("Reminders");

    }


}