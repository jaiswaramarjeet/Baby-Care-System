package com.babycare.pkg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class namedao {
	JdbcTemplate j;

    public JdbcTemplate getJ() 
    {
        return j;
    }

    public void setJ(JdbcTemplate j) 
    {
        this.j = j;
    }
    public List<name>  chackname(name n)
    {	//System.out.println("check login"+ k.email+""+k.pass);
	
    	String sql="select * from name_suggesion where gender='"+n.getGender()+"'";
    	return j.query(sql,new RowMapper<name>()
    		{
    		
    			public name mapRow(ResultSet rs,int i)throws SQLException
    		{
    			name n1=new name();
    			n1.setGender(rs.getString("gender"));
    			n1.setName(rs.getString("name"));
    			
    			return n1;
    			
    			
    		}
    		
    	});
    	
    }


}
