import java.util.ArrayList;
import java.util.List;

public class Port<Object> {

    List<Object> message; // Declarer une List pas une ArrayList

    public Port(){
        message = new ArrayList<>(); // utiliser le constructeur d'ArrayList
    }

    public synchronized void envoyer(Object msg){
        message.add(msg);
        notify();
    }

    public synchronized Object recevoir() throws InterruptedException {

        if(message.size() == 0)wait();
        Object temp = message.get(0); // 0 pour l'ordre FIFO
        message.remove(0);
        return temp;
    }

}
