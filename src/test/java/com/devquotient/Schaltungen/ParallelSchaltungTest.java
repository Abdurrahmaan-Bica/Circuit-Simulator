package com.devquotient.Schaltungen;

import com.devquotient.Exception.InvalidNumberOfResistorsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Tests der Klasse ParallelSchaltung wurden von DevQuotient geschrieben
 */

public class ParallelSchaltungTest {

    private ParallelSchaltung parallelSchaltung;

    @BeforeEach
    public void create() {
        parallelSchaltung = new ParallelSchaltung();
    }
    // Die ersten 3 Tests, uberpruefen ob man den Gesamtwiderstand mit 1/2/3 Widerstaende berechnen kann.
    // Erster Test

    @Test
    void berechneDenGesamtWiderstandMitEinemWiderstand() throws InvalidNumberOfResistorsException {
        parallelSchaltung.setAnzahlDerWiderstaende(1);
        parallelSchaltung.setR1(BigDecimal.valueOf(20));

        assertEquals(BigDecimal.valueOf(20), parallelSchaltung.berechneDenGesamtWiderstand(1));
    }
    // Zweiter Test
    @Test
    void berechneDenGesamtWiderstandMitZweiWiderstaende() throws InvalidNumberOfResistorsException {
        parallelSchaltung.setAnzahlDerWiderstaende(2);
        parallelSchaltung.setR1(BigDecimal.valueOf(20));
        parallelSchaltung.setR2(BigDecimal.valueOf(30));

        assertEquals(BigDecimal.valueOf(12), parallelSchaltung.berechneDenGesamtWiderstand(2));
    }
    // Dritter Test
    @Test
    void berechneDenGesamtWiderstandMitDreiWiderstaende() throws InvalidNumberOfResistorsException {
        parallelSchaltung.setAnzahlDerWiderstaende(3);
        parallelSchaltung.setR1(BigDecimal.valueOf(20));
        parallelSchaltung.setR2(BigDecimal.valueOf(25));
        parallelSchaltung.setR3(BigDecimal.valueOf(30));

        assertEquals(BigDecimal.valueOf(5), parallelSchaltung.berechneDenGesamtWiderstand(3));
    }
    // Exception Test 1 , wenn die Anzahl der Widerstaende 5 ist.
    /**
     * Diese Methode,testet ob ein InvalidNumberOfResistorsException geworfen wird, wenn die Anzahl der Widerstaende 5 ist.
     */
    @Test
    void berechneDenGesamtWiderstandMitFuenfWiderstaende() {
        assertThrows(InvalidNumberOfResistorsException.class, () -> parallelSchaltung.berechneDenGesamtWiderstand(5));
    }
    // Exception Test 2 fuer 0 als Anzahl der Widerstaende
    /**
     * Diese Methode,testet ob ein InvalidNumberOfResistorsException geworfen wird, wenn die Anzahl der Widerstaende 0 ist.
     */
    @Test
    void berechneDenGesamtWiderstandMit0Widerstaende() {
        assertThrows(InvalidNumberOfResistorsException.class, () -> parallelSchaltung.berechneDenGesamtWiderstand(0));
    }
    // Exception Test 3, fuer eine negative Zahl
    /**
     * Diese Methode,testet ob ein InvalidNumberOfResistorsException geworfen wird, falls -1 als Anzahl der Widerstaende ist.
     */
    @Test
    void berechneDenGesamtWiderstandMitEinerNegativenAnzahlDerWiderstaende() {
        assertThrows(InvalidNumberOfResistorsException.class, () -> parallelSchaltung.berechneDenGesamtWiderstand(-1));
    }
    /** Exception Message test
     * Diese Methode , testet die Nachricht von InvalidNumberOfResistorsException.
     * Die erwartete Nachricht wird mit der aktuellen Nachricht verglichen.
     * Falls die Nachrichten gleich sind, besteht den Test.
     */
    @Test
    void berechneDenGesamtwiderstandMitKeinemWiderstandExceptionMessage() {
        Executable executable = () -> parallelSchaltung.berechneDenGesamtWiderstand(0);
        String expectedMessage = "Ungueltige Anzahl von Widerstaende!";
        Exception exception = assertThrows(InvalidNumberOfResistorsException.class, executable);
        assertEquals(expectedMessage, exception.getMessage());
    }

}
