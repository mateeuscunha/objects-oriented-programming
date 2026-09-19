public class Evento {
    // nome do evento
    private String nome;
    // tipo do evento (ex.: Show, Festa, Peça teatral, etc.)
    private String tipo;
    // data na qual o evento ocorreu ou ocorrerá
    private Data data;

    /**
     * Cria um evento
     * @param nome O nome do evento
     * @param tipo O tipo do evento
     * @param data A data do evento
     */
    public Evento(String nome, String tipo, Data data) {
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
    }

    /**
     * @return o nome do evento
     */
    public String obterNome() {
        return nome;
    }

    /**
     * @return o tipo do evento
     */
    public String obterTipo() {
        return tipo;
    }

    /**
     * @return a data do evento
     */
    public Data obterData() {
        return data;
    }

}
