package de.pischka.java.tipps.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Die gezeigten Beispiele sollen verdeutlichen, wie mit JUnit 5 auf erwartete Exceptions getestet werden kann.
 */
public class JUnit5ErwarteteExceptions {

  /**
   * Teste die Konvertierung.
   */
  @Test
  public void positiverTest() {
    assertEquals(15, this.konvertiereInPositiveGanzzahl("15"));
    assertEquals(0, this.konvertiereInPositiveGanzzahl("0"));
  }

  /**
   * Hier wird lediglich der Typ der erwarteten Exception überprüft.
   */
  @Test
  public void erwarteExceptionTest() {

    assertThrows(IllegalArgumentException.class, () -> this.konvertiereInPositiveGanzzahl(null));
    assertThrows(IllegalArgumentException.class, () -> this.konvertiereInPositiveGanzzahl(""));
    assertThrows(IllegalArgumentException.class, () -> this.konvertiereInPositiveGanzzahl("-1"));
    assertThrows(IllegalArgumentException.class, () -> this.konvertiereInPositiveGanzzahl("xy"));
    assertThrows(IllegalArgumentException.class, () -> this.konvertiereInPositiveGanzzahl("1.3"));
  }

  /**
   * Hier wird über den Typ hinaus die mitgegebene Fehlermeldung überprüft.
   */
  @Test
  public void erwarteKonkreteFehlermeldungTest() {

    Exception exceptionLeererParameter = assertThrows(IllegalArgumentException.class,
        () -> this.konvertiereInPositiveGanzzahl(null));
    assertEquals("Der Eingabeparameter ist leer", exceptionLeererParameter.getMessage());

    Exception exceptionFalscheEingabe = assertThrows(IllegalArgumentException.class,
        () -> this.konvertiereInPositiveGanzzahl("xy"));
    assertEquals("Die Eingabe entspricht nicht einer positiven Ganzzahl", exceptionFalscheEingabe.getMessage());
  }

  /**
   * Konvertiert eine positive Ganzzahl aus einer Zeichenkette in ein Integer.
   *
   * @param zahlAlsZeichenkette Zu konvertierende Zahl
   * @return Ergebnis
   */
  private Integer konvertiereInPositiveGanzzahl(String zahlAlsZeichenkette) {

    if (zahlAlsZeichenkette == null) {
      throw new IllegalArgumentException("Der Eingabeparameter ist leer");
    }
    if (!zahlAlsZeichenkette.matches("\\d+")) {
      throw new IllegalArgumentException("Die Eingabe entspricht nicht einer positiven Ganzzahl");
    }

    return Integer.parseInt(zahlAlsZeichenkette);
  }
}
