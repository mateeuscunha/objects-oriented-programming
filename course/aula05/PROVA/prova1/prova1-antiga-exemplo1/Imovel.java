public class Imovel {
    // nome do proprietário do imóvel
    private String proprietario;
    // endereço do imóvel
    private Endereco endereco;
    // valor do aluguel do imóvel
    private int valorAluguel;

    /**
     * Cria um imóvel a ser alugado
     * @param nomeProprietario O nome do proprietário do imóvel
     * @param endereco O endereço do imóvel
     * @param valorAluguel O valor do alugueĺ do imóvel
     */
    public Imovel(String nomeProprietario, Endereco endereco, int valorAluguel) {
        proprietario = nomeProprietario;
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
    }

    /**
     * @return o nome do proprietário do imóvel
     */
    public String obterProprietario() {
        return proprietario;
    }

    /**
     * @return o endereço do imóvel
     */
    public Endereco obterEndereco() {
        return endereco;
    }

    /**
     * @return o valor do alugueĺ do imóvel
     */
    public int obterValorAluguel() {
        return valorAluguel;
    }    
}
