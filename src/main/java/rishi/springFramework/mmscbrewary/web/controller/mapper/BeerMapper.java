package rishi.springFramework.mmscbrewary.web.controller.mapper;

import org.mapstruct.Mapper;
import rishi.springFramework.mmscbrewary.domain.Beer;
import rishi.springFramework.mmscbrewary.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
