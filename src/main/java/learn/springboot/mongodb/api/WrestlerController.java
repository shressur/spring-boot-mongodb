package learn.springboot.mongodb.api;


import learn.springboot.mongodb.entity.Wrestler;
import learn.springboot.mongodb.repository.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Skipped "Service Class". Using only "Repository Class"

@RestController
public class WrestlerController {
    @Autowired
    private WrestlerRepository wrestlerRepository;

    //CREATE
    @PostMapping("/new-wrestler")
    public Wrestler createWrestler(@RequestBody Wrestler wrestler){
        wrestlerRepository.insert(wrestler);
        return wrestler;
    }
    @PostMapping("/new-wrestler-many")
    public List<Wrestler> createWrestlerMany(@RequestBody List<Wrestler> wrestler){
        wrestlerRepository.insert(wrestler);
        return wrestler;
    }

    //READ
    @GetMapping("/view-wrestlers")
    public List<Wrestler> getWrestlers(){
        return wrestlerRepository.findAll();
    }

    /*
    @GetMapping("/view-wrestler/{id}")
    public Wrestler getWrestler(@PathVariable (name = "id") String id) throws Exception {
        Optional<Wrestler> wrestler = wrestlerRepository.findById(id);
        wrestler.orElseThrow(()->new Exception("Wrestler not found..."));

        return wrestler.get();
    }
    */

    @GetMapping("/view-wrestler")
    public Wrestler getWrestler(@RequestParam(value = "id") String id) throws Exception {
        Optional<Wrestler> wrestler = wrestlerRepository.findById(id);
        wrestler.orElseThrow(()->new Exception("Wrestler not found..."));

        return wrestler.get();
    }

    //UPDATE
    @PutMapping("/update-wrestler")
    public Wrestler updateWrestler(@RequestBody Wrestler wrestler) throws Exception {
        Optional<Wrestler> wrestlerInDB = wrestlerRepository.findById(wrestler.getId());
        wrestlerInDB.orElseThrow(()->new Exception("Wrestler not found..."));

        wrestlerInDB.get().setName(wrestler.getName());
        wrestlerInDB.get().setFinisher(wrestler.getFinisher());
        wrestlerInDB.get().setGender(wrestler.getGender());
        wrestlerInDB.get().setActive(wrestler.isActive());

        wrestlerRepository.save(wrestlerInDB.get());

        return wrestlerInDB.get();

    }

    //DELETE
    @DeleteMapping("/delete-wrestler")
    public void deleteWrestler(@RequestParam (value = "id") String id){
        wrestlerRepository.deleteById(id);

        System.out.println("Wrestler with id: " + id + " was deleted.");
    }
}
