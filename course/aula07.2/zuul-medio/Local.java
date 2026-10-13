import java.util.HashMap;

/**
 * Classe Local - um local em um jogo adventure.
 *
 * Esta classe eh parte da aplicacao "World of Zuul".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Local" representa um lugar no cenario do jogo. Ele eh conectado 
 * aos outros locais atraves de saidas. As saidas sao nomeadas como 
 * norte, sul, leste e oeste. Para cada direcao, o local guarda uma 
 * referencia para o local vizinho, ou null se nao ha saida naquela 
 * direcao.
 * 
 * Traduzido por Julio César Alves. Versão: 2023.10.21
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Local 
{
    private String descricao;
    private HashMap<String, Saida> saidas;
    private Item item;

    /**
     * Cria um local com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma cozinha" ou
     * "um jardim aberto".
     * @param descricao A descricao do local.
     */
    public Local(String descricao) 
    {
        saidas = new HashMap<>();
        this.descricao = descricao;
    }

    /**
     * Cria um local com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma cozinha" ou
     * "um jardim aberto".
     * @param descricao A descricao do local.
     * @param item O item que esta naquele local.
     */
    public Local(String descricao, Item item) 
    {
        saidas = new HashMap<>();
        this.descricao = descricao;
        this.item = item;
    }
    
    /**
     * Ajusta uma saida desbloqueada do local
     */
    public void ajustarSaida(String direcao, Local localSaida) {
        Saida saida = new Saida(localSaida);
        saidas.put(direcao, saida);
    }
    
    /**
     * Ajusta uma saida bloqueada do local
     */
    public void ajustarSaidaBloqueada(String direcao, Local localSaida, String itemDesbloqueio) {
        Saida saida = new Saida(localSaida, itemDesbloqueio);
        saidas.put(direcao, saida);
    }
    
    /**
     * Se a saida existe e nao eh bloqueada, retorna a saida a partir
     * da direcao informada. Se nao existe saida para aquela direcao, ou a saida eh
     * bloqueada, retorna null.
     */
    public Saida getSaida(String direcao) {
        Saida saida = saidas.get(direcao);
        if(saida != null && !saida.ehBloqueada()) {
            return saida;
        }
        return null;
    }
    
    /**
     * @return As possiveis direcoes de saida numa string
     */
    public String direcoesDeSaida() {
        String direcoes = "";
        for (String direcao : saidas.keySet()) {
            direcoes += direcao + " ";
        }
        return direcoes;
    }

    /**
     * @return A descricao do local.
     */
    public String obterDescricao()
    {
        return descricao;
    }
    
    /**
     * @return Se true se tem algum item para coletar no local.
     */
    public boolean temItem() {
        boolean temItem = false;
        if (item != null) {
           temItem = true; 
        }
        return temItem;
    }
    
    /**
     * @return O item do local, se tiver, e null, se nao tiver.
     */
    public Item obterItem() {
        return item;
    }
    
    /**
     * Coleta o item que estava no local, ele eh excluido, pois vai para o inventario
     * do jogador.
     */
    public Item coletarItem() {
        Item itemAuxiliar = item;
        item = null;
        return itemAuxiliar; // retorna null quando nao ha item pra coletar
    }
    
    /**
     * Usa determinado item no local.
     * Se alguma saida daquele local tiver o item como desbloqueio, ela eh desbloqueada.
     * 
     * @return Verdadeiro se desbloquear alguma saida.
     */
    public boolean usarItem(Item itemASerUtilizado) {
        String nomeDoItem = itemASerUtilizado.obterNome();
        boolean debloqueouAlguma = false;
        
        for (Saida analisada : saidas.values()) {
            String nomeAnalisado = analisada.obterNomeDoItemQueAbre();
            if (nomeAnalisado == nomeDoItem) {
                analisada.desbloquear();
                debloqueouAlguma = true;
            }
        }
        
        return debloqueouAlguma;
    }
    
    /**
     * @return A descricao completa do local.
     */
    public String obterDescricaoLonga() {
        String descricaoLonga = "Voce esta " + descricao + "\n";
        if (temItem()) {
            descricaoLonga += "Ha um(a) " + item.obterDescricao() + " por aqui." + "\n\n";
        } else {
            descricaoLonga += "Nao ha nada aqui" + "\n\n";
        }
        descricaoLonga += "Saidas: " + direcoesDeSaida();
        return descricaoLonga;
    }
    
}
