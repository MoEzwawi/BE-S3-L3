package MoEzwawi;

import MoEzwawi.dao.EventDAO;
import MoEzwawi.entities.Event;
import MoEzwawi.entities.enums.EventType;
import MoEzwawi.entities.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE-S3-L2");
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventDAO dao = new EventDAO(em);
/*
        Event evento1 = dao.getById(8);
*/
        Location capannone = new Location("polifunzionale","Bagnone");
        Event evento1 = new Event("Sagra della cipolla2",Event.parseDateForItaly("02/07/2024"),EventType.PUBLIC);
        evento1.setDescription("Per me la cipolla");
        evento1.setMaximumCapacity(100);
        evento1.setLocation(capannone);
        /* Event concerto = dao.getById(0);
        logger.info("L'evento "+concerto.getTitle()+" si terrà il "+concerto.getEventDate());
        Event partita = dao.getById(4);
        logger.info("L'evento "+partita.getTitle()+" si terrà il "+partita.getEventDate());*/
        dao.save(evento1);
        emf.close();
        em.close();
    }
}
