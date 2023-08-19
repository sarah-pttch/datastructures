package com.example.datastructures.Controller;

import com.example.datastructures.Service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stack")
public class StackController {

    @Autowired
    StackService stackService;

    @GetMapping("/push")
    public String push(@RequestParam Integer number){
        stackService.push(number);
        return "You added the number " + number + " to the stack";
    }

    @GetMapping("/remove")
    public String remove(){
        return "You removed the number " + stackService.remove() + " from the stack";
    }

    @GetMapping("/peek")
    public String peek(){
        return "The number on top of the stack is " + stackService.peek();
    }

}
