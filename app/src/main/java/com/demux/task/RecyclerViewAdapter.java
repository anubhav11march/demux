package com.demux.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.QuestionsViewHolder> {

    ArrayList<Question> questions;
    RecyclerView rv;
    Context context;

    RecyclerViewAdapter(ArrayList<Question> questions, ArrayList<String> filters, Context context){
        this.questions = questions;
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.questions_card, parent, false);
        return new QuestionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsViewHolder holder, int position) {
        holder.setName(questions.get(position).getName());
        holder.setFreq(questions.get(position).getFrequency());
        holder.setRecyclerView(questions.get(position).getTags());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class QuestionsViewHolder extends RecyclerView.ViewHolder{
        View mView;
        TextView nameT, count;
        RecyclerView tagsR;

        QuestionsViewHolder(View mView){
            super(mView);
            this.mView = mView;
        }

        void setName(String name){
            nameT = mView.findViewById(R.id.name);
            nameT.setText(name);
        }

        void setFreq(int freq){
            count = mView.findViewById(R.id.count);
            count.setText(freq+"");
        }

        void setRecyclerView(ArrayList<Tag> tt){
            tagsR = mView.findViewById(R.id.tags);
            tagsR.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            tagsR.setAdapter(new HorizontalRecyclerViewAdapter(tt));
        }


    }

    class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TagViewHolder>{

        ArrayList<Tag> tagsList;

        HorizontalRecyclerViewAdapter(ArrayList<Tag> tagsList){
            this.tagsList = tagsList;
        }

        @NonNull
        @Override
        public RecyclerViewAdapter.TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tag, parent, false);
            return new TagViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewAdapter.TagViewHolder holder, int position) {
            holder.setText(tagsList.get(position).getText());
            if(tagsList.get(position).getType().equals("difficulty"))
                holder.setDifficulty(tagsList.get(position).getText());
            else if(tagsList.get(position).getType().equals("company"))
                holder.setCompany(tagsList.get(position).getText());
            else if(tagsList.get(position).getType().equals("type"))
                holder.setType(tagsList.get(position).getText());
            else if(tagsList.get(position).getType().equals("topic"))
                holder.setTopic(tagsList.get(position).getText());
        }

        @Override
        public int getItemCount() {
            return tagsList.size();
        }
    }

    class TagViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView tagText;
        LinearLayout tagBg;

        TagViewHolder(View view){
            super(view);
            this.view = view;
            tagText = view.findViewById(R.id.tag_text);
            tagBg = view.findViewById(R.id.tag_bg);
        }

        void setText(String text){
            tagText.setText(text);
        }

        void setDifficulty(String diff){
            tagText.setTextColor(context.getResources().getColor(R.color.white));
            if(diff.equals("Easy"))
                tagBg.setBackground(context.getDrawable(R.drawable.easy_button));
            else if(diff.equals("Medium"))
                tagBg.setBackground(context.getDrawable(R.drawable.medium_buttton));
            else if(diff.equals("Hard"))
                tagBg.setBackground(context.getDrawable(R.drawable.hard_button));
        }

        void setCompany(String co){
            tagText.setTextColor(context.getResources().getColor(R.color.company));
            tagBg.setBackground(context.getDrawable(R.drawable.uniform_button));
        }

        void setTopic(String co){
            tagText.setTextColor(context.getResources().getColor(R.color.topic));
            tagBg.setBackground(context.getDrawable(R.drawable.topic_button));
        }

        void setType(String co){
            tagText.setTextColor(context.getResources().getColor(R.color.type));
            tagBg.setBackground(context.getDrawable(R.drawable.type_button));
        }
    }
}


