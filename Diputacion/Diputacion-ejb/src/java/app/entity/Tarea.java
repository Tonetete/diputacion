/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tone
 */
@Entity
@Table(name = "TAREA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByIdTarea", query = "SELECT t FROM Tarea t WHERE t.idTarea = :idTarea"),
    @NamedQuery(name = "Tarea.findByDni", query = "SELECT t FROM Tarea t WHERE t.dni = :dni"),
    @NamedQuery(name = "Tarea.findByFechaEmision", query = "SELECT t FROM Tarea t WHERE t.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Tarea.findByValidado", query = "SELECT t FROM Tarea t WHERE t.validado = :validado")})
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)    
    @Column(name = "id_tarea")
    private Integer idTarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dni")
    private String dni;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "validado")
    private Character validado;
    @JoinColumn(name = "tipo_tarea", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoTarea tipoTarea;
    @JoinColumn(name = "dni_tarea_asignado", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Usuario dniTareaAsignado;
    @JoinColumn(name = "codigo_terminal", referencedColumnName = "codigo")
    @ManyToOne
    private Terminal codigoTerminal;
    @JoinColumn(name = "codigo_perfil", referencedColumnName = "codigo")
    @ManyToOne
    private Perfil codigoPerfil;
    @JoinColumn(name = "codigo_numero", referencedColumnName = "codigo")
    @ManyToOne
    private Linea codigoNumero;
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    @ManyToOne
    private Categoria codigoCategoria;

    public Tarea() {
    }

    public Tarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Tarea(Integer idTarea, String dni) {
        this.idTarea = idTarea;
        this.dni = dni;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Character getValidado() {
        return validado;
    }

    public void setValidado(Character validado) {
        this.validado = validado;
    }

    public TipoTarea getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(TipoTarea tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public Usuario getDniTareaAsignado() {
        return dniTareaAsignado;
    }

    public void setDniTareaAsignado(Usuario dniTareaAsignado) {
        this.dniTareaAsignado = dniTareaAsignado;
    }

    public Terminal getCodigoTerminal() {
        return codigoTerminal;
    }

    public void setCodigoTerminal(Terminal codigoTerminal) {
        this.codigoTerminal = codigoTerminal;
    }

    public Perfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Perfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public Linea getCodigoNumero() {
        return codigoNumero;
    }

    public void setCodigoNumero(Linea codigoNumero) {
        this.codigoNumero = codigoNumero;
    }

    public Categoria getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Categoria codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Tarea[ idTarea=" + idTarea + " ]";
    }
    
}
