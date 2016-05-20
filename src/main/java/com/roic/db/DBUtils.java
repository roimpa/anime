package com.roic.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

 @Autowired
 private DataSource dataSource;
 
 @PostConstruct
 public void initialize(){
  try {
   Connection connection = dataSource.getConnection();
   Statement statement = connection.createStatement();
   //statement.execute("DROP TABLE IF EXISTS ANIME");
   statement.executeUpdate(
     "CREATE TABLE IF NOT EXISTS ANIME(" +
     "ID INTEGER Primary key, " +
     "NAME varchar(30) not null, " +
     "WATCHED INTEGER not null)"
     );
   statement.close();
   connection.close();
  }
  catch (SQLException e) {
   e.printStackTrace();
  }
 }
}