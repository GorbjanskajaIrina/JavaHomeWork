package com.pb.gorbjanskaja.hw7;

public class Atelier {
    public static void main(String[] args) {
        Tshirt tshirt = new Tshirt(Size.XXS, 45, "red");
        Pants pants = new Pants(Size.M, 50, "brown");
        Skirt skirt = new Skirt(Size.XS, 200, "green");
        Tie tie = new Tie(Size.L, 150, "blue");

        Clothes[] clothes = new Clothes[]{tshirt, pants, skirt, tie};
        dressMan(clothes);
        dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда: ");
        for (Clothes clothe : clothes) {
            if (clothe instanceof ManClothes) {
                ((ManClothes) clothe).dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        System.out.println("Женская одежда: ");
        for (Clothes clothe : clothes) {
            if (clothe instanceof WomenClothes) {
                WomenClothes womenClothes = (WomenClothes) clothe;
                womenClothes.dressWomen();
            }
        }
    }

}


