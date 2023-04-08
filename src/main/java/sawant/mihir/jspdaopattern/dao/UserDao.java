package sawant.mihir.jspdaopattern.dao;

import sawant.mihir.jspdaopattern.entities.User;


import java.util.List;

public class UserDao {
    private static List<User> usersDb;

    public UserDao(){
        usersDb = List.of(new User("Tom", 35),
                new User("Jerry", 25), new User("Donald", 55),
                new User("Popyee", 34), new User("Shinchan", 8));
    }

    public int addUser(User user){
        boolean addValue = usersDb.add(user);
        return addValue;
    }

    public int updateUser(String name, User user){
        boolean checkName = usersDb.stream()
                .anyMatch(u -> u.getName().equalsIgnoreCase(name));
        if(checkName){
            for(User u : usersDb){
                if(u.getName().equalsIgnoreCase(name)){
                    u.setName(user.getName());
                    u.setAge(user.getAge());
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
