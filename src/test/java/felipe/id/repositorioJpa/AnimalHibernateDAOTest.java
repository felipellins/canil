/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.repositorioJpa;

import felipe.id.model.Animal;
import felipe.id.model.AnimalModel;
import felipe.id.model.Canil;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Felipe
 */
public class AnimalHibernateDAOTest {

    AnimalModel am = new AnimalModel();

    Animal a1 = new Animal("14", "ercules", 5, "Médio", "Pastor", "dog", "02/07/2018", "02/07/2018", null, can);
    Animal a2 = new Animal("15", "ercules", 5, "Médio", "Pastor", "dog", "02/07/2018", "02/07/2018", null, can);
    private static Canil can;
    private static Animal a3;

    @BeforeAll
    public void objetoIniciado() {

        can = new Canil();
        a1 = new Animal("14", "ercules", 5, "Médio", "Pastor", "dog", "02/07/2018", "02/07/2018", null, can);
        a2 = new Animal("15", "ercules", 5, "Médio", "Pastor", "dog", "02/07/2018", "02/07/2018", null, can);
        a3 = new Animal("16", "piter", 5, "Médio", "pigmeu", "dog", "02/07/2018", "02/07/2018", null, can);
    }

    public void inserir() {

        am.cadastrarAnimal(a1);

        assertEquals(a1, am.recuperar("14"));

    }

    public void delete() {

        am.cadastrarAnimal(a2);
        am.removerAnimal(15);

        // valor tem que ser nulo
        assertNull(am.recuperar("15"));

    }

    public void alterar() {

        am.cadastrarAnimal(a3);

        a3 = new Animal("16", "piter alterado", 5, "Médio", "pigmeu", "dog", "02/07/2018", "02/07/2018", null, can);
        a3.setCodAnimal("16");
        am.alterarAnimal(a3);

        assertEquals(a3, am.recuperar("16"));

    }

    public void recuperar() {
        // nao pode ser nulo
        assertNotNull(am.recuperar("15"));

    }

    @Test
    public void iguais() {
        // iguais 
        assertEquals(a1.getNomeAni(), a2.getNomeAni());

        // não iguais
        //  assertNotEquals(am.recuperar("14"),am.recuperar("16"));  
    }

    public void recuperarTodos() {

        // nao pode ser nulo
        assertNotNull(am.RecuperarTodos());

    }

    public void recuperarOfaos() {

        // nao pode ser nulo
        assertNotNull(am.RecuperarOrfaos());

    }

}
