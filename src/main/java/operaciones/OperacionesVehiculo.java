package operaciones;

import bd.ManejadorConexion;
import dto.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesVehiculo implements Operacion<Vehiculo>{

    private final String sqlCrear= "INSERT INTO vehiculo(placa, precio, marca) VALUES (?, ?, ?)";
    private final String sqlModificar= "UPDATE vehiculo SET precio = ?, marca =? WHERE placa = ?";
    private final String sqlConsultaPK= "select * from vehiculo  WHERE placa = ?";
    private final String sqlConsultaALL= "select * from vehiculo  ";
    private final String sqlBorrar= "delete from vehiculo  WHERE placa = ?";



    @Override
    public boolean crear(Vehiculo dato) {
        if (dato == null){
            return false;
        }else if (dato.getPlaca() == null){
            return false;

        }
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarse();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlCrear);

                ps.setString(1, dato.getPlaca());
                ps.setLong(2, dato.getPrecio());
                ps.setString(3, dato.getMarca());

                int modificados = ps.executeUpdate();
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return false;
    }

    @Override
    public boolean modificar(Vehiculo dato) {
        if (dato == null){
            return false;
        }else if (dato.getPlaca() == null){
            return false;

        }
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarse();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlModificar);

                ps.setString(3, dato.getPlaca());
                ps.setLong(1, dato.getPrecio());
                ps.setString(2, dato.getMarca());

                int modificados = ps.executeUpdate();
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return false;
    }

    @Override
    public boolean borrar(Vehiculo dato) {
        if (dato == null){
            return false;
        }else if (dato.getPlaca() == null){
            return false;

        }
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarse();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlBorrar);

                ps.setString(1, dato.getPlaca());

                int modificados = ps.executeUpdate();
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return false;
    }

    @Override
    public Vehiculo consulta(String pk) {
        if (pk == null){
            return null;
        }
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarse();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaPK);

                ps.setString(1, pk);

                ResultSet resultado = ps.executeQuery();
                if (resultado.next()){
                    Vehiculo elvehiculo = new Vehiculo();
                    elvehiculo.setPlaca(resultado.getString("placa"));
                    elvehiculo.setPrecio(resultado.getLong("precio"));
                    elvehiculo.setMarca(resultado.getString("marca"));
                    return elvehiculo;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return null;
    }

    @Override
    public List<Vehiculo> consultar() {
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarse();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaALL);

                ResultSet resultado = ps.executeQuery();
                List<Vehiculo> datos = new ArrayList<>();
                while (resultado.next()){
                    Vehiculo elvehiculo = new Vehiculo();
                    elvehiculo.setPlaca(resultado.getString("placa"));
                    elvehiculo.setPrecio(resultado.getLong("precio"));
                    elvehiculo.setMarca(resultado.getString("marca"));
                    datos.add(elvehiculo);
                }
                return datos;

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return new ArrayList<>();
    }
}
