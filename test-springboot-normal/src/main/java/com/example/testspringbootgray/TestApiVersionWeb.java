package com.example.testspringbootgray;

import com.example.springbootgray.apiversion.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbm
 * @date 2024/3/811:07
 */
@RestController
@ApiVersion(value = 1)
@RequestMapping("/api/{version}")
public class TestApiVersionWeb {

    @GetMapping("/test")
    public String testVersion() {
        return  "test version 1";
    }
}
