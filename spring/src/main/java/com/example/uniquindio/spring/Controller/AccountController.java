package com.example.uniquindio.spring.Controller;

import com.example.uniquindio.spring.model.documents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.uniquindio.spring.dto.UserDto;
import com.example.uniquindio.spring.dto.emaildto.EmailDto;
import com.example.uniquindio.spring.service.EmailService;
import com.example.uniquindio.spring.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    /**
     * TODO: method create user
     *
     * @param userdto
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody() UserDto userdto) {
        if (userService.validateUser(userdto) != true) {
            User user = userService.saveUser((userdto));
            return ResponseEntity.status(200).body(user);
        } else {
            return ResponseEntity.status(409).body(null);
        }

    }

    @RequestMapping(value = "email", method = RequestMethod.POST)
    public void sendEmail(@RequestBody() EmailDto emaildto) throws Exception {
        emailService.sendEmailRegister(emaildto);
    }
}
