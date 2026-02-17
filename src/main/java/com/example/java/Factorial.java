package com.example.java;

public class Factorial {
    
    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("5! = " + calculate(5));
            System.out.println("10! = " + calculate(10));
            System.out.println("0! = " + calculate(0));
            System.out.println("-8! = " + calculate(-8));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
