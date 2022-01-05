package com.intelix.service.GraphQLServices.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

/**
 * Clase util para convertir un BigDecimal a letras
 * 
 * @author Ricardo J. Carvajal F.
 */
@Component
public class NumberToletter {

    private final static int DIGITOS_POR_PERIODO = 6;

    private final static String MUY_GRANDE = "Número demasiado grande";

    private final static String LLON = "llón";

    private final static String LLONES = "llones";

    private final static String UN = "un";

    private final static String VEINTIUN = "veintiún";

    private final static String CIEN = "cien";

    private final static String MIL = "mil";

    private final static String[] UNIDADES = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete",
            "ocho", "nueve"};

    private final static String[] DIECIS = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis",
            "diecisiete", "dieciocho", "diecinueve"};

    private final static String[] VEINTIS = {"veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro",
            "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve"};

    private final static String[] DECENAS = {"ERROR", "diez", "veinte", "treinta", "cuarenta", "cincuenta",
            "sesenta", "setenta", "ochenta", "noventa"};

    private final static String[] CENTENAS = {"ERROR", "ciento", "doscientos", "trescientos", "cuatrocientos",
            "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};

    private final static String[] PERIODOS = {"ERROR", "mi", "bi", "tri", "quatri", "quinti", "sexti", "septi",
            "octi", "noni", "deci", "undeci", "duodeci", "tredeci", "cuatrodeci", "quindeci", "hexadeci",
            "septendeci", "octodeci", "novendeci", "viginti", "unviginti", "duoviginti", "treviginti",
            "cuatroviginti", "quinviginti", "sexviginti", "septenviginti", "octoviginti", "novemviginti",
            "triginti", "untriginti", "duotriginti", "tretriginti"};

    /**
     * Traduce un BigDecimal
     *
     * @param number El número a convertir a letras.
     * @return Representación literal del número.
     */
    public String toLetter(BigDecimal number) {

        // Extraer parte decimal
        BigInteger intpart = number.toBigInteger();
        BigDecimal decpart = number.subtract(new BigDecimal(number.toBigInteger()));

        // Si tiene parte decimal mayor a cero..
        if (decpart.compareTo(BigDecimal.ZERO) > 0) {
            StringBuilder sb = new StringBuilder();
            /// convertir parte entera
            sb.append(toLetter(intpart));

            sb.append(" con ");
            sb.append(decpart.movePointRight(decpart.scale()));
            sb.append("/");
            sb.append(BigDecimal.TEN.pow(decpart.scale()));

            return sb.toString();
        }

        // Tiene solo parte entera
        return toLetter(intpart);
    }

    /**
     * Traduce un BigInteger
     *
     * @param number El número a convertir a letras.
     * @return Representación literal del número.
     */
    public String toLetter(BigInteger number) {

        if (number.equals(BigInteger.ZERO)) {
            return normalize(UNIDADES[0]);
        }

        return normalize(toLetter(number.toString()));
    }

    private static String toLetter(String digit) {

        List<NumericPeriod> lista = splitPeriods(digit);

        if (lista.size() > ((PERIODOS.length))) {
            return MUY_GRANDE;
        }

        StringBuilder sb = new StringBuilder();

        for (NumericPeriod pn : lista) {
            sb.append(pn.toString());
            sb.append(" ");
        }

        return normalize(sb.toString());
    }

    private static List<NumericPeriod> splitPeriods(String digit) {

        StringBuilder sb = new StringBuilder();

        char[] chArray = digit.toCharArray();

        for (int i = chArray.length; i > 0; i--) {
            if (((chArray.length - i) % DIGITOS_POR_PERIODO == 0) && ((chArray.length - i) > 0)) {
                sb.append('M');
            }
            sb.append(chArray[i - 1]);
        }

        String[] periodos = sb.reverse().toString().split("M");

        List<NumericPeriod> lista = new ArrayList<>();

        ListIterator<String> li = (Arrays.asList(periodos).listIterator());
        while (li.hasNext()) {
            int orden = periodos.length - li.nextIndex() - 1;
            Integer periodo = Integer.parseInt(li.next());
            lista.add(new NumericPeriod(orden, periodo));
        }

        return lista;
    }

    private static String normalize(String s) {

        if (0 == s.trim().length()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        String tnlc = s.trim().toLowerCase();

        sb.append(Character.toUpperCase(tnlc.charAt(0)));
        sb.append(tnlc.substring(1));

        String[] words = sb.toString().split(" ");

        sb.delete(0, sb.length());

        int cnt = 0;
        for (String word : words) {
            if (word.length() > 0) {
                sb.append(word.trim());
                if (cnt < words.length - 1) {
                    sb.append(" ");
                }
            }
            cnt++;
        }

        return sb.toString();
    }

    private static class NumericPeriod {

        private final int m_posicion;

        private final Integer m_number;

        public NumericPeriod(int posicion, Integer number) {

            if (posicion < 0) {
                throw new IllegalArgumentException("Posicion debe ser un numero positivo!");
            }

            if (number < 0) {
                throw new IllegalArgumentException("Periodo numérico no puede ser menor que cero!");
            }
            if (number > 999999) {
                throw new IllegalArgumentException("Periodo numérico no puede ser mayor que 999.999!");
            }

            this.m_posicion = posicion;
            this.m_number = number;
        }

        private String suffix() {

            switch (m_number) {
                case 0:
                    return ""; // Ej.: 100000000000000

                case 1:
                    StringBuilder sb1 = new StringBuilder();
                    return sb1.append(PERIODOS[m_posicion]).append(LLON).toString();

                default:
                    StringBuilder sb2 = new StringBuilder();
                    return sb2.append(PERIODOS[m_posicion]).append(LLONES).toString();
            }
        }

        private boolean isFirstPeriod() {
            return 0 == m_posicion;
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();

            // procesar los digitos del periodo
            sb.append(processPeriod());

            if (!isFirstPeriod()) {
                sb.append(" ");
                sb.append(suffix());
            }

            return sb.toString();
        }

        private String processPeriod() {

            List<ClassNumerica> lc = splitClass(m_number);

            StringBuilder sb = new StringBuilder();
            ListIterator li = lc.listIterator();
            while (li.hasNext()) {
                sb.append(li.next().toString());
                sb.append(" ");
            }

            return sb.toString();
        }

        private List<ClassNumerica> splitClass(Integer s) {

            List<ClassNumerica> lc = new ArrayList<>();

            Integer clBaja, clAlta;
            clBaja = s - ((s / 1000) * 1000);
            clAlta = s / 1000;

            if (clAlta > 0) {
                lc.add(new ClassNumerica(clAlta, TypeClass.UpperClass, this));
            }

            lc.add(new ClassNumerica(clBaja, TypeClass.LowerClass, this));

            return lc;
        }
    }

    private enum TypeClass {

        LowerClass, UpperClass
    }

    private static class ClassNumerica {

        private final Integer m_number;

        private final TypeClass m_type;

        private final NumericPeriod m_period;

        public ClassNumerica(Integer num, TypeClass tc, NumericPeriod period) {

            if (null == period) {
                throw new IllegalArgumentException("Periodo no puede ser null");
            }

            this.m_type = tc;
            this.m_number = num;
            this.m_period = period;

        }

        @Override
        public String toString() {
            final int cen = m_number / 100;
            final int dec = (m_number - (m_number / 100) * 100) / 10;
            final int uni = m_number - (m_number / 10) * 10;
            final boolean claseBaja = (m_type == TypeClass.LowerClass);

            StringBuilder sb = new StringBuilder();

            // No hace falta considerar 0 (cero)

            // Caso excepcional
            if (100 == m_number) {
                if (claseBaja) {
                    return CIEN;
                } else {
                    sb.append(CIEN);
                    sb.append(" ");
                    sb.append(MIL);
                    return sb.toString();
                }
            }

            // Empezar con las centenas
            if (cen > 0) {
                sb.append(CENTENAS[cen]);
            }

            if ((((10 * dec) + uni) < 10) && (((10 * dec) + uni) > 0)) {
                sb.append(" ");
                if (uni == 1) {
                    if (claseBaja && m_period.isFirstPeriod()) {
                        sb.append(UNIDADES[uni]);
                    } else {
                        sb.append(UN);
                    }
                } else {
                    sb.append(UNIDADES[uni]);
                }

            }

            if ((((10 * dec) + uni) > 9) && (((10 * dec) + uni) < 20)) {
                sb.append(" ");
                sb.append(DIECIS[uni]);
            }

            if ((((10 * dec) + uni) > 19) && (((10 * dec) + uni) < 30)) {
                sb.append(" ");
                if (uni == 1) {
                    if (claseBaja && m_period.isFirstPeriod()) {
                        sb.append(VEINTIS[uni]); // veintiuno
                    } else {
                        sb.append(VEINTIUN);
                    }
                } else {
                    sb.append(VEINTIS[uni]);
                }
            }

            if (dec > 2) {
                sb.append(" ");
                sb.append(DECENAS[dec]);
            }

            if ((dec > 2) && (uni > 0)) {
                sb.append(" y ");
                if (uni == 1) {
                    if (claseBaja && m_period.isFirstPeriod()) {
                        sb.append(UNIDADES[uni]);
                    } else {
                        sb.append(UN);
                    }
                } else {
                    sb.append(UNIDADES[uni]);
                }
            }

            if ((m_number > 0) && (!claseBaja)) {
                sb.append(" ");
                sb.append(MIL);
            }

            return sb.toString();
        }
    }
}
