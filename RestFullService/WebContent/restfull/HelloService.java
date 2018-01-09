package com.valuelabs.restfull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



@Path("/helloService")
public class HelloService {
	
	@GET
	@Path("/sayHello")
	@Produces("text/html")
	public String sayHello(@QueryParam("name") String name , @QueryParam("age") String age){
		return name+" toooooooooooooooooooo age is:"+age;
	}
	@GET
	@Path("/getEmployeeId/{eid}")
	@Produces(MediaType.APPLICATION_XML)
	public void getEmployee(@PathParam("eid") int eid){
		
		Configuration cfg = new Configuration();
		cfg.configure("/RestFullService/WebContent/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
	
		employee.setEid(eid);
		employee.setAge(28);
		
		session.save(employee);
		System.out.println("data inserted");
		
		
		
		/*Connection con = ConnectionFactory.getConnection();
		Employee emp=null;
		try{
			System.out.println(eid);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("Select * from employee where eid='"+eid+"'");
			System.out.println(rs);
			
			if(rs.next()){
				System.out.println("$$$$");
				emp=new Employee();
				emp.setEid(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getInt(3));
			}
		}catch(Exception e){
			System.out.println(e);
		}	
		
		return emp;*/
		
	}
	
	
	@GET
	@Path("/getAllEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getAllEmployees(){
		
		Connection con = ConnectionFactory.getConnection();
		Employee emp=null;
		try{
			//System.out.println(eid);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("Select * from employee");
			System.out.println(rs);
			
			if(rs.next()){
				System.out.println("$$$$");
				emp=new Employee();
				emp.setEid(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getInt(3));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return emp;
	}

	@POST
	@Path("/setEmployeeId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee setEmployee(@QueryParam("eid") int eid, @QueryParam("name") String name, @QueryParam("salary") int salary,@QueryParam("age") int age){
		
		Connection con = ConnectionFactory.getConnection();
		Employee emp=null;
		boolean result = false;
		System.out.println("Employee details inserted");
		
		try{
			Statement statement = con.createStatement();
			result= statement.execute("Insert into Employee  values ('"+ eid + "','" + name + "','" + salary + "','"+age+"')");
			
			
		}catch(Exception e){ 
			System.out.println(e);
		}
		return emp;
	}
	
	@POST
	@Path("/setEmployeeIdwithJSON")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee setEmployeewithObj(Employee employee){
		
		Connection con = ConnectionFactory.getConnection();
		System.out.println("Employee details inserted");
		
		try{
			Statement statement = con.createStatement();
			statement.execute("Insert into Employee  values ('"+ employee.getEid() + "','" + employee.getName() + "','" + employee.getSalary() + "','"+employee.getAge()+"')");
			
			
		}catch(Exception e){ 
			System.out.println(e);
		}
		return employee;
	}
}
