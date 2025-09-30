public class Usuario {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void prestarLibro(Libro libro) {
        if (libro.estaDisponible()) {
            System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido prestado a " + nombre + ".");
            // Aquí agregar lógica para marcar el libro como no disponible
        } else {
            System.out.println("El libro \"" + libro.getTitulo() + "\" no está disponible para préstamo.");
        }
    }

    public void devolverLibro(Libro libro) {
        System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido devuelto por " + nombre + ".");
        // Aquí agregar lógica para marcar el libro como disponible
    }

    public void verificarDisponibilidad(Libro libro) {
        if (libro.estaDisponible()) {
            System.out.println("El libro \"" + libro.getTitulo() + "\" está disponible.");
        } else {
            System.out.println("El libro \"" + libro.getTitulo() + "\" no está disponible.");
        }
    }
}
