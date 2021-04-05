package com.assignment;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView registerForm(){
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("customer") Customer customer, BindingResult result){
        System.out.println(customer);
        if(result.hasErrors()){
            return new ModelAndView("registration");
        }
        return new ModelAndView("success");
    }

}
