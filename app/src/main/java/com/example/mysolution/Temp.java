package com.example.mysolution;

public class Temp {
    private double cel;
    //find cel from other type
    public Temp(double t,String type){
        if(type.equals("F")){
            this.cel = (t-32)*5/9;
        }else if(type.equals("K")){
            this.cel = t-273;
        }else {
            this.cel=t;
        }
    }


    public  double getCel(){

        return Double.parseDouble(String.format("%.2f", this.cel));
    }
    public double getFah(){

        return Double.parseDouble(String.format("%.2f", this.cel * 1.8 + 32));
    }
    public  double getKel(){

        return Double.parseDouble(String.format("%.2f", this.cel +273));
    }

}
