package RMI.ProcessusB;

import RMI.Service1;

import java.io.IOException;

public class ProcessusB {
    private Service1 od;
    private int port;

    public ProcessusB(Service1 od) {
        this.od = od;
        this.port = port;
    }

    public void start() throws IOException {

        od.A();
        od.doneA();

    }
}
