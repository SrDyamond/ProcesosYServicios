package com.afundacionfp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        ServerSocket ss =null;
        try {
            ss=new ServerSocket(1234);
        }catch (IOException e) {
            System.out.println("Error al abrir el socket");

        }
        long entrada;
        long salida;

        while(true){
            try{
                Socket sckt =ss.accept();
                DataInputStream dis = new DataInputStream(sckt.getInputStream());
                DataOutputStream dos = new DataOutputStream(sckt.getOutputStream());
                entrada=dis.readInt();
                salida =entrada * entrada;
                dos.writeLong(salida);
                dis.close();
                dos.close();
                sckt.close();
            }catch (IOException e){
                System.out.println("Se ha producido la excepcion");
            }
        }

    }
}
