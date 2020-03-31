package com.qjt.qjtttt.service;

import com.qjt.qjtttt.common.annotion.DataSource;
import com.qjt.qjtttt.common.dao.UserMapper;
import com.qjt.qjtttt.common.mutidatesource.DSEnum;
import com.qjt.qjtttt.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查找用户
     * @param id
     * @return
     */
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public User findById1(Integer id){return userMapper.selectById(id);}

    /**
     * 新增用户
     * @param user
     */
    public Integer insertUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * 修改用户
     * @param user
     */
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    /**
     * 删除用户
     * @param id
     */
    public Integer deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    public List<User> getUserList(RowBounds rowBounds) {
        return userMapper.selectPage(rowBounds,null);
    }
}
