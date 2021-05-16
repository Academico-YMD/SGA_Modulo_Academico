/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
 * @author Yaritza
 */
@Entity
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a")
    , @NamedQuery(name = "Alumnos.findByDocumento", query = "SELECT a FROM Alumnos a WHERE a.documento = :documento")
    , @NamedQuery(name = "Alumnos.findByNombre", query = "SELECT a FROM Alumnos a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumnos.findByApellidos", query = "SELECT a FROM Alumnos a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "Alumnos.findByFechadenacimiento", query = "SELECT a FROM Alumnos a WHERE a.fechadenacimiento = :fechadenacimiento")
    , @NamedQuery(name = "Alumnos.findBySisben", query = "SELECT a FROM Alumnos a WHERE a.sisben = :sisben")
    , @NamedQuery(name = "Alumnos.findByDireccion", query = "SELECT a FROM Alumnos a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Alumnos.findByTelefono", query = "SELECT a FROM Alumnos a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Alumnos.findByCorreoElectronico", query = "SELECT a FROM Alumnos a WHERE a.correoElectronico = :correoElectronico")})
public class Alumnos implements Serializable {

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
    @Column(name = "Sisben")
    private String sisben;
    @Size(max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 100)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @JoinTable(name = "alumno_has_curso", joinColumns = {
        @JoinColumn(name = "ALUMNO_Documento", referencedColumnName = "Documento")}, inverseJoinColumns = {
        @JoinColumn(name = "CURSO_codigo", referencedColumnName = "codigo")})
    @ManyToMany
    private List<Cursos> cursosList;
    @JoinColumn(name = "TIPO_DOCUMENTO_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoDocumento tIPODOCUMENTOid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnosDocumento")
    private List<Notas> notasList;

    public Alumnos() {
    }

    public Alumnos(Integer documento) {
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

    public String getSisben() {
        return sisben;
    }

    public void setSisben(String sisben) {
        this.sisben = sisben;
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

    @XmlTransient
    public List<Cursos> getCursosList() {
        return cursosList;
    }

    public void setCursosList(List<Cursos> cursosList) {
        this.cursosList = cursosList;
    }

    public TipoDocumento getTIPODOCUMENTOid() {
        return tIPODOCUMENTOid;
    }

    public void setTIPODOCUMENTOid(TipoDocumento tIPODOCUMENTOid) {
        this.tIPODOCUMENTOid = tIPODOCUMENTOid;
    }

    @XmlTransient
    public List<Notas> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Notas> notasList) {
        this.notasList = notasList;
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
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
    
}
