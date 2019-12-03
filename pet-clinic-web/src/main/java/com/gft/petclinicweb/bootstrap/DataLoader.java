package com.gft.petclinicweb.bootstrap;

        import com.gft.petclinicdata.model.Owner;
        import com.gft.petclinicdata.model.Vet;
        import com.gft.petclinicdata.services.OwnerService;
        import com.gft.petclinicdata.services.VetService;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setFirstName("toto");
        owner.setLastName("lopez");
        owner.setId(1L);

        Owner owner2 = new Owner();
        owner2.setFirstName("titi");
        owner2.setLastName("Titi");
        owner2.setId(2L);

        ownerService.save(owner);
        ownerService.save(owner2);

        Vet vet = new Vet();
        vet.setFirstName("Foo");
        vet.setLastName("bar");
        vet.setId(1L);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet");
        vet2.setLastName("Vet");
        vet2.setId(2L);

        vetService.save(vet);
        vetService.save(vet2);



    }
}
