package appium.MobileTesting;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

import javax.imageio.ImageIO;

public class clipboardtest {
    public static void clipboard() {
        // Replace this path with your image file's path
        //String imagePath = "C://Users//0047HE744//Desktop//Personal//MyLearning//AppiumTesting//MobileTesting//test-result.png";
    	String imagePath = System.getProperty("user.dir") + "/test-result.png";
    	copyImageToClipboard(imagePath);
    }

    public static void copyImageToClipboard(String imagePath) {
        try {
            // Read the image file into memory
            File imageFile = new File(imagePath);
            Image image = ImageIO.read(imageFile);

            // Get the system clipboard
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            // Create a Transferable object with the image
            TransferableImage transferable = new TransferableImage(image);

            // Set the Transferable object to the clipboard
            clipboard.setContents(transferable, null);

            System.out.println("Image copied to clipboard successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TransferableImage implements Transferable {
    private Image image;

    public TransferableImage(Image image) {
        this.image = image;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) {
        if (flavor.equals(DataFlavor.imageFlavor) && image != null) {
            return image;
        } else {
            return null;
        }
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.imageFlavor);
    }
}
