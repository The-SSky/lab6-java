package edu.factories;

import edu.Collectable;

public interface CollectableFactory {

    Collectable createInstance();

    Collectable createInstance(String title, int price, int count);
}
