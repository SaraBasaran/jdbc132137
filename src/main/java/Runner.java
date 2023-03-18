public class Runner {

    public static void main(String[] args) {

        //1.step:Create the connection
        JDBCUtils.connectToDatabase();

        //2.step:Create Statement
        JDBCUtils.createStatement();

        //3.step: Execute Query
        JDBCUtils.execute("CREATE TABLE workers(worker_id VARCHAR(10), worker_name VARCHAR(50), worker_salary INT)");

        JDBCUtils.execute("ALTER TABLE workers ADD worker_address VARCHAR(100)");

        JDBCUtils.dropTable("workers");

        //4.step:Close connection and statement

        JDBCUtils.closeConnAndStatement();

    }



}
