package com.zz.yuan_user.dao;


import com.zz.yuan_user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where id= #{id}")
    public User getById(@Param("id") long id);

    @Insert("insert into user(id, username, password, salt, register_date, last_login_date, completeness) " +
            "values(#{id}, #{username}, #{password}, #{salt}, #{registerDate}, #{lastLoginDate}, #{completeness} )")
    public int insertUser(User user);

    @Select("select * from user where username = #{username}")
    public User getByUserName(@Param("username") String username);
}
