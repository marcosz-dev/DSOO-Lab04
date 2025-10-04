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
    private boolean stringValido(String palabra) {
        if (palabra==null) {
            return false;
        }
        return true;
    }

    //Metodo para agregar usuario
    public void agregarUsuario(Usuario usuario) {
        if (!validarUsuario(usuario)) {
            return;
        }
        
        if (existeUsuario(usuario.getNombre())) {
            System.out.println("Error: El usuario '" + usuario.getNombre() + "' ya existe en el sistema");
            return;
        }
        
        usuarios.add(usuario);
        System.out.println("Usuario '" + usuario.getNombre() + "' agregado correctamente");
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

    private boolean existeUsuario(String nombre){
        return buscarUsuario(nombre) != null;
    }

    public Usuario buscarUsuario(String nombre){
        for(Usuario a : usuarios){
            if(a.getNombre().equalsIgnoreCase(nombre)){
                return a;
            }
        }
        return null; 
    }  

    //Lista de usuarios registrados
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
