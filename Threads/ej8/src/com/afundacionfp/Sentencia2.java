package com.afundacionfp;

public class Sentencia2 extends Thread {
    // variable introducida por el usuario
    private int x,y;
    // variable a calcular por el hilo secundario
    private int b;

    public Sentencia2(int x,int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        this.b = x - y;
        System.out.println("S2:B vale: " + b);
    }


    public int getB() {
        return b;
    }
}
