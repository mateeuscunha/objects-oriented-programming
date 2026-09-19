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

A linguagem Java nos permite criar classes sem definir construtores. 
Mas isso é recomendável de acordo com os princípios de POO? 
Justifique sua resposta explicando para que servem os construtores.

> Responda abaixo: 
> 


## Questão 2 (Peso 15)

Dado o trecho da classe Cachorro abaixo, implemente um método de acesso 
ao atributo raca e um método modificador para o atributo idade.

```java
public class Cachorro {
  private String nome;
  private String raca;
  private int idade;
  // restante da classe omitido
}
```

## Questão 3 (20 pontos)

Explique qual é o tempo de vida e o escopo de cada um dos tipos de variáveis abaixo:

a) Atributos.

b) Parâmetros.

c) Variáveis locais.

> Escreva a resposta abaixo:
> 


## Observações sobre as próximas questões

As próximas questões devem ser respondidas alterando-se o código 
do presente projeto.

Note que a classe Municipio só passará a compilar após a implementação
da Questão 4.

## Questão 4 (20 pontos)

Implemente a classe chamada Data que representa uma data na qual um evento
pode ocorrer.

A classe deve ter os seguintes atributos:

a) um atributo inteiro para guardar o dia,

b) um atributo String para guardar o mês, e

c) um atributo inteiro para guardar o ano.

Além disso, a classe deve ter:

1. Um construtor, seguindo as boas práticas de POO e de forma que a classe
   Municipio passe a compilar.

2. Métodos de acesso para cada atributo.

3. Um método que retorna uma String com a data por extenso de acordo com o 
   formato dos exemplos abaixo:

  "Dia 21 de outubro de 2025"

  "Dia 19 de agosto de 2024"


## Questão 5 (25 pontos)

Considere as classes Evento e Municipio. 
Um evento tem um nome, um tipo e a data em que foi (ou será) realizado. 
Já um município tem uma coleção de eventos (apenas parte da classe é apresentada).

Implemente um método na classe Municipio que:

- receba por parâmetro um ano inicial e um ano final
- e exiba no terminal o nome, o tipo e data por extenso de todos dos eventos 
  que ocorreram (ou ocorrerão) naquele município desde o ano inicial 
  até o ano final. 
- Caso não exista nenhum evento no período informado, 
  exiba uma mensagem informando isso no terminal.

Atenção: sua implementação deve funcionar para quaisquer eventos
que possam existir na coleção de eventos.

Dica: foram criados métodos que criam eventos no município de forma que você 
possa testar sua implementação.
