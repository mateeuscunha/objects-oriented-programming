public class Endereco {
    // atributos da classe
    private String rua;
    private int numero;
    private String bairro;
    
    public Endereco(String rua, int numero, String bairro)
    {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }
    
    public String enderecoFormatado()
    {
        String formatacao = rua + ", " + numero + " - " + bairro;
        
        return formatacao;
    }
    
    public boolean verificarBairro(String possivelBairro)
    {
        boolean ehDoBairro = false;
        if (bairro.toUpperCase().equals(possivelBairro.toUpperCase()))
        {
            ehDoBairro = true;
        }
        return ehDoBairro;
    }
}
