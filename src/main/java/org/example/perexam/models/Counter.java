package org.example.perexam.models;

public class Counter {
    private  int count=0;
    public void increment(){
        count++;
    }
    public void reset(){
        count=0;
    }
    public int getCount(){
        return count;
    }
}
