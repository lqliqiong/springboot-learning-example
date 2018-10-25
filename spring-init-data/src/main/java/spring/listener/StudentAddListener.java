package spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import spring.event.StudentAddEvent;

/**
 * @author: lq
 * @CreateTime:2018-10-13 10:16
 * @Description:todo
 */
@Component
public class StudentAddListener implements ApplicationListener {


    public void onApplicationEvent(ApplicationEvent _event) {
        if (!(_event instanceof StudentAddEvent)) {
            return;
        }
        StudentAddEvent studentAddEvent = (StudentAddEvent) _event;
        System.out.println("增加了学生:::" + studentAddEvent.getStudentName());
    }

}
