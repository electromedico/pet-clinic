package com.gft.petclinicweb.bootstrap;

        import com.gft.petclinicdata.model.Owner;
        import com.gft.petclinicdata.model.PetType;
        import com.gft.petclinicdata.model.Vet;
        import com.gft.petclinicdata.services.OwnerService;
        import com.gft.petclinicdata.services.PetTypeService;
        import com.gft.petclinicdata.services.VetService;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.stereotype.Component;

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

        PetType dog = new PetType();
        dog.setName("Dog");
        dog =petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat =petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("toto");
        owner.setLastName("lopez");

        Owner owner2 = new Owner();
        owner2.setFirstName("titi");
        owner2.setLastName("Titi");

        ownerService.save(owner);
        ownerService.save(owner2);

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
