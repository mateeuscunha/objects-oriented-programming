
/**
 * Escreva uma descrição da classe AnimalVoador aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public abstract class AnimalVoador extends Animal
{
    private boolean voaBem;

    /**
     * Construtor para objetos da classe AnimalVoador
     */
    public AnimalVoador(String nome, String especie, int numeroPatas, String som, boolean voaBem)
    {
        super(nome, especie, numeroPatas, som);
        this.voaBem = voaBem;
    }

    public boolean obterVoaBem() {
        return voaBem;
    }
    
    @Override
    public String obterDescricaoCompleta() {
        String bemOuMal = "mal";
        if (voaBem) {
            bemOuMal = "bem";
        }
        
        return super.obterDescricaoCompleta() + " e voa " + bemOuMal;
    }
}