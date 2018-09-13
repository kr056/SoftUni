using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_RandomizeWords
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] words = Console.ReadLine().Split();

            Random rnd = new Random();

            for (int pos1 = 0; pos1 < words.Length; pos1++)
            {

                int pos2 = rnd.Next(words.Length);

                var oldWord = "";
                oldWord = words[pos1];
                words[pos1] = words[pos2];
                words[pos2] = oldWord;

            }

            Console.WriteLine(string.Join("\n", words));

        }
    }
}
