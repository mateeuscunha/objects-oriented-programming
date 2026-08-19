import java.util.*;

/**
 * A classe Disciplina representa a matrícula em uma disciplina. Ela guarda
 * a hora, a sala e os participantes da disciplina, bem como o nome do professor.
 * 
 * Traduzido por Julio César Alves - 2023-08-25
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 */
public class Disciplina
{
    private String professor;
    private String sala;
    private String diaEHora;
    private ArrayList<Estudante> estudantes;
    private int capacidade;
    
    /**
     * Cria uma Disciplina com um número máximo de vagas. Todos os demais
     * detalhes são definidos por valores padrões.
     */
    public Disciplina(int numeroMaximoDeEstudantes)
    {
        professor = "desconhecido";
        sala = "desconhecido";
        diaEHora = "desconhecido";
        estudantes = new ArrayList<Estudante>();
        capacidade = numeroMaximoDeEstudantes;
    }

    /**
     * Adiciona um estudante a esta Disciplina.
     */
    public void matricularEstudante(Estudante novoEstudante)
    {
        if(estudantes.size() == capacidade) {
            System.out.println("A disciplina está cheia. Você não pode se matricular.");
        }
        else {
            estudantes.add(novoEstudante);
        }
    }
    
    /**
     * Retorna o número de estudantes atualmente matriculados nesta Disciplina
     */
    public int numeroDeEstudantes()
    {
        return estudantes.size();
    }
    
    /**
     * Define o número da sala desta disciplina.
     */
    public void definirSala(String numeroDaSala)
    {
        sala = numeroDaSala;
    }
    
    /**
     * Define o horário das aulas. O parâmetro deveria definir
     * o dia e a hora do dia, por exemplo, "Sextas 10h"
     */
    public void definirHorario(String diaEHoraComoString)
    {
        diaEHora = diaEHoraComoString;
    }
    
    /**
     * Define o nome do professor desta Disciplina.
     */
    public void definirProfessor(String nomeProfessor)
    {
        professor = nomeProfessor;
    }
    
    /**
     * Exibe no terminal uma lista com detalhes da Disciplina.
     */
    public void imprimirLista()
    {
        System.out.println("Aulas " + diaEHora);
        System.out.println("Professor: " + professor + "   Sala: " + sala);
        System.out.println("Alunos matriculados:");
        for(Estudante estudante : estudantes) {
            estudante.imprimir();
        }
        System.out.println("Número de estudantes: " + numeroDeEstudantes());
    }
}
