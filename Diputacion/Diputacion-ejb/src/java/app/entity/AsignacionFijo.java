/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tone
 */
@Entity
@Table(name = "ASIGNACION_FIJO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionFijo.findAll", query = "SELECT a FROM AsignacionFijo a"),
    @NamedQuery(name = "AsignacionFijo.findByFechaAsignacion", query = "SELECT a FROM AsignacionFijo a WHERE a.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "AsignacionFijo.findByFechaFin", query = "SELECT a FROM AsignacionFijo a WHERE a.fechaFin = :fechaFin"),
    @NamedQuery(name = "AsignacionFijo.findByCodigo", query = "SELECT a FROM AsignacionFijo a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "AsignacionFijo.findByCoste", query = "SELECT a FROM AsignacionFijo a WHERE a.coste = :coste"),
    @NamedQuery(name = "AsignacionFijo.findByAsignado", query = "SELECT a FROM AsignacionFijo a WHERE a.asignado = :asignado")})
public class AsignacionFijo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Long codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coste")
    private BigDecimal coste;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignado")
    private char asignado;
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Usuario dni;
    @JoinColumn(name = "codigo_terminal", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Terminal codigoTerminal;
    @JoinColumn(name = "codigo_numero", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Linea codigoNumero;
    @JoinColumn(name = "codigo_cat", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Categoria codigoCat;

    public AsignacionFijo() {
    }

    public AsignacionFijo(Long codigo) {
        this.codigo = codigo;
    }

    public AsignacionFijo(Long codigo, Date fechaAsignacion, Date fechaFin, char asignado) {
        this.codigo = codigo;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaFin = fechaFin;
        this.asignado = asignado;
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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCoste() {
        return coste;
    }

    public void setCoste(BigDecimal coste) {
        this.coste = coste;
    }

    public char getAsignado() {
        return asignado;
    }

    public void setAsignado(char asignado) {
        this.asignado = asignado;
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

    public Linea getCodigoNumero() {
        return codigoNumero;
    }

    public void setCodigoNumero(Linea codigoNumero) {
        this.codigoNumero = codigoNumero;
    }

    public Categoria getCodigoCat() {
        return codigoCat;
    }

    public void setCodigoCat(Categoria codigoCat) {
        this.codigoCat = codigoCat;
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
        if (!(object instanceof AsignacionFijo)) {
            return false;
        }
        AsignacionFijo other = (AsignacionFijo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.AsignacionFijo[ codigo=" + codigo + " ]";
    }
    
}
