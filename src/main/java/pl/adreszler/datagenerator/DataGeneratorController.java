package pl.adreszler.datagenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
class DataGeneratorController {

    private DataGeneratorService dataGeneratorService;

    public DataGeneratorController(DataGeneratorService dataGeneratorService) {
        this.dataGeneratorService = dataGeneratorService;
    }

    @PostMapping("/generate")
    String generateData(@RequestParam(required = false) int entries,
                        @RequestParam(required = false) String language,
                        @RequestParam(required = false) boolean firstName,
                        @RequestParam(required = false) boolean lastName,
                        @RequestParam(required = false) boolean university,
                        @RequestParam(required = false) boolean country,
                        Model model) {
        Map<String, List<String>> data = dataGeneratorService.getDataMap(entries, language, firstName, lastName,
                university, country);
        model.addAttribute("data", data);
        model.addAttribute("entries", entries);

        return "generated-data";
    }
}