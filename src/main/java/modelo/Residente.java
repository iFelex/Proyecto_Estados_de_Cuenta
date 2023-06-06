package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "residente")
public class Residente implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_res", nullable = false)
    private int idResident;

    @Column(name = "documento_res", nullable = false)
    private String docResident;

    @Column(name = "nombre_res", nullable = false)
    private String nameResident;

    @Column(name = "tel_res", nullable = false)
    private String telResident;

    @Column(name = "direccion_res", nullable = false)
    private String addressResident;

    @OneToMany(mappedBy = "obl_res")
    private List<Obligacion> obligaciones;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adm_res",referencedColumnName = "id_adm")
    private Administrador adm_res;

    @OneToMany(mappedBy = "res_rec")
    private List<ReciboCobro> recibos;

    @OneToMany(mappedBy = "pag_res")
    private List<Pago> pagos;

    public Residente(int idResident, String docResident, String nameResident, String telResident, String addressResident, Administrador adm_res) {
        this.idResident = idResident;
        this.docResident = docResident;
        this.nameResident = nameResident;
        this.telResident = telResident;
        this.addressResident = addressResident;
        this.adm_res = adm_res;
    }

    public Residente(String docResident, String nameResident, String telResident, String addressResident, Administrador adm_res) {
        this.docResident = docResident;
        this.nameResident = nameResident;
        this.telResident = telResident;
        this.addressResident = addressResident;
        this.adm_res = adm_res;
    }

    public Residente(){}

    public int getIdResident() {
        return idResident;
    }

    public void setIdResident(int idResident) {
        this.idResident = idResident;
    }

    public String getDocResident() {
        return docResident;
    }

    public void setDocResident(String docResident) {
        this.docResident = docResident;
    }

    public String getNameResident() {
        return nameResident;
    }

    public void setNameResident(String nameResident) {
        this.nameResident = nameResident;
    }

    public String getTelResident() {
        return telResident;
    }

    public void setTelResident(String telResident) {
        this.telResident = telResident;
    }

    public String getAddressResident() {
        return addressResident;
    }

    public void setAddressResident(String addressResident) {
        this.addressResident = addressResident;
    }

    public List<Obligacion> getObligaciones() {
        return obligaciones;
    }

    public void setObligaciones(List<Obligacion> obligaciones) {
        this.obligaciones = obligaciones;
    }

    public Administrador getAdm_res() {
        return adm_res;
    }

    public void setAdm_res(Administrador adm_res) {
        this.adm_res = adm_res;
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
