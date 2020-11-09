package com.cognizant.kafkaconsumer.dao;

import com.cognizant.kafkaconsumer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
