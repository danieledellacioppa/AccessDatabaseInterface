import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Define the JDBC connection parameters
        String url = "jdbc:ucanaccess://C:/Users/danie/Documents/RecruitisLtdCRM.accdb";
        String user = "";  // Leave blank if not required
        String password = "";  // Leave blank if not required

        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Define the SQL query
            String query = "SELECT * FROM Contacts";

            // Execute the query and get the results
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the results and print each record
            while (rs.next()) {
                int contactID = rs.getInt("ContactID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String companyName = rs.getString("CompanyName");
                String jobTitle = rs.getString("JobTitle");
                String emailAddress = rs.getString("EmailAddress");
                String phoneNumber = rs.getString("PhoneNumber");
                String address = rs.getString("Address");
                String notes = rs.getString("Notes");

                System.out.println(contactID + "\t" + firstName + "\t" + lastName + "\t" + companyName + "\t" + jobTitle + "\t" + emailAddress + "\t" + phoneNumber + "\t" + address + "\t" + notes);
            }

            // Close the connection and release resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}