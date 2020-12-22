package io.codekaffee.ciclosdepagamento.repositories;

import io.codekaffee.ciclosdepagamento.models.Debit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitRepository extends MongoRepository<Debit, String> {
}
