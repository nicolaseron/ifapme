package be.ifapme.spring_batch.repositoty;

import be.ifapme.spring_batch.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
