import java.io.*;
import java.sql.*;

public class DatabaseHandling {
    public static void main(String[] args){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root",""); //Making a connection to the database server
            Statement smt = con.createStatement();
            create(con); read(smt);
            update(smt); delete(smt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
  
    //Deleting record from table operation
    private static void delete(Statement smt) throws SQLException {
        int res = smt.executeUpdate("delete from student where name='logi'");
        System.out.println((res==1)?"Deleted record":"record not exist");
    }
  
    //Updating existing record in table operation
    private static void update(Statement smt) throws SQLException {
        int res = smt.executeUpdate("update student set name='logi' where name='logeetha' ");
        System.out.print( (res==1)?"Updated":"record not exist");
    }
  
    //Reading the records present in the table
    private static void read(Statement smt) throws SQLException, IOException {
        ResultSet rs = smt.executeQuery("Select * from student");
        while(rs.next()){
            System.out.println("Id : "+ rs.getInt(1));
            System.out.println("Name : "+ rs.getString(2));
            System.out.println("Department : "+ rs.getString(3));

            Blob b = rs.getBlob(4);
            DataInputStream dis = new DataInputStream(b.getBinaryStream());
            int i;
            while( (i=dis.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println("\n----------------------------------------------------------\n");
        }

    }
  
    //Inserting new record into the table
    private static void create(Connection con) throws SQLException, FileNotFoundException {
        PreparedStatement ps = con.prepareStatement("insert into student(id,name,department,about) values(?,?,?,?)");
        ps.setInt(1,2);
        ps.setString(2,"logeetha");
        ps.setString(3,"cse");

        File f = new File("C:\\Users\\niththish A\\Downloads\\student-about.bin");
        ps.setBinaryStream(4,new FileInputStream(f));

        int res = ps.executeUpdate();
        System.out.println(res==1?"Inserted data":"Unable to insert");
    }
}
