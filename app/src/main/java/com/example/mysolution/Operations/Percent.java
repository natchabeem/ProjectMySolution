package com.example.mysolution.Operations;

public class Percent implements Operation{
    @Override
    public int eval(int x, int y) {
        int r=x%y;
        return  r;
    }

    @Override
    public String symbol() {
        return "%";
    }
}
