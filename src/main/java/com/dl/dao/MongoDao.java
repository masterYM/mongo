package com.dl.dao;


import com.dl.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String STA_DATA_COLLECTION = "address";

    public Address getAddress(String city, String state) {
        Query query = new Query();
        Criteria criteria = Criteria.where("city").is(city);
//        Criteria criteria = Criteria.where("city").is(city).and("state").is(state);
        query.addCriteria(criteria);
        List<Address> address = mongoTemplate.findAll(Address.class);
//        Address address = mongoTemplate.findOne(query,Address.class,STA_DATA_COLLECTION);
//        if (address == null) {
//            address = new Address();
//        }
        return address.get(0);
    }
}
