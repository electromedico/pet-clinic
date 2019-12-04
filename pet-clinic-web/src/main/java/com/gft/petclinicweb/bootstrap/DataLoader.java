package com.gft.petclinicweb.bootstrap;

        import com.gft.petclinicdata.model.Owner;
        import com.gft.petclinicdata.model.Pet;
        import com.gft.petclinicdata.model.PetType;
        import com.gft.petclinicdata.model.Vet;
        import com.gft.petclinicdata.services.OwnerService;
        import com.gft.petclinicdata.services.PetService;
        import com.gft.petclinicdata.services.PetTypeService;
        import com.gft.petclinicdata.services.VetService;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.stereotype.Component;

        import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

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


        Vet vet = new Vet();
        vet.setFirstName("Foo");
        vet.setLastName("bar");

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("Vet");

        vetService.save(vet);
        vetService.save(vet2);



    }
}
