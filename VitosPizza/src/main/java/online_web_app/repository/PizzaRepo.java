package online_web_app.repository;

import online_web_app.model.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends MongoRepository<Pizza, String> {

}
