import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.crypt.CryptCodecProvider;
import com.healthmarketscience.jackcess.crypt.InvalidCredentialsException;
import com.healthmarketscience.jackcess.impl.query.QueryImpl;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Result result = logWithPassword();
        try {
            // Open the database with the CryptCodecProvider
            Database db = new DatabaseBuilder(new File(result.path()))
                    .setCodecProvider(new CryptCodecProvider(result.passwordStr()))
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
        }
        catch (IOException e)
        {
            System.out.println("Error accessing database: " + e.getMessage());
        }
        catch (InvalidCredentialsException e)
        {
            System.out.println("Wrong password: " + e.getMessage());
        }

    }

    private static Result logWithPassword() {
        // Define the path to the database file
        String path = "C:\\Users\\daniele\\repo\\AccessDatabaseInterface\\sql\\db\\RecruitisLtdCRMgiorno2.accdb";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        char[] password = scanner.nextLine().toCharArray();

        String passwordStr=new String(password);
        System.out.println("Password is: " +passwordStr);
        Result result = new Result(path, passwordStr);
        return result;
    }

    private record Result(String path, String passwordStr) {
    }
}
