package kodlama.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
        //gevşek mapleme --> nesnemizd a,b,c,d,e elemanları var ama response nesnesinde a b c var
        //sadece a b c yi map le, diğerlerini map leme diyoruz
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
        //her şeyi mapleyebiliriz

    }
}
