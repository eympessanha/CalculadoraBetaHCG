package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import control.Calculadora;

class CalculadoraTest {

    Calculadora calc;

    @BeforeEach
    public void setup() {
        calc = new Calculadora();
    }

    @AfterEach
    public void tearDown() {
        calc = null;
    }

    // Existing Tests
    @Test
    public void testResultadoNegativoAteQuatroSemanas() {
        assertEquals("Resultado negativo. Pode ser falso negativo nesta fase precoce (<4 sem). Repetir exame em 1 semana", calc.interpretarBhcg(24.9, 27));
    }

    @Test
    public void testResultadoNegativoAposQuatroSemanas() {
        assertEquals("Resultado negativo", calc.interpretarBhcg(24.9, 28));
    }

    // Boundary Tests for Gestational Age
    @Test
    public void testForaDoIntervaloAbaixoDe3Semanas() {
        assertEquals("Fora do intervalo de 3–16 semanas de gestação.", calc.interpretarBhcg(100, 20)); // Less than 3 weeks
    }

    @Test
    public void testForaDoIntervaloAcimaDe16Semanas() {
        assertEquals("Fora do intervalo de 3–16 semanas de gestação.", calc.interpretarBhcg(100, 113)); // More than 16 weeks
    }


    // --- Boundary Value Analysis for each week ---

    // Week 3 (min: 5, max: 50) - dum = 21 to 27
    @Test
    public void testSemana3() {
        int dum = 21;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(4.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(5, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(50, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(50.1, dum));
    }

    // Week 4 (min: 10, max: 750) - dum = 28 to 34
    @Test
    public void testSemana4() {
        int dum = 28;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(9.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(10, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(750, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(750.1, dum));
    }

    // Week 5 (min: 200, max: 7100) - dum = 35 to 41
    @Test
    public void testSemana5() {
        int dum = 35;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(199.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(200, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(7100, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(7100.1, dum));
    }

    // Week 6 (min: 160, max: 32000) - dum = 42 to 48
    @Test
    public void testSemana6() {
        int dum = 42;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(159.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(160, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(32000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(32000.1, dum));
    }

    // Week 7 (min: 3700, max: 160000) - dum = 49 to 55
    @Test
    public void testSemana7() {
        int dum = 49;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(3699.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(3700, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(160000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(160000.1, dum));
    }

    // Week 8 (min: 32000, max: 210000) - dum = 56 to 62
    @Test
    public void testSemana8() {
        int dum = 56;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(31999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(32000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(210000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(210000.1, dum));
    }

    // Week 9 (min: 64000, max: 210000) - dum = 63 to 69
    @Test
    public void testSemana9() {
        int dum = 63;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(63999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(64000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(210000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(210000.1, dum));
    }

    // Week 10 (min: 47000, max: 220000) - dum = 70 to 76
    @Test
    public void testSemana10() {
        int dum = 70;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(46999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(47000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(220000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(220000.1, dum));
    }

    // Week 11 (min: 30000, max: 210000) - dum = 77 to 83
    @Test
    public void testSemana11() {
        int dum = 77;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(29999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(30000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(210000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(210000.1, dum));
    }

    // Week 12 (min: 27000, max: 190000) - dum = 84 to 90
    @Test
    public void testSemana12() {
        int dum = 84;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(26999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(27000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(190000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(190000.1, dum));
    }

    // Week 13 (min: 14000, max: 180000) - dum = 91 to 97
    @Test
    public void testSemana13() {
        int dum = 91;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(13999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(14000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(180000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(180000.1, dum));
    }

    // Week 14 (min: 11000, max: 57000) - dum = 98 to 104
    @Test
    public void testSemana14() {
        int dum = 98;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(10999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(11000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(57000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(57000.1, dum));
    }

    // Week 15 (min: 9000, max: 56000) - dum = 105 to 111
    @Test
    public void testSemana15() {
        int dum = 105;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(8999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(9000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(56000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(56000.1, dum));
    }

    // Week 16 (min: 8000, max: 40000) - dum = 112
    @Test
    public void testSemana16() {
        int dum = 112;
        assertEquals("Resultado positivo abaixo do esperado", calc.interpretarBhcg(7999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(8000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(40000, dum));
        assertEquals("Resultado positivo acima do esperado", calc.interpretarBhcg(40000.1, dum));
    }
}