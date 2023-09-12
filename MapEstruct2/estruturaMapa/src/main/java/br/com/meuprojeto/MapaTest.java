package br.com.meuprojeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MapaTest {
    private Mapa<String, Integer> mapa;

    @BeforeEach
    public void setup() {
        mapa = new Mapa<>();
    }

    @Test
    public void testeColocarEObter() {
        mapa.colocar("chave", 123);
        assertEquals(123, mapa.obter("chave"));
    }

    @Test
    public void testeRemover() {
        mapa.colocar("chave", 123);
        mapa.remover("chave");
        assertNull(mapa.obter("chave"));
    }

    @Test
    public void testeContemChave() {
        mapa.colocar("chave", 123);
        assertTrue(mapa.contemChave("chave"));
        assertFalse(mapa.contemChave("chave2"));
    }
}

