package com.example.customException.project.repository;

import com.example.customException.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class UserDalMongoDb implements IUserDal {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User addUser (User user){
        mongoTemplate.insert(user);
        return user;
    }

    @Override
    public void removeUserById(int id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
    }

    @Override
    public void updateUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User findById(int id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, User.class);
    }

}
