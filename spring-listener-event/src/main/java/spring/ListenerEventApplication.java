package spring;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import spring.bean.SpringContextHolder;
import spring.bean.StudentAddBean;
import spring.event.StudentAddEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;


@SpringBootApplication
@Slf4j
public class ListenerEventApplication  {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(ListenerEventApplication.class, args);

//        Environment env = SpringApplication.run(ListenerEventApplication.class, args).getEnvironment();
//        String port = env.getProperty("server.port", "8080");
//        String healthPort = env.getProperty("management.port", "9001");
//
//        log.info("Access URLs:\n----------------------------------------------------------\n\t"
//                        + "Local: \t\thttp://127.0.0.1:{}\n\t"
//                        + "External: \thttp://{}:{}\n\t"
//                        + "health: \thttp://{}:{}/health\n----------------------------------------------------------",
//                port,
//                InetAddress.getLocalHost().getHostAddress(),
//                port,
//                InetAddress.getLocalHost().getHostAddress(),
//                healthPort
//        );

//        1
        StudentAddBean studentBean = SpringContextHolder
                .getBean("studentAddBean");
        studentBean.addStudent("我是第一个学生");
        studentBean.addStudent("第二个学生已经添加");

//2
        StudentAddEvent aStudentEvent = new StudentAddEvent(
                SpringContextHolder.getApplicationContext(), "ceshi ");
        SpringContextHolder.getApplicationContext().publishEvent(aStudentEvent);
    }
}
