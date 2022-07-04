package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Costermonger {

    private int capacity=200;
    private int money=10000;
    private List<Product> products=new ArrayList<>();
    private List<Product> agregatedList=new ArrayList<>();


    public void deleteBestAssortiment() {

        double bestQual=0;
        int tovarNumber=0;

        for (int i=0; i < agregatedList.size(); i++) {
            if (agregatedList.get(i).getQuality() > bestQual) {
                bestQual=agregatedList.get(i).getQuality();
                tovarNumber=i;
            }
            System.out.println(agregatedList.get(tovarNumber));
        }

        agregatedList.remove(tovarNumber);
    }


    public void print() {
        int meatCount=0;
        int driedFruitsCount=0;
        int seedCount=0;
        int floorCount=0;
        int fabricsCount=0;
        int paintCount=0;

        for (Product product : products) {

            if (product.getType() == Assortment.MEAT) {
                meatCount=meatCount + product.getWeight();
            } else if (product.getType() == Assortment.DRIED_FRUITS) {
                driedFruitsCount=driedFruitsCount + product.getWeight();
            } else if (product.getType() == Assortment.SEED) {
                seedCount=seedCount + product.getWeight();
            } else if (product.getType() == Assortment.FLOUR) {
                floorCount=floorCount + product.getWeight();
            } else if (product.getType() == Assortment.FABRICS) {
                fabricsCount=fabricsCount + product.getWeight();
            }
            paintCount=paintCount + product.getWeight();
        }

        System.out.println("|============================================================================|");
        System.out.printf("|  %s   |   %s  |   %s   |   %s   |   %s   |   %s   |", Assortment.MEAT.getValue(), Assortment.DRIED_FRUITS.getValue(),
                Assortment.SEED.getValue(), Assortment.FLOUR.getValue(), Assortment.FABRICS.getValue(), Assortment.PAINT.getValue());
    }

    public void downQuality(Assortment type) {
        for (Product product : agregatedList) {
            if (product.getType() == type) {
                double quality=0;
                if (product.getQuality() == 1.2) {
                    quality=product.getQuality();
                    product.setQuality(0.95);
                    System.out.println("Product quality  " + product.getType() + " worsened " + quality + " before " + product.getQuality());
                } else if (product.getQuality() == 0.95) {
                    product.setQuality(0.55);
                    System.out.println("Product quality  " + product.getType() + " worsened " + quality + " before " + product.getQuality());
                } else if (product.getQuality() == 0.55) {
                    product.setQuality(0.25);
                    System.out.println("Product quality  " + product.getType() + " worsened " + quality + " before " + product.getQuality());
                } else if (product.getQuality() == 0.25) {
                    product.setQuality(0.1);
                    System.out.println("Product quality  " + product.getType() + " worsened " + quality + " before " + product.getQuality());
                } else {
                    System.out.println("Product quality  " + product.getType() + " worsened " + quality + " before " + product.getQuality());
                }

            }
        }
    }

    private Assortment getRndProductType() {
        Random random=new Random();
        int rnd=random.nextInt(6);
        if (rnd == 0) {
            return Assortment.MEAT;
        } else if (rnd == 1) {
            return Assortment.DRIED_FRUITS;
        } else if (rnd == 2) {
            return Assortment.FABRICS;
        } else if (rnd == 3) {
            return Assortment.PAINT;
        } else if (rnd == 4) {
            return Assortment.FLOUR;
        } else {
            return Assortment.SEED;
        }
    }


    void loadingCart() {

        boolean continiue=true;

        while (continiue) {
            Assortment type=getRndProductType();
            Product product=new Product(type);
            Random random=new Random();
            product.setWeight(random.nextInt(6) + 1);
            products.add(product);
            continiue=executeCount(product.getWeight(), product.getCost());
        }

        agregateProducts();
    }

    private void agregateProducts() {

        agregatedList.add(new Product(Assortment.MEAT));
        agregatedList.add(new Product(Assortment.SEED));
        agregatedList.add(new Product(Assortment.DRIED_FRUITS));
        agregatedList.add(new Product(Assortment.FABRICS));
        agregatedList.add(new Product(Assortment.FLOUR));
        agregatedList.add(new Product(Assortment.PAINT));

        for (Product product : products) {

            for (Product aggProduct : agregatedList) {
                if (aggProduct.getType() == product.getType()) {
                    aggProduct.setWeight(aggProduct.getWeight() + product.getWeight());
                    break;
                }
            }
        }
    }

    private boolean executeCount(int productWeight, int productCost) {
        this.capacity=this.capacity - productWeight;
        this.money=this.money - productCost * productWeight;

        if (this.money < 20 || this.capacity < 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Costermonger costermonger=new Costermonger();
        costermonger.deleteBestAssortiment();
    }
}
