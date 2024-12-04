package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.model.Task; // Certifique-se de que a classe Task está importada corretamente

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
}
