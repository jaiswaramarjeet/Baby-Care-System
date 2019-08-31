package com.babycare.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.babycare.pkg.login;



public class insert_name_dao {
	JdbcTemplate j;

    public JdbcTemplate getJ() 
    {
        return j;
    }

    public void setJ(JdbcTemplate j) 
    {
        this.j = j;
    }
    
    /*------------------------------------------add baby name-----------------------------------------------------*/
     public void addname(admininsertname admin)
    {
    	 System.out.println("asd");
    	 
        j.update("insert into name_suggesion values('"+admin.getGender()+"','"+admin.getReligion()+"','"+admin.getName()+"','"+admin.getMeaning()+"')");
    }
     
  /*----------------------------------------admin check all baby name list-----------------------------------------------*/
     public List<admininsertname>  Checknamelist(admininsertname a)
     {
     	//System.out.println("check admin"+ a.user+""+a.pass);
 	
     	String sql="select * from name_suggesion";
    	List<admininsertname> namelist=j.query(sql,new RowMapper<admininsertname>()
     		{
     		
     			public admininsertname mapRow(ResultSet rs,int i)throws SQLException
     		{
     			admininsertname aa=new admininsertname();    			
     			aa.setGender(rs.getString("gender"));
     			aa.setReligion(rs.getString("religion"));
     			aa.setName(rs.getString("name"));
     			aa.setMeaning(rs.getString("meaning"));
     			return aa;
     			
     			
     		}
     		
     	});
    	return namelist;
     	
     }
     
 /*----------------------------------------------admin delete baby_name from list--------------------------------------------*/
     
  	public void delete_Name(String nAme) 
  	{
        String sql = "DELETE FROM name_suggesion WHERE nAme=?";
        j.update(sql, nAme);
    }



/*---------------------------------------------user check baby_name------------------------------------------------------------*/

	public List<admininsertname>  Checknamelist2(admininsertname a)
	{
		//System.out.println("check admin"+ a.user+""+a.pass);
	
		String sql="select name,meaning from name_suggesion where gender='"+a.getGender()+"' and religion='"+a.getReligion()+"'";
		List<admininsertname> namelist=j.query(sql,new RowMapper<admininsertname>()
			{
			
				public admininsertname mapRow(ResultSet rs,int i)throws SQLException
			{
				admininsertname aa=new admininsertname();    			
				/*aa.setGender(rs.getString("gender"));
				aa.setReligion(rs.getString("religion"));*/
				aa.setName(rs.getString("name"));
				aa.setMeaning(rs.getString("meaning"));
				return aa;
							
			}
			
		});
		return namelist;
		
	}
	
	/*------------------------------------------------------Edit name list-----------------------------------------------------------------------------*/	
	public void editBabyName(admininsertname ain) {
	   
	        // update
	        String sql = "UPDATE name_suggesion SET gender=?, religion=?,meaning=? WHERE name=?";
	        j.update(sql, ain.getGender(), ain.getReligion(),ain.getMeaning(), ain.getName());
	    }
}
