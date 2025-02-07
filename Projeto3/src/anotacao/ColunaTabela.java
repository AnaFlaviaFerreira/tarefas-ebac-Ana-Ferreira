package anotacao;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//para saber o nome da coluna e o valor que vai setar
public @interface ColunaTabela {
    String dbName();

    String setJavaName();
}
