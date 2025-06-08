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

    @Test
    public void testResultadoNegativoAteQuatroSemanas() {
        assertEquals("Resultado negativo (<25 mUI/mL): indica que, provavelmente, não há gestação em curso. Se a DUM for recente (menos de 4 semanas), existe possibilidade de falso negativo, sendo recomendado repetir o exame em 1 semana.", calc.interpretarBhcg(24.9, 27));
    }

    @Test
    public void testResultadoNegativoAposQuatroSemanas() {
        assertEquals("Resultado negativo (<25 mUI/mL): indica que, provavelmente, não há gestação em curso.", calc.interpretarBhcg(24.9, 28));
    }

    @Test
    public void testForaDoIntervaloAbaixoDe3Semanas() {
        assertEquals("A ferramenta cobre o intervalo de 3 a 16 semanas de gestação. Valores fora desse intervalo não serão interpretados, pois exigem outra abordagem clínica.", calc.interpretarBhcg(100, 20));
    }

    @Test
    public void testForaDoIntervaloAcimaDe16Semanas() {
        assertEquals("A ferramenta cobre o intervalo de 3 a 16 semanas de gestação. Valores fora desse intervalo não serão interpretados, pois exigem outra abordagem clínica.", calc.interpretarBhcg(100, 113));
    }

    @Test
    public void testSemana3() {
        int dum = 21;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(4.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(5, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(50, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(50.1, dum));
    }

    @Test
    public void testSemana4() {
        int dum = 28;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(9.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(10, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(750, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(750.1, dum));
    }

    @Test
    public void testSemana5() {
        int dum = 35;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(199.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(200, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(7100, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(7100.1, dum));
    }

    @Test
    public void testSemana6() {
        int dum = 42;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(159.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(160, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(32000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(32000.1, dum));
    }

    @Test
    public void testSemana7() {
        int dum = 49;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(3699.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(3700, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(160000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(160000.1, dum));
    }

    @Test
    public void testSemana8() {
        int dum = 56;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(31999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(32000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(210000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(210000.1, dum));
    }

    @Test
    public void testSemana9() {
        int dum = 63;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(63999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(64000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(210000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(210000.1, dum));
    }

    @Test
    public void testSemana10() {
        int dum = 70;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(46999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(47000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(220000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(220000.1, dum));
    }

    @Test
    public void testSemana11() {
        int dum = 77;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(29999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(30000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(210000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(210000.1, dum));
    }

    @Test
    public void testSemana12() {
        int dum = 84;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(26999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(27000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(190000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(190000.1, dum));
    }

    @Test
    public void testSemana13() {
        int dum = 91;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(13999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(14000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(180000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(180000.1, dum));
    }

    @Test
    public void testSemana14() {
        int dum = 98;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(10999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(11000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(57000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(57000.1, dum));
    }

    @Test
    public void testSemana15() {
        int dum = 105;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(8999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(9000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(56000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(56000.1, dum));
    }

    @Test
    public void testSemana16() {
        int dum = 112;
        assertEquals("Resultado positivo abaixo do esperado: pode indicar problemas na evolução da gravidez ou datação incorreta; é necessário acompanhamento médico.", calc.interpretarBhcg(7999.9, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(8000, dum));
        assertEquals("Resultado positivo compatível com a idade gestacional", calc.interpretarBhcg(40000, dum));
        assertEquals("Resultado positivo acima do esperado: pode sugerir uma gestação gemelar ou erro de datação; também deve ser avaliado por um profissional de saúde.", calc.interpretarBhcg(40000.1, dum));
    }
}