import java.util.ArrayList;
import java.util.LinkedList;

public class Player implements Comparable<Player> {
    private String name;
    private float currentPoint;
    private float totalPoint;
    private ArrayList<String> matchDetails = new ArrayList<>();
    private LinkedList<String> playedAgainst = new LinkedList<>();
    private boolean isMatched = false;

    Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCurrentPoint(float currentPoint){
        this.currentPoint = currentPoint;
        setTotalPoint(currentPoint);
    }

    public float getCurrentPoint(){
        return this.currentPoint;
    }

    private void setTotalPoint(float currentPoint){
        this.totalPoint+= currentPoint;
    }

    public float getTotalPoint(){
        return this.totalPoint;
    }

    public void setMatchDetails(String details){
        this.matchDetails.add(details);
    }

    public ArrayList<String> getMatchDetails(){
        return this.matchDetails;
    }

    public void setPlayedAgainst(String player){
        this.playedAgainst.add(player);
    }

    public boolean getPlayedAgainst(String player){
        return this.playedAgainst.contains(player);
    }

    public void setMatched(boolean status){
        this.isMatched = status;
    }

    public boolean getMatched(){
        return this.isMatched;
    }

    public String toString(){
        return this.name +" "+this.totalPoint;
    }

    @Override
    public int compareTo(Player o) {
        if(this.totalPoint < o.totalPoint){
            return 1;
        }else if(this.totalPoint > o.totalPoint){
            return -1;
        }else{
            return 0;
        }
    }
}
