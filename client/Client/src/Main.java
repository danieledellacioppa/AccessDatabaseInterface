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
        String path = "C:\\Users\\daniele\\repo\\AccessDatabaseInterface\\sql\\db\\RecruitisLtdCRMgiorno2.accdb";
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
                String firstName = (String) row.get("first_name");
                String lastName = (String) row.get("last_name");
                String companyName = (String) row.get("email");
                String jobTitle = (String) row.get("contact");
                String emailAddress = (String) row.get("Company");
                String phoneNumber = (String) row.get("Risk");
                String address = (String) row.get("Status");
//                String notes = (String) row.get("Notes");

                System.out.println(contactID + "\t" + firstName + "\t" + lastName + "\t" + companyName + "\t" + jobTitle + "\t" + emailAddress + "\t" + phoneNumber + "\t" + address);
            }

            // Close the database
            db.close();
        } catch (IOException e) {
            System.out.println("Error accessing database: " + e.getMessage());
        }
    }
}
