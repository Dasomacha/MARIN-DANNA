import java.util.*;
import org.apache.log4j.Logger;

public class OdontologoDAOCollection implements OdontologoDAO {
    private static final Logger logger = Logger.getLogger(OdontologoDAOCollection.class);

    private Map<Integer, Odontologo> odontologos = new HashMap<>();

    @Override
    public void guardar(Odontologo odontologo) {
        odontologos.put(odontologo.getMatricula(), odontologo);
        logger.info("Odontologo guardado: " + odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Listado de todos los odontologos realizado.");
        return new ArrayList<>(odontologos.values());
    }
}