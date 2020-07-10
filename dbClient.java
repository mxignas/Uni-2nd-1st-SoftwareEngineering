import java.io.*;
import java.util.*;
import java.net.*;

public class dbClient {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 0) {
            System.err.println(
			       "Host name and Port number is already defined");
            System.exit(1);
        }

        String hostName = "localhost";
        int portNumber = 8888;

        try {
	    //echo socket
            Socket echoSocket = new Socket(hostName, portNumber);

	    // to write to server
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);

	    // to write in client
	    Scanner scanner = new Scanner(System.in);
	    
	    BufferedReader in =
                new BufferedReader(
				   new InputStreamReader(echoSocket.getInputStream()));
        
	   
	    System.out.println("Successfully connected to the server!");
	    functionality();
	    
	    while(true) {
		//user input
		String input = scanner.nextLine();
		out.println(input);

		if(input.equals("listall")){
		    System.out.println("[bookingID][staffID][clientID][focus][bkDate][bkTime][duration]");
		}
		
		if(input.equals("listpt")){
		    System.out.println("Please input clientID number whose bookings you want to see");
		    System.out.println("[bookingID][staffID][clientID][focus][bkDate][bkTime][duration]");
		}

		if(input.equals("listclient")){
		    System.out.println("Please input clientID number whose bookings you want to see");
		    System.out.println("[bookingID][staffID][clientID][focus][bkDate][bkTime][duration]");
		}

		if(input.equals("listday")){
		    System.out.println("Please input date to see that day all the bookings");
		    System.out.println("Example: 2020-02-18");
		    System.out.println("[bookingID][staffID][clientID][focus][bkDate][bkTime][duration]");
		}

		if(input.equals("add")){
		    System.out.println("Please enter your booking values as follows (staffID, clientID, focus, bkDate, bkTime, duration).");
		    System.out.println("Example: 1, 3, 'WeightLoss', '2020-01-01', '13:30:00', 120");
		}

		if(input.equals("delete")){
		    System.out.println("Please input bookingID which you want to delete");
		}

		if(input.equals("update")){
		    System.out.println("Example: changing duration and staffID to a booking 1");
		    System.out.println("SET duration = 60, SET staffID = 2 WHERE bookingID = 1");
		    System.out.println("[bookingID][staffID][clientID][focus][bkDate][bkTime][duration]");
		}

		if(input.equals("q")){
		    break;
		}
	       
		String response = in.readLine();
		//reading from server
		while(!response.equals("")) {
		    System.out.println(response);
		    response = in.readLine();
		}
		System.out.println("");
	    }
	}
    
	catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
			       hostName);
            System.exit(1);
        } 
    }

    public static void functionality () {
        
	    System.out.println("");
	    System.out.println("For adding booking - type in 'add'");
	    System.out.println("");
	    System.out.println("For listing all the bookings - type 'listall'");
	    System.out.println("");
	    System.out.println("For listing given PT bookings - type 'listpt'");
	    System.out.println("");
	    System.out.println("For listing given client bookings - type 'listclient'");
	    System.out.println("");
	    System.out.println("For listing given day bookings - type 'listday'");
	    System.out.println("");
	    System.out.println("To update booking - type 'update'");
	    System.out.println("");
	    System.out.println("To delete booking - type 'delete'");
	    System.out.println("");
	    System.out.println("To quit - type 'q'");
	    
    }
    
}
