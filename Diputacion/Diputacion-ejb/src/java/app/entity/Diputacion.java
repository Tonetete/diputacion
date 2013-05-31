/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "DIPUTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diputacion.findAll", query = "SELECT d FROM Diputacion d"),
    @NamedQuery(name = "Diputacion.findByCodigo", query = "SELECT d FROM Diputacion d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Diputacion.findByDireccion", query = "SELECT d FROM Diputacion d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Diputacion.findByTelefono", query = "SELECT d FROM Diputacion d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Diputacion.findByCodPostal", query = "SELECT d FROM Diputacion d WHERE d.codPostal = :codPostal"),
    @NamedQuery(name = "Diputacion.findByCiudad", query = "SELECT d FROM Diputacion d WHERE d.ciudad = :ciudad")})
public class Diputacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 9)
    @Column(name = "cod_postal")
    private String codPostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(mappedBy = "codigoDip")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diputacion")
    private Collection<PlanConcertacion> planConcertacionCollection;

    public Diputacion() {
    }

    public Diputacion(Integer codigo) {
        this.codigo = codigo;
    }

    public Diputacion(Integer codigo, String direccion, String ciudad) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<PlanConcertacion> getPlanConcertacionCollection() {
        return planConcertacionCollection;
    }

    public void setPlanConcertacionCollection(Collection<PlanConcertacion> planConcertacionCollection) {
        this.planConcertacionCollection = planConcertacionCollection;
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
        if (!(object instanceof Diputacion)) {
            return false;
        }
        Diputacion other = (Diputacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Diputacion[ codigo=" + codigo + " ]";
    }
    
}
