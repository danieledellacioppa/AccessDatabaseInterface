import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.crypt.CryptCodecProvider;
import com.healthmarketscience.jackcess.impl.query.QueryImpl;

import java.io.File;
import java.io.IOException;
import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Define the path to the database file
        String path = "C:\\Users\\daniele\\repo\\AccessDatabaseInterface\\sql\\db\\RecruitisLtdCRM.accdb";
        String password = "pippo";

        try {
            // Open the database with the CryptCodecProvider
            Database db = new DatabaseBuilder(new File(path))
                    .setCodecProvider(new CryptCodecProvider(password))
                    .open();

            // Query the database
            Table contactsTable = db.getTable("Contacts");
            for (Row row : contactsTable) {
                int contactID = (Integer) row.get("ContactID");
                String firstName = (String) row.get("FirstName");
                String lastName = (String) row.get("LastName");
                String companyName = (String) row.get("CompanyName");
                String jobTitle = (String) row.get("JobTitle");
                String emailAddress = (String) row.get("EmailAddress");
                String phoneNumber = (String) row.get("PhoneNumber");
                String address = (String) row.get("Address");
                String notes = (String) row.get("Notes");

                System.out.println(contactID + "\t" + firstName + "\t" + lastName + "\t" + companyName + "\t" + jobTitle + "\t" + emailAddress + "\t" + phoneNumber + "\t" + address + "\t" + notes);
            }

            // Close the database
            db.close();
        } catch (IOException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        }
    }
}
