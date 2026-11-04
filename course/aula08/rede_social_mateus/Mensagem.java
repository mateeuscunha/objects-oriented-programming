import java.util.ArrayList;

/**
 * Escreva uma descrição da classe Mensagem aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Mensagem
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nomeAutor;
    private long horaPostagem;
    private int curtidas;
    ArrayList<String> comentarios;

    /**
     * Construtor para objetos da classe Mensagem
     */
    public Mensagem(String nomeAutor)
    {
        this.nomeAutor = nomeAutor;
        horaPostagem = System.currentTimeMillis();
        curtidas = 0;
        comentarios = new ArrayList<>();
    }

    /**
     * Curte a mensagem 
     */
    public void curtir()
    {
        curtidas += 1;
    }
    
    /**
     * Descurte a mensagem 
     */
    public void descurtir()
    {
        curtidas -= 1;
    }
    
    /**
     * Adiciona um comentario
     */
    public void comentar(String comentario)
    {
        comentarios.add(comentario);
    }
    
    /**
     * Retorna um texto que possui o tempo que se passou desde que a mensagem
     * foi postada.
     */
    protected String getTextoTempo() {
        long tempoAtual = System.currentTimeMillis();
        long diferenca = (tempoAtual - horaPostagem);
        long diferencaSeg = diferenca/1000;
        long diferencaMin = diferencaSeg/60;
        if (diferencaMin < 1) {
                return "Há " + diferencaSeg + " segundo(s)";
        }
        else {
                return "Há " + diferencaMin + " minuto(s)";
        }
    }
    
    /**
     * Retorna a mensagem completa
     */
    protected String mensagemCompleta(String textoEspecifico)
    {
        String comentariosFormatados;
        if (comentarios.size() == 0) {
            comentariosFormatados = "Nao ha comentarios.";
        } else {
            comentariosFormatados = "Comentarios: \n   ";
            for (String comentario : comentarios) {
                comentariosFormatados += comentario + "\n";
            }
        }
        
        return nomeAutor + " escreveu: " + textoEspecifico + "\n" +
                getTextoTempo() + "\n" + curtidas + " pessoas curtiram isso!"
                + "\n"+ comentariosFormatados;           
    }
}