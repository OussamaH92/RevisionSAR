public class JobController {

    private boolean done;
    //private boolean exec;

    public JobController(/*boolean toDoo*/){
        this.done = false /*toDoo*/;
        //this.exec = false;
    }

    public synchronized void jobDone(){
        this.done = true;
        notifyAll();
    }

   /* public synchronized void jobNotExec(){
        this.exec = true;
        notifyAll();
    }*/


    public synchronized void isJobDone() throws InterruptedException {
        while(!done /*&& !exec*/){
            wait();
        }
        //done = false;
    }

}
