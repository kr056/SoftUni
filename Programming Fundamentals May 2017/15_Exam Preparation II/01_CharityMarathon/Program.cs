using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_CharityMarathon
{
    class Program
    {
        static void Main(string[] args)
        {

            ulong marathonDaysCount = ulong.Parse(Console.ReadLine());
            ulong runnersCount = ulong.Parse(Console.ReadLine());
            ulong averageLapCount = ulong.Parse(Console.ReadLine());
            ulong trackLength = ulong.Parse(Console.ReadLine());
            ulong trackCapacity = ulong.Parse(Console.ReadLine());
            decimal moneyPerKm = decimal.Parse(Console.ReadLine());

            ulong totalMeters = 0;

            if (runnersCount > trackCapacity * marathonDaysCount)
            {
                totalMeters = trackCapacity * marathonDaysCount * averageLapCount * trackLength;
            }
            else
            {
                totalMeters = runnersCount * averageLapCount * trackLength;
            }

            ulong totalKm = totalMeters / 1000;
            decimal moneyRaised = moneyPerKm * totalKm;

            Console.WriteLine($"Money raised: {moneyRaised:f2}");

        }
    }
}
