package com.examportal.examserver.Controller;

import com.examportal.examserver.Model.User;
import com.examportal.examserver.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User Controller", description = "REST APIs  for user")
public class UserController {

   @Autowired
   private UserService userService;

    // get user by user username
    @GetMapping("/{username}")
    @Operation(summary= "get user by username")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUsername(@PathVariable String username)
    {
        return userService.getUserByUsername(username);
    }

    // delete user by user id
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserByUserId(@PathVariable Long userId)
    {
         userService.deleteUserByUserId(userId);
    }

    // update user by user id
    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUserByUserId(@RequestBody  User user,@PathVariable Long userId)
    {
        return userService.updateUserByUserId(user,userId);
    }




}
