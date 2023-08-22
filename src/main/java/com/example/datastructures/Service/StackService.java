package com.example.datastructures.Service;

import org.springframework.stereotype.Service;

@Service
public class StackService {

    int[] stack = new int[10];
    int i = 0;

    public void push(int number){
        try {
            stack[i] = number;
        }
        catch(IndexOutOfBoundsException e) {
            throw new ListFullException();
        }
        i++;
    }

    public Integer remove() {
        if(i == 0){
            throw new ListEmptyException();
        }
        i--;
        return stack[i];
    }

    public Integer peek(){
        try {
            return stack[i - 1];
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
