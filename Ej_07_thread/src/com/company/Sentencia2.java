package com.company;

public class Sentencia2 extends Thread {
    // variable introducida por el usuario
    private int z;
    // variable a calcular por el hilo secundario
    private int b;

    public Sentencia2(int z) {
        this.z = z;
    }

    @Override
    public void run() {
        this.b = z - 1;
        System.out.println("b vale: " + b);
    }


    public int getB() {
        return b;
    }
}
