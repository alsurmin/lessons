import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //System.out.println(calendar);

        calendar.add(Calendar.MINUTE, 10);
        System.out.println(calendar.getTime());

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(dateFormat.format(calendar.getTime()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm");
        System.out.println(simpleDateFormat.format(calendar.getTime()));

        //21/07/1967

        Date newDate = null;
        try {
            newDate = simpleDateFormat.parse("21-07-1967 05:22");
            System.out.println(simpleDateFormat.format(newDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
