import java.util.ArrayList;

public class Municipio {
    
    // coleção de eventos que ocorreram ou ocorrerão no município
    private ArrayList<Evento> eventos;
    
    /**
     * Cria um objeto município, sem eventos
     */
    public Municipio() {
        eventos = new ArrayList<>();
    }

    /**
     * Adiciona um evento à coleção de eventos do município
     * @param evento O evento a ser adicionado
     */
    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    /*
     * Implemente abaixo o método solicitado no
     * enunciado da Questão 5
     */
    





    /**
     * Este método preenche a coleção de eventos com alguns eventos
     * para que possa usar nos seus testes
     */
    public void cenarioDeTeste1() {
        // remove os eventos que existiam anteriormente
        eventos.clear();

        // adiciona eventos de teste
        
        Evento evento1 = new Evento("Show da Luna", "Show", new Data(21, "outubro", 2025));
        eventos.add(evento1);
        Evento evento2 = new Evento("O Magico de Oz", "Peça teatral", new Data(18, "março", 2023));
        eventos.add(evento2);
        Evento evento3 = new Evento("Rancho Fundo", "Festa", new Data(1, "janeiro", 2026));
        eventos.add(evento3);
    }

    /**
     * Este método preenche a coleção de eventos com outros eventos
     * para que possa usar nos seus testes
     */
    public void cenarioDeTeste2() {
        // remove os eventos que existiam anteriormente
        eventos.clear();

        // adiciona eventos de teste
        
        Evento evento1 = new Evento("TecnoMusic", "Festa", new Data(20, "setembro", 2025));
        eventos.add(evento1);
        Evento evento2 = new Evento("ArtLavras", "Exposição", new Data(18, "março", 2026));
        eventos.add(evento2);
        Evento evento3 = new Evento("Rodeio", "Festa", new Data(19, "agosto", 2024));
        eventos.add(evento3);
    }

}
