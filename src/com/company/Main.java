package com.company;

import java.util.Random;

public class Main {

    private Costermonger costermonger;
    private City city;

    private int distance;
    private int speed=3;
    private int dayNumber=0;

    public Main(Costermonger costermonger) {
        this.costermonger=costermonger;
    }

    void startProgram() {

        costermonger.loadingCart();
        costermonger.print();
        System.out.println();
        System.out.println("|============================================================================|");
        initCity();
        initKm();

        while (distance > 0) {
            oneDay();
        }


        System.out.println("The program has performed the action!");
    }

    private void initCity() {
        Random random=new Random();
        int initCity=random.nextInt(7);
        if (initCity == 0) {
            this.city=City.BISHKEK;
            System.out.println("The action begins in Bishkek!");
        } else if (initCity == 1) {
            this.city=City.KANT;
            System.out.println("The action begins in Kant!");
        } else if (initCity == 2) {
            this.city=City.TOKMOK;
            System.out.println("The action begins in Tokmok!");
        } else if (initCity == 3) {
            this.city=City.KEMIN;
            System.out.println("The action begins in Kemin!");
        } else if (initCity == 4) {
            this.city=City.BALYKCHY;
            System.out.println("The action begins in Balykchy!");
        } else if (initCity == 5) {
            this.city=City.CHOLPON_ATA;
            System.out.println("The action begins in Cholpon-Ata!");
        } else {
            this.city=City.KARAKOL;
            System.out.println("The action begins in Karakol!");
        }
    }

    void initKm() {
        Random random=new Random();
        this.distance=random.nextInt(50) + 51;
        System.out.println("The distance between the cities is... " + distance);
    }

    private void oneDay() {
        Random random=new Random();
        int randomEvent=random.nextInt(8);
        Action action;
        if (randomEvent == 0) {
            action=Action.RAIN;
            System.out.println("It's raining. I'm going slowly(((  " + distance);
            distance=distance - (speed - 2);

            if (random.nextInt(2) == 0) {

                int rndProduct=random.nextInt(8);

                Assortment ruined;

                if (rndProduct == 0) {
                    ruined=Assortment.MEAT;
                    costermonger.downQuality(ruined);
                } else if (rndProduct == 1) {
                    ruined=Assortment.DRIED_FRUITS;
                    costermonger.downQuality(ruined);
                } else if (rndProduct == 2) {
                    ruined=Assortment.SEED;
                    costermonger.downQuality(ruined);
                } else if (rndProduct == 3) {
                    ruined=Assortment.FLOUR;
                    costermonger.downQuality(ruined);
                } else if (rndProduct == 4) {
                    ruined=Assortment.FABRICS;
                    costermonger.downQuality(ruined);
                } else {
                    ruined=Assortment.PAINT;
                    costermonger.downQuality(ruined);
                }
            }

        } else if (randomEvent == 1) {
            action=Action.ORDINARY_DAY;
            System.out.println("An ordinary day.  Nothing unusual happened. " + distance);
            distance=distance - speed;
        } else if (randomEvent == 2) {
            action=Action.GOOD_ROAD;
            System.out.println("I was driving on a flat road. The speed has increased! " + distance);
            distance=distance - (speed + 2);
        } else if (randomEvent == 3) {
            action=Action.A_WHEEL_BROKE;
            System.out.println("A wheel broke. I spent the whole day on repairs. " + distance);
        } else if (randomEvent == 4) {
            action=Action.RIVER;
            System.out.println("I met a river on the way. While I was looking for a ford, I wasted a day((( " + distance);
        } else if (randomEvent == 5) {
            action=Action.LOCAL_RESIDENT;
            int km=random.nextInt(3) + 4;
            distance=distance - (speed + km);
            System.out.println("I met a local resident. Took a shortcut to..." + distance);
        } else if (randomEvent == 6) {
            action=Action.HIGHWAYMEN;
        }
        System.out.println("|============================================================================|");
    }


    public static void main(String[] args) {

        Costermonger costermonger=new Costermonger();
        Main main=new Main(costermonger);

        main.startProgram();


    }
}
