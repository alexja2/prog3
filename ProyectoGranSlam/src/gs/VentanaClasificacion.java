package gs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaClasificacion extends JFrame{

	//PERMITE VISUALIZAR DE FORMA DINAMICA LA CLASIFICACION DE JUGADORES EN FUNCION DE LOS TORNEOS GANADOS
	//ORDENAR POR TORNEOS GANADOS, TOP1, TOP2, TOP3...
	
	protected List<String> tenistas;
	HashMap<String, Integer> victoriasPorTenista;
	HashMap<String, Integer> victoriasPorTenistaCopia;
	HashMap<String, Integer> rankingPorJugador;
	
	public VentanaClasificacion(VentanaGrandSlam principal) {
		
		this.setSize(300,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//CONFIGURACION SALIR
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				principal.main.setVisible(true);
			}
		});
		
		JPanel panelTablaTenistas = new JPanel(new BorderLayout());
		panelTablaTenistas.setBorder(new EmptyBorder(10, 10, 10, 10));
		    	
    	String[] columnasTitulosTenistas = {"Nº Puesto", "Tenista"};
    	DefaultTableModel modelo3 = new DefaultTableModel(columnasTitulosTenistas, 0) {
    		@Override // Esto hace que todas las celdas sean no editables y asi pueda hacer el pop-up
    	    public boolean isCellEditable(int row, int column) {
    	        return false; 
    	    }
    	};
    	
        JTable tablaTorneo = new JTable(modelo3);
        
        JScrollPane scrollPane3 = new JScrollPane(tablaTorneo);
        panelTablaTenistas.add(scrollPane3, BorderLayout.CENTER);
        
        this.add(panelTablaTenistas);
       
        
        //relleno lista de tenistas sin repetir
        tenistas = new ArrayList<>();
        for(Resultado resultado : principal.resultados) {
        	//primero los tenistas ganadores
        	String tenista = resultado.getCampeon();
        	if(!tenistas.contains(tenista)) {
        		tenistas.add(tenista);
        	}
        	//ahora los tenistas subcampeones, por lo tanto 0 victorias
        	String tenista2 = resultado.getSubCampeon();
        	if(!tenistas.contains(tenista2)) {
        		tenistas.add(tenista2);
        	}
        	}
        
      //cuantas victorias tienes los tenistas
      victoriasPorTenista = new HashMap<>();
      
      for (String tenista : tenistas) {
    	    victoriasPorTenista.put(tenista, 0);
    	    
    	}
      
      //rellenar hashmap correctamente
        for(String tenista : tenistas) {
        	for(Resultado resultado : principal.resultados) {
        		if (tenista.equals(resultado.getCampeon())) {
        			victoriasPorTenista.put(tenista, victoriasPorTenista.get(tenista)+1);
        		}      		
        	}
        }
        
        
        
      //hacemos copia del hashmap para ir borrando elementos
        victoriasPorTenistaCopia = new HashMap<>(victoriasPorTenista);
        
        int tamañoHashMap = victoriasPorTenistaCopia.size();
        
        rankingPorJugador = new HashMap<>();
        //ahora ordenar la tabla con los datos por orden del int
        for(int i=1;i<=tamañoHashMap;i++) {
        	String tenista = buscarTenistaMax();
        	modelo3.addRow(new Object[] {i, tenista});
        	rankingPorJugador.put(tenista, i);
        }
        
        
        
    	//------------POP-UP DE INFORMACION POR TENISTA-------------
        
    	//info del tenista, posicion en ranking, numero de gs ganados
    	//primero obtengo el nombre del tenista, luego ya me las apaño vaya
    	
        tablaTorneo.addMouseListener(new MouseAdapter() {
        	 @Override
             public void mouseClicked(MouseEvent e) {
        		 if (e.getClickCount()==2) {
        			 	int columnaselec = tablaTorneo.getSelectedColumn();
        		    	int filaselec = tablaTorneo.getSelectedRow();
        		    	
        		    	if (filaselec!=-1 && columnaselec != -1) {
        		    		String nombre = (tablaTorneo.getValueAt(filaselec, columnaselec)).toString();
        		    		Tenista tenista = findTenista(nombre, principal.tenistas);
        		    		popUpInfoTenista(tenista);
        		    	} 
        		 }
        	 }
        });
      
	}
	

	
	public String buscarTenistaMax() {
		String tmax = null;
		 int max = 0;
		for (Map.Entry<String, Integer> entry : victoriasPorTenistaCopia.entrySet()){
        	String tenista = entry.getKey();
            Integer victorias = entry.getValue();
            
            if(victorias>=max) {
            	max = victorias;
            	tmax = tenista;
            }
         
        }
		 victoriasPorTenistaCopia.remove(tmax);
		return tmax;
	}


	public void popUpInfoTenista(Tenista tenista) {
		JFrame frame2 = new JFrame();
		frame2.setSize(900,1050);
		frame2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame2.setTitle("Detalles de "+tenista.getNombre().toUpperCase());
		//frame2.setLocationRelativeTo(null);
		frame2.setVisible(true);
		JPanel main = new JPanel(new GridLayout(4,2));
		main.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame2.add(main);
		
		JTextField tnombre = new JTextField(tenista.getNombre()); tnombre.setEditable(false);
		JTextField tnacionalidad = new JTextField(tenista.getNacionalidad()); tnacionalidad.setEditable(false);
		JTextField tranking = new JTextField(rankingPorJugador.get(tenista.getNombre()).toString()); tranking.setEditable(false);
		JTextField tvictorias = new JTextField(victoriasPorTenista.get(tenista.getNombre()).toString()); tvictorias.setEditable(false);	
		
		main.add(new JLabel("Nombre")); main.add(tnombre);
		main.add(new JLabel("Nacionalidad")); main.add(tnacionalidad);
		main.add(new JLabel("Ranking")); main.add(tranking);
		main.add(new JLabel("Nº Victorias en GS")); main.add(tvictorias);
				
	}
	
	public Tenista findTenista(String nombre, List<Tenista> tenistas) {
		Tenista tenista = null;
		for(Tenista t : tenistas) {
			if(t.getNombre().equals(nombre)) {
				tenista = t;
			}
		}		
		return tenista;
	}
	
	
}
