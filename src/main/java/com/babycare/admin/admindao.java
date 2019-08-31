package com.babycare.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;



public class admindao {

	JdbcTemplate j;

    public JdbcTemplate getJ() 
    {
        return j;
    }

    public void setJ(JdbcTemplate j) 
    {
        this.j = j;
    }
    public List<admin>  Checkladmin(admin a)
    {
    	//System.out.println("check admin"+ a.user+""+a.pass);
	
    	String sql="select * from admin where username='"+a.getUser()+"' and password='"+a.getPass()+"'";
    	return j.query(sql,new RowMapper<admin>()
    		{
    		
    			public admin mapRow(ResultSet rs,int i)throws SQLException
    		{
    			admin aa=new admin();    			
    			aa.setUser(rs.getString("username"));
    			aa.setPass(rs.getString("password"));
    			return aa;
    			
    			
    		}
    		
    	});
    	
    }

}
