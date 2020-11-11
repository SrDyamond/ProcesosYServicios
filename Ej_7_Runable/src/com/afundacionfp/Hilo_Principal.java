package com.afundacionfp;

import java.util.Scanner;

public class Hilo_Principal {

    private  int  a,b,c,w;//a calcular


    //contructor
    public Hilo_Principal(int x, int y, int z) {

        System.out.println("--INICIO EJECUCION--");
        RunnableS2 miRunnableS2 =new RunnableS2(this , z);
        Thread miHiloS2=new Thread(miRunnableS2);
        miHiloS2.start();
        a=x+y;
        System.out.printf("S1: a (%d) = x (%d) + y (%d):\n",a,x,y);
      //  b=z-1;
     //   System.out.printf("S2: b (%d) = z (%d) -1:\n",b,z);
        try{
            miHiloS2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        c=a-b;
        System.out.printf("S3: c (%d) = a (%d) + b (%d):\n",c,a,b);
        w=c+1;
        System.out.printf("S4: w (%d) = c (%d) + 1:\n",w,c);

        System.out.println("--FIN EJECUCION--");


    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        int x,y,z;//a introducir por el usuario
        Scanner in =new Scanner(System.in);
        System.out.println("introduce x");
        x=in.nextInt();
        System.out.println("introduce y");
        y=in.nextInt();
        System.out.println("introduce z");
        z=in.nextInt();

        Hilo_Principal miclase=new Hilo_Principal(x,y,z);

        in.close();

    }
}