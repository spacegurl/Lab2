package com.example.lab2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab2.domain.entity.ArchiveListItem;

import java.util.List;

public class ArchiveListAdapter extends ArrayAdapter<ArchiveListItem> {
    private LayoutInflater inflater;
    private int layout;
    private List<ArchiveListItem> list_items;

    public ArchiveListAdapter(@NonNull Context context, int resource, @NonNull List<ArchiveListItem> objects) {
        super(context, resource, objects);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.list_items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        ImageView imageview = view.findViewById(R.id.cat_on_docs);
        TextView textview = view.findViewById(R.id.archivetext);
        ArchiveListItem item = list_items.get(position);
        imageview.setImageResource(item.getId_image());
        textview.setText(item.getCompleted_project());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Completed project in Archive "
                        + (position + 1) + " is clicked", Toast.LENGTH_SHORT).show();
                Log.d("LIST LOGS", "Log for completed project in Archive "
                        + (position + 1) + " is clicked");
            }
        });

        return view;
    }
}
