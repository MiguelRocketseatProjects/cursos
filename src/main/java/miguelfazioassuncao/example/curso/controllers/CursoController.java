package miguelfazioassuncao.example.curso.controllers;

import miguelfazioassuncao.example.curso.entities.Curso;
import miguelfazioassuncao.example.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.save(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable UUID id, @RequestBody Curso curso_body) {
        return cursoService.findById(id).map(curso -> {
            if (curso_body.getName() != null) {
                curso.setName(curso_body.getName());
            }

            if (curso_body.getCategory() != null) {
                curso.setCategory(curso_body.getCategory());
            }

            return ResponseEntity.ok(cursoService.save(curso));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return cursoService.findById(id).map(curso -> {
            cursoService.delete(curso.getId());
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Curso> toggleActivate(@PathVariable UUID id) {
        return cursoService.findById(id).map(curso -> {
            curso.setActive(!curso.getActive());
            return ResponseEntity.ok(cursoService.save(curso));
        }).orElse(ResponseEntity.notFound().build());
    }
}
