package com.mycompany.casopractico1;

import Controller.DatosController;
import Dao.DatosDao;
import domain.Funcionarios;
import domain.Familiares;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Autor: JHON BENITEZ
 */
public class AdministracionFuncionarios {

    public static void main(String[] args) throws SQLException {
        DatosController datosController = new DatosController();
        DatosDao datosDao = new DatosDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear Funcionario");
            System.out.println("2. Leer Funcionario");
            System.out.println("3. Actualizar Funcionario");
            System.out.println("4. Eliminar Funcionario");
            System.out.println("5. Crear Familiar");
            System.out.println("6. Leer Familiar");
            System.out.println("8. Eliminar Familiar");
            System.out.println("9. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearFuncionario(datosController);
                    break;
                case 2:
                    leerFuncionario(datosDao);
                    break;
                case 3:
                    actualizarFuncionario(datosController);
                    break;
                case 4:
                    eliminarFuncionario(datosDao);
                    break;
                case 5:
                    crearFamiliar(datosController);
                    break;
                case 6:
                    leerFamiliar(datosDao);
                    break;
          
                case 7:
                    eliminarFamiliar(datosDao);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

   public static void crearFuncionario(DatosController datosController) {
    try {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Digite el tipo de identificación:");
        String tipoId = sc.nextLine();

        System.out.println("Digite el número de identificación:");
        int numeroId = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite el nombre:");
        String nombre = sc.nextLine();

        System.out.println("Digite el apellido:");
        String apellido = sc.nextLine();

        System.out.println("Digite el estado civil:");
        String estadoCivil = sc.nextLine();

        System.out.println("Digite el sexo:");
        String sexo = sc.nextLine();

        System.out.println("Digite la dirección:");
        String direccion = sc.nextLine();

        System.out.println("Digite el teléfono:");
        String telefono = sc.nextLine();

        System.out.println("Digite la fecha de nacimiento:");
        String fechaNacimiento = sc.nextLine();

        System.out.println("Digite la universidad:");
        String universidad = sc.nextLine();

        System.out.println("Digite el nivel de estudio:");
        String nivelEstudio = sc.nextLine();

        System.out.println("Digite el título:");
        String titulo = sc.nextLine();

        
        
        Funcionarios funcionario = new Funcionarios();
        funcionario.setTipoIdentificacion(tipoId);
        funcionario.setNumeroIdentificacion(numeroId);
        funcionario.setNombre(nombre);
        funcionario.setApellido(apellido);
        funcionario.setEstadoCivil(estadoCivil);
        funcionario.setSexo(sexo);
        funcionario.setDireccion(direccion);
        funcionario.setTelefono(telefono);
        funcionario.setFechaNacimiento(fechaNacimiento);
        funcionario.setUniversidad(universidad);
        funcionario.setNivelEstudio(nivelEstudio);
        funcionario.setTitulo(titulo);
        datosController.crear(funcionario);


        System.out.println("El funcionario fue creado con éxito.");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}


    public static void leerFuncionario(DatosDao datosDao) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("______________________________________");

        System.out.println("Ingrese el ID del funcionario que desea buscar:");
        int id = sc.nextInt();
        sc.nextLine();

        Funcionarios funcionario = datosDao.obtenerFuncionario(id);

        if (funcionario != null) {
            System.out.println("Información del funcionario:");
            System.out.println("             ID: " + funcionario.getId());
            System.out.println("   TIPO DE IDNF: " + funcionario.getTipoIdentificacion());
            System.out.println(" NUMERO DE IDNF:" + funcionario.getNumeroIdentificacion());
            System.out.println("         NOMBRE: " + funcionario.getNombre());
            System.out.println("       APELLIDO: "+ funcionario.getApellido());
            System.out.println("     ESTD CIVIL: " + funcionario.getEstadoCivil());
            System.out.println("           SEXO: " + funcionario.getSexo());
            System.out.println("      DIRECCION: " +funcionario.getDireccion());            
            System.out.println("     FEC NACMTO: " + funcionario.getFechaNacimiento());  
            System.out.println(" NVEL DE STUDIO: " +funcionario.getNivelEstudio());   
            System.out.println("    UNIVERSIDAD: " +funcionario.getUniversidad());
            System.out.println("         TITULO: " +funcionario.getTitulo());            
            
            
            
            
        } else {
            System.out.println("No se encontró ningún funcionario con el ID proporcionado.");
        }
    }

    public static void actualizarFuncionario(DatosController datosController) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el ID del funcionario que desea actualizar:");
        int id = sc.nextInt();
        sc.nextLine();

        Funcionarios funcionario = datosController.obtenerFuncionario(id);

        if (funcionario != null) {
            System.out.println("Digite el nuevo tipo de identificación (o Enter para mantener el actual):");
            String nuevoTipoId = sc.nextLine().trim();
            if (!nuevoTipoId.isEmpty()) {
                funcionario.setTipoIdentificacion(nuevoTipoId);
            }

            System.out.println("Digite el nuevo número de identificación (o Enter para mantener el actual):");
            String nuevoNumeroStr = sc.nextLine().trim();
            if (!nuevoNumeroStr.isEmpty()) {
                try {
                    int nuevoNumero = Integer.parseInt(nuevoNumeroStr);
                    funcionario.setNumeroIdentificacion(nuevoNumero);
                } catch (NumberFormatException e) {
                    System.out.println("El número de identificación no es válido. Se mantendrá el valor actual.");
                }
            }
                 System.out.println("Digite el nuevo nombre (o Enter para mantener el actual):");
                String nuevoNombre = sc.nextLine().trim();
                if (!nuevoNombre.isEmpty()) {
                    funcionario.setNombre(nuevoNombre);
                }
                
                 System.out.println("Digite el nuevo apellido (o Enter para mantener el actual):");
                String nuevoApellido = sc.nextLine().trim();
                if (!nuevoApellido.isEmpty()) {
                    funcionario.setApellido(nuevoApellido);
                }
                
                 System.out.println("Digite el nuevo estado civil (o Enter para mantener el actual):");
                String nuevoEstado = sc.nextLine().trim();
                if (!nuevoEstado.isEmpty()) {
                    funcionario.setEstadoCivil(nuevoEstado);
                }
                
                 System.out.println("Digite el nuevo sexo (o Enter para mantener el actual):");
                String nuevoSexo = sc.nextLine().trim();
                if (!nuevoSexo.isEmpty()) {
                    funcionario.setSexo(nuevoSexo);
                }
            

           
                System.out.println("Digite la nueva dirección (o Enter para mantener la actual):");
                String nuevaDireccion = sc.nextLine().trim();
                if (!nuevaDireccion.isEmpty()) {
                    funcionario.setDireccion(nuevaDireccion);
                }

                System.out.println("Digite el nuevo teléfono (o Enter para mantener el actual):");
                String nuevoTelefono = sc.nextLine().trim();
                if (!nuevoTelefono.isEmpty()) {
                    funcionario.setTelefono(nuevoTelefono);
                }

                System.out.println("Digite la nueva fecha de nacimiento (o Enter para mantener la actual):");
                String nuevaFechaNacimiento = sc.nextLine().trim();
                if (!nuevaFechaNacimiento.isEmpty()) {
                    funcionario.setFechaNacimiento(nuevaFechaNacimiento);
                }

                System.out.println("Digite la nueva universidad (o Enter para mantener la actual):");
                String nuevaUniversidad = sc.nextLine().trim();
                if (!nuevaUniversidad.isEmpty()) {
                    funcionario.setUniversidad(nuevaUniversidad);
                }

                System.out.println("Digite el nuevo nivel de estudio (o Enter para mantener el actual):");
                String nuevoNivelEstudio = sc.nextLine().trim();
                if (!nuevoNivelEstudio.isEmpty()) {
                    funcionario.setNivelEstudio(nuevoNivelEstudio);
                }

                System.out.println("Digite el nuevo título (o Enter para mantener el actual):");
                String nuevoTitulo = sc.nextLine().trim();
                if (!nuevoTitulo.isEmpty()) {
                    funcionario.setTitulo(nuevoTitulo);
                }

                

            datosController.actualizar(id, funcionario);
            System.out.println("Funcionario actualizado con éxito.");
        } else {
            System.out.println("No se encontró ningún funcionario con el ID proporcionado.");
        }
    }

    public static void eliminarFuncionario(DatosDao datosDao) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("__________________________________________");

        System.out.print("Ingrese el ID del funcionario que desea eliminar: ");
        int id = sc.nextInt();

        int resultado = datosDao.eliminarFuncionario(id);

        if (resultado > 0) {
            System.out.println("Funcionario eliminado con éxito.");
        } else {
            System.out.println("No se pudo eliminar el funcionario.");
        }
    }

