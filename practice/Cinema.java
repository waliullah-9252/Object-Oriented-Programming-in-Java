import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StarCinema {
    static ArrayList<Hall> hallList = new ArrayList<>();

    public void entryHall(Hall hall) {
        hallList.add(hall);
    }
}

class Hall extends StarCinema {
    private final Map<String, Map<Integer, Map<Integer, Integer>>> seats = new HashMap<>();
    private final ArrayList<String[]> showList = new ArrayList<>();
    private final int rows;
    private final int cols;
    private final int hallNo;

    public Hall(int rows, int cols, int hallNo) {
        this.rows = rows;
        this.cols = cols;
        this.hallNo = hallNo;
        entryHall(this);
    }

    public void entryShow(String showId, String movieName, String time) {
        String[] allEntryInfo = {showId, movieName, time};
        showList.add(allEntryInfo);

        Map<Integer, Map<Integer, Integer>> seatMap = new HashMap<>();
        for (int i = 1; i <= rows; i++) {
            seatMap.put(i, new HashMap<>());
            for (int j = 1; j <= cols; j++) {
                seatMap.get(i).put(j, 0);
            }
        }
        seats.put(showId, seatMap);
    }

    public void bookSeats(String showId, int quantity, Map<Integer, Map<Integer, Integer>> seatMap) {
        Map<Integer, Map<Integer, Integer>> currentSeatMap = seats.get(showId);
        if (currentSeatMap != null) {
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : seatMap.entrySet()) {
                int row = entry.getKey();
                Map<Integer, Integer> colMap = entry.getValue();
                for (Map.Entry<Integer, Integer> seatEntry : colMap.entrySet()) {
                    int col = seatEntry.getKey();
                    int status = seatEntry.getValue();
                    if (row > 0 && row <= rows && col > 0 && col <= cols) {
                        if (status == 0 && currentSeatMap.get(row).get(col) == 0) {
                            currentSeatMap.get(row).put(col, 1);
                            System.out.println("SEAT (" + row + ", " + col + ") BOOKED SUCCESSFULLY FOR THE SHOW ID " + showId + ".");
                        } else {
                            System.out.println("SEAT (" + row + ", " + col + ") IS ALREADY BOOKED.");
                        }
                    } else {
                        System.out.println("INVALID SEAT (" + row + "," + col + "), PLEASE ENTER YOUR VALID ROW AND COLUMN !");
                    }
                }
            }
        }
    }

    public void viewShowList() {
        for (String[] showInfo : showList) {
            System.out.println("SHOW ID: " + showInfo[0] + ", MOVIE NAME: " + showInfo[1] + ", DATE & TIME: " + showInfo[2]);
        }
    }

    public void viewAvailableSeats(String showId) {
        Map<Integer, Map<Integer, Integer>> seatMap = seats.get(showId);
        if (seatMap != null) {
            System.out.println("AVAILABLE SEATS FOR THE SHOW ID " + showId + ":");
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    if (seatMap.get(i).get(j) == 0) {
                        System.out.print("O ");
                    } else {
                        System.out.print("1 ");
                    }
                }
                System.out.println();
            }
        }
    }
}

public class Cinema {
    public static void main(String[] args) {
        Hall starCineplex = new Hall(5, 5, 1001);
        starCineplex.entryShow("111", "IRON MAN 3", "6:00 PM and 09/10/2023");

        Hall sony = new Hall(5, 6, 1002);
        sony.entryShow("222", "SPIDER MAN", "4:00 PM and 09/10/2023");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("MENU");
            System.out.println("1. VIEW ALL SHOW: ");
            System.out.println("2. VIEW AVAILABLE SEATS: ");
            System.out.println("3. BOOKING TICKET");
            System.out.println("4. EXIT!");

            int ch = scanner.nextInt();

            if (ch == 1) {
                System.out.println("--------------------SHOW LIST--------------------");
                starCineplex.viewShowList();
                sony.viewShowList();
                System.out.println("-------------------------------------------------");

            } else if (ch == 2) {
                System.out.print("ENTER THE SHOW ID: ");
                String showId = scanner.next();
                if ("111".equals(showId)) {
                    starCineplex.viewAvailableSeats(showId);
                } else if ("222".equals(showId)) {
                    sony.viewAvailableSeats(showId);
                } else {
                    System.out.println("INVALID SHOW ID " + showId);
                }

            } else if (ch == 3) {
                System.out.print("ENTER THE SHOW ID: ");
                String showId = scanner.next();
                System.out.print("ENTER NO OF TICKETS: ");
                int quantity = scanner.nextInt();
                Map<Integer, Map<Integer, Integer>> seats = new HashMap<>();
                System.out.println("ENTER THE SEAT ROW AND COLUMN:");
                for (int i = 0; i < quantity; i++) {
                    System.out.print("Seat " + (i + 1) + " Row: ");
                    int row = scanner.nextInt();
                    System.out.print("Seat " + (i + 1) + " Column: ");
                    int col = scanner.nextInt();
                    if (!seats.containsKey(row)) {
                        seats.put(row, new HashMap<>());
                    }
                    seats.get(row).put(col, 0);
                }
                if ("111".equals(showId)) {
                    starCineplex.bookSeats(showId, quantity, seats);
                } else if ("222".equals(showId)) {
                    sony.bookSeats(showId, quantity, seats);
                } else {
                    System.out.println("INVALID SHOW ID " + showId);
                }

            } else if (ch == 4) {
                System.out.println("EXIT!");
                break;
            }
        }
    }
}
