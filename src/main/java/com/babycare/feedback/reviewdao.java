package com.babycare.feedback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.babycare.pkg.login;

public class reviewdao {
	
	JdbcTemplate j;

    public JdbcTemplate getJ() 
    {
        return j;
    }

    public void setJ(JdbcTemplate j) 
    {
        this.j = j;
    }
     public void review(review r,HttpServletRequest req)
    {
    	 HttpSession http=req.getSession();
    	 String email=(String) http.getAttribute("email");	
    	 
        j.update("insert into review (email,review) values('"+email+"','"+r.getFeedback()+"')");
    }

     
/*-----------------------------------------------Admin all Feedback list-----------------------------------------------------------------*/
     public List<review>  feedvackList(review r)
     {	//System.out.println("check login"+ k.email+""+k.pass);
 	
     	String sql="select * from review";
     	List<review> projectlist=j.query(sql,new RowMapper<review>()
     		{
     		
     			public review mapRow(ResultSet rs,int i)throws SQLException
     		{
     			review re=new review();
     			re.setId(Integer.parseInt(rs.getString("rid")));
     			re.setEmil(rs.getString("email"));
     			re.setFeedback(rs.getString("review"));
     		//	aa.setGender(rs.getString("gender"))
     		
     			return re;
     			
     			
     		}
     		
     	});
     	
     	return projectlist;
     }
     


}
