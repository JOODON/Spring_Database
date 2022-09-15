package DTO.dao;
//여기에다가는 사용하려는 SQL쿼리를 넣어주면댐!
public class RoleDaoSql {
    public static final String SELECT_ALL="SELECT role_id,description FROM role order by role_id";
    public static final String UPDATE="UPDATE role set description = :description where role_id = :roleID" ;
}
