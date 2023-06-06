package modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "obligacion")
public class Obligacion implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_obl", nullable = false)
    private int idObligation;

    @Column(name = "desc_obli", nullable = false)
    private String descObligation;

    @Column(name = "valor", nullable = false)
    private Double value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "obl_pro",referencedColumnName = "id_pro")
    private Propietario obl_pro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "obl_res",referencedColumnName = "id_res")
    private Residente obl_res;

    public Obligacion(String descObligation, Double value) {
        this.descObligation = descObligation;
        this.value = value;
    }

    public Obligacion() {}

    public int getIdObligation() {
        return idObligation;
    }

    public void setIdObligation(int idObligation) {
        this.idObligation = idObligation;
    }

    public String getDescObligation() {
        return descObligation;
    }

    public void setDescObligation(String descObligation) {
        this.descObligation = descObligation;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Propietario getObl_pro() {
        return obl_pro;
    }

    public void setObl_pro(Propietario obl_pro) {
        this.obl_pro = obl_pro;
    }

    public Residente getObl_res() {
        return obl_res;
    }

    public void setObl_res(Residente obl_res) {
        this.obl_res = obl_res;
    }
}
