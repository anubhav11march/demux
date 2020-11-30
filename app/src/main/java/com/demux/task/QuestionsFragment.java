package com.demux.task;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionsFragment extends Fragment {

    ArrayList<Question> questions;
    RecyclerView rv;
    Context context;

    QuestionsFragment(ArrayList<Question> questions, ArrayList<String> filters, Context context){
        this.questions = questions;
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        rv = view.findViewById(R.id.all_questions);
        rv.setLayoutManager(new LinearLayoutManager(context));
        inflateRecyclerView();
        return view;
    }

    void inflateRecyclerView(){
        rv.setAdapter(new RecyclerViewAdapter(questions, new ArrayList<>(), context));
    }





}
