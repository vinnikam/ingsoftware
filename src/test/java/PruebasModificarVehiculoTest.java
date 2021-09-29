import dto.Vehiculo;
import operaciones.OperacionesVehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class PruebasModificarVehiculoTest {
    @DisplayName("modifica ok")
    @Test
    public void modificar(){
        OperacionesVehiculo oper = new OperacionesVehiculo();
        String pk = "RRR234";
        Vehiculo vBase = oper.consulta(pk);
        vBase.setMarca("OTRA");

        boolean rta = oper.modificar(vBase);
        vBase = oper.consulta(pk);

        assertTrue(vBase.getMarca().equals("OTRA"));


    }
    @DisplayName("modifica null")
    @Test
    public void modificarNull(){
        OperacionesVehiculo oper = new OperacionesVehiculo();
        boolean rta = oper.modificar(null);
        assertFalse(rta);


    }
    @DisplayName("modifica sin pk")
    @Test
    public void modificarSinPK(){
        OperacionesVehiculo oper = new OperacionesVehiculo();
        boolean rta = oper.modificar(new Vehiculo());
        assertFalse(rta);


    }
    @DisplayName("Consulta ok")
    @Test
    public void consultaokpk(){
        OperacionesVehiculo oper = new OperacionesVehiculo();
        String pk = "RRR234";
        Vehiculo v = oper.consulta(pk);
        assertNotNull(v);


    }
    @DisplayName("Consulta pk null ")
    @Test
    public void consultapknull(){
        OperacionesVehiculo oper = new OperacionesVehiculo();
        String pk = "RRR234";
        Vehiculo v = oper.consulta(null);
        assertNull(v);


    }
    @DisplayName("Borrado  null ")
    @Test
    public void borradonull(){
        OperacionesVehiculo oper = new OperacionesVehiculo();
        boolean rta = oper.borrar(null);
        assertFalse(rta);


    }
    @DisplayName("Borrado ok  ")
    @Test
    public void consultapk(){
        OperacionesVehiculo oper = new OperacionesVehiculo();
        String pk = "RRR234";
        Vehiculo v = oper.consulta(pk);
        boolean rta = oper.borrar(v);
        assertTrue(rta);


    }
    @DisplayName("Consulta All ")
    @Test
    public void consultaAll(){
        OperacionesVehiculo oper = new OperacionesVehiculo();
        List<Vehiculo> v = oper.consultar();
        for (Vehiculo dato:v) {
            System.out.println(dato);

        }
        assertTrue(v.size()>0);


    }
}
