package com.frutyloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frutyloops.models.Item;

@Controller
public class ItemController {
 
    @RequestMapping("/")
    public String index(Model model) {
        
        // Creating a list of fruits
        ArrayList<Item> fruits = new ArrayList<Item>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", 0.75));
        
        // Adding the fruits list to the model
        model.addAttribute("fruits", fruits);
        
        // Returning the view name
        return "index.jsp";
    }
}
