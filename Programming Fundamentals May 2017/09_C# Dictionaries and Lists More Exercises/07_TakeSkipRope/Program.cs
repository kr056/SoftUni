using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_TakeSkipRope
{
    class Program
    {
        static void Main(string[] args)
        {

            string line = Console.ReadLine();

            var searchForNumbers = line.ToCharArray();

            var digits = searchForNumbers.Where(a => char.IsDigit(a))
                .Select(a => int.Parse(a.ToString())).ToList();

            var letters = searchForNumbers.Where(a => !char.IsDigit(a)).ToList();

            var evenList = new List<int>();
            var oddList = new List<int>();

            evenList = digits.Where((x, index) => index % 2 == 0).ToList();
            oddList = digits.Where((x, index) => index % 2 == 1).ToList();

            string finalMessage = String.Empty;
            int totalSkip = 0;
            for (int i = 0; i < evenList.Count; i++)
            {
                int takeCount = evenList[i];
                int skipCount = oddList[i];

                finalMessage += new string(letters.Skip(totalSkip).Take(takeCount).ToArray());
                totalSkip += takeCount + skipCount;
            }

            Console.WriteLine(finalMessage);
        }
    }
}
