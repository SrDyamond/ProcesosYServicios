package com.company;

import java.util.Scanner;
/**
 * S1: a = x + y;<br>
 * S2: b = z - 1;<br>
 * S3: c = a - b;<br>
 * S4: w = c + 1;<br>
 */
public class Main {

    // variables introducidas
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
        // Se declaran las variables a calcular por el hilo principal
        int a, c, w;
        // Se crea una instancia de la clase Sentencia2 (una llamada a su constructor)
        Sentencia2 sentencia2 = new Sentencia2(z);
        // Se crea un objeto thread con el runnable de sentencia2
        Thread sentencia2Thread = new Thread(sentencia2);


        // Se lanza el hilo secundario
        // S2
        sentencia2Thread.start();

        // S1
        a = x + y;
        System.out.println("a vale: " + a);

        try {
            sentencia2Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("It's a no no");
        }

        // S3
        c = a - sentencia2.getB();
        System.out.println("c vale: " + c);

        // S4
        w = c + 1;
        System.out.println("w vale: " + w);
    }
}
