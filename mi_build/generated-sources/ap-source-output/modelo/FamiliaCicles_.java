package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FamiliaCicles.class)
public abstract class FamiliaCicles_ {

	public static volatile SingularAttribute<FamiliaCicles, Long> id;
	public static volatile SingularAttribute<FamiliaCicles, String> nom;
	public static volatile ListAttribute<FamiliaCicles, Cicle> llistaCicles;

}

