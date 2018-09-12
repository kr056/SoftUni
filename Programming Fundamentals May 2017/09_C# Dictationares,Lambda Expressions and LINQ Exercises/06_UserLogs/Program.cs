using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_UserLogs
{
    class Program
    {
        static void Main(string[] args)
        {
            var userLog = new SortedDictionary<string, Dictionary<string, int>>();

            var line = Console.ReadLine();



            while (line != "end")
            {

                var tokens = line.Split(' ');

                string ip = tokens[0].Substring(3, tokens[0].Length - 3);

                var userName = tokens[2].Substring(5, tokens[2].Length - 5);

                if (!userLog.ContainsKey(userName))
                {
                    userLog[userName] = new Dictionary<string, int>();

                }
                if (userLog[userName].ContainsKey(ip))
                {
                    userLog[userName][ip]++;
                }
                else
                {
                    userLog[userName][ip] = 1;
                }

                line = Console.ReadLine();

            }

            foreach (var user in userLog)
            {
                Console.WriteLine($"{user.Key}: ");
                foreach (var log in user.Value)
                {
                    if (log.Key != user.Value.Keys.Last())
                    {
                        Console.Write($"{log.Key} => {log.Value}, ");
                    }
                    else
                    {
                        Console.WriteLine($"{log.Key} => {log.Value}.");
                    }
                }
            }
        }
    }
}

