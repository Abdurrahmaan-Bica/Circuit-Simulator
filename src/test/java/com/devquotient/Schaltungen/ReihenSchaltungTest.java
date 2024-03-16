package com.devquotient.Schaltungen;

import com.devquotient.Exception.InvalidNumberOfResistorsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests der Klasse ReihenSchaltung wurden von DevQuotient geschrieben
 */

class ReihenSchaltungTest {

    private ReihenSchaltung reihenSchaltung;
    @BeforeEach
    public void create(){
        reihenSchaltung = new ReihenSchaltung();

    }
    // Die ersten 3 Tests, uberpruefen ob man den Gesamtwiderstand mit 1/2/3 Widerstaende berechnen kann.
    // Erster Test

    @Test
    void berechneDenGesamtWiderstandMitEinemWiderstand() throws InvalidNumberOfResistorsException {
        reihenSchaltung.setAnzahlDerWiderstaende(1);
        reihenSchaltung.setR1(BigDecimal.valueOf(20));

        assertEquals(BigDecimal.valueOf(20),reihenSchaltung.berechneDenGesamtWiderstand(1));

    }
    // Zweiter Test
    @Test
    void berechneDenGesamtWiderstandMitZweiWiderstaende() throws InvalidNumberOfResistorsException {
        reihenSchaltung.setAnzahlDerWiderstaende(2);
        reihenSchaltung.setR1(BigDecimal.valueOf(20));
        reihenSchaltung.setR2(BigDecimal.valueOf(30));

        assertEquals(BigDecimal.valueOf(50),reihenSchaltung.berechneDenGesamtWiderstand(2));

    }
    // Dritter Test
    @Test
    void berechneDenGesamtWiderstandMitDreiWiderstaende() throws InvalidNumberOfResistorsException {
        reihenSchaltung.setAnzahlDerWiderstaende(3);
        reihenSchaltung.setR1(BigDecimal.valueOf(20));
        reihenSchaltung.setR2(BigDecimal.valueOf(25));
        reihenSchaltung.setR3(BigDecimal.valueOf(30));

        assertEquals(BigDecimal.valueOf(75),reihenSchaltung.berechneDenGesamtWiderstand(3));

    }
    // Exception Test 1 , wenn die Anzahl der Widerstaende 4 ist.
    /**
     * Diese Methode,testet ob ein InvalidNumberOfResistorsException geworfen wird, wenn die Anzahl der Widerstaende 4 ist.
     */
    @Test
    void berechneDenGesamtWiderstandMitVierWiderstaende(){
        assertThrows(InvalidNumberOfResistorsException.class,()->reihenSchaltung.berechneDenGesamtWiderstand(4));

    }

    // Exception Test 2 fuer 0 als Anzahl der Widerstaende
    /**
     * Diese Methode,testet ob ein InvalidNumberOfResistorsException geworfen wird, wenn die Anzahl der Widerstaende 0 ist.
     */
    @Test
    void berechneDenGesamtWiderstandMit0Widerstaende(){
        assertThrows(InvalidNumberOfResistorsException.class,()->reihenSchaltung.berechneDenGesamtWiderstand(0));

    }
    // Exception Test 3, fuer eine negative Zahl
    /**
     * Diese Methode,testet ob ein InvalidNumberOfResistorsException geworfen wird, falls -1 als Anzahl der Widerstaende ist.
     */
    @Test
    void berechneDenGesamtWiderstandMitEinerNegativenAnzahlDerWiderstaende(){
        assertThrows(InvalidNumberOfResistorsException.class,()->reihenSchaltung.berechneDenGesamtWiderstand(-1));

    }
    /** Exception Message test
     * Diese Methode , testet die Nachricht von InvalidNumberOfResistorsException.
     * Die erwartete Nachricht wird mit der aktuellen Nachricht verglichen.
     * Falls die Nachrichten gleich sind, besteht den Test.
     */
    @Test
    void berechneDenGesamtwiderstandMitKeinemWiderstandExceptionMessage(){
        Executable executable = () -> reihenSchaltung.berechneDenGesamtWiderstand(0);
        String erwarteteNachricht = "Ungueltige Anzahl von Widerstaende!";
        Exception exception = assertThrows(InvalidNumberOfResistorsException.class,executable);
        assertEquals(erwarteteNachricht,exception.getMessage());
    }

}