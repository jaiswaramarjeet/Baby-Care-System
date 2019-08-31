package com.babycare.pkg;
import org.springframework.jdbc.core.JdbcTemplate;

public class regdao {
	JdbcTemplate j;

    public JdbcTemplate getJ() 
    {
        return j;
    }

    public void setJ(JdbcTemplate j) 
    {
        this.j = j;
    }
     public void adduser(registration l)
    {
    	 
    	 
        j.update("insert into user values('"+l. getFull()+"','"+l.getEmail()+"','"+l. getPass()+"','"+l.getNo()+"','"+l.getGender()+"','"+l.getAddress()+"','"+l.getState()+"','"+l.getCountry()+"')");
    }


}
