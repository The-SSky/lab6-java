package edu.app;

import edu.*;
import edu.factories.CollectableFactory;
import edu.factories.VideoLibraryFactory;
import edu.threads.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        VideoLibrary videoLibrary = new VideoLibrary(
                "run title",
                100,
                new String[]{"a", "b", "c", "d"},
                new int[]{200, 300, 400, 500});

        SynchronizedCollectable syncVL = new SynchronizedCollectable(videoLibrary);

        for (Object dur : videoLibrary)
        {
            System.out.println(dur);
        }

        CollectableFactory cf;
        cf = new VideoLibraryFactory();
        InputOutput.setCollectableFactory(cf);

        System.out.println(InputOutput.createInstance());
    }
}
