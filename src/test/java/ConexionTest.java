import bd.ManejadorConexion;
import dto.Vehiculo;
import operaciones.OperacionesVehiculo;
import operaciones.OperacionesVehiculoA;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

import java.sql.Connection;

public class ConexionTest {
    @DisplayName("Pruebas de conexion ")
    @Test
    public void testPruebasConexion(){
        ManejadorConexion c = new ManejadorConexion();
        Connection con = c.conectarse();
        assertNotNull(con );
    }
    @DisplayName("Insercion Vehiculo Null ")
    @Test
    public void testInsercionVehiculoNull(){

        OperacionesVehiculo oper= new OperacionesVehiculo();
        boolean rta = oper.crear(null);
        assertFalse(rta );
    }
    @DisplayName("Insercion Vehiculo sin datos ")
    @Test
    public void testInsercionVehiculoSindatos(){

        OperacionesVehiculo oper= new OperacionesVehiculo();
        Vehiculo v = new Vehiculo();

        boolean rta = oper.crear(v);
        assertFalse(rta );
    }
    @DisplayName("Insercion Vehiculo sin PK ")
    @Test
    public void testInsercionVehiculoSinpk(){

        OperacionesVehiculo oper= new OperacionesVehiculo();
        Vehiculo v = new Vehiculo();
        v.setPrecio(15000);
        v.setMarca("kia");
        boolean rta = oper.crear(v);
        assertFalse(rta );
    }
    @DisplayName("Insercion Vehiculo ok ")
    @Test
    public void testInsercionVehiculoOK(){

        OperacionesVehiculo oper= new OperacionesVehiculo();
        Vehiculo v = new Vehiculo();
        v.setPrecio(15000);
        v.setMarca("kia");
        v.setPlaca("RRR234");
        boolean rta = oper.crear(v);
        assertTrue(rta );
    }
    @DisplayName("Prueba constructor ")
    @Test
    public void testConstructorOK(){

        OperacionesVehiculoA oper= new OperacionesVehiculoA();

        Vehiculo v = new Vehiculo();
        v.setPrecio(1584);
        v.setMarca("kia");
        v.setPlaca("RR2234");
        boolean rta = oper.crear(v);
        assertTrue(rta );
    }
    @DisplayName("Prueba testConexionSQLite ")
    @Test
    public void testConexionSQLite(){

        ManejadorConexion m = new ManejadorConexion();
        Connection c = m.conectarse();
        assertNotNull(c );
    }
}
