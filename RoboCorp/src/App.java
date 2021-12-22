/**
 * Hello world!
 *
 */

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App
{
    public static void main( String[] args )
    {
        var url = "jdbc:mysql://localhost:3306/RoboCorp";

        try (var con = DriverManager.getConnection(url, "sa", "");
             var stm = con.createStatement();
             var rs = stm.executeQuery("SELECT 1+1")) {

            if (rs.next()) {

                System.out.println(rs.getInt(1));
            }

        } catch (SQLException ex) {

            var lgr = Logger.getLogger(App.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}
