package operaciones;

import archivospersistenc.Operaciones;
import dto.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class OperacionesVehiculoA implements Operacion<Vehiculo>{

    private final String archivo = "vehiculos.app";
    private List<Vehiculo> vehiculos;

    public OperacionesVehiculoA() {
        this.vehiculos = new ArrayList<>();
    }

    // 5 caracteristicas
    //1. Mismo nombre de la clase
    //2. No tiene retorno
    //3. Es un método
    //4. Tiene parametros
    //5. Solamente se instancia 1 vez con new

    @Override
    public boolean crear(Vehiculo dato) {
        Operaciones oper = new Operaciones();
        this.vehiculos.add(dato);

        return oper.guardar(this.vehiculos, this.archivo);

    }

    @Override
    public boolean modificar(Vehiculo dato) {
        return false;
    }

    @Override
    public boolean borrar(Vehiculo dato) {
        return false;
    }

    @Override
    public Vehiculo consulta(String pk) {
        return null;
    }

    @Override
    public List<Vehiculo> consultar() {
        return null;
    }
}
