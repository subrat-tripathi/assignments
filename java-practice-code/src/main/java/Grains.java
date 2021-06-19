import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if(square < 1 || square > 64){
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        BigInteger result = BigInteger.valueOf(2);
        return result.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger result = new BigInteger(String.valueOf(2));
        return result.pow(64).subtract(BigInteger.ONE);
    }

}
