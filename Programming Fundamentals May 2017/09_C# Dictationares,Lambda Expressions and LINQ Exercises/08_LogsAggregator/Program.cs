using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_LogsAggregator
{
    class Program
    {
        static void Main(string[] args)
        {

            var n = int.Parse(Console.ReadLine());

            var logsInfo = new SortedDictionary<string, SortedDictionary<string, int>>();

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine();

                var tokens = input.Split();

                var ip = tokens[0];
                var name = tokens[1];
                var duration = int.Parse(tokens[2]);

                if (!logsInfo.ContainsKey(name))
                {
                    logsInfo[name] = new SortedDictionary<string, int>();
                }
                if (!logsInfo[name].ContainsKey(ip))
                {
                    logsInfo[name][ip] = 0;
                }
                logsInfo[name][ip] += duration;


            }

            foreach (var log in logsInfo)
            {
                var name1 = log.Key;
                var ipDur = log.Value;

                var totalDuration = ipDur.Sum(a => a.Value);

                var ips = ipDur.Select(a => a.Key).ToArray();

                Console.WriteLine($"{name1}: {totalDuration} [{string.Join(", ", ips)}]");
            }

        }
    }
}
