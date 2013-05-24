/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tone
 */
@Entity
@Table(name = "PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByCodigo", query = "SELECT p FROM Perfil p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Perfil.findByDescripcion", query = "SELECT p FROM Perfil p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Perfil.findBySaldoLimite", query = "SELECT p FROM Perfil p WHERE p.saldoLimite = :saldoLimite"),
    @NamedQuery(name = "Perfil.findByCoste", query = "SELECT p FROM Perfil p WHERE p.coste = :coste")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "saldo_limite")
    private Long saldoLimite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coste")
    private BigDecimal coste;
    @OneToMany(mappedBy = "codigoPerfil")
    private Collection<Tarea> tareaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPerfil")
    private Collection<AsignacionMovil> asignacionMovilCollection;

    public Perfil() {
    }

    public Perfil(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getSaldoLimite() {
        return saldoLimite;
    }

    public void setSaldoLimite(Long saldoLimite) {
        this.saldoLimite = saldoLimite;
    }

    public BigDecimal getCoste() {
        return coste;
    }

    public void setCoste(BigDecimal coste) {
        this.coste = coste;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    @XmlTransient
    public Collection<AsignacionMovil> getAsignacionMovilCollection() {
        return asignacionMovilCollection;
    }

    public void setAsignacionMovilCollection(Collection<AsignacionMovil> asignacionMovilCollection) {
        this.asignacionMovilCollection = asignacionMovilCollection;
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
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Perfil[ codigo=" + codigo + " ]";
    }
    
}
