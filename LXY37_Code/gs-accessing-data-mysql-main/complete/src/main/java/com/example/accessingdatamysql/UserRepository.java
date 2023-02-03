package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

//import com.example.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

public User findByEmail(String email);//自己写了一个根据邮箱查找对象的函数，系统根据名字解析不需要sql语句？

}
