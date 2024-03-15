import Schaltungen.ParallelSchaltung;
import Schaltungen.ReihenSchaltung;
import Exception.InvalidNumberOfResistorsException;
import Exception.InvalidCircuitException;
import javax.swing.*;
import java.math.BigDecimal;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "---JAVACIRCUITSIMU---" + "\n" + "Anleitung: " + "\n" + "Dieser Simulator kann sowohl den Gesamtwiderstand von einer Reihenschaltung als auch von einer Parallelschaltung berechnen." + "\n" + "Folgen Sie bitte alle Schritte, um den Simulator erfolgreich zu benutzen." + "\n" + "Wichtige Hinweise: " + "\n" + "- Die Schaltung darf maximal nur 3 Widerstaende haben." + "\n" + "- Die Anzahl der Widerstaende darf nicht kleiner als 1 sein." + "\n" + "Um fortzufahren, klicken Sie bitte auf OK.", "Information", JOptionPane.INFORMATION_MESSAGE);
        String eingabe;
        int eingegebeneZahl;
        boolean istDieZahlUngültig, istDieSchaltungsArtUngültig;
        String schaltungsArt;
        try {
            do {
                eingabe = showInputDialog(null, "Wählen Sie bitte eine Option aus:" + "\n" + "1. Programm starten" + "\n" + "2. Programm beenden", "Eingabe", JOptionPane.PLAIN_MESSAGE);
                eingegebeneZahl = Integer.parseInt(eingabe);
                istDieZahlUngültig = eingegebeneZahl < 1 || eingegebeneZahl > 2;


                if (istDieZahlUngültig) {
                    JOptionPane.showMessageDialog(null, "Die eingegebene Zahl " + eingegebeneZahl + " ist ungültig.", "Ungültige Eingabe", JOptionPane.WARNING_MESSAGE);
                }
                if (eingegebeneZahl == 1) {
                schaltungsArt = showInputDialog(null, "Geben Sie bitte die Schaltungsart (Reihenschaltung/Parallelschaltung) ein: "+"\n"+"Hinweis: Eine andere Schaltungsart kann zurzeit nicht ausgewählt werden.","Eingabe", JOptionPane.PLAIN_MESSAGE);
                    if (schaltungsArt.equalsIgnoreCase("Reihenschaltung")) {
                        int anzahlDerWiderstände = Integer.parseInt(showInputDialog(null, "Geben Sie bitte die Anzahl der Widerstände ein: ","Eingabe", JOptionPane.PLAIN_MESSAGE));

                        BigDecimal r1 = new BigDecimal(showInputDialog(null, "Geben Sie bitte den Wert des Widerstandes R1 ein: ","Eingabe", JOptionPane.PLAIN_MESSAGE));
                        BigDecimal r2 = null;
                        BigDecimal r3 = null;
                        if (anzahlDerWiderstände >= 2) {
                            r2 = new BigDecimal(showInputDialog(null, "Geben Sie bitte den Wert des Widerstandes R2 ein: ","Eingabe", JOptionPane.PLAIN_MESSAGE));
                        }
                        if (anzahlDerWiderstände == 3) {
                            r3 = new BigDecimal(showInputDialog(null, "Geben Sie bitte den Wert des Widerstandes R3 ein: ","Eingabe", JOptionPane.PLAIN_MESSAGE));
                        }

                        ReihenSchaltung reihenSchaltung = new ReihenSchaltung(anzahlDerWiderstände);
                        reihenSchaltung.setR1(r1);
                        reihenSchaltung.setR2(r2);
                        reihenSchaltung.setR3(r3);
                        reihenSchaltung.berechneDenGesamtWiderstand(anzahlDerWiderstände);
                        reihenSchaltung.zeigErgebnisDerBerechnungAn();
                    } else if (schaltungsArt.equalsIgnoreCase("Parallelschaltung")) {
                        int anzahlDerWiderstände = Integer.parseInt(showInputDialog(null, "Geben Sie bitte die Anzahl der Widerstände ein: ","Eingabe", JOptionPane.PLAIN_MESSAGE));

                        BigDecimal r1 = new BigDecimal(showInputDialog(null, "Geben Sie bitte den Wert des Widerstandes R1 ein: ","Eingabe", JOptionPane.PLAIN_MESSAGE));
                        BigDecimal r2 = null;
                        BigDecimal r3 = null;
                        if (anzahlDerWiderstände >= 2) {
                            r2 = new BigDecimal(showInputDialog(null, "Geben Sie bitte den Wert des Widerstandes R2 ein: ","Eingabe", JOptionPane.PLAIN_MESSAGE));
                        }
                        if (anzahlDerWiderstände == 3) {
                            r3 = new BigDecimal(showInputDialog(null, "Geben Sie bitte den Wert des Widerstandes R3 ein: ","Eingabe", JOptionPane.PLAIN_MESSAGE));
                        }

                        ParallelSchaltung parallelSchaltung = new ParallelSchaltung(anzahlDerWiderstände);
                        parallelSchaltung.setR1(r1);
                        parallelSchaltung.setR2(r2);
                        parallelSchaltung.setR3(r3);
                        parallelSchaltung.berechneDenGesamtWiderstand(anzahlDerWiderstände);
                        parallelSchaltung.zeigErgebnisDerBerechnungAn();


                    } else {
                        throw new InvalidCircuitException("Die eingegebene Schaltungsart existiert nicht!");
                    }

                }

            } while (eingegebeneZahl != 2 || istDieZahlUngültig);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nur Zahlen sind erlaubt!", "Oops :(, etwas ist schief gelaufen.", JOptionPane.WARNING_MESSAGE);
        }catch (InvalidNumberOfResistorsException e){
            JOptionPane.showMessageDialog(null, "Ungültige Anzahl von Widerstände!", "Oops :(, etwas ist schief gelaufen.", JOptionPane.WARNING_MESSAGE);
        }
        catch (InvalidCircuitException e){
            JOptionPane.showMessageDialog(null, "Die eingegebene Schaltungsart existiert nicht!", "Oops :(, etwas ist schief gelaufen.", JOptionPane.WARNING_MESSAGE);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Unbestimmter Fehler!", "Oops :(, etwas ist schief gelaufen.", JOptionPane.WARNING_MESSAGE);
        }


    }

}

