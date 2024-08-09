import org.apache.log4j.BasicConfigurator;

public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();

        // Using H2 Database
        OdontologoDAO odontologoDAOH2 = new OdontologoDAOH2();
        odontologoDAOH2.guardar(new Odontologo(1, "Juan", "Perez"));
        odontologoDAOH2.guardar(new Odontologo(2, "Ana", "Gomez"));
        System.out.println("Odontologos en H2:");
        odontologoDAOH2.listarTodos().forEach(System.out::println);

        // Using Collection
        OdontologoDAO odontologoDAOCollection = new OdontologoDAOCollection();
        odontologoDAOCollection.guardar(new Odontologo(3, "Luis", "Martinez"));
        odontologoDAOCollection.guardar(new Odontologo(4, "Maria", "Lopez"));
        System.out.println("Odontologos en Collection:");
        odontologoDAOCollection.listarTodos().forEach(System.out::println);
    }
}
