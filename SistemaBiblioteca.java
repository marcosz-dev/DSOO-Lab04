import java.util.ArrayList;

public class SistemaBiblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;

    public SistemaBiblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    //AGREGAR LIBRO

    public void agregarLibro(Libro libro) {
        //checks
        if (!stringValido(libro.getTitulo()) || !stringValido(libro.getAutor())) {
            System.out.println("Titulo o autor no validos, debes ingresar los datos");
            return;
        }
        if (buscarLibro(libro.getIsbn())!=null) {
            System.out.println("El libro ya existe, no se hicieron cambios");
            return;
        }

        libros.add(libro);
        System.out.println("Se agrego el libro correctamente");
    }

    //METODOS PARA VERIFICAR LIBRO
    
    //Busca un libro por su ISBN y lo retorna, si no lo encuentra retorna null
    public Libro buscarLibro(String ISBN) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    //Valida que la cadena no sea null
    public boolean stringValido(String palabra) {
        if (palabra==null) {
            return false;
        }
        return true;
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
