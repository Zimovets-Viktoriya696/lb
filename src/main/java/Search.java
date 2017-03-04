import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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

    public Person getSerch(){

        DAO dao = new DAO(DB_URL, USER, PASS);
        Person person = dao.getData(getQuery());
        printPerson(person);
        return person;
    }


    public static int getYear (){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        try {
            String age = reader.readLine();
            a = Integer.parseInt(age);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    private String getQuery(){
        String query = String.format("SELECT id, name, soneme, age, book FROM new_table1 where age = %s", getYear());
        return query;
    }

    public void printPerson(Person person){
        System.out.println(person.getAge() + " age " + person.getName() + " name " + person.getSurname() + " Surname " );
    }
}
