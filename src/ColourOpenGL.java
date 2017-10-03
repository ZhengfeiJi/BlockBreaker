/**
 * This class is responsible to store openGL graphical item with vertical color gradient
 * @author user
 *
 */
public class ColourOpenGL {	

	// Used to store openGL graphical item colours with vertical colour gradient.
	
	private float rT;
    private float gT;
    private float bT;
    private float rB;
    private float gB;
    private float bB;
    
    public ColourOpenGL(float rt, float gt, float bt, float rb, float gb, float bb){
    	        
        this.rT = rt;
        this.gT = gt;
        this.bT = bt;
        this.rB = rb;
        this.gB = gb;
        this.bB = bb;
    }
	/**
	 * setter, set the Red element of the top of the block
	 * @param rt
	 */
	public void setRT(float rt){
    	this.rT = rt;
    }
	/**
	 * setter, set the Blue element of the top of the block
	 * @param bt
	 */
	public void setBT(float bt){
		this.bT = bt;
	}
	/**
	 * setter, set the Green element of the top of the block
	 * @param gt
	 */
	public void setGT(float gt){
		this.gT = gt;
	}
	/**
	 * setter, set the Red element of the bottom of the block
	 * @param rb
	 */
	public void setRB(float rb){
		this.rB = rb;
	}
	/**
	 * Setter, set the Blue element of the bottom of the block
	 * @param bb
	 */
	public void setBB(float bb){
		this.bB = bb;
	}
	/**
	 * Setter, set the Green element of the bottom of the block
	 * @param gb
	 */
	public void setGB(float gb){
		this.gB = gb;
	}
	/**
	 * Getter, return rT to whoever called this method
	 * @return rT
	 */
    public float getRT(){
    	return rT;
    }
    /**
	 * Getter, return bT to whoever called this method
	 * @return bT
	 */
	public float getBT(){
		return bT;
	}
	/**
	 * Getter, return GT to whoever called this method
	 * @return gT
	 */
	public float getGT(){
		return gT;
	}
	/**
	 * Getter, return rB to whoever called this method
	 * @return rB
	 */
	public float getRB(){
		return rB;
	}
	/**
	 * Getter, return bB to whoever called this method
	 * @return bB
	 */
	public float getBB(){
		return bB;
	}
	/**
	 * Getter, return gB to whoever called this method
	 * @return gB
	 */
	public float getGB(){
		return gB;
	}
		
}