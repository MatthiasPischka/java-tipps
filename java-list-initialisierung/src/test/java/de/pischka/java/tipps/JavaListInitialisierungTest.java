package de.pischka.java.tipps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaListInitialisierungTest {

  /**
   * Liste aus einem Array erzeugen
   */
  @Test
  public void erzeugeListAusArray() {
    // Die lange Variante mit expliziter Array-Erzeugung
    List<String> liste1 = Arrays.asList(new String[]{"Warsteiner", "Krombacher"});
    // Überprüfung
    Assertions.assertTrue(liste1.contains("Warsteiner"));
    Assertions.assertEquals(2, liste1.size());

    // Kürzere und besser lesbare Variante
    List<String> liste2 = Arrays.asList("Warsteiner", "Krombacher");
    // Überprüfung
    Assertions.assertTrue(liste2.contains("Warsteiner"));
    Assertions.assertEquals(2, liste1.size());
  }

  /**
   * Liste aus einem Stream erzeugen (Java 8)
   */
  @Test
  public void erzeugeListAusStream() {
    List<String> liste3 = Stream.of("Warsteiner", "Krombacher").collect(Collectors.toList());
    // Überprüfung
    Assertions.assertTrue(liste3.contains("Warsteiner"));
    Assertions.assertEquals(2, liste3.size());
  }
}
