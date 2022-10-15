package com.example.demo.Controller;

import com.example.demo.modelo.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.servicio.ToolService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Tool")
public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getAll(){
        return toolService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Tool> getTool(@PathVariable("id") int id) {

        return toolService.getTool(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save (@RequestBody Tool tool) {
        return toolService.save(tool);
    }

}
