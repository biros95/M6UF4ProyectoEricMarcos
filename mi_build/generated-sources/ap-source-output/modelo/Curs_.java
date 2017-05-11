package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utilitats.NombreDeCurs;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Curs.class)
public abstract class Curs_ {

	public static volatile SingularAttribute<Curs, Cicle> cicle;
	public static volatile SingularAttribute<Curs, NombreDeCurs> nombreDeCurs;
	public static volatile SingularAttribute<Curs, Long> id;
	public static volatile ListAttribute<Curs, UnitatFormativa> listaUF;
	public static volatile ListAttribute<Curs, Modul> llistaModuls;

}

