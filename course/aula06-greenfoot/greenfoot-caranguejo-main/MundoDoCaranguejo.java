import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Escreva aqui uma descrição da classe MundoDoCarganguejo.
 * 
 * @author (seu nome) 
 * @version (um número de versão ou uma data)
 */
public class MundoDoCaranguejo extends World
{
    private boolean terminou;
    private int pontuacao;
    /**
     * Construtor para objetos da classe MundoDoCaranguejo.
     * 
     */
    public MundoDoCaranguejo()
    {    
        super(1000, 800, 1); 
        prepare();
        showText("Jogo do Caranguejo", 500, 20);
        terminou = false;
        pontuacao = 0;
        exibirPlacar();
    }
    
    private void exibirPlacar() {
        showText("Placar: " + pontuacao + " pontos", 800, 20);
    }
    
    public void contarPontosPorLarva() {
        pontuacao += 10;
        exibirPlacar();
    }
    
    public void act() {
        if (!terminou) {
            List<Larva> larvas = getObjects(Larva.class);
            List<Caranguejo> caranguejos = getObjects(Caranguejo.class);
            if (larvas.size() == 0) {
                showText ("You won!!!", 200, 300);
                terminou = true;
            }
            if (caranguejos.size() == 0) {
                showText ("GAME OVER", 200, 300);
                terminou = true;
            }
        }
    }
    
    public Larva buscarUmaLarva() {
        List<Larva> larvas = getObjects(Larva.class);
        if (larvas.size() > 0) {
            int posicao = Greenfoot.getRandomNumber(larvas.size());
            return larvas.get(posicao);
        }
        return null;
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {

        Larva larva = new Larva();
        addObject(larva,161,94);
        Larva larva2 = new Larva();
        addObject(larva2,859,105);
        Larva larva3 = new Larva();
        addObject(larva3,388,316);
        Larva larva4 = new Larva();
        addObject(larva4,860,449);
        Larva larva5 = new Larva();
        addObject(larva5,210,598);
        Larva larva6 = new Larva();
        addObject(larva6,770,661);
        Larva larva7 = new Larva();
        addObject(larva7,580,498);
        Larva larva8 = new Larva();
        addObject(larva8,144,385);
        Larva larva9 = new Larva();
        addObject(larva9,703,279);
        Larva larva10 = new Larva();
        addObject(larva10,538,141);
        Caranguejo caranguejo = new Caranguejo();
        addObject(caranguejo,708,107);
        Caranguejo caranguejo2 = new Caranguejo();
        addObject(caranguejo2,268,498);
        Lagosta lagosta = new Lagosta();
        addObject(lagosta,279,154);
        Lagosta lagosta2 = new Lagosta();
        addObject(lagosta2,860,251);
        Lagosta lagosta3 = new Lagosta();
        addObject(lagosta3,571,322);
        Lagosta lagosta4 = new Lagosta();
        addObject(lagosta4,502,606);
        Aranha aranha = new Aranha();
        addObject(aranha,255,304);
    }
}
