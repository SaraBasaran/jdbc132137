import java.sql.*;

public class ExecuteUpdate01 {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
        Statement statement=connection.createStatement();

        //1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees

        String sql1= "UPDATE companies\n" +
                "SET number_of_employees =16000\n" +
                "WHERE number_of_employees < (SELECT AVG(number_of_employees) FROM companies)";
       int numOfRows= statement.executeUpdate(sql1);//executeUpdate() returns number of records updated

        System.out.println("numOfRows" + " "+ numOfRows);

        String sql2= "SELECT * FROM companies";
        ResultSet resultSet= statement.executeQuery(sql2);

        while (resultSet.next()){

            System.out.println(resultSet.getObject(1) + " " +resultSet.getObject(2) +" "+ resultSet.getObject(3));

        }

        connection.close();
        statement.close();



    }




}
