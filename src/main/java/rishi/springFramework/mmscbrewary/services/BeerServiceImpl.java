package rishi.springFramework.mmscbrewary.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rishi.springFramework.mmscbrewary.model.BeerDto;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Budwiser")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // impl
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer");
    }
}
