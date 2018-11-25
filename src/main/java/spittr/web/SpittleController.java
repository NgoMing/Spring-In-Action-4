package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(
            SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    // Model is a map
    // The default key is inferred from the type of object
    // For example: List<Spittle> -> spittleList
//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute(
//                spittleRepository.findRecentSpittles(20)
//        );
//        return "spittles";
//    }

    // Another way
    // Logical view name is inferred from the request path
    // For example: /spittles -> spittles
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles() {
//        return spittleRepository.findRecentSpittles(20);
//    }

    // Using query parameters
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam("max") long max,
            @RequestParam("count") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    // Using path parameters
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

}

