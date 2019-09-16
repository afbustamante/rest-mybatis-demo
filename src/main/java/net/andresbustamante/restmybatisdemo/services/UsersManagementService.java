package net.andresbustamante.restmybatisdemo.services;

import net.andresbustamante.restmybatisdemo.beans.User;
import net.andresbustamante.restmybatisdemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersManagementService {

    @Autowired
    private UserDAO userDAO;

    public User findUserById(Long id) {
        return userDAO.findUserById(id);
    }

    public long createUser(User user) {
        int insertedLines = userDAO.createUser(user);
        return user.getId();
    }
}
