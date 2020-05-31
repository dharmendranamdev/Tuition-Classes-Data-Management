
package user;

import java.sql.*;

public class Conne {
    Connection c;
    Statement s;
    public Conne()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c  = DriverManager.getConnection("jdbc:mysql:///tuitiondatamanagement","root","");
            //c  = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12283219","sql12283219","Lfqk28JhTy");
            s = c.createStatement();
        } catch (Exception ex) {
            
            System.out.println("Exception:"+ex);
        }
        
    }
   
    
}

