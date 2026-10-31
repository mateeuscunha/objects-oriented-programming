import java.util.ArrayList;

/**
 * Classe para representar uma biblioteca. 
 * Uma biblioteca tem uma coleção de livros que podem ser emprestados e uma
 * coleção de alunos que podem pegar livros emprestados.
 * 
 * Obs.: este código não tem a implementação completa da classe.
 * 
 * @author Julio César Alves
 * @version 2024.12.16
 */
public class Biblioteca
{
    // acervo de livros da biblioteca
    private ArrayList<Livro> acervo;
    // coleção de alunos que podem pegar livros emprestado
    private ArrayList<Aluno> alunos;

    /**
     * Construtor para objetos da classe Biblioteca
     */
    public Biblioteca()
    {
        acervo = new ArrayList<>();
        alunos = new ArrayList<>();

        // carrega os dados do acervo e dos alunos
        carregarDados();
    }

    /**
     * Carrega os dados do acervo de livros e dos alunos
     * 
     * Obs.: em uma implementação real, os dados seriam buscados em um banco de dados
     */
    private void carregarDados() {
        acervo.add(new Livro(104, "POO", "Zelia Silva"));
        acervo.add(new Livro(101, "Algoritmos", "Gilberto Junior"));
        acervo.add(new Livro(107, "Estruturas de Dados", "Mário Pereira"));

        alunos.add(new Aluno(202412, "Clarice"));
        alunos.add(new Aluno(202415, "Sebastiao"));
    }
    
    /**
     * Realiza o empréstimo de um livro para um aluno
     * 
     * @param codigoDoLivro o código do livro a ser emprestado.
     * @param matriculaDoAluno a matrícula do aluno que está fazendo o empréstimo
     * @return true se o empréstimo foi realizado e false em caso contrário
     */
    public boolean emprestarLivro(int codigoDoLivro, int matriculaDoAluno) {
        // Procura o livro no acervo
        Livro livro = buscarLivro(codigoDoLivro);
        // Procura o aluno no sistema
        Aluno aluno = buscarAluno(matriculaDoAluno);

        // O empréstimo é realizado se o livro e o aluno existem e se o aluno
        // pode pegar o livro emprestado
        if (livro != null && aluno != null && aluno.pegarLivroEmprestado(livro)) {
            return true;
        }
        return false;
    }
    
    public boolean devolverLivro(int codigo, int matricula) {
        Aluno aluno = buscarAluno(matricula);
        if (aluno == null) {
            return false;
        }
        
        Livro livroDevolvido = aluno.devolverLivro(codigo);
        if (livroDevolvido == null) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Busca um livro no acervo pelo seu código.
     * @return o livro encontrado ou null se não for encontrado.
     */
    private Livro buscarLivro(int codigo) {
        for (Livro livro : acervo) {
            if (livro.obterCodigo() == codigo) {
                return livro;
            }
        }
        return null;
    }
    
    /**
     * Busca um aluno pela sua matrícula.
     * @return o aluno encontrado ou null se não for encontrado.
     */
    private Aluno buscarAluno(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.obterNumeroDeMatricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }
    
    /**
     * Exibe no terminal as informações do acervo de livros da biblioteca
     */
    public void listarAcervo() {
        System.out.println("ACERVO DE LIVROS");
        for (Livro livro : acervo) {
            System.out.println("Livro " + livro.obterCodigo() +  
                               " (autor: " + livro.obterAutor() + ")");
        }
    }
    
    /*
    public boolean devolverLivro(int matriculaAluno, int codigoLivro) {
        Aluno aluno = buscarAluno(matriculaAluno);
        if (aluno != null) {
            Livro livro = aluno.devolverLivro(codigoLivro);
            if (livro != null) {
                return true;
            }
        }
        return false;
    }
    */
    /**
     * Exite no terminal as informações dos empréstimos de livros
     */
    public void listarEmprestimos() {
        System.out.println("EMPRÉSTIMOS DE LIVROS");
        boolean temAlgumLivroEmprestado = false;
        for (Aluno aluno : alunos) {
            int nroLivros = aluno.obterNumeroDeLivrosEmprestados();
            if (nroLivros > 0) {
                System.out.println("Aluno(a) " + aluno.obterNome() +  
                                   " pegou " + nroLivros + " livro(s) emprestado(s)");
                temAlgumLivroEmprestado = true;
            }
        }
        if (!temAlgumLivroEmprestado) {
            System.out.println("Não há nenhum livro emprestado!");
        }
    }
}
