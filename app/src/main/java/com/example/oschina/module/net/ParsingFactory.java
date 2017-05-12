package com.example.oschina.module.net;

/**
 * Created by Administrator on 2017/4/21 0021.
 */

public class ParsingFactory {
    private static final int OKHTPP = 1;
    private static final int RETROFIT = 2;
    private static final int TYPE = RETROFIT;
    public static IHTTP initParsing(){
        IHTTP ihttp = null;
        switch(TYPE){
            case OKHTPP:
                break;
            case RETROFIT:
                ihttp = RetrofitImple.getInstance();
                break;
        }
        return ihttp;
    }
}
