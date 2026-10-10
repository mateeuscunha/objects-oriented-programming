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
    private HashMap<String, Local> saidas;
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

    public void ajustarSaida(String direcao, Local saida) {
        saidas.put(direcao, saida);
    }
    
    public Local getSaida(String direcao) {
        return saidas.get(direcao);
    }
    
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
    
    public boolean temItem() {
        boolean temItem = false;
        if (item != null) {
           temItem = true; 
        }
        return temItem;
    }
    
    public Item obterItem() {
        return item;
    }
    
    public Item coletarItem() {
        Item itemAuxiliar = item;
        item = null;
        return itemAuxiliar; // retorna null quando nao ha item pra coletar
    }
    
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
