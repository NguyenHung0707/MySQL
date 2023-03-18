package SQL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Delete {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
        ) {
            PreparedStatement sqlDelete = conn.prepareStatement("delete from customers where CustomerID = ?");
            conn.setAutoCommit(false);

            Scanner Customer = new Scanner(System.in);
            System.out.println("Enter CustomersID: ");
            String CustomerID = Customer.nextLine();
            sqlDelete.setString(1, CustomerID);
            sqlDelete.addBatch();
            int[] sc = sqlDelete.executeBatch();
            for (int i :sc) {
                System.out.println(i + " dòng bị ảnh hưởng");
            }
            System.out.println();
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
