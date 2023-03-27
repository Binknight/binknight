package org.binknight.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.StringJoiner;

@RestController
@RequestMapping(value = "/v1.0/api/")
public class InitRest {


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(){
        return "hello Shawn";
    }


    // 添加 API
    @RequestMapping(method = RequestMethod.GET, value = "/java")
    public String java() throws IOException, URISyntaxException {
        InputStream rs = InitRest.class.getResourceAsStream("/javaDco/0322.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(rs));
        StringJoiner txt = new StringJoiner("\n");
        while(reader.ready()) {
            txt.add(reader.readLine());
            System.out.println(reader.readLine());
        }
        return txt.toString();
    }
}
