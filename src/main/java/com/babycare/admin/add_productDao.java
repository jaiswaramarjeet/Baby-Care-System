package com.babycare.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.babycare.pkg.registration;

public class add_productDao {


		JdbcTemplate j;

	    public JdbcTemplate getJ() 
	    {
	        return j;
	    }

	    public void setJ(JdbcTemplate j) 
	    {
	        this.j = j;
	    }
	    public void addProduct(add_product add)
	    {
	    	//String img2=req.getParameter("image").toString();
	    	// System.out.println(img2);
	    	j.update("insert into products values('"+add.getId()+"','"+add.getName()+"','"+add.getImg()+"','"+add.getPrice()+"')");
	    }
	
/*---------------------------------------------check product list----------------------------------------------------------------*/	    
	    public List<add_product>  Checkproductlistlist(add_product add)
	     {
	     	//System.out.println("check admin"+ a.user+""+a.pass);
	 	
	     	String sql="select * from products";
	    	List<add_product> productlist=j.query(sql,new RowMapper<add_product>()
	     		{
	     		
	     			public add_product mapRow(ResultSet rs,int i)throws SQLException
	     		{
	     			add_product ad=new add_product();
	     			ad.setId(rs.getString("pid"));
	     			ad.setName(rs.getString("pname"));
	     			ad.setImg(rs.getString("image"));
	     			ad.setPrice(rs.getString("desc"));
	     		
	     			return ad;
	     			
	     			
	     		}
	     		
	     	});
	    	return productlist;
	     	
	     }
	     
/*----------------------------------------admin delete product---------------------------------------*/
		public void delete_product(String id) 
	  	{
	        String sql = "DELETE FROM products WHERE pid=?";
	        j.update(sql, id);
	    }

	    
	    
}



