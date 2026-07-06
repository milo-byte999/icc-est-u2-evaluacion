# Evaluación de Set y Map
## Nombre: Emilio Montaleza

## Método A: filtrarYOrdenarTickets
Implementación utilizada: Utilice el método public Set<TicketSoporte> filtrarYOrdenarTickets(List<TicketSoporte> tickets, int prioridadMinima) y lo instancie en 
un TreeSet Set<TicketSoporte> ticketFiltrados = new TreeSet<>((t1, t2) -> {});
Explicación: 
Lo que hace este es compara entre 2 t1 y t2 donde si el codigo del ticket 1 y el ticket 2 son iguales retorna cero para indicar que son el mismo
luego compare entre ambos su prioridad usando un Integer.compare para determinar cual era mayor y si era diferente de cero que indica que son iguales 
envia la prioridad mayor y si estos son iguales ocupe el compareTo entre estos pero ahora agarramos el Tecnico del codigo ya que su prioridad son iguales 
entonces agarramos su nombre y lo ordenamos alfabéticamente.

## Método B: agruparCodigosPorPrioridad
Implementación utilizada para el Map:Para el map ocupamos Map<String, Set<String>> grupos = new TreeMap<>(); un TreeMap para guardar en orden de llegada
Implementación utilizada para los set internos: para el set interno obtiene la categoria de los grupos
Explicación:
Primero creamos una LinkedHashSet para guardar en un grupo los tickets dentro de una categoria, posteriormente en un bucle agarramos la prioridad de cada uno y si es mayor a 4 su prioridad es alta asi con los demas, luego dentro del set guardamos la categoria dentro de un grupo y en un for si ya existe este codigo cierra el bucle sino lo añade al set, posteriormente mostramos todos los grupos y volvemos al main.
