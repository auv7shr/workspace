package com.androidexample.reservation;

import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;
import android.content.Intent;

public class MyHandler implements UncaughtExceptionHandler {
    private Context m_context;


    public static void attach(Context context) {
        Thread.setDefaultUncaughtExceptionHandler(
            new MyHandler(context)
        );
    }

    ///////////////////////////////////////////// implementation

    private MyHandler(Context context) {
        m_context=context;
    }

    public void uncaughtException(Thread thread,Throwable exception) {
    /*  StringWriter stackTrace=new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));*/
        System.out.println("ERROR IS "+(exception));


        Intent intent=new Intent("com.androidexample.reservation.BroadcastNewSms");  
            m_context.startService(intent);

        // from RuntimeInit.crash()
//        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
