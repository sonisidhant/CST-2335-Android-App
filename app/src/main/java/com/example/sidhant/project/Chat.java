package com.example.sidhant.project;

public class Chat {
    private String message;
    private String calories;
    private String fat;
    private String carbohydates;
    private long _id;

    public Chat(String message, String calor, String f, String carbo,long id) {
        this.message = message;
        this.calories = calor;
        this.fat = f;
        this.carbohydates = carbo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calorie) {
        this.calories = calorie;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fa) {
        this.fat = fa;
    }

    public String getCarbohydates() {
        return carbohydates;
    }

    public void setCarbohydates(String Carbohydates) {
        this.carbohydates = Carbohydates;
    }
    public long get_id() {return _id;}

    public void set_id(long _id) {this._id = _id;}
}