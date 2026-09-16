
/**
 * A classe VisorDeRelogio implementa um visor de relógio digital.
 * O relógio mostra horas, minutos e segundos.
 * O relógio marca de 00:00:00 (meia-noite)
 * até 23:59:59 (um segundo para meia-noite).
 * 
 * O visor do relógio recebe "tique-taques" (através do método tiqueTaque) a
 * cada segundo e reage incrementado o valor do visor. Isso é feito como é em
 * um relógio, o minuto incrementa quando os segundos voltam para zero e assim
 * por diante.
 * 
 * Traduzido por Julio César Alves - 2023.09.15
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

/*        RESPOSTA DO DESAFIO
 * É possível que um objeto VisorDeNumero informe a outro objeto que ele
 * voltou para zero para que este seja incrementado, basta criar um parâmetro
 * referente ao próximo visor e configurar para que os visores conversem
 * corretamente entre si.
 * O método tiqueTaque deveria interagir apenas com o VisorDeNúmero que
 * está 'tiquetateando', no caso, os segundo. Ele deve apenas incrementar os
 * segundos que, por sua vez, notifica os minutos e assim por diante.
 * Quando um dia inteiro se passa, o objeto horas deve voltar a zero, como
 * acontece com todos os outros (minutos e segundos), mas, dessa vez,
 * como 'horas' é o último visor, ele não deve avisar nenhum outro que
 * seu ciclo zerou.
 */

public class VisorDeRelogio
{
    private VisorDeNumero horas;
    private VisorDeNumero minutos;
    private VisorDeNumero segundos;
    private String stringVisor;    // simula o visor real
    
    /**
     * Construtor para objetos VisorDeRelogio. Este construtor
     * cria um novo relógio marcando 00:00.
     */
    public VisorDeRelogio()
    {
        // Criando os visores, ainda sem conexao entre si
        horas = new VisorDeNumero(24);
        minutos = new VisorDeNumero(60);
        segundos = new VisorDeNumero(60);
        // Agora a configuracao da cadeia de notificacoes
        segundos.definirProximoVisor(minutos);
        minutos.definirProximoVisor(horas);
        
        atualizarVisor();
    }

    /**
     * Construtor para objetos VisorDeRelogio. Este construtor
     * cria um novo relógio marcando as horas de acordo com 
     * os parâmetros recebidos.
     */
    public VisorDeRelogio(int hora, int minuto, int segundo)
    {
        this();  // Chama o construtor padrão para configurar a cadeia
        definirHora(hora, minuto, segundo);
        // Aprendi a mexer com o this() para chamar construtores e estou usando
    }

    /**
     * Este método deveria ser chamado uma vez a cada segundo -
     * ele faz o visor do relógio passar um segundo.
     */
    public void tiqueTaque()
    {
        segundos.incrementar();
        
        atualizarVisor();
    }

    /**
     * Define a hora do visor de acordo com o valor de hora e
     * minuto recebidos por parâmetro.
     */
    public void definirHora(int hora, int minuto, int segundo)
    {
        horas.definirValor(hora);
        minutos.definirValor(minuto);
        segundos.definirValor(segundo);
        
        atualizarVisor();
    }

    /**
     * Retorna a hora atual do visor no formato HH:MM:SS.
     */
    public String obterHora()
    {
        return stringVisor;
    }
    
    /**
     * Atualiza a string interna que representa o visor.
     */
    private void atualizarVisor()
    {
        stringVisor = horas.obterValorVisor() + ":" + 
                        minutos.obterValorVisor() + ":" +
                        segundos.obterValorVisor();
    }
}
