package learn.springboot.mongodb.api;


import learn.springboot.mongodb.entity.Wrestler;
import learn.springboot.mongodb.repository.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//Skipped "Service Class". Using only "Repository Class"

@RestController
public class WrestlerController {
    @Autowired
    private WrestlerRepository wrestlerRepository;

    @GetMapping("/wrestlers")
    public List<Wrestler> getWrestlers(){
        return wrestlerRepository.findAll();
    }

    @GetMapping("/wrestler/{id}")
    public Wrestler getWrestler(@PathVariable (name = "id") String id) throws Exception {
        Optional<Wrestler> wrestler = wrestlerRepository.findById(id);
        wrestler.orElseThrow(()->new Exception("Wrestler not found..."));

        return wrestler.get();
    }
    /*
    @GetMapping("/wrestler")
    public Wrestler getWrestler(@RequestParam(name = "id") String id) throws Exception {
        Optional<Wrestler> wrestler = wrestlerRepository.findById(id);
        wrestler.orElseThrow(()->new Exception("Wrestler not found..."));

        return wrestler.get();
    }
    */
}
