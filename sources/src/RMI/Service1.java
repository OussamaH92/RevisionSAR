package RMI;

import java.rmi.server.UnicastRemoteObject;

public interface Service1{

    void A();
    void isDoneA() throws InterruptedException;
    void doneA();

    void B() throws InterruptedException;
    void isDoneB() throws InterruptedException;
    void doneB();

}
