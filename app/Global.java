import java.util.List;

import models.daos.UsuarioDAO;
import models.daos.impl.UsuarioDAOImpl;
import models.entities.Usuario;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {
    @Override
    public void onStart(Application app) {
        
        UsuarioDAO udao = new UsuarioDAOImpl();
        
        // Check if the database is empty
        if (Ebean.find(Usuario.class).findList().size() == 0) {
            List<?> lista = (List<?>) Yaml.load("test-data.yml");

        }
    }
}
