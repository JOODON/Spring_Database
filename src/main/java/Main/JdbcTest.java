package Main;

import Config.ApplicationConfig;
import DTO.Role;
import DTO.dao.RoleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcTest {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = ac.getBean(RoleDao.class);

        Role role=new Role();
        role.setRole_id(5);
        role.setDescription("DataBaseSpringtest");
        int count = roleDao.insert(role);

        System.out.println(count+"건 입력 하였습니다!");

//        Role resultRole=roleDao.selectById(4);
//
//        System.out.println(resultRole);
//
//        int deleteCount=roleDao.deleteById(3);
//
//        System.out.println(deleteCount+"건 삭제 하였습니다!");
    }
}
