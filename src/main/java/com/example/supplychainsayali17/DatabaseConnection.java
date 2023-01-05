package com.example.supplychainsayali17;
import java.sql.*;
public class DatabaseConnection {
    private static final String databaseUrl="jdbc:mysql://localhost:3306/supply_chain_dec";
    private static final String user="root";
    private static final String password="SSD@28599sayu";

    public Statement getStatement(){
        Statement statement=null;
        Connection conn;
        try {
            conn = DriverManager.getConnection(databaseUrl, user, password);
            statement = conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        return statement;
    }
    public ResultSet getQueryTable(String query){
        Statement statement=getStatement();
        try{
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdateQuery(String query){
        Statement statement=getStatement();
        try{
            return statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //  public static void main(String[] args){
    //   DatabaseConnection databaseConnection=new DatabaseConnection();
    //   ResultSet rs = databaseConnection.getQueryTable("SELECT email,first_name FROM COSTUMER");
    //   try{
    //      while(rs.next()){
    //         System.out.println(rs.getString("email")+" "+rs.getString("first_name"));
    //     }
    //   }catch (Exception e){
    //    e.printStackTrace();
    //  }
    // }

}
