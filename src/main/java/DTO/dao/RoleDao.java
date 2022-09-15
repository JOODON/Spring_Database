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
import java.util.Map;

import static DTO.dao.RoleDaoSql.*;
//스태틱으로 정의된 모든것을 가져올수 있음!
@Repository
//저장소라는 것을 선언해준다!
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc; //JDBC 템플릿을가져온것
    private SimpleJdbcInsert insertAction;
    //Insert 엑션을 구현하려고 선언해주는거
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
    //template객체의 query메서드를 통해 결과값을 가져올 때,sql문에 따라 추출된 결과를 리턴받을 객체의 멤버변수에 적절하게 할당하기 위한 매핑수단!
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
    public int update(Role role){
        SqlParameterSource params=new BeanPropertySqlParameterSource(role);
        //얘는 자기가 알아서 Map이라는 객체로 바꿔주는데
        return jdbc.update(UPDATE,params);
    }
    public int deleteById(Integer id){
        Map<String, ?>params = Collections.singletonMap("role_id",id);
        //맵값으로 입력받는 아이디가 들어갈거같음!
        //하나만 가지고 사용할 경우에는 Map을 바로 사용하는것이 좋음
        //Map이 그냥 쿼리값 받아서 바꿔주는거인듯?!
        return jdbc.update(DELETE_BY_ROLE_ID,params);
    }
    public Role selectById(Integer id){
        try {
            Map<String, ?>params = Collections.singletonMap("role_id",id);
            return jdbc.queryForObject(SELECT_BY_ROLE_ID,params,rowMapper);
        }catch (EnumConstantNotPresentException e){
            return null;
        }
    }
}
