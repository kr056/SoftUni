using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MaxSequenceOfEqualElements
{
    class Program
    {
        static void Main(string[] args)
        {

            var arr = Console.ReadLine().
                Split(' ').Select(int.Parse).ToArray();


            var startIndex = 0;
            var seqLength = 1;

            var bestStartIndex = 0;
            var bestSeqLength = 0;

            for (int i = 1; i < arr.Length; i++)
            {

                if (arr[i] == arr[i - 1])
                {
                    seqLength++;
                    if (seqLength > bestSeqLength)
                    {
                        bestStartIndex = startIndex;
                        bestSeqLength = seqLength;
                    }
                }
                else
                {
                    startIndex = i;
                    seqLength = 1;
                }





            }
            for (int i = bestStartIndex; i < bestStartIndex + bestSeqLength; i++)
            {
                Console.Write(arr[i] + " ");
            }
            Console.WriteLine();

        }
    }
}
