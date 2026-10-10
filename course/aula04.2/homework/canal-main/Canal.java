import java.util.ArrayList;

/**
 * Armazena os detalhes das inscrições em um canal
 * 
 * @author (seu nome)
 * @version (um número de versão ou uma data)
 */
public class Canal
{
    private ArrayList<Inscricao> inscricoes;
    
    /**
     * Construtor de objetos da classe Canal
     */
    public Canal()
    {
        inscricoes = new ArrayList<>();        
    }

    /**
     * Adiciona um novo incrito na lista de inscritos do canal.
     * @param inscricao O objeto inscricao a ser adicionado.
     */
    public boolean inscrever(Inscricao possivelInscricao)
    {
        boolean foiInscrito = false;
        String nomePossivelInscrito = possivelInscricao.obterNome();
        if (!estaInscrito(nomePossivelInscrito))
        {
            inscricoes.add(possivelInscricao);
            foiInscrito = true;
        }
        return foiInscrito;
    }

    /**
     * @return O número de inscritos (objetos Inscricao) no canal.
     */
    public int quantidadeDeInscritos()
    {
        return inscricoes.size();
    }
    
    /** 
     * Retorna quantos membros se inscreveram em um dado mês.
     * @param mes O mês que estamos interessados.
     * @return Quandos membros se inscreveram no mês.
     */
    public int inscritosNoMes(int mes)
    {
        if (mes<1 || mes>12)
        {
            System.out.println("Mes invalido. Digite um valor de 1 a 12");
            return 0;
        } else
        {
            int inscricoesNesseMes = 0;
            for (Inscricao analisada: inscricoes)
            {
                int mesAnalisado = analisada.obterMes();
                if (mesAnalisado == mes)
                {
                    inscricoesNesseMes++;
                }
            }
            return inscricoesNesseMes;
        }
    }
    
        /**
     * Retorna se o canal tem alguém inscrito com o nome passado.
     * @param nome O nome a ser procurado na lista de inscritos.
     * @return Retorna true se tem alguém inscrito com o nome passado,
     *         e false em caso contrário
     */
    public boolean estaInscrito(String nome)
    {
        boolean existeAlguma = false;
        for (Inscricao analisada : inscricoes)
        {
            String nomeAnalisado = analisada.obterNome().toUpperCase();
            if (nomeAnalisado.equals(nome.toUpperCase()))
            {
                existeAlguma = true;
            }
        }
        return existeAlguma;
    }
    
        /**
     * Remove todos os membros da classe `Canal` que se inscreveram em um dado
     * mês de um determinado ano, e os retorna em um objeto coleção separado.
     * @param mes O mês da inscrição.
     * @param ano O ano da inscrição.
     */
    public ArrayList removerInscritos(int mes, int ano)
    {
        ArrayList<Inscricao> removidos = new ArrayList<>();
        if (mes<1 || mes>12)
        {
            System.out.println("Mes invalido. Digite um valor de 1 a 12");
        } else
        {
            for (Inscricao analisada : inscricoes)
            {
                int mesAnalisado = analisada.obterMes();
                int anoAnalisado = analisada.obterAno();
                
                boolean mesIgual = mesAnalisado == mes;
                boolean anoIgual = anoAnalisado == ano;
                
                if (mesIgual && anoIgual)
                {
                    removidos.add(analisada);
                    // inscricoes.remove(analisada);
                }
            }
        }
        return removidos;
    }
}
