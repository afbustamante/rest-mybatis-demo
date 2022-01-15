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

    private final UsersManagementService usersManagementService;

    @Autowired
    public UsersController(UsersManagementService usersManagementService) {
        this.usersManagementService = usersManagementService;
    }

    @PostMapping(path = "")
    public ResponseEntity<Void> createUser(User user) {
        long id = usersManagementService.createUser(user);
        URI location = URI.create("/users/" + id);
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        User user = usersManagementService.findUserById(id);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}
