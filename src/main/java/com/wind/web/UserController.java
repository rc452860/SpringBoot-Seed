package com.wind.web;

import com.wind.common.Constant;
import com.wind.common.PaginatedResult;
import com.wind.exception.ResourceNotFoundException;
import com.wind.mybatis.pojo.User;
import com.wind.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return userService
                .getUserByID(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException()
                        .setResourceName(Constant.RESOURCE_USER)
                        .setId(id));
    }

    @GetMapping("/all/{page}")
    public ResponseEntity<?> getAllUser(@PathVariable int page) {
        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(userService.getAll(page))
                        .setCurrentPage(page)
                        .setTotalPage(userService.getTotalPage()));
    }

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody User user) {
        userService.addUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody User user) {
        assertUserExist(id);

        user.setId(id);
        userService.modifyUserById(user);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        assertUserExist(id);

        userService.deleteUserById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    /********************************** HELPER METHOD **********************************/
    private void assertUserExist(Long id) {
        userService
                .getUserByID(id)
                .orElseThrow(() -> new ResourceNotFoundException()
                        .setResourceName(Constant.RESOURCE_USER)
                        .setId(id));
    }
}