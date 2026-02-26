package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    void estVainqueurContre_gagne_si_attaque_superieure() {
        // GIVEN
        Pokemon pikachu = new Pokemon("Pikachu", "", new Stats(55, 40));
        Pokemon bulbizarre = new Pokemon("Bulbizarre", "", new Stats(49, 49));

        // WHEN
        boolean resultat = pikachu.estVainqueurContre(bulbizarre);

        // THEN
        assertTrue(resultat);
    }

    @Test
    void estVainqueurContre_perd_si_attaque_inferieure() {
        // GIVEN
        Pokemon pikachu = new Pokemon("Pikachu", "", new Stats(48, 40));
        Pokemon dracaufeu = new Pokemon("Dracaufeu", "", new Stats(84, 78));

        // WHEN
        boolean resultat = pikachu.estVainqueurContre(dracaufeu);

        // THEN
        assertFalse(resultat);
    }

    @Test
    void estVainqueurContre_gagne_si_attaque_egale_et_defense_superieure() {
        Pokemon carapuce = new Pokemon("Carapuce", "", new Stats(50, 65));
        Pokemon salameche = new Pokemon("Salamèche", "", new Stats(50, 43));

        // WHEN
        boolean resultat = carapuce.estVainqueurContre(salameche);

        // THEN
        assertTrue(resultat);
    }

    @Test
    void estVainqueurContre_perd_si_attaque_egale_et_defense_inferieure() {
        // GIVEN
        Pokemon salameche = new Pokemon("Salamèche", "", new Stats(50, 43));
        Pokemon carapuce = new Pokemon("Carapuce", "",new Stats(50, 65));

        // WHEN
        boolean resultat = salameche.estVainqueurContre(carapuce);

        // THEN
        assertFalse(resultat);
    }

    @Test
    void estVainqueurContre_gagne_si_attaque_et_defense_egales_priorite_au_premier() {
        // GIVEN
        Pokemon mew = new Pokemon("Mew", "", new Stats(100, 100));
        Pokemon mewtwo = new Pokemon("Mewtwo", "", new Stats(100, 100));

        // WHEN
        boolean resultat = mew.estVainqueurContre(mewtwo);

        // THEN
        assertTrue(resultat);
    }
}