package uz.uzrailways.repository;

import uz.uzrailways.domain.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo , Long>
{
    @Query("SELECT p.fileUrl FROM photo p WHERE p.id = :id")
    Optional<String> findFileUrlById(@Param("id") Long id);
}
