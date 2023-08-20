package com.example.datastructures.Service;

import org.springframework.stereotype.Service;

@Service
public class QueueService {

    int[] queue = new int[10];
    int i = 0;

    public void push(int number){
        try {
            queue[i] = number;
        }
        catch(IndexOutOfBoundsException e){
            throw new ListFullException();
        }
        i++;
    }

    public Integer remove(){
        Integer number = queue[0];
        try {
            System.arraycopy(queue, 1, queue, 0, i - 1);
        }
        catch(IndexOutOfBoundsException e){
            throw new ListEmptyException();
        }
        i--;
        return number;
    }

    public Integer peek() throws IndexOutOfBoundsException {
        if(i == 0){
            throw new ListEmptyException();
        }
        return queue[0];
    }

    public int getI(){
        return i;
    }

    public int getQueueValue(int x){
        return queue[x];
    }
}
