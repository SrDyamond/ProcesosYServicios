package com.afundaconfp;

import java.util.Scanner;

public class Main extends Thread {

    private static int a, b, c, d, e, w;
    private static double f;

    private final int option;

    public Main(int option) {
        this.option = option;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("b: ");
        b = s.nextInt();
        System.out.print("c: ");
        c = s.nextInt();
        System.out.print("e: ");
        e = s.nextInt();
        System.out.print("w: ");
        w = s.nextInt();

        Thread hilo1 = new Main(1);
        Thread hilo2 = new Main(2);
        Thread hilo3 = new Main(3);

        System.out.println("-- INICIO DE LA EJECUCION --");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("S4: g = funcion(a (%d), d (%d), f (%f))\n", a, d, f);
        f = Math.sin(w);
        System.out.printf("S5: f (%f) = sen(z (%d))\n", f, w);
        System.out.println("-- FIN DE LA EJECUCION --");
    }

    @Override
    public void run() {
        switch (option) {
            case 1 -> {
                a = b + c;
                System.out.printf("S1: a (%d) = b (%d) + c (%d)\n", a, b, c);
            }
            case 2 -> {
                d = b + e;
                System.out.printf("S2: d (%d) = b (%d) + e (%d)\n", d, b, e);
            }
            case 3 -> {
                f = c + e;
                System.out.printf("S3: f (%f) = c (%d) + e (%d)\n", f, c, e);
            }
        }
    }
}
