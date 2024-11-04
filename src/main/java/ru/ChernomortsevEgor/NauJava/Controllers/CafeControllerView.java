package ru.ChernomortsevEgor.NauJava.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ChernomortsevEgor.NauJava.PojoClasses.Cafe;
import ru.ChernomortsevEgor.NauJava.repository.CafeRepository;

import java.util.List;

@Controller
@RequestMapping("/custom/cafes/view")
public class CafeControllerView {
    @Autowired
    private final CafeRepository cafeRepository;

    @Autowired
    public CafeControllerView(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @GetMapping("/list")
    public String cafeListView(Model model)
    {
        Iterable<Cafe> cafes = cafeRepository.findAll();
        model.addAttribute("cafes", cafes);
        return "cafeList";
    }
}
