using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringsAndObjects
{
    class Program
    {
        static void Main(string[] args)
        {

            string word1 = "Hello";
            string word2 = "World";

            object combo = word1 + " " + word2;

            string finalWord = Convert.ToString(combo);

            Console.WriteLine(finalWord);

        }
    }
}
