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
@Table(name = "ASIGNACION_MOVIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionMovil.findAll", query = "SELECT a FROM AsignacionMovil a"),
    @NamedQuery(name = "AsignacionMovil.findByFechaAsignacion", query = "SELECT a FROM AsignacionMovil a WHERE a.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "AsignacionMovil.findByFechaFin", query = "SELECT a FROM AsignacionMovil a WHERE a.fechaFin = :fechaFin"),
    @NamedQuery(name = "AsignacionMovil.findByDni", query = "SELECT a FROM AsignacionMovil a WHERE a.asignacionMovilPK.dni = :dni"),
    @NamedQuery(name = "AsignacionMovil.findByCodigoNumero", query = "SELECT a FROM AsignacionMovil a WHERE a.asignacionMovilPK.codigoNumero = :codigoNumero"),
    @NamedQuery(name = "AsignacionMovil.findByCodigoTerminal", query = "SELECT a FROM AsignacionMovil a WHERE a.asignacionMovilPK.codigoTerminal = :codigoTerminal")})
public class AsignacionMovil implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coste")
    private BigDecimal coste;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignado")
    private char asignado;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionMovilPK asignacionMovilPK;
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
    @JoinColumn(name = "codigo_terminal", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Terminal terminal;
    @JoinColumn(name = "dni", referencedColumnName = "dni", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "codigo_perfil", referencedColumnName = "codigo")
    @ManyToOne
    private Perfil codigoPerfil;
    @JoinColumn(name = "codigo_numero", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Linea linea;

    public AsignacionMovil() {
    }

    public AsignacionMovil(AsignacionMovilPK asignacionMovilPK) {
        this.asignacionMovilPK = asignacionMovilPK;
    }

    public AsignacionMovil(AsignacionMovilPK asignacionMovilPK, Date fechaAsignacion, Date fechaFin) {
        this.asignacionMovilPK = asignacionMovilPK;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaFin = fechaFin;
    }

    public AsignacionMovil(String dni, int codigoNumero, int codigoTerminal) {
        this.asignacionMovilPK = new AsignacionMovilPK(dni, codigoNumero, codigoTerminal);
    }

    public AsignacionMovilPK getAsignacionMovilPK() {
        return asignacionMovilPK;
    }

    public void setAsignacionMovilPK(AsignacionMovilPK asignacionMovilPK) {
        this.asignacionMovilPK = asignacionMovilPK;
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

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Perfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
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
        hash += (asignacionMovilPK != null ? asignacionMovilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionMovil)) {
            return false;
        }
        AsignacionMovil other = (AsignacionMovil) object;
        if ((this.asignacionMovilPK == null && other.asignacionMovilPK != null) || (this.asignacionMovilPK != null && !this.asignacionMovilPK.equals(other.asignacionMovilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.AsignacionMovil[ asignacionMovilPK=" + asignacionMovilPK + " ]";
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
