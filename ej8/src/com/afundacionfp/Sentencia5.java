package com.afundacionfp;

public class Sentencia5 extends Thread {
    // variable introducida por el usuario
    private int a,b,c;
    // variable a calcular por el hilo secundario
    private int e;

    public Sentencia5(int a, int b, int c) {
        this.a=a;
        this.b=b;
        this.c=c;
        
    }

    @Override
    public void run() {
        this.e= a * b *c;
        System.out.println("S5:e vale: " + e);
    }

    public int getE() {
        return e;
    }
}
