package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Agent;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-08T23:45:51")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> lName;
    public static volatile SingularAttribute<Customer, Agent> agent;
    public static volatile SingularAttribute<Customer, String> fName;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, String> passport;
    public static volatile SingularAttribute<Customer, Integer> tel;
    public static volatile SingularAttribute<Customer, String> email;

}