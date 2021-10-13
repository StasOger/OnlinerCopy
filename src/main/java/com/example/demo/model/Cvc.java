package com.example.demo.model;

public class Cvc  {
    private int block1;

    public Cvc(int block1) {
        this.block1 = block1;
    }
    public Cvc() {
    }

    public int getBlock1() {
        return block1;
    }

    public void setBlock1(int block1) {
        this.block1 = block1;
    }


    @Override
    public String toString() {
        return "CVC{" + block1 + '}';
    }
}
