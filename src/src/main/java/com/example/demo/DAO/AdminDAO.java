package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Admin;

@Repository
public interface AdminDAO extends CrudRepository<Admin,Integer>{

}
