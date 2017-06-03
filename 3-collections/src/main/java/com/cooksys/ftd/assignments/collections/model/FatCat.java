package com.cooksys.ftd.assignments.collections.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FatCat implements Capitalist {
    String catName="";
    int catSalary=0;
    FatCat catOwner=null;


    public FatCat(String name, int salary) {
        //this(name,salary,null);
        this.catName=name;
        this.catSalary=salary;
        //throw new NotImplementedException();
    }

    public FatCat(String name, int salary, FatCat owner) {
        this.catName=name;
        this.catSalary=salary;
        this.catOwner=owner;
        //throw new NotImplementedException();
    }

    /**
     * @return the name of the capitalist
     */
    @Override
    public String getName() {
        return this.catName;
        //throw new NotImplementedException();
    }

    /**
     * @return the salary of the capitalist, in dollars
     */
    @Override
    public int getSalary() {
        return this.catSalary;
        //throw new NotImplementedException();
    }

    /**
     * @return true if this element has a parent, or false otherwise
     */
    @Override
    public boolean hasParent() {
        if(catOwner!=null){
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
        return catOwner;
        //throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FatCat fatCat = (FatCat) o;

        if (catSalary != fatCat.catSalary) return false;
        if (catName != null ? !catName.equals(fatCat.catName) : fatCat.catName != null) return false;
        return catOwner != null ? catOwner.equals(fatCat.catOwner) : fatCat.catOwner == null;

    }

    @Override
    public int hashCode() {
        int result = catName != null ? catName.hashCode() : 0;
        result = 31 * result + catSalary;
        result = 31 * result + (catOwner != null ? catOwner.hashCode() : 0);
        return result;
    }
}
