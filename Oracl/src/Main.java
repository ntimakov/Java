import java.sql.*;

        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Connection;
        import java.sql.SQLException;
        import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello world");
        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@altd01-prd-ibs:1521:altd", "SAS_AF_APP",
                    "qwerty$4");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }


        Statement stmt = null;
        String query = "select * from user_tables";
        try {
//            aaa= connection.
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String coffeeName = rs.getString("TABLE_NAME");
//	            int supplierID = rs.getInt("SUP_ID");
//	            float price = rs.getFloat("PRICE");
//	            int sales = rs.getInt("SALES");
//	            int total = rs.getInt("TOTAL");
                System.out.println(coffeeName  );
            }
            System.out.println("END!");
        } catch (SQLException e ) {
            System.out.println("Problems: "+e.getMessage());
//	        JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } }
        }
    }

}
