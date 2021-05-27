package edu.threads;

public class RunnableReadThread implements Runnable{
    private CollectableSynchronizer libSync;

    public RunnableReadThread(CollectableSynchronizer libSync) {
        this.libSync = libSync;
    }

    @Override
    public void run() {
        try {
            for (int index = 0; index < libSync.getSerItemsCount(); index++) {
                libSync.read();
            }
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
