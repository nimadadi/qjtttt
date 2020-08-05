package com.qjt.qjtttt.service;

import com.qjt.qjtttt.model.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    User findById1(Integer id);

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

    List<User> getUserList(RowBounds rowBounds);
}
