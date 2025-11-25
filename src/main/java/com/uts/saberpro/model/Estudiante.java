package com.uts.saberpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Datos personales
    private String tipoDocumento;
    
    @Column(unique = true, nullable = false)
    private String documento;
    
    private String registro;
    
    @Column(nullable = false)
    private String primerNombre;
    
    private String segundoNombre;
    
    @Column(nullable = false)
    private String primerApellido;
    
    private String segundoApellido;
    
    private String correo;
    
    private String telefono;
    
    private String programa;
    
    // Puntajes globales
    private Integer puntajeTotal;
    
    private String nivelTotal;
    
    // Comunicación Escrita
    private Integer comunicacionEscrita;
    private String comunicacionEscritaNivel;
    
    // Razonamiento Cuantitativo
    private Integer razonamientoCuantitativo;
    private String razonamientoCuantitativoNivel;
    
    // Lectura Crítica
    private Integer lecturaCritica;
    private String lecturaCriticaNivel;
    
    // Competencias Ciudadanas
    private Integer competenciasCiudadanas;
    private String competenciasCiudadanasNivel;
    
    // Inglés (solo nivel, sin puntaje)
    private String inglesNivel;
    
    // Formulación de Proyectos
    private Integer formulacionProyectos;
    private String formulacionProyectosNivel;
    
    // Pensamiento Científico
    private Integer pensamientoCientifico;
    private String pensamientoCientificoNivel;
    
    // Diseño de Software
    private Integer disenoSoftware;
    private String disenoSoftwareNivel;
    
    // Campo para beneficios (no persistido en BD)
    @Transient
    private String beneficio;

    // Constructor vacío (requerido por JPA)
    public Estudiante() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public Integer getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public String getNivelTotal() {
        return nivelTotal;
    }

    public void setNivelTotal(String nivelTotal) {
        this.nivelTotal = nivelTotal;
    }

    public Integer getComunicacionEscrita() {
        return comunicacionEscrita;
    }

    public void setComunicacionEscrita(Integer comunicacionEscrita) {
        this.comunicacionEscrita = comunicacionEscrita;
    }

    public String getComunicacionEscritaNivel() {
        return comunicacionEscritaNivel;
    }

    public void setComunicacionEscritaNivel(String comunicacionEscritaNivel) {
        this.comunicacionEscritaNivel = comunicacionEscritaNivel;
    }

    public Integer getRazonamientoCuantitativo() {
        return razonamientoCuantitativo;
    }

    public void setRazonamientoCuantitativo(Integer razonamientoCuantitativo) {
        this.razonamientoCuantitativo = razonamientoCuantitativo;
    }

    public String getRazonamientoCuantitativoNivel() {
        return razonamientoCuantitativoNivel;
    }

    public void setRazonamientoCuantitativoNivel(String razonamientoCuantitativoNivel) {
        this.razonamientoCuantitativoNivel = razonamientoCuantitativoNivel;
    }

    public Integer getLecturaCritica() {
        return lecturaCritica;
    }

    public void setLecturaCritica(Integer lecturaCritica) {
        this.lecturaCritica = lecturaCritica;
    }

    public String getLecturaCriticaNivel() {
        return lecturaCriticaNivel;
    }

    public void setLecturaCriticaNivel(String lecturaCriticaNivel) {
        this.lecturaCriticaNivel = lecturaCriticaNivel;
    }

    public Integer getCompetenciasCiudadanas() {
        return competenciasCiudadanas;
    }

    public void setCompetenciasCiudadanas(Integer competenciasCiudadanas) {
        this.competenciasCiudadanas = competenciasCiudadanas;
    }

    public String getCompetenciasCiudadanasNivel() {
        return competenciasCiudadanasNivel;
    }

    public void setCompetenciasCiudadanasNivel(String competenciasCiudadanasNivel) {
        this.competenciasCiudadanasNivel = competenciasCiudadanasNivel;
    }

    public String getInglesNivel() {
        return inglesNivel;
    }

    public void setInglesNivel(String inglesNivel) {
        this.inglesNivel = inglesNivel;
    }

    public Integer getFormulacionProyectos() {
        return formulacionProyectos;
    }

    public void setFormulacionProyectos(Integer formulacionProyectos) {
        this.formulacionProyectos = formulacionProyectos;
    }

    public String getFormulacionProyectosNivel() {
        return formulacionProyectosNivel;
    }

    public void setFormulacionProyectosNivel(String formulacionProyectosNivel) {
        this.formulacionProyectosNivel = formulacionProyectosNivel;
    }

    public Integer getPensamientoCientifico() {
        return pensamientoCientifico;
    }

    public void setPensamientoCientifico(Integer pensamientoCientifico) {
        this.pensamientoCientifico = pensamientoCientifico;
    }

    public String getPensamientoCientificoNivel() {
        return pensamientoCientificoNivel;
    }

    public void setPensamientoCientificoNivel(String pensamientoCientificoNivel) {
        this.pensamientoCientificoNivel = pensamientoCientificoNivel;
    }

    public Integer getDisenoSoftware() {
        return disenoSoftware;
    }

    public void setDisenoSoftware(Integer disenoSoftware) {
        this.disenoSoftware = disenoSoftware;
    }

    public String getDisenoSoftwareNivel() {
        return disenoSoftwareNivel;
    }

    public void setDisenoSoftwareNivel(String disenoSoftwareNivel) {
        this.disenoSoftwareNivel = disenoSoftwareNivel;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", documento='" + documento + '\'' +
                ", primerNombre='" + primerNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", puntajeTotal=" + puntajeTotal +
                '}';
    }
}