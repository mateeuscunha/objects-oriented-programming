import java.util.ArrayList;
import java.util.Iterator;

public class Imobiliaria {
    // coleção de imóveis disponíveis para aluguel na imobiliaria
    private ArrayList<Imovel> imoveisParaAlugar;
    
    /**
     * Cria um objeto imobiliária, sem imóveis para alugar
     */
    public Imobiliaria() {
        imoveisParaAlugar = new ArrayList<>();
    }

    /**
     * Adiciona um imóvel à coleção de imóveis para alugar
     * @param imovel O imóvel a ser adicionado
     */
    public void adicionarImovel(Imovel imovel) {
        imoveisParaAlugar.add(imovel);
    }

    /*
     * Implemente abaixo o método consultarImovel de acordo com o
     * enunciado da Questão 5
     */
    
    public void consultarImoveis(String bairro, int valorMaxAluguel)
    {
        Iterator<Imovel> it = imoveisParaAlugar.iterator();
        boolean imprimiuAlgum = false;
        while (it.hasNext())
        {
            Imovel analisado = it.next();
            
            boolean mesmoBairro = analisado.obterEndereco().verificarBairro(bairro);
            boolean aluguelMenIgual = analisado.obterValorAluguel() <= valorMaxAluguel;
            
            if (mesmoBairro && aluguelMenIgual)
            {
                System.out.println(analisado.obterEndereco().enderecoFormatado() 
                   + " - Aluguel: R$ " + analisado.obterValorAluguel());
                   
                imprimiuAlgum = true;
            }
        }
        
        if (!imprimiuAlgum)
        {
            System.out.println("Nenhum imovel encontrado!");
        }
    }
     

    /**
     * Este método preenche a lista de imóveis para alugar com alugns
     * imóveis para que possa usar em seus testes.
     */
    public void cenarioDeTeste1() {        
        // remove imóveis que existiam anteriormente
        imoveisParaAlugar.clear();

        // adiciona imóveis de teste
        Endereco endereco1 = new Endereco("Rua das Rosas", 25, "Cidade Jardim");
        Imovel imovel1 = new Imovel("João", endereco1, 2500);
        adicionarImovel(imovel1);

        Endereco endereco2 = new Endereco("Rua Nimbus", 38, "Nuvens da Serra");
        Imovel imovel2 = new Imovel("Maria", endereco2, 1500);
        adicionarImovel(imovel2);
        
        Endereco endereco3 = new Endereco("Rua das Margaridas", 410, "Cidade Jardim");
        Imovel imovel3 = new Imovel("Tião", endereco3, 4000);
        adicionarImovel(imovel3);
        }

    /**
     * Este método preenche a lista de imóveis para alugar com outros
     * imóveis para que possa usar em seus testes.
     */
    public void cenarioDeTeste2() {
        imoveisParaAlugar.clear();

        Endereco endereco1 = new Endereco("Rua Alfa", 10, "Bairro Azul");
        Imovel imovel1 = new Imovel("Carlos", endereco1, 1500);
        adicionarImovel(imovel1);

        Endereco endereco2 = new Endereco("Rua Beta", 20, "Bairro Azul");
        Imovel imovel2 = new Imovel("Ana", endereco2, 2000);
        adicionarImovel(imovel2);

        Endereco endereco3 = new Endereco("Rua Gama", 30, "Bairro Verde");
        Imovel imovel3 = new Imovel("Pedro", endereco3, 1600);
        adicionarImovel(imovel3);

        Endereco endereco4 = new Endereco("Rua Delta", 40, "Bairro Verde");
        Imovel imovel4 = new Imovel("Lucia", endereco4, 2500);
        adicionarImovel(imovel4);
    }
}

