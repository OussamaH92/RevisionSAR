package RPC;

import java.io.*;
import java.net.Socket;

public class Client {

    private int port;
    private String adresse; //sur la meme machine adresse = "localhost"

    public Client(int p, String a){
        this.port = p;
        this.adresse = a;
    }

    public Object1 requete1(String Object2) throws IOException, ClassNotFoundException {

       Socket s = new Socket(adresse,port);
       ObjectInputStream in = new ObjectInputStream(s.getInputStream());
       ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

       out.writeObject("M2");
       out.writeObject(Object2);

       Object res = in.readObject();
       while(res == null){
           res = in.readObject();
       }

       s.close();
       in.close();
       out.close();

       return (Object1) res;

    }

    public Object2 requete2(String Object1) throws IOException, ClassNotFoundException {

        Socket s = new Socket(adresse,port);
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

        out.writeObject("M1");
        out.writeObject(Object1);

        Object res = in.readObject();
        while(res == null){
            res = in.readObject();
        }

        s.close();
        in.close();
        out.close();

        return (Object2) res;

    }

}
