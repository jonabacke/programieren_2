package Aufgabe_1;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * Ein einfacher J�ger-Beute-Simulator, basierend auf einem
 * Feld mit F�chsen und Hasen.
 * 
 * @author David J. Barnes und Michael K�lling
 * @version 2016.03.18
 */
public class Simulator
{
    // Konstanten f�r Konfigurationsinformationen �ber die Simulation.
    // Die Standardbreite f�r ein Feld.
    private static final int STANDARD_BREITE = 120;
    // Die Standardtiefe f�r ein Feld.
    private static final int STANDARD_TIEFE = 80;
    // Die Wahrscheinlichkeit f�r die Geburt eines Fuchses an
    // einer beliebigen Position im Feld.
    private static final double FUCHSGEBURT_WAHRSCHEINLICH = 0.02;
    // Die Wahrscheinlichkeit f�r die Geburt eines Hasen an
    // einer beliebigen Position im Feld.
    private static final double HASENGEBURT_WAHRSCHEINLICH = 0.08;    

    // Listen der Tiere im Feld. Getrennte Listen vereinfachen das Iterieren.
    private List<Tier> tiere;
    // Der aktuelle Zustand des Feldes
    private Feld feld;
    // Der aktuelle Schritt der Simulation
    private int schritt;
    // Eine grafische Ansicht der Simulation
    private List<Simulationsansicht> ansichten;
    
    /**
     * Erzeuge ein Simulationsfeld mit einer Standardgr��e.
     */
    public Simulator()
    {
        this(STANDARD_TIEFE, STANDARD_BREITE);
    }
      
    /**
     * Erzeuge ein Simulationsfeld mit der gegebenen Gr��e.
     * @param tiefe   die Tiefe des Feldes (muss gr��er als null sein)
     * @param breite  die Breite des Feldes (muss gr��er als null sein)
     */
    public Simulator(int tiefe, int breite)
    {
        if(breite <= 0 || tiefe <= 0) {
            System.out.println("Abmessungen m�ssen gr��er als null sein.");
            System.out.println("Benutze Standardwerte.");
            tiefe = STANDARD_TIEFE;
            breite = STANDARD_BREITE;
        }

        tiere = new ArrayList<>();
        feld = new Feld(tiefe, breite);

        ansichten = new ArrayList<>();
        
        Simulationsansicht ansicht = new GitterAnsicht(tiefe, breite);
        ansicht.setzeFarbe(Hase.class, Color.ORANGE);
        ansicht.setzeFarbe(Fuchs.class, Color.BLUE);
        ansichten.add(ansicht);
        
        ansicht = new DiagrammAnsicht(500, 150, 500);
        ansicht.setzeFarbe(Hase.class, Color.BLACK);
        ansicht.setzeFarbe(Fuchs.class, Color.RED);
        ansichten.add(ansicht);
        
        // Einen g�ltigen Startzustand einnehmen.
        zuruecksetzen();
    }
    
    /**
     * Starte die Simulation vom aktuellen Zustand aus f�r einen längeren
     * Zeitraum (4000 Schritte).
     */
    public void starteLangeSimulation()
    {
        simuliere(4000);
    }
    
    /**
     * F�hre vom aktuellen Zustand aus die angegebene Anzahl an
     * Simulationsschritten durch.
     * Brich vorzeitig ab, wenn die Simulation nicht mehr aktiv ist.
     * @param schritte  die Anzahl der auszuf�hrenden Schritte
     */
    public void simuliere(int schritte)
    {
        for(int schritt = 1; schritt <= schritte && ansichten.get(0).istAktiv(feld); schritt++) {
            simuliereEinenSchritt();
            //verzoegern(60);  //auskommentieren f�r langsameren Ablauf
        }
    }
    
    /**
     * F�hre einen einzelnen Simulationsschritt aus:
     * Durchlaufe alle Feldpositionen und aktualisiere den 
     * Zustand jedes Fuchses und Hasen.
     */
    public void simuliereEinenSchritt()
    {
        schritt++;
        
        // Platz f�r neugeborenes Tier anlegen.
        List<Tier> neueTiere = new ArrayList<>();
        // Alle Tiere agieren lassen.
        for(Iterator<Tier> iter = tiere.iterator(); iter.hasNext(); ) {
            Tier tier = iter.next();
            tier.agiere(neueTiere);
            if(!tier.istLebendig()) {
                iter.remove();
            }
        }
        
        // Neugeborene F�chse und Hasen in die Hauptliste einf�gen.
        tiere.addAll(neueTiere);

        aktualisiereAnsichten();
    }
        
    /**
     * Setze die Simulation an den Anfang zur�ck.
     */
    public void zuruecksetzen()
    {
        schritt = 0;
        tiere.clear();
        for (Simulationsansicht ansicht : ansichten) {
            ansicht.zuruecksetzen();
        }

        bevoelkere();
        aktualisiereAnsichten();
    }

    /**
     * Aktualisiere alle bestehenden Ansichten.
     */
    private void aktualisiereAnsichten()
    {
        for (Simulationsansicht ansicht : ansichten) {
            ansicht.zeigeStatus(schritt, feld);
        }
    }
    
    /**
     * Bev�lkere das Feld mit F�chsen und Hasen.
     */
    private void bevoelkere()
    {
        Random rand = Zufallssteuerung.gibZufallsgenerator();
        feld.raeumen();
        for(int zeile = 0; zeile < feld.gibTiefe(); zeile++) {
            for(int spalte = 0; spalte < feld.gibBreite(); spalte++) {
                if(rand.nextDouble() <= FUCHSGEBURT_WAHRSCHEINLICH) {
                    Position position = new Position(zeile, spalte); 
                    Fuchs fuchs = new Fuchs(true, feld, position);
                    tiere.add(fuchs);
                }
                else if(rand.nextDouble() <= HASENGEBURT_WAHRSCHEINLICH) {
                    Position position = new Position(zeile, spalte); 
                    Hase hase = new Hase(true, feld, position);
                    tiere.add(hase);
                }
                // ansonsten die Position leer lassen
            }
        }
    }
    
    /**
     * Die Simulation f�r die angegebene Zeit anhalten.
     * @param millisek  die zu pausierende Zeit in Millisekunden
     */
    private void verzoegern(int millisek)
    {
        try {
            Thread.sleep(millisek);
        }
        catch (InterruptedException ie) {
            // aufwachen
        }
    }
}