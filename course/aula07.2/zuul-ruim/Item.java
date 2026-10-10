
/**
 * Escreva uma descrição da classe item aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Item
{
    private String nome;
    private String descricao;

    /**
     * Construtor para objetos da classe item
     */
    public Item(String nome, String descricao)
    {
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * Metodo de acesso para o atributo nome do item.
     */
    public String obterNome()
    {
        return nome;
    }
    
    /**
     * Metodo de acesso para o atributo descricao do item.
     */
    public String obterDescricao()
    {
        return descricao;
    }
}