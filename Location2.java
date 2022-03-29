package com.awesam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Location2 {

        private final int locationID;
        private final String description;
        private final Map<String,Integer>exists;

        public Location2(int locationID, String description,Map<String,Integer>exists) {
            this.locationID = locationID;
            this.description = description;
            if (exists!=null) {
                this.exists = new HashMap<>(exists);
            }else{
                this.exists = new HashMap<>();
            }
            this.exists.put("Q",0);
        }
        /*private void addExits(String direction,int location){
            exists.put(direction,location);
        }*/

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
            Map<String,Integer>tempExists=new HashMap<String,Integer>();
            locations.put(0,new Location2(0,"you are sitting in front of your computer learning java", tempExists));

            tempExists=new HashMap<String,Integer>();
            tempExists.put("w",1);
            tempExists.put("E",2);
            tempExists.put("S",3);
            tempExists.put("N",4);
            locations.put(1,new Location2(1,"you are standing at the end of a road before a small bridge",tempExists));

            tempExists=new HashMap<String,Integer>();
            tempExists.put("N",5);
            locations.put(2,new Location2(2,"you are at the top of a hill",tempExists));


            tempExists=new HashMap<String,Integer>();
            tempExists.put("w",1);
            locations.put(3,new Location2(3,"you are inside a building, ",tempExists));


            tempExists=new HashMap<String,Integer>();
            tempExists.put("N",1);
            tempExists.put("w",2);
            locations.put(4,new Location2(4,"you are inside a valley besides a stream", tempExists));

            tempExists=new HashMap<String,Integer>();
            tempExists.put("S",1);
            tempExists.put("w",2);
            locations.put(5,new Location2(5,"you are inside the forest", tempExists));


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
        private static Map<Integer, Location2> locations = new HashMap<Integer, Location2>();
    }


