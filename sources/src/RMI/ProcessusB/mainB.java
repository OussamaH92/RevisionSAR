package RMI.ProcessusB;

import RMI.ProcessusB.ProcessusB;
import RMI.Service1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class mainB {


    public static void main(String[] args) {

        try{

            Service1 od;

            Registry reg = LocateRegistry.getRegistry(1099);
            od = (Service1) reg.lookup("Service1");

            ProcessusB p2 = new ProcessusB(od);

            p2.start();


        }catch (Exception e){

        }

    }
}
