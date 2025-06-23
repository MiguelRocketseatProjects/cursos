package miguelfazioassuncao.example.curso.service;

import miguelfazioassuncao.example.curso.entities.Curso;
import miguelfazioassuncao.example.curso.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(UUID id) {
        return cursoRepository.findById(id);
    }

    public void delete(UUID id) {
        cursoRepository.deleteById(id);
    }
}
