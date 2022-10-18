package com.example.nativeandroidtasks.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nativeandroidtasks.Model.Todos_response;
import com.example.nativeandroidtasks.R;

import java.util.List;

public class ToDo_adapter extends RecyclerView.Adapter<ToDo_adapter.ViewHolder> {
    List<Todos_response> filteredToDoList;

    public ToDo_adapter(List<Todos_response> filteredToDoList) {
        this.filteredToDoList = filteredToDoList;
    }

    @NonNull
    @Override
    public ToDo_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDo_adapter.ViewHolder holder, int position) {

        Todos_response response = filteredToDoList.get(position);
        holder.titleText.setText("title: "+response.title);
        holder.idText.setText("ID: "+String.valueOf(response.id));
        holder.userIdText.setText("UserID: "+String.valueOf(response.userId));

        holder.checkBox.setChecked(response.completed);

    }

    @Override
    public int getItemCount() {
        return filteredToDoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, idText, userIdText;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            userIdText = itemView.findViewById(R.id.userIdText);
            idText = itemView.findViewById(R.id.idText);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
