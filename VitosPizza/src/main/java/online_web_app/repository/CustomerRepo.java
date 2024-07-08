package online_web_app.repository;

import online_web_app.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer, Integer> {

}
