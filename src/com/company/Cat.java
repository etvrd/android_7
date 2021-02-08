package com.company;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate plate){
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            satiety = true;
            System.out.println("Котеечка покушал и сыт.");
        } else {
            System.out.println("Нужно досыпать еды!");
        }
    }

    @Override
    public String toString() {
        return "Котейка{" +
                "имя='" + name + '\'' +
                ", аппетит=" + appetite +'}';
    }
}
