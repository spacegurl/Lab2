package com.example.lab2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.domain.entity.ProjectListItem;

import java.util.List;

public class ProjectListRecyclerViewAdapter extends RecyclerView.Adapter<ProjectListRecyclerViewAdapter.ViewHolder> {

    private final List<ProjectListItem> projectListItems;
    private final LayoutInflater inflater;

    public ProjectListRecyclerViewAdapter(Context context, List<ProjectListItem> projectListItems) {
        this.projectListItems = projectListItems;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // отрисовывает view
        View view = inflater.inflate(R.layout.item_projects_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // заполняет данными
        ProjectListItem item = projectListItems.get(position);
        holder.paintSwatches.setImageResource(item.getId_image());
        holder.projectsText.setText(item.getCompleted_project());
        int temp = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.projectsText.getContext(), "Current project "
                        + (temp + 1) + " is clicked", Toast.LENGTH_SHORT).show();
                Log.d("LIST LOGS", "Log for current project " + (temp + 1) + " is clicked");
            }
        });

    }

    @Override
    public int getItemCount() { // возвращает кол-во элементов списка
        return projectListItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView projectsText;
        final ImageView paintSwatches;

        ViewHolder(View view) {
            super(view);
            projectsText = view.findViewById(R.id.projectstext);
            paintSwatches = view.findViewById(R.id.paint_swatches);
        }
    }
}
