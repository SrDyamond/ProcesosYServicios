package com.afundacionfp;

public class Sentencia3_4 extends Thread {
    // variable introducida por el usuario
    private int x,y;
    // variable a calcular por el hilo secundario
    private int c,d;

    public Sentencia3_4(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        this.c = x * y;
        System.out.println("S3:c vale: " + c);
        this.d = c + 8;
        System.out.println("S4:d vale: "+d);
    }

    public int getD(){ return d;}
}