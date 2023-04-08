package sawant.mihir.jspdaopattern.entities;

public class User {
    private String name;
    private String designation;

    public User(String name, String designation){
        this.name = name;
        this.designation = designation;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", designation=" + designation +
                '}';
    }
}
