package Controller;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class FileManagerPiped {
    final PipedOutputStream output = new PipedOutputStream();
    final PipedInputStream input  = new PipedInputStream(output);

    public FileManagerPiped() throws IOException {
    }

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                output.write("Prueba".getBytes());
            }
        }
    });
}
