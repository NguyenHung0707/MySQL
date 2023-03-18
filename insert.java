package SQL;
import java.sql.*;
import java.util.Scanner;
public class insert {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
        ) {
            PreparedStatement pstmt = conn.prepareStatement("insert into customers values (?,?,?,?,?,?,?,?,?,?,?)");
            conn.setAutoCommit(false);
            Scanner Customer = new Scanner(System.in);
            System.out.println("Enter CustomerID: ");
            String CustomerID = Customer.nextLine();

            Scanner company = new Scanner(System.in);
            System.out.println("Enter ConpanyName: ");
            String ConpanyName = company.nextLine();

            Scanner contact = new Scanner(System.in);
            System.out.println("Enter ContactName: ");
            String ContactName = contact.nextLine();

            Scanner title = new Scanner(System.in);
            System.out.println("Enter ContactTitle: ");
            String ContactTitle = title.nextLine();

            Scanner address = new Scanner(System.in);
            System.out.println("Enter Address: ");
            String Address = address.nextLine();

            Scanner city = new Scanner(System.in);
            System.out.println("Enter City: ");
            String City = city.nextLine();

            Scanner region = new Scanner(System.in);
            System.out.println("Enter Region: ");
            String Region = region.nextLine();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter PostalCode: ");
            String PostalCode = sc.nextLine();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Country: ");
            String Country = scanner.nextLine();

            Scanner phone = new Scanner(System.in);
            System.out.println("Enter Phone: ");
            String Phone = phone.nextLine();

            Scanner fax = new Scanner(System.in);
            System.out.println("Enter Fax: ");
            String Fax = fax.nextLine();

            pstmt.setString(1, CustomerID);
            pstmt.setString(2, ConpanyName);
            pstmt.setString(3, ContactName);
            pstmt.setString(4, ContactTitle);
            pstmt.setString(5, Address);
            pstmt.setString(6, City);
            pstmt.setString(7, Region);
            pstmt.setString(8, PostalCode);
            pstmt.setString(9, Country);
            pstmt.setString(10, Phone);
            pstmt.setString(11, Fax);
            pstmt.addBatch();
            int[] Codes = pstmt.executeBatch();
            for (int code : Codes){
                System.out.println(code + " dòng bị ảnh hưởng");
            }
            System.out.println();
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
