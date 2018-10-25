package spring.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import spring.bean.StudentAddBean;

/**
 * @author: lq
 * @CreateTime:2018-10-13 10:15
 * @Description:todo
 */

public class StudentAddEvent extends ApplicationEvent {

    private static final long serialVersionUID = 20L;
    private String m_sStudentName;
    public StudentAddEvent(Object source, String _sStudentName) {
        super(source);
        this.m_sStudentName = _sStudentName;
    }
    public String getStudentName() {
        return m_sStudentName;
    }


}
