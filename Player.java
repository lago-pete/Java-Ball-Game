// Purpose: This class is used to keep track of the player's score and the number of hits they have made on each type of ball.
public class Player 
{
    private int basic;
    private int shrink;
    private int bounce;
    private int split;
    private int score;
    private int hits;

    public Player() 
    {
        this.score = 0;
    }

    public int getScore() 
    {
        return score;
    }

    public void hit_basic()
    {
        basic++;
        hits += 1;
        score += 25;
    }
    public void hit_shrink()
    {
        shrink ++;
        hits += 1;
        score += 20;
    }
    public void hit_bounce()
    {
        bounce ++;
        hits += 1;
        score += 15;
    }
    public void hit_split()
    {
        split ++;
        hits += 1;
        score += 10;
    }
    
    public int getHits()
    {
        return hits;
    }
    
    public int getBasic()
    {
        return basic;
    }
    public int getShrink()
    {
        return shrink;
    }
    public int getBounce()
    {
        return bounce;
    }
    public int getSplit()
    {
        return split;
    }


}