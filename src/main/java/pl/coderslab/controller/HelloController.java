package pl.coderslab.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;


@Controller
@RequestMapping(produces = "text/html; charset = UTF-8")
public class HelloController {

    @GetMapping("/workers")
    public String workersAction(Model m) throws IOException {
        Random random = new Random();
        final int n = random.nextInt(30) + 1;
        String nAsString = Integer.toString(n);

        if (n<10){
            nAsString = "0" + nAsString;
        }

        Resource resource = new ClassPathResource("Workers.txt");
        InputStream input = resource.getInputStream();
        File file = resource.getFile();

        List<String> workers = new ArrayList<>();

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            String worker = scan.nextLine();
            workers.add(worker);
        }

        String finalNAsString = nAsString;
        List<String> s = workers.stream()
                .filter(e -> e.startsWith(finalNAsString))
                .collect(Collectors.toList());

        if (!s.isEmpty()) {
            m.addAttribute("workerNumber", "Znaleziono pracownika " + s + " o ID " + n);
        } else {
            m.addAttribute("workerNumber", "Nie ma pracownika o ID: " + n);
        }
        return "workers";
    }
}
