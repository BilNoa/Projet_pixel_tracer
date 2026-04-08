package shape;


/**
 * Class Shape
 */
abstract public class Shape {

  //
  // Fields
  //

  private long int id;
  private char fill;
  private float thickness;
  private int color;
  private double rotation;
  
  //
  // Constructors
  //
  public Shape () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of id
   * @param newVar the new value of id
   */
  public void setId (long int newVar) {
    id = newVar;
  }

  /**
   * Get the value of id
   * @return the value of id
   */
  public long int getId () {
    return id;
  }

  /**
   * Set the value of fill
   * @param newVar the new value of fill
   */
  public void setFill (char newVar) {
    fill = newVar;
  }

  /**
   * Get the value of fill
   * @return the value of fill
   */
  public char getFill () {
    return fill;
  }

  /**
   * Set the value of thickness
   * @param newVar the new value of thickness
   */
  public void setThickness (float newVar) {
    thickness = newVar;
  }

  /**
   * Get the value of thickness
   * @return the value of thickness
   */
  public float getThickness () {
    return thickness;
  }

  /**
   * Set the value of color
   * @param newVar the new value of color
   */
  public void setColor (int newVar) {
    color = newVar;
  }

  /**
   * Get the value of color
   * @return the value of color
   */
  public int getColor () {
    return color;
  }

  /**
   * Set the value of rotation
   * @param newVar the new value of rotation
   */
  public void setRotation (double newVar) {
    rotation = newVar;
  }

  /**
   * Get the value of rotation
   * @return the value of rotation
   */
  public double getRotation () {
    return rotation;
  }

  //
  // Other methods
  //

  /**
   * @return       String
   */
  public String toString()
  {
  }


}
