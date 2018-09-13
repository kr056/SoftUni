using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_MorseCodeUpgraded
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = Console.ReadLine().Split('|');

            var equal = new List<int>();

            var count1 = 0;
            var count0 = 0;

            var totalSum = 0;
            var seqLength = 1;

            var resultString = new StringBuilder();

            for (int i = 0; i < input.Length; i++)
            {
                var str = input[i].ToCharArray();

                for (int j = 0; j < str.Length; j++)
                {

                    if (j < str.Length - 1)
                    {
                        if (str[j] == str[j + 1])
                        {
                            seqLength++;
                        }
                        else
                        {
                            if (seqLength > 1)
                            {
                                equal.Add(seqLength);
                            }
                            seqLength = 1;
                        }
                    }

                    if (j == str.Length - 1 && seqLength > 1)
                    {
                        equal.Add(seqLength);
                    }

                    if (str[j] == '0')
                    {
                        count0++;
                    }
                    else if (str[j] == '1')
                    {
                        count1++;
                    }

                }

                totalSum = equal.Sum() + count0 * 3 + count1 * 5;
                resultString.Append((char)totalSum);
                equal.Clear();
                totalSum = 0;
                count0 = 0;
                count1 = 0;
                seqLength = 1;
            }
            Console.WriteLine(resultString);
        }
    }
}
