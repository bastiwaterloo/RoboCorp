import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class H2Class {
    public static void main(String[] a) throws Exception {
        var url = "jdbc:h2:mem:";

        try (var con = DriverManager.getConnection(url);
             var stm = con.createStatement();
             var rs = stm.executeQuery("SELECT 1+1")) {

            if (rs.next()) {

                System.out.println(rs.getInt(1));
            }

        } catch (SQLException ex) {

            var lgr = Logger.getLogger(H2Class.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}