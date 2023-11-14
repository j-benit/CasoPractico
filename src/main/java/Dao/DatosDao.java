package Dao;

import Utils.ConectionUtil;
import domain.Familiares;
import domain.Funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatosDao {

    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionarios " 
            + "(tipo_Id, numero_Id, nombre, apellido, estado_Civil, sexo, direccion, telefono, fecha_Nacimiento, nvel_Estudio, universidad, titulo)" 
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String CREATE_FAMILIAR = "INSERT INTO familiares "
            + "(tipo_Id, numero_Id, nombre, apellido, estado_Civil, sexo, direccion, telefono, fecha_Nacimiento, funcionario_id)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String READ_FUNCIONARIO_BY_ID = "SELECT * FROM funcionarios WHERE id = ?";

    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionarios SET tipo_Id = ?, numero_Id = ?, nombre = ?, apellido = ?, estado_Civil = ?, sexo = ?, direccion = ?, telefono = ?, fecha_Nacimiento = ?, nvel_Estudio = ?, universidad = ?, titulo = ? WHERE id = ?;";

    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionarios WHERE id = ?;";

    public List<Funcionarios> obtenerFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionarios> listaFuncionarios = new ArrayList<>();

        try {
            connection = ConectionUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM funcionarios");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Funcionarios funcionario = new Funcionarios();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_Id"));
                funcionario.setNumeroIdentificacion(resultSet.getInt("numero_Id"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setEstadoCivil(resultSet.getString("estado_Civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_Nacimiento"));
                funcionario.setNivelEstudio(resultSet.getString("nvel_Estudio"));
                funcionario.setUniversidad(resultSet.getString("universidad"));
                funcionario.setTitulo(resultSet.getString("titulo"));
                listaFuncionarios.add(funcionario);
            }

            return listaFuncionarios;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public List<Familiares> obtenerFamiliares() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Familiares> listaFamiliares = new ArrayList<>();

        try {
            connection = ConectionUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM familiares");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Familiares familiar = new Familiares();
                familiar.setId(resultSet.getInt("id"));
                familiar.setTipoIdentificacion(resultSet.getString("tipo_Id"));
                familiar.setNumeroIdentificacion(resultSet.getInt("numero_Id"));
                familiar.setNombre(resultSet.getString("nombre"));
                familiar.setApellido(resultSet.getString("apellido"));
                familiar.setEstadoCivil(resultSet.getString("estado_Civil"));
                familiar.setSexo(resultSet.getString("sexo"));
                familiar.setDireccion(resultSet.getString("direccion"));
                familiar.setTelefono(resultSet.getString("telefono"));
                familiar.setFechaNacimiento(resultSet.getString("fecha_Nacimiento"));
                familiar.setFuncionario_id(resultSet.getInt("funcionario_id"));
                listaFamiliares.add(familiar);
            }

            return listaFamiliares;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void crearFuncionario(Funcionarios funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setInt(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setString(5, funcionario.getEstadoCivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.setString(10, funcionario.getNivelEstudio());
            preparedStatement.setString(11, funcionario.getUniversidad());
            preparedStatement.setString(12, funcionario.getTitulo());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionarios obtenerFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionarios funcionario = null;

        try {
            connection = ConectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(READ_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionarios();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_Id"));
                funcionario.setNumeroIdentificacion(resultSet.getInt("numero_Id"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setEstadoCivil(resultSet.getString("estado_Civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_Nacimiento"));
                funcionario.setNivelEstudio(resultSet.getString("nvel_Estudio"));
                funcionario.setUniversidad(resultSet.getString("universidad"));
                funcionario.setTitulo(resultSet.getString("titulo"));
            }

            return funcionario;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void actualizarFuncionario(int id, Funcionarios funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setInt(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setString(5, funcionario.getEstadoCivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.setString(10, funcionario.getNivelEstudio());
            preparedStatement.setString(11, funcionario.getUniversidad());
            preparedStatement.setString(12, funcionario.getTitulo());
            preparedStatement.setInt(13, id);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public int eliminarFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return id;
    }

    public void crearFamiliar(Familiares familiar) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FAMILIAR);
            preparedStatement.setString(1, familiar.getTipoIdentificacion());
            preparedStatement.setInt(2, familiar.getNumeroIdentificacion());
            preparedStatement.setString(3, familiar.getNombre());
            preparedStatement.setString(4, familiar.getApellido());
            preparedStatement.setString(5, familiar.getEstadoCivil());
            preparedStatement.setString(6, familiar.getSexo());
            preparedStatement.setString(7, familiar.getDireccion());
            preparedStatement.setString(8, familiar.getTelefono());
            preparedStatement.setString(9, familiar.getFechaNacimiento());
            preparedStatement.setInt(10, familiar.getFuncionario_id());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

       public List<Familiares> obtenerFamiliaresPorFuncionario(int idFuncionario) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<Familiares> listaFamiliares = new ArrayList<>();

    try {
        connection = ConectionUtil.getConnection();
        preparedStatement = connection.prepareStatement("SELECT * FROM familiares WHERE funcionario_id = ?");
        preparedStatement.setInt(1, idFuncionario);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Familiares familiar = new Familiares();
            familiar.setId(resultSet.getInt("id"));
            familiar.setTipoIdentificacion(resultSet.getString("tipo_Id"));
            familiar.setNumeroIdentificacion(resultSet.getInt("numero_Id"));
            familiar.setNombre(resultSet.getString("nombre"));
            familiar.setApellido(resultSet.getString("apellido"));
            familiar.setEstadoCivil(resultSet.getString("estado_Civil"));
            familiar.setSexo(resultSet.getString("sexo"));
            familiar.setDireccion(resultSet.getString("direccion"));
            familiar.setTelefono(resultSet.getString("telefono"));
            familiar.setFechaNacimiento(resultSet.getString("fecha_Nacimiento"));
            familiar.setFuncionario_id(resultSet.getInt("funcionario_id"));
            listaFamiliares.add(familiar);
        }

        return listaFamiliares;
    } finally {
        if (connection != null) {
            connection.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}

}
