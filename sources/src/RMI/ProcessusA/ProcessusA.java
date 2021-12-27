package RMI.ProcessusA;

import java.io.IOException;

public class ProcessusA {

   private Service1Impl od;
   private int port;

    public ProcessusA(Service1Impl od) {
        this.od = od;
        this.port = port;
    }


    public void start() throws IOException, InterruptedException {

        od.isDoneA();
        od.B();
        od.doneB();

    }

}
