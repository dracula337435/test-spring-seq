package io.dracula.test.spring.seq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dk
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @TestMark
    @GetMapping("hello")
    public String sayHello(){
        logger.info("in controller");
        return "hello world";
    }

}
