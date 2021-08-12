package name;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {

private String url = "DB URL" ;
private String username;
private String password;
Connection db = null;


public db (String Username, String Password) throws SQLException{
	this.username = Username;
	this.password = Password;
	
	try{
	Class.forName("org.postgresql.Driver");
	db = DriverManager.getConnection(url, Username, Password);
 	}
	catch (java.laqng.ClassNotFoundException e) {
            System.out.println(e.getMessage());
     }
}
 


public void addPerson(INT age){
	try {
	      Statement st = db.createStatement();
	      DatabaseMetaData dbm = db.getMetaData();
	      ResultSet tables = dbm.getTables(null, null, "Person", null);
	       if(tables.next()){
	         
	        }else{
	          ResultSet rs = st.executeQuery("CREATE TABLE Person (age  int   );");  
	            }
	            st.close();
	            }
	        catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage());
	        }try {
	            Statement st = db.createStatement();
	            
	            if(age<7 )
	            ResultSet rs2 = st.executeQuery("INSERT INTO Person(age););
	            rs2.close();
	            st.close();
	             if()
	             }
	            }
	        catch (java.sql.SQLException e) {
	        } 
	
}

 
public void selectInsertName(STRING mor){
       try {
           Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Person WHERE mor  ="+mor+"    ");
           while (rs.next()) {
            System.out.print("mor returned ");
            System.out.println(rs.getString(1));
            //2
            
           }
           rs.close();
           st.close();
           }
       catch (java.sql.SQLException e) {
           System.out.println(e.getMessage());
       }
   }
   

public void removesomeOne(STRING far){
       try {
           
           Statement st = db.createStatement();
           ResultSet rs = st.executeQuery("Delete FROM Person WHERE far  ="+far+"    " );
           rs.close();
           st.close();
           }
       catch (java.sql.SQLException e) {
           System.out.println(e.getMessage());
       }
   }
   


public void removeAll(){
try {	            
		Statement st = db.createStatement();
		ResultSet rs = st.executeQuery("DELETE * FROM Person");
			rs.close();
			st.close();
}
catch (java.sql.SQLException e) {
		}
	 }
 public void selectAll(){
        try {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Person");
            rs.close();
            st.close();
            }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
