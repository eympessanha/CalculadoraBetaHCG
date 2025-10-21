# Calculadora Beta hCG

Autora: Esther Pessanha

Este projeto é uma **calculadora de interpretação de resultados de Beta hCG (gonadotrofina coriônica humana)**, desenvolvida em **Java** com **JUnit** para testes automatizados.  
O objetivo é auxiliar na **interpretação clínica** dos valores de hCG de acordo com o número de dias desde a **DUM (Data da Última Menstruação)**, estimando a idade gestacional e classificando os resultados conforme faixas esperadas.

---

## Funcionalidades

- Interpreta valores de **Beta hCG** com base nos dias desde a DUM.  
- Retorna mensagens para diferentes situações:
  - Resultado negativo  
  - Falso negativo em fase precoce (< 4 semanas)  
  - Resultado positivo compatível com a idade gestacional  
  - Resultado positivo abaixo do esperado  
  - Resultado positivo acima do esperado  
  - Fora do intervalo de 3–16 semanas de gestação  
- Contém **testes unitários** com **JUnit 5** garantindo a confiabilidade da lógica.

---

## Lógica de funcionamento

O método principal é `interpretarBhcg(double hcg, int dum)`, que:

1. Converte os dias da DUM em semanas (`dum / 7`).
2. Define o intervalo de referência de Beta hCG conforme a semana gestacional.
3. Retorna uma string descritiva com a interpretação do resultado.

### Exemplo de uso

```java
Calculadora calc = new Calculadora();
String resultado = calc.interpretarBhcg(32000, 56);
System.out.println(resultado);
// Saída: "Resultado positivo compatível com a idade gestacional"
```

## Testes unitários

- Os testes estão implementados na classe CalculadoraTest, cobrindo:
  - Todas as semanas gestacionais (3 a 16)
  - Casos limites de resultados negativos e positivos
  - Cenários fora do intervalo gestacional

- Exemplos de testes

```java
@Test
public void testResultadoNegativoAteQuatroSemanas() {
    assertEquals(
        "Resultado negativo. Pode ser falso negativo nesta fase precoce (<4 sem). Repetir exame em 1 semana",
        calc.interpretarBhcg(24.9, 27)
    );
}

@Test
public void testSemana8() {
    int dum = 56;
    assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(32000, dum));
}
```

- Para rodar os testes:

  mvn test


## Tecnologias utilizadas
- Java 23
- JUnit 5 (Jupiter)
-  Maven – gerenciamento de dependências e execução de testes

## Como executar o projeto

#### Clone o repositório:

git clone https://github.com/eympessanha/CalculadoraBetaHCG.git

cd CalculadoraBetaHCG


#### Compile o projeto:

mvn clean compile


#### Execute os testes:

mvn test
