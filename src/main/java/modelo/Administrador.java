package modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_adm", nullable = false)
    private int idAdm;

    @Column(name = "usuario_adm", nullable = false)
    private String userAdm;

    @Column(name = "contraseña_adm", nullable = false)
    private String passwordAdm;

    @Column(name = "nombre_adm", nullable = false)
    private String nameAdm;

    @Column(name = "tel_adm", nullable = false)
    private Long telAdm;

    @OneToMany(mappedBy = "adm_pro")
    private List<Propietario> propietarios;

    @OneToMany(mappedBy = "adm_res")
    private List<Residente> residentes;

    public Administrador(String nameAdm, Long telAdm, String userAdm, String passwordAdm) {
        this.nameAdm = nameAdm;
        this.telAdm = telAdm;
        this.userAdm = userAdm;
        this.passwordAdm = passwordAdm;
    }

    public Administrador(){}

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public String getUserAdm() {
        return userAdm;
    }

    public void setUserAdm(String userAdm) {
        this.userAdm = userAdm;
    }

    public String getPasswordAdm() {
        return passwordAdm;
    }

    public void setPasswordAdm(String passwordAdm) {
        this.passwordAdm = passwordAdm;
    }

    public String getNameAdm() {
        return nameAdm;
    }

    public void setNameAdm(String nameAdm) {
        this.nameAdm = nameAdm;
    }

    public Long getTelAdm() {
        return telAdm;
    }

    public void setTelAdm(Long telAdm) {
        this.telAdm = telAdm;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public List<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Residente> residentes) {
        this.residentes = residentes;
    }
}
