using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_MinerTask
{
    class Program
    {
        static void Main(string[] args)
        {

            var output = new Dictionary<string, decimal>();

            var resource = String.Empty;
            decimal quantity = 0;

            var i = 0;
            while (true)
            {

                i++;
                if (i % 2 == 1)
                {
                    resource = Console.ReadLine();
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
                    quantity = decimal.Parse(Console.ReadLine());
                    output[resource] += quantity;
                }
                if (resource == "stop")
                {
                    break;
                }

            }

            foreach (var pair in output)
            {
                if (pair.Key != "stop")
                {
                    Console.WriteLine("{0} -> {1}", pair.Key, pair.Value);

                }
            }

        }
    }
}
