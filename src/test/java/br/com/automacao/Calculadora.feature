
Feature: Calculadora de tipo de triângulo de acordo com tamanho dos lados

@funcionais
  Scenario Outline: Calcular tipo de triângulo
    Given Acesso o sistema
    When informo o valor do lado um do triangulo "<lado1>"
    And Informo o valor do lado dois do triangulo "<lado2>"
    And Informo o valor do lado tres do triangulo "<lado3>"
    Then Eu visualizo o resultado do tipo de triangulo "<mensagem>"

    Examples: 
      | lado1  | lado2 | lado3  | mensagem                | 
      | 10     |  10   |  20    | Triângulo Isósceles     |
      | 10     |  10   |  10    | Triângulo Equilátero    |
      | 10     |  30   |  20    | Triângulo Escaleno      |
      |        |       |        | Preencha todos os lados |
      |  0     |  0    |  0     | Triângulo inválido      |
      |  -10   |  -10  |  -10   | Triângulo inválido      |