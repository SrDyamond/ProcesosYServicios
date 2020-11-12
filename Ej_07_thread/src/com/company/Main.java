package com.company;

import java.util.Scanner;

public class Main {
    // variables introducidas por el usuario
    static int x, y, z;

    public static void main(String[] args) {

        obtenerVariablesEntrada();
        calcularSentencias();

    }

    public static void obtenerVariablesEntrada() {
        Scanner scan = new Scanner(System.in);

        // Se introducen los valores por teclado
        System.out.print("Introduce el valor de x: ");
        x = scan.nextInt();
        System.out.print("Introduce el valor de y: ");
        y = scan.nextInt();
        System.out.print("Introduce el valor de z: ");
        z = scan.nextInt();

        scan.close();
    }

    public static void calcularSentencias() {
        Sentencia2 sentencia2 = new Sentencia2(z);

        // Se lanza el proceso secundario
        sentencia2.start();

        int a = x + y;
        System.out.println("a vale: " + a);

        try {
            sentencia2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Petated");
        }

        int c = a - sentencia2.getB();
        System.out.println("c vale: " + c);

        int w = c + 1;
        System.out.println("w vale: " + w);
    }
}
