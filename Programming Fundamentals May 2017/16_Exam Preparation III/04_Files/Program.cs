using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _04_Files
{
    class Program
    {
        static void Main(string[] args)
        {

            var filesInfo = new Dictionary<string, Dictionary<string, long>>();

            var filesCount = int.Parse(Console.ReadLine());

            for (int i = 0; i < filesCount; i++)
            {
                var file = Console.ReadLine();

                var tokens = file.Split(new char[] { '\\' }, StringSplitOptions.RemoveEmptyEntries);

                var root = tokens[0];
                var fileAndSize = file.Substring(file.LastIndexOf('\\') + 1).Split(';');
                var fileName = fileAndSize[0];
                var fileSize = fileAndSize[1];

                if (!filesInfo.ContainsKey(root))
                {
                    filesInfo[root] = new Dictionary<string, long>();
                    if (!filesInfo[root].ContainsKey(fileName))
                    {
                        filesInfo[root][fileName] = long.Parse(fileSize);
                    }
                }

                filesInfo[root][fileName] = long.Parse(fileSize);

            }

            var extensionAndRoot = Console.ReadLine().Split();
            var extension = extensionAndRoot[0];
            var searchRoot = extensionAndRoot[2];
            var yes = false;

            foreach (var fileInfo in filesInfo)
            {
                if (fileInfo.Key == searchRoot)
                {
                    foreach (var info in fileInfo.Value.OrderByDescending(a => a.Value).ThenBy(x => x.Key))
                    {
                        var db = info.Key.Split('.').Last();

                        if (db == extension)
                        {
                            yes = true;
                            Console.WriteLine($"{info.Key} - {info.Value} KB");
                        }
                    }
                }
            }

            if (!yes)
            {
                Console.WriteLine("No");
            }

        }
    }
}
