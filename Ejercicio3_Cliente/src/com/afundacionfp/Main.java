package com.afundacionfp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Socket sck = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            System.out.println("Introduce el numero del que quieres aeriguar su cuadrado");
            Scanner sc =new Scanner(System.in);
            int numero =sc.nextInt();
            sck=new Socket("local host",1234);
            dis=new DataInputStream(sck.getInputStream());
            dos=new DataOutputStream(sck.getOutputStream());
            dos.writeInt(numero);
            long resultado =dis.readLong();
            System.out.println("Solicitud :" +numero+"\tResultado :"+resultado);
            dos.close();
            dis.close();

        }catch (IOException e){
            System.out.println("Se ha producido la excepcion en el cliente");
        }
        try{
            if(sck!=null)
                sck.close();
        }catch (IOException e){
            System.out.println("Error al cerrar el socket");
        }
    }
}
