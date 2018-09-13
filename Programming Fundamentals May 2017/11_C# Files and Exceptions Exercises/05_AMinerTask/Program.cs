using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_AMinerTask
{
    class Program
    {
        static void Main(string[] args)
        {
            var output = new Dictionary<string, decimal>();

            var input = File.ReadAllLines("input.txt");

            var resource = String.Empty;
            decimal quantity = 0;

            var i = 0;
            while (true)
            {

                if (input[i] == "stop")
                {
                    break;
                }

                if (i % 2 == 0)
                {
                    resource = input[i];
                    if (output.ContainsKey(resource))
                    {

                    }
                    else
                    {
                        output[resource] = 0;

                    }
                }
                else
                {
                    quantity = decimal.Parse(input[i]);
                    output[resource] += quantity;
                }

                i++;

            }

            foreach (var pair in output)
            {
                if (pair.Key != "stop")
                {
                    var key = pair.Key;
                    var value = pair.Value;
                    var print = key + " -> " + value;
                    File.AppendAllText("output.txt", print + Environment.NewLine);
                }
            }
        }
    }
}
