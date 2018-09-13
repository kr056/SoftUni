using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_CountSubstringOccurences
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine().ToLower();

            var wordToCheck = Console.ReadLine().ToLower();

            var substringCount = 0;

            int index = input.IndexOf(wordToCheck);

            while (index != -1)
            {
                substringCount++;
                index = input.IndexOf(wordToCheck, index + 1);
            }

            Console.WriteLine(substringCount);


        }
    }
}
