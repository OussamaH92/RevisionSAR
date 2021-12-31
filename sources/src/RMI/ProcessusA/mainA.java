package RMI.ProcessusA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class mainA {

    {
        try {

            Service1Impl od = new Service1Impl();

            ProcessusA p1 = new ProcessusA(od);

            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("Service1",od);


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
