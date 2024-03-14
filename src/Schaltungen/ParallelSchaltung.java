package Schaltungen;

import Exception.InvalidNumberOfResistorsException;

import java.math.BigDecimal;

/**
 * Die Klasse ParallelSchaltung ist eine Unterklasse von Schaltungen.Schaltung und das Wort extends, erlaubt die Vererbung von Attributten und Methoden der Oberklasse Schaltung
 */
public class ParallelSchaltung extends Schaltung {


    public ParallelSchaltung(int anzahlDerWiderstaende) {
        super(anzahlDerWiderstaende);
        this.setSchaltungsart(Schaltungsart.PARALLELSCHALTUNG);
    }

    /**
     * Die Methode berechneDenGesamtwiderstand wird in der Unterklasse ParallelSchaltung implementiert.
     * Hinweis: Die Formel zur Berechnung von GesamtWiderstand in einer Parallelschaltung ist unterschiedlich von einer Schaltungen ReihenSchaltung.
     * Formel: Rges = 1/r1 + 1/r2 +1/r3
     * Formel fuer 2 Widerstaende : Rges = r1*r2/r1+r2
     * Formel fuer 3 Widerstaende : Rges = 1/kehrwert Des Widerstands denn--> 1/Rges = 1/r1 +1/r2 +1/r3;
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
                this.setGesamtWiderstand(this.getR1()); // Wenn die Schaltung nur 1 Widerstand besitzt, ist der Gesamtwiderstand gleich der Widerstand1
                break;
            case 2:
                this.setGesamtWiderstand(this.getR1().multiply(this.getR2()).divide(this.getR1().add(this.getR2())));
                break;
            case 3:
                BigDecimal kehrwertDesRges = BigDecimal.ONE.divide(this.getR1().add(BigDecimal.ONE)
                        .divide(this.getR2()).add(BigDecimal.ONE)
                        .divide(this.getR3()), BigDecimal.ROUND_HALF_UP);
                this.setGesamtWiderstand(BigDecimal.ONE.divide(kehrwertDesRges));
                break;


        }

        return this.getGesamtWiderstand();
    }


}



