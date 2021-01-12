package com.afundaconfp;

import java.util.Scanner;

public class Main extends Thread {
    private static int x, y, z, a, b = 0;

    private final int opcion;

    public Main(int opcion) {
        this.opcion = opcion;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("y: ");
        y = s.nextInt();
        System.out.print("a: ");
        a = s.nextInt();
        System.out.print("b: ");
        b = s.nextInt();

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
        System.out.println("-- FIN DE LA EJECUCION --");
    }

    @Override
    public void run() {
        switch (this.opcion) {
            case 1 -> {
                x = y + 1;
                System.out.println("x vale: " + x);
                y = x + 2;
                System.out.println("y vale: " + y);
            }
            case 2 -> {
                z = a + b;
                System.out.println("z vale: " + z);
            }
        }
    }
}
