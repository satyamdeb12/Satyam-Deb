package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAOImpl implements UserDAO{

    NamedParameterJdbcTemplate template;


    @Autowired
    public void setTemplate(NamedParameterJdbcTemplate template) throws DataAccessException {
        this.template = template;
    }

    private SqlParameterSource getSqlParamByModel(User user){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if(user != null){
            parameterSource.addValue("username",user.getUserName());
            parameterSource.addValue("password", user.getPassword());
            parameterSource.addValue("email",user.getPassword());
        }
        return parameterSource;
    }

    private static final class UserMapper implements RowMapper {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setUserName(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            return user;
        }
    }

    @Override
    public void createUser(User user) {
        System.out.println(user);
        String query = "insert into user (username,password,email) values (:username, :password, :email)";
        template.update(query, getSqlParamByModel(user));
    }

    @Override
    public User getUserByUserName(String userName) {
        String query = "select * from user where username = :username";
        User user =  new User();
        user.setUserName(userName);
        return (User)template.queryForObject(query,getSqlParamByModel(user), new UserMapper());
    }
}
