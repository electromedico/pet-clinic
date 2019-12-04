package com.gft.petclinicweb.bootstrap;

        import com.gft.petclinicdata.model.*;
        import com.gft.petclinicdata.services.*;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.stereotype.Component;

        import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VetSpecialtyService vetSpecialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, VetSpecialtyService vetSpecialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.vetSpecialtyService = vetSpecialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count ==0){
            loadData();
        }
    }

    private void loadData() {
        PetType dogType = new PetType();
        dogType.setName("Dog");
        dogType =petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("Cat");
        catType =petTypeService.save(catType);


        Owner owner = new Owner();
        owner.setFirstName("toto");
        owner.setLastName("lopez");
        owner.setAddress("here");
        owner.setCity("quebec");
        owner.setTelephone("123456789");

        Pet dog = new Pet();
        dog.setName("happy");
        dog.setPetType(dogType);
        dog.setBirthday( LocalDate.of(2017,10,10));
        dog.setOwner(owner);
        owner.getPets().add(dog);

        Owner owner2 = new Owner();
        owner2.setFirstName("titi");
        owner2.setLastName("Titi");
        owner2.setAddress("not here");
        owner2.setCity("quebec");
        owner2.setTelephone("123456789");

        Pet cat = new Pet();
        cat.setName("Cat");
        cat.setPetType(catType);
        cat.setBirthday( LocalDate.of(2019,10,10));
        cat.setOwner(owner2);
        owner2.getPets().add(cat);

        owner = ownerService.save(owner);
        owner2 = ownerService.save(owner2);


        VetSpecialty radSpecialty = new VetSpecialty();
        radSpecialty.setDescription("radiology");

        VetSpecialty generalSpecialty = new VetSpecialty();
        generalSpecialty.setDescription("General");

        //radSpecialty = vetSpecialtyService.save(radSpecialty);
        //generalSpecialty = vetSpecialtyService.save(generalSpecialty);

        Vet vet = new Vet();
        vet.setFirstName("Foo");
        vet.setLastName("bar");
        vet.getSpecialties().add(radSpecialty);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("Vet");
        vet2.getSpecialties().add(generalSpecialty);

        vetService.save(vet);
        vetService.save(vet2);
    }
}
