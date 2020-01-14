package cn.sueking.grpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    private static String host;
    private static int port = 50051;

    static {
        host = System.getenv("SERVER");
        if (StringUtils.isEmpty(host)) {
            host = "localhost";
        }
    }

    @Bean
    HelloWorldClient client() {
        return new HelloWorldClient(host, port);
    }

    @Autowired
    HelloWorldClient helloWorldClient;


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String name) {
        return helloWorldClient.greet(name);
    }
}
