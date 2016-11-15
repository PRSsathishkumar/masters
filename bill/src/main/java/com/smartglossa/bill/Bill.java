package com.smartglossa.bill;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String op = request.getParameter("operation");
	    String password = "root";
	    
	    if (op.equals("addProduct")) {
	        int productId = Integer.parseInt(request.getParameter("pid"));
	        String name = request.getParameter("pname");
	        float cost = Float.parseFloat(request.getParameter("cost"));
	        
	        // Add Product
            JSONObject obj = new JSONObject();
	        try {
	            Class.forName("com.mysql.jdbc.Driver") ;
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", password) ;
	            Statement stmt = conn.createStatement() ;
	            String query = "Insert into product value(" + productId + ", '" + name + "', " + cost +")";
	            stmt.execute(query) ;
	        } catch (Exception e) {
	            obj.put("Message","Error");
                response.getWriter().print(obj);
	        }
	    } else if (op.equals("getProduct")) {
	        int pid = Integer.parseInt(request.getParameter("pid"));
            JSONObject obj = new JSONObject();

	        try {
                Class.forName("com.mysql.jdbc.Driver") ;
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", password) ;
                Statement stmt = conn.createStatement() ;
                String query = "select * from product where productId = " + pid;
                ResultSet rs = stmt.executeQuery(query) ;
                if (rs.next())  {
                    obj.put("name", rs.getString(2));
                    obj.put("cost", rs.getFloat(3));
                }
                response.getWriter().print(obj);
            } catch (Exception e) {
                obj.put("Message","Error");
                response.getWriter().print(obj);
            }
	    } else if(op.equals("updateProduct")){
	    	    int productId = Integer.parseInt(request.getParameter("pid"));
		        String name = request.getParameter("name");
		        float cost = Float.parseFloat(request.getParameter("cost"));
		        JSONObject obj = new JSONObject();
		        try {
		            Class.forName("com.mysql.jdbc.Driver") ;
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", password) ;
		            Statement stmt = conn.createStatement() ;
		            String query = "Update product set name='" + name + "',cost= '" + cost + "'where productId= " + productId ;
		            stmt.execute(query) ;
		        } catch (Exception e) {
		            obj.put("Message","Error");
	                response.getWriter().print(obj);
		        }
	    }else if(op.equals("deleteProduct")){
	    	 int productId = Integer.parseInt(request.getParameter("pid"));
	    	 JSONObject obj = new JSONObject();
	    	 try {
		            Class.forName("com.mysql.jdbc.Driver") ;
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", password) ;
		            Statement stmt = conn.createStatement() ;
		            String query = "Delete from product where productId= " + productId ;
		            stmt.execute(query) ;
		        } catch (Exception e) {
		            obj.put("Message","Error");
	                response.getWriter().print(obj);
		        }
	    } else if(op.equals("getAllProduct")){
	    	JSONArray res = new JSONArray();
	    	try {
                Class.forName("com.mysql.jdbc.Driver") ;
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", password) ;
                Statement stmt = conn.createStatement() ;
                String query = "select * from product";
                ResultSet rs = stmt.executeQuery(query) ;
                while (rs.next())  {
                	JSONObject obj = new JSONObject();
                	obj.put("productId", rs.getInt(1));
                    obj.put("name", rs.getString(2));
                    obj.put("cost", rs.getFloat(3));
                    res.put(obj);
                }
                response.getWriter().print(res);
            } catch (Exception e) {
            	JSONObject obj = new JSONObject();
                obj.put("Message","Error");
                response.getWriter().print(obj);
            }
	    }
	    
	   
	    
	}

   

}