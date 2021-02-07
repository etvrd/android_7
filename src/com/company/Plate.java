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

    public void decreaseFood(int n) {
        if (n > food)
            System.out.println("В тарелке не хвататает еды, досыпь еще " + (n-food));
        else
            food-=n;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void increaseFood(int n) {
        food+=n;
    }
}
