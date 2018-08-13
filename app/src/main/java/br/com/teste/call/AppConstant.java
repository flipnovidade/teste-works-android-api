package br.com.teste.call;

import java.util.Locale;

public class AppConstant {

    public class Bundle {
    }

    public class Format {
        public static final String DATA_US = "yyyy-MM-dd";
        public static final String DATA_HORA_US = "yyyy-MM-dd HH:mm:ss";
        public static final String DATA_HORA_US_2 = "yyyy-MM-dd HH:mm";
        public static final String DATA_BR = "dd/MM/yyyy";
        public static final String DATA_CUSTOM = "dd/MMM";
        public static final String HORA_MINUTO_BR = "HH:mm";
        public static final String ANO = "yyyy";
        public static final String DATA_BR_AMIGAVEL = "dd MMM yyyy";
    }

    public class Mask {
        public static final String DATA = "##/##/####";
        public static final String TIPO_MOTOR = "#.#";

    }

    public static class Localizacao {
        public static final Locale PTBR = new Locale("pt", "BR");
    }

    public static class Dribbble{
        public static final String Client_ID = "a9a66cc325f22a9e5040005f93ac19ffc1dfc12f4b710df52dd22b3da4f57f00";
        public static final String Client_Secret = "6778212f0d2beb71f4141607aa2221ce976e737fe517dfd834bc79ab840c4f03";
        public static final String Token = "703f7e74ffa8da0839e23c970433018dad0436afff662357d842537cf2a86ca8";
        public static final String Account = "felippesantos";
        public static final String AccountAnother = "Creativedash";
        public static final String URL = "https://api.dribbble.com/";
        public static final String PER_PAGE = "30";
    }

}
