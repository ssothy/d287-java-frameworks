package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if(context==null) return true;
        if(context!=null)myContext=context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);
        PartService partRepo = myContext.getBean(PartServiceImpl.class);
        if (product.getId() != 0) {
            Product myProduct = repo.findById((long) product.getId()); //existing product
            if (product.getInv() <= myProduct.getInv()) {
                return false; //Validation fails if new inventory is less than old inventory
            }
            for (Part p : myProduct.getParts()) {
                // Calculate the change in inventory for each associated part
                int inventoryChange = (product.getInv() - 1) - myProduct.getInv();
                int newPartInventory = p.getInv() - inventoryChange;
                if (newPartInventory <= p.getMin()) {
                    return false; // Validation fails if part's inventory would go below the minimum
                }
                // Update the part's inventory
                p.setInv(newPartInventory);
                partRepo.save(p); // Save the updated part
            }
        }
        return true; // Validation passes if no associated part's inventory would go below the minimum
    }
}


