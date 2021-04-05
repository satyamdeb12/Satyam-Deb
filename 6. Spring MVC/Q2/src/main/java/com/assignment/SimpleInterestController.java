package com.assignment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SimpleInterestController {
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("simpleInterest");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/submit.html")
    public ModelAndView getValues(@RequestParam Map<String,String> reqParam){
        reqParam.entrySet().forEach(e->System.out.println(e.getValue()));
        int si = (Integer.parseInt(reqParam.get("amount"))*Integer.parseInt(reqParam.get("years"))*Integer.parseInt(reqParam.get("rate")))/100;
        ModelAndView modelAndView = new ModelAndView("displayResult");
        modelAndView.addObject("result",si);
        return  modelAndView;

    }

}
