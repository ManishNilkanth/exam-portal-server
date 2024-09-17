package com.examportal.examserver.Service.ServiceImplimentation;

import com.examportal.examserver.Model.User;
import com.examportal.examserver.Model.UserRole;
import com.examportal.examserver.Repository.RoleRepository;
import com.examportal.examserver.Repository.UserRepository;
import com.examportal.examserver.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //get user by username logic
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //delete user by user id logic
    @Override
    public void deleteUserByUserId(Long userId) {
        userRepository.deleteById(userId);
    }

    //update user by user id logic
    @Override
    public User updateUserByUserId(User user,Long userId) {
        User userFromDatabase = userRepository.findById(userId).get();

        if(userFromDatabase == user)
        {
            return userFromDatabase;
        }
        else
        {  if(user.getEmail() != null)
           {
               userFromDatabase.setEmail(user.getEmail());
           }
           if(user.getFirstName() != null)
           {
               userFromDatabase.setFirstName(user.getFirstName());
           }
           if(user.getLastName() != null)
           {
               userFromDatabase.setLastName(user.getLastName());
           }
           if(user.getPhoneNumber() != null)
           {
               userFromDatabase.setPhoneNumber(user.getPhoneNumber());
           }
           if(user.getProfile() != null)
           {
               userFromDatabase.setProfile(user.getProfile());
           }

            return userRepository.save(userFromDatabase);

        }
    }

}
