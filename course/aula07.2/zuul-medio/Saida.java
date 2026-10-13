
/**
 * A classe Saida indica possiveis saidas de um local.
 */
public class Saida
{
    private Local localSaida;
    private boolean ehBloqueada;
    private String itemQueAbre;

    /**
     * Construtor para objetos da classe Saida que nao sao bloqueados
     */
    public Saida(Local localSaida)
    {
        this.localSaida = localSaida;
        ehBloqueada = false;
        itemQueAbre = null;
    }
    
    /**
     * Construtor para objetos da classe Saida que possuem saida bloqueada
     */
    public Saida(Local localSaida, String itemQueAbre)
    {
        this(localSaida);
        
        // Se o item que abre nao for nulo, atualiza o estado para bloqueado
        if (itemQueAbre != null) {
            this.ehBloqueada = true;
            this.itemQueAbre = itemQueAbre;
        }
    }
    
    /**
     * @return O local de saida.
     */
    public Local obterLocalSaida()
    {
        return localSaida;
    }
    
    /**
     * @return Se a saida eh ou nao bloqueada.
     */
    public boolean ehBloqueada()
    {
        return ehBloqueada;
    }
    
    /**
     * @return O nome do item que abre o aquela saida.
     */
    public String obterNomeDoItemQueAbre()
    {
        return itemQueAbre;
    }
    
    /**
     * Desbloqueia a saida.
     */
    public void desbloquear()
    {
        ehBloqueada = false;
    }
}