using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _06_EmailStatistics
{
    class Program
    {
        static void Main(string[] args)
        {

            var emailsCount = int.Parse(Console.ReadLine());

            var pattern = @"^(?<username>[a-zA-Z]{5,})@(?<server>[a-z]{3,})(?<domain>((\.com)|(\.bg)|(\.org)))$";

            var stats = new Dictionary<string, List<string>>();

            for (int i = 0; i < emailsCount; i++)
            {
                var email = Console.ReadLine();
                var match = Regex.Match(email, pattern);

                if (match.Success)
                {
                    var username = match.Groups["username"].Value;
                    var domain = match.Groups["server"].Value + match.Groups["domain"].Value;

                    if (!stats.ContainsKey(domain))
                    {
                        stats[domain] = new List<string>();
                    }

                    if (!stats[domain].Contains(username))
                    {
                        stats[domain].Add(username);

                    }

                }

            }

            foreach (var item in stats.OrderByDescending(a => a.Value.Count))
            {
                var usernames = item.Value;
                Console.WriteLine($"{item.Key}:");
                foreach (var username in usernames)
                {
                    Console.WriteLine($"### {username}");
                }
            }

        }
    }
}
