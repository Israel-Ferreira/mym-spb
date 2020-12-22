package io.codekaffee.ciclosdepagamento.repositories;

import io.codekaffee.ciclosdepagamento.models.BillingCycle;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingCycleRepository extends MongoRepository<BillingCycle, ObjectId> {
}
