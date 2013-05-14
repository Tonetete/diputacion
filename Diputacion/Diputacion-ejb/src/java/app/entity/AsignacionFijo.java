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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "AsignacionFijo.findByDni", query = "SELECT a FROM AsignacionFijo a WHERE a.asignacionFijoPK.dni = :dni"),
    @NamedQuery(name = "AsignacionFijo.findByCodigoNumero", query = "SELECT a FROM AsignacionFijo a WHERE a.asignacionFijoPK.codigoNumero = :codigoNumero"),
    @NamedQuery(name = "AsignacionFijo.findByCodigoCat", query = "SELECT a FROM AsignacionFijo a WHERE a.asignacionFijoPK.codigoCat = :codigoCat")})
public class AsignacionFijo implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coste")
    private BigDecimal coste;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignado")
    private char asignado;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionFijoPK asignacionFijoPK;
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
    @JoinColumn(name = "codigo_terminal", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Terminal codigoTerminal;
    @JoinColumn(name = "codigo_cat", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "dni", referencedColumnName = "dni", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "codigo_numero", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Linea linea;

    public AsignacionFijo() {
    }

    public AsignacionFijo(AsignacionFijoPK asignacionFijoPK) {
        this.asignacionFijoPK = asignacionFijoPK;
    }

    public AsignacionFijo(AsignacionFijoPK asignacionFijoPK, Date fechaAsignacion, Date fechaFin) {
        this.asignacionFijoPK = asignacionFijoPK;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaFin = fechaFin;
    }

    public AsignacionFijo(String dni, int codigoNumero, int codigoCat) {
        this.asignacionFijoPK = new AsignacionFijoPK(dni, codigoNumero, codigoCat);
    }

    public AsignacionFijoPK getAsignacionFijoPK() {
        return asignacionFijoPK;
    }

    public void setAsignacionFijoPK(AsignacionFijoPK asignacionFijoPK) {
        this.asignacionFijoPK = asignacionFijoPK;
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

    public Terminal getCodigoTerminal() {
        return codigoTerminal;
    }

    public void setCodigoTerminal(Terminal codigoTerminal) {
        this.codigoTerminal = codigoTerminal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionFijoPK != null ? asignacionFijoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionFijo)) {
            return false;
        }
        AsignacionFijo other = (AsignacionFijo) object;
        if ((this.asignacionFijoPK == null && other.asignacionFijoPK != null) || (this.asignacionFijoPK != null && !this.asignacionFijoPK.equals(other.asignacionFijoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.AsignacionFijo[ asignacionFijoPK=" + asignacionFijoPK + " ]";
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
    
}
