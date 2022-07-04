package com.company;

public class Product {

    Assortment type;
    private int weight=0;
    private int cost;
    private double quality=1.2;

    public Product(Assortment type) {
        this.type=type;
        if (type == Assortment.MEAT) {
            cost=450;
        } else if (type == Assortment.DRIED_FRUITS) {
            cost=150;
        } else if (type == Assortment.SEED) {
            cost=20;
        } else if (type == Assortment.PAINT) {
            cost=500;
        } else if (type == Assortment.FABRICS) {
            cost=250;
        } else {
            cost=25;
        }


    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality=quality;
    }

    public Assortment getType() {
        return type;
    }

    public void setType(Assortment type) {
        this.type=type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight=weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost=cost;
    }
}
