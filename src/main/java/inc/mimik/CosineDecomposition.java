package inc.mimik;

import java.util.function.Function;
import java.util.stream.LongStream;

public class CosineDecomposition implements Function<Double, Double> {

  private final int N;

  public CosineDecomposition( int n ) { N = n; }

  public CosineDecomposition( ) { this( 5 ); }

  private static double fact( int n ) {
    return (double) LongStream.rangeClosed( 1, n )
        .reduce(1, ( long x, long y ) -> x * y );
  }

  @Override
  public Double apply( Double x ) {
    double result = 0;
    for ( int i = 0; i < N; ++i ) {
      final double doubledI = 2 * i;
      result += Math.pow( -1, i ) * Math.pow( x, doubledI ) / fact( 2 * i );
    }
    return result;
  }
}
