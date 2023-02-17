using System;
namespace gpFlightReservation
{
    public class FlightManager
    {
        public Flight[] fList;
        public int numFlights;
        public int maxFlights;

        public FlightManager()
        {
            maxFlights = 100;
            numFlights = 0;
            fList = new Flight[maxFlights];
        }

        public void addFlight(string destination, string origin, int numSeats)
        {
            if (numFlights < maxFlights)
            {
                int flightNum = numFlights + 1;
                fList[numFlights] = new Flight(flightNum, destination, origin, numSeats);
                numFlights++;
                
                Console.WriteLine("\nFlight added! \nFlight ID: " + flightNum + "\n");

            }
            
        }

        public string viewAllFlights()
        {
            string s = "--- Flight List ---";
            for (int i = 0; i < numFlights; i++)
            {
                s += fList[i].toString() + "\n";
            }
            return s;
        }

        public string viewFlight(int flightNum)
        {
            string s = " ";
            for (int i = 0; i < numFlights; i++)
            {
                int flight = fList[i].getFlightNum();
                if (flight == flightNum)
                {
                    s = fList[i].toString();
                }
            }
            return s;
            
        }

        public Flight getFlight(int flightNum)
        {
            Flight temp = null;
            for(int i = 0; i < numFlights; i++)
            {
                if(flightNum <= numFlights && flightNum > 0)
                {
                    int flight = fList[i].getFlightNum();
                    if(flight == flightNum)
                    {
                        temp = fList[i];
                    }
                }
            }
            return temp;
        }

        public int findPositionByID(int flightNum)
        {
            for (int i = 0; i < numFlights; i++)
            {
                if (flightNum == fList[i].getFlightNum()) { return i; }
            }
            return -1;
        }
        public bool removeFlight(int flightNum)
        {
            int result = findPositionByID(flightNum);
            if (result == -1) { return false; }
            else
            {
                Flight temp = fList[numFlights - 1];
                fList[numFlights - 1] = fList[result];
                fList[result] = temp;
                numFlights--;
                Console.WriteLine("Flight removed! \n");

            }
            return true;
        }
    }
}

    

