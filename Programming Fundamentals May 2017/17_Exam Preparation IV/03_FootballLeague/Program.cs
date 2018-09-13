using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _03_FootballLeague
{
    class Program
    {
        static void Main(string[] args)
        {
            var key = Regex.Escape(Console.ReadLine());
            var pattern = string.Format(@"^.*(?:{0})(?<team1>[a-zA-Z]*)(?:{0}).* .*(?:{0})(?<team2>[a-zA-Z]*)(?:{0}).* (?<team1Score>\d+):(?<team2Score>\d).*$", key);

            var leagueInfo = new Dictionary<string, TeamInfo>();

            while (true)
            {
                var line = Console.ReadLine();

                if (line == "final")
                {
                    break;
                }

                var match = Regex.Match(line, pattern);

                var team1Name = new string(match.Groups["team1"].Value.ToUpper().Reverse().ToArray());
                var team2Name = new string(match.Groups["team2"].Value.ToUpper().Reverse().ToArray());

                var team1ScoredGoals = ulong.Parse(match.Groups["team1Score"].Value);
                var team2ScoredGoals = ulong.Parse(match.Groups["team2Score"].Value);

                if (!leagueInfo.ContainsKey(team1Name))
                {
                    leagueInfo[team1Name] = new TeamInfo();
                }

                if (!leagueInfo.ContainsKey(team2Name))
                {
                    leagueInfo[team2Name] = new TeamInfo();
                }

                leagueInfo[team1Name].ScoredGoals += team1ScoredGoals;
                leagueInfo[team2Name].ScoredGoals += team2ScoredGoals;

                if (team1ScoredGoals > team2ScoredGoals)
                {
                    leagueInfo[team1Name].Points += 3;
                }
                else if (team2ScoredGoals > team1ScoredGoals)
                {
                    leagueInfo[team2Name].Points += 3;
                }
                else
                {
                    leagueInfo[team1Name].Points += 1;
                    leagueInfo[team2Name].Points += 1;
                }

            }

            var leagueStanding = leagueInfo.OrderByDescending(a => a.Value.Points).ThenBy(b => b.Key)
                .ToArray();

            Console.WriteLine("League standings:");

            for (int i = 0; i < leagueStanding.Length; i++)
            {
                var currentStanding = leagueStanding[i];

                var place = i + 1;
                var teamName = currentStanding.Key;
                var points = currentStanding.Value.Points;

                Console.WriteLine($"{place}. {teamName} {points}");
            }

            var top3Goals = leagueStanding.OrderByDescending(a => a.Value.ScoredGoals).ThenBy(a => a.Key)
                .Take(3).ToArray();

            Console.WriteLine("Top 3 scored goals:");

            foreach (var pair in top3Goals)
            {
                var teamName = pair.Key;
                var scoredGoals = pair.Value.ScoredGoals;
                Console.WriteLine($"- {teamName} -> {scoredGoals}");
            }
        }
    }

    internal class TeamInfo
    {
        public int Points { get; set; }
        public ulong ScoredGoals { get; set; }
    }
}
