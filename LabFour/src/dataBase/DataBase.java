package dataBase;
import java.sql.*;
import java.util.Scanner;

public class DataBase
{
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public DataBase(Connection conn, Statement stmt)
    {
        this.conn = conn;
        this.stmt = stmt;
    }

    public void serverServiceProc() throws SQLException
    {
        Scanner scanner = new Scanner(System.in);
        String command;
        String[] tokens;

        DatabaseMetaData metaData = conn.getMetaData();

        while (true)
        {
            String input = scanner.nextLine().replaceAll("\\s+"," ");
            tokens = input.split(" ");

            if (tokens.length == 0)
            {
                System.out.println("Invalid input");
            }
            else
            {
                processCommand(tokens);
            }
        }
    }

    private static void processCommand(String[] tokens) throws SQLException
    {
        switch (tokens[0])
        {
            case "/add":
                if (tokens.length != 3)
                {
                    System.out.println("Invalid input");
                    return;
                }

                try
                {
                    Integer.parseInt(tokens[2]);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid price input");
                    return;
                }

                rs = stmt.executeQuery("SELECT * FROM products");
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next())
                {
                    if (rs.getString(3).equals(tokens[1]))
                    {
                        System.out.println("There is already a product whit this name");
                        return;
                    }
                }

                String command = "INSERT INTO products VALUE(" +
                        getRowsCount() + ", " + getRowsCount() + ", \"" + tokens[1] + "\", " + tokens[2] + ");";
                stmt.executeUpdate(command);

                break;

            case "/delete":
                if (tokens.length != 2)
                {
                    System.out.println("Invalid input");
                    return;
                }

                command = "DELETE FROM products WHERE title = " + tokens[1] + ";";
                stmt.executeUpdate(command);

                break;

            case "/show_all":
                rs = stmt.executeQuery("SELECT * FROM products");
                rsmd = rs.getMetaData();
                while (rs.next())
                {
                    for (int i = 1; i <= rsmd.getColumnCount(); i++)
                    {
                        System.out.print(rs.getString(i) + " ");
                        if (i % 4 == 0)
                        {
                            System.out.println("");
                        }
                    }
                }
                break;

            case "/price":
                if (tokens.length != 2)
                {
                    System.out.println("Invalid input");
                    return;
                }

                command = "SELECT cost FROM products WHERE title = '" + tokens[1] + "';";
                rs = stmt.executeQuery(command);
                if (rs.next())
                {
                    System.out.println("Price of this product: " + rs.getString(1));
                }
                else
                {
                    System.out.println("There is no such a product");
                }

                break;

            case "/change_price":
                if (tokens.length != 3)
                {
                    System.out.println("Invalid input");
                    return;
                }

                try
                {
                    Integer.parseInt(tokens[2]);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid price input");
                    return;
                }

                command = "UPDATE products SET cost = " + tokens[2] + " WHERE title = '" + tokens[1] + "';";
                stmt.executeUpdate(command);

                break;

            case "/filter_by_price":
                if (tokens.length != 3)
                {
                    System.out.println("Invalid input");
                    return;
                }

                try
                {
                    int min = Integer.parseInt(tokens[1]);
                    int max = Integer.parseInt(tokens[2]);
                    int price;

                    rs = stmt.executeQuery("SELECT * FROM products");
                    rsmd = rs.getMetaData();
                    while (rs.next())
                    {
                        price = Integer.parseInt(rs.getString(4));
                        if (min <= price && price <= max)
                        {
                            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                            {
                                System.out.print(rs.getString(i) + " ");
                                if (i % 4 == 0)
                                {
                                    System.out.println("");
                                }
                            }
                        }
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid integer input");
                    return;
                }
                break;

            default:
                System.out.println("Invalid input");
                return;

        }
    }

    private static int getRowsCount() throws SQLException
    {
        rs = stmt.executeQuery("SELECT * FROM products");
        int count = 0;

        while (rs.next())
        {
            count++;
        }

        return count++;
    }
}
