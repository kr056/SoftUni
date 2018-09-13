using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_SoftUniKaraoke
{
    class Program
    {
        static void Main(string[] args)
        {
            var participants = Console.ReadLine().Split(',')
                         .Select(x => x.Trim())
                         .Where(x => !string.IsNullOrWhiteSpace(x))
                         .ToArray();

            var songs = Console.ReadLine().Split(',')
                        .Select(x => x.Trim())
                        .Where(x => !string.IsNullOrWhiteSpace(x))
                        .ToArray();

            var input = Console.ReadLine();

            var karaokeInfo = new Dictionary<string, SortedSet<string>>();

            while (input != "dawn")
            {
                var tokens = input.Split(',')
                        .Select(x => x.Trim())
                        .Where(x => !string.IsNullOrWhiteSpace(x))
                        .ToArray();

                var participant = tokens[0];
                var song = tokens[1];
                var award = tokens[2];

                var valid = participants.Contains(participant)
                    && songs.Contains(song);
                if (valid)
                {
                    if (!karaokeInfo.ContainsKey(participant))
                    {
                        karaokeInfo[participant] = new SortedSet<string>();
                    }
                    karaokeInfo[participant].Add(award);
                }


                input = Console.ReadLine();
            }
            karaokeInfo = karaokeInfo
                .OrderByDescending(a => a.Value.Count())
                .ThenBy(a => a.Key).ToDictionary(d=>d.Key,c=>c.Value);

            if (karaokeInfo.Count != 0)
            {
                foreach (var item in karaokeInfo)
                {
                    Console.WriteLine($"{item.Key}: {item.Value.Count()} awards");
                    foreach (var itemAward in item.Value)
                    {
                        Console.WriteLine($"--{itemAward}");
                    }
                }
            }

            else
            {
                Console.WriteLine("No awards");
            }

        }
    }
}
