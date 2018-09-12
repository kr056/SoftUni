using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MathPower
{
    class Program
    {
        static void Main(string[] args)
        {
            double number = double.Parse(Console.ReadLine());
            double power = double.Parse(Console.ReadLine());
            double pow = CalcPower(number, power);
            Console.WriteLine(pow);

        }

        static double CalcPower(double number, double power)
        {

            double pow = Math.Pow(number, power);

            return pow;
        }
    }
}
