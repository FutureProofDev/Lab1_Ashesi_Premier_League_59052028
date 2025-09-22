import java.util.Scanner;

public class PlayerSelection {
    public static void main(String[] args) {

        // TAKING USER INPUT
        Scanner user_input = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = user_input.nextLine();

        System.out.println("Enter your age:");
        int age = user_input.nextInt();

        System.out.println("Enter your height in metres:");
        double heightMetres = user_input.nextDouble();

        System.out.println("Enter your weight in pounds:");
        double weightPounds = user_input.nextDouble();

        System.out.println("Enter your jersey number:");
        int jerseyNum= user_input.nextInt();

        user_input.close();

        // PERFORMING CONVERSIONS
        final double POUND = 0.45359237;
        final int METER = 100;

        double weightKG = weightPounds * POUND;
        double heightCM = heightMetres * METER;

        int weightKG_int = (int) weightKG;
        int heightCM_int = (int) heightCM;


        // ELIGIBILITY CHECKER
        boolean eligible;

        eligible  = (age >= 18 && age <= 35) && (weightKG_int < 90);



        // CATEGORY CHECKER
        String category;

        if (age < 20)
            category = "Rising Star";

        else if (age > 20 && age < 30)
            category = "Prime Player";

        else if (age > 30)
            category = "Veteran";

        else
            category = "no category";



        // Player Position and Attacker Jersey
        String playerPosition;
        String attackerJersey = "No";

        switch (jerseyNum) {
            case 1:
                playerPosition = "Goalkeeper";
                break;

            case 5:
            case 2:
                playerPosition = "Defender";
                System.out.println("Player Position - Defender");
                break;

            case 6:
            case 8:
                playerPosition = "Midfielder";
                System.out.println("Player Position - Midfielder");
                break;

            case 11:
            case 7:
                playerPosition = "Winger";
                attackerJersey = "Yes";
                break;

            case 9:
                playerPosition = "Striker";
                attackerJersey = "Yes";
                break;

            case 10:
                playerPosition = "Playmaker";
                attackerJersey = "Yes";
                break;

            default:
                playerPosition = "Unknown Position";
        }



        // Line Up Decision Maker
        String decision;

        if (age < 20){
            if (weightKG_int < 80) {
                decision = "Starting Line Up";
            }
            else {
                decision = "Bench";
                eligible = false;
            }
        }
        else {
            decision = "Bench";
            eligible = false;
        }

        // Final Status Maker
        String finalStatus = (eligible) ? "Play" : "Rest";
        String eligibility = (eligible) ? "Eligible" : "Not Eligible";


        // FINAL OUTPUT
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " (" + category + ")");
        System.out.println("Height: " + heightCM_int + "cm");
        System.out.println("Weight: " + weightKG_int + "kg");
        System.out.println("Jersey: " + jerseyNum);
        System.out.println("Position: " + playerPosition);
        System.out.println("Attacker jersey: " + attackerJersey);
        System.out.println("Eligibility: " + eligibility);
        System.out.println("Lineup Decision: " + decision);
        System.out.println("Final Decision: " + finalStatus);


    }
}
