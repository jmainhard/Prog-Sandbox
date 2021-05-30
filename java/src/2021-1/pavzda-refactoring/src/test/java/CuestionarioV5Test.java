import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CuestionarioV5Test {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4 })
    void testGetAnswer(int operador) {
        double esperado, actual;

        // set de valores esperados para la operacion entre 2 y 2
        esperado = switch (operador) {
            case 1, 3 -> 4; // 2 + 2 and 2 * 2
            case 2 -> 0;
            case 4 -> 1;
            default -> throw new IllegalStateException("Valor inesperado: " + operador);
        };
        actual = CuestionarioV5.getAnswer(2, 2, operador);
        System.out.printf("operador: %d\nesperado: %f\n\n", operador, esperado);
        Assertions.assertEquals(esperado, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4 })
    void testGetAnswerWhenOperandoDosIsZero(int operador) {
        double esperado, actual;

        // set de valores esperados para la operacion entre 38 y 0
        esperado = switch (operador) {
            case 1, 2 -> 38; // a + b, a - b
            case 3, 4 -> 0; // a * b, a / b
            default -> throw new IllegalStateException("Valor inesperado: " + operador);
        };
        actual = CuestionarioV5.getAnswer(38, 0, operador);
        System.out.printf("operador: %d\nesperado: %f\n\n", operador, esperado);
        Assertions.assertEquals(esperado, actual);
    }

}