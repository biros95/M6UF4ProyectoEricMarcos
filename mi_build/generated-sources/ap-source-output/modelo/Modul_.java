package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Modul.class)
public abstract class Modul_ {

	public static volatile SingularAttribute<Modul, Cicle> cicle;
	public static volatile SingularAttribute<Modul, Long> id;
	public static volatile SingularAttribute<Modul, String> nom;
	public static volatile SingularAttribute<Modul, Curs> curs;
	public static volatile ListAttribute<Modul, UnitatFormativa> llistaUF;

}

