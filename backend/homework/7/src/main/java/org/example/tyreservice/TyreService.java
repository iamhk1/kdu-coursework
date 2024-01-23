package org.example.tyreservice;
import org.example.entities.Tyre;
import org.example.springconfig.TyreConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


//@Service
@Component
public class TyreService {
    public Tyre getTyre(String tyreName)
    {
        var context=new AnnotationConfigApplicationContext(TyreConfig.class);
        return context.getBean(tyreName,Tyre.class);

    }
}
