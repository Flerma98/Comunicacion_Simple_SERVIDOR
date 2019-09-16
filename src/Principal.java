import java.net.*;
import java.io.*;

public class Principal {

   static int numsocket;
   static ServerSocket socketServer;
   static Socket socket;
   
    public static void main(String[] args) throws Exception{
        try{
        if(args[args.length-1]!=null){
            try {
                numsocket= Integer.parseInt(args[args.length-1]);
                while (true) {
                socketServer= new ServerSocket(numsocket);
                socket= socketServer.accept();
                BufferedReader lector= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String entrada;       
                while ((entrada=lector.readLine())!=null) {
                    System.out.println("me dijeron: " + entrada);
                }
                socket.close();
                socketServer.close();
                }
            } catch (Exception e) {System.out.println("No se pudo levantar un servidor");}
            
        }else{
            System.out.println("No se introdujo un socket");
        }
        } catch (Exception e) {System.out.println("Introdusca un socket valido");}
    }
}