
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import Grafiche.Grafica;
import Grafiche.GraficaLinguaInglese;
import Grafiche.GraficaLinguaItaliana;

public class MainTester {

    private static final String PERSISTENCE_UNIT_NAME = "GraficaPU";
    private static EntityManagerFactory factory;

   
    public static void main(String[] args){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();

        // read the existing entries
        Query q = em.createQuery("select g from Grafica g");
        // Persons should be empty

        // do we have entries?
        boolean createNewEntries = (q.getResultList().size() == 0);

        // No, so lets create new entries
        if (createNewEntries) {
            
            Grafica grafica1 = new Grafica();
            grafica1.setNomeFile("nomeDelFile1");
            grafica1.setImageFilePath("path1/pat1/pa1/p1");
            grafica1.setPrimaryKey((long) 1);
            //em.persist(grafica1);
            GraficaLinguaItaliana italiana1 = new GraficaLinguaItaliana();
            italiana1.setKeyWord("keyword 1 2 3 4 5");
            italiana1.setNome("Nome per la grafica");
            italiana1.setNomeRidotto("Nome per");
            italiana1.setPrimaryKey((long) 1);
            italiana1.addGraficaMadre(grafica1);
            //em.persist(italiana1);
            // now persists the family person relationship
            //italiana1.addGraficaMadre(grafica1);
            em.persist(grafica1);
            em.persist(italiana1);
            Grafica grafica2 = new Grafica();
            grafica2.setNomeFile("nomeDelFile2");
            grafica2.setImageFilePath("path2/pat2/pa2/p2");
            grafica2.setPrimaryKey(2);
            //em.persist(grafica1);
            GraficaLinguaItaliana italiana2 = new GraficaLinguaItaliana();
            italiana2.setKeyWord("keyword 6 7 8 9 0");
            italiana2.setNome("Nome per la grafica 2");
            italiana2.setNomeRidotto("Nome per 2");
            italiana2.setPrimaryKey(2);
            italiana2.addGraficaMadre(grafica2);
            //em.persist(italiana1);
            // now persists the family person relationship
            //italiana2.addGraficaMadre(grafica2);
            em.persist(grafica2);
            em.persist(italiana2);
        }
        else {
        	
        	/*
        	GraficaLinguaInglese graficaIngleseDue = new GraficaLinguaInglese();
        	graficaIngleseDue.setPrimaryKey(2);
        	graficaIngleseDue.setNome("English name2");
        	graficaIngleseDue.setKeyWord("one two three sdfdsfdsfds");
        	graficaIngleseDue.setNomeRidotto("bsadasdt");
        	Grafica grafica = new Grafica();
        	grafica.setPrimaryKey(2);
        	graficaIngleseDue.addGraficaMadre(grafica);
        	em.persist(graficaIngleseDue);
        	*/
        	
        	Query p = em.createQuery("select m from GraficaLinguaItaliana m");
        /*	Query p2 = em.createQuery("Select i from GraficaLinguaInglese i");
        	List<GraficaLinguaInglese> lista2 = p2.getResultList(); */
        	List<GraficaLinguaItaliana> lista = p.getResultList();
        	
        	for(GraficaLinguaItaliana g : lista) {
        		System.out.println(g.graficaMadre().getImageFilePath() + " - " + g.getNome()+"  - "+ g.getKeyWord());
        	}
        	/*for(GraficaLinguaInglese g : lista2) {
        		System.out.println(g.graficaMadre() + " - " + g.getNome());
        	}*/
        	

            em.close();
        }
        // Commit the transaction, which will cause the entity to
        // be stored in the database
        em.getTransaction().commit();
        // It is always good practice to close the EntityManager so that
        // resources are conserved.
        em.close();
    }
/*
    @Test
    public void checkAvailablePeople() {

        // now lets check the database and see if the created entries are there
        // create a fresh, new EntityManager
        EntityManager em = factory.createEntityManager();

        // Perform a simple query for all the Message entities
        Query q = em.createQuery("select m from GraficaLinguaItaliana m");

        // We should have 40 Persons in the database
        assertTrue(q.getResultList().size() == 2);

        em.close();
    }

    @Test
    public void checkFamily() {
        EntityManager em = factory.createEntityManager();
        // Go through each of the entities and print out each of their
        // messages, as well as the date on which it was created
        Query q = em.createQuery("select f from Grafica f");

        // We should have one family with 40 persons
        assertTrue(q.getResultList().size() == 2);
        em.close();
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deletePerson() {
        EntityManager em = factory.createEntityManager();
        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();
        Query q = em
                .createQuery("SELECT p FROM GraficaLinguaItaliana p WHERE p.nome = :firstName");
        q.setParameter("firstName", "Nome per la grafica");
        GraficaLinguaItaliana user = (GraficaLinguaItaliana) q.getSingleResult();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }
    */
}