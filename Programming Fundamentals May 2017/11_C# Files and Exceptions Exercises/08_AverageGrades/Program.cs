using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_AverageGrades
{
    class Student
    {
        public string Name { get; set; }
        public double[] Grades { get; set; }
        public double AverageGrade => this.Grades.Average();
    }

    class Program
    {
        static void Main(string[] args)
        {
            var students = new List<Student>();

            var input = File.ReadAllLines("input2.txt");

            var n = int.Parse(input[0]);

            for (int i = 1; i <= n; i++)
            {
                var readArr = input.Skip(i).First().Split();

                var name = readArr[0];
                var grades = readArr
                    .Skip(1)
                    .Select(double.Parse)
                    .ToArray();

                var student = new Student
                {

                    Name = name,
                    Grades = grades
                };

                students.Add(student);

            }

            students = students
                .Where(a => a.AverageGrade >= 5.00)
                .OrderBy(a => a.Name)
                .ThenByDescending(a => a.AverageGrade)
                .ToList();

            foreach (var student in students)
            {
                File.AppendAllText("output2.txt", $"{student.Name} -> {student.AverageGrade:F2}" + Environment.NewLine);
            }
        }
    }




}
