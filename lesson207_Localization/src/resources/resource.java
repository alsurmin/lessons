package resources;

import java.awt.*;
import java.util.ListResourceBundle;


public class resource extends ListResourceBundle {
    private static final Object[][] contents = {
            {"somevalue", "Это на русском языке"},
            {"backGround", Color.BLACK},
            {"defaultPaperSize", new double[] {210,297}}
    };

    @Override
    public Object[][] getContents() {
        return contents;
    }
}
