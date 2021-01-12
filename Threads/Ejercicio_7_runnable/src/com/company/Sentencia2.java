package com.company;

public class Sentencia2 implements Runnable{
    // variable introducida
    private int z;
    // variable a calcular por el hilo secundario
    private int b;

    // Se crea el constructor de la clase Sentencia2 (inicia la instancia y sus valores)
    public Sentencia2(int z) {
        this.z = z;
    }

    // Método run (donde tiene lugar la ejecución del hilo secundario)
    @Override
    public void run() {
        this.b = z - 1;
        System.out.println("b vale: " + b);
    }


    // Método getter de la variable b
    // (restringe el acceso a la variable privada desde la fuera de la clase)
    public int getB() {

        return b;
    }
}
