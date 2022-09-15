package DTO.dao;
//여기에다가는 사용하려는 SQL쿼리를 넣어주면댐!
public class RoleDaoSql {
    public static final String SELECT_ALL="SELECT role_id,description FROM role order by role_id";
    public static final String UPDATE="UPDATE role set description = :description where role_id = :role_id" ; //:부분이 값으로 바인딩 될 값!

    public static final String SELECT_BY_ROLE_ID="SELECT role_id,description From role where role_id = :role_id"; //컬럼 명을 정확하게 사용하는걸 추천!

    public static final String DELETE_BY_ROLE_ID="DELETE FROM role WHERE role_id = :role_id" ;
}
