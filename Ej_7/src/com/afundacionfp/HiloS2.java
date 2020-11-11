package com.afundacionfp;

public class HiloS2 extends Thread {
    private int z;
    private Hilo_Principal hiloprincipal;

    public HiloS2(Hilo_Principal hiloprincipal,int z) {
        this.z = z;
        this.hiloprincipal = hiloprincipal;
    }

    @Override
    public void run() {
        int b=z-1;
        hiloprincipal.setB(b);
        System.out.printf("S2: b (%d) = z (%d) -1:\n",b,z);

    }
}
