package com.college.event.repository;

import com.college.event.model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration, String> {
    List<Registration> findByStudentId(String studentId);
    List<Registration> findByEventId(String eventId);
    Optional<Registration> findByStudentIdAndEventId(String studentId, String eventId);
    long countByEventId(String eventId);
}
