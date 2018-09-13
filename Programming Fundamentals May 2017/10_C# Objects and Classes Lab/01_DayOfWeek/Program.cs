using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_DayOfWeek
{
    class Program
    {
        static void Main(string[] args)
        {

            var dayOfWeek = Console.ReadLine().Split('-').Select(int.Parse).ToArray();

            DateTime dt = new DateTime(dayOfWeek[2], dayOfWeek[1], dayOfWeek[0]);
            Console.WriteLine(dt.DayOfWeek);

        }
    }
}
