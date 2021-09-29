package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManejadorConexion {
    private final String BASEDATOS = "basehoy";
    private final String USUARIO = "pruebahoy";
    private final String CLAVE = "12345";


    public Connection conectarse (){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/"+BASEDATOS, USUARIO, CLAVE);
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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
