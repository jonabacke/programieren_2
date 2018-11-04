package Aufgabe_1;

import java.awt.Color;

/**
 * Eine grafische Ansicht des Simulationsfeldes. Diese Schnittstelle definiert alle
 * möglichen unterschiedlichen Ansichten.
 *
 * @author David J. Barnes und Michael Kölling
 * @version 2016.03.18
 */
public interface Simulationsansicht 
{    
    /**
     * Definiere eine Farbe für die gegebene Tierklasse.
     * @param tierklasse  das Klassenobjekt der Tierklasse
     * @param farbe       die zu benutzende Farbe für die Tierklasse
     */
    void setzeFarbe(Class tierklasse, Color farbe);

    /**
     * Entscheide, ob die Simulation weiterlaufen soll.
     * @param true  wenn mehr als eine Spezies existiert
     */
    boolean istAktiv(Feld feld);

    /**
     * Zeige den aktuellen Zustand des Feldes.
     * @param schritt  welcher Iterationsschritt ist dies?
     * @param feld     das Feld, das angezeigt werden soll
     */
    void zeigeStatus(int schritt, Feld feld);

    /**
     * Bereite einen neuen Lauf vor.
     */
    void zuruecksetzen();

}
