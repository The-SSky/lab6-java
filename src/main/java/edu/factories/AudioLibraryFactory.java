package edu.factories;

import edu.AudioLibrary;
import edu.Collectable;

public class AudioLibraryFactory implements CollectableFactory{
    @Override
    public Collectable createInstance() {
        return new AudioLibrary();
    }

    @Override
    public Collectable createInstance(String title, int price, int count) {
        return new AudioLibrary(title, price, count);
    }
}
