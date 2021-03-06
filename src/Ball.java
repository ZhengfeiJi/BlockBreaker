/**
 * This class is to define the pad and then draw it
 * 
 */
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

/**
 * This class is to define the pad and then draw it
 * 
 */
public class Ball {
    private float radius;
    private float posX;
    private float posY;
    private float prevPosX;
    private float speedX;
    private float speedY;

    /**
     * Creates a ball with defined parameters
     *
     * @param radius Defines radius of the ball
     * @param posX Defines horizontal position of the ball
     * @param posY Defines vertical position of the ball
     * @param speedX Defines horizontal velocity of the ball
     * @param speedY Defines vertical velocity of the ball
     */
    public Ball(float radius, float posX, float posY, float speedX, float speedY){
        this.radius = radius;
        this.posX = posX;
        this.posY = posY;
        this.speedX = speedX;
        this.speedY = speedY;		   

    }

    /**
     * This method generates an array of float values, that will be used to create vertexes to fill an arc. Which in our case is a circle.
     *
     * @param x Horizontal position of the centre of the arc
     * @param y Vertical position of the centre of the arc
     * @param r Radius of the vertexes/arc to be filled (radius of the circle)
     * @param startingAngleDeg Starting angle
     * @param endAngleDeg End angle
     * @param slices Number of slices/vertexes that will fill the arc
     * @return An array of floats corresponding to vertexes
     */
    public static float[] getFilledArcVertexes(float x, float y, float r, double startingAngleDeg, double endAngleDeg, int slices) {

        float radius =  r;

        double arcAngleLength = (endAngleDeg - startingAngleDeg) / 360f;

        float[] vertexes = new float[slices*6+6];

        double initAngle = Math.PI / 180f * startingAngleDeg;
        float prevXA = (float) Math.sin(initAngle) * radius;
        float prevYA = (float) Math.cos(initAngle) * radius;

        for(int arcIndex = 0; arcIndex < slices+1; arcIndex++) {
            double angle = Math.PI * 2 * ((float)arcIndex) / ((float)slices);
            angle += Math.PI / 180f;
            angle *= arcAngleLength;
            int index = arcIndex * 6;
            float xa = (float) Math.sin(angle) * radius;
            float ya = (float) Math.cos(angle) * radius;
            vertexes[index] = x;
            vertexes[index+1] = y;
            vertexes[index+2] = x+prevXA;
            vertexes[index+3] = y+prevYA;
            vertexes[index+4] = x+xa;
            vertexes[index+5] = y+ya;
            prevXA = xa;
            prevYA = ya;            
        }

        return vertexes;
    }	

    /**
     * Draws the ball
     *
     */
    public void draw(){
        glBegin(GL_TRIANGLE_FAN);
        float[] ballVertexes = Ball.getFilledArcVertexes(this.posX,this.posY,this.radius,0.0, 360.0, 10);
        for(int i = 0; i < ballVertexes.length; i++){

            glColor4f(1.0f, 1.0f, 0.5f, 1.0f);
            glVertex2f(ballVertexes[i], ballVertexes[i+1]);

            i++;
        }

        glEnd();

    }
    
    
    /**
     * getter, return the radius of the ball to whoever call this method
     * @return radius
     */
    public float getRadius(){
    	return radius;
    }    
    /**
     * getter, return the x Position of the ball
     * @return posX
     */
    public float getPosX(){
    	return posX;
    }
    /**
     * getter, return the y position of the ball
     * @return posY
     */
    public float getPosY(){
    	return posY;
    }
    /**
     * getter, return the previous X position of the ball
     * @return prevPosX
     */
    public float getPrevPosX(){
    	return prevPosX;
    }
    /**
     * getter, return the X speed of the ball
     * @return speedX
     */
    public float getSpeedX(){
    	return speedX;    	
    }
    /**
     * getter, return the Y speed of the ball
     * @return speedY
     */
    public float getSpeedY(){
    	return speedY;
    }
    /**
     * setter, this method can set the radius
     * @param r
     */
    public void setRadiusX(float r){
    	radius = r;
    }
    /**
     * setter, this method is to set the X position of the Ball
     * @param p X position of the Ball
     */
    public void setPosX(float p){
    	posX = p;
    }
    /**
     * setter, this method is to set the Y position of the Ball 
     * @param p Y position of the Ball
     */
    public void setPosY(float p){
    	posY = p;
    }
    /**
     * setter, this will set the previous X position of the Ball
     * @param p A parameter taken from where it is called to set the previous position of the Ball
     */
    public void setPrevPosX(float p){
    	prevPosX = p;
    }
    /**
     * setter, this will set the X speed of the Ball
     * @param s A parameter taken from where it is called,used to set the X speed
     */
    public void setSpeedX(float s){
    	speedX = s;    	
    }
    /**
     * setter, this will set the Y speed of the Ball
     * @param s A parameter taken from where it is called,used to set the Y speed
     */
    public void setSpeedY(float s){
    	speedY = s;
    }
}