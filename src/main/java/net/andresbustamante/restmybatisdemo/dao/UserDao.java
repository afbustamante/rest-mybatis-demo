package net.andresbustamante.restmybatisdemo.dao;

import net.andresbustamante.restmybatisdemo.beans.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User findUserById(@Param("id") Long id);

    int createUser(@Param("user") User user);
}
