package com.example.frank.jpa;
import com.example.frank.jpa.model.UserMaxGamesPlayedJPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends CrudRepository<UserMaxGamesPlayedJPA, Integer> {
//User who has played max number of games in last 7 days.
UserMaxGamesPlayedJPA findByUuid(String uuid);



}