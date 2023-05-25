package kz.techboot.Sprint_task_61.repository;

import kz.techboot.Sprint_task_61.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
    List<ApplicationRequest> findAllByHandledIsFalse();
    List<ApplicationRequest> findAllByHandledIsTrue();


    @Query(value = "SELECT a FROM ApplicationRequest a ORDER BY a.handled ")
    List<ApplicationRequest>  getAllOrderByHandle();
}
