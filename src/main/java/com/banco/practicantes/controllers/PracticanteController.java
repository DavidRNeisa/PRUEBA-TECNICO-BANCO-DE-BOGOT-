package com.banco.practicantes.controllers;

import com.banco.practicantes.models.Practicante;
import com.banco.practicantes.services.PracticanteService;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.util.*;

@Controller
public class PracticanteController {
    
    private final PracticanteService service;
    
    public PracticanteController(PracticanteService service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/registro")
    public String formulario() {
        return "registro";
    }
    
    @PostMapping("/api/practicantes")
    public String registrar(@ModelAttribute Practicante p,
                           @RequestParam("pdf") MultipartFile pdf,
                           Model model) {
        try {
            service.registrar(p, pdf);
            model.addAttribute("mensaje", "Registro exitoso");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "registro";
    }
    
    @GetMapping("/analista")
    public String panelAnalista(Model model) {
        model.addAttribute("practicantes", service.listarTodos());
        return "analista";
    }
    
    @PostMapping("/api/practicantes/{id}/evaluar")
    public String evaluar(@PathVariable Long id,
                         @RequestParam String estado,
                         @RequestParam(required = false) String comentarios) {
        service.evaluar(id, estado, comentarios);
        return "redirect:/analista";
    }
    
    @GetMapping("/api/practicantes/{id}/pdf")
    @ResponseBody
    public ResponseEntity<Resource> descargarPdf(@PathVariable Long id) {
        Optional<Practicante> opt = service.buscarPorId(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        try {
            Path ruta = Paths.get("uploads", opt.get().getRutaPdf());
            Resource recurso = new UrlResource(ruta.toUri());
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .body(recurso);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
