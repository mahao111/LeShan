package com.mahao.leshan.ui.message;

public class Message {
    String title;
    String text;

    public Message(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
