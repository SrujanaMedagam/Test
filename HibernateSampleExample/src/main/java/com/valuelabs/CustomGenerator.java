package com.valuelabs;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.mysql.jdbc.Connection;

public class CustomGenerator implements IdentifierGenerator{
	
	
	private String defaultPrefix = "R&D";
	 private int defaultNumber = 1;


	public Serializable generate(SessionImplementor session, Object arg1) throws HibernateException {
		System.out.println("custom generator");
		 String id = "";
		  String digits = "";
		   String prefix = null ;
		  Connection con = (Connection) session.connection();
		  try {
		   java.sql.PreparedStatement pst = con
		     .prepareStatement("select id from employee ");
		   ResultSet rs = pst.executeQuery();
		   if (rs != null && rs.next()) {
			   id = rs.getString("id");
		    System.out.println(id);
		    prefix = "emp_";
		    id=prefix+id;
		   /* String str[] = id.split(prefix);
		    digits = String.format("%06d", Integer.parseInt(str[1]) + 1);
		    id = prefix.concat(digits);*/
		   } else {
		    digits = String.format("%06d", defaultNumber);
		    id = prefix+id;
		   }
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return id;
	}

}
