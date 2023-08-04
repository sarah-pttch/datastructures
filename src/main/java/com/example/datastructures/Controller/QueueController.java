package com.example.datastructures.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    QueueService queueService;

    @GetMapping("/push")
    public String push(@RequestParam Integer number){
        queueService.push(number);
        return "You added the number " + number + " to the queue";
    }

    @GetMapping("/remove")
    public String remove(){
        return "You removed the number " + queueService.remove() + " from the queue";
    }

    @GetMapping("/peek")
    public String peek(){
        return "The number at the head of the queue is " + queueService.peek();
    }

}
