package modelo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservacion")
public class Reservacion implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_reservation", nullable = false)
    private int idReser;

    @Column(name = "direccion_reservation", nullable = false)
    private String adressReser;

    @Column(name = "nombre_lugar", nullable = false)
    private String namePlace;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha", nullable = false)
    private Date dateReser;

    @Column(name = "numero_horas", nullable = false)
    private short numberHours;

    @Column(name = "valor", nullable = false)
    private Double valueReser;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "res_pro",referencedColumnName = "id_pro")
    private Propietario res_pro;

    public Reservacion(String adressReser, String namePlace, Date dateReser, short numberHours, Double valueReser) {
        this.adressReser = adressReser;
        this.namePlace = namePlace;
        this.dateReser = dateReser;
        this.numberHours = numberHours;
        this.valueReser = valueReser;
    }

    public Reservacion(){}

    public int getIdReser() {
        return idReser;
    }

    public void setIdReser(int idReser) {
        this.idReser = idReser;
    }

    public String getAdressReser() {
        return adressReser;
    }

    public void setAdressReser(String adressReser) {
        this.adressReser = adressReser;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public Date getDateReser() {
        return dateReser;
    }

    public void setDateReser(Date dateReser) {
        this.dateReser = dateReser;
    }

    public short getNumberHours() {
        return numberHours;
    }

    public void setNumberHours(short numberHours) {
        this.numberHours = numberHours;
    }

    public Double getValueReser() {
        return valueReser;
    }

    public void setValueReser(Double valueReser) {
        this.valueReser = valueReser;
    }

    public Propietario getRes_pro() {
        return res_pro;
    }

    public void setRes_pro(Propietario res_pro) {
        this.res_pro = res_pro;
    }
}
