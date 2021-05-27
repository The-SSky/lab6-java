package edu;

import edu.iterators.ItemsDurationIterator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

public class UnmodifiableCollectable implements Collectable{

    private final Collectable c;

    public UnmodifiableCollectable(Collectable c) {
        this.c = c;
    }

    @Override
    public String getTitle(){
        return c.getTitle();
    }

    @Override
    public int getItemsCount(){
        return c.getItemsCount();
    }

    @Override
    public int getPrice(){
        return c.getPrice();
    }

    @Override
    public String getItem(int index){
        return c.getItem(index);
    }

    @Override
    public int getDuration(int index){
        return c.getDuration(index);
    }

    @Override
    public  void setTitle(String title){
        throw new UnsupportedOperationException("Cant be modified");
    }

    @Override
    public void setPrice(int price){
        throw new UnsupportedOperationException("Cant be modified");
    }

    @Override
    public void setItem(int index, String title){
        throw new UnsupportedOperationException("Cant be modified");
    }

    @Override
    public void setDuration(int index, int duration){
        throw new UnsupportedOperationException("Cant be modified");
    }

    @Override
    public int[] getDurations(){
        return c.getDurations();
    }

    @Override
    public int getTotalDuration(){
        return c.getTotalDuration();
    }

    @Override
    public void output(OutputStream out) throws IOException {
        c.output(out);
    }

    @Override
    public void write(BufferedWriter out) throws IOException{
        c.write(out);
    }

    @Override
    public Iterator iterator() {
        return new ItemsDurationIterator(this);
    }
}
