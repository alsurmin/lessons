package resources;

import java.awt.*;
import java.util.ListResourceBundle;


public class resource_en extends ListResourceBundle {
    private static final Object[][] contents = {
            {"somevalue", "This is english text"},
            {"backGround", Color.BLACK},
            {"defaultPaperSize", new double[] {210,297}}
    };

    @Override
    public Object[][] getContents() {
        return contents;
    }
}
