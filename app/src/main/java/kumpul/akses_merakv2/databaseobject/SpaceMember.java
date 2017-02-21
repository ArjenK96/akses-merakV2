package kumpul.akses_merakv2.databaseobject;

/**
 * Created by Arjen on 20-2-2017.
 */

public class SpaceMember {
    private String name;
    private String email;

    public SpaceMember(){

    }

    public SpaceMember(String _createdAt, String _modifiedAt, String email, String id, String name, String spaceId){
        this.name = name;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
