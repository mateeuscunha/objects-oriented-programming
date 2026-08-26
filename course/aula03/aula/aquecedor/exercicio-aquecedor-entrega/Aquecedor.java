
/**
 * Escreva uma descrição da classe Aquecedor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Aquecedor
{
    // atributos
    private double temperatura;
    private double min;
    private double max;
    private double incremento;
    
    /**
     * Construtor para objetos da classe Aquecedor
     */
    public Aquecedor(double valorMin, double valorMax)
    {
        temperatura = 20.0;
        min = valorMin;
        max = valorMax;
        incremento = 3.0;
    }
    
    /**
     * Aumenta a temperatura em 3.0 graus
     */
    public void esquentar()
    {
        if ((temperatura + incremento) <= max)
        {
            temperatura += incremento;    
        } else
        {
            System.out.println("O valor maximo e: " + max);
        }
    }
    
    /**
     * Diminui a temperatura em 3.0 graus
     */
    public void esfriar()
    {
        if ((temperatura - incremento) >= min)
        {
            temperatura -= incremento;    
        } else
        {
            System.out.println("O valor minimo e: " + min);
        }
    }
    
    /**
     * Retorna o valor da temperatura do aquecedor
     */
    public double obterTemperatura()
    {
        return temperatura;
    }
    
    /**
     * Muda o valor do incremento (so aceita valores positivos)
     */
    public void mudarIncremento(double novoIncremento)
    {
        if (novoIncremento < 0)
        {
            System.out.println("O incremento deve ser positivo!");
        } else
        {
            incremento = novoIncremento;
        }
    }
}