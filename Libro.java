public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    // Constructor completo
    public Libro(String titulo, String autor, String isbn, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = disponible; 
    }
    // Constructor sobrecargado sin disponible
    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, true); // Por defecto, el libro está disponible
    }

    // Constructor sobrecargado sin isbn
    public Libro(String titulo, String autor) {
        this(titulo, autor, "sin ISBN", true); // ISBN por defecto
    }   

    // Getters
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getIsbn() {
        return isbn;  
    }
    public boolean estaDisponible() {
        return disponible;
    }
    
    // Setters
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

    @Override
    public String toString() {
        return "ISBN: "+isbn+"\tTITULO: "+titulo+"\tAUTOR: "+autor+"\tDISPONIBLE: "+disponible;
    }
}
