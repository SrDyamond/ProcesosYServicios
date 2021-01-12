package com.afundaconfp;

import java.util.Scanner;

public class Main extends Thread {

    private static int a, x, y, z;
    private static float c;

    private final int option;

    public Main(int option) {
        this.option = option;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("x: ");
        x = s.nextInt();
        System.out.print("y: ");
        y = s.nextInt();
        System.out.print("z: ");
        z = s.nextInt();

        Thread hilo1 = new Main(1);
        Thread hilo2 = new Main(2);

        System.out.println("-- INICIO DE LA EJECUCION --");
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float d = a + c;
        System.out.printf("S4: d (%f) = a (%d) + c (%f)\n", d, a, c);
        System.out.println("-- FIN DE LA EJECUCION --");
    }

    @Override
    public void run() {
        switch (option) {
            case 1 -> {
                a = 2 * x;
                System.out.printf("S1: a (%d) = 2 * x (%d)\n", a, x);
            }
            case 2 -> {
                float b = y - z;
                System.out.printf("S2: b (%f) = y (%d) - z (%d)\n", b, y, z);
                c = b / 3;
                System.out.printf("S3: c (%f) = b (%f) / 3\n", c, b);
            }
        }
    }
}
