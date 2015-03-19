package hello;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 27.02.15
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
    }

}
