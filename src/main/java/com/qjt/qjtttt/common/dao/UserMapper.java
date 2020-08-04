package com.qjt.qjtttt.common.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.qjt.qjtttt.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select name from t_user")
    List<User> selectName();

    List<User> selectUsername();

}
