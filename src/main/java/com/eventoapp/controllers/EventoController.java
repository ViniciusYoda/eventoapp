package com.eventoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String mostrarFormulario() {
        return "evento/formEvento"; 
    }

    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String salvarEvento(Evento evento) {
        er.save(evento);
        return "redirect:/cadastrarEvento"; 
    }

    // @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    // public String salvarEvento(@Valid Evento evento, BindingResult result) {
    // if (result.hasErrors()) {
    //     return "evento/formEvento"; // Retorna ao formulário em caso de erro
    // }
    // er.save(evento);
    // return "redirect:/cadastrarEvento";
}

}
