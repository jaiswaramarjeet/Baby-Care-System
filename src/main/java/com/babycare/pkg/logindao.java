package com.babycare.pkg;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.babycare.admin.admininsertname;

public class logindao {
	JdbcTemplate j;

    public JdbcTemplate getJ() 
    {
        return j;
    }

    public void setJ(JdbcTemplate j) 
    {
        this.j = j;
    }
 
    
    
    /*---------------------------------user login ---------------------------------------------------------------*/   
    public List<login>  Checklogin(login k)
    {	//System.out.println("check login"+ k.email+""+k.pass);
	
    	String sql="select * from user where email='"+k.getEmail()+"' and password='"+k.getPass()+"'";
    	return j.query(sql,new RowMapper<login>()
    		{
    		
    			public login mapRow(ResultSet rs,int i)throws SQLException
    		{
    			login l=new login();
    			
    			l.setEmail(rs.getString("email"));
    			l.setPass(rs.getString("password"));
    		
    			return l;
    			
    			
    		}
    		
    	});
    	
    }
/*---------------------------------------user check profile data-----------------------------------------------------------*/    
    public List<login>  Checkprofile(HttpServletRequest res)
    {	//System.out.println("check login"+ k.email+""+k.pass);
    	
    	
    	HttpSession http=res.getSession();
    	String email=(String) http.getAttribute("email");
   
    	return j.query("select * from user where email='"+email+"'",new ResultSetExtractor<List<login>>()
    	
    	
    		{
    			
				public List<login> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<login> list=new ArrayList<login>();
					while(rs.next()) {
						
						login l=new login();
						l.setFull(rs.getString("fullname"));
						l.setEmail(rs.getString("email"));
						l.setPass(rs.getString("password"));
						l.setMobile(rs.getString("mobile"));
						l.setGender(rs.getString("gender"));
						l.setAddress(rs.getString("address"));
						l.setState(rs.getString("state"));
						l.setCountry(rs.getString("country"));
						list.add(l);
					}
					
					return list;
				}
    		
    		
    	});
    	
    }
    
/*------------------------------------------------------Change Password-----------------------------------------------------------------*/	
	/*public void changePassword(login k) {
	   
	        // update
	        String sql = "UPDATE user SET password=? WHERE email=?";
	        j.update(sql,k.getPass(),k.getEmail());
	    }*/
    
    /*------------------------------------show all user details------------------------------------------------*/   
    public List<login>  Checkalluserdetails(login k)
    {	//System.out.println("check login"+ k.email+""+k.pass);
	
    	String sql="select * from user";
    	List<login> projectlist=j.query(sql,new RowMapper<login>()
    		{
    		
    			public login mapRow(ResultSet rs,int i)throws SQLException
    		{
    			login l=new login();
    			l.setFull(rs.getString("fullname"));
    			l.setEmail(rs.getString("email"));
    			l.setPass(rs.getString("password"));
    			l.setMobile(rs.getString("mobile"));
    			l.setGender(rs.getString("gender"));
    			l.setAddress(rs.getString("address"));
    			l.setState(rs.getString("state"));
    			l.setCountry(rs.getString("country"));
    			return l;
    			
    			
    		}
    		
    	});
    	
    	return projectlist;
    }
    
    
  /*----------------------------------------------admin_delete user details------------------------------------------------*/

    
    	public void delete_Row(String eMail) {
        String sql = "DELETE FROM user WHERE email=?";
        j.update(sql, eMail);
    }
}