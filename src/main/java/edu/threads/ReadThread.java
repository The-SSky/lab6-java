package edu.threads;

import edu.MediaLibrary;

public class ReadThread extends Thread{

    private final MediaLibrary mediaLibrary;

    public ReadThread(MediaLibrary mediaLibrary){
        this.mediaLibrary= mediaLibrary;
    }

    @Override
    public void run() {
        super.run();

        int length = mediaLibrary.getItemsCount();

        for(int i=0; i<length; i++) {

            synchronized (mediaLibrary) {
                mediaLibrary.notify();
                System.out.println("Read: " + mediaLibrary.getDuration(i) + "  at: " + i);
                try {
                    if(i + 1 == length) return;
                    mediaLibrary.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        interrupt();
    }
}

