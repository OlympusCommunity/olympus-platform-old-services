package com.olympus.platform.repository;

import com.olympus.platform.entity.RepresentativeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepresentativeRepository extends JpaRepository<RepresentativeEntity, Long>  {

    @Query(
            "SELECT w FROM RepresentativeEntity w WHERE w.representativeId IN (1, 2, 3, 4) ORDER BY w.representativeId")
    List<RepresentativeEntity> findFirstFourById();

}
