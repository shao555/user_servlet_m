package com.cs.service.impl;

import com.cs.dao.impl.UserDaoImpl;
import com.cs.entity.User;
import com.cs.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl udi=new UserDaoImpl();
    @Override
    public int findByCountUser() throws Exception {
        return udi.findByCountUser();
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        return udi.findByPageUserInfo(pageNo,pageSize);
    }

    @Override
    public User login(String username, String password) throws Exception {
        return udi.login(username,password);
//        return null;
    }

    @Override
    public List<User> findByUserInfoALl() throws Exception {
        return udi.findByUserInfoALl();
//        return null;
    }

    @Override
    public User findByIDdUserInfo(int id) throws Exception {
        return udi.findByIDdUserInfo(id);
//        return null;
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        int i = udi.updateUser(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
//        return false;
    }

    @Override
    public boolean delUser(int id) throws Exception {
        int i = udi.delUser(id);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
//        return false;
    }
}