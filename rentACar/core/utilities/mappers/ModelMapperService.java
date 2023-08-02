package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;

public interface ModelMapperService {
    ModelMapper forResponse();

    ModelMapper forRequest();
}
