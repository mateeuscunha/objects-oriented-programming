import java.util.HashMap;

/**
 * Escreva uma descrição da classe Zoologico aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Zoologico
{
    private HashMap<String, Gorila> gorilas;
    private HashMap<String, Leao> leoes;
    private HashMap<String, Ema> emas;
    private HashMap<String, Arara> araras;

    /**
     * Construtor para objetos da classe Zoologico
     */
    public Zoologico()
    {
        // inicializa variáveis de instância
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
}