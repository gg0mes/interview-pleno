package br.com.brainweb.interview.core.service;

import br.com.brainweb.interview.core.model.Heroes;
import br.com.brainweb.interview.core.repository.HeroesRepository;
import exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroesService {

    @Autowired
    HeroesRepository heroesRepository;

    public List<Heroes> getAllHeroes() {

        List<Heroes> heroes = new ArrayList<Heroes>();
        heroesRepository.findAll().forEach(heroesLambda -> heroes.add((Heroes) heroesLambda));
        return heroes;
    }

    public Heroes findHeroByUuid(String heroUuid) {
        return (Heroes) this.heroesRepository.findHeroByUuid(heroUuid).orElseThrow(() -> new EntityNotFoundException(String.format("Hero not found: %s", heroUuid)));
    }

    public Heroes findHeroByName(String name) {
        return (Heroes) this.heroesRepository.findHeroByName(name).orElseThrow(() -> new EntityNotFoundException(String.format("Hero not found: %s", name)));
    }

    public void delete(String heroUuid) {
        heroesRepository.delete(heroUuid).orElseThrow(() -> new EntityNotFoundException(String.format("Hero could be not deleted: %s", heroUuid)));
    }

    public void updateHeroes(Heroes heroes) {
        heroesRepository.save(heroes);
    }

    public void saveHeroes(Heroes heroes) {
    }


}
