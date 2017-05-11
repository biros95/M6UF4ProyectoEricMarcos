package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cicle.class)
public abstract class Cicle_ {

	public static volatile ListAttribute<Cicle, Curs> llistaCursos;
	public static volatile SingularAttribute<Cicle, Long> id;
	public static volatile SingularAttribute<Cicle, String> nom;
	public static volatile ListAttribute<Cicle, Modul> llistaModuls;
	public static volatile SingularAttribute<Cicle, FamiliaCicles> familia;
	public static volatile SingularAttribute<Cicle, String> grau;

}

