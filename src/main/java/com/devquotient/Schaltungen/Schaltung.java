package com.devquotient.Schaltungen;

import com.devquotient.Exception.InvalidNumberOfResistorsException;

import javax.swing.*;
import java.math.BigDecimal;


/**
 * Die Klasse Schaltung ist abstract, damit man nicht erlaubt,
 * dass ein Objekt der Klasse Schaltung instanzieert wird.
 */
public abstract class Schaltung {
    protected final int MAXIMALE_ANZAHL_VON_MOEGLICHEN_WIDERSTAENDEN = 3; // Das Attribut ist final, da das Programm nur Schaltungen mit maixmal 3 Widerstaenden lösen kann.
    protected final int MINIMALE_ANZAHL_VON_MOEGLICHEN_WIDERSTAENDEN = 1;
    protected Schaltungsart schaltungsart; // Attribut schaltungsart vom Typ Enum Schaltungen.Schaltungsart
    protected int anzahlDerWiderstaende;
    protected BigDecimal r1, r2, r3;
    protected BigDecimal gesamtWiderstand;


    public Schaltung(int anzahlDerWiderstaende) {
        this.schaltungsart = schaltungsart;
        this.anzahlDerWiderstaende = anzahlDerWiderstaende;

    }

    public Schaltung() {
    }

    public int getMAXIMALE_ANZAHL_VON_MOEGLICHEN_WIDERSTAENDEN() {
        return MAXIMALE_ANZAHL_VON_MOEGLICHEN_WIDERSTAENDEN;
    }

    public int getMINIMALE_ANZAHL_VON_MOEGLICHEN_WIDERSTAENDEN() {
        return MINIMALE_ANZAHL_VON_MOEGLICHEN_WIDERSTAENDEN;
    }

    public BigDecimal getGesamtWiderstand() {
        return gesamtWiderstand;
    }

    public void setGesamtWiderstand(BigDecimal gesamtWiderstand) {
        this.gesamtWiderstand = gesamtWiderstand;
    }


    public BigDecimal getR1() {
        return r1;
    }

    public void setR1(BigDecimal r1) {
        this.r1 = r1;
    }

    public BigDecimal getR2() {
        return r2;
    }

    public void setR2(BigDecimal r2) {
        this.r2 = r2;
    }

    public BigDecimal getR3() {
        return r3;
    }

    public void setR3(BigDecimal r3) {
        this.r3 = r3;
    }

    public Schaltungsart getSchaltungsart() {
        return schaltungsart;
    }

    public void setSchaltungsart(Schaltungsart schaltungsart) {
        this.schaltungsart = schaltungsart;
    }

    public int getAnzahlDerWiderstaende() {
        return anzahlDerWiderstaende;
    }

    public void setAnzahlDerWiderstaende(int anzahlDerWiderstaende) {
        this.anzahlDerWiderstaende = anzahlDerWiderstaende;
    }

    // Die methode berechneDenGesamtWiderstand, wir in den Unterklassen implementiert, da man fuer eine Reihenschaltung eine andere Formel hat, im Vergleich zu ParallelSchaltung
    public abstract BigDecimal berechneDenGesamtWiderstand(int anzahlDerWiderstaende) throws InvalidNumberOfResistorsException;

    public void zeigErgebnisDerBerechnungAn(){
        String message = "---ERGEBNIS DER BERECHNUNG---\n" +
                "SCHALTUNGSTYP: " + this.getSchaltungsart() + "\n" +
                "ANZAHL DER WIDERSTÄNDE: " + this.getAnzahlDerWiderstaende() + "\n" +
                "GESAMTWIDERSTAND: " + this.getGesamtWiderstand() + "Ω";

        JOptionPane.showMessageDialog(null, message,"Ergebnis der Berechnung",JOptionPane.INFORMATION_MESSAGE);
    }

}
