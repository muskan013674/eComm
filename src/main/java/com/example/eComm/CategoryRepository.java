package com.example.eComm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    @Query("SELECT C FROM  Category C where C.Cid = ?1")
    public Category findById(int id);
}
