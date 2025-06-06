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
    public void testResultadoNegativoAteQUatroSemanas() {
        assertEquals("Resultado negativo. Pode ser falso negativo nesta fase precoce (<4 sem). Repetir exame em 1 semana", calc.interpretarBhcg(24, 10));
    }

    @Test
    public void testResultadoNegativoAposQUatroSemanas() {
        assertEquals("Resultado negativo", calc.interpretarBhcg(24, 30));
    }

}
