package com.afundacionfp;

import java.util.Scanner;

public class ejercicio6 extends Thread {
    private static int x, y, z, a;
    // Variable de clase, va en el constructor
    private int operacion;
    private static double b, c, d;

    // Se crea un constructor
    public ejercicio6(int operation) {
        this.operacion = operation;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Se instancian dos objetos de la clase
        ejercicio6 hilo1 = new ejercicio6(1);
        ejercicio6 hilo2 = new ejercicio6(2);

        // Se introducen los valores por teclado
        System.out.print("Introduce el valor de x: ");
        x = scan.nextInt();

        System.out.print("Introduce el valor de y: ");
        y = scan.nextInt();

        System.out.print("Introduce el valor de z: ");
        z = scan.nextInt();

        System.out.print("Introduce el valor de a: ");
        a = scan.nextInt();

        // Se lanzan los dos hilos con el método start()
        // Al heredar de la clase Thread, directamente usa run()
        hilo1.start();
        hilo2.start();

        // Se le dice que pare la ejecución del main hasta que acaben los dos hilos
        // Para ello se usa join dentro de un try-catch
        try {
            hilo1.join();
            hilo2.join();
        } catch(InterruptedException e){

        }

        d=a+c;
        System.out.print("d Vale "+d);

        // Al acabar los hilos se sigue con la ejecución

    }

    @Override
    public void run() {
        switch (operacion) {
            case 1:
                a = 2 * x;
                System.out.println("a vale: "+a);
                break;
            case 2:
                b = y * z;
                System.out.println("b vale: "+b);
                c = b / 3;
                System.out.println("c vale: "+c);
                break;
        }
    }
}