package org.binknight.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1.0/api/")
public class InitRest {


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(){
        return "hello Shawn";
    }


    // 添加 API
    @RequestMapping(method = RequestMethod.GET, value = "/java")
    public String java() throws IOException {
        ClassPathResource resource = new ClassPathResource("/javaDco/0322.txt");
        Path path = Paths.get(resource.getURI());
        String collect = Files.lines(path).collect(Collectors.joining("\r\n"));
        return collect;
    }
}
