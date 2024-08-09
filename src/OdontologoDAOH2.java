import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDAOH2 implements OdontologoDAO {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/odontologos", "sa", "");
    }

    @Override
    public void guardar(Odontologo odontologo) {
        String sql = "INSERT INTO Odontologo (matricula, nombre, apellido) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();
            logger.info("Odontologo guardado: " + odontologo);

        } catch (SQLException e) {
            logger.error("Error al guardar odontologo", e);
        }
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        String sql = "SELECT * FROM Odontologo";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int matricula = resultSet.getInt("matricula");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");

                Odontologo odontologo = new Odontologo(matricula, nombre, apellido);
                odontologos.add(odontologo);
            }
            logger.info("Listado de todos los odontologos realizado.");

        } catch (SQLException e) {
            logger.error("Error al listar odontologos", e);
        }

        return odontologos;
    }
}
