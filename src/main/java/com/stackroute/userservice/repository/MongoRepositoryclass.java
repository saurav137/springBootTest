package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoRepositoryclass extends MongoRepository<User,Integer>{
   // public  User findById(int trackId);
//   @Query(value = "@Query(\"{name: { $regex: ?0 } })\")")
//   List<User> getTrackByName(@Param("name") String name);

}
