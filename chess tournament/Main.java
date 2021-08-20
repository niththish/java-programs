package test.chessTournament;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
     private static LinkedList<Player[]> schedules = new LinkedList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList<Player> players = new LinkedList<>();

        //Getting number of players count
        System.out.print("Enter no of players : ");
        int noOfPlayers = sc.nextInt();

        //Getting the number of rounds count
        System.out.print("Enter no of Rounds : ");
        int noOfRounds = sc.nextInt();

        //Storing the players initial details in a list
        for(int i=1;i<=noOfPlayers;i++){
            players.add(new Player("Player"+i));
        }

        int roundCount = 1;
        while(roundCount <= noOfRounds){
            pairPlayers(players); //used to do match pairing between the players
            viewSchedule(roundCount,schedules); //used to view the match schedules of all rounds
            playMatch(roundCount,schedules); //manipulating the players victory and updating their points status
            roundResults(roundCount,schedules); //used to view the current round summary
            Collections.sort(players); //sorting the players based on their total tournament points
            pointsTable(roundCount,players); //used to view the points table after each round ends completely
            clearMatches(players); //resetting the previous rounds helper variables to their default values for correct pairing
            schedules.clear(); //clearing the previous round schedule
            roundCount++; //incrementing the roundCount to next round
        }

        tournamentSummary(players); //used to view each players match summary in the complete tournament
        tournamentRank(players); //used to view the final tournament players rankList
    }

    private static void pairPlayers(LinkedList<Player> players){
        for(int i=0;i<players.size();i++){
            for(int j=0;j<players.size();j++){
                if(players.get(i).getName().equals(players.get(j).getName())){
                    continue;
                }else if(players.get(i).getMatched() || players.get(j).getMatched()){
                    continue;
                }
                else{
                    if(! players.get(i).getPlayedAgainst(players.get(j).getName()) ){
                        players.get(i).setPlayedAgainst(players.get(j).getName());
                        players.get(j).setPlayedAgainst(players.get(i).getName());
                        players.get(i).setMatched(true);
                        players.get(j).setMatched(true);
                        schedule(schedules,players.get(i),players.get(j));
                        break;
                    }
                }
            }
        }
        if(players.size()%2==1){

            for(Player p : players){
                if(!p.getMatched()){
                    schedule(schedules,p,null);
                }
            }

        }
    }

    private static void schedule(LinkedList<Player[]> schedules,Player p1,Player p2){
        schedules.add(new Player[]{p1,p2});
    }

    private static void viewSchedule(int roundCount,LinkedList<Player[]> schedules){
        System.out.println("\n----------Schedule : "+roundCount+"----------");
        for(Player[] p : schedules){
            if(p[1] == null){
                System.out.println(p[0].getName()+" Bye");
            }else{
                System.out.println(p[0].getName() +" vs "+p[1].getName());
            }
        }
    }

    private static void playMatch(int roundCount,LinkedList<Player[]> schedules){
        for(Player[] p : schedules){
            if(p[1] == null){
                p[0].setCurrentPoint(1f);
                p[0].setMatchDetails("match "+roundCount+" Bye");
            }else{
                int p1_points = (int) Math.ceil(Math.random()*10);
                int p2_points = (int) Math.ceil(Math.random()*10);
                if(p1_points == p2_points){
                    p[0].setCurrentPoint(0.5f);
                    p[1].setCurrentPoint(0.5f);
                    p[0].setMatchDetails("match "+roundCount+" vs "+p[1].getName() +" Draw");
                    p[1].setMatchDetails("match "+roundCount+" vs "+p[0].getName() +" Draw");
                }else if(p1_points > p2_points){
                    p[0].setCurrentPoint(1f);
                    p[1].setCurrentPoint(0f);
                    p[0].setMatchDetails("match "+roundCount+" vs "+p[1].getName() +" Won");
                    p[1].setMatchDetails("match "+roundCount+" vs "+p[0].getName() +" Lost");
                }else if(p1_points < p2_points){
                    p[0].setCurrentPoint(0f);
                    p[1].setCurrentPoint(1f);
                    p[0].setMatchDetails("match "+roundCount+" vs "+p[1].getName() +" Lost");
                    p[1].setMatchDetails("match "+roundCount+" vs "+p[0].getName() +" Won");
                }
            }
        }
    }

    private static void roundResults(int roundCount,LinkedList<Player[]> schedules){
        System.out.println("\n----------Results for round : "+roundCount+"----------");
        for(Player[] p : schedules){
            if(p[1] == null){
                System.out.printf("%s (%.1f) \n",p[0].getName(),p[0].getCurrentPoint());
            }else{
                System.out.printf("%s (%.1f : %.1f) %s\n",p[0].getName(),p[0].getCurrentPoint(),p[1].getCurrentPoint(),p[1].getName());
            }
        }
    }

    private static void pointsTable(int roundCount,LinkedList<Player> players){
        System.out.println("\n----------Points table after round : "+roundCount+"----------");
        for(Player p : players){
            System.out.println(p.getName()+" ( "+p.getTotalPoint()+" )");
        }
    }

    private static void tournamentSummary(LinkedList<Player> players){
        System.out.println("\nPlayers Summary");
        for(Player p: players){
            System.out.println("------------------------------");
            System.out.println("Player name : "+p.getName());
            System.out.println("Total points : "+p.getTotalPoint());
            for(String summary : p.getMatchDetails()){
                System.out.println(summary);
            }
            System.out.println("------------------------------");
        }
    }

    private static void tournamentRank(LinkedList<Player> players){
        System.out.println("Tournament Scorecard");
        for(int i=0;i<players.size();i++){
            System.out.println("Rank "+(i+1)+" : "+players.get(i).getName()+"   "+players.get(i).getTotalPoint());
        }
    }

    private static void clearMatches(LinkedList<Player> players){
        for(Player p : players){
            p.setMatched(false);
        }
    }
}
