package modelo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "recibo_cobro")
public class ReciboCobro implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_recibo", nullable = false)
    private int idRecibo;

    @Column(name = "nombre_propiedad", nullable = false)
    private String nameProperty;

    @Column(name = "direccion_admin", nullable = false)
    private String adressAdmin;

    @Column(name = "tel_admin", nullable = false)
    private String telAdmin;

    @Column(name = "desc_recibo", nullable = false)
    private String descReceipt;

    @Column(name = "valor", nullable = false)
    private Double value;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha", nullable = false)
    private Date date;

    @Column(name = "estado_recibo", nullable = false)
    private String state;

    @Column(name = "acuerdo_pago")
    private String agreementPay;

    @Column(name = "saldo")
    private Double pendingValue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pro_rec",referencedColumnName = "id_pro")
    private Propietario pro_rec;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "res_rec",referencedColumnName = "id_res")
    private Residente res_rec;

    public ReciboCobro(String nameProperty, String adressAdmin, String telAdmin, String descReceipt, Double value, Date date, String state, String agreementPay, Double pendingValue) {
        this.nameProperty = nameProperty;
        this.adressAdmin = adressAdmin;
        this.telAdmin = telAdmin;
        this.descReceipt = descReceipt;
        this.value = value;
        this.date = date;
        this.state = state;
        this.agreementPay = agreementPay;
        this.pendingValue = pendingValue;
    }

    public ReciboCobro(){}

    public int getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    public String getNameProperty() {
        return nameProperty;
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty = nameProperty;
    }

    public String getAdressAdmin() {
        return adressAdmin;
    }

    public void setAdressAdmin(String adressAdmin) {
        this.adressAdmin = adressAdmin;
    }

    public String getTelAdmin() {
        return telAdmin;
    }

    public void setTelAdmin(String telAdmin) {
        this.telAdmin = telAdmin;
    }

    public String getDescReceipt() {
        return descReceipt;
    }

    public void setDescReceipt(String descReceipt) {
        this.descReceipt = descReceipt;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAgreementPay() {
        return agreementPay;
    }

    public void setAgreementPay(String agreementPay) {
        this.agreementPay = agreementPay;
    }

    public Double getPendingValue() {
        return pendingValue;
    }

    public void setPendingValue(Double pendingValue) {
        this.pendingValue = pendingValue;
    }

    public Propietario getPro_rec() {
        return pro_rec;
    }

    public void setPro_rec(Propietario pro_rec) {
        this.pro_rec = pro_rec;
    }

    public Residente getRes_rec() {
        return res_rec;
    }

    public void setRes_rec(Residente res_rec) {
        this.res_rec = res_rec;
    }
}
