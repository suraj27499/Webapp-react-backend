package com.example.suraj;

import org.springframework.data.jpa.repository.*;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	@Query(value="select * from customer where id = ?1", nativeQuery = true)
	CustomerEntity getById(Long id);
	
	@Query(value="select * from customer where email_id = ?1 and password = ?2", nativeQuery = true)
	CustomerEntity findByUserNameAndPassword(String email,String password);
}
