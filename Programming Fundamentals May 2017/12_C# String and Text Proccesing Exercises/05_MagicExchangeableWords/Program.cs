using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_MagicExchangeableWords
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine().Split();

            var word1 = input[0];
            var word2 = input[1];
            var result = AreExchangeable(word1, word2);

            if (result)
            {
                Console.WriteLine("true");
            }
            else
            {
                Console.WriteLine("false");
            }

        }

        static bool AreExchangeable(string word1, string word2)
        {
            var distinctedWord1 = word1.Distinct().ToArray();
            var distinctedWord2 = word2.Distinct().ToArray();
            if (distinctedWord1.Length != distinctedWord2.Length)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
}
