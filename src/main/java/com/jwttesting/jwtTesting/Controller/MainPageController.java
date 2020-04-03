package com.jwttesting.jwtTesting.Controller;


import com.jwttesting.jwtTesting.Model.AppUser;
import com.jwttesting.jwtTesting.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/")
public class MainPageController {

    @Autowired
    private AppUserService appUserService;


    @GetMapping
    public ResponseEntity<?> getUser(){

        
        SecurityProperties.User user = new SecurityProperties.User();



        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody AppUser user, BindingResult result){

        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(appUserService.save(user),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody AppUser user, BindingResult result){


        if(result.hasErrors()){
            Map<String,String> errorMap = new HashMap<String,String>();

            result.getFieldErrors().forEach(error->
                    errorMap.put(error.getField(),error.getDefaultMessage()));
            return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(appUserService.save(user),HttpStatus.ACCEPTED);
    }


}
