import java.text.ParseException;
import java.util.stream.IntStream;
import simulation.Game;

/**
 *
 * That class has main method to play pisti game
 *  K game count
 */
public class Main {

    private static int K = 0;

    public static void main(String[] args) {

        validateArgs(args);

        IntStream.range(0,K)
            .forEach( i-> new Thread(new Game()).start());

    }

    private static void validateArgs(String[] args) {
        try {
            K = Integer.parseInt(args[0]);
            if(K < 1){
                throw new ParseException("cannot parse. stack trace : ",K);
            }
        }catch (NumberFormatException e){
            System.out.println("Please give me a valid number");
        }catch (ParseException e){
            System.out.println("cannot parse. please give me integer");

        }
    }
}
