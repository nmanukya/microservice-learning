package nlm.springframework.microservicelearning.web.mappers;

import nlm.springframework.microservicelearning.domain.Beer;
import nlm.springframework.microservicelearning.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * microservice-learning
 * Created by nmanu on 20/01/2021
 **/
@Mapper(uses = DateMapper.class)

public interface BeerMapper {
    BeerDto BeerToBeerDtop(Beer beer);
    Beer BeerDtoToBeer(BeerDto dto);
}
