using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _01_Censorship
{
    class Program
    {
        static void Main(string[] args)
        {

            var wordToCensor = Console.ReadLine();
            var input = Console.ReadLine();

            var fillteredInput = Regex.Replace(input, $@"{wordToCensor}", new string('*', wordToCensor.Length));

            Console.WriteLine(fillteredInput);

        }
    }
}
