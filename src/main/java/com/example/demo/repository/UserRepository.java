package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.NativePlace;
import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 查找是否有这样的用户名和密码用户存在
     * @param name
     * @param password
     * @return
     */
    User findUserByUsernameAndUserpwd(String name, String password);

    /**
     * 查找是否有这样的用户存在
     * @param name
     * @return
     */
    List<User> findUserByUsername(String name,Sort sort);
    

}
