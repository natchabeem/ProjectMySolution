package com.example.mysolution.Operations;

public class Devide implements Operation {
    @Override
    public int eval(int x, int y) {
        if(x<y){
            int t=x;
            x=y;
            y=t;
        }
        if(x%y==0){
            return x/y;
        }else {
            return 0;
        }
    }

    @Override
    public String symbol() {
        return "/";
    }
}
