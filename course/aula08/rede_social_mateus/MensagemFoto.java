
/**
 * Escreva uma descrição da classe MensagemFoto aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class MensagemFoto extends Mensagem
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String arquivoImagem;
    private String legendaFoto;
    
    /**
     * Construtor para objetos da classe MensagemFoto
     */
    public MensagemFoto(String nomeAutor, String arquivoImagem, String legendaFoto)
    {
        super(nomeAutor);
        this.arquivoImagem = arquivoImagem;
        this.legendaFoto = legendaFoto;
    }

    /**
     * Retorna a mensagem completa
     */
    public String mensagemCompleta()
    {
        String textoEspecifico = arquivoImagem + "<legenda:" + legendaFoto + ">";
        
        return mensagemCompleta(textoEspecifico);
    }
}