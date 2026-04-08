package shape;


/**
 * Class Line
 */
public class Line extends Shape {

  //
  // Fields
  //

  private shape.Point p1;
  private shape.Point p2;
  
  //
  // Constructors
  //
  public Line () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of p1
   * @param newVar the new value of p1
   */
  public void setP1 (shape.Point newVar) {
    p1 = newVar;
  }

  /**
   * Get the value of p1
   * @return the value of p1
   */
  public shape.Point getP1 () {
    return p1;
  }

  /**
   * Set the value of p2
   * @param newVar the new value of p2
   */
  public void setP2 (shape.Point newVar) {
    p2 = newVar;
  }

  /**
   * Get the value of p2
   * @return the value of p2
   */
  public shape.Point getP2 () {
    return p2;
  }

  //
  // Other methods
  //

  /**
   * @return       String
   */
  public String toString()
  {
    return "Line[p1=" + p1 + ", p2=" + p2 + "]";
  }


}
