package com.pb.gorbjanskaja.hw7;

public class Tie extends Clothes implements ManClothes {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

        public void dressMan() {
            System.out.println("Мужcкой галстук, " + size.getEuroSize()+" " + size.getDescription() +
                    ", цена- " + getPrice() + ", цвет- " + getColor());
    }
}
