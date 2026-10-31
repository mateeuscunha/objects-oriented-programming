
/**
 * Classe que representa os livros pertencentes ao acervo da biblioteca
 * 
 * Um livro possui um código, um título e um autor
 * 
 * @author Julio César Alves
 * @version 2024.12.16
 */
public class Livro
{
    // O código do livro na biblioteca
    private int codigo;
    // O título do livro
    private String titulo;
    // O autor do livro
    private String autor;

    /**
     * Construtor para objetos da classe Livro
     * @param codigo O código do livro
     * @param titulo O título do livro
     * @param autor O autor do livro
     */
    public Livro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    /**
     * Retorna o código do livro na biblioteca
     * @return o código
     */
    public int obterCodigo() {
        return codigo;
    }

    /**
     * Retorna o título do livro
     * @return o título
     */
    public String obterTitulo() {
        return titulo;
    }

    /**
     * Retorna o autor do livro
     * @return o autor
     */
    public String obterAutor() {
        return autor;
    }
}
