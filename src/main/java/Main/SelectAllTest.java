package Main;

import Config.ApplicationConfig;
import DTO.Role;
import DTO.dao.RoleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SelectAllTest {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //일단 이녀석은 어플리케이션 컨텐츠 가져올떄 가져온다고 생각
        RoleDao roleDao=ac.getBean(RoleDao.class);

        List<Role> list = roleDao.selectAll();

        for (Role role:list){
            System.out.println(role);
        }
    }
}
