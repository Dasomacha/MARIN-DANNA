import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OdontologoDAOTest {
    private OdontologoDAO odontologoDAO;

    @Before
    public void setUp() {
        odontologoDAO = new OdontologoDAOCollection();
        odontologoDAO.guardar(new Odontologo(1, "Carlos", "Diaz"));
        odontologoDAO.guardar(new Odontologo(2, "Lucia", "Fernandez"));
    }

    @Test
    public void testListarTodos() {
        List<Odontologo> odontologos = odontologoDAO.listarTodos();
        Assert.assertEquals(2, odontologos.size());
    }
}