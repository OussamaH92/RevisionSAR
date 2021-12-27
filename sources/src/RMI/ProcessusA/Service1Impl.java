package RMI.ProcessusA;

import RMI.Service1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service1Impl extends UnicastRemoteObject implements Service1 {

    private boolean doneA = false;
    private boolean doneB = false;

    protected Service1Impl() throws RemoteException {
    }


    @Override
    public synchronized void A() {
        System.out.println("A");
    }

    @Override
    public synchronized void isDoneA() throws InterruptedException {
        while(!doneA)wait();

    }

    @Override
    public synchronized void doneA() {
        this.doneA = true;
        notify();
    }

    @Override
    public synchronized void B() throws InterruptedException {
        System.out.println("B");
    }

    @Override
    public synchronized void isDoneB() throws InterruptedException {
        while(!doneB)wait();
    }

    @Override
    public synchronized void doneB() {
        this.doneB = true;
        notify();
    }
}
