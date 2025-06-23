package miguelfazioassuncao.example.curso.repositories;

import miguelfazioassuncao.example.curso.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
}
