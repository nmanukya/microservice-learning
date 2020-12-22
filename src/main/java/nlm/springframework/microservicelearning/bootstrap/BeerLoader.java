package nlm.springframework.microservicelearning.bootstrap;

import nlm.springframework.microservicelearning.domain.Beer;
import nlm.springframework.microservicelearning.repositories.BeerRepository;
import nlm.springframework.microservicelearning.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;

    public BeerLoader (BeerRepository beerRepository){
        this.beerRepository=beerRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }
    private void loadBeerObjects(){
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                    .beerName("Lefe")
                    .beerStyle(BeerStyleEnum.IPA.name())
                    .minOnHand(8)
                    .quantityToBrew(100)
                    .price(new BigDecimal("13.95"))
                    .upc("0631234200026")
                    .build()); 
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyleEnum.PILSNER.name())
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.95"))
                    .upc("0631234200036")
                    .build());
        }
        //System.out.println("Number of objects in repository = " +beerRepository.count());
    }
}
