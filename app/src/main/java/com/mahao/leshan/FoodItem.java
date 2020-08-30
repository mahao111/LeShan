package com.mahao.leshan;

public class FoodItem {
    private String title_food;
    private  String subtitle_food;
    private  int  imageRes;

    public FoodItem(String title_food, String subtitle_food, int imageRes) {
        this.title_food = title_food;
        this.subtitle_food = subtitle_food;
        this.imageRes = imageRes;
    }

    public String getTitle_food() {
        return title_food;
    }

    public String getSubtitle_food() {
        return subtitle_food;
    }

    public int getImageRes() {
        return imageRes;
    }
}
