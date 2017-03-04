import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Vika on 03.03.2017.
 */
public class DAO {

    Connection conn ;
    Statement stmt  ;
   String sql = "SELECT id, name, soneme, age, book FROM new_table1";


    DAO(String DB_URL, String USER, String PASS) {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // getting Statement object to execute query
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getData(String sql) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("name");
                String last = rs.getString("soneme");
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }

            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample

