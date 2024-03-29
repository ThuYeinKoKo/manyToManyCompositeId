package com.syh.test.manytomany_composit;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "GROUPS")
public class Group {
    private long id;
    private String name;
 
    private Set<UserGroup> userGroups = new HashSet<UserGroup>();
     
    public Group() {
    }
 
    public Group(String name) {
        this.name = name;
    }
         
    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID")
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @OneToMany(mappedBy = "primaryKey.group",
            cascade = CascadeType.ALL)
    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }
 
    public void setUserGroups(Set<UserGroup> groups) {
        this.userGroups = groups;
    }
     
    public void addUserGroup(UserGroup userGroup) {
        this.userGroups.add(userGroup);
    }
}
