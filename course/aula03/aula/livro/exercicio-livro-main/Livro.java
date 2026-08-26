/**
 * Uma classe que mantém informação de um livro.
 * Ela pode ser parte de uma aplicação mair como um sistema
 * de uma biblioteca, por exemplo.
 *
 * @author (Digite seu nome aqui.)
 * @version (Insira o dia de hoje aqui.)
 */

/**
 * Resposta do item 1.3 
 * Da maneira que a classe se encontra ela eh imutavel, no sentido de que, uma
 * vez cadastrado um livro com seus respectivos atributos, ele permanecera, 
 * sempre, com esses mesmos atributos. Um livro, por exemplo, nao pode ter 
 * seu nome mudado ou paginas adicionadas.
 */
class Livro
{
    // Os atributos.
    private String autor;
    private String titulo;
    private int paginas;
    private String id;
    private int numeroEmprestimos;

    /**
     * Define os atributos autor e o título quando este
     * objeto é criado.
     */
    public Livro(String autorLivro, String tituloLivro, int paginasLivro)
    {
        autor = autorLivro;
        titulo = tituloLivro;
        paginas = paginasLivro;
        id = "";
        numeroEmprestimos = 0;
    }

    // Adicione os métodos aqui ...
    /**
     * Imprime o nome do autor no terminal
     */
    public void imprimirAutor()
    {
        System.out.println(autor);
    }
    
    /**
     * Imprime o nome do titulo no terminal
     */
    public void imprimirTitulo()
    {
        System.out.println(titulo);
    }
    
    /**
     * Retorna o numero de paginas do livro
     */
    public int obterPaginas()
    {
        return paginas;
    }
    
    /**
     * Imprime os detalhes do livro no terminal
     */
    public void imprimirDetalhes() 
    {
        String impressaoDoId;
        if (id.length() != 0) 
        {
            impressaoDoId = id;
        } else 
        {
            impressaoDoId = "NDEF"; //nao definido
        }
        
        System.out.println("Titulo do livro: " + titulo);
        System.out.println("Escrito por: " + autor);
        System.out.println("Numero de paginas: " + paginas);
        System.out.println("Numero de chamada ou ID: " + impressaoDoId);
        System.out.println("Numero de emprestimos: " + numeroEmprestimos);
    }
    
    /**
     * Adiciona o numero de chamada ou ID do livro
     */
    public void adicionarId(String novoId) 
    {
        if (novoId.length() < 3)
        {
            System.out.println("O ID deve ter pelo menos 3 caracteres!");
        } else
        {
            id = novoId;
        }
    }
    
    /**
     * Retorna o ID do livro
     */
    public String obterId() 
    {
        return id;
    }
    
    /**
     * Empresta o livro uma vez, atualizando o atributo numeroEmprestimos
     */
    public void emprestar()
    {
        numeroEmprestimos += 1;
    }
    
    /**
     * Retorna o numero de emprestimos do livro
     */
    public int obterNumeroEmprestimos() 
    {
        return numeroEmprestimos;
    }
}