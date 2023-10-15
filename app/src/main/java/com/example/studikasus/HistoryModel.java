package com.example.studikasus;

public class HistoryModel {
    int icon;
    String name, date, price;

    public HistoryModel(int icon, String name, String date, String price) {
        this.icon = icon;
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }
}
