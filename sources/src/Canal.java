public class Canal<Object> {

    Object message;

    public Canal(){
        this.message = null;
    }

    public synchronized void deposerMessage(Object msg) throws InterruptedException {

        this.message = msg;
        notify();
        wait();

    }

    public synchronized Object lireMessage() throws InterruptedException {

        if(message == null)wait();
        Object temp = message;
        message = null;
        notify();
        return temp;

    }

}
