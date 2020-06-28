package main;

import lombok.extern.slf4j.Slf4j;
import main.configuration.ConfigurationApp;
import main.entity.User;
import main.interfaces.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@Slf4j
public class SpringBootApp {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApp.class);
        UserService userService = context.getBean("userServiceImpl", UserService.class);

        User zhenia = new User("Zhenia", "Zsavinoww@gmail.com");
        log.info(userService.saveAndReturnCache(zhenia).toString());
        User zhenia2 = new User("Zhenia", "Zsavinoww@gmail.com");
        log.info(userService.saveAndReturnCache(zhenia2).toString());
        User zhenia3 = new User("Zhenia", "Zsavinoww@gmail.com");
        log.info(userService.saveAndRefreshCache(zhenia3).toString());
        User zhenia4 = new User("Zhenia", "Zsavinoww@gmail.com");
        log.info(userService.saveAndReturnCache(zhenia4).toString());

        log.info(userService.getUserById(zhenia.getId()).toString());
        log.info(userService.getUserById(zhenia2.getId()).toString());
        log.info(userService.getUserById(zhenia.getId()).toString());
        log.info(userService.getUserById(zhenia2.getId()).toString());
    }
}
