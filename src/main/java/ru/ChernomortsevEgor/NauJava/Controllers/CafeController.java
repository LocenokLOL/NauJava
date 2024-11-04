package ru.ChernomortsevEgor.NauJava.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Cafe;
import ru.ChernomortsevEgor.NauJava.repository.CafeRepository;

import java.util.List;

@RestController
@RequestMapping("/custom/cafes")
public class CafeController {
    @Autowired
    private final CafeRepository cafeRepository;

    @Autowired
    public CafeController(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @GetMapping("findByName")
    public List<Cafe> findByName(@RequestParam String name)
    {
        return cafeRepository.findByName(name);
    }
}
