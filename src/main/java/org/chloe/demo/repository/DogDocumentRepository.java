package org.chloe.demo.repository;

import org.chloe.demo.model.DogDocumentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogDocumentRepository extends JpaRepository<DogDocumentModel, Long> {

}
