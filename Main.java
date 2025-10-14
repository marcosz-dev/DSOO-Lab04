public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // Crear usuarios y libros
        Usuario ronald = new Usuario("Ronald", "123456789");
        Usuario misael = new Usuario("Misael", "987654321");
        Usuario jairo = new Usuario("Jairo", "987654321"); //Mismo DNI
        Usuario pedro = new Usuario("Pedro", "787652321"); 

        Libro libro1 = new Libro("1984", "George Orwell", "123456789");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "987654321");
        Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupéry", "987654321"); // Mismo ISBN
        Libro libro4 = new Libro(null, null); 


        // Agregar usuarios y libros al sistema
        sistema.agregarUsuario(ronald);
        sistema.agregarUsuario(misael);
        sistema.agregarUsuario(jairo);

        sistema.agregarLibro(libro1);
        sistema.agregarLibro(libro2);
        sistema.agregarLibro(libro3);
        sistema.agregarLibro(libro4);

        // Pruebas de préstamo
        ronald.tomarPrestado(libro1);
        misael.tomarPrestado(libro2);

        // Mostrar estado inicial
        sistema.mostrarLibros();
        sistema.mostrarUsuarios();

        // Mostrar libros prestados actuales
        ronald.mostrarLibrosPrestados();
        misael.mostrarLibrosPrestados();
        pedro.mostrarLibrosPrestados();

        // Devolver libros
        ronald.devolverLibro(libro1);
        misael.devolverLibro("Cien Años de Soledad");
        
        // Mostrar estado final
        System.out.println(ronald);
        ronald.mostrarLibrosPrestados();
        System.out.println(misael);
        misael.mostrarLibrosPrestados();
    }
}
