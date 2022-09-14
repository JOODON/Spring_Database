package Main;

import Config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class DataSourecTest {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //공장처럼 어플리케이션을 불러주는 것을 만듬

        DataSource ds=ac.getBean(DataSource.class);
        //데이터 베이스를 구현하고 있는 실제 객체를 가져옴!
        Connection conn=null;
        try {
            conn=ds.getConnection();
            if (conn !=null){
                System.out.printf("접속 성공");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (conn != null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
