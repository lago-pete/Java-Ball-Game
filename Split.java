import java.awt.Color;

public class Split extends BasicBall{
    
    public Split(double r, Color c) {
        super(r, c);
    }

    @Override
    public int reset() {
        rx = 0.0;
        ry = 0.0;  	
        vx = StdRandom.uniform(-0.01, 0.01); 
        vy = StdRandom.uniform(-0.01, 0.01);
        
        return 1;
    }

    
}
