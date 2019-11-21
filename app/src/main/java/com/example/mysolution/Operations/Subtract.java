package com.example.mysolution.Operations;

public class Subtract implements Operation {
    @Override
    public int eval(int x, int y) {
        return (x-y);
    }
    @Override
    public String symbol() {
        return "-";
    }
}
