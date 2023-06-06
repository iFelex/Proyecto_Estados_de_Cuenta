package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_pay", nullable = false)
    private int idPay;

    @Column(name = "direccion_propiedad", nullable = false)
    private String adressProperty;

    @Column(name = "periodo_pago", nullable = false)
    private String periodPay;

    @Column(name = "des_pago", nullable = false)
    private String descPay;

    @Column(name = "valor", nullable = false)
    private Double value;

    @Column(name = "saldo", nullable = false)
    private Double valueDue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pag_pro",referencedColumnName = "id_pro")
    private Propietario pag_pro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pag_res",referencedColumnName = "id_res")
    private Residente pag_res;

    public Pago(String adressProperty, String periodPay, String descPay, Double value, Double valueDue, Propietario pag_pro) {
        this.adressProperty = adressProperty;
        this.periodPay = periodPay;
        this.descPay = descPay;
        this.value = value;
        this.valueDue = valueDue;
        this.pag_pro = pag_pro;
    }

    public Pago(){}

    public int getIdPay() {
        return idPay;
    }

    public void setIdPay(int idPay) {
        this.idPay = idPay;
    }

    public String getAdressProperty() {
        return adressProperty;
    }

    public void setAdressProperty(String adressProperty) {
        this.adressProperty = adressProperty;
    }

    public String getPeriodPay() {
        return periodPay;
    }

    public void setPeriodPay(String periodPay) {
        this.periodPay = periodPay;
    }

    public String getDescPay() {
        return descPay;
    }

    public void setDescPay(String descPay) {
        this.descPay = descPay;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValueDue() {
        return valueDue;
    }

    public void setValueDue(Double valueDue) {
        this.valueDue = valueDue;
    }

    public Propietario getPag_pro() {
        return pag_pro;
    }

    public void setPag_pro(Propietario pag_pro) {
        this.pag_pro = pag_pro;
    }

    public Residente getPag_res() {
        return pag_res;
    }

    public void setPag_res(Residente pag_res) {
        this.pag_res = pag_res;
    }
}
