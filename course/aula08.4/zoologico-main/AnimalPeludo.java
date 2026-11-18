
/**
 * Escreva uma descrição da classe AnimalPeludo aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public abstract class AnimalPeludo extends Animal
{
    private String corDoPelo;

    /**
     * Construtor para objetos da classe AnimalPeludo
     */
    public AnimalPeludo(String nome, String especie, int numeroPatas, String som, String corDoPelo)
    {
        super(nome, especie, numeroPatas, som);
        this.corDoPelo = corDoPelo;
    }   

    public String obterCorDoPelo() {
        return corDoPelo;
    }
    
    @Override
    public String obterDescricaoCompleta() {
        return super.obterDescricaoCompleta() + " e tem pelo " + corDoPelo;
    }
}