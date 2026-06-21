package com.banco.practicantes.services;

import com.banco.practicantes.models.Practicante;
import com.banco.practicantes.repositories.PracticanteRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PracticanteService {
    
    private final PracticanteRepository repository;
    
    @Value("${file.upload-dir}")
    private String uploadDir;
    
    public PracticanteService(PracticanteRepository repository) {
        this.repository = repository;
    }
    
    public Practicante registrar(Practicante p, MultipartFile pdf) throws IOException {
        if (repository.existsByCorreoElectronico(p.getCorreoElectronico())) {
            throw new RuntimeException("El correo ya está registrado");
        }
        String nombreArchivo = System.currentTimeMillis() + "_" + pdf.getOriginalFilename();
        Path ruta = Paths.get(uploadDir, nombreArchivo);
        Files.copy(pdf.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
        p.setRutaPdf(nombreArchivo);
        p.setEstado("Pendiente");
        p.setFechaRegistro(java.time.LocalDateTime.now());
        return repository.save(p);
    }
    
    public List<Practicante> listarTodos() {
        return repository.findAll();
    }
    
    public List<Practicante> buscarConFiltros(String nombre, String correo, String carrera, 
                                               Integer semestre, String estado) {
        List<Practicante> todos = repository.findAll();
        
        return todos.stream()
            .filter(p -> nombre == null || nombre.isEmpty() || 
                    p.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase()))
            .filter(p -> correo == null || correo.isEmpty() || 
                    p.getCorreoElectronico().toLowerCase().contains(correo.toLowerCase()))
            .filter(p -> carrera == null || carrera.isEmpty() || 
                    p.getCarrera().toLowerCase().contains(carrera.toLowerCase()))
            .filter(p -> semestre == null || p.getSemestre().equals(semestre))
            .filter(p -> estado == null || estado.isEmpty() || p.getEstado().equals(estado))
            .collect(Collectors.toList());
    }
    
    public Optional<Practicante> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    public Practicante evaluar(Long id, String estado, String comentarios) {
        Practicante p = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Practicante no encontrado"));
        p.setEstado(estado);
        p.setComentarios(comentarios);
        return repository.save(p);
    }
}
