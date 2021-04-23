package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
  private final List<Person> persons;

  public VizitkaController() {
    persons = Arrays.asList(
            new Person("Kristyna Shanelova", "Václavské náměstí 837/11", "11000 Praha 1", "kristyna@czechitas.cz", "+420800123456", "www.czechitas.cz", "Czechitas"),
            new Person("Pavla Shanelova", "Košinova 3105/18a", "61200 Brno", null, "+420800123456", "www.czechitas.cz", "Czechitas"),
            new Person("Daniela Shanelova", "Václavské náměstí 837/11", "11000 Praha 1", "daniela@czechitas.cz", null, "www.czechitas.cz", "Czechitas"),
            new Person("Emilie Shanelova", "Václavské náměstí 837/11", "11000 Praha 1", "emilie@czechitas.cz", "+420800123456", null, "Czechitas")
    );
  }

  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("persons", persons);
    return modelAndView;
  }

  @GetMapping("/detail")
  public ModelAndView detail(int id) {
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("person", persons.get(id));
    return modelAndView;
  }
}
