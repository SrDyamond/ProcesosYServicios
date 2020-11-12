package com.afundacionfp;
/*
        S1-S3
        S2-S4
          S5
        S1: a = x + y;
        S2: b = a + 3;
        S3: c = x * y;
        S4: d = c + 8;
        S5: e = b + d;

 */
import java.util.Scanner;

public class Main {
    // variables introducidas por el usuario
    static int x, y;

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


        scan.close();
    }

    public static void calcularSentencias() {
        int a,b,c,d,e;


        // Se lanza el proceso secundario

        //S1
        a = x + y;
        System.out.println("S1:a vale: " + a);
        //S2
        b = a + 3;
        System.out.println("S2:b vale: " + b);
        //S3S4
        Sentencia3_4 sentencia34 = new Sentencia3_4(x,y);
        sentencia34.start();
        try {
            sentencia34.join();
        } catch (InterruptedException ei) {
            ei.printStackTrace();
            System.out.println("Petated");
        }
        //S5
        e = b + sentencia34.getD();
        System.out.println("S5:e vale: "+e);


    }
}
