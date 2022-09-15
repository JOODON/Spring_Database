package DTO.dao;

import DTO.Role;
import com.mysql.cj.xdevapi.Collection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import static DTO.dao.RoleDaoSql.*;
//스태틱으로 정의된 모든것을 가져올수 있음!
@Repository
//저장소라는 것을 선언해준다!
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc; //JDBC 템플릿을가져온것
    private SimpleJdbcInsert insertAction;
    //Insert 엑션을 구현하려고 선언해주는거
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource){
        //데이터 소스를 받아드려 JDBC안에다가 넣어주는거!
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction=new SimpleJdbcInsert(dataSource).withTableName("role");
        //어떤테이블에다가 넣을건가만 알려주면됨
    }
    public List<Role> selectAll(){
        return jdbc.query(SELECT_ALL, Collections.emptyMap(),rowMapper);
    }
    public int insert(Role role){
        SqlParameterSource params=new BeanPropertySqlParameterSource(role);
        //롤 객체에 있는걸 Map으로 바꿔줌
        return insertAction.execute(params);
    }

}
