using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Elevator
{
    class Program
    {
        static void Main(string[] args)
        {

            decimal persons = decimal.Parse(Console.ReadLine());
            decimal capacity = decimal.Parse(Console.ReadLine());

            decimal courses = (persons / capacity);
            Console.WriteLine(Math.Ceiling(courses));

        }
    }
}
