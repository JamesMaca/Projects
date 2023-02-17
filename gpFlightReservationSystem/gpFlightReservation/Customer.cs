using System;
namespace gpFlightReservation
{
    public class Customer
    {
        public int custID;
        private string custFirstName;
        private string custLastName;
        private string custPhoneNum;
        private string custEmail;
        private int numBookings;

        public Customer(int custID, string custFirstName, string custLastName, string custPhoneNum, string custEmail, int numBookings)
        {
            this.custID = custID;
            this.custFirstName = custFirstName;
            this.custLastName = custLastName;
            this.custPhoneNum = custPhoneNum;
            this.custEmail = custEmail;
            this.numBookings = numBookings;
        }

        public int getCustID()
        {
            return custID;
        }

        public virtual string getFirstName()
        {
            return custFirstName;
        }

        public virtual string getLastName()
        {
            return custLastName;
        }
        public string getCustPhoneNum()
        {
            return custPhoneNum;
        }
        public string getCustEmail()
        {
            return custEmail;
        }

        public int getNumBookings()
        {
            return numBookings;
        }
        public int setNumBookings()
        {
            numBookings =  numBookings + 1;
            return numBookings;
        }


        public virtual string toString()
        {
            return "\n Customer ID: " + custID +
                   "\n Customer Name: " + custFirstName + custLastName +
                   "\n Customer Phone Number: " + custPhoneNum +
                   "\n Customer Email: " + custEmail +
                   "\n Number of Bookings: " + numBookings;
        }


    }
}


