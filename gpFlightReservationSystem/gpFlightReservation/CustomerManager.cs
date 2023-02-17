using System;

namespace gpFlightReservation
{
    public class CustomerManager
    {
        private int numCustomers;
        private int maxCustomers;
        private Customer[] customerList;

        public CustomerManager()
        {
            numCustomers = 0;
            maxCustomers = 200;
            customerList = new Customer[maxCustomers];
        }

        public void addCustomer(string custFirstName, string custLastName, string custPhoneNum, string custEmail, int numBookings)
        {
            if (numCustomers < maxCustomers)
            {
                int custID = numCustomers + 1;
                Customer temp = new Customer(custID, custFirstName, custLastName, custPhoneNum, custEmail, numBookings);
                customerList[numCustomers] = temp;
                numCustomers++;
                Console.WriteLine("\nCustomer added! \nCustomer ID: " + custID + "\n");
            }
        }

        public int findPositionByID(int custID)
        {
            for (int i = 0; i < numCustomers; i++)
            {
                if (custID == customerList[i].getCustID()) { return i; }
            }
            return -1;
        }
        public bool removeCustomer(int custID)
        {
            int result = findPositionByID(custID);
            if (result == -1) { return false; }
            else
            {
                Customer temp = customerList[numCustomers - 1];
                customerList[numCustomers - 1] = customerList[result];
                customerList[result] = temp;
                numCustomers--;
                Console.WriteLine("Customer removed! \n");

            }
            return true;
        }

        public Customer getCustomer(int custID)
        {
            Customer temps = null;
            for (int i = 0; i < numCustomers; i++)
            {
                if(custID <= numCustomers && custID > 0)
                {
                    int cust = customerList[i].getCustID();
                    if (cust == custID)
                    {
                        temps = customerList[i];

                    }
                }
            }
            return temps;
            
        }

        public string printAllCustomers()
        {
            string s = "--- Customer List ---";
            for (int i = 0; i < numCustomers; i++)
            {
                s += customerList[i].toString() + "\n";
            }
            return s;
        }
        
    }
}

