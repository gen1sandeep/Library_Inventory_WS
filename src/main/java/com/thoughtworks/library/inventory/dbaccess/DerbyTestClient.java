package com.thoughtworks.library.inventory.dbaccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class DerbyTestClient {
 
public static void main(String[] args) {
 
Connection conn = null;
 
try {
Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//String url = "jdbc:derby://localhost:1527/inventorydb;create=true;user=admin;password=P@ssw0rd";
String url = "jdbc:derby://localhost:1527/inventorydb;user=admin;password=P@ssw0rd";
conn = DriverManager.getConnection(url);

} catch (Exception except) {
except.printStackTrace();
}
 
if (conn != null) {
System.out.println("connected");
 
ResultSet rs = null;
Statement smt1 = null;
Statement smt2 = null;
Statement smt3 = null;
int a = 0;
 
try {
smt1 = conn.createStatement();
smt2 = conn.createStatement();
smt3 = conn.createStatement();
a = smt1.executeUpdate("CREATE TABLE alltechstories (name VARCHAR(26), age INT)");
 
System.out.println("Table created");
 
a = smt2.executeUpdate("insert into alltechstories values ('Jack', 20)");
 
System.out.println("Values inserted");
 
rs = smt3.executeQuery("select * from alltechstories");
while (rs.next())
System.out.println("Values in the table are: "
+ rs.getString(1) + "," + rs.getString(2));
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}
}