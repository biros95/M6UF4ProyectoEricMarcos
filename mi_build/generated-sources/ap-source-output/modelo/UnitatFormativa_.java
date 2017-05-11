package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UnitatFormativa.class)
public abstract class UnitatFormativa_ {

	public static volatile SingularAttribute<UnitatFormativa, Integer> hores;
	public static volatile SingularAttribute<UnitatFormativa, Modul> modul;
	public static volatile SingularAttribute<UnitatFormativa, Long> id;
	public static volatile SingularAttribute<UnitatFormativa, String> nom;
	public static volatile ListAttribute<UnitatFormativa, Matricula> listaMatriculas;
	public static volatile SingularAttribute<UnitatFormativa, Curs> curs;

}

