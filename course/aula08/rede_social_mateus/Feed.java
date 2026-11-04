import java.util.ArrayList;

/**
 * Escreva uma descrição da classe Feed aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Feed
{
    ArrayList<MensagemTexto> mensagensTexto;
    ArrayList<MensagemFoto> mensagensFoto;
    
    /**
     * Construtor para objetos da classe Feed
     */
    public Feed()
    {
        mensagensTexto = new ArrayList<>();
        mensagensFoto = new ArrayList<>();
    }

    /**
     * Posta mensagem de texto
     */
    public void postarMensagemTexto(MensagemTexto mensagem) {
        mensagensTexto.add(mensagem);
        System.out.println("Post publicado!");
    }
    
    /**
     * Posta mensagem com foto
     */
    public void postarMensagemFoto(MensagemFoto mensagem) {
        mensagensFoto.add(mensagem);
        System.out.println("Post publicado!");
    }
    
    /**
     * Exibe todas as publicacoes
     */
    public void exibirPostagens() {
        if (mensagensTexto.size() != 0) {
            for(MensagemTexto mensagem : mensagensTexto) {
                System.out.println(mensagem.mensagemCompleta() + "\n");
            }
        }
        
        if (mensagensFoto.size() != 0) {
            for(MensagemFoto mensagem : mensagensFoto) {
                System.out.println(mensagem.mensagemCompleta() + "\n");
            }
        }
    }
    
    /**
     * Curte uma mensagem
     */
    public void curtirMensagem(boolean temFoto, int posicaoNaLista) {
        if (!temFoto) {
            if (posicaoNaLista < mensagensTexto.size() && posicaoNaLista >= 0) {
                MensagemTexto mensagem = mensagensTexto.get(posicaoNaLista);
                mensagem.curtir();
                System.out.println("Mensagem curtida");
            }
        } else {
            if (posicaoNaLista < mensagensFoto.size() && posicaoNaLista >= 0) {
                MensagemFoto mensagem = mensagensFoto.get(posicaoNaLista);
                mensagem.curtir();
                System.out.println("Mensagem curtida");
            }
        }
    }
    
    /**
     * Faz um comentario em uma mensagem
     */
    public void comentarEmMensagem(boolean temFoto, int posicaoNaLista, String comentario) {
        if (!temFoto) {
            if (posicaoNaLista < mensagensTexto.size() && posicaoNaLista >= 0) {
                MensagemTexto mensagem = mensagensTexto.get(posicaoNaLista);
                mensagem.comentar(comentario);
                System.out.println("Mensagem curtida");
            }
        } else {
            if (posicaoNaLista < mensagensFoto.size() && posicaoNaLista >= 0) {
                MensagemFoto mensagem = mensagensFoto.get(posicaoNaLista);
                mensagem.comentar(comentario);
                System.out.println("Mensagem curtida");
            }
        }
    }
}