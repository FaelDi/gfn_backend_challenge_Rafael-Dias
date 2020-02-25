package com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.repository;


import com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, String> {
}

