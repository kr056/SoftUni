using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_EmailMe
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine().Split('@');

            var before = input[0].ToCharArray();
            var after = input[1].ToCharArray();

            var result = before.Sum(x => (int)x) - after.Sum(y => (int)y);

            if (result >= 0)
            {
                Console.WriteLine("Call her!");
            }
            else
            {
                Console.WriteLine("She is not the one.");
            }

        }
    }
}
