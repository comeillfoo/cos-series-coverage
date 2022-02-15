package inc.mimik;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CosineDecompositionTests {

  private final CosineDecomposition cos5 = new CosineDecomposition( 5 );
  private final double err5 = 0.0239334203269133;

  @ParameterizedTest
  @CsvSource( {
      "-3.141,-1.0000",
      "-2.973,-0.9858",
      "-1.604,-0.0332",
      "-1.570,0.0000",
      "-1.554,0.0168",
      "-0.785,0.7071",
      "-0.125,0.9922",
      "0.126,0.9921",
      "0.785,0.7071",
      "1.554,0.0168",
      "1.570,0.0000",
      "1.604,-0.0332",
      "2.973,-0.9858",
      "3.141,-1.0000"
  } )
  public void test5EqualSegments( double x, double y ) {
    assertEquals( cos5.apply( x ), y, err5 );
  }

  @ParameterizedTest
  @CsvSource( {
      "-3.141,3.141",
      "-2.973,2.973",
      "-1.604,1.604",
      "-1.570,1.570",
      "-1.554,1.554",
      "-0.785,0.785",
      "-0.125,0.125"
  } )
  public void test5Parity( double x1, double x2 ) {
    assertEquals( cos5.apply( x1 ), cos5.apply( x2 ), err5 );
  }
}
