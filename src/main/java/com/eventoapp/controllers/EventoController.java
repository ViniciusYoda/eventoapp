package com.eventoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;
import com.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cr;

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
// }

    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @RequestMapping(value="/[codigo]", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("detalhesEvento");
        mv.addObject("evento", evento);
        return mv;
    }

    @RequestMapping(value="/[codigo]", method=RequestMethod.POST)
    public String detalhesEventoPost(@PathVariable("codigo") long codigo, Convidado convidado){
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento);
        cr.save(convidado);
        return "redirect/{codigo}";
    }

}
