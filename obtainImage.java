    /*
     * Client Side 
     * 
     */
    package Interface_class;

    import java.awt.image.BufferedImage;
    import java.io.DataInputStream;
    import java.io.DataOutputStream;
    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.net.SocketTimeoutException;
    import javax.imageio.ImageIO;

    public class obtainImage extends Thread {

        public obtainImage() {
            System.out.println("Loading socket");
        }

        public void run() {
            CLIENTINFO_CLASS obj = new CLIENTINFO_CLASS();
            obj.consulta();
            try {
                Socket socket = new Socket("localhost", 6066);
    //              DataInputStream din = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
               //Using this to send image "name" to server, so it can identify and send image to client
                dataOut.writeUTF(obj.getImg_name());
                BufferedImage img = ImageIO.read(ImageIO.createImageInputStream(socket.getInputStream()));
                System.out.println("Image received");
    //                socket.close();
            } catch (IOException e) {
                System.out.println("Error ending socket" + e);
            }
        }
    }