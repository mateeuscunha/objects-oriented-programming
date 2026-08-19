
/**
 * A classe Estudante representa um estudante em um sistema de gestão de
 * estudantes. Ela guarda os detalhes relevantes dos estudantes nesse
 * contexto.
 * 
 * Traduzido por Julio César Alves - 2023-08-25
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 */
public class Estudante
{
    // o nome completo do estudante
    private String nome;
    // a matrícula do estudante
    private String matricula;
    // o número de créditos que o estudante já cumpriu
    private int creditos;

    /**
     * Cria um novo estudante com um dado nom e matrícula
     */
    public Estudante(String nomeCompleto, String matriculaEstudante)
    {
        nome = nomeCompleto;
        matricula = matriculaEstudante;
        creditos = 0;
    }

    /**
     * Retorna o nome completo do estudante.
     */
    public String obterNome()
    {
        return nome;
    }

    /**
     * Define um novo nome para o estudante
     */
    public void mudarNome(String novoNome)
    {
        nome = novoNome;
    }

    /**
     * Retorna a matrícula do estudante
     */
    public String obterMatricula()
    {
        return matricula;
    }

    /**
     * Adiciona crédito aos créditos já acumulados pelo estudante
     */
    public void adicionarCreditos(int creditosAdicionais)
    {
        creditos += creditosAdicionais;
    }

    /**
     * Retorna o número de créditos que o estudante já acumulou.
     */
    public int obterCreditos()
    {
        return creditos;
    }

    /**
     * Retorna o login do estudante. Ele é uma combinação das primeiras quatro
     * letras do nome do estudante com os primeiros três caracteres da sua
     * matrícula.
     */
    public String obterLogin()
    {
        return nome.substring(0,4) + matricula.substring(0,3);
    }
    
    /**
     * Imprime o nome e a matrícula do estudante no terminal.
     */
    public void imprimir()
    {
        System.out.println(nome + ", matrícula: " + matricula + ", créditos: " + creditos);
    }
}
