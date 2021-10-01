package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManejadorConexion {
    private static Logger log = LogManager.getLogger(ManejadorConexion.class.getName());

    private final String BASEDATOS = "basehoy";
    private final String USUARIO = "pruebahoy";
    private final String CLAVE = "12345";

    private final String URL = "./bd/misvehiculos.db";

    public Connection conectarseSQL (){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/"+BASEDATOS, USUARIO, CLAVE);
            log.info("Se conecto a postgres");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            log.error("Informa error",e);
        }
        return null;
    }
    public Connection conectarse (){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:"+URL);
            log.info("Se conecto a SQLLITE");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            log.error("Informa error",e);
        }
        return null;
    }
    public void desconexion(Connection conexion){
        if (conexion!= null){
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
