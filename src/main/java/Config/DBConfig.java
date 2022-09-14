package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
//이녀석 불러줘야됨 숨어있음
@Configuration
@EnableTransactionManagement
//트렉직션 떄문에 필요한것!
public class DBConfig {
    private String dbclassName="com.mysql.cj.jdbc.Driver";

    private String url="jdbc:mysql://localhost:3307/role";

    private String userName="root";

    private String Password="kkjjss103@";

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(dbclassName);

        dataSource.setUrl(url);

        dataSource.setUsername(userName);

        dataSource.setPassword(Password);

        return dataSource;
    }
}
