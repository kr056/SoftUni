using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HouseBuilder
{
    class Program
    {
        static void Main(string[] args)
        {

            long sbyteValue = long.Parse(Console.ReadLine());
            long intValue = long.Parse(Console.ReadLine());

            if (sbyteValue >= sbyte.MinValue && sbyteValue <= sbyte.MaxValue)
            {
                sbyteValue = sbyteValue * 4;
            }
            else
            {
                sbyteValue = sbyteValue * 10;

            }
            if (intValue >= 128 && intValue <= int.MaxValue)
            {
                intValue = intValue * 10;
            }
            else
            {
                intValue = intValue * 4;

            }

            long total = intValue + sbyteValue;
            Console.WriteLine(total);
        }
    }
}
