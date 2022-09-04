package com.service.hotplace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class test {

	public static void main(String args[]) throws SQLException, ClassNotFoundException{

        String query;

        // Connect to system Database first
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        Connection con = DriverManager.getConnection(url,"system","####");
        java.sql.Statement statement = con.createStatement();  
        query = "alter user HR identified by HR account unlock";

        //Unlock the account
        ResultSet resultset = statement.executeQuery(query);

        //Connect to HR database
        con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","bnk","bnk");
        statement = con.createStatement();  

        //Fetch all the tables in HR database
        query = "select 'Connected' from dual";
        resultset = statement.executeQuery(query);

        //Prints records fetched
        while (resultset.next()) {
               System.out.println(resultset.getString(1));
        }        

        statement.close();  
        con.close();  

 }
}
