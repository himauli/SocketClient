package com.example.Client;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import com.example.Client.R;
        import com.example.Client.*;

        import java.net.Socket;

public class MainActivity extends Activity {

    TextView response;
    EditText editTextAddress, editTextPort;
    Button buttonConnect, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editTextAddress = (EditText) findViewById(R.id.addressEditText);
        editTextPort = (EditText) findViewById(R.id.portEditText);
        buttonConnect = (Button) findViewById(R.id.connectButton);
        buttonClear = (Button) findViewById(R.id.clearButton);
        response = (TextView) findViewById(R.id.responseTextView);

       buttonConnect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Client myClient = new Client(editTextAddress.getText()
                      .toString(), Integer.parseInt(editTextPort
                    .getText().toString()), response);

                //Client myClient = new Client(editTextAddress.getText()
                //      .toString(), Integer.parseInt(editTextPort
              //   .getText().toString()), response);

             //  Client myClient = new Client(response);
                myClient.execute();
            }
        });
     /*   buttonConnect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            }

            socket = IO.socket("http://192.168.4.1:23");
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    socket.emit("foo", "hi");
                    socket.disconnect();
                }

            }).on("event", new Emitter.Listener() {

                @Override
                public void call(Object... args) {}

            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {}

            });
            socket.connect();
            }
        });  */

        buttonClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                response.setText(" ");
            }
        });
    }
}
