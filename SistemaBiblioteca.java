import java.util.ArrayList;

public class SistemaBiblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;

    // Constructor
    public SistemaBiblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    //AGREGAR LIBRO

    public void agregarLibro(Libro libro) {
        // NUEVA VALIDACIÓN: Revisar si el objeto Libro es nulo
        if (libro == null) {
            System.out.println("Error: El objeto libro no puede ser nulo");
            return;
        }
        //checks
        if (!stringValido(libro.getTitulo()) || !stringValido(libro.getAutor())) {
            System.out.println("Titulo o autor no validos, debes ingresar los datos");
            return;
        } 

        if (buscarLibro(libro.getIsbn())!=null) {
            System.out.println("El libro ya existe, no se hicieron cambios");
            return;
        }
        System.out.println("====== SISTEMA ======");
        libros.add(libro);
        System.out.println("Se agrego el libro correctamente\n");
    }

    //METODOS PARA VERIFICAR LIBRO
    
    //Busca un libro por su ISBN y lo retorna, si no lo encuentra retorna null
    public Libro buscarLibro(String ISBN) {
        // Validación adicional para asegurar que la entrada no sea nula o vacía
        if (!stringValido(ISBN)) {
            System.out.println("Error: El ISBN de búsqueda no es válido.");
            return null;
        }
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    //Valida que la cadena no sea null
    private boolean stringValido(String palabra) {
        return palabra != null && !palabra.trim().isEmpty();
    }

    //Metodo para agregar usuario
    public void agregarUsuario(Usuario usuario) {
        if (!validarUsuario(usuario)) {
            return;
        }
        
        if (existeUsuario(usuario.getDni())) {
            System.out.println("Error: El usuario con DNI '" + usuario.getDni() + "' ya existe en el sistema");
            return;
        }
        
        System.out.println("====== SISTEMA ======");
        usuarios.add(usuario);
        System.out.println("Usuario '" + usuario.getNombre() + "' agregado correctamente\n");
    }

    //Metodos de validacion de usuario
    private boolean validarUsuario(Usuario usuario){
        if (!validarObjetoNulo(usuario)) return false;
        if(!validarNombreUsuario(usuario.getNombre())) return false;
        return true;
    }

    private boolean validarObjetoNulo (Usuario usuario){
        if(usuario == null){
            System.out.println("Error: El usuario no puede ser nulo");
            return false;
        }
        return true;
    }

    private boolean validarNombreUsuario(String nombre){
        if(!stringValido(nombre)){
            System.out.println("Error: El nombre del usuario no puede ser nulo");
            return false;
        }
        if(esCadenaVacia(nombre)){
            System.out.println("Error: El nombre del usuario no puede estar vacio");
            return false;
        }
        return true;
    }   
    
    private boolean esCadenaVacia(String cadena){
        return cadena.trim().isEmpty();
    }

    private boolean existeUsuario(String dni){
        return buscarUsuario(dni) != null;
    }

    public Usuario buscarUsuario(String dni){
        for(Usuario a : usuarios){
            if(a.getDni().equalsIgnoreCase(dni)){
                return a;
            }
        }
        return null; 
    }  

    //Lista de usuarios registrados
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }


    // Método para mostrar todos los libros
    public void mostrarLibros() {
        System.out.println("========== CATÁLOGO DE LIBROS ==========");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados");
        } else {
            for (int i = 0; i < libros.size(); i++) {
                System.out.println((i + 1) + ". " + libros.get(i));
            }
        }
        System.out.println("=========================================\n");
    }
    
    // Método para mostrar todos los usuarios
    public void mostrarUsuarios() {
        System.out.println("========== LISTA DE USUARIOS ==========");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        } else {
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println((i + 1) + ". " + usuarios.get(i));
            }
        }
        System.out.println("========================================\n");
    }
}
