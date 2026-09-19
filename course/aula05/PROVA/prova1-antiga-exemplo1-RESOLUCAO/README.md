# Prova 1 Antiga - IPOO

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

1. A pasta da prova, de nome `prova1`, deve ser compactada em um arquivo ZIP.
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

Digite seu nome completo:

> Digite abaixo:
> 

## Questão 1 (Peso 20)

Objetos de uma mesma classe podem ter quantidades diferentes de atributos?
E podem ter valores diferentes para os mesmos atributos? 
Justifique suas respostas apresentando exemplos (não precisa ser de código).

> Responda abaixo: 
> 


## Questão 2 (Peso 15)

Para cada método apresentado na classe Alimento abaixo, preencha o comentário
acima da assinatura do método indicando se o método é (a) de acesso, 
(b) modificador ou (c) se não é nem de acesso e nem modificador e  **justifique** 
sua resposta. **Atenção**: respostas sem justificativa serão desconsideradas.

```java
public class Alimento { // construtor e restante da classe foram omitidos
  private String nome;
  private boolean ehSaudavel;
  private int calorias;
  
  // Este método é: 
  // Justificativa: 
  public void alterarCalorias(int calorias) {
    this.calorias = calorias;
  }
  
  // Este método é: 
  // Justificativa: 
  public void imprimir() {
    System.out.print("Alimento " + nome + " tem " + calorias + " calorias e ");
    if (ehSaudavel) {
      System.out.println("é saudável :)");
    }
    else {
      System.out.println("não é saudável :(");
    }
  }

  // Este método é: 
  // Justificativa: 
  public int getCalorias() {
    return calorias;
  }
}
```

## Questão 3 (20 pontos)

Escolha um (e apenas um) dos três conceitos abaixo e explique o que 
ele é e para que serve. Sua resposta deve ser a mais completa possível. 

a) Estado de um objeto
b) Sobrecarga de métodos
c) Variáveis locais

> Conceito escolhido: 

> Escreva a resposta abaixo:
> 


## Observações sobre as próximas questões

As próximas questões devem ser respondidas alterando-se o código 
do presente projeto.

Note que a classe Imobiliaria só passará a compilar após a implementação
da Questão 4.

## Questão 4 (20 pontos)

Implemente a classe chamada Endereco que representa um endereço de um imóvel.

A classe deve ter os seguintes atributos:

a) um atributo String para guardar o nome da rua,

b) um atributo inteiro para guardar o número, e

c) um atributo String para guardar o nome do bairro.

Além disso, a classe deve ter:

1. Um construtor, seguindo as boas práticas de POO e de forma que a classe
   Imobiliaria passe a compilar.

2. Um método que retorna uma String de acordo com o formato dos exemplos abaixo:

  "Rua Francisco Sales, 293 - Centro"
  
  "Rua Manoel Fernandes de Lima, 7 - Vila Alzira"

3. Um método que receba por parâmetro um nome de um bairro e retorne um boolean 
   com valor true se o endereço é daquele bairro e false em caso contrário.

## Questão 5 (25 pontos)

Considere as classes Imovel e Imobiliaria presentes nesse projeto. 
Um imóvel possui um nome de proprietário, um endereço e um valor de aluguel.
Já uma imobiliária tem uma coleção de imóveis (apenas parte da classe é apresentada).

Implemente um método chamado consultarImoveis na classe Imobiliaria. 
O método deve:

- receber por parâmetro o nome de um bairro e um valor máximo de aluguel;
- e exibir no terminal os endereços e os valores de aluguel de todos os imóveis daquele 
  bairro cujo valor de aluguel seja menor ou igual ao valor máximo informado.
  - obs: se não existir nenhum imóvel de acordo com os parâmetro informados, 
    deve ser exibida a mensagem: "Nenhum imóvel encontrado!"

Atenção: sua implementação deve funcionar para quaisquer imóveis
que possam existir na coleção de imóveis.

Dica: foram criados métodos que criam imóveis na imobiliária de forma que você 
possa testar sua implementação do método consultarImoveis.
