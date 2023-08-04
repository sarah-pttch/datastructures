package com.example.datastructures.Controller;

import org.springframework.stereotype.Service;

@Service
public class StackService {

    static int[] stack = new int[10];
    static int i = 0;

    public void push(int number){
        // if i>9 throw exception
        stack[i] = number;
        i++;
    }

    public Integer remove() throws IndexOutOfBoundsException {
        if(i == 0){
            throw new IndexOutOfBoundsException("List empty");
        }
        i--;
        return stack[i];
    }

    public Integer peek(){
        return stack[i-1];
    }
}
