package com.cooksys.ftd.assignments.collections;

import com.cooksys.ftd.assignments.collections.hierarchy.Hierarchy;
import com.cooksys.ftd.assignments.collections.model.Capitalist;
import com.cooksys.ftd.assignments.collections.model.FatCat;
import com.cooksys.ftd.assignments.collections.model.WageSlave;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.util.*;

public class MegaCorp implements Hierarchy<Capitalist, FatCat> {
    ArrayList<Capitalist> stuff=new ArrayList<Capitalist>();

    /**
     * Adds a given element to the hierarchy.
     * <p>
     * If the given element is already present in the hierarchy,
     * do not add it and return false
     * <p>
     * If the given element has a parent and the parent is not part of the hierarchy,
     * add the parent and then add the given element
     * <p>
     * If the given element has no parent but is a Parent itself,
     * add it to the hierarchy
     * <p>
     * If the given element has no parent and is not a Parent itself,
     * do not add it and return false
     *
     * @param capitalist the element to add to the hierarchy
     * @return true if the element was added successfully, false otherwise
     */
    @Override
    public boolean add(Capitalist capitalist) {
        if(capitalist==null || stuff.contains(capitalist)){
            return false;
        }
        //if(stuff.contains(capitalist)){
        //   return false;
        //}
        if(capitalist.hasParent() && stuff.contains(capitalist.getParent())){
            stuff.add(capitalist);
            return true;
        }
        if(capitalist.hasParent() && !stuff.contains(capitalist.getParent())){
            stuff.add(capitalist);
            add(capitalist.getParent());
            return true;
        }
        if(!capitalist.hasParent() && capitalist instanceof FatCat){
            stuff.add(capitalist);
            return true;
        }
        if(!capitalist.hasParent() && capitalist instanceof WageSlave){
            return false;
        }
        return false;
        //throw new NotImplementedException();
    }

    /**
     * @param capitalist the element to search for
     * @return true if the element has been added to the hierarchy, false otherwise
     */
    @Override
    public boolean has(Capitalist capitalist) {
        if(stuff.contains(capitalist)){
            return true;
        }
        return false;
        //throw new NotImplementedException();
    }

    /**
     * @return all elements in the hierarchy,
     * or an empty set if no elements have been added to the hierarchy
     */
    @Override
    public Set<Capitalist> getElements() {
        Set elemSet= new HashSet(stuff);
        return elemSet;
        //  throw new NotImplementedException();
    }

    /**
     * @return all parent elements in the hierarchy,
     * or an empty set if no parents have been added to the hierarchy
     */
    @Override
    public Set<FatCat> getParents() {
        Set <FatCat> catParents = new HashSet<>();
        for (int i=0; i<stuff.size();i++){
            if(stuff.get(i) instanceof FatCat){
                catParents.add((FatCat)stuff.get(i));
            }
        }

        return catParents;
        //throw new NotImplementedException();
    }

    /**
     * @param fatCat the parent whose children need to be returned
     * @return all elements in the hierarchy that have the given parent as a direct parent,
     * or an empty set if the parent is not present in the hierarchy or if there are no children
     * for the given parent
     */
    @Override
    public Set<Capitalist> getChildren(FatCat fatCat) {
        Set <Capitalist> children = new HashSet<>();
        for (int i=0; i<stuff.size();i++){
            if ((stuff.get(i)).hasParent() && fatCat.equals(stuff.get(i).getParent())){
                children.add(stuff.get(i));
            }
        }
        return children;
        //throw new NotImplementedException();
    }

    /**
     * @return a map in which the keys represent the parent elements in the hierarchy,
     * and the each value is a set of the direct children of the associate parent, or an
     * empty map if the hierarchy is empty.
     */
    @Override
    public Map<FatCat, Set<Capitalist>> getHierarchy() {

        Map<FatCat,Set<Capitalist>> hierarchy= new HashMap<>();
        //Set<FatCat> parents=getParents();
        Set<Capitalist> children;

        for (int i=0; i<stuff.size();i++){
            if(stuff.get(i) instanceof FatCat) {
                children = getChildren((FatCat) stuff.get(i));
                hierarchy.put((FatCat) stuff.get(i), children);
            }
        }
        return hierarchy;
    }

    /**
     * @param capitalist
     * @return the parent chain of the given element, starting with its direct parent,
     * then its parent's parent, etc, or an empty list if the given element has no parent
     * or if its parent is not in the hierarchy
     */
    @Override
    public List<FatCat> getParentChain(Capitalist capitalist) {
        List<FatCat> parentChain= new ArrayList<FatCat>();
        if (capitalist == null || capitalist.hasParent()==false ||  !(stuff.contains(capitalist.getParent()))){
            return parentChain;
        }
        Capitalist temp= capitalist;
        while(temp.getParent()!=null){
            parentChain.add(temp.getParent());
            temp=temp.getParent();

        }
        return parentChain;
    }

}
