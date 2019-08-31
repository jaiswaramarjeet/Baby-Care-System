package com.babycare.doctor;

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

import com.babycare.admin.add_product;
import com.babycare.admin.admininsertname;
import com.babycare.pkg.login;



public class doctordao {
	
	JdbcTemplate j;

    public JdbcTemplate getJ() 
    {
        return j;
    }

    public void setJ(JdbcTemplate j) 
    {
        this.j = j;
    }
    public void addDoctor(doctor d)
    {
    	//String img2=req.getParameter("image").toString();
    	// System.out.println(img2);
    	j.update("insert into doctor values('"+d.getFull()+"','"+d.getGender()+"','"+d.getNo()+"','"+d.getTime()+"','"+d.getDay()+"','"+d.getAddress()+"','"+d.getArea()+"','"+d.getState()+"')");
    }

    
  /*---------------------------------------------check doctor list----------------------------------------------------------------*/	    
    public List<doctor>  checkDoctor(doctor d)
     {
     	//System.out.println("check admin"+ a.user+""+a.pass);
 	
     	String sql="select * from doctor";
    	List<doctor> productlist=j.query(sql,new RowMapper<doctor>()
     		{
     		
     			public doctor mapRow(ResultSet rs,int i)throws SQLException
     		{
     			doctor dt=new doctor();
     			dt.setFull(rs.getString("fullname"));
     			dt.setNo(rs.getString("mobile"));
     			dt.setGender(rs.getString("gender"));
     			dt.setTime(rs.getString("time"));
     			dt.setDay(rs.getString("day"));
     			dt.setAddress(rs.getString("address"));
     			dt.setArea(rs.getString("area"));
     			dt.setState(rs.getString("state"));
     		
     			return dt;
     			
     			
     		}
     		
     	});
    	return productlist;
     	
     }
     
/*----------------------------------------admin delete doctor data--------------------------------------------------*/
	public void delete_product(String name) 
  	{
        String sql = "DELETE FROM doctor WHERE fullname=?";
        j.update(sql, name);
    }

/*----------------------------------------user search doctor-------------------------------------------------------*/
    
	
	public List<doctor>  searchDoctor(doctor d)
	{
		
	
		String sql="select * from doctor where area='"+d.getArea()+"'";
		List<doctor> list=j.query(sql,new RowMapper<doctor>()
			{
			
				public doctor mapRow(ResultSet rs,int i)throws SQLException
			{
				doctor dt=new doctor();
				dt.setFull(rs.getString("fullname"));
     			dt.setNo(rs.getString("mobile"));
     			dt.setGender(rs.getString("gender"));
     			dt.setTime(rs.getString("time"));
     			dt.setDay(rs.getString("day"));
     			dt.setAddress(rs.getString("address"));
     			dt.setArea(rs.getString("area"));
     			dt.setState(rs.getString("state"));
				
				
				
				return dt;
							
			}
			
		});
		return list;
		
	}
	

 
	
}
