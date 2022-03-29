
package com.awesam;

import java.util.*;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer>exists;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exists=new HashMap<String,Integer>();
        this.exists.put("Q",0);
    }



    void addExits(String direction, int location){
        exists.put(direction,location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String,Integer>(exists);
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        locations.put(0,new Location(0,"you are sitting in front of your computer learning java"));
        locations.put(1,new Location(1,"you are standing at the end of a road before a small bridge" ));
        locations.put(2,new Location(2,"you are at the top of a hill"));
        locations.put(3,new Location(3,"you are inside a building, "));
        locations.put(4,new Location(4,"you are inside a valley besides a stream"));
        locations.put(5,new Location(5,"you are inside the forest" ));

        locations.get(1).addExits("w",1);
        locations.get(1).addExits("E",2);
        locations.get(1).addExits("S",3);
        locations.get(1).addExits("N",4);

        locations.get(2).addExits("N",5);

        locations.get(3).addExits("w",1);

        locations.get(4).addExits("N",1);
        locations.get(4).addExits("w",2);

        locations.get(5).addExits("S",1);
        locations.get(5).addExits("w",2);
        Map<String,String>vocabulary=new HashMap<>();
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");
        vocabulary.put("QUIT","Q");
        int loc=1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) break;
            Map<String,Integer>exits= locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit: exits.keySet()) {
                System.out.print(exit+", ");
            }
            System.out.println();
            String direction=scanner.nextLine().toUpperCase();
            if (direction.length()>1){
                String []words=direction.split(" ");
                for (String word:words) {
                  if (vocabulary.containsKey(word)){
                      direction=vocabulary.get(word);
                      break;
                  }
                }
            }
            if (exits.containsKey(direction)){
             loc= exits.get(direction);
            }else{
                System.out.println("You can not go in that direction");
            }

        }

    }
   private static Map<Integer,Location> locations = new HashMap<Integer,Location>();
}

