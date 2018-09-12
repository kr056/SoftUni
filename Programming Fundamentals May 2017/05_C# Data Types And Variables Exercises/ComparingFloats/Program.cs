using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComparingFloats
{
    class Program
    {
        static void Main(string[] args)
        {
            double number1 = double.Parse(Console.ReadLine());
            double number2 = double.Parse(Console.ReadLine());

            bool equal = false;
            double diff = Math.Abs((number1 - number2));

            if (diff < 0.000001)
            {
                equal = true;
            }

            Console.WriteLine(equal);

        }
    }
}
