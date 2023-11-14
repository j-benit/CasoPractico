
package Controller;

import Dao.DatosDao;
import domain.Familiares;
import domain.Funcionarios;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JHON BENITEZ
 */
public class DatosController {
    
    private DatosDao datosDao;
    
    public DatosController(){
        
        datosDao = new DatosDao();
    }
    public List<Funcionarios> odtenerFuncionarios()throws SQLException {
        return datosDao.obtenerFuncionarios();
    }
    
    public void crear(Funcionarios funcionarios) throws SQLException {
         datosDao.crearFuncionario(funcionarios);
    }
    public Funcionarios obtenerFuncionario(int id) throws SQLException {
        return datosDao.obtenerFuncionario(id);
       
    }
  
    
     
    public void actualizar(int id, Funcionarios funcionarios) throws SQLException {
        datosDao.actualizarFuncionario(id, funcionarios);
       
    }
    
    public void eliminar(int id) throws SQLException {
        datosDao.eliminarFuncionario(id);
                }

    public void crearFamiliar(Familiares familiar) throws SQLException {
        datosDao.crearFamiliar(familiar);
        
    }

    public Familiares obtenerFamiliar(int id) throws SQLException {
         return (Familiares) datosDao.obtenerFamiliares();
        
    }

     public List<Familiares> odtenerFamiliares()throws SQLException {
        return datosDao.obtenerFamiliares();
    }
    
    
    
}
