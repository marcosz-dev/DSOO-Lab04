public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true; // Por defecto, el libro está disponible
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getIsbn() {
        return isbn;  
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }  

    // Método para verificar si el libro está disponible
    public boolean estaDisponible() {
        return disponible;
    }
    

    public String toString() {
        return "ISBN: "+isbn+"\tTITULO: "+titulo+"\tAUTOR: "+autor+"\tDISPONIBLE: "+disponible;
    }
}
