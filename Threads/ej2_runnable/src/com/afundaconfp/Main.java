package com.afundaconfp;

import java.util.Scanner;

public class Main implements Runnable {

    public static int cuad, x, y, z, a, b, c, m1, m2;

    public int option;

    public Main(int option) {
        this.option = option;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("x: ");
        x = s.nextInt();
        System.out.print("a: ");
        a = s.nextInt();
        System.out.print("b: ");
        b = s.nextInt();
        System.out.print("c: ");
        c = s.nextInt();

        Main runnable1 = new Main(1);
        Main runnable2 = new Main(2);

        Thread hilo1 = new Thread(runnable1);
        Thread hilo2 = new Thread(runnable2);

        System.out.println("-- INICIO DE LA EJECUCION --");
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        z = m1 + m2;
        System.out.printf("S4: z (%d) = m1 (%d) + m2 (%d)\n", z, m1, m2);
        y = z + c;
        System.out.printf("S5: y (%d) = z (%d) + c (%d)\n", y, z, c);
        System.out.println("-- FIN DE LA EJECUCION --");
    }

    @Override
    public void run() {
        switch (option) {
            case 1 -> {
                cuad = x * x;
                System.out.printf("S1: cuad (%d) = x (%d) * x (%d)\n", cuad, x, x);
                m1 = a * cuad;
                System.out.printf("S2: m1 (%d) = a (%d) * cuad (%d)\n", m1, a, cuad);
            }
            case 2 -> {
                m2 = b * x;
                System.out.printf("S3: m2 (%d) = b (%d) * x (%d)\n", m2, b, x);
            }
        }
    }
}
