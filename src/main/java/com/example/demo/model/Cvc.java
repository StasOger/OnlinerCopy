package com.example.demo.model;

public class Cvc  {
    private int block1;
    private int block2;

    public Cvc() {
    }

    @Override
    public String toString() {
        return "Cvc{" +
                "block1=" + block1 +
                ", block2=" + block2 +
                '}';
    }

    public int getBlock1() {
        return block1;
    }

    public void setBlock1(int block1) {
        this.block1 = block1;
    }

    public int getBlock2() {
        return block2;
    }

    public void setBlock2(int block2) {
        this.block2 = block2;
    }
}
