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

//-----------------------------------인설트 부분----------------------------------------------------
        Role role=new Role();
//        role.setRole_id(6);
//        role.setDescription("DataBaseSpringLasttest");
//        int count = roleDao.insert(role);
//        System.out.println(count+"건 입력 하였습니다!");
//-----------------------------------업데이트 부분----------------------------------------------------
//        role.setRole_id(4);
//        role.setDescription("resultSpringUpTest");
//        int upcount= roleDao.update(role);
//        System.out.println(upcount+"건 수정 하였습니다!");
//-----------------------------------찾기 부분----------------------------------------------------
//        Role resultRole=roleDao.selectById(2);
//
//        System.out.println(resultRole);
//-----------------------------------삭제 부분----------------------------------------------------
        int deleteCount=roleDao.deleteById(2);

        System.out.println(deleteCount+"건 삭제 하였습니다!");

    }
}
