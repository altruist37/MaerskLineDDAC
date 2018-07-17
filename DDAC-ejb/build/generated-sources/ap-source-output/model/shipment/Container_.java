package model.shipment;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-08T23:45:51")
@StaticMetamodel(Container.class)
public class Container_ { 

    public static volatile SingularAttribute<Container, String> vessel;
    public static volatile SingularAttribute<Container, Date> departureDate;
    public static volatile SingularAttribute<Container, Date> arrivalDate;

}