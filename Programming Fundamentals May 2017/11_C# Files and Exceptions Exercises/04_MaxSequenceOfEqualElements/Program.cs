using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_MaxSequenceOfEqualElements
{
    class Program
    {
        static void Main(string[] args)
        {
            var arr = File.ReadAllText("input.txt").

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
                var result = arr[i] + " ";
                File.AppendAllText("output.txt", result);
            }
        }
    }
}
