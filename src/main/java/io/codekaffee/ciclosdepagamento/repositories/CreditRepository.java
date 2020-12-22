package io.codekaffee.ciclosdepagamento.repositories;

import io.codekaffee.ciclosdepagamento.models.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends MongoRepository<Credit, String> {
}
