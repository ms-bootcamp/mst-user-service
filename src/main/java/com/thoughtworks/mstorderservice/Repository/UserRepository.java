package com.thoughtworks.mstorderservice.Repository;


import com.thoughtworks.mstorderservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByName(String name);
}
