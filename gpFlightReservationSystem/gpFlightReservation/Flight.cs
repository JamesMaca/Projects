using System;
namespace gpFlightReservation
{
    public class Flight
    {
        public int flightNum;
        public string destination;
        public string origin;
        public int numSeats;
        public Customer[] passengers;

        public Flight(int flightNum, string destination, string origin, int numSeats)
        {
            this.flightNum = flightNum;
            this.destination = destination;
            this.origin = origin;
            this.numSeats = numSeats;
            passengers = new Customer[numSeats];
            
        }

        public bool addCust(Customer cust)
        {
            int i;
            for(i = 0; i < passengers.Length; i++)
            {
                if (passengers[i] == null)
                {
                    passengers[i] = cust;
                    cust.setNumBookings();
                    return true;
                } 
            }
            return false;

        }

        public virtual int getFlightNum()
        {
            return flightNum;
        }

        public string getDest()
        {
            return destination;
        }

        public string getOrigin()
        {
            return origin;
        }

        public int getNumSeats()
        {
            return numSeats;
        }

        public virtual string toString()
        {
            string p = "";
            string s = "\n Flight Number: " + flightNum;
            s += "\n Destination: " + destination;
            s += "\n Origin: " + origin;
            s += "\n Seats: " + numSeats;
            for (int i = 0; i < passengers.Length; i++)
            {
                if (passengers[i] != null)
                {
                    p += "\n   " + passengers[i].getFirstName() +
                         " " + passengers[i].getLastName();
                }
                
            }
            s += "\n Passengers: " + p;
            return s;
        }
    }
}

