using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IntervalOfNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int finish = int.Parse(Console.ReadLine());

            if (start < finish)
            {
                for (int i = start; i <= finish; i++)
                {
                    Console.WriteLine(i);
                }
            }
            else if (start > finish)
            {
                for (int i = finish; i <= start; i++)
                {
                    Console.WriteLine(i);
                }
            }

        }
    }
}
