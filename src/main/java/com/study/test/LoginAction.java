package com.study.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAction{   
    
    public String login(Connection conn, String name, int pas) {   
           
        PreparedStatement pst = null;   
        ResultSet rs = null;   
           
        try {   
            String sql = "select * from user where name = ? and pas = ?";   
            pst = conn.prepareStatement(sql);   
            pst.setString(1, name);   
            pst.setInt(2, pas);   
            rs = pst.executeQuery();   
               
            if(rs.next()) {   
                return "登陆成功。";   
            } else {   
                return "登陆失败。";   
            }   
               
        }catch(SQLException e) {   
            e.printStackTrace();   
            return "抛出异常。";   
        } finally {        
            try {   
                rs.close();   
                pst.close();   
            } catch (SQLException e) {   
                e.printStackTrace();   
            }   
        }   
    }   
  
}  
