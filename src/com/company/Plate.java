package com.company;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int n) {
        if (food - n < 0) {
            System.out.println("В миски не может остаться отрицательного количества еды");
            return false;
        }
        food = food - n;
        return true;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void increaseFood(int n) {
        food+=n;
    }
}
