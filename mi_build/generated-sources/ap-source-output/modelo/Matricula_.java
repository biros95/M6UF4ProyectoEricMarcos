package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utilitats.Descompte;
import utilitats.Modalitat;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Matricula.class)
public abstract class Matricula_ {

	public static volatile SingularAttribute<Matricula, Date> data;
	public static volatile SingularAttribute<Matricula, Modalitat> modalitat;
	public static volatile SingularAttribute<Matricula, Alumne> alumneId;
	public static volatile SingularAttribute<Matricula, Long> id;
	public static volatile ListAttribute<Matricula, UnitatFormativa> listaUF;
	public static volatile SingularAttribute<Matricula, Import> importe;
	public static volatile SingularAttribute<Matricula, Descompte> descompte;

}

