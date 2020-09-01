package com.mahao.leshan.detial;

public class FoodDetialItem {
    private String tilte;
    private  int imageRes;
    private  String money;
    private String address;
    private  String time;
    private  String phone;

    public FoodDetialItem(String tilte,  String money, String address, String time, String phone,int imageRes) {
        this.tilte = tilte;
        this.imageRes = imageRes;
        this.money = money;
        this.address = address;
        this.time = time;
        this.phone = phone;
    }

    public String getTilte() {
        return tilte;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getMoney() {
        return money;
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return time;
    }

    public String getPhone() {
        return phone;
    }
}


