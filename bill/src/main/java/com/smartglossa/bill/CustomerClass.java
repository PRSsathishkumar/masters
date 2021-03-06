package com.smartglossa.bill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

public class CustomerClass {
    Connection con = null;
    Statement stat = null;
    ResultSet rs = null;

    public CustomerClass() throws ClassNotFoundException, SQLException {
        openConnection();
 
    }

    public void cusAdd(int cid, String cname, String caddr, String cphno) throws ClassNotFoundException, SQLException {
        try {
            String query = "insert into customer(customerId,name,address,phonenumber)values(" + cid + ",'" + cname
                    + "','" + caddr + "'," + cphno + ")";
            stat.execute(query);
        } finally {
            closeConnection();
        }
    }

    public void cusUpdate(int cid, String cname, String caddr, String cphno)
            throws ClassNotFoundException, SQLException {
        try {
            String query = "update customer set name=' " + cname + " ',address=' " + caddr + " ',phonenumber=" + cphno
                    + " where customerId=" + cid;
            stat.execute(query);
        } finally {
            closeConnection();
        }
    }

    public void cusDelete(int cid) throws ClassNotFoundException, SQLException {
        try {
            String query = "delete from customer where customerId=" + cid;
            stat.execute(query);
        } finally {
            closeConnection();
        }
    }

    public JSONObject cusOne(int id) throws ClassNotFoundException, SQLException {
        JSONObject result = new JSONObject();
        try {
            String query = "select * from customer where customerId=" + id;
            rs = stat.executeQuery(query);
            if (rs.next()) {
                result.put("name", rs.getString("name"));
                result.put("address", rs.getString("address"));
                result.put("phonenumber", rs.getString("phonenumber"));
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public JSONArray cusAll() throws ClassNotFoundException, SQLException {
        JSONArray result = new JSONArray();
        try {
            String query = "select * from customer";
            rs = stat.executeQuery(query);
            while (rs.next()) {
                JSONObject get = new JSONObject();
                get.put("cid", rs.getInt("customerId"));
                get.put("name", rs.getString("name"));
                get.put("address", rs.getString("address"));
                get.put("phonenumber", rs.getString("phonenumber"));
                result.put(get);
            }

        } finally {
            closeConnection();
        }
        return result;

    }
    public void customerAdd(int cid,int saleId) throws ClassNotFoundException,SQLException {
    	try {
    		String query="insert into customerBill(customerId,saleId)values("+cid+","+saleId+")";
    		stat.execute(query);
			
		} finally {
			
			closeConnection();
			
		}
	}
    
    
    
    
    

    public JSONArray cusale(int cuid) throws ClassNotFoundException, SQLException {
        JSONArray result = new JSONArray();
        try {
            String query = "select saleId from customerbill where customerId=" + cuid;
            rs = stat.executeQuery(query);
            while (rs.next()) {
                int saleId = rs.getInt("saleId");
                String queryy = "select * from salemetadata,salelineitems,salepayment where salemetadata.saleId="
                        + saleId + " AND salelineitems.saleId =" + saleId + " AND salepayment.saleId =" + saleId;
                rs = stat.executeQuery(queryy);
                while (rs.next()) {
                    JSONObject obj = new JSONObject();
                    obj.put("billDate", rs.getDate("billDate"));
                    obj.put("vat", rs.getFloat("vat"));
                    obj.put("discount", rs.getFloat("discount"));
                    obj.put("billTotal", rs.getFloat("billTotal"));
                    obj.put("saleLineId", rs.getInt("saleLineId"));
                    obj.put("productId", rs.getInt("productId"));
                    obj.put("quantity", rs.getFloat("quantity"));
                    obj.put("cost", rs.getFloat("cost"));
                    obj.put("payId", rs.getInt("payId"));
                    obj.put("payDate", rs.getDate("payDate"));
                    obj.put("paidAmount", rs.getFloat("paidAmount"));
                    result.put(obj);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    private void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://" + BillConstants.MYSQL_SERVER + "/" + BillConstants.DATABASE,
                BillConstants.USERNAME, BillConstants.PASSWORD);
        stat = con.createStatement();
    }

    private void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
        if (stat != null) {
            stat.close();
        }
        if (rs != null) {
            rs.close();
        }

    }
}
