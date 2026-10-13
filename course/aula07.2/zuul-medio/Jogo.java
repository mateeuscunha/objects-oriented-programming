/**
 *  Essa eh a classe principal da aplicacao "World of Zull".
 *  "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.
 *  Usuarios podem caminhar em um cenario. E eh tudo! Ele realmente
 *  precisa ser estendido para fazer algo interessante!
 * 
 *  Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 *  "jogar".
 * 
 *  Essa classe principal cria e inicializa todas as outras: ela cria os
 *  locais, cria o analisador e comeca o jogo. Ela tambeme avalia e 
 *  executa os comandos que o analisador retorna.
 * 
 * Traduzido por Julio César Alves. Versão: 2023.10.21
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Jogo 
{
    private Analisador analisador;
    private Jogador jogador;
    private Local localInicio;
    
    //private Local localAtual;
    //private Local localAnterior;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() 
    {
        criarLocais();
        analisador = new Analisador();
        jogador = new Jogador(localInicio);
        //localAnterior = null;
    }

    /**
     * Cria todos os locais e liga as saidas deles.
     */
    private void criarLocais()
    {
        Local aldeia, caverna, vila, postoGuarda, temploDeserto, monumentoOceano;
        Item chave, picareta, escafandro;
        
        // cria os items
        chave = new Item("chave", "chave rara que permite abrir um bau do mapa");
        picareta = new Item("picareta", "picareta de ferro para ajudar na mineracao");
        escafandro = new Item("escafandro", "escafandro para explorar o oceano");
        
        // cria os locais
        aldeia = new Local("na sua aldeia, junto com seus amigos");
        caverna = new Local("dentro da caverna misteriosa", escafandro);
        vila = new Local("na vila mistica do povo anciao");
        postoGuarda = new Local("no posto de inimigos arqueiros", picareta);
        temploDeserto = new Local("no templo do deserto, recheado de armadilhas", chave);
        monumentoOceano = new Local("no monumento do oceano, cuidado com os tubaroes");
        
        // inicializa as saidas dos locais
        aldeia.ajustarSaida("sul", caverna);
        aldeia.ajustarSaida("leste", vila);
        aldeia.ajustarSaida("oeste", postoGuarda);
        
        postoGuarda.ajustarSaidaBloqueada("oeste", monumentoOceano, "escafandro");
        postoGuarda.ajustarSaida("leste", aldeia);
        
        caverna.ajustarSaida("norte", aldeia);
        
        vila.ajustarSaida("oeste", aldeia);
        vila.ajustarSaida("leste", temploDeserto);
        
        temploDeserto.ajustarSaida("oeste", vila);
        
        monumentoOceano.ajustarSaida("leste", postoGuarda);
        
        definirLocalInicio(aldeia); // o jogo vai comecar na aldeia
    }
    
    /**
     * Define, na criacao dos locais, o local de inicio do jogo.
     */
    private void definirLocalInicio(Local local)
    {
        localInicio = local;
    }
    
    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() 
    {            
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.obterComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas()
    {
        System.out.println();
        System.out.println("Bem-vindo ao World of Zuul!");
        System.out.println("World of Zuul eh um incrivel jogo de aventura.");
        System.out.println("Seu objetivo eh encontrar o raro minerio de diamante.");
        System.out.println(" --- Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        
        jogador.exibirLocalizacaoAtual();
    }

    /**
     * Dado um comando, processa (executa) o comando.
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) 
    {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.obterPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaLocal(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if (palavraDeComando.equals("observar")) {
            observar(comando);
        }
        else if (palavraDeComando.equals("pegar")) {
            pegar(comando);
        }
        else if (palavraDeComando.equals("voltar")) {
            voltar(comando);
        }
        else if (palavraDeComando.equals("inventario")) {
            acessarInventario(comando);
        }
        else if (palavraDeComando.equals("usar")) {
            usar(comando);
        }
        
        return querSair;
    }
    
    // Implementacoes dos comandos do usuario

    /**
     * Imprime informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de 
     * palavras de comando
     */
    private void imprimirAjuda() 
    {
        System.out.println("Sua aldeia precisa de voce, guerreiro.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println("   ");
        System.out.println(analisador.obterPalavrasDeComando());
        System.out.println();
    }
    
    /** 
     * Tenta ir em uma direcao. Se existe uma saida entra no 
     * novo local, caso contrario imprime mensagem de erro.
     */
    private void irParaLocal(Comando comando) 
    {
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.obterSegundaPalavra();
        Local localAtual = jogador.obterLocalAtual();
        
        // Tenta sair do local atual
        Saida saida = localAtual.getSaida(direcao);

        if (saida == null) {
            System.out.println("Nao ha passagem!");
        } else {
            irParaLocal(saida.obterLocalSaida());
        }
        
        /* POSSIVEL MELHORIA
         * else if (saida.ehBloqueada()) {
            System.out.println("A passagem esta bloqueada. Voce precisa do item '"
                               + saida.obterNomeDoItemQueAbre() + 
                                "' para abrir a passagem.");
        } 
         */
    }
    
    /** 
     * Vai para o local de destino passado por parametro.
     */
    private void irParaLocal(Local destino) 
    {
        jogador.atualizarLocalAtual(destino);
        
        jogador.exibirLocalizacaoAtual();
    }
    
    /**
     * Observa o local que se encontra.
     */
    private void observar(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Não é possível observar coisas específicas");
            return;
        }
        
        jogador.exibirLocalizacaoAtual();
    }
    
    /** 
     * Pega o item que esta no local, se houver.
     */
    private void pegar(Comando comando) 
    {
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos o que pegar...
            System.out.println("Pegar o que?");
            return;
        }
        
        String itemParaColetar = comando.obterSegundaPalavra();
        Local localAtual = jogador.obterLocalAtual();
        Item itemDoLocal = localAtual.obterItem();
        
        if (itemDoLocal == null || !itemParaColetar.equalsIgnoreCase(itemDoLocal.obterNome())) {
            // se nao tiver item nenhum ou o item que esta la eh diferente da entrada
            System.out.println("Nao tem esse item aqui");
        } else { // o item esta la para ser pegado
            jogador.adicionarItemAoInventario(itemDoLocal);
            System.out.println("Voce coletou um(a) " + itemDoLocal.obterNome() + 
                                " que esta agora no seu inventario");
            localAtual.coletarItem();
        }
    }
    
    /**
     * Volta para o ultimo local visitado.
     */
    private void voltar(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("O comando 'voltar' deve ser passado sozinho " + 
                                "para retornar para o ultimo local visitado");
            return;
        }
        
        Local localAnterior = jogador.obterLocalAnterior();
        
        if (localAnterior == null) {
            System.out.println("Voltar pra onde? Movimente-se pelo mapa primeiro");
            return;
        }
        
        irParaLocal(localAnterior);
    }
    
    /**
     * Acessa o inventario do jogador.
     */
    private void acessarInventario(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("O comando 'inventario' deve ser passado sozinho " + 
                                "para retornar os itens no seu inventario");
            return;
        }
        
        System.out.println(jogador.itensDoInventario());
    }
    
    /**
     * Usa o item passado no comando.
     */
    private void usar(Comando comando) {
        if(!comando.temSegundaPalavra()) {
            System.out.println("Usar o que?");
            return;
        }
        
        String nomeItem = comando.obterSegundaPalavra();
        
        if (!jogador.consultarSeTemItem(nomeItem)) {
            System.out.println("Voce nao possui esse item.");
            return;
        } else {
            if (jogador.usarItem(nomeItem)) {
                jogador.removerItemDoInventario(nomeItem);
                System.out.println("Voce usou o item e desbloqueou pelo menos uma saida.");
            } else {
                System.out.println("Esse item nao desbloqueia nenhuma saida aqui.");
            }
        }
    }
    
    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) 
    {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nos queremos sair
        }
    }
}
