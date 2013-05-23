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
@Table(name = "LLAMADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamada.findAll", query = "SELECT l FROM Llamada l"),
    @NamedQuery(name = "Llamada.findByCodigo", query = "SELECT l FROM Llamada l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Llamada.findByCodigoNumero", query = "SELECT l FROM Llamada l WHERE l.codigoNumero = :codigoNumero"),
    @NamedQuery(name = "Llamada.findByNumeroDestino", query = "SELECT l FROM Llamada l WHERE l.numeroDestino = :numeroDestino"),
    @NamedQuery(name = "Llamada.findByTipo", query = "SELECT l FROM Llamada l WHERE l.tipo = :tipo"),
    @NamedQuery(name = "Llamada.findByDuracion", query = "SELECT l FROM Llamada l WHERE l.duracion = :duracion"),
    @NamedQuery(name = "Llamada.findByCoste", query = "SELECT l FROM Llamada l WHERE l.coste = :coste"),
    @NamedQuery(name = "Llamada.findByInicio", query = "SELECT l FROM Llamada l WHERE l.inicio = :inicio"),
    @NamedQuery(name = "Llamada.findByFin", query = "SELECT l FROM Llamada l WHERE l.fin = :fin")})
public class Llamada implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "coste")
    private BigDecimal coste;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "numero_destino")
    private String numeroDestino;
    @Size(max = 40)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    @JoinColumn(name = "codigo_numero", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Linea codigoNumero;

    public Llamada() {
    }

    public Llamada(Long codigo) {
        this.codigo = codigo;
    }

    public Llamada(Long codigo, String numeroDestino, int duracion, BigDecimal coste) {
        this.codigo = codigo;
        this.numeroDestino = numeroDestino;
        this.duracion = duracion;
        this.coste = coste;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
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
        if (!(object instanceof Llamada)) {
            return false;
        }
        Llamada other = (Llamada) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Llamada[ codigo=" + codigo + " ]";
    }

    public Llamada(Linea codigoNumero) {
        this.codigoNumero = codigoNumero;
    }

    public Llamada(Linea codigoNumero, BigDecimal coste) {
        this.codigoNumero = codigoNumero;
        this.coste = coste;
    }

    public BigDecimal getCoste() {
        return coste;
    }

    public void setCoste(BigDecimal coste) {
        this.coste = coste;
    }

    

    
    
}
