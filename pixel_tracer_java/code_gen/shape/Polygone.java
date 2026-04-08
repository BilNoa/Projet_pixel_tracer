package shape;


/**
 * Class Polygone
 */
public class Polygone extends Shape {

  //
  // Fields
  //

  private ArrayList<Point> points;
  
  //
  // Constructors
  //
  public Polygone () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of points
   * @param newVar the new value of points
   */
  public void setPoints (ArrayList<Point> newVar) {
    points = newVar;
  }

  /**
   * Get the value of points
   * @return the value of points
   */
  public ArrayList<Point> getPoints () {
    return points;
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
