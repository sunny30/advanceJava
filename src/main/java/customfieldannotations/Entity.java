package customfieldannotations;

import customfieldannotations.MInfo;

public class Entity {

    @MInfo("id")
    private String Id ;

    @MInfo("ename")
    private String name ;

    @MInfo
    private String nonEntityMember ;

    Entity(String id,String name,String nonEntityMember){
        this.Id = id ;
        this.name = name ;
        this.nonEntityMember = nonEntityMember ;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
