package com.pb.gorbjanskaja.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужcкая футболка, " + size.getEuroSize()+" " + size.getDescription() +
                ", цена- " + getPrice() + ", цвет- " + getColor());
    }
    @Override
    public void dressWomen() {
        System.out.println("Женская футболка, " + size.getEuroSize()+" "  + size.getDescription() +
                ", цена- "+ getPrice() + ", цвет- " + getColor());
    }


}
