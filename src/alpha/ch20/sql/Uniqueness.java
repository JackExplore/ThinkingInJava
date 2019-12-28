package alpha.ch20.sql;

public @interface Uniqueness {

    Constraints constraints() default @Constraints(unique = true);
}
