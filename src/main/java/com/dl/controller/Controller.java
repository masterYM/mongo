package com.dl.controller;

import com.dl.dao.MongoDao;
import com.dl.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class Controller {
    @Autowired
    private MongoDao mongoDao;

    @RequestMapping("address")
    public Address getAddress(@RequestParam(value = "city") String city, @RequestParam(value = "state") String state){
        Address address = mongoDao.getAddress(city,state);
        return address;
    }

}
