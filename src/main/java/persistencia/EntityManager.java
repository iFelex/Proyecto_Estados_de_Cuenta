package persistencia;

import modelo.*;
import org.jboss.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EntityManager {

    private javax.persistence.EntityManager entityManager;
    private EntityManagerFactory entityManagerFac;
    private Logger logger = Logger.getLogger(EntityManager.class);

    public EntityManager(){
        try {
            entityManagerFac= Persistence.createEntityManagerFactory("proyectoFinal");
            entityManager=entityManagerFac.createEntityManager();
        }catch(Exception e) {
            Writer buffer = new StringWriter();
            PrintWriter pw = new PrintWriter(buffer);
            e.printStackTrace(pw);
            logger.info(buffer.toString());
        }
    }

    public Administrador getAdmin(String user){
        List<Administrador> listManager = this.getAdmins();
        for (Administrador manager: listManager) {
            if(manager.getUserAdm().equals(user)){return manager;}
        }
        return null;
    }

    public Residente existResident(String document, int idAdmin){
        List<Residente> residents = this.getResidentes(idAdmin);
        for (Residente resident: residents) {
            if(resident.getDocResident().equals(document)){return resident;}
        }
        return null;
    }

    public Administrador getAdmin(int id){
        List<Administrador> admins = this.getAdmins();
        for (Administrador admin: admins) {
            if(admin.getIdAdm() == id){return admin;}
        }
        return null;
    }

    public List<Administrador> getAdmins(){
        List<Administrador> listManager = entityManager.createQuery("SELECT e FROM Administrador e").getResultList();
        return listManager;
    }

    public void agregarPropietario(Propietario propietario){
        entityManager.getTransaction().begin();
        entityManager.persist(propietario);
        entityManager.getTransaction().commit();
    }

    public Propietario getPropietario(String user){
        List<Propietario> owners = this.getPropietarios();
        for (Propietario owner: owners) {
            if(owner.getUserProp().equals(user)){return owner;}
        }
        return null;
    }

    public Propietario getPropietario(int id){
        List<Propietario> allOwners = this.getPropietarios();
        for (Propietario owner: allOwners) {
            if(owner.getIdProp() == id){return owner;}
        }
        return null;
    }

    public List<Propietario> getPropietarios(){
        List<Propietario> listOwner = entityManager.createQuery("SELECT e FROM Propietario e").getResultList();
        return listOwner;
    }

    public boolean existeResidente(String document, int idAdmin) {
        List<Residente> residents = this.getResidentes(idAdmin);
        for (Residente resident: residents) {
            if(resident.getDocResident().equals(document)){return true;}
        }
        return false;
    }

    public void agregarResidente(Residente residente) {
        entityManager.getTransaction().begin();
        entityManager.persist(residente);
        entityManager.getTransaction().commit();
    }

    public Residente getResidente(String doc, int idAdmin){
        List<Residente> residentes = this.getResidentes(idAdmin);
        for (Residente residente: residentes) {
            if(residente.getDocResident().equals(doc)){return residente;}
        }
        return null;
    }

    private List<Residente> getResidentes(int idAdmin) {
        List<Residente> listResidentes = entityManager.createQuery("SELECT e FROM Residente e").getResultList();
        return listResidentes;
    }

    public void modificarResidente(Residente residente) {
        entityManager.getTransaction().begin();
        entityManager.merge(residente);
        entityManager.getTransaction().commit();
    }

    public void agregarRecibo(ReciboCobro recibo) {
        entityManager.getTransaction().begin();
        entityManager.persist(recibo);
        entityManager.getTransaction().commit();
    }

    public void agregarObligacion(Obligacion obligacion) {
        entityManager.getTransaction().begin();
        entityManager.persist(obligacion);
        entityManager.getTransaction().commit();
    }

    public void agregarHistorialPago(Pago payment) {
        entityManager.getTransaction().begin();
        entityManager.persist(payment);
        entityManager.getTransaction().commit();
    }

    public Boolean existePropietario(int doc) {
        List<Propietario> propietarios = this.getPropietarios();
        for (Propietario propietario: propietarios) {
            if(propietario.getIdProp() == doc){return true;}
        }
        return false;
    }

    public void changeStateOwner(Propietario propietario, String state) {
        entityManager.getTransaction().begin();
        propietario.setPayStateProp(state);
        entityManager.merge(propietario);
        entityManager.getTransaction().commit();
    }

    public int getValueReservation(short number) {
        return 4000*number;
    }

    public void agregarReservacion(Reservacion reservacion) {
        entityManager.getTransaction().begin();
        Obligacion obligacion = new Obligacion("Cobro por reservacion",reservacion.getValueReser());
        Propietario propietario = reservacion.getRes_pro();
        propietario.getObligaciones().add(obligacion);
        propietario.setPayStateProp("Con deuda");
        entityManager.persist(reservacion);
        entityManager.getTransaction().commit();

    }

    public boolean existeReservacion(int idAdmin, String name, Date date) {
        List<Reservacion> reservaciones = getReservaciones(idAdmin);
        for (Reservacion reservacion: reservaciones){
            if (name.equals(reservacion.getNamePlace())){
                Date dateRes = reservacion.getDateReser();
                if (!date.before(dateRes)){return true;}
                else {return false;}
            }
        }
        return false;
    }

    public boolean existeReservacion(String name, Date date) {
        ArrayList<Reservacion> reservaciones = (ArrayList<Reservacion>) getReservaciones();
        for (Reservacion reservacion: reservaciones){
            if (name.equals(reservacion.getNamePlace())){
                Date dateRes = reservacion.getDateReser();
                if (!date.before(dateRes)){return true;}
                else {return false;}
            }
        }
        return false;
    }

    public List<Reservacion> getReservaciones(int idAdmin) {
        List<Reservacion> allReservations;
        List<Reservacion> reservations = new ArrayList<>();
        allReservations = entityManager.createQuery("SELECT e FROM Reservacion e").getResultList();
        for (Reservacion reservacion: allReservations) {
            if (reservacion.getRes_pro().getAdm_pro().getIdAdm() == idAdmin){reservations.add(reservacion);}
        }
        return reservations;
    }

    public List<Reservacion> getReservaciones() {
        return entityManager.createQuery("SELECT e FROM Reservacion e").getResultList();
    }

    public boolean reservacionDisponible(int idAdmin, Date date, String name) {
        return !existeReservacion(idAdmin,name,date);
    }

    public boolean reservacionDisponible(Date date, String name) {
        return !existeReservacion(name,date);
    }

    public Reservacion getReservacion(int idAdmin, int idRes) {
        ArrayList<Reservacion> reservaciones = (ArrayList<Reservacion>) getReservaciones(idAdmin);
        for(Reservacion reservacion:reservaciones){
            if (reservacion.getIdReser() == idRes){
                return reservacion;
            }
        }
        return null;
    }

    public int getMulta(Reservacion reservacion) {
        boolean option = validarFechaMulta(reservacion);
        if (option){
            int value = (int) (reservacion.getValueReser()/2);
            Propietario propietario = reservacion.getRes_pro();
            Obligacion obligacion = new Obligacion("Multa cancelacion de reservacion", (double) value);
            return value;
        }else {
            return 0;
        }
    }

    public boolean validarFechaMulta(Reservacion reservacion){
        Calendar calendar = Calendar.getInstance();
        Date currentDate = Calendar.getInstance().getTime();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        Date limitDate = calendar.getTime();
        if(!reservacion.getDateReser().after(limitDate)) {return true;}
        else {return false;}
    }
}
