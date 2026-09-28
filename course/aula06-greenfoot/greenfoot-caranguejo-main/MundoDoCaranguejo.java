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
        addObject(larva,40,30);
        larva.setLocation(74,35);
        larva.setLocation(102,37);
        Larva larva2 = new Larva();
        addObject(larva2,102,37);
        larva.setLocation(164,47);
        Larva larva3 = new Larva();
        addObject(larva3,164,47);
        Larva larva4 = new Larva();
        addObject(larva4,336,43);
        Larva larva5 = new Larva();
        addObject(larva5,505,53);
        Larva larva6 = new Larva();
        addObject(larva6,484,144);
        Larva larva7 = new Larva();
        addObject(larva7,194,258);
        Larva larva8 = new Larva();
        addObject(larva8,122,259);
        Larva larva9 = new Larva();
        addObject(larva9,116,132);
        Larva larva10 = new Larva();
        addObject(larva10,117,117);
        Larva larva11 = new Larva();
        addObject(larva11,340,156);
        Larva larva12 = new Larva();
        addObject(larva12,381,218);
        Larva larva13 = new Larva();
        addObject(larva13,597,127);
        Larva larva14 = new Larva();
        addObject(larva14,794,48);
        Larva larva15 = new Larva();
        addObject(larva15,947,32);
        Larva larva16 = new Larva();
        addObject(larva16,868,21);
        Larva larva17 = new Larva();
        addObject(larva17,672,44);
        larva17.setLocation(656,44);
        Larva larva18 = new Larva();
        addObject(larva18,656,44);
        larva17.setLocation(792,108);
        Larva larva19 = new Larva();
        addObject(larva19,792,108);
        Larva larva20 = new Larva();
        addObject(larva20,837,149);
        Larva larva21 = new Larva();
        addObject(larva21,885,85);
        larva21.setLocation(847,88);
        Larva larva22 = new Larva();
        addObject(larva22,847,88);
        larva21.setLocation(918,124);
        Larva larva23 = new Larva();
        addObject(larva23,918,124);
        Larva larva24 = new Larva();
        addObject(larva24,992,171);
        Larva larva25 = new Larva();
        addObject(larva25,973,85);
        larva25.setLocation(840,98);
        Larva larva26 = new Larva();
        addObject(larva26,840,98);
        Larva larva27 = new Larva();
        addObject(larva27,652,199);
        Larva larva28 = new Larva();
        addObject(larva28,600,260);
        Larva larva29 = new Larva();
        addObject(larva29,700,104);
        larva29.setLocation(665,91);
        Larva larva30 = new Larva();
        addObject(larva30,665,91);

        larva.setLocation(149,62);
        larva.setLocation(50,19);
        larva17.setLocation(968,94);
        larva21.setLocation(254,41);
        larva29.setLocation(558,187);

        Caranguejo caranguejo = new Caranguejo();
        addObject(caranguejo,191,110);
        Caranguejo caranguejo2 = new Caranguejo();
        addObject(caranguejo2,803,339);
        Caranguejo caranguejo3 = new Caranguejo();
        addObject(caranguejo3,295,595);

        Lagosta lagosta = new Lagosta();
        addObject(lagosta,153,41);
        Lagosta lagosta2 = new Lagosta();
        addObject(lagosta2,148,360);
        Lagosta lagosta3 = new Lagosta();
        addObject(lagosta3,150,668);
        larva28.setLocation(575,612);
        larva22.setLocation(442,451);
        larva22.setLocation(894,615);
        larva22.setLocation(707,539);
        larva27.setLocation(659,381);
        larva12.setLocation(57,593);
        larva9.setLocation(472,715);
        larva19.setLocation(418,351);
        larva29.setLocation(764,228);
        larva20.setLocation(966,437);
        larva23.setLocation(462,243);
        caranguejo3.setLocation(308,566);
        lagosta2.setLocation(741,152);
        lagosta3.setLocation(497,608);
        caranguejo3.setLocation(185,380);
        larva3.setLocation(174,241);
        caranguejo.setLocation(245,92);
        caranguejo3.setLocation(163,587);
        caranguejo3.setLocation(274,514);
        larva7.setLocation(186,222);
        larva3.setLocation(798,697);
        larva2.setLocation(150,479);
        lagosta.setLocation(179,188);
        larva7.setLocation(99,378);
        lagosta.setLocation(243,266);
        larva30.setLocation(248,703);
        larva17.setLocation(849,156);
        larva16.setLocation(926,199);
        larva16.setLocation(600,250);
        larva24.setLocation(914,265);
        larva5.setLocation(273,370);
        larva4.setLocation(100,699);
        Aranha aranha = new Aranha();
        addObject(aranha,470,63);
        Aranha aranha2 = new Aranha();
        addObject(aranha2,884,663);
        aranha2.setLocation(458,478);
    }}
