/**
 * MaquinaIngressos modela uma máquina de ingressos ingênua que
 * emite ingressos de preço fixo.
 * O preço de um ingresso é definido através do construtor.
 * É uma máquina ingênua porque ela confia que os clientes
 * colocarão a quantidade de dinheiro suficiente antes de tentar
 * emitir um ingresso.
 * Ela também assume que os clientes colocarão quantidades
 * razoáveis.
 * 
 * Traduzido por Julio César Alves - 2023-08-31
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MaquinaIngressos
{
    // O preço de um ingresso desta máquina
    private int preco;
    // A quantidade de dinheiro que o usuário colocou até o momento.
    private int saldo;
    // A quantidade total de dinheiro coletada pela máquina.
    private int total;
    // Nome da empresa que vende os ingressos
    private String nome;

    /**
     * Cria uma máquina que emite ingressos de um dado preço.
     * Note que o preço deve ser maior que zero, e não tem
     * nenhuma verificação para garantir isso.
     */
    
    public MaquinaIngressos(String nomeEmpresa)
    {
        // Com a fixacao do preco e remocao do parametro, ao criar uma maquina,
        // nao aparece o campo para preencher o parametro custoIngresso
        preco = 1000; //Preco fixado em 1000 centavos
        saldo = 0;
        total = 0;
        nome = nomeEmpresa;
    }
    /**
     * Segundo construtor, esse precisa passar o valor do ingresso.
     */
    public MaquinaIngressos(int custoIngresso, String nomeEmpresa)
    {
        // Com a criacao do segundo construtor, passa a aparecer duas opcoes
        // para criar um objeto, uma passando parametro e outra sem passar
        preco = custoIngresso;
        saldo = 0;
        total = 0;
        nome = nomeEmpresa;
    }
    /**
     * Esse e um metodo de acesso, que mostra o valor total arrecadado
     * na maquina.
     */
    
    public int obterTotal()
    {
        return total;
    }
    
    /**
     * Esse e um metodo modificador, ja que ele altera (modifica) o valor da 
     * variavel 'total', atribuindo a ela valor zero.
     */
    public void esvaziar()
    {
       total = 0; 
    }
    
    /**
     * Esse metodo mostra o nome da empresa no terminal.
     */
    public String obterNome()
    {
        return nome;
    }
    
    /**
     * Retorna o preço do ingresso.
     */
    public int obterPreco()
    {
        return preco;
    }

    /**
     * Retorna a quantidade de dinheiro já inserida para o
     * próximo ingresso.
     */
    public int obterSaldo()
    {
        return saldo;
    }

    /**
     * Recebe uma quantidade de dinheiro de um cliente.
     */
    public void inserirDinheiro(int quantidade)
    {
        saldo = saldo + quantidade;
    }

    /**
     * Imprime um ingresso.
     * Atualiza o total coletado e reduz o saldo para zero.
     */
    public void imprimirIngresso(String nomeComprador)
    {
        // Simula a impressão de um ingresso
        int reais = preco / 100;
        int centavos = preco % 100;
        String precoFormatado = String.format("R$ %d, %02d", reais, centavos);
        System.out.println("##################");
        System.out.println("# " + nome + " ");
        System.out.println("# Ingresso");
        System.out.println("# R$ " + precoFormatado);
        System.out.println("# Comprador: " + nomeComprador + " ");
        System.out.println("##################");
        System.out.println();

        // Atualiza o total coletado com o saldo
        total = total + saldo;
        // Zera o saldo
        saldo = 0;
    }
}
