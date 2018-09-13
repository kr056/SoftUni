using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Office.Intertop.Excel;


namespace _06_ExcellentKnowledge
{
    class Program
    {
        static void Main(string[] args)
        {
            Application xlApp = new Application();
            Workbook xlWorkbook = xlApp.Workbooks.Open("sample_table.xlsx");
            Worksheet xlWorksheet = xlWorksheets.Sheets[1];
            Range xlRange = xlWorksheet.UsedRange;

            for (int i = 1; i <= 5; i++)
            {
                for (int j = 1; j <= 5; j++)
                {
                    if (j == 1 && i != 1)
                    {
                        Console.WriteLine();
                    }

                    Console.Write(xlRange.Cells[i, j].Value + "|");
                }
            }
        }
    }
}


