package com.example.datastructures.Service;

public class ListFullException extends IndexOutOfBoundsException {

    public ListFullException(){
        super("The list is full.");
    }
}
