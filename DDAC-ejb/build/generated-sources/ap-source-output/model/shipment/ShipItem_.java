package model.shipment;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Agent;
import model.Customer;
import model.shipment.Container;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-08T23:45:51")
@StaticMetamodel(ShipItem.class)
public class ShipItem_ { 

    public static volatile SingularAttribute<ShipItem, Integer> regNo;
    public static volatile SingularAttribute<ShipItem, Agent> agent;
    public static volatile SingularAttribute<ShipItem, Double> price;
    public static volatile SingularAttribute<ShipItem, Container> vessel;
    public static volatile SingularAttribute<ShipItem, Long> id;
    public static volatile SingularAttribute<ShipItem, Integer> itemNo;
    public static volatile SingularAttribute<ShipItem, Customer> cust;

}