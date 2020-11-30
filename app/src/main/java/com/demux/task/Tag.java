package com.demux.task;

public class Tag {
    String type, text;
    Tag(String type, String text){
        this.type = type;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }
}
