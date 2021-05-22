package io.dracula.test.spring.seq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

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

    @TestMark
    @PostMapping("hello")
    public String sayHello(@Valid @RequestBody TestParam testParam){
        String msg = testParam.getMsg();
        logger.info("in controller, msg="+ msg);
        return "hello world, msg="+ msg;
    }

    static class TestParam {

        @NotEmpty(message = "消息不能空白")
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}
