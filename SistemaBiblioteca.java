import java.util.ArrayList;

public class SistemaBiblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;

    public SistemaBiblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public ArrayList<Libro> getLibros() {
        return libros;
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
