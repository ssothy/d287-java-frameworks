package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

        if (partRepository.count() == 0) {
            InhousePart pinkBow = new InhousePart();
            pinkBow.setName("Pink Bow");
            pinkBow.setInv(15);
            pinkBow.setPrice(5.00);
            pinkBow.setId(1000);

            InhousePart whiteBow = new InhousePart();
            whiteBow.setName("White Bow");
            whiteBow.setInv(15);
            whiteBow.setPrice(5.00);
            whiteBow.setId(1001);

            InhousePart alohaDress = new InhousePart();
            alohaDress. setName("Aloha Dress");
            alohaDress.setInv(5);
            alohaDress.setPrice(10.00);
            alohaDress.setId(1002);

            InhousePart glitterDress = new InhousePart();
            glitterDress.setName("Glitter Dress");
            glitterDress.setInv(5);
            glitterDress.setPrice(11.00);
            glitterDress.setId(1003);

            InhousePart picnicDress = new InhousePart();
            picnicDress.setName("Picnic Dress");
            picnicDress.setInv(5);
            picnicDress.setPrice(10.00);
            picnicDress.setId(1004);

            partRepository.save(pinkBow);
            partRepository.save(whiteBow);
            partRepository.save(alohaDress);
            partRepository.save(glitterDress);
            partRepository.save(picnicDress);
        }

        if (productRepository.count() == 0) {
            Product brownBear = new Product("Brown Bear", 15.00, 20);
            Product whiteBear = new Product("White Bear", 15.00, 20);
            Product whiteBunny = new Product("White Bunny", 15.00, 20);
            Product pinkBunny = new Product("Pink Bunny", 15.00, 20);
            Product cat = new Product("Cat", 15.00, 20);

            productRepository.save(brownBear);
            productRepository.save(whiteBear);
            productRepository.save(whiteBunny);
            productRepository.save(pinkBunny);
            productRepository.save(cat);
        }


        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            System.out.println(part.getName() + " " + part.getCompanyName());
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
