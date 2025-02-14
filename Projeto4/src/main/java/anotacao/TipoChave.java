package main.java.anotacao;

import java.lang.annotation.*;

/**
 * @author ana
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
