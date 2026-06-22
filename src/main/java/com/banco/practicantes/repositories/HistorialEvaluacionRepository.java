package com.banco.practicantes.repositories;

import com.banco.practicantes.models.HistorialEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistorialEvaluacionRepository extends JpaRepository<HistorialEvaluacion, Long> {
    List<HistorialEvaluacion> findByPracticanteIdOrderByFechaEvaluacionDesc(Long practicanteId);
}
