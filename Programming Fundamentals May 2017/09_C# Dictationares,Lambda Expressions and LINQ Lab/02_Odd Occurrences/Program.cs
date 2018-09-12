using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_Odd_Occurrences
{
    class Program
    {
        static void Main(string[] args)
        {
            var words = Console.ReadLine().ToLower().Split().ToArray();

            var result = new Dictionary<string, int>();

            var final = new List<string>();

            foreach (var word in words)
            {
                if (result.ContainsKey(word))
                {
                    result[word]++;
                }
                else
                {
                    result[word] = 1;
                }
            }

            foreach (var pair in result)
            {
                if (pair.Value % 2 == 1)
                {
                    final.Add(pair.Key);
                }
            }

            Console.WriteLine(string.Join(", ", final));
        }
    }
}
