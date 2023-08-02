package kodlama.io.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentACarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}//http://localhost:8080/swagger-ui/index.html

