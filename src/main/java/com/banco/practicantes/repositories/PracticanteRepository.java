package com.banco.practicantes.repositories;

import com.banco.practicantes.models.Practicante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PracticanteRepository extends JpaRepository<Practicante, Long> {
    List<Practicante> findByEstado(String estado);
    List<Practicante> findByCarreraContainingIgnoreCase(String carrera);
    boolean existsByCorreoElectronico(String correo);
    List<Practicante> findByNombreCompletoContainingIgnoreCase(String nombre);
    List<Practicante> findByCorreoElectronicoContainingIgnoreCase(String correo);
    List<Practicante> findBySemestre(Integer semestre);
}
