package com.example.user.taxhelper;

/**
 * Created by User on 8/20/2018.
 */

public class CalculateTax {
    public CalculateTax(){}

    static double round(double x)
    {
        double ans = ((int)(x * 100))/100.0;
        return ans;
    }

    static IT_Details individual_2018_19(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }
        if(tempsalary > 250000)
        {
            range2 = tempsalary - 250000;
            tempsalary = 250000;
        }
        range1 = tempsalary;

        tax = 0 * range1 + 0.05 * range2 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        if(salary > 250000 && salary <= 350000)
        {
            if(tax >= 2500)
            {
                cess = 0.04 * (tax - 2500);
                rebate = 2500;
            }
            else
            {
                rebate = tax;
                cess = 0;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;

        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }

    static IT_Details senior_2018_19(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }
        if(tempsalary > 300000)
        {
            range2 = tempsalary - 300000;
            tempsalary = 300000;
        }
        range1 = tempsalary;

        tax = 0 * range1 + 0.05 * range2 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        if(salary > 250000 && salary <= 350000)
        {
            if(tax >= 2500)
            {
                cess = 0.04 * (tax - 2500);
                rebate = 2500;
            }
            else
            {
                rebate = tax;
                cess = 0;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;
        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }

    static IT_Details supersenior_2018_19(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }

        range1 = tempsalary;

        tax = 0 * range1 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;
        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }

    static IT_Details individual_2017_18(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }
        if(tempsalary > 250000)
        {
            range2 = tempsalary - 250000;
            tempsalary = 250000;
        }
        range1 = tempsalary;

        tax = 0 * range1 + 0.05 * range2 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        if(salary > 250000 && salary <= 350000)
        {
            if(tax >= 2500)
            {
                cess = 0.04 * (tax - 2500);
                rebate = 2500;
            }
            else
            {
                rebate = tax;
                cess = 0;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;

        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }

    static IT_Details senior_2017_18(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }
        if(tempsalary > 300000)
        {
            range2 = tempsalary - 300000;
            tempsalary = 300000;
        }
        range1 = tempsalary;

        tax = 0 * range1 + 0.05 * range2 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        if(salary > 250000 && salary <= 350000)
        {
            if(tax >= 2500)
            {
                cess = 0.04 * (tax - 2500);
                rebate = 2500;
            }
            else
            {
                rebate = tax;
                cess = 0;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;
        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }

    static IT_Details supersenior_2017_18(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }

        range1 = tempsalary;

        tax = 0 * range1 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;
        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }

    static IT_Details individual_2016_17(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }
        if(tempsalary > 250000)
        {
            range2 = tempsalary - 250000;
            tempsalary = 250000;
        }
        range1 = tempsalary;

        tax = 0 * range1 + 0.05 * range2 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        if(salary > 250000 && salary <= 350000)
        {
            if(tax >= 2500)
            {
                cess = 0.04 * (tax - 2500);
                rebate = 2500;
            }
            else
            {
                rebate = tax;
                cess = 0;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;

        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }

    static IT_Details senior_2016_17(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }
        if(tempsalary > 300000)
        {
            range2 = tempsalary - 300000;
            tempsalary = 300000;
        }
        range1 = tempsalary;

        tax = 0 * range1 + 0.05 * range2 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        if(salary > 250000 && salary <= 350000)
        {
            if(tax >= 2500)
            {
                cess = 0.04 * (tax - 2500);
                rebate = 2500;
            }
            else
            {
                rebate = tax;
                cess = 0;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;
        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }

    static IT_Details supersenior_2016_17(double salary)
    {
        double tax = 0,cess = 0,surcharge = 0,rebate= 0,totaltax = 0,range1 = 0,range2 = 0,range3 = 0,range4 = 0,range5 = 0,range6 = 0,tempsalary = salary;
        if(tempsalary > 10000000)
        {
            range6 = tempsalary - 10000000;
            tempsalary = 10000000;
        }
        if(tempsalary > 5000000)
        {
            range5 = tempsalary - 5000000;
            tempsalary = 5000000;
        }
        if(tempsalary > 1000000)
        {
            range4 = tempsalary - 1000000;
            tempsalary = 1000000;
        }
        if(tempsalary > 500000)
        {
            range3 = tempsalary - 500000;
            tempsalary = 500000;
        }

        range1 = tempsalary;

        tax = 0 * range1 + 0.2 * range3 + 0.3 * range4 + 0.3 * range5 + 0.3 * range6;
        cess = 0.04 * tax;
        if (salary > 10000000)
        {
            surcharge = 0.15 * tax;
            if(surcharge > range6)
            {
                surcharge = 0.1 * tax;
            }
        }
        else
        if (salary > 5000000)
        {
            surcharge = 0.1 * tax;
            if(surcharge > range5)
            {
                surcharge = 0.7 * range5;
            }
        }

        totaltax = (tax + cess + surcharge) - rebate;
        tax = round(tax);
        cess = round(cess);
        surcharge = round(surcharge);
        rebate = round(rebate);
        totaltax = round(totaltax);
        IT_Details res = new IT_Details(tax,cess,surcharge,rebate,totaltax);
        return res;
    }
}
