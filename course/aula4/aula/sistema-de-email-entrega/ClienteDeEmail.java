/**
 * Uma classe que modela um cliente de e-mail simples.
 * O cliente é executado por um usuário específico, e envia e
 * recebe e-mails através de um servidor específico.
 * 
 * Traduzido por Julio César Alves. 2023-09-22
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class ClienteDeEmail
{
    // O servidor usar para enviar e receber e-mails.
    private ServidorDeEmail servidor;
    // O usuário que está rodando este cliente.
    private String usuario;

    /**
     * Cria uma execução de cliente de e-mail pelo usuário e 
     * ligado ao servidor passado.
     */
    public ClienteDeEmail(ServidorDeEmail servidor, String usuario)
    {
        this.servidor = servidor;
        this.usuario = usuario;
    }

    /**
     * Retorna a próxima mensagem de e-mail do servidor, se houver.
     */
    public Email obterProximoEmail()
    {
        return servidor.obterProximoEmail(usuario);
    }

    /**
     * Imprime no terminal de texto a próxima mensagem de e-mail 
     * deste usuário, se houver.
     */
    public void imprimirProximoEmail()
    {
        Email email = servidor.obterProximoEmail(usuario);
        if(email == null) {
            System.out.println("Não há novos e-mails.");
        }
        else {
            email.imprimir();
        }
    }

    /**
     * Imprime, no terminal, todos os e-mails deste usuário, se houver.
     */
    public void imprimirTodosEmails(String remetente)
    {
        int emailsImpressos = 0;
        Email email = servidor.obterProximoEmail(usuario);
        if (remetente.length() >= 0) {
            while(email != null)
            {
                email.imprimir();
                System.out.println("------------");
                emailsImpressos++;
                email = servidor.obterProximoEmail(usuario);
            }
            System.out.println("Foram impressos " + emailsImpressos + " emails.");
        } else
        {
            while(email != null)
            {
                String remetenteAtual = email.obterRemetente();
                if (remetenteAtual.equals(remetente))
                {
                    email.imprimir();
                    System.out.println("------------");
                    emailsImpressos++;
                    email = servidor.obterProximoEmail(usuario);
                }
                else
                {
                    email = servidor.obterProximoEmail(usuario);
                }
            }
        }
    }
    
    /**
     * Envia a mensagem passada para o destinatário passado
     * usando o servidor de e-mail.
     * @param destinatario O destinatário da mensagem.
     * @param messagem O texto da mensagem a ser enviada.
     */
    public void enviarEmail(String destinatario, String mensagem, 
    String assunto)
    {
        Email email = new Email(usuario, destinatario, mensagem, assunto);
        servidor.postar(email);
    }
    
    public void enviarEmail(String destinatario, String mensagem, 
    String assunto, String anexo)
    {
        Email email = new Email(usuario, destinatario, mensagem, assunto, anexo);
        servidor.postar(email);
    }
}
