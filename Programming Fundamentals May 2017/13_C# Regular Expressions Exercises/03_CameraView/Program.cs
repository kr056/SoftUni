using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _03_CameraView
{
    class Program
    {
        static void Main(string[] args)
        {
            var result = new List<string>();

            var nums = Console.ReadLine().Split().Select(int.Parse).ToArray();
            var skip = nums[0];
            var take = nums[1];

            var pattern = new Regex(@"(?<=\|<)(?<text>\w+)");
            var input = Console.ReadLine();

            var matches = pattern.Matches(input)
                .Cast<Match>()
                .Select(a => a.Groups["text"].Value)
                .ToArray();

            foreach (var item in matches)
            {
                var camera = String.Empty;
                if (item.Length < skip + take)
                {
                    camera = item.Substring(skip, item.Length - skip);
                    result.Add(camera);

                }
                else
                {
                    camera = item.Substring(skip, take);
                    result.Add(camera);
                }

            }

            Console.WriteLine(string.Join(", ", result));
        }
    }
}
