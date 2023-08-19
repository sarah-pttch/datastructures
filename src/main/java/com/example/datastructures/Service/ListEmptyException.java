package com.example.datastructures.Service;

public class ListEmptyException extends IndexOutOfBoundsException {

    public ListEmptyException(){
        super("There are no elements in the list. Add elements first.");
    }
}
