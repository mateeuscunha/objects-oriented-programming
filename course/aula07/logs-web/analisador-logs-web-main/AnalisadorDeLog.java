/**
 * Lê dados de servidor web e analisa padrões de acesso por hora.
 * 
 * Traduzido por Julio César Alves - 2026-09-26
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class AnalisadorDeLog
{
    // Onde calcular as contagens de acesso por hora.
    private int[] contagensPorHora;
    // Usa um LeitorDeArquivoDeLog para acessar os dados.
    private LeitorDeArquivoDeLog leitor;

    /**
     * Cria um objeto para analisar acessos web por hora.
     */
    public AnalisadorDeLog()
    { 
        // Cria o objeto array para armazenar as
        // contagens de acesso por hora.
        contagensPorHora = new int[24];
        // Cria o leitor para obter os dados.
        leitor = new LeitorDeArquivoDeLog();
    }
    
    /**
     * Cria um objeto para analisar acessos web por hora, recebendo o nome do
     * arquivo para analise como parametro e utilizando-o para iniciar o 
     * leitor de arquivo de log.
     */
    public AnalisadorDeLog(String nomeArquivo)
    {
        contagensPorHora = new int[24];
        leitor = new LeitorDeArquivoDeLog(nomeArquivo);
    }
    
    /**
     * Retorna a quantidade total de acessos armazenados em um arquivo log
     */
    public int numeroDeAcessos()
    {
        int totalAcessos = 0;
        for (int i = 0; i < contagensPorHora.length; i++) {
            totalAcessos = totalAcessos + contagensPorHora[i];
        }
        return totalAcessos;
    }
    
    /**
     * Retorna a hora com a maior quantidade de acessos.
     */
    public int horaMaisOcupada()
    {
        for (int i = 0; i < contagensPorHora.length
    }
    
    /**
     * Analisa os dados de acesso por hora do arquivo de log.
     */
    public void analisarDadosPorHora()
    {
        while(leitor.hasNext()) {
            EntradaDeLog entrada = leitor.next();
            int hora = entrada.obterHora();
            contagensPorHora[hora]++;
        }
    }

    /**
     * Imprime as contagens por hora.
     * Elas devem ter sido definidas com uma chamada
     * anterior de analisarDadosPorHora.
     */
    public void imprimirContagensPorHora()
    {
        System.out.println("Hora: Contagem");
        for(int hora = 0; hora < contagensPorHora.length; hora++) {
            System.out.println(hora + ": " + contagensPorHora[hora]);
        }
    }
    
    /**
     * Imprime as linhas de dados lidas pelo LeitorArquivoLog.
     */
    public void imprimirDados()
    {
        leitor.imprimirDados();
    }
}
