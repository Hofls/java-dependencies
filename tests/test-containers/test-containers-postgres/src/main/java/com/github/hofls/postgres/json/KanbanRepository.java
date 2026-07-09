package com.github.hofls.postgres.json;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KanbanRepository extends JpaRepository<KanbanCard, Long> {

}
