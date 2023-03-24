package org.binknight.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1.0/api/")
public class InitRest {


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(){
        return "hello Shawn";
    }
}
