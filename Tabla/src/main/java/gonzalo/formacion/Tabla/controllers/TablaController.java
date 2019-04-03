package gonzalo.formacion.Tabla.controllers;



import gonzalo.formacion.Tabla.model.Usuario;
import gonzalo.formacion.Tabla.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TablaController {

    private static final Logger log = LoggerFactory.getLogger(TablaController.class);



    @Autowired
    private UsuarioRepository usersData;


    //MOSTRAR
    @GetMapping("/mostrar")
    public String userMostrar(Model model) {


        model.addAttribute("Users",usersData.findAll());


        return "principal";
    }
    //BORRAR
    @GetMapping("/borrar/{id}")
    public String userDelete(@PathVariable("id") int id) {

        usersData.deleteById(id);


        return "redirect:/mostrar";
    }

    //MODIFICAR
    @GetMapping("/modificar/{id}")
    public String greetingForm(Model model) {
        model.addAttribute("usuarioAModificar", new Usuario());


        return "modificarUsuario";
    }

    @PostMapping("/modificar")
    public String userUpdate(@ModelAttribute Usuario usuario ) {


        usersData.save(usuario);

        return "modificarUsuario";
    }


    /*
    //No hecho
        @PostMapping("/greeting")
        public String greetingSubmit(@ModelAttribute Usuario users) {

            //    log.info(greeting.getContent() + greeting.getId());

            usersData.save(users);
            return "result";
        }

        @GetMapping("/borrar/{id}")
        public String borrar (@PathVariable("id") Integer id) {

            //    log.info(greeting.getContent() + greeting.getId());
            Optional<Usuario> objectDel = usersData.findById(id);

            // el redirect sirve para redirigir a otro metodo de un controlador
            return "redirect:/greeting";
        }

        */

    }
