package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") User user){
        userService.createUser(user);

        return "redirect:login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(value = "/loginsubmit", method = RequestMethod.POST)
    public ModelAndView display(@ModelAttribute("user") User user){
         User storedUser  = userService.getUserByUserName(user.getUserName());
         if(storedUser != null){
             if(storedUser.getPassword().equals(user.getPassword())){
                 return new ModelAndView("Success");
             }
         }
         return new ModelAndView("Error");
    }




}
