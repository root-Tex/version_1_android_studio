package com.example.pruebaborrar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    EditText et1, et2;
    TextView tv4;

    et1=(EditText)findViewById(R.id.et1);
    et2=(EditText)findViewById(R.id.et2);
    tv4=(TextView)findViewById(R.id.tv4);

    public String leerDatos(String nombreArchivo)
    {
        String contenido="";

        try {

            InputStream stream=getAssets().open(nombreArchivo);
            int size= stream.available();
            byte buffer []=new byte [size];
            stream.read(buffer);
            stream.close();
            contenido=new String (buffer);
            ingresar();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return contenido;
    }



    int sw;

    public void ingresar (View v)
    {
        String user,pass;
        user =et1.getText().toString();
        pass=et2.getText().toString();

        String texto = leerDatos("Usuarios.txt");
        StringTokenizer st= new StringTokenizer(texto,"\n");
        String linea="";
        while(st.hasMoreTokens())
        {
            linea=st.nextToken();
            String lineaSeparada[]=linea.split(",");
            if(user.equals(lineaSeparada[3]))
            {
                if(pass.equals(lineaSeparada[4]))
                {

                    sw=1;
                    Intent i=new Intent(this, Bienvenida.class);
                    i.putExtra("codigo",lineaSeparada[0]);
                    startActivity(i);
                }
            }
        }



    }
    private void ingresar() {
    }
}