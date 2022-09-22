package com.example.arjun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.arjun.entity.Cart;
import com.example.arjun.entity.User;
@Repository
public interface ICartRepository extends JpaRepository<Cart,Integer>{

}
