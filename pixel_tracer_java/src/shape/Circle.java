package shape;


/**
 * Class Circle
 */
public class Circle extends Shape {

  //
  // Fields
  //

  private shape.Point center;
  
  //
  // Constructors
  //
  public Circle () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of center
   * @param newVar the new value of center
   */
  public void setCenter (shape.Point newVar) {
    center = newVar;
  }

  /**
   * Get the value of center
   * @return the value of center
   */
  public shape.Point getCenter () {
    return center;
  }

  //
  // Other methods
  //

  /**
   * @return       String
   */
  public String toString()
  {
    return "Circle[center=" + center + "]";
  }


}
