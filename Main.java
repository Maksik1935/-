package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static String num1;
    public static String op;
    public static String num2;
    public static String numTest;
    public static int result;

    public static void main(String[] args) {
        System.out.println("Введите пример: ");
        String Ent1 = scan.nextLine();
        String[] Ent = Ent1.split(" ");
        num1 = Ent[0];
        op = Ent[1];
        num2 = Ent[2];
        numTest = numTest();
        if (Ent.length != 3) {
            throw new NullPointerException();
        }

        int num01;
        int num02;
        if (numTest == "Arab") {
            num01 = Integer.parseInt(num1);
            num02 = Integer.parseInt(num2);
        } else {
            num01 = Integer.parseInt(RomanToArab1());
            num02 = Integer.parseInt(RomanToArab2());
            if ((num02 | num01) == 0) {
                throw new NullPointerException();
            }
        }
        switch (op) {
            case "+":
                result = num01 + num02;
                break;
            case "-":
                result = num01 - num02;
                break;
            case "/":
                result = num01 / num02;
                break;
            case "*":
                result = num01 * num02;
                break;
            default:
                throw new NullPointerException();
        }
        if (numTest == "Arab") {
            System.out.println(result);
        } else {
            if (result < 1) {
                throw new NullPointerException();
            }
            System.out.println(ArabToRoman());
        }

    }
        public static String numTest () {
            int i;
            try {
                i = Integer.parseInt(num1);
                return "Arab";
            } catch (NumberFormatException e) {
                return "Roman";
            }
        }
        private static String ArabToRoman () {
            int[] Aval = {100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] Rval = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder RomanSB = new StringBuilder();
            int num01 = result;
            for (int i = 0; i < Aval.length; i++) {
                while (num01 >= Aval[i]) {
                    num01 -= Aval[i];
                    RomanSB.append(Rval[i]);
                }
            }
            return RomanSB.toString();
        }
        private static String RomanToArab1 () {
            int[] Aval = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            String[] Rval = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
            StringBuilder num01 = new StringBuilder();
            for (int i = 0; i < Rval.length; i++) {
                if (num1.equals(Rval[i])) num01.append(Aval[i]);
            }
                return num01.toString();
        }

        private static String RomanToArab2 () {
            int[] Aval = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            String[] Rval = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
            StringBuilder num02 = new StringBuilder();
            for (int i = 0; i < Rval.length; i++) {
                if (num2.equals(Rval[i])) num02.append(Aval[i]);
            }
            return num02.toString();
        }
}