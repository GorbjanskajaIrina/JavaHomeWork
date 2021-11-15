package com.pb.gorbjanskaja.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes{
    public Pants (Size size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void dressMan() {
        System.out.println("Мужcкие штаны, " + size.getEuroSize()+" " + size.getDescription() +
                ", цена- " + getPrice() + ", цвет- " + getColor());
    }
    @Override
    public void dressWomen() {
        System.out.println("Женские штаны, " + size.getEuroSize()+" " + size.getDescription() +
                ", цена- " + getPrice() + ", цвет- " + getColor());
    }

}
