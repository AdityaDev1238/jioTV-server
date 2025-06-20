package com.jio.Tv.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jio.Tv.model.User;

public interface UserRepo extends JpaRepository<User, Integer>
{
        User findByName(String name);

}
