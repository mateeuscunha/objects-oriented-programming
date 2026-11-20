import java.util.HashMap;
import java.util.Map;

/**
 * Escreva uma descrição da classe Zoologico aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Zoologico
{
    // nao havera animais com nomes diferentes !!!
    private HashMap<String, Gorila> gorilas;
    private HashMap<String, Leao> leoes;
    private HashMap<String, Ema> emas;
    private HashMap<String, Arara> araras;

    /**
     * Construtor para objetos da classe Zoologico
     */
    public Zoologico()
    {
        gorilas = new HashMap<>();
        leoes = new HashMap<>();
        emas = new HashMap<>();
        araras = new HashMap<>();
    }

    public void adicionarGorila(String nome) {
        Gorila gorila = new Gorila(nome);

        gorilas.put(nome, gorila);
    }

    public void adicionarLeao(String nome) {
        Leao leao = new Leao(nome);

        leoes.put(nome, leao);
    }

    public void adicionarEma(String nome) {
        Ema ema = new Ema(nome);

        emas.put(nome, ema);
    }

    public void adicionarArara(String nome) {
        Arara arara = new Arara(nome);

        araras.put(nome, arara);
    }

    public String getDescricaoDoAnimal(String nome) {
        String descricao = "";

        if (gorilas.get(nome) != null) {
            descricao = gorilas.get(nome).obterDescricaoCompleta();
        }

        if (descricao.equals("")) {
            if (leoes.get(nome) != null) {
                descricao = leoes.get(nome).obterDescricaoCompleta();
            }
        }

        if (descricao.equals("")) {
            if (emas.get(nome) != null) {
                descricao = emas.get(nome).obterDescricaoCompleta();
            }
        }
        
        if (descricao.equals("")) {
            if (araras.get(nome) != null) {
                descricao = araras.get(nome).obterDescricaoCompleta();
            }
        }

        return descricao;
    }
    
    public String getDescricaoResumidaTodosAnimais() {
        String separador = "\n";
        String conjuntoDescricoes = "";
        
        for(Map.Entry<String, Gorila> chaveValor : gorilas.entrySet()) {
            Gorila analisado = chaveValor.getValue();
            conjuntoDescricoes += analisado.obterDescricaoResumida() + separador;
        }
        
        for(Map.Entry<String, Leao> chaveValor : leoes.entrySet()) {
            Leao analisado = chaveValor.getValue();
            conjuntoDescricoes += analisado.obterDescricaoResumida() + separador;
        }
        
        for(Map.Entry<String, Ema> chaveValor : emas.entrySet()) {
            Ema analisada = chaveValor.getValue();
            conjuntoDescricoes += analisada.obterDescricaoResumida() + separador;
        }
        
        for(Map.Entry<String, Arara> chaveValor : araras.entrySet()) {
            Arara analisada = chaveValor.getValue();
            conjuntoDescricoes += analisada.obterDescricaoResumida() + separador;
        }
        
        return conjuntoDescricoes;
    }
    
    public String getDescricaoCompletaTodosAnimais() {
        String separador = "\n";
        String conjuntoDescricoes = "";
        
        for(Map.Entry<String, Gorila> chaveValor : gorilas.entrySet()) {
            Gorila analisado = chaveValor.getValue();
            conjuntoDescricoes += analisado.obterDescricaoCompleta() + separador;
        }
        
        for(Map.Entry<String, Leao> chaveValor : leoes.entrySet()) {
            Leao analisado = chaveValor.getValue();
            conjuntoDescricoes += analisado.obterDescricaoCompleta() + separador;
        }
        
        for(Map.Entry<String, Ema> chaveValor : emas.entrySet()) {
            Ema analisada = chaveValor.getValue();
            conjuntoDescricoes += analisada.obterDescricaoCompleta() + separador;
        }
        
        for(Map.Entry<String, Arara> chaveValor : araras.entrySet()) {
            Arara analisada = chaveValor.getValue();
            conjuntoDescricoes += analisada.obterDescricaoCompleta() + separador;
        }
        
        return conjuntoDescricoes;
    }
}