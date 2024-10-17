package org.trueFanBoutique.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trueFanBoutique.model.Ordenes;



@Repository
public interface OrderRepository extends JpaRepository<Ordenes, Long>{
	 
}
