package com.example.datastructures.Service;

import org.springframework.stereotype.Service;

@Service
public class StackService {

    int[] stack = new int[10];
    int i = -1;

    public void push(int number){
        if(i == 9) {
            throw new ListFullException();
        }
        i++;
        stack[i] = number;
    }

    public Integer remove() {
        if(i == -1){
            throw new ListEmptyException();
        }
        i--;
        return stack[i+1];
    }

    public Integer peek(){
        try {
            return stack[i];
        }
        catch(IndexOutOfBoundsException e){
            throw new ListEmptyException();
        }
    }

    public int getI(){
        return i;
    }

    public int getStackValueByIndex(int x){
        return stack[x];
    }
}
