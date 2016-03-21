import java.util.*;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SendMailToUser
{
   public void sendMail(String [] args)
   {      
	     String url = "jdbc:mysql://localhost:3306/";  
	     String dbName = "form";  
	     String driver = "com.mysql.jdbc.Driver";  
	     String userName = "root";  
	     String password = "root";
	     Boolean uFlag = false;
	     Boolean eFlag = false;
	     java.sql.Date d;
	    
//	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	     Date date = new Date();   
	     String dateFormat = DateFormat.getDateTimeInstance(
	     DateFormat.MEDIUM, DateFormat.SHORT).format(date);
        
      //  Date AuctionDate= dateFormat.format(date);
        
        d = convertJavaDateToSqlDate(dateFormat);  
        ResultSet rs ;
	  try {
        Class.forName(driver);
      Connection conn = DriverManager.getConnection(url + dbName, userName, password);
      PreparedStatement pst = conn.prepareStatement("select ad.firstname, ad.lastname, ad.emailid,"
	            		+ "ah.auctionid, ah.winningbid"
	            		+ "from auctionhistory ah, accountdetails ad"
	            		+ "where ah.userid= ad.buyerid,"
	            		+ " Auctiondate = ?");
			    pst.setDate(1, d);   // change this to date format
			    rs = pst.executeQuery();
	  }catch(Exception e){ 
		  System.out.println("Error: " + e);
	  }
			    
			    try {
					while (rs.next()) {
						String firstName = rs.getString(1);
						String lastName =  rs.getString(2);
						String to = rs.getString(3);
						Integer auctionid = rs.getInt(4);
						Float bid = rs.getFloat(5);
						
						try {
						// Sender's email ID needs to be mentioned
					    String from = "web@gmail.com";

					    // Assuming you are sending email from localhost
					    String host = "localhost";

					    // Get system properties
					    Properties properties = System.getProperties();

					    // Setup mail server
					    properties.setProperty("mail.smtp.host", host);

					    // Get the default Session object.
					    Session session = Session.getDefaultInstance(properties);

					    
					       // Create a default MimeMessage object.
					       MimeMessage message = new MimeMessage(session);

					       // Set From: header field of the header.
					       message.setFrom(new InternetAddress(from));

					       // Set To: header field of the header.
					       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					       // Set Subject: header field
					       message.setSubject("You won the auction");
					       
					       // Now set the actual message
					       message.setText("This is actual message");

					       // Send message
					       Transport.send(message);
					       System.out.println("Sent message successfully....");
					    }
					    
						catch (MessagingException mex) {
					        mex.printStackTrace();
					     }
   
						
}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  //while
   }

	private java.sql.Date convertJavaDateToSqlDate(String dateFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date sDate = new java.util.Date();
		try {
			sDate = formatter.parse(dateFormat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return (new java.sql.Date(sDate.getTime()));
	}
}

