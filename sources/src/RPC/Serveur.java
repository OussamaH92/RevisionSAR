package RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

    private int port;

    public Serveur(int port){
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(port);

        while(true){
            traiterRequete(ss.accept());
        }

    }

    public void traiterRequete(Socket s) throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

        String request = (String) in.readObject();


        if(request.equals("M1")){
            out.writeObject(new Object2());
        }else if(request.equals("M2")){
            out.writeObject(new Object1());
        }

        s.close();
        in.close();
        out.close();


    }

}
