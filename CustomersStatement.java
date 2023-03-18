package SQL;

import java.sql.*;
import java.util.Scanner;

public class CustomersStatement {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
                PreparedStatement pstmt = conn.prepareStatement("insert into customers values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from customers where CustomerID LIKE 'F%'");

                Statement stmt = conn.createStatement();
        ){

            ResultSet rset = pstmtSelect.executeQuery();
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColumns = rsetMD.getColumnCount();
            for(int i=1; i<= numColumns; ++i ){
                System.out.printf("%-45s", rsetMD.getColumnName(i));
            }
            System.out.println();

            for(int i =1; i <= numColumns; ++i ){
                System.out.printf("%-45s",
                        "(" + rsetMD.getColumnClassName(i) +") ");
            }
            System.out.println();
            while (rset.next()){
                for(int i = 1; i <= numColumns; ++i){
                    System.out.printf("%-45s", rset.getString(i));
                }
                System.out.println();
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
