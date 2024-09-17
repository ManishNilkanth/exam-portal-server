package com.examportal.examserver.Service;

import com.examportal.examserver.Model.User;

public interface UserService {



    public User getUserByUsername(String username);

    public void deleteUserByUserId(Long userId);

    public User updateUserByUserId(User user,Long userId);
}
