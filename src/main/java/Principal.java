import bd.ManejadorConexion;
import dto.Vehiculo;
import operaciones.OperacionesVehiculo;

import java.sql.Connection;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Probando persistencia");
        //ManejadorConexion mc = new ManejadorConexion();
        //Connection mx = mc.conectarse();
        //System.out.println(mx);

        OperacionesVehiculo oper = new OperacionesVehiculo();
        Vehiculo veh = new Vehiculo();
        veh.setPlaca("JDG234");
        veh.setPrecio(15000000);
        veh.setMarca("RENAULT");
        
        boolean rta = oper.crear(veh);
        System.out.println(rta);

    }
}
