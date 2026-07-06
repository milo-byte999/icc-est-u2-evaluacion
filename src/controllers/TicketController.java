package controllers;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import models.TicketSoporte;

public class TicketController {

  public Set<TicketSoporte> filtrarYOrdenarTickets(List<TicketSoporte> tickets, int prioridadMinima) {

    Set<TicketSoporte> ticketFiltrados = new TreeSet<>((t1, t2) -> {

      if (t1.getCodigo().equalsIgnoreCase(t2.getCodigo())) {
        return 0;
      }

      int comparacionPrioridad = Integer.compare(t2.getPrioridad(), t1.getPrioridad());
      if (comparacionPrioridad != 0)
        return comparacionPrioridad;

      return t1.getTecnico().compareTo(t2.getTecnico());
    });

    for (TicketSoporte t : tickets) {
      if (t.getPrioridad() >= prioridadMinima) {
        ticketFiltrados.add(t);
      }
    }

    for (TicketSoporte t : ticketFiltrados) {
      System.out.println(t);
    }
    return ticketFiltrados;
  }

  public Map<String, Set<String>> agruparCodigosPorPrioridad(List<TicketSoporte> tickets) {

    Map<String, Set<String>> grupos = new TreeMap<>();

    grupos.put("ALTA", new LinkedHashSet<>());
    grupos.put("MEDIA", new LinkedHashSet<>());
    grupos.put("BAJA", new LinkedHashSet<>());

    for (TicketSoporte t : tickets) {
      String categoria;
      if (t.getPrioridad() >= 4) {
        categoria = "ALTA";
      } else if (t.getPrioridad() >= 2 && t.getPrioridad() <= 3) {
        categoria = "MEDIA";
      } else {
        categoria = "BAJA";
      }

      Set<String> set = grupos.get(categoria);
      boolean existe = false;

      for (String n : set) {
        String codigoSet = n.split("-")[1];
        String codigoTicket = t.getCodigo().split("-")[1];
        if (codigoSet.equalsIgnoreCase(codigoTicket)) {
          existe = true;
          break;
        } else if(!existe){
          set.add(codigoTicket);
        }
      }
  }
    System.out.println(grupos);
    return grupos;
  }
}