package anotacao;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//para saber o nome da tabela
public @interface Tabela {
    String value();
}
