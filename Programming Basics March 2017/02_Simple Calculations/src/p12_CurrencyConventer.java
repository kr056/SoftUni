import java.util.Scanner;

public class p12_CurrencyConventer {
    public static void main(String[] args){

        Scanner console = new Scanner(System.in);

        double currency = Double.parseDouble(console.nextLine());
        String ivalue = console.nextLine();
        String ovalue = console.nextLine();


       switch(ivalue){

           case "BGN":
             switch(ovalue){
                 case "GBP":
                     double result=currency/2.53405;
                     System.out.printf("%.2f GBP",result);
                     break;

                 case "EUR":
                     double result1=currency/1.95583;
                     System.out.printf("%.2f EUR",result1);
                     break;
                 case "USD":
                     double result2=currency/1.795493;
                     System.out.printf("%.2f USD",result2);
                     break;
             }
       }

        switch(ivalue){

            case "GBP":
                switch(ovalue){
                    case "BGN":
                        double result=currency*2.53405;
                        System.out.printf("%.2f BGN",result);
                        break;

                    case "EUR":
                        double result1=currency*2.53405;
                        double converttoEUR=result1/1.95583;
                        System.out.printf("%.2f EUR",converttoEUR);
                        break;
                    case "USD":
                        double result2=currency*2.53405;
                        double converttoUSD=result2/1.795493;
                        System.out.printf("%.2f USD",converttoUSD);
                        break;
                }
        }

        switch(ivalue){

            case "EUR":
                switch(ovalue){
                    case "BGN":
                        double result=currency*1.95583;
                        System.out.printf("%.2f BGN",result);
                        break;

                    case "GBP":
                        double result1=currency*1.95583;
                        double converttoGBP=result1/2.53405;
                        System.out.printf("%.2f GBP",converttoGBP);
                        break;
                    case "USD":
                        double result2=currency*1.95583;
                        double converttoUSD=result2/1.795493;
                        System.out.printf("%.2f USD",converttoUSD);
                        break;
                }
        }
        switch(ivalue){

            case "USD":
                switch(ovalue){
                    case "BGN":
                        double result=currency*1.79549;
                        System.out.printf("%.2f BGN",result);
                        break;

                    case "EUR":
                        double result1=currency*1.79549;
                        double converttoEUR=result1/1.95583;
                        System.out.printf("%.2f EUR",converttoEUR);
                        break;
                    case "GBP":
                        double result2=currency*1.79549;
                        double converttoGBP=result2/2.53405;
                        System.out.printf("%.2f USD",converttoGBP);
                        break;
                }
        }

    }
}
