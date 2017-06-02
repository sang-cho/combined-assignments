package com.cooksys.ftd.assignments.collections.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WageSlave implements Capitalist {
    String wagName;
    int wagSalary;
    FatCat wageOwner;

    public WageSlave(String name, int salary) {
        //this(name,salary,null);
        this.wagName=name;
        this.wagSalary=salary;
        //throw new NotImplementedException();
    }

    public WageSlave(String name, int salary, FatCat owner) {
        this.wagName=name;
        this.wagSalary=salary;
        this.wageOwner=owner;

        //throw new NotImplementedException();
    }

    /**
     * @return the name of the capitalist
     */
    @Override
    public String getName() {
        return this.wagName;
        //throw new NotImplementedException();
    }

    /**
     * @return the salary of the capitalist, in dollars
     */
    @Override
    public int getSalary() {
        return this.wagSalary;
        //throw new NotImplementedException();
    }

    /**
     * @return true if this element has a parent, or false otherwise
     */
    @Override
    public boolean hasParent() {
        if(this.wageOwner!=null){
            return true;
        }
        return false;
        //throw new NotImplementedException();
    }

    /**
     * @return the parent of this element, or null if this represents the top of a hierarchy
     */
    @Override
    public FatCat getParent() {
        if (!hasParent()){
            return null;
        }
        return wageOwner;
        //throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WageSlave wageSlave = (WageSlave) o;

        if (wagSalary != wageSlave.wagSalary) return false;
        if (wagName != null ? !wagName.equals(wageSlave.wagName) : wageSlave.wagName != null) return false;
        return wageOwner != null ? wageOwner.equals(wageSlave.wageOwner) : wageSlave.wageOwner == null;

    }

    @Override
    public int hashCode() {
        int result = wagName != null ? wagName.hashCode() : 0;
        result = 31 * result + wagSalary;
        result = 31 * result + (wageOwner != null ? wageOwner.hashCode() : 0);
        return result;
    }
}
