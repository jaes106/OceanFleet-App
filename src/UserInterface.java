import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.print("Enter the number of vessels to be added: ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.print("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(":");

            Vessel vessel = new Vessel(
                    parts[0],
                    parts[1],
                    Double.parseDouble(parts[2]),
                    parts[3]
            );

            util.addVesselPerformance(vessel);
        }

        System.out.println("Enter the Vessel Id to check speed: ");
        String searchId = sc.nextLine();

        Vessel found = util.getVesselById(searchId);
        if (found != null) {
            System.out.println(
                    found.getVesselId() + " | " +
                            found.getVesselName() + " | " +
                            found.getVesselType() + " | " +
                            found.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        System.out.println("High performance vessels are");
        List<Vessel> topVessels = util.getHighPerformanceVessels();
        for (Vessel v : topVessels) {
            System.out.println(
                    v.getVesselId() + " | " +
                            v.getVesselName() + " | " +
                            v.getVesselType() + " | " +
                            v.getAverageSpeed() + " knots"
            );
        }
    }
}
