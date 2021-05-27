package edu.factories;

import edu.Collectable;
import edu.VideoLibrary;

public class VideoLibraryFactory implements CollectableFactory {
    @Override
    public Collectable createInstance() {
        return new VideoLibrary();
    }

    @Override
    public Collectable createInstance(String title, int price, int count) {
        return new VideoLibrary(title, price, count);
    }
}
