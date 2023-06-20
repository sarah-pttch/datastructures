package com.example.datastructures.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class StackController {

    ArrayList<Integer> stack = new ArrayList<>();

    @GetMapping("/stack/push")
    public String push(@RequestParam Integer number){
        stack.add(number);
        return "You added the number " + number + " to the stack";
    }

    @GetMapping("/stack/remove")
    public String remove(){
        Integer number = stack.get(stack.size() - 1);
        stack.remove(stack.size()-1);
        return "You removed the number " + number + " from the stack";
    }

    @GetMapping("/stack/peek")
    public String peek(){
        return "The number on top of the stack is " + stack.get(stack.size()-1);
    }

}
