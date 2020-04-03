package com.jwttesting.jwtTesting.Services;

import com.jwttesting.jwtTesting.ExceptionHandling.UsernameNotUniqueException;
import com.jwttesting.jwtTesting.Model.AppUser;
import com.jwttesting.jwtTesting.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private UserRepository userRepository;

    public AppUser save(AppUser user){

        try{
            userRepository.save(user);
        }catch (Exception e){
            throw new UsernameNotUniqueException("Username already taken!");
        }


        return userRepository.findAppUserByUsername(user.getUsername());
    }

}
