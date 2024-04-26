import java.awt.Color;

public class Shrink extends BasicBall{
    double shrink_radius;

    public Shrink(double r, Color c) {
        super(r, c);  
        shrink_radius = r;
    }

    @Override
    public int reset() {
        if (radius <= (shrink_radius * 0.25)) {
            radius = shrink_radius;  
            rx = 0.0;  
            ry = 0.0;
        } else {
            radius = (2*radius)/3;  
            rx = 0.0;  
            ry = 0.0;
        }
        vx = StdRandom.uniform(-0.01, 0.01);
        vy = StdRandom.uniform(-0.01, 0.01);
        return 1; 
    }
    
}
