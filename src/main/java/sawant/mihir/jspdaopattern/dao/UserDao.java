package sawant.mihir.jspdaopattern.dao;

import sawant.mihir.jspdaopattern.entities.User;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDao {
    private List<User> usersDb;

    public UserDao(){
        usersDb = new ArrayList<User>();

        usersDb.addAll(Arrays.asList(new User("Tom", "Manager"),
                new User("Jerry", "Manager"),
                new User("Donald", "Developer"),
                new User("Popyee", "Sales"),
                new User("Shinchan", "Marketing")));
    }

    public int addUser(User user){
        boolean addValue = usersDb.add(user);
        return addValue ? 1 : -1;
    }

    public int updateUser(String name, User user){
        boolean checkName = usersDb.stream()
                .anyMatch(u -> u.getName().equalsIgnoreCase(name));
        if(checkName){
            for(User u : usersDb){
                if(u.getName().equalsIgnoreCase(name)){
                    u.setName(user.getName());
                    u.setDesignation(user.getDesignation());
                    return 1;
                }
            }
        }
        return -1;
    }

    public int deleteUser(String name){
        boolean checkName = usersDb.stream()
                .anyMatch(u -> u.getName().equalsIgnoreCase(name));

        if(checkName){
            for(User u : usersDb){
                if(u.getName().equalsIgnoreCase(name)){
                    usersDb.remove(u);
                    return 1;
                }
            }
        }
        return -1;
    }

    public List<User> getUsers(){
        return usersDb;
    }





}
