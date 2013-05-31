/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tone
 */
@Entity
@Table(name = "TERMINAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t"),
    @NamedQuery(name = "Terminal.findByCodigo", query = "SELECT t FROM Terminal t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Terminal.findByFechaAlta", query = "SELECT t FROM Terminal t WHERE t.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "Terminal.findByFechaBaja", query = "SELECT t FROM Terminal t WHERE t.fechaBaja = :fechaBaja"),
    @NamedQuery(name = "Terminal.findByMarca", query = "SELECT t FROM Terminal t WHERE t.marca = :marca"),
    @NamedQuery(name = "Terminal.findByModelo", query = "SELECT t FROM Terminal t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "Terminal.findByConfiguracion", query = "SELECT t FROM Terminal t WHERE t.configuracion = :configuracion"),
    @NamedQuery(name = "Terminal.findBySn", query = "SELECT t FROM Terminal t WHERE t.sn = :sn"),
    @NamedQuery(name = "Terminal.findByNumeroInterno", query = "SELECT t FROM Terminal t WHERE t.numeroInterno = :numeroInterno"),
    @NamedQuery(name = "Terminal.findByPedido", query = "SELECT t FROM Terminal t WHERE t.pedido = :pedido"),
    @NamedQuery(name = "Terminal.findByProduct", query = "SELECT t FROM Terminal t WHERE t.product = :product")})
public class Terminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Size(max = 40)
    @Column(name = "marca")
    private String marca;
    @Size(max = 40)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 200)
    @Column(name = "configuracion")
    private String configuracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sn")
    private long sn;
    @Size(max = 40)
    @Column(name = "numero_interno")
    private String numeroInterno;
    @Size(max = 400)
    @Column(name = "pedido")
    private String pedido;
    @Size(max = 200)
    @Column(name = "product")
    private String product;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTerminal")
    private Collection<AsignacionFijo> asignacionFijoCollection;
    @OneToMany(mappedBy = "codigoTerminal")
    private Collection<Tarea> tareaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTerminal")
    private Collection<Rma> rmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTerminal")
    private Collection<AsignacionMovil> asignacionMovilCollection;

    public Terminal() {
    }

    public Terminal(Integer codigo) {
        this.codigo = codigo;
    }

    public Terminal(Integer codigo, long sn) {
        this.codigo = codigo;
        this.sn = sn;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }

    public long getSn() {
        return sn;
    }

    public void setSn(long sn) {
        this.sn = sn;
    }

    public String getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(String numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @XmlTransient
    public Collection<AsignacionFijo> getAsignacionFijoCollection() {
        return asignacionFijoCollection;
    }

    public void setAsignacionFijoCollection(Collection<AsignacionFijo> asignacionFijoCollection) {
        this.asignacionFijoCollection = asignacionFijoCollection;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    @XmlTransient
    public Collection<Rma> getRmaCollection() {
        return rmaCollection;
    }

    public void setRmaCollection(Collection<Rma> rmaCollection) {
        this.rmaCollection = rmaCollection;
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
        if (!(object instanceof Terminal)) {
            return false;
        }
        Terminal other = (Terminal) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Terminal[ codigo=" + codigo + " ]";
    }
    
}
