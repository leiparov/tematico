package controllers;

import models.daos.DAOException;
import models.entities.*;
import models.services.UsuarioService;
import models.services.impl.UsuarioServiceImpl;
import play.Routes;
import play.mvc.*;
import play.data.*;
import views.html.*;
import utils.Login;

public class Application extends Controller {

    private static UsuarioService usuarioService = new UsuarioServiceImpl();

    @Login.Requiere
    public static Result index() {
        Login login = Login.obtener(ctx());
        return ok(index.render());
        /*if (login.isTipo(Usuario.class)) {
            return ok(index.render());
        } else {
            return noContent();
        }*/
    }

    public static Result interfazLogin() {
        return ok(login.render());
    }
    

    public static Result logout() {
        Login.obtener(ctx()).deslogearSesion();
        return redirect(routes.Application.interfazLogin());
    }

    public static Result autenticar() {
        try {
            Form<Login.Form> loginForm = Form.form(Login.Form.class).bindFromRequest();
            Usuario logueado = usuarioService.obtenerLogin(loginForm.get().email, loginForm.get().password);
            Login.obtener(ctx()).logearSesion(logueado);
            return redirect(routes.Application.index());
        } catch (DAOException.FalloLoginException e) {
            flash("error", "Usuario o contraseña incorrecta");
            return badRequest(login.render());
        }
    }
    
    public static Result recuperarContrasenia() {
    	Form<contraseniaForm> popupForm = Form.form(contraseniaForm.class).bindFromRequest();
    	String email = popupForm.get().emailRecuperar;
    	if(email != ""){
    		if(usuarioService.obtener(email) != 0){
    			usuarioService.recuperarContrasenia(email);
    			flash("successRecuperar", "Su nueva contraseña ha sido enviada a su correo.");
    		}
    		else
    			flash("errorRecuperar", "El correo ingresado no pertenece a un usuario.");
    	}
    	else{
    		flash("errorRecuperar", "No ha ingresado su correo para recuperar su contraseña.");
    	}
        return ok(login.render());
    }
    
    public static Result jsRoutes(){
        response().setContentType("text/javascript");
        return ok(Routes.javascriptRouter("jsRoutes"                    
                ));
    }
    
  //clases estaticas para los formularios
    public static class contraseniaForm{
        public String emailRecuperar; 
    }
 
}
