package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "propietario")
public class Propietario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_pro", nullable = false)
    private int idProp;

    @Column(name = "usuario_pro", nullable = false)
    private String userProp;

    @Column(name = "contraseña_pro", nullable = false)
    private String passwordProp;

    @Column(name = "nombre_pro", nullable = false)
    private String nameProp;

    @Column(name = "direccion_pro", nullable = false)
    private String adressProp;

    @Column(name = "estado_pago_pro", nullable = false)
    private String payStateProp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adm_pro",referencedColumnName = "id_adm")
    private Administrador adm_pro;

    @OneToMany(mappedBy = "res_pro")
    private List<Reservacion> reservaciones;

    @OneToMany(mappedBy = "pro_rec")
    private List<ReciboCobro> recibos;

    @OneToMany(mappedBy = "pag_pro")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "obl_pro")
    private List<Obligacion> obligaciones;

    public Propietario(int idProp, String userProp, String passwordProp, String nameProp, String adressProp, String payStateProp) {
        this.idProp = idProp;
        this.userProp = userProp;
        this.passwordProp = passwordProp;
        this.nameProp = nameProp;
        this.adressProp = adressProp;
        this.payStateProp = payStateProp;
    }

    public Propietario() {}

    public int getIdProp() {
        return idProp;
    }

    public void setIdProp(int idProp) {
        this.idProp = idProp;
    }

    public String getUserProp() {
        return userProp;
    }

    public void setUserProp(String userProp) {
        this.userProp = userProp;
    }

    public String getPasswordProp() {
        return passwordProp;
    }

    public void setPasswordProp(String passwordProp) {
        this.passwordProp = passwordProp;
    }

    public String getNameProp() {
        return nameProp;
    }

    public void setNameProp(String nameProp) {
        this.nameProp = nameProp;
    }

    public String getAdressProp() {
        return adressProp;
    }

    public void setAdressProp(String adressProp) {
        this.adressProp = adressProp;
    }

    public String getPayStateProp() {
        return payStateProp;
    }

    public void setPayStateProp(String payStateProp) {
        this.payStateProp = payStateProp;
    }

    public List<Obligacion> getObligaciones() {
        return obligaciones;
    }

    public Double valueObligations(){
        List<Obligacion> obligacions = this.getObligaciones();
        Double result = 0.0;
        for (Obligacion obligacion: obligacions) {
            result+=obligacion.getValue();
        }
        return result;
    }

    public void setObligaciones(List<Obligacion> obligaciones) {
        this.obligaciones = obligaciones;
    }

    public Administrador getAdm_pro() {
        return adm_pro;
    }

    public void setAdm_pro(Administrador adm_pro) {
        this.adm_pro = adm_pro;
    }

    public List<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(List<Reservacion> reservaciones) {
        this.reservaciones = reservaciones;
    }

    public List<ReciboCobro> getRecibos() {
        return recibos;
    }

    public void setRecibos(List<ReciboCobro> recibos) {
        this.recibos = recibos;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
}
