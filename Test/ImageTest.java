import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ImageTest {
    @Test
    public void testLoadImage(){

        BufferedImage image= null;
        try {
            image = ImageIO.read(new File(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(image);
    }
}
