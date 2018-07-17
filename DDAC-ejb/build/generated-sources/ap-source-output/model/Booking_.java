package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Agent;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-08T23:45:51")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Agent> agent;
    public static volatile SingularAttribute<Booking, String> vessel;
    public static volatile SingularAttribute<Booking, Integer> id;

}