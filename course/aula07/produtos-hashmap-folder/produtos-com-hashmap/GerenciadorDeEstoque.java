import java.util.Iterator;
import java.util.HashMap;

/**
 * Gerencia o estoque de uma empresa.
 * Um estoque é formado por zero ou mais produtos.
 * 
 * Traduzido por Julio César Alves - 2023.10.10
 * 
 * @author (seu nome) 
 * @version (a data)
 */

/**
 * RESPOSTA EXERCICIO 3:
 * Ha vantagem em usar o HashMap, pois o codigo ficou menor e mais legivel.
 * Alem disso, o acesso do HashMap eh mais rapido, por isso, se eu iniciasse
 * o projeto do zero, usario o HashMap, nesse caso.
 */
public class GerenciadorDeEstoque
{
    // Uma lista dos produtos.
    private HashMap<Integer, Produto> estoqueId;
    private HashMap<String, Produto> estoqueNome;

    /**
     * Inicializa o gerenciador de estoque.
     */
    public GerenciadorDeEstoque()
    {
        estoqueId = new HashMap<>();
        estoqueNome = new HashMap<>();
    }

    /**
     * Adiciona um produto à lista.
     * @param item O item a ser adicionado.
     */
    public void adicionarProduto(Produto item)
    {
        estoqueId.put(item.obterID(), item);
        estoqueNome.put(item.obterNome(), item);
    }
    
    /**
     * Tenta encontrar um produto no estoque com o identificador passado.
     * @return O produto identificado, ou null se não há nenhum produto
     *         com o identificador passado.
     */
    public Produto encontrarProduto(int idConsulta)
    {
        if(estoqueId.containsKey(idConsulta)) {
            return estoqueId.get(idConsulta);
        }
        else {
            return null;
        }
    }
    
    /**
     * Tenta encontrar um produto no estoque com o nome passado.
     * @return O produto identificado, ou null se não há nenhum produto
     *         com o nome passado.
     */
    public Produto encontrarProduto(String nomeConsulta)
    {
        if (estoqueNome.containsKey(nomeConsulta)) {
            return estoqueNome.get(nomeConsulta);
        }
        return null;
    }
    
    /**
     * Recebe uma entrega de um produto particular.
     * Aumenta a quantidade do produto pela quantidade passada.
     * @param id O identificador do produto.
     * @param quantidade A quantidade a ser aumentada do produto.
     */
    public void receberEntrega(int id, int quantidade)
    {
        Produto produto = encontrarProduto(id);
        if (produto == null)
        {
            System.out.println("ID do produto inexistente no estoque!");
        } else
        {
            produto.aumentarQuantidade(quantidade);
            System.out.println("O produto " + produto.obterNome() +
                                " teve sua quantidade aumentada em " + 
                                produto.obterQuantidade() + " unidades");
        }
    }
    
    /**
     * Localiza um produto com o identificador passado, e retorna
     * quantas unidades dele existem no estoque. Retorna zero
     * se não há nenhum produto com o identificador passado.
     * @param id O identificador do produto.
     * @return A quantidade do produto solicitado em estoque.
     */
    public int quantidadeEmEstoque(int id)
    {
        Produto produtoProcurado = encontrarProduto(id);
        if(produtoProcurado != null)
        {
            return produtoProcurado.obterQuantidade();
        }
        return 0;
    }

    /**
     * Localiza o(s) produto(s) com a quantidade menor que a passada, e imprime
     * os detalhes desse(s) produto(s).
     * @param quantidade Quantidade passada como teto
     */
    public void detalhesDoProdutoEmBaixaNoEstoque(int quantidadeTeto)
    {
        boolean encontrouAlgum = false;
        for (Integer idAnalisado : estoqueId.keySet()) {
            Produto produtoAnalisado = estoqueId.get(idAnalisado);
            if (produtoAnalisado.obterQuantidade() < quantidadeTeto) {
                System.out.println(produtoAnalisado.paraString());
                encontrouAlgum = true;
            }
        }
        if (!encontrouAlgum)
        {
            System.out.println("Nao ha produtos com quantidade inferior a " +
                                quantidadeTeto);
        }
        
        
        /*
        Iterator<Produto> it = estoque.iterator();
        boolean encontrouAlgum = false;
        while(it.hasNext())
        {
            Produto analisado = it.next();
            if (analisado.obterQuantidade() < quantidade)
            {
                System.out.println(analisado.paraString());
                if (!encontrouAlgum)
                {
                    encontrouAlgum = true;
                }
            }
        }
        if (!encontrouAlgum)
        {
            System.out.println("Nao ha produtos com quantidade inferior a " +
                                quantidade);
        }
        */
    }
    
    /**
     * Exibe os detalhes de todos os produtos.
     */
    public void imprimirDetalhesDosProdutos()
    {
        for (Integer identificador : estoqueId.keySet()) {
            Produto produtoAnalisado = estoqueId.get(identificador);
            System.out.println(produtoAnalisado.paraString());
        }
        
        /*
        Iterator<Produto> it = estoque.iterator();
        while (it.hasNext())
        {
            Produto produtoAnalisado = it.next();
            System.out.println(produtoAnalisado.paraString());
        }
        */
    }
}
