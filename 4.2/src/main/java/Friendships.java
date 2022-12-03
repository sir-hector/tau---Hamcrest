import java.util.*;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!
    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }

    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return friendships.get(person);
    }

    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        List<String> listOfFriends = getFriendsList(person1);
        if(listOfFriends != null){
            return listOfFriends.contains(person2);
        }else{
            return false;
        }
    }
    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
        if(getFriendsList(person) == null){
            List<String> friends = new ArrayList<String>();
            friends.add(friend);
            friendships.put(person, friends);
        } else {
            List<String> listOfFriends = getFriendsList(person);
            listOfFriends.add(friend);
        }
    }
}