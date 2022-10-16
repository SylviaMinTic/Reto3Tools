package com.example.demo.servicio;

import com.example.demo.modelo.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositorio.ToolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll(){
        return toolRepository.getAll();
    }
    public Optional<Tool> getTool(int id){
        return toolRepository.getTool(id);
    }
    public Tool save (Tool tool){
        if (validarCampos(tool)){
            if(tool.getId()==null){
                return toolRepository.save(tool);
            }else{
                Optional<Tool> toolEncontrado = getTool(tool.getId());
                if(toolEncontrado.isEmpty()){
                    return toolRepository.save(tool);
                }else{
                    return tool;
                }
            }
        }
        return tool;
    }
    public Tool update (Tool tool){
        if (validarCampos(tool)){
            if(tool.getId() !=null){
                Optional<Tool> toolEncontrado = getTool(tool.getId());
                if (!toolEncontrado.isEmpty()){
                    if(tool.getName()!=null){
                        toolEncontrado.get().setName(tool.getName());
                    }
                    if(tool.getBrand()!=null){
                        toolEncontrado.get().setBrand(tool.getBrand());
                    }
                    if(tool.getYear()!=null){
                        toolEncontrado.get().setYear(tool.getYear());
                    }
                    if(tool.getDescription()!=null){
                        toolEncontrado.get().setDescription(tool.getDescription());
                    }
                    if(tool.getCategory()!=null){
                        toolEncontrado.get().setCategory(tool.getCategory());
                    }
                    return toolRepository.save(toolEncontrado.get());
                }

            }
            return tool;
        }
        return tool;
    }
    public boolean delete(int id){
        Boolean respuesta = getTool(id).map(elemento ->{
            toolRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
    public boolean validarCampos(Tool tool){
        return (tool.getBrand().length() <=45 && tool.getName().length()<= 45 &&
                String.valueOf(tool.getYear()).length()==4 && tool.getDescription().length()<=250);
    }
}
