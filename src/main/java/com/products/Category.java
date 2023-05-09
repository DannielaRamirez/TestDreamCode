package com.products;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Category {
    private String name;
    private Set<String> keywords;

    private List<Category> children;

    private Category father;

    public Category(String name){
        this.name= name;
        this.keywords= new HashSet<>();
        this.children= new ArrayList<>();
    }


    public void addChildren(Category cat){
        cat.setFather(this);
        children.add(cat);
    }

    public Set<String> getKeywords(){
        Set<String> lstKeywords = new HashSet<>(keywords);
        Category actual = this.father;
        while (actual != null){
            lstKeywords.addAll(actual.getKeywords());
            actual = actual.getFather();
        }
        return lstKeywords;
    }


    public int getLevel(){
        int level = 0;
        Category actual = this.father;
        while (actual != null){
            level++;
            actual= actual.getFather();
        }
        return level;

    }


}
