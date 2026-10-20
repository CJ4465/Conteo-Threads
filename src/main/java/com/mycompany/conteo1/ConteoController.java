
package com.mycompany.conteo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class ConteoController implements Initializable {

    @FXML
    private TextField txtClicks;

    @FXML
    private Button btnContar;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button btnEsperar;

    private int contadorClicks = 0;

    @FXML
    private void handleContar() {
        contadorClicks++;
        txtClicks.setText(String.valueOf(contadorClicks));
    }


@FXML
private void handleEsperar() {
    // Deshabilitar ambos botones
    btnEsperar.setDisable(true);
    btnContar.setDisable(true);

    progressBar.setProgress(0.0);

    Thread hiloEspera = new Thread(() -> {
        try {
            int pasos = 100;

            for (int i = 1; i <= pasos; i++) {
                Thread.sleep(100);

                final double progreso = (double) i / pasos;

                Platform.runLater(() ->
                    progressBar.setProgress(progreso)
                );
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        } finally {
            Platform.runLater(() -> {
                btnEsperar.setDisable(false);
                btnContar.setDisable(false);
            });
        }
    });

    hiloEspera.setDaemon(true);
    hiloEspera.start();
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contadorClicks = 0;
        txtClicks.setText("0");
        progressBar.setProgress(0.0);
    }
}
