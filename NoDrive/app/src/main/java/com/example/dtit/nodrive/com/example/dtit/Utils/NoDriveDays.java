package com.example.dtit.nodrive.com.example.dtit.Utils;

import android.util.Log;

import com.example.dtit.nodrive.com.example.dtit.Entidad.NoManeja;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dtit on 23/02/16.
 */
public class NoDriveDays {

  /*  public static int ObtieneAnoAuto(int anio)
    {
        Calendar now = Calendar.getInstance();
        int YearNow = now.get(Calendar.YEAR);
        int anioAuto = YearNow - anio;

        //Log.e("año", String.valueOf(anioAuto));

        return anioAuto;
    }
*/

    public static int ObtieneUltimoDigito(String placa)
    {

        int n = placa.length();
        char UltimoCaracter= placa.charAt(n - 1);
        int lastdig= Integer.parseInt(""+UltimoCaracter);
        //Log.e("ultimodihic", String.valueOf(lastdig));
        return lastdig;


    }

    public static NoManeja ObtieneDiasNomaneja(String placa)
    {
        //NoManeja nodrive = new NoManeja();
        NoManeja nodrive2 = new NoManeja();

        String  [][] emissionsTestingPeriodsPeriods = {{"Marzo - Abril", "1 Septiembre - 15 Octubre"},
                {"Abril - Mayo","1 Octubre - 15 Noviembre"},
                {"Mayo - Junio", "1 Noviembre - 15 Diciembre"},
                {"Junio - Julio", "1 Diciembre - 15 Enero"},
                {"Julio - Agosto", "15 Diciembre - 31 Enero"}};

        int ultimodigitoPlaca = ObtieneUltimoDigito(placa);
        //int getyear =  ObtieneAnoAuto(year);


        //color y dia
        if((ultimodigitoPlaca != 0))
            switch (ultimodigitoPlaca) {
                case 5:
                    nodrive2.setColor("Amarillo");
                    nodrive2.setDia("Lunes");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[0][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[0][1]);
                    break;
                case 6:
                    nodrive2.setColor("Amarillo");
                    nodrive2.setDia("Lunes");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[0][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[0][1]);

                    break;
                case 7:
                    nodrive2.setColor("Rosa");
                    nodrive2.setDia("Martes");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[1][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[1][1]);
                    break;
                case 8:
                    nodrive2.setColor("Rosa");
                    nodrive2.setDia("Martes");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[1][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[1][1]);
                    break;
                case 3:
                    nodrive2.setColor("Rojo");
                    nodrive2.setDia("Miercoles");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[2][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[2][1]);
                    break;
                case 4:
                    nodrive2.setColor("Rojo");
                    nodrive2.setDia("Miercoles");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[2][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[2][1]);
                    break;
                case 1:
                    nodrive2.setColor("Verde");
                    nodrive2.setDia("Jueves");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[3][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[3][1]);
                    break;
                case 2:
                    nodrive2.setColor("Verde");
                    nodrive2.setDia("Jueves");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[3][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[3][1]);
                    break;
                case 9:
                    nodrive2.setColor("Azul");
                    nodrive2.setDia("Viernes");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[4][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[4][1]);
                    break;
                case 0:
                    nodrive2.setColor("Azul");
                    nodrive2.setDia("Viernes");
                    nodrive2.setEtpFirsHalf(emissionsTestingPeriodsPeriods[4][0]);
                    nodrive2.setEtpSecondHalf(emissionsTestingPeriodsPeriods[4][1]);
                    break;

            }


        //tipo de carro
/*
        if(getyear > 0 && getyear < 9)
        {
            nodrive2.setClaseAuto("Zero");
        }
        else if (getyear >= 9 && getyear < 16)
        {
            nodrive2.setClaseAuto("One");
        }
        else
        {
            nodrive2.setClaseAuto("Two");
        }*/

        //restriccion sabado

        /*
        if((ultimodigitoPlaca % 2) == 0)
        {
            nodrive2.setRestricSabado("Par");
            nodrive2.setDescripcion("Segundo y cuarto sábado de cada mes descansan");
        }
        else
        {
            nodrive2.setRestricSabado("Impar");
            nodrive2.setDescripcion("Primer y tercer sábado de cada mes descansan");
        }
*/

        //comparativa
        /*

        if(nodrive2.getClaseAuto().equals("One"))
        {
            if (nodrive2.getRestricSabado().equals("Impar"))
            {
                nodrive2.setDescripcion("Primer y tercer sábado de cada mes descansan");
            }else
            {
                nodrive2.setDescripcion("Segundo y cuarto sábado de cada mes descansan");
            }
        }
        else if(nodrive2.getClaseAuto().equals("Two"))
        {
            nodrive2.setDescripcion("Dejan de circular todos los sábados");
        }
        else if(nodrive2.getClaseAuto().equals("Zero"))
        {
            nodrive2.setDescripcion("Siempre Circula");
        }*/


        return nodrive2;
    }


}
