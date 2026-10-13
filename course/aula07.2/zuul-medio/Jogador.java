import java.util.HashMap;

/**
 * Essa classe guarda informacoes do jogador.
 */
public class Jogador
{
    private HashMap<String, Item> inventario;
    private Local localAtual;
    private Local localAnterior;
    
    /**
     * Construtor para objetos da classe Jogador
     */
    public Jogador(Local localInicio)
    {
        inventario = new HashMap<>();
        
        localAtual = localInicio;
        localAnterior = null;
    }

    /**
     * Retorna o local atual do jogador.
     */
    public Local obterLocalAtual()
    {
        return localAtual;
    }
    
    /**
     * Retorna o local visitado anteriormente pelo jogador.
     */
    public Local obterLocalAnterior()
    {
        return localAnterior;
    }
    
    /**
     * Adiciona um item ao inventario.
     */
    public void adicionarItemAoInventario(Item item)
    {
        inventario.put(item.obterNome(), item);
    }
    
    /**
     * Remove um item da colecao a partir de seu nome.
     */
    public boolean removerItemDoInventario(String nomeDoItem)
    {
        if(inventario.remove(nomeDoItem) == null) {
            System.out.println("Nao existe um item com esse nome no seu inventario!");
            return false;
        }
        
        inventario.remove(nomeDoItem);
        System.out.println("O item " + nomeDoItem + " foi removido com sucesso");
        return true;
    }
    
    /**
     * Retorna uma string contendo todos os itens do inventario do jogador.
     */
    public String itensDoInventario()
    {
        if (inventario.isEmpty()) {
            return "O seu inventario esta vazio!";
        }
        
        String retorno = "";
        for (Item analisado : inventario.values()) {
            retorno += analisado.obterNome() + " ";
        }
        
        // tratando a string
        
        retorno = retorno.trim(); // tira o caracter de espaco do final
        retorno = retorno.replace(" ", ", ") + "."; // coloca virgulas e um ponto no fim
        retorno = "Inventario: " + retorno;
        return retorno;
    }
    
    /**
     * Consulta se o jogador possui aquele item no inventario.
     */
    public boolean consultarSeTemItem(String nomeDoitemConsulta)
    {
        nomeDoitemConsulta = nomeDoitemConsulta.toLowerCase();
        String todosOsItens = itensDoInventario().toLowerCase();
        
        if (todosOsItens.contains(nomeDoitemConsulta)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Usa o item no local em que o jogador se encontra.
     */
    public boolean usarItem(Item itemASerUtilizado) {
        return localAtual.usarItem(itemASerUtilizado);
    }
    
    /**
     * Usa o item no local em que o jogador se encontra, recebendo apenas o nome do item.
     */
    public boolean usarItem(String nomeItemASerUtilizado) {
        Item item = inventario.get(nomeItemASerUtilizado);
        return localAtual.usarItem(item);
    }
    
    /**
     * Exibe a localizacao atual do jogador
     */
    public void exibirLocalizacaoAtual() {
        System.out.println(localAtual.obterDescricaoLonga());
    }
    
    /**
     * Atualiza o local atual e, por consequencia, o anterior.
     */
    public void atualizarLocalAtual(Local novoLocal)
    {
        localAnterior = localAtual;
        localAtual = novoLocal;
    }
}