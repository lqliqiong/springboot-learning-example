package spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import spring.event.StudentAddEvent;

/**
 * @author: lq
 * @CreateTime:2018-10-13 10:19
 * @Description:todo
 */
@Component
public class StudentAddBean implements ApplicationContextAware {
    private ApplicationContext m_applicationContext = null;
    public void setApplicationContext(ApplicationContext _applicationContext)
            throws BeansException {
        this.m_applicationContext = _applicationContext;
    }
    public void addStudent(String _sStudentName) {
        StudentAddEvent aStudentEvent = new StudentAddEvent(
                m_applicationContext, _sStudentName);
        m_applicationContext.publishEvent(aStudentEvent);
    }
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        StudentAddBean studentBean = (StudentAddBean) context
                .getBean("StudentAddBean");
        studentBean.addStudent("我是第一个学生");
        studentBean.addStudent("第二个学生已经添加");
    }
}
