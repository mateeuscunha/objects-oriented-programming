
/**
 * Escreva uma descrição da classe Animal aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public abstract class Animal
{
    private String nome;
    private String especie;
    private int numeroPatas;
    private String som;

    /**
     * Construtor para objetos da classe Animal
     */
    public Animal(String nome, String especie, int numeroPatas, String som)
    {
        this.nome = nome;
        this.especie = especie;
        this.numeroPatas = numeroPatas;
        this.som = som;
    }

    public String obterNome() {
        return nome;
    }
    
    public String obterEspecie() {
        return especie;
    }

    public int obterNumeroPatas() {
        return numeroPatas;
    }
    
    public String obterSom() {
        return som;
    }
    
    public String obterDescricaoResumida() {
        return nome + " é um(a) " + especie;
    }
    
    public String obterDescricaoCompleta() {
        return obterDescricaoResumida() + " que faz " + som;
    }
}