package resources;

import java.awt.*;
import java.util.ListResourceBundle;

public class resource_fr extends ListResourceBundle {
    private static final Object[][] contents = {
            {"somevalue", "de fua france"},
            {"backGround", Color.BLACK},
            {"defaultPaperSize", new double[] {210,297}}
    };

    @Override
    public Object[][] getContents() {
        return contents;
    }
}
