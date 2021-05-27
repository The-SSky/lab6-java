package edu.threads;

public class RunnableWriteThread implements Runnable{
    private CollectableSynchronizer libSync;

    public RunnableWriteThread(CollectableSynchronizer libSync) {
        this.libSync = libSync;
    }

    @Override
    public void run() {
        try {
            int dur;
            for (int index = 0; index < libSync.getSerItemsCount(); index++) {
                dur = index * 100;
                libSync.write(dur);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
