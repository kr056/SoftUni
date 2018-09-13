using System;
using System.Text.RegularExpressions;

public class Hideout
{
    public static void Main()
    {
        var map = Console.ReadLine();

        var firstCharIndex = 0;
        var foundStringCount = 0;

        var findHideout = false;

        while (!findHideout)
        {
            var clueData = Console.ReadLine()
                .Split();

            var searchedCharacter = clueData[0];
            var minimumCount = int.Parse(clueData[1]);

            var pattern = $@"\{searchedCharacter}{{{minimumCount},}}";
            var match = Regex.Match(map, pattern);

            if (match.Success)
            {
                firstCharIndex = match.Index;
                foundStringCount = match.Length;

                findHideout = true;
                break;
            }
        }

        Console.WriteLine($"Hideout found at index {firstCharIndex} and it is with size {foundStringCount}!");
    }
}