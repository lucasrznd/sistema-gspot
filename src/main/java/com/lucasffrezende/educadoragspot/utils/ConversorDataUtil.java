package com.lucasffrezende.educadoragspot.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

public class ConversorDataUtil {

    public static String dataNomeArquivo() {
        Locale local = new Locale("pt", "BR");
        Calendar calendar = Calendar.getInstance();
        DateFormat formatarMes = new SimpleDateFormat("MMM", local);

        String mesAno = formatarMes.format(calendar.getTime()) + LocalDate.now().getYear();
        return mesAno;
    }

}
