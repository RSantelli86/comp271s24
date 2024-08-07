public class TrainLine {

    /** Points to first station in the train line */
    private Station head;

    /** Points to the last station in the train line */
    private Station tail;

    /** Number of stations in the line */
    private int numberOfStations;

    /** Default constructor */
    public TrainLine() {
        this.head = null;
        this.tail = null;
        this.numberOfStations = 0;
    }

    /**
     * Adds a new station at the end of the train line.
     * @param name Name of the station to add.
     */
    public void add(String name) {
        Station newStation = new Station(name);
        if (this.head == null) {
            this.head = newStation;
            this.tail = newStation;
        } else {
            this.tail.setNext(newStation);
            this.tail = newStation;
        }
        this.numberOfStations++;
    }

    /**
     * Returns a string with the names of stations in reverse order.
     * Traverses the TrainLine only once.
     * @return String with station names in reverse order.
     */
    public String reverseListStations() {
        if (this.head == null) {
            return "The line is empty.";
        }

        return reverseHelper(this.head, "");
    }

    /**
     * Helper method to reverse the station order recursively.
     * @param current The current station in the traversal.
     * @param result The accumulated result string in reverse order.
     * @return The result string with stations in reverse order.
     */
    private String reverseHelper(Station current, String result) {
        if (current == null) {
            return result;
        }
        // Recursively call for next station first
        result = reverseHelper(current.getNext(), result);
        // Then add current station's name to result
        return result + current.getName() + "\n";
    }

    public static void main(String[] args) {
        TrainLine lincolnService = new TrainLine();
        lincolnService.add("Chicago");
        lincolnService.add("Summit");
        lincolnService.add("Joliet");
        lincolnService.add("Dwight");
        lincolnService.add("Pontiac");
        lincolnService.add("Bloomington");
        lincolnService.add("Lincoln");
        lincolnService.add("Springfield");
        lincolnService.add("Carlinville");
        lincolnService.add("Alton");
        lincolnService.add("Saint Louis");

        System.out.println(lincolnService.reverseListStations());
    }
}