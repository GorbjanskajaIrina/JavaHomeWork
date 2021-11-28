package com.pb.gorbjanskaja.hw10;

public class NumBox<T extends Number> {
    private final T[] arrays;
    int filled;

    public NumBox(int size) {
        arrays = (T[]) new Number[size];
    }

    void add(T num)
    {
        if(this.filled >= this.arrays.length){

        }
        this.arrays[this.filled] = num;
        this.filled++;
    }
    public T get(int index) {
        return arrays[index];
    }
    public int lengthMas() {
        return this.filled;
    }
    public double average() {
        double sum = 0.0;

        for (T value : arrays) {
            if( value!=null)
            sum += value.doubleValue();
        }

        return sum / this.filled;
    }
    public double sum() {
        double sum = 0.0;

        for (T value : arrays) {
            if( value!=null)
            sum += value.doubleValue();
        }
        return sum;
    }

   public double max() {
       double startMax = 0.0;

       for (T value : arrays) {
           if( value!=null && value.doubleValue()>startMax)
               startMax=value.doubleValue();
       }
       return startMax;
   }

    public void set(int size, T array) {
        this.arrays[size] = array;
    }
    public int getSize () {
        return arrays.length;
    }

    }
