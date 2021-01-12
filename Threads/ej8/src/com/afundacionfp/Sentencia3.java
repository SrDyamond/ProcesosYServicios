package com.afundacionfp;

public class Sentencia3 extends Thread {
    // variable introducida por el usuario
    private int x,y;
    // variable a calcular por el hilo secundario
    private int c;

    public Sentencia3(int x,int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        this.c = x * y;
        System.out.println("S3:C vale: " + c);
    }


    public int getC() {
        return c;
    }
}