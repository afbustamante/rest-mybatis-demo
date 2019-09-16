package net.andresbustamante.restmybatisdemo.controllers;

import net.andresbustamante.restmybatisdemo.beans.User;
import net.andresbustamante.restmybatisdemo.services.UsersManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersManagementService usersManagementService;

    @PostMapping(path = "")
    public ResponseEntity createUser(User user) {
        usersManagementService.createUser(user);
        URI location = URI.create("/users/" + user.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        User user = usersManagementService.findUserById(id);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}
