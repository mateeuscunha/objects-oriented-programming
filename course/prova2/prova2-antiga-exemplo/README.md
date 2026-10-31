# 2ª Prova - IPOO - 2025-2

## Instruções

- **Não desligue** o computador ao terminar a prova!
- Deixe um documento de identificação com foto (RG, CNH ou Carteirinha da UFLA)
  sobre a bancada durante toda a prova.
- A prova é individual e sem consulta.
- Durante a prova você poderá usar apenas o BlueJ na máquina do laboratório.
- Não é permitido o uso de construções de Programação Funcional em Java 
  (como comandos stream e operador ->).
- Desligue e guarde celulares e quaisquer outros aparelhos eletrônicos.
- Leia atentamente todo o enunciado antes de responder cada questão.
- Questões teóricas devem ser respondidas nesse mesmo arquivo.
- Questões práticas devem ser respondidas alterando o código do projeto fornecido.

Para entregar a prova:

1. A pasta da prova, de nome `prova2-2025-2`, deve ser compactada em um arquivo ZIP.
2. Clique com o botão direito do mouse no atalho `Enviar Prova` na Área de Trabalho 
  e acesse a opção `Permitir Iniciar`.
3. Em seguida clique duas vezes no atalho `Enviar Prova`.
4. Preencha o login usando a primeira parte do seu e-mail (ou seja, sem `@estudante.ufla.br`).
5. Preencha a senha usando seu número de matrícula (chame o professor se não lembrar).
6. Escolha o arquivo ZIP que você gerou no passo 1.
7. Clique em enviar e confira se apareceu a mensagem `Upload Recebido`.
  - Se aparecer outra mensagem a prova não foi entregue!
8. Após fazer a entrega, avise o professor e **NÃO** desligue o computador.

## ATENÇÃO

**Não desligue** o computador ao terminar a prova!


## Identificação do Aluno

Digite abaixo seu nome completo:

> 

## Questão 1 (Peso 20)

Considere a implementação da classe `Nave` abaixo. 
Repare que o número máximo de escudos que as naves podem ter foi declarado como 
um atributo constante (`final`). 
Nesse contexto, responda:

a. Da forma como a implementação foi feita, naves diferentes podem ter número máximo de escudos diferentes? 
   E isso seria conceitualmente correto? Justifique sua resposta.
   
b. Seria possível criar um método modificador para o número máximo de escudos, 
   mantendo as declarações dos atributos como estão? Justifique sua resposta.

c. Se você soubesse que todas as naves devem ter sempre o mesmo número máximo de escudos 
   (ou seja, esse número nunca seria alterado em uma execução do programa), 
   seria recomendável fazer alguma alteração na implementação da classe Nave? Qual(is)?
   (Obs.: você pode explicar ou fazer o código, como preferir).

```java
public class Nave {
  private int numeroDeEscudos;
  private static final int numeroMaximoDeEscudos = 10;
  public Nave() {
    numeroDeEscudos = 0;
  }
  public boolean pegarEscudo() { 
    if (numeroDeEscudos < numeroMaximoDeEscudos) {
      numeroDeEscudos++;
      return true;
    }
    return false;
  }
}
```

> Responda abaixo: 
> 

## Questão 2 (Peso 20)

Por que atributos de uma classe, que não são constantes, devem ser sempre declarados como privados? 
Dê um exemplo de uma situação na qual a declaração de um atributo com visibilidade pública pode 
causar problemas de design na evolução do código de um sistema.

> Responda abaixo:
>

## Questão 3 (Peso 20)

De acordo com os critérios de Design de Classes, qual das implementações a seguir é melhor e por que? 
Justifique explicando os conceitos de Design de Classes relacionados à sua escolha.

**Opção 1**

```java
import java.util.ArrayList;
public class Jogo {
  private ArrayList<Heroi> herois;
  ...
  public boolean atacar(String nome) {
    Heroi heroi = buscarHeroi(nome);
    if (heroi != null) {
        heroi.atacar();
        return true;
    }
    return false;
  }
  public boolean fugir(String nome) {
    Heroi heroi = buscarHeroi(nome);
    if (heroi != null) {
        heroi.fugir();
        return true;
    }
    return false;
  }
  private Heroi buscarHeroi(String nome) {
    for (Heroi h : herois) {
      if (h.obterNome().equals(nome)) {
        return h;
      }
    }
    return null;
  }
}
```

**Opção 2**

```java
import java.util.ArrayList;
public class Jogo {
  private ArrayList<Heroi> herois;
  ...
  public boolean atacar(String nome) {
    Heroi heroi = null;
    for (Heroi h : herois) {
      if (h.obterNome().equals(nome)) {
        heroi = h;
      }
    }
    if (heroi != null) {
        heroi.atacar();
        return true;
    }
    return false;
  }
  public boolean fugir(String nome) {
    Heroi heroi = null;
    for (Heroi h : herois) {
      if (h.obterNome().equals(nome)) {
        heroi = h;
      }
    }
    if (heroi != null) {
        heroi.fugir();
        return true;
    }
    return false;
  }
}
```

## Questão 4 (Peso 40)

Faça as alterações pedidas a seguir no código do presente projeto, que traz a 
implementação incompleta de um sistema de empréstimos de livros de uma biblioteca.

Estude atentamente o código e os comentários das classes fornecidas antes de fazer suas 
implementações. 
Sugestão: estude o código nessa ordem: Livro, Aluno e Biblioteca. 
Lembre-se que você deve fazer suas implementações utilizando um bom design de classes.

a) (Peso 20) Altere a classe Aluno de forma a limitar a quantidade de livros que um 
aluno pode pegar emprestado ao mesmo tempo. Considerando que todos os alunos podem pegar 
no máximo dois livros, declare de forma apropriada um atributo na classe para guardar 
essa informação e altere o método pegarLivroEmprestado de forma que o aluno não possa 
pegar mais livros se já estiver com dois livros emprestados.

b) (Peso 10) Crie um método para devolução de um livro na classe Aluno. O método deve 
receber um código de livro e, se o aluno tinha pegado emprestado o livro de código passado, 
o livro deve ser removido da coleção de livros emprestados e retornado pelo método. 
Mas, se o aluno não estava com aquele livro emprestado, o método deve retornar null.

c) (Peso 10) Crie um método para devolução de um livro na classe Biblioteca. O método 
deve receber por parâmetro o código do livro e a matrícula do aluno e deve retornar true 
se o aluno existe e ele estava com o livro de código passado, e retornar false em caso 
contrário. Lembre-se de chamar o método criado no item anterior para que o livro seja 
removido da coleção de livros que o aluno pegou emprestado.

Dica: use o BlueJ, criando objetos e chamando os métodos necessários, para testar as suas implementações!
