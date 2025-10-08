import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String dni;
    private ArrayList<Libro> librosPrestados;

    // Constructor completo
    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.librosPrestados = new ArrayList<>();
    }

    // Constructor sobrecargado sin dni
    public Usuario(String nombre) {
        this(nombre, "sin DNI");
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
        }
    
    public ArrayList<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    // Metodo de instancia para tomar prestado un libro
    public boolean tomarPrestado(Libro libro) {
        // NUEVA VALIDACIÓN: El libro a tomar prestado no puede ser nulo
        if (libro == null) {
            System.out.println("Error: No se puede tomar prestado un objeto nulo.");
            return false;
        }
        if (!libro.estaDisponible()) {
            System.out.println(" El libro '" + libro.getTitulo() + "' no está disponible");
            return false;
        }
        libro.setDisponible(false);
        librosPrestados.add(libro);
        System.out.println(nombre + " ha tomado prestado: " + libro.getTitulo());
        return true;
    }

    // Método para verificar si el usuario tiene un libro prestado
    public boolean tieneLibroPrestado(Libro libro) {
        return librosPrestados.contains(libro);
    }
    
    // Método sobrecargado para verificar por título
    public boolean tieneLibroPrestado(String titulo) {
        for (Libro libro : librosPrestados) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    // Metodo de instancia para devolver un libro
    public boolean devolverLibro(Libro libro) {
         // NUEVA VALIDACIÓN: El libro a devolver no puede ser nulo
        if (libro == null) {
            System.out.println("Error: No se puede devolver un objeto nulo.");
            return false;
        }
        if (!tieneLibroPrestado(libro)) {
            System.out.println("Error: " + nombre + " no tiene prestado este libro");
            return false;
        }
        
        libro.setDisponible(true);
        librosPrestados.remove(libro);
        System.out.println(nombre + " ha devuelto: " + libro.getTitulo());
        return true;
    }

    // Método sobrecargado para devolver libro por título
    public boolean devolverLibro(String titulo) {
        if (!tieneLibroPrestado(titulo)) {
            System.out.println("No se encontró el libro '" + titulo + "' en los préstamos");
            return false;
        }
        
        for (Libro libro : librosPrestados) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return devolverLibro(libro);
            }
        }
        return false;
    }

    // Método para mostrar libros prestados
    public void mostrarLibrosPrestados() {
        if (librosPrestados.isEmpty()) {
            System.out.println("No tiene libros prestados");
        } else {
            for (Libro libro : librosPrestados) {
                System.out.println("- " + libro.getTitulo() + " (ISBN: " + libro.getIsbn() + ")");
            }
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "nombre='" + nombre +
               ", librosPrestados=" + librosPrestados.size() +
               '}';
    }

}