package net.andresbustamante.restmybatisdemo.services;

import net.andresbustamante.restmybatisdemo.beans.User;
import net.andresbustamante.restmybatisdemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersManagementService {

    private final UserDAO userDAO;

    @Autowired
    public UsersManagementService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findUserById(Long id) {
        return userDAO.findUserById(id);
    }

    public long createUser(User user) {
        userDAO.createUser(user);
        return user.getId();
    }
}
