package com.cs.dao.impl;

import com.cs.basedao.BaseDao;
import com.cs.dao.UserDao;
import com.cs.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int findByCountUser() throws Exception {
        int index = 0;
        String sql = "select Count(*) from user";
        ResultSet rs = exeuQuery(sql, null);
        while (rs.next()) {
            index = rs.getInt(1);
        }
        getClose();
        return index;
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        List<User> list = new ArrayList<User>();
        String sql = "select * from user limit ?,?";
        Object obj[] = {(pageNo - 1) * pageSize, pageSize};
        ResultSet rs = exeuQuery(sql, obj);
        while (rs.next()) {
            User us = new User();
            us.setId(rs.getInt(1));
            us.setUsername(rs.getString(2));
            us.setPassword(rs.getString(3));
            us.setSex(rs.getString(4));
            us.setBornDate(rs.getString(5));
            us.setUserpic(rs.getString(6));
            list.add(us);
        }
        getClose();
        return list;
    }

    @Override
    public User login(String username, String password) throws Exception {

        User user = null;
        String sql = "select * from user where username = ? and password = ?";
        Object[] obj = {username, password};
        ResultSet rs = exeuQuery(sql, obj);
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setSex(rs.getString(4));
            user.setBornDate(rs.getString(5));
            user.setUserpic(rs.getString(6));
        }
        getClose();
        return user;
//        return null;
    }

    @Override
    public List<User> findByUserInfoALl() throws Exception {
        List<User> list = new ArrayList<>();
        String sql = "select * from user";
        ResultSet rs = exeuQuery(sql, null);
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setSex(rs.getString(4));
            user.setBornDate(rs.getString(5));
            user.setUserpic(rs.getString(6));
            list.add(user);
        }
        return list;
//        return null;
    }

    @Override
    public User findByIDdUserInfo(int id) throws Exception {
        User user = null;
        String sql = "select * from user where id = ?";
        Object[] obj = {id};
        ResultSet rs = exeuQuery(sql, obj);
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setSex(rs.getString(4));
            user.setBornDate(rs.getString(5));
            user.setUserpic(rs.getString(6));
        }
        getClose();
        return user;
//        return null;
    }

    @Override
    public int updateUser(User user) throws Exception {
        int index = -1;
        String sql = "update user set username = ?,password = ?," +
                "sex = ?,bornDate = ? where id = ?";
        Object[] obj = {user.getUsername(), user.getPassword(),
                user.getSex(), user.getBornDate(), user.getId()};
        index = exeUpdate(sql, obj);
        getClose();
        return index;
//        return 0;
    }

    @Override
    public int delUser(int id) throws Exception {
        int index = -1;
        String sql = "delete from user where id = ?";
        Object[] obj = {id};
        index = exeUpdate(sql, obj);
        getClose();
        return index;
//        return 0;
    }
}
