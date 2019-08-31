package com.babycare.babysitter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class babysitterdao {

	
	JdbcTemplate j;

    public JdbcTemplate getJ() 
    {
        return j;
    }

    public void setJ(JdbcTemplate j) 
    {
        this.j = j;
    }
    public void addBabysitter(babysitter b)
    {
    	//String img2=req.getParameter("image").toString();
    	// System.out.println(img2);
    	j.update("insert into babysitter values('"+b.getFull()+"','"+b.getNo()+"','"+b.getGender()+"','"+b.getAadhar()+"','"+b.getAddress()+"','"+b.getArea()+"','"+b.getState()+"')");
    }

    
  /*---------------------------------------------check babysitter list----------------------------------------------------------------*/	    
    public List<babysitter>  checkBabysitter(babysitter b)
     {
     	//System.out.println("check admin"+ a.user+""+a.pass);
 	
     	String sql="select * from babysitter";
    	List<babysitter> productlist=j.query(sql,new RowMapper<babysitter>()
     		{
     		
     			public babysitter mapRow(ResultSet rs,int i)throws SQLException
     		{
     			babysitter bs=new babysitter();
     			bs.setFull(rs.getString("fullname"));
     			bs.setNo(rs.getString("mobile"));
     			bs.setGender(rs.getString("gender"));
     			bs.setAadhar(rs.getString("aadhar"));
     		
     			bs.setAddress(rs.getString("address"));
     			bs.setArea(rs.getString("area"));
     			bs.setState(rs.getString("state"));
     		
     			return bs;
     			
     			
     		}
     		
     	});
    	return productlist;
     	
     }
     
/*----------------------------------------admin delete doctor data--------------------------------------------------*/
	public void delete_babysitter(String aadhar) 
  	{
        String sql = "DELETE FROM babysitter WHERE aadhar=?";
        j.update(sql, aadhar);
    }

/*----------------------------------------user search doctor-------------------------------------------------------*/
    
	
	public List<babysitter>  searchBabysitter(babysitter b)
	{
		
	
		String sql="select * from babysitter where area='"+b.getArea()+"'";
		List<babysitter> list=j.query(sql,new RowMapper<babysitter>()
			{
			
				public babysitter mapRow(ResultSet rs,int i)throws SQLException
			{
				babysitter bs=new babysitter();
				bs.setFull(rs.getString("fullname"));
     			bs.setNo(rs.getString("mobile"));
     			bs.setGender(rs.getString("gender"));
     			bs.setAadhar(rs.getString("aadhar"));
     			
     			bs.setAddress(rs.getString("address"));
     			bs.setArea(rs.getString("area"));
     			bs.setState(rs.getString("state"));
				
				
				
				return bs;
							
			}
			
		});
		return list;
		
	}
	

}
