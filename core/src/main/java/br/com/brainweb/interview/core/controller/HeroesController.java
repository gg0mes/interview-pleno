package br.com.brainweb.interview.core.controller;

import br.com.brainweb.interview.core.model.Heroes;
import br.com.brainweb.interview.core.service.HeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroesController {

    @Autowired
    HeroesService heroesService;

    @GetMapping("/hero")
    private List<Heroes> getAllHeroes()
    {
        return heroesService.getAllHeroes();
    }

    @GetMapping("/hero/{heroUuid}")
    private Heroes getHeroesByUuid(@PathVariable("heroUuid") String heroUuid)
    {
        return heroesService.findHeroByUuid(heroUuid);
    }

    @GetMapping("/hero/{name}")
    private Heroes getHeroesByName(@PathVariable("name") String name)
    {
        return heroesService.findHeroByName(name);
    }

    @DeleteMapping("/hero/{heroUuid}")
    private void deleteHero(@PathVariable("heroUuid") String heroUuid)
    {
        heroesService.delete(heroUuid);
    }

    @PutMapping("/heroes")
    private Heroes updateHero(@RequestBody Heroes heroes)
    {
        heroesService.updateHeroes(heroes);
        return heroes;
    }

    @PostMapping("/heroes")
    private String saveHero(@RequestBody Heroes heroes)
    {
        heroesService.saveHeroes(heroes);
        return heroes.getUuid();
    }

}
