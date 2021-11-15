package com.pb.gorbjanskaja.hw7;

public enum Size {

    XXS(32,"Детский размер"),
    XS(34,"Взрослый размер"),
    S(36,"Взрослый размер"),
    M(38,"Взрослый размер"),
    L(40,"Взрослый размер");

    private int euroSize;
    private String description;

    Size (int euroSize, String description) {
        this.euroSize = euroSize;
        this.description = description;
    }

    public void setEuroSize(int euroSize) {
        this.euroSize = euroSize;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String getDescription() {
        return description;
    }
}
