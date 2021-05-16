/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yaritza
 */
@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n")
    , @NamedQuery(name = "Notas.findByIdnotas", query = "SELECT n FROM Notas n WHERE n.idnotas = :idnotas")
    , @NamedQuery(name = "Notas.findByCalificacion", query = "SELECT n FROM Notas n WHERE n.calificacion = :calificacion")
    , @NamedQuery(name = "Notas.findByPeriodo", query = "SELECT n FROM Notas n WHERE n.periodo = :periodo")})
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnotas")
    private Integer idnotas;
    @Size(max = 45)
    @Column(name = "calificacion")
    private String calificacion;
    @Column(name = "periodo")
    private Integer periodo;
    @JoinColumn(name = "alumnos_Documento", referencedColumnName = "Documento")
    @ManyToOne(optional = false)
    private Alumnos alumnosDocumento;
    @JoinColumn(name = "asignatura_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Asignaturas asignaturaCodigo;

    public Notas() {
    }

    public Notas(Integer idnotas) {
        this.idnotas = idnotas;
    }

    public Integer getIdnotas() {
        return idnotas;
    }

    public void setIdnotas(Integer idnotas) {
        this.idnotas = idnotas;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Alumnos getAlumnosDocumento() {
        return alumnosDocumento;
    }

    public void setAlumnosDocumento(Alumnos alumnosDocumento) {
        this.alumnosDocumento = alumnosDocumento;
    }

    public Asignaturas getAsignaturaCodigo() {
        return asignaturaCodigo;
    }

    public void setAsignaturaCodigo(Asignaturas asignaturaCodigo) {
        this.asignaturaCodigo = asignaturaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnotas != null ? idnotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idnotas == null && other.idnotas != null) || (this.idnotas != null && !this.idnotas.equals(other.idnotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Notas[ idnotas=" + idnotas + " ]";
    }
    
}
