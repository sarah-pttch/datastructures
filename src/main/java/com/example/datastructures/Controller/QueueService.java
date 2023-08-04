package com.example.datastructures.Controller;

import org.springframework.stereotype.Service;

@Service
public class QueueService {

    static int[] queue = new int[10];
    static int i = 0;

    public void push(int number){
        queue[i] = number;
        i++;
    }

    public Integer remove(){
        Integer number = queue[0];
        System.arraycopy(queue, 1, queue, 0, i-1);
        i--;
        return number;
    }

    public Integer peek() throws IndexOutOfBoundsException {
        if(i == 0){
            throw new IndexOutOfBoundsException("List empty");
        }
        return queue[0];
    }
}
