import java.awt.Color;

public class Bounce extends BasicBall{
    int wall = 3;

    public Bounce(double r, Color c) {
        super(r, c); 
    }

    @Override
    public int reset() {
        rx = 0.0;
        ry = 0.0;
        vx = StdRandom.uniform(-0.01, 0.01);
        vy = StdRandom.uniform(-0.01, 0.01);
        this.wall = 3;
        isOut = false; 
        return 1;
    }



    @Override
    public void move() 
    {
        if(isOut)
        {
            return;
        }
        rx = rx + vx;
        ry = ry + vy;
        if (Math.abs(rx) + radius >= 1.0)
         {
            if (wall > 0) 
            {
                vx = -vx; 
                if (vx > 0) 
                { 
                    rx = rx + radius;
                } 
                else 
                {
                    rx = rx - radius;
                }
                wall--;
            } 
            else 
            {
                isOut = true;
            }
        }
        if (Math.abs(ry) + radius >= 1.0) 
        {
            if (wall > 0) 
            {
                vy = -vy; 
                if (vy > 0) 
                {                    
                    ry = ry + radius;
                } 
                else 
                {
                    ry = ry - radius;
                }
                wall--;
            } 
            else 
            {
                isOut = true;
            }
        }
    }


    @Override
    public void draw() { 
    	if ((Math.abs(rx) <= 1.0) && (Math.abs(ry) <= 1.0)) {
    		StdDraw.setPenColor(color);
    		StdDraw.filledCircle(rx, ry, radius);
    	} else
    		isOut = true;
    	
    }



    
}
