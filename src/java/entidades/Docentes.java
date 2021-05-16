/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
 * @author Yaritza
 */
@Entity
@Table(name = "docentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d")
    , @NamedQuery(name = "Docentes.findByDocumento", query = "SELECT d FROM Docentes d WHERE d.documento = :documento")
    , @NamedQuery(name = "Docentes.findByNombre", query = "SELECT d FROM Docentes d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Docentes.findByApellidos", query = "SELECT d FROM Docentes d WHERE d.apellidos = :apellidos")
    , @NamedQuery(name = "Docentes.findByFechadenacimiento", query = "SELECT d FROM Docentes d WHERE d.fechadenacimiento = :fechadenacimiento")
    , @NamedQuery(name = "Docentes.findByDireccion", query = "SELECT d FROM Docentes d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "Docentes.findByTelefono", query = "SELECT d FROM Docentes d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Docentes.findByCorreoElectronico", query = "SELECT d FROM Docentes d WHERE d.correoElectronico = :correoElectronico")})
public class Docentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Documento")
    private Integer documento;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Fecha_de_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadenacimiento;
    @Size(max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @JoinColumn(name = "TIPO_DOCUMENTO_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoDocumento tIPODOCUMENTOid;

    public Docentes() {
    }

    public Docentes(Integer documento) {
        this.documento = documento;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(Date fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public TipoDocumento getTIPODOCUMENTOid() {
        return tIPODOCUMENTOid;
    }

    public void setTIPODOCUMENTOid(TipoDocumento tIPODOCUMENTOid) {
        this.tIPODOCUMENTOid = tIPODOCUMENTOid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Docentes[ documento=" + documento + " ]";
    }
    
}
