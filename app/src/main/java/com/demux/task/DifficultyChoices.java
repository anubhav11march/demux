package com.demux.task;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class DifficultyChoices extends Fragment {

    ArrayList<String> selections, removals = new ArrayList<>();
    Context context;
    LinearLayout easy, medium, hard, apply;

    DifficultyChoices(ArrayList<String> selections, Context context){
        this.selections = selections;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.difficulty, container, false);
        easy = view.findViewById(R.id.easy);
        medium = view.findViewById(R.id.medium);
        hard = view.findViewById(R.id.hard);
        apply = view.findViewById(R.id.apply);
        for(int i=0; i<selections.size(); i++){
            if(selections.contains("Easy"))
                easy.setBackground(context.getDrawable(R.drawable.selected_button));
            if(selections.contains("Medium"))
                medium.setBackground(context.getDrawable(R.drawable.selected_button));
            if(selections.contains("Hard"))
                hard.setBackground(context.getDrawable(R.drawable.selected_button));
        }

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selections.contains("Easy")) {
                    selections.remove("Easy");
                    removals.add("Easy");
                    easy.setBackground(context.getDrawable(R.drawable.uniform_button));
                }
                else {
                    selections.add("Easy");
                    if(removals.contains("Easy"))
                        removals.remove("Easy");
                    easy.setBackground(context.getDrawable(R.drawable.selected_button));
                }
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selections.contains("Medium")) {
                    selections.remove("Medium");
                    removals.add("Medium");
                    medium.setBackground(context.getDrawable(R.drawable.uniform_button));
                }
                else{
                    selections.add("Medium");
                    if(removals.contains("Medium"))
                    removals.remove("Medium");
                    medium.setBackground(context.getDrawable(R.drawable.selected_button));
                }
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selections.contains("Hard")) {
                    selections.remove("Hard");
                    removals.add("Hard");
                    hard.setBackground(context.getDrawable(R.drawable.uniform_button));
                }
                else {
                    selections.add("Hard");
                    if(removals.contains("Hard"))
                    removals.remove("Hard");
                    hard.setBackground(context.getDrawable(R.drawable.selected_button));
                }
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity2) context).modifyFilter(selections, removals);
            }
        });

        return view;
    }
}
