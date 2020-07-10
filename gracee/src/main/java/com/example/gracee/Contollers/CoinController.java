package com.example.gracee.Contollers;


import com.example.gracee.Models.Coin;
import com.example.gracee.Repos.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class CoinController
{

    @Autowired
    CoinRepo crepo;
    Coin    coins;

    //http://localhost:2019/total
    //Get total!

    @GetMapping(value = "/total",
            produces = {"application/json"})
    public ResponseEntity<?> total()
    {
        List<Coin> mylist = new ArrayList<>();
        crepo.findAll().iterator().forEachRemaining(mylist::add);


        double total = 0;
        for (Coin c : mylist)
        {
            System.out.print(c.getQuantity() + " ");
            if (c.getQuantity() == 1)
            {
                System.out.println(c.getName());
            } else
            {
                System.out.println(c.getNamepural());
            }
            total = total + (c.getQuantity() * c.getValue());

        }
        System.out.println("The piggy bank holds $ " + total);


        return new ResponseEntity<>(mylist, HttpStatus.OK);


    }

}
