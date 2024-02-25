package com.liveasy.Repository;

import com.liveasy.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoadRepo extends JpaRepository<Load,Integer> {
    Optional<Load>findById(Integer loadId);

}
