package com.jetbrains;

public class MyFloat {
    private long mantissa, exponent;
    private long myInteger, myFraction;
    private long maxExponent, minExponent;
    public MyFloat(long mantissa, long exponent) {
        this.exponent = exponent;
        this.mantissa = mantissa;
        this.myInteger = (long)(this.mantissa / Math.pow(10, this.exponent));
        this.myFraction = (long)(this.mantissa % Math.pow(10, this.exponent));
    }
    public void sum(MyFloat b) {
        long resultFraction = 0;
        long resultInteger = 0;
        int k = 0;
        if (this.exponent <= b.exponent) {
            maxExponent = b.exponent;
            minExponent = this.exponent;
            myFraction *= (long)(Math.pow(10, maxExponent - minExponent));
        }
        else {
            maxExponent = this.exponent;
            minExponent = b.exponent;
            b.myFraction *= (long)(Math.pow(10, maxExponent - minExponent));
        }
        resultFraction += myFraction + b.myFraction;
        for (long i = resultFraction ; i < (long)(Math.pow(10, maxExponent - 1)) ; i *= 10) {
            k += 1;
        }
        if (resultFraction >= Math.pow(10,maxExponent)) {
            resultInteger += 1;
        }
        resultInteger += myInteger + b.myInteger;
        System.out.print(resultInteger + ".");
        for (int i = 0; i < k; i++) {
            System.out.print("0");
        }
        System.out.println(resultFraction);
    }
    public void dif(MyFloat b) {
        long resultFraction = 0;
        long resultInteger = 0;
        int c = 0;
        if (this.exponent <= b.exponent) {
            maxExponent = b.exponent;
            minExponent = this.exponent;
            myFraction *= (long)(Math.pow(10, maxExponent - minExponent));
        }
        else {
            maxExponent = this.exponent;
            minExponent = b.exponent;
            b.myFraction *= (long)(Math.pow(10, maxExponent - minExponent));
        }
        if (myInteger >= b.myInteger) {
            if (myFraction >= b.myFraction) {
                resultFraction += (myFraction - b.myFraction);
            }
            else {
                myFraction += (long)(Math.pow(10, maxExponent));
                myInteger -= 1;
                resultFraction += myFraction - b.myFraction;
            }
            resultInteger += myInteger - b.myInteger;
        }
        if (myInteger < b.myInteger) {
            if (myFraction >= b.myFraction) {
                resultFraction += (long)(Math.pow(10, maxExponent)) - (myFraction - b.myFraction);
                resultInteger += myInteger - b.myInteger + 1;
            }
            else {
                resultFraction += b.myFraction - myFraction;
                resultInteger += myInteger - b.myInteger;
            }
        }
        if (resultFraction != 0) {
            for (long i = resultFraction ; i < (long)(Math.pow(10, maxExponent - 1)) ; i *= 10) {
                c += 1;
            }
            System.out.print(resultInteger + ".");
            for (int i = 0; i < c; i++) {
                System.out.print("0");
            }
            System.out.println(resultFraction);
        }
       else {
            System.out.print(resultInteger + "." + resultFraction);
        }
    }
}
