package com.banco.practicantes.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_evaluaciones")
public class HistorialEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long practicanteId;
    private String analista;
    private String estadoAnterior;
    private String estadoNuevo;
    
    @Column(length = 1000)
    private String observacion;
    
    private LocalDateTime fechaEvaluacion = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPracticanteId() { return practicanteId; }
    public void setPracticanteId(Long practicanteId) { this.practicanteId = practicanteId; }
    public String getAnalista() { return analista; }
    public void setAnalista(String analista) { this.analista = analista; }
    public String getEstadoAnterior() { return estadoAnterior; }
    public void setEstadoAnterior(String estadoAnterior) { this.estadoAnterior = estadoAnterior; }
    public String getEstadoNuevo() { return estadoNuevo; }
    public void setEstadoNuevo(String estadoNuevo) { this.estadoNuevo = estadoNuevo; }
    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
    public LocalDateTime getFechaEvaluacion() { return fechaEvaluacion; }
    public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) { this.fechaEvaluacion = fechaEvaluacion; }
}
