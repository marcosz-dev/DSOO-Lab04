public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        Usuario usuario1 = new Usuario("Ronald");
        Usuario usuario2 = new Usuario("Ana");

        Libro libro1 = new Libro("1984", "George Orwell", "123456789");
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "987654321");

        sistema.agregarUsuario(usuario1);
        sistema.agregarUsuario(usuario2);
        sistema.agregarLibro(libro1);
        sistema.agregarLibro(libro2);

        
    }
}
