package com.bertolazzoilhas.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bertolazzoilhas.model.Compras;

@Repository
public interface ComprasRepository extends JpaRepository <Compras, Long> {

}
