package com.devquotient.Schaltungen;

import com.devquotient.Exception.InvalidNumberOfResistorsException;

import java.math.BigDecimal;

/**
 * Die Klasse Schaltungen.ReihenSchaltung ist eine Unterklasse von Schaltungen.Schaltung und das Wort extends, erlaubt die Vererbung von Attributten und Methoden der Oberklasse Schaltungen.Schaltung
 */
public class ReihenSchaltung extends Schaltung {


    public ReihenSchaltung(int anzahlDerWiderstaende) {
        super(anzahlDerWiderstaende);
        this.setSchaltungsart(Schaltungsart.REIHENSCHALTUNG);
    }

    public ReihenSchaltung() {
    }

    /**
     * Die Methode berechneDenGesamtwiderstand wird in der Unterklasse Reihenschaltung implementiert.
     * Hinweis: Die Formel zur Berechnung von GesamtWiderstand in einer Reihenschaltung ist unterschiedlich von einer ParallelSchaltung.
     * Formel: Rges= R1+R2+R3;-> Allgemein kann man sagen, dass der Gesamtwiderstand in einer Reihenschaltung gleich die Summe der Widerstaenden.
     *
     * @param anzahlDerWiderstaende
     * @return Gesamtwiderstand
     */
    @Override
    public BigDecimal berechneDenGesamtWiderstand(int anzahlDerWiderstaende) throws InvalidNumberOfResistorsException {

        if (anzahlDerWiderstaende < MINIMALE_ANZAHL_VON_MOEGLICHEN_WIDERSTAENDEN || anzahlDerWiderstaende > MAXIMALE_ANZAHL_VON_MOEGLICHEN_WIDERSTAENDEN) {
            throw new InvalidNumberOfResistorsException("Ungueltige Anzahl von Widerstaende!");
        }
        switch (anzahlDerWiderstaende) {
            case 1:
                this.setGesamtWiderstand(this.getR1()); // Wenn die Schaltung nur 1 Widerstand besitzt, ist der Gesamtwiderstand gleich dem wert des einzigen Widerstandes; Rges= R1;
                break;
            case 2:
                this.setGesamtWiderstand(this.getR1().add(this.getR2()));// Rges = R1+R2;
                break;
            case 3:
                this.setGesamtWiderstand(this.getR1().add(this.getR2().add(this.getR3())));// Rges = R1+R2+R3; Rges = Gesamtwiderstand
                break;
        }

        return this.getGesamtWiderstand();
    }


}







