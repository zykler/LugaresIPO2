package es.ipo2.lugaresipo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MiAdaptador extends BaseAdapter { 
    private LayoutInflater inflador; // Crea Layouts a partir del XML
    TextView distancia;
    TextView nombre, direccion;
    ImageView foto;
    RatingBar valoracion;
    
    public MiAdaptador(Context contexto) {
    	inflador =(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int posicion, View vistaReciclada, ViewGroup padre) {
         Lugar lugar =Lugares.elemento(posicion);
         if (vistaReciclada == null) {
        	 vistaReciclada= inflador.inflate(R.layout.elemento_lista, null);
         }
         
         nombre = (TextView) vistaReciclada.findViewById(R.id.nombre);
         direccion = (TextView) vistaReciclada.findViewById(R.id.direccion);
         foto = (ImageView) vistaReciclada.findViewById(R.id.foto);
         valoracion = (RatingBar) vistaReciclada.findViewById(R.id.valoracion);
         nombre.setText(lugar.getNombre());
         direccion.setText(lugar.getDireccion());
         distancia = (TextView) vistaReciclada.findViewById(R.id.distancia);
         
         int id = R.drawable.otros;
         
         switch(lugar.getTipo()) {
         
           	case RESTAURANTE:id = R.drawable.restaurante; break;
           	case BAR:        id = R.drawable.bar;         break;
           	case COPAS:      id = R.drawable.copas;       break;
           	case ESPECTACULO:id = R.drawable.espectaculos; break;
           	case HOTEL:      id = R.drawable.hotel;       break;
           	case COMPRAS:    id = R.drawable.compras;     break;
           	case EDUCACION:  id = R.drawable.educacion;   break;
           	case DEPORTE:    id = R.drawable.deporte;     break;
           	case NATURALEZA: id = R.drawable.naturaleza;  break;
           	case GASOLINERA: id = R.drawable.gasolinera;  break;
         }

         foto.setImageResource(id);
         foto.setScaleType(ImageView.ScaleType.FIT_END);
         valoracion.setRating(lugar.getValoracion());  
         return vistaReciclada;
      }

      public int getCount() {
    	  return Lugares.size();
      }
      
      public Object getItem(int posicion) {
    	  return Lugares.elemento(posicion);
      }

      public long getItemId(int posicion) {
    	  return posicion;
      }

}
