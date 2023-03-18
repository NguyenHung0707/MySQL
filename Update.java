package SQL;
import java.sql.*;
import java.util.Scanner;
public class Update {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
        ) {
            PreparedStatement sqlUpdate = conn.prepareStatement("update customers set CustomerID = ? where CompanyName = ?");
            conn.setAutoCommit(false);

            Scanner customer = new Scanner(System.in);
            System.out.printf("CustomerID : ");
            String CustomerID = customer.nextLine();
            Scanner company = new Scanner(System.in);
            System.out.printf("CompanyName: ");
            String CompanyName = company.nextLine();
            sqlUpdate.setString(1, CustomerID);
            sqlUpdate.setString(2, CompanyName);
            sqlUpdate.addBatch();
            int[] sc = sqlUpdate.executeBatch();
            for (int i : sc) {
                System.out.println(i + " dong bị ảnh hưởng");
            }
            System.out.println();
            conn.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
