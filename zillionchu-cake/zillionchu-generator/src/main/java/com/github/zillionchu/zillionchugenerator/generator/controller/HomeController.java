package com.github.zillionchu.zillionchugenerator.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
@RequestMapping("")
public class HomeController{


    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(Map<String,Object> map){
        return "index";
    }

    @RequestMapping(value = "about",method = RequestMethod.GET)
    public String about(){
        return "about";
    }
    @RequestMapping(value = "generator",method = RequestMethod.GET)
    public String user(){
        return "generator/list";
    }
    @RequestMapping(value = "gengertorsql",method = RequestMethod.GET)
    public String exce(){
        return "generatorSql/gengertorsql";
    }
}
