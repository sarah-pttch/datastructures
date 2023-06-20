package com.example.datastructures.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class QueueController {

    ArrayList<Integer> queue = new ArrayList<>();

    @GetMapping("/queue/push")
    public String push(@RequestParam Integer number){
        queue.add(number);
        return "You added the number " + number + " to the queue";
    }

    @GetMapping("/queue/remove")
    public String remove(){
        Integer number = queue.get(0);
        queue.remove(0);
        return "You removed the number " + number + " from the queue";
    }

    @GetMapping("/queue/peek")
    public String peek(){
        return "The number at the head of the queue is " + queue.get(0);
    }

}
