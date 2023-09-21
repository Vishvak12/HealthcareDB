package Hospital;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class patient {
   private int id;
   private String name;
   private Date dateOfBirth;
   private String gender;
   private String address;
   private String phoneNumber;
   
   public patient(String name, Date dateOfBirth, String gender, String address, String phoneNumber) {
      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.gender = gender;
      this.address = address;
      this.phoneNumber = phoneNumber;
      
      try {
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "username", "password");
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO patient (name, dateOfBirth, gender, address, phoneNumber) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, name);
         stmt.setDate(2, dateOfBirth);
         stmt.setString(3, gender);
         stmt.setString(4, address);
         stmt.setString(5, phoneNumber);
         stmt.executeUpdate();
         ResultSet rs = stmt.getGeneratedKeys();
         if (rs.next()) {
            this.id = rs.getInt(1);
         }
      } catch (SQLException e) {
         System.out.println("Error inserting patient record: " + e.getMessage());
      }
   }
}  
   