import java.util.ArrayList;

/**
 * Escreva uma descrição da classe MensagemTexto aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class MensagemTexto extends Mensagem
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String mensagem;

    /**
     * Construtor para objetos da classe MensagemTexto
     */
    public MensagemTexto(String nomeAutor, String mensagem)
    {
        super(nomeAutor);
        this.mensagem = mensagem;
    }

    /**
     * Retorna a mensagem completa
     */
    public String mensagemCompleta()
    {
        return mensagemCompleta(mensagem);
    }
}