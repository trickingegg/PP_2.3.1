package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DataInit {

    @Autowired
    private UserService userService;

//    @PostConstruct
//    public void init() {
//        userService.add(new User("NameOne", "SecondNameOne", "email1@mail.ru"));
//        userService.add(new User("NameTwo", "SecondNameTwo", "email2@mail.ru"));
//        userService.add(new User("NameThree", "SecondNameThree", "email3@mail.ru"));
//    }
}
