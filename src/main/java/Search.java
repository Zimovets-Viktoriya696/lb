/**
 * Created by Vika on 03.03.2017.
 */
public class Search {

    private Person person;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/new_bd";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    private Person getSerch(String query){
        String sql = "SELECT id, name, soneme, age, book FROM new_table1";

        DAO dao = new DAO(DB_URL, USER, PASS);
        dao.getData(sql);
        return null;
    }

}