    public static void crearFamiliar(DatosController datosController) throws SQLException {
        
        
        try { Scanner sc = new Scanner(System.in);
        System.out.println("Digite el id del funcionario");    
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Digite el tipo de identificación:");
        String tipoId = sc.nextLine();
        System.out.println("Digite el número de identificación:");
        int numeroId = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Digite el apellido:");
        String apellido = sc.nextLine();
        System.out.println("Digite el estado civil:");
        String estadoCivil = sc.nextLine();
        System.out.println("Digite el sexo:");
        String sexo = sc.nextLine();
        System.out.println("Digite la dirección:");
        String direccion = sc.nextLine();
        System.out.println("Digite el teléfono:");
        String telefono = sc.nextLine();
        System.out.println("Digite la fecha de nacimiento:");
        String fechaNacimiento = sc.nextLine();
        
                    Familiares familiar = new Familiares();
            familiar.setFuncionario_id(id);
            familiar.setTipoIdentificacion(tipoId);
            familiar.setNumeroIdentificacion(numeroId);
            familiar.setNombre(nombre);
            familiar.setApellido(apellido);
            familiar.setEstadoCivil(estadoCivil);
            familiar.setSexo(sexo);
            familiar.setDireccion(direccion);
            familiar.setTelefono(telefono);
            familiar.setFechaNacimiento(fechaNacimiento);

        datosController.crearFamiliar(familiar); 
       
        
    }catch (SQLException ex) {
    } 
    }

