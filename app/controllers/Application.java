package controllers;

import static play.data.Form.form;
import models.entities.Usuario;
import play.data.*;
import play.Routes;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

public class Application extends Controller {

    @Security.Authenticated(Secured.class)
    public static Result index() {        
        return ok(index.render(Usuario.find.byId(request().username())));
    }

    public static Result login() {
		return ok(login.render(form(Login.class)));
	}    

    public static Result logout() {
    	session().clear();
		flash("success", "You've been logged out");
		return redirect(routes.Application.login());
    }

    public static Result authenticate() {
		Form<Login> loginForm = form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().email);
			return redirect(routes.Application.index());
		}
	}
    
    public static class Login {

		public String email;
		public String password;

		public String validate() {
			if (Usuario.authenticate(email, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}
	}
   
    public static Result jsRoutes(){
        response().setContentType("text/javascript");
        return ok(Routes.javascriptRouter("jsRoutes"                    
                ));
    }    
  
 
}
