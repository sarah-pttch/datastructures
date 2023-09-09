package com.example.datastructures.Service;

import org.springframework.stereotype.Service;

@Service
public class QueueService {

    int[] queue = new int[10];
    int i = -1;

    public void push(int number){
        if(i == 9) {
            throw new ListFullException();
        }
        i++;
        queue[i] = number;
    }

    public Integer remove(){
        Integer number = queue[0];
        try {
            System.arraycopy(queue, 1, queue, 0, i);
        }
        catch(IndexOutOfBoundsException e){
            throw new ListEmptyException();
        }
        i--;
        return number;
    }

    public Integer peek() throws IndexOutOfBoundsException {
        if(i == -1){
            throw new ListEmptyException();
        }
        return queue[0];
    }

    public int getI(){
        return i;
    }

    public int getQueueValueByIndex(int x){
        return queue[x];
    }
}
