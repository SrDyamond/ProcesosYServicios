package com.afundacionfp;
/*
        S1: a = x + y;
        S2: b = x – y;

        S3: c = x * y;

        S4: d = a + b + c;
        S5: e = a * b * c;
        S6: f = d – e;
        
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
        int a,d,f;
        Sentencia2 sentencia2 = new Sentencia2(x,y);
        Sentencia3 sentencia3 = new Sentencia3(x,y);


        // Se lanza el proceso secundario
        sentencia2.start();
        sentencia3.start();
        //se lanzan antes para que sea concurrente
        a = x + y;
        System.out.println("S1:A vale: " + a);

        try {
            sentencia2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Petated");
        }

        try {
            sentencia3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Petated");
        }
        d = a + sentencia2.getB() + sentencia3.getC();
        System.out.println("S4:D vale :"+d);

        Sentencia5 sentencia5 = new Sentencia5(a,sentencia2.getB(),sentencia3.getC());
        sentencia5.start();
        //S5 se lanza antes para poder ser concurrente con S6
        try {
            sentencia5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Petated");
        }

        f= d- sentencia5.getE();
        System.out.println("S6:F vale :"+f);


    }
}
