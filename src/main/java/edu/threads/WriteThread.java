package edu.threads;

import edu.MediaLibrary;

public class WriteThread extends Thread{

    private final MediaLibrary mediaLibrary;

    public WriteThread(MediaLibrary mediaLibrary){
        this.mediaLibrary= mediaLibrary;
    }

    @Override
    public void run() {
        super.run();

        int length = mediaLibrary.getItemsCount();

        for(int i=0; i<length; i++) {
            synchronized (mediaLibrary) {
                mediaLibrary.notify();
                mediaLibrary.setDuration(i, i * 100);
                System.out.println("Write: " + mediaLibrary.getDuration(i) + "  at: " + i);
                try {
                    if(i + 1 == length) return;
                    mediaLibrary.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
