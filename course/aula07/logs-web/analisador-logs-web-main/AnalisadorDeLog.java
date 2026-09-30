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
    // Onde calcular as contagens de acesso por dia da semana.
    private int[] contagensPorDia;
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
        // Cria o objeto array para armazenar as contagens de acesso por dia.
        contagensPorDia = new int[7];
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
        contagensPorDia = new int[7];
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
        int posMaiorValor = 0;
        for (int i = 0; i < contagensPorHora.length; i++)
        {
            if (contagensPorHora[i] > contagensPorHora[posMaiorValor]) {
                posMaiorValor = i;
            }
        }
        if (posMaiorValor == -1) {
            return -1;
        } else {
            return posMaiorValor;
        }
    }
    
    /**
     * Retorna a hora com a maior quantidade de acessos.
     */
    public int horaMaisTranquila()
    {
        int posMenorValor = 0;
        for (int i = 0; i < contagensPorHora.length; i++)
        {
            if (contagensPorHora[i] < contagensPorHora[posMenorValor]) {
                posMenorValor = i;
            }
        }
        if (posMenorValor == -1) {
            return -1;
        } else {
            return posMenorValor;
        }
    }
     
    /**
     * Retorna o período de duas horas consecutivas com a maior quantidade 
     * de acessos.
     */
    public int duasHorasSeguidasMaisOcupadas()
    {
        int somaDasDuasHorasConsecutivas;
        int maiorSomaConsecutiva = 0;
        int valorHoraAnterior = 0;
        int horaDeInicio = 0;
        for (int i = 0; i < contagensPorHora.length; i++) {
            if (i == 0) {
                valorHoraAnterior = contagensPorHora[i];
            } else {
                int valorHoraAtual = contagensPorHora[i];
                somaDasDuasHorasConsecutivas = valorHoraAnterior + 
                                                valorHoraAtual;
                
                if (somaDasDuasHorasConsecutivas > maiorSomaConsecutiva) {
                    maiorSomaConsecutiva = somaDasDuasHorasConsecutivas;
                    horaDeInicio = i-1;
                }
                
                valorHoraAnterior = valorHoraAtual;
            }
        }
        return horaDeInicio;
    }
    
    /**
     * Analisa os dados de acesso por dia da semana do arquivo de log.
     */
    public void analisarDadosPorDia()
    {
        while(leitor.hasNext()) {
            EntradaDeLog entrada = leitor.next();
            int diaDaSemana = ((entrada.obterDiaDaSemana()-1) % 7) + 1;
            contagensPorDia[diaDaSemana-1]++;
        }
    }
    
    /**
     * Imprime as contagens por dia.
     * Elas devem ter sido definidas com uma chamada
     * anterior de analisarDadosPorHora.
     */
    public void imprimirContagensPorDia()
    {
        String[] nomes = {"Domingo", "Segunda", "Terça", "Quarta",
                  "Quinta", "Sexta", "Sábado"};
        for(int dia = 0; dia < contagensPorDia.length; dia++) {
            System.out.println(nomes[dia] + ": " + contagensPorDia[dia]);
        }
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
