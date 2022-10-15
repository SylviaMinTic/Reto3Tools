package com.example.demo.repositorio;

import com.example.demo.repositorio.CrudRepository.ToolCrudRepository;
import com.example.demo.modelo.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ToolRepository {
    @Autowired
    private ToolCrudRepository toolCrudRepository;

    public List<Tool> getAll(){

        return (List<Tool>) toolCrudRepository.findAll();
    }
    public Optional<Tool> getTool(int id){

        return toolCrudRepository.findById(id);
    }
    public Tool save(Tool tool){

        return toolCrudRepository.save(tool);
    }
    public void delete (Tool tool){

        toolCrudRepository.delete(tool);
    }
}
