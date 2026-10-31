import java.util.HashMap;

/**
 * Representa um aluno que pode pegar livros emprestados na biblioteca
 * 
 * @author Julio César Alves
 * @version 2024.12.16
 */
public class Aluno {
    // o número de matrícula do aluno
    private int numeroDeMatricula;
    // o nome do aluno
    private String nome;
    // livros que o aluno pegou emprestado
    private HashMap<Integer, Livro> livrosPegouEmprestado;
    private static final int MAXIMO_LIVROS_EMPRESTADOS = 2;
    
    /**
     * Construtor para objetos da classe Aluno
     * @param numeroDeMatricula o número de matrícula do aluno
     * @param nome o nome do aluno
     */
    public Aluno(int numeroDeMatricula, String nome) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nome = nome;
        this.livrosPegouEmprestado = new HashMap<>();
    }

    /**
     * Retorna o número de matrícula do aluno
     * @return o número de matrícula
     */    
    public int obterNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    /**
     * Retorna o nome do aluno
     * @return o nome
     */
    public String obterNome() {
        return nome;
    }

    /**
     * Retorna a quantidade de livros que o aluno pegou emprestado
     * @return a quantidade de livros
     */
    public int obterNumeroDeLivrosEmprestados() {
        return livrosPegouEmprestado.size();
    }

    public Livro devolverLivro(int codigo) {
        Livro livro = livrosPegouEmprestado.get(codigo);
        if (livro != null) {
            livrosPegouEmprestado.remove(codigo);
            return livro;
        }
        
        return null;
    }

    /**
     * Acrescenta o livro na coleção de livros que o aluno pegou emprestado se ele
     * puder pegá-lo.
     * @param o livro
     * @returns true se o aluno pode pegar o livro e false em caso contrário.
     */
    public boolean pegarLivroEmprestado(Livro livro) {
        // se ja tem dois livros, nao da pra pegar mais
        if (obterNumeroDeLivrosEmprestados() >= 2) {
            return false;
        }
        // se o aluno ainda não pegou um exemplar do livro passado
        if (livrosPegouEmprestado.get(livro.obterCodigo()) == null
            && obterNumeroDeLivrosEmprestados() < MAXIMO_LIVROS_EMPRESTADOS) {
            // o livro é acrescentado na coleção
            livrosPegouEmprestado.put(livro.obterCodigo(), livro);
            return true;
        }
        else {
            // se o aluno já está com um exemplar do livro, ele não pode pegar outro
            return false;
        }
    }
}
