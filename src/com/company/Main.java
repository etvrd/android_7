package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Cat[] cats = new Cat[random.nextInt(10)];
        Plate[] plates = new Plate[cats.length];
        //я решил, что лучше создать массив тарелок по количеству котов, потому что они подерутся
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Барсик "+(i+1), (random.nextInt(15)+1));
            plates[i] = new Plate((random.nextInt(15)+1));
        }
        int food = 0;
        int flag = 0;
        int minFood;
        do{
            int n = 0;
            for (int i = 0; i < cats.length ; i++) {
                if (!cats[i].isSatiety()) {
                    minFood = plates[i].getFood() + food;
                    if (flag == 1 && (minFood - cats[i].getAppetite()) >= 0){
                        //после первого приема пищи разбрасываем еду поэтапно:
                        //все, что осталось - сыпем в миску первому по списку голодному, если ему хватит
                        plates[i].setFood(minFood);
                        food = plates[i].getFood() - cats[i].getAppetite();
                        flag = 3;//метка, что голодному уже насыпали и до следующего круга еды не будет
                    }
                    System.out.println(cats[i]);
                    System.out.println("Еды в тарелке: " + (plates[i].getFood()));
                    cats[i].eat(plates[i]);
                    System.out.println("Осталось корма: "+plates[i].getFood());
                    System.out.println();
                }
                if (cats[i].isSatiety()){
                    n++;
                    if (flag != 1 && flag != 3)
                        food+=plates[i].getFood();
                }
            }
            System.out.println("Количество сытых котов: " + n);
            if (n == cats.length) {
                System.out.println("Все покушали.");
                break;
            }
            if (flag == 1 || food <= 0 || n == 0){
                System.out.println("Еды всем котикам не хватило, останутся голодными.");
                break;
            }
            while (flag != 1 && flag != 2){
                System.out.println("У поевших котов осталось " + food + " еды, рассыпать по тарелочкам " +
                        "голодных? 1 - да, 2 - нет, пускай голодные ходють.");
                Scanner sc = new Scanner(System.in);
                flag = sc.nextInt();
                if (flag == 2)
                    food = 0;
            }
        } while (food > 0);


    }
}
