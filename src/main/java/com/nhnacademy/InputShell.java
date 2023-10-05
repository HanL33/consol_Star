package com.nhnacademy;

import java.util.Scanner;

public class InputShell {
    static Scanner sc = new Scanner(System.in);

    public static int inputFromShell(){
        int value = sc.nextInt();
        return value;
    }

    public static void ScannerClose(){
        sc.close();
    }
}
