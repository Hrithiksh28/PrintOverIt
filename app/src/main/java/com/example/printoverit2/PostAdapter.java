package com.example.printoverit2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.printoverit2.Model.Reminders;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PostAdapter extends FirebaseRecyclerAdapter<Reminders, PostAdapter.PostViewHolder> {

    public PostAdapter(@NonNull FirebaseRecyclerOptions<Reminders> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull Reminders model) {

        holder.reminderText.setText(model.getReminderText());
        holder.time.setText(model.getTime());
        holder.date.setText(model.getDate());

    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder, parent, false);

        return new PostViewHolder(view);
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView reminderText, time, date;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            reminderText = itemView.findViewById(R.id.reminderText);
            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
