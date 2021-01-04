package io.codekaffee.ciclosdepagamento.repositories;

import io.codekaffee.ciclosdepagamento.models.BillingCycle;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingCycleRepository extends MongoRepository<BillingCycle, String > {
    List<BillingCycle> findAllById(List<String> ids);
}
