package com.example.demo.model;

public class Card {
    private int block1;
    private int block2;
    private int block3;
    private int block4;

    public Card(int block1, int block2, int block3, int block4) {
        this.block1 = block1;
        this.block2 = block2;
        this.block3 = block3;
        this.block4 = block4;
    }

    public Card() {
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

    public int getBlock3() {
        return block3;
    }

    public void setBlock3(int block3) {
        this.block3 = block3;
    }

    public int getBlock4() {
        return block4;
    }

    public void setBlock4(int block4) {
        this.block4 = block4;
    }

    @Override
    public String toString() {
        return "Card{" + block1 + block2 + block3 + block4 + '}';
    }
}
