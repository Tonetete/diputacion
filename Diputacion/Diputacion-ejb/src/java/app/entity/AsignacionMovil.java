/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ASIGNACION_MOVIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionMovil.findAll", query = "SELECT a FROM AsignacionMovil a"),
    @NamedQuery(name = "AsignacionMovil.findByAsignado", query = "SELECT a FROM AsignacionMovil a WHERE a.asignado = :asignado"),
    @NamedQuery(name = "AsignacionMovil.findByCoste", query = "SELECT a FROM AsignacionMovil a WHERE a.coste = :coste"),
    @NamedQuery(name = "AsignacionMovil.findByFechaAsignacion", query = "SELECT a FROM AsignacionMovil a WHERE a.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "AsignacionMovil.findByFechaFin", query = "SELECT a FROM AsignacionMovil a WHERE a.fechaFin = :fechaFin"),
    @NamedQuery(name = "AsignacionMovil.findByCodigo", query = "SELECT a FROM AsignacionMovil a WHERE a.codigo = :codigo")})
public class AsignacionMovil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "asignado")
    private Character asignado;
    @Column(name = "coste")
    private BigInteger coste;
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Usuario dni;
    @JoinColumn(name = "codigo_terminal", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Terminal codigoTerminal;
    @JoinColumn(name = "codigo_perfil", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Perfil codigoPerfil;
    @JoinColumn(name = "codigo_numero", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Linea codigoNumero;

    public AsignacionMovil() {
    }

    public AsignacionMovil(String codigo) {
        this.codigo = codigo;
    }

    public Character getAsignado() {
        return asignado;
    }

    public void setAsignado(Character asignado) {
        this.asignado = asignado;
    }

    public BigInteger getCoste() {
        return coste;
    }

    public void setCoste(BigInteger coste) {
        this.coste = coste;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getDni() {
        return dni;
    }

    public void setDni(Usuario dni) {
        this.dni = dni;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionMovil)) {
            return false;
        }
        AsignacionMovil other = (AsignacionMovil) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.AsignacionMovil[ codigo=" + codigo + " ]";
    }
    
}
