import java.sql.*;
import java.util.*;

public class JDBCDemo {

	public static void main(String[] args) {
		try {
			int choice = 0;
			String qry, name;
			Scanner sc = new Scanner(System.in);
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://myfirst.accdb");
			Statement stment = conn.createStatement();
			conn.setAutoCommit(false);
			while (true) {
				System.out.println(
						"1.Display Table\n2.Insert Record\n3.Delete Record\n4.Update Record\n5.Commit Transaction\n6.Rollback Transaction\n7. DB META DATA\n8.RESULT SET META DATA\n9.Exit");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				switch (choice) {
					case 1:
						System.out.println("---------Displaying Table Records------------");
						qry = "SELECT * FROM MyTable";
						ResultSet rs = stment.executeQuery(qry);
						while (rs.next()) {
							String id = rs.getString("ID");
							String fname = rs.getString("Name");

							System.out.println("ID: " + id + "  Name: " + fname);
						}
						break;

					case 2:
						System.out.println("---------Insert Operation------------");
						System.out.print("enter the name to insert: ");
						name = sc.next();
						String sql = "INSERT INTO MyTable (Name) VALUES ('" + name + "')";
						int row = stment.executeUpdate(sql);
						if (row > 0)
							System.out.println("Record is inserted successfully");
						else
							System.out.println("Error in Record insertion");
						break;

					case 3:
						System.out.println("---------Delete Operation------------");
						System.out.print("Enter name to delete the record: ");
						name = sc.next();
						sql = "DELETE FROM MyTable where Name='" + name + "'";
						row = stment.executeUpdate(sql);
						if (row > 0)
							System.out.println("Record is deleted successfully");
						else
							System.out.println("Error!..record does not exist");
						break;

					case 4:
						System.out.println("---------Update Operation------------");
						System.out.print("Enter id number to update the record: ");
						int id = sc.nextInt();
						System.out.print("Enter Name to update in the record: ");
						name = sc.next();
						sql = "UPDATE MyTable " + "SET Name = '" + name + "'  WHERE id='" + id + "'";
						row = stment.executeUpdate(sql);
						if (row > 0)
							System.out.println("Record is updated successfully");
						else
							System.out.println("Error!..record does not exist");
						break;
					case 5:
						conn.commit();
						System.out.println("---------Transaction Updated permanently------------");

						break;
					case 6:
						conn.rollback();
						System.out.println("---------Transaction reversed before commit------------");
						break;

					case 7:
						System.out.println("---------METADATA OF DB------------");
						DatabaseMetaData dbmd = conn.getMetaData();
						System.out.println("database version:" + dbmd.getDatabaseProductVersion());
						System.out.println("database name:" + dbmd.getDatabaseProductName());
						System.out.println("numeric functions: " + dbmd.getNumericFunctions());
						break;

					case 8:
						System.out.println("---------METADATA OF RESULTSET------------");
						rs = stment.executeQuery("select * from MyTable");
						ResultSetMetaData rsmd = rs.getMetaData();
						int colcnt = rsmd.getColumnCount();
						System.out.println("No. of columns in the table: " + colcnt);
						System.out.println("Columns present in the table are:");
						for (int i = 1; i <= colcnt; i++) {
							System.out.print(rsmd.getColumnLabel(i) + "\t\t");

						}
						System.out.println();
						System.out.println("datatypes of the columns are:");
						for (int i = 1; i <= colcnt; ++i) {
							System.out.print(rsmd.getColumnTypeName(i) + "\t");
						}
						System.out.println();
						break;
					case 9:
						return;

					default:
						System.out.println("Invalid choice");

				}
			}
		} catch (Exception err) {
			System.out.println(err);
		}
	}

}