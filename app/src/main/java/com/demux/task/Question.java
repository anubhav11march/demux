package com.demux.task;

import java.util.ArrayList;

public class Question {
    String name;
    ArrayList<Tag> tags;
    int frequency;
    String tag;

    Question(String name, ArrayList<Tag> tags, int frequency, String tag){
        this.frequency = frequency;
        this.name = name;
        this.tags = tags;
        this.tag = tag;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getName() {
        return name;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}
