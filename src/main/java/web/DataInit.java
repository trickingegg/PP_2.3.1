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

    @PostConstruct
    public void init() {
        userService.add(new User("Name1", "Second name1", "email1@mail.ru"));
        userService.add(new User("Name2", "Second name2", "email2@mail.ru"));
        userService.add(new User("Name3", "Second name3", "email3@mail.ru"));
    }
}