    public static void leerFamiliar(DatosDao datosDao) throws SQLException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el ID del funcionario cuyos familiares desea buscar:");
    int idFuncionario = sc.nextInt();
    
    List<Familiares> familiares = datosDao.obtenerFamiliaresPorFuncionario(idFuncionario);
    
    if (!familiares.isEmpty()) {
        System.out.println("Familiares del funcionario:");
        for (Familiares familiar : familiares) {
            System.out.println("ID: " + familiar.getId());
            System.out.println("Tipo de Identificación: " + familiar.getTipoIdentificacion());
            System.out.println("Número de Identificación: " + familiar.getNumeroIdentificacion());
            System.out.println("Nombre: " + familiar.getNombre());
            System.out.println("Apellido: " + familiar.getApellido());
            System.out.println("Estado Civil: " + familiar.getEstadoCivil());
            System.out.println("Sexo: " + familiar.getSexo());
            System.out.println("Dirección: " + familiar.getDireccion());
            System.out.println("Fecha de Nacimiento: " + familiar.getFechaNacimiento());
            // Agrega otros campos aquí si es necesario
            System.out.println("_________________________");
        }
    } else {
        System.out.println("No se encontraron familiares para el funcionario con ID proporcionado.");
    }
}

    private static void eliminarFamiliar(DatosDao datosDao) throws SQLException {
               
        Scanner sc = new Scanner(System.in);
        
        System.out.println("__________________________________________");        

        System.out.print("Ingresa el ID del carro que desea eliminar: ");
        int id = sc.nextInt();

        int resultado = datosDao.eliminarFuncionario(id);

        if (resultado > 0) {
            System.out.println("Carro eliminado con éxito.");
        } else {
            System.out.println("No se pudo eliminar el carro.");
        }

    }
        
        
        
        
    }
   

