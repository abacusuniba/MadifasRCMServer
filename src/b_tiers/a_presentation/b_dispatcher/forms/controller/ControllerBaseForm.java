package b_tiers.a_presentation.b_dispatcher.forms.controller;

import java.net.URL;
import java.util.ResourceBundle;


//import org.apache.solr.search.function.ProductFloatFunction;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

////import com.google.gson.Gson;

import b_tiers.a_presentation.b_dispatcher.forms.controller.CBase;
import b_tiers.b_business.a_businessDelegate.lookUpService.ServiceType;
import c_dto.Command;
import c_dto.GraphAdapterBuilder;
import c_dto.a_abstract.Azienda;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Administrator;
import c_dto.b_real.Altro;
import c_dto.b_real.CAP;
import c_dto.b_real.CausaleTrasporto;
import c_dto.b_real.Citta;
import c_dto.b_real.Cliente;
import c_dto.b_real.SubAgente;
import c_dto.b_real.TempoConsegna;
import c_dto.b_real.Consorzio;
import c_dto.b_real.Documento;
import c_dto.b_real.FormaGiuridica;
import c_dto.b_real.Fornitore;
import c_dto.b_real.GruppoProdotto;
import c_dto.b_real.GruppoSocietario;
import c_dto.b_real.Iva;
import c_dto.b_real.Magazzino;
import c_dto.b_real.Minimo;
import c_dto.b_real.Nazione;
import c_dto.b_real.Pagamento;
import c_dto.b_real.PercentualeCollaboratore;
import c_dto.b_real.PercentualeFornitore;
import c_dto.b_real.Prodotto;
import c_dto.b_real.Provincia;
import c_dto.b_real.Regione;
import c_dto.b_real.Segnalatore;
import c_dto.b_real.Settore;
import c_dto.b_real.SottoGruppoProdotto;
import c_dto.b_real.TipoDocumento;
import c_dto.b_real.Trasporto;
import c_dto.b_real.UM;
import c_dto.b_real.Utente;
import c_dto.b_real.Validita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
//import business.delegate.ServiceType;
//import business.services.as.EmailException;
//import business.services.as.UsernameException;
//import dto.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

//import com.fasterxml.jackson.databind.ObjectMapper;

//import org.codehaus.jackson.map.ObjectMapper;

import a_main.RCMException;

import java.util.ArrayList;
import java.util.List;

import c_dto.Command;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
* 
* @author Rosario
*
*/
public class ControllerBaseForm extends CBase implements Initializable{

//	private static int idCLientCount = 0;
	
	
	

	/**
	 * Classe <em><b>MultiServer</b></em><br />
	 * Questa � la classe che gestisce l'avvio del server, estendendo la classe <b>Thread</b><br />
	 * Il server sar� disponibile su una porta predefinita (al di fuori del range 1-1024) e dovr� gestire 
	 * contemporaneamente richieste da pi� client
	 * 
	 * @author <em>Appice Annalisa</em>
	 * @author <em>Accardo Rosario</em>
	 * 
	 * @since <b>Alberi di decisione 7.0</b>
	 * 
	 * @version <b>Alberi di decisione 8.0</b>
	 */
	public class MultiServer extends Thread{
		private int idCLientCount = 0;
		
		
		/**
		 * Classe <em><b>ServerOneClient</b></em><br />
		 * Questa � la classe che gestisce la connessione con il singolo client
		 * 
		 * @author <em>Appice Annalisa</em>
		 * @author <em>Accardo Rosario</em>
		 * 
		 * @since <b>Alberi di decisione 7.0</b>
		 * 
		 * @version <b>Alberi di decisione 9.0</b>
		 */
		class ServerOneClient extends Thread {
			
//			private ServerUi serverUi;
			
			/**
			 * Oggetto istanza della classe <b>Socket</b>.<br />
			 * E' il canale di connessione con il client
			 * 
			 * @since <b>Alberi di decisione 7.0</b>
			 */
			private Socket socket;
			
			/**
			 * Oggetto istanza della classe <b>ObjectInputStream</b>.<br />
			 * E' lo stream di input e gestisce le richieste del client
			 * 
			 * @since <b>Alberi di decisione 7.0</b>
			 */
			private ObjectInputStream in; // stream con richieste del client
			
			/**
			 * Oggetto istanza della classe <b>ObjectOutputStream</b>.<br />
			 * E' lo stream di output e gestisce le risposte del server
			 * 
			 * @since <b>Alberi di decisione 7.0</b>
			 */
			private ObjectOutputStream out;
			
			/**
			 * Oggetto istanza della classe <b>DecisionTree</b><br />
			 * Questo membro � l'oggetto utilizzato per gestire tutte le operazioni che vengono richieste dal client
			 * 
			 * @since <b>Alberi di decisione 7.0</b>
			 */
//			DecisionTree tree;


//			private static int idCLientCount = 0;
			private int idClient;
			
//			private boolean isDesktop=false;
			private Object type;
			
			
//			private List<String> tablesList;
			private byte[] getBytes(Object obj){// throws java.io.IOException{
			      byte [] data = null;
				try{
				      ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
				      ObjectOutputStream oos = new ObjectOutputStream(bos); 
				      oos.writeObject(obj);
				      oos.flush(); 
				      oos.close(); 
				      bos.close();
				      data = bos.toByteArray();
				}
				catch(Exception e){
				}
			      return data;
			  }
			
			
			public int getMyID() {
				return idClient;
			}

			/**
			 * Questo membro � il <b>costruttore della classe</b>.<br />
			 * Collega la socket passata, crea gli stream di input e di output sulla socket e successivamente avvia 
			 * il thread (usando il metodo <b>start()</b>)
			 * 
			 * @param s Oggetto istanza della classe <b>Socket</b> contenente la socket utilizzata per la connessione
			 * con il client
			 * 
			 * @throws IOException Eccezione sollevata nel momento in cui, in fase di ricezione/invio dati, si 
			 * dovessero verificare condizioni anomale, come un'improvvisa interruzione dell'I/O o un fallimento di
			 * invio/ricezione.
			 * 
			 * @since <b>Alberi di decisione 7.0</b>
			 */
//			public ServerOneClient(Socket s, ServerUi server) throws IOException {
			public ServerOneClient(Socket s/* /, int id/**/) throws IOException {
//				serverUi=server;
				socket = s;
				
				out = new ObjectOutputStream(socket.getOutputStream());
				in = new ObjectInputStream(socket.getInputStream());
//				out = new ObjectOutputStream(socket.getOutputStream());
				
				idClient= ++idCLientCount;
//				server.connectClient(idClient, Color.GREEN);
				start();
			}
			ObjectMapper mapper = new ObjectMapper();

			/**
			 * Questo membro � il metodo che si occupa della gestione delle richieste del client.<br />
			 * Il client pu� effettuare le seguenti richieste:<br /><br />
			 * <b>1.</b> Apprendere un nuovo albero di decisione.<br />
			 * In questo caso il client invia una richiesta del tipo: "1 \n <nome tabella>"<br /><br />
			 * 
			 * <b>2.</b> Salvare un albero di decisione in un file "tree.dat".<br />
			 * In questo caso il client invia una richiesta del tipo: "2 \n <nome file>"<br /><br />
			 * 
			 * <b>3.</b> Caricare un albero di deciisone da un file "tree.dat".<br />
			 * In questo caso il client invia una richiesta del tipo: "3 \n <nome file>"<br /><br />
			 * 
			 * <b>4.</b> Usare un albero di decisione per effettuare una nuova predizione.<br /><br />
			 * In questo caso il client invia una richiesta del tipo: "4"<br />
			 * 
			 * <b>5.</b> Scollegarsi dal server.<br />
			 * In questo caso il client invia una richiesta del tipo: "5 \n"
			 */
			
			boolean resetRequired;
			
			@SuppressWarnings("unused")
			public void run() {
				
				
				try {
//					DecisionTree tree=null;
//					Data trainingSet = null;

					try{	
//						//ricavo l'elenco delle tabelle dal database
//						tablesList = loadTablesFromDatabase();
//						
//						//invio dell'elenco delle tabelle
//						out.writeObject(tablesList);
						
						
//						isDesktop=(boolean) in.readObject();//ricava se il client � desktop oppure no
//						String tableOrFileName = "";
					while (true) {
//						int command = ((Integer)in.readObject()).intValue();
						
						
//						Class<?> clz = (Class<?>) in.readObject();
//						
//						String jsonInString = (String) in.readObject();
//						
//						Gson mapper = new Gson();
////						Staff obj = mapper.readValue(jsonInString, Staff.class);
//						Command cmd= (Command) mapper.fromJson(jsonInString, clz);
						
						
						//vecchia versione
//						Command cmd= (Command) in.readObject();
						//nuova versione
						Command cmd= (Command) in.readUnshared();
						
						DTOBase myDto = (DTOBase) cmd.getDto();
						
						if (myDto.getId()>0) {
							resetRequired=true;
						}
						else {
							resetRequired=false;
						}
						
						if (cmd.getDto() instanceof Documento)
							System.out.print("");
//						Command cmd=null;
//						
//						Class<Command> cls = (Class<Command>) in.readObject();
//						String jsonString = (String) in.readObject();
//						
//						cmd=(Command) mapper.readValue(jsonString, cls);

//						Object obj=in.readObject();
//						Object obj2=null;
////						if (obj instanceof List<?>) {
////							//è una lista
////							obj2=obj;
////							
////						}
////						else {
//							// è un dto convertito in json
//							Class<? extends DTOBase> cls = (Class<? extends DTOBase>) obj;
//							String jsonString = (String) in.readObject();
//							
//							obj2=mapper.readValue(jsonString, cls);
////						}
//					
//						Command cmd = null;
						
						
						
////						cmd=null;
//						
////						execute(cmd);
//						
////						switch (cmd.getService()) {
////						case login:
////							txtLogOld.setText(txtLogOld.getText() + "Client \"" + getMyID() + "\" richiede: " + cmd.getService().toString() + "\n");
////							break;
////						case elenco:
////							txtLogOld.setText(txtLogOld.getText() + "Client \"" + getMyID() + "\" richiede: " + cmd.getService().toString() + "\n");
////							break;
////						}
//////						out.writeObject(execute(cmd));
//						
////						try {
////							txtLogOld.setText(txtLogOld.getText() + "Client \"" + getMyID() + "\" richiede: " + cmd.getService().toString() + " " + cmd.getDto().getClass().getSimpleName().toLowerCase() + "\n");
////							
//////							datiClient.add("Client \"" + getMyID() + "\"");
////							
////							
////						}
////						catch(Exception e)
////						{
////							txtLogOld.setText(txtLogOld.getText() + "Client \"" + getMyID() + "\" richiede: " + cmd.getService().toString() + "\n");
//////							datiClient.add("Client \"" + getMyID() + "\"");
////						}
//						if (cmd.getDto() instanceof Documento)
//							System.out.print("");
						Object o = execute(cmd);
						
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						//vecchia versione
//						out.writeObject(o);
						//nuova versione
						out.writeUnshared(o);
						if (resetRequired==true)
							out.reset();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//						if (o==null) {
//							o=cmd.getDto();
//						}
//						
//						String objInJsonString="";
//						if (o instanceof List<?>){
//							out.writeObject(o);
////							objInJsonString = mapper.writeValueAsString(o);
////							out.writeObject(o.getClass());
////							out.writeObject(objInJsonString);
//						}
//						else {
////							try {
//								objInJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
////							}
////							catch (Exception e) {
////								e.printStackTrace();
////							}
//							out.writeObject(o.getClass());
//							out.writeObject(objInJsonString);
//						}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
////						jsonInString=mapper.toJson(o);
////
////						out.writeObject(o.getClass());
////						out.writeObject(jsonInString);
//						out.writeObject(o);
//						out.flush();
						
						
						
						

						
//						GsonBuilder gsonBuilder = new GsonBuilder();
						
//						new GraphAdapterBuilder()
//					    .addType(o.getClass())
//					    .registerOn(gsonBuilder);		
						
//						Gson gson = gsonBuilder.create();
//						String s = gson.toJson(o);
//						System.out.println(s);						
						
						
						
						
//						ObjectMapper jacksonMapper =  new ObjectMapper();
//						jacksonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
						
//						//invio la "classe" dell'oggetto
//						out.writeUnshared(o.getClass());
//						if (o instanceof Cliente){
//							out.writeObject(s);
//							
////								try {
////									for (Field f : ((Cliente)o).getClass().getDeclaredFields()){
////									System.out.println(f.getName() + ": " + o.getClass().getDeclaredField(f.getName()));
////									}
////								} catch (NoSuchFieldException | SecurityException e) {
////									// TODO Auto-generated catch block
////									e.printStackTrace();
////								}
//							
//							
//							
//						}
//						else{
//						out.writeUnshared(jacksonMapper.writeValueAsString(o));
//						out.writeUnshared(o);
//						out.flush();
////						}
						
						
//						//invio la "classe" dell'oggetto
//						out.writeUnshared(o.getClass());

						
						
						
//						System.out.println(jSonObj.toJson(o));
						
//						if (o instanceof ArrayList<?>){
//							//l'oggetto � una lista
//							if (!((ArrayList<?>) o).isEmpty())
//							{
//								out.writeUnshared(((ArrayList<?>) o).get(0).getClass());
//							}
//						}else{
//							//l'oggetto � "normale"
//							out.writeUnshared(o.getClass());
////							out.writeUnshared(jSonObj.toJson(o));
//						}
						
						
						
						
						
//						switch(cmd)
//						{
//							case 1: // LEARNING A DECISION TREE
		/////////////////////////////////////////////////////////////////////////////////////////////////
////								try {
////									tableOrFileName=((String) in.readObject()).toString();
////									trainingSet = new Data(tableOrFileName);//lettura del nome della tabella
////								} catch (DataException e1) {
////									//
////								} catch (ClassTypeException e1) {
////									//
////								}
////								tree = new DecisionTree(trainingSet);
		////
////								//aggiunto da me
////								if (isDesktop){
////									int width=((Integer)in.readObject()).intValue();
////									int height=((Integer)in.readObject()).intValue();
////									tree.createGraph(width,height);
////									out.writeObject(tree.getGraph());//spedisco il "grafo" al client
////								}
////								else
////									out.writeObject("Load complete");
		////
////								serverUi.addClientRequest("Apprendimento albero dal database\n  (Tabella: " + tableOrFileName + ")", idClient, Color.BLACK);
//								break;
//							case 2: // SERIALIZE THE CURRENT DECISION TREE ON A FILE
////								//gestire albero nullo
////								tableOrFileName=((String) in.readObject()).toString();
////								tree.salva(tableOrFileName);
////								serverUi.addClientRequest("Salvataggio albero in un file\n  (File: " + tableOrFileName + ")", idClient, Color.BLACK);
//								break;
//							case 3: // STORE THE DECISION TREE FROM FILE
////								tableOrFileName=((String) in.readObject()).toString();
////								serverUi.addClientRequest("Caricamento albero da un file\n  (File: " + tableOrFileName + ")", idClient, Color.BLACK);
////								try{
////									tree = DecisionTree.carica(tableOrFileName);
////									if (isDesktop){
////										tree.createGraph(((Integer)in.readObject()).intValue(),((Integer)in.readObject()).intValue());
////										out.writeObject(tree.getGraph());//spedisco il "grafo" al client
////									}
////									else
////										out.writeObject("Load complete");
////								}
////								catch(FileNotFoundException e){
////									serverUi.addServerResponse("Errore. File inesistente\n  (File: " + tableOrFileName + ")", idClient, Color.RED);
////									if (isDesktop){
////										out.writeObject(null);//spedisco il "grafo" al client
////										int buffer=((Integer)in.readObject()).intValue();//usata in tampone per evitare di acquisire un dato errato
////										buffer=((Integer)in.readObject()).intValue();//usata in tampone per evitare di acquisire un dato errato
////									}
////									out.writeObject(e.getMessage());
////								}
//								break;
//							case 4: //USE THE CURRENT TREE TO PREDICT AN EXAMPLE
////								serverUi.addClientRequest("Usare l'albero per una predizione", idClient, Color.BLACK);
////								try {
////							    	String classValue="CLASSE: "+predictClass(tree);
////							    	out.writeObject("Transmitting class ...");
////							    	out.writeObject(classValue);
////									serverUi.addServerResponse(classValue, idClient, Color.BLACK);
////							    	
////							    }
////								catch (NullPointerException e) {
////									System.out.println("Prediction: Albero non esistente");
////									out.writeObject(e);
////								}
////								catch(UnknownValueException e){
////									System.out.println("Prediction: Opzione scelta inesistente");
////									
////									out.writeObject(e);
////								}
//								break;
//								
//							}// END SWITCH
				}
					}
					catch(IOException e){
//						serverUi.disconnectClient(idClient, Color.RED);
						txtLogOld.setText(txtLogOld.getText() + "Client disconnesso. ID=" + getMyID() + "\n");
//						ArrayList<String> array= mapClient.get(getMyID());
//						array.add("Client disconnesso. ID=" + getMyID() + "\n");
//						
//						mapClient.put(getMyID(), array);
////						datiClient.add("Client_ID = " + client.getMyID());
//						datiOperazioni.addAll(array);
						
						
						
//						RCMException.showException(e);
						
					}
					catch(ClassNotFoundException e){
						RCMException.showException(e);
					}
				} finally {
					try {
						socket.close();
//						System.out.println("Socket chiusa");
					} catch (IOException e) {
						System.out.println("Socket non chiuso!");
					}
				}
			}
			
			
//			private ArrayList<String> loadTablesFromDatabase() {
//				ArrayList<String> tablesFromDatabase=new ArrayList<String>();
//				
		//
//				try {
//					DbAccess.initConnection();
//				} catch (DatabaseConnectionException e) {
//					e.printStackTrace();
//				}
//				
//				
//				
//				//inserisco le tabelle nell'ArrayList
//				try {
//					Statement s = DbAccess.getConnection().createStatement();
//					
//					String query = "select * from tables order by name";
//					
//					ResultSet rs = s.executeQuery(query);
//					
//					while (rs.next()){
//						tablesFromDatabase.add(rs.getString("name"));
//					}
//					
		//
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
		//
//				
//				
//				DbAccess.closeConnection();
//				
//				return tablesFromDatabase;
//			}



			/**
			 * Questo membro � il metodo utilizzato per effettuare la predizione del valore di classe di un nuovo 
			 * esempio.<br />
			 * Visualizza le informazioni di ciascuno split dell'albero e per il corrispondente attributo acquisisce,
			 * dal client, il valore dell'esempio da classificare.<br />
			 * Se il nodo root corrente � istanza della classe <b>LeafNode</b>, l'acquisizione termina e viene inviata
			 * al client la classe, altrimenti si invoca ricorsivamente il metodo predictClass, sul figlio di root in 
			 * childTree[] (individuato dal valore acquisito), e si continua con la predizione finch� non si raggiunge
			 * il livello foglia.
			 * 
			 * @param tree Oggetto istanza della classe <b>DecisionTree</b> contenente l'intero albero per effettuare
			 * la predizione di un nuovo esempio
			 * @return Restituisce:<br />
			 * - il valore della classe (nel caso venga raggiunto il nodo foglia)
			 * - il valore del nodo corrente (nel caso in cui il nodo corrente sia un nodo di split)
			 * 
			 * @throws UnknownValueException Eccezione sollevata nel momento in cui, in fase di acquisizione, non 
			 * viene inserito alcun valore oppure il valore inserito non � compreso in quelli ammessi dal programma
			 * @throws ClassNotFoundException Eccezione sollevata nel momento in cui non � possibile trovare la classe
			 *  con il nome specificato
			 * @throws IOException Eccezione sollevata nel momento in cui, in fase di ricezione/invio dati, si 
			 * dovessero verificare condizioni anomale, come un'improvvisa interruzione dell'I/O o un fallimento di
			 * invio/ricezione.
			 */
//			private String predictClass(DecisionTree tree)throws UnknownValueException, ClassNotFoundException,IOException{
//				//aggiunto da me
//				String responseQuery="";
//				
//				if(tree.getRoot() instanceof LeafNode)
//					return ((LeafNode) tree.getRoot()).getPredictedClassValue();//senza modificatore di visibilit�
//				else
//				{
//					int risp;
//					responseQuery=(((SplitNode)tree.getRoot()).formulateQuery());
//					
//					out.writeObject(responseQuery);
//					serverUi.addServerResponse(responseQuery, idClient, Color.BLACK);
//					
//					
//					risp=((Integer)in.readObject()).intValue();
//					serverUi.addClientRequest(""+risp, idClient, Color.BLACK);
//					
//					if(risp==-1 || risp>=tree.getRoot().getNumberOfChildren())
//						throw new UnknownValueException();
//					else
//					{
//						return predictClass(tree.subTree(risp));
//					}
//				
//				}
//			}
			
		}
		
		
		
		
		
		
//		private ServerUi serverUi;
		
		/**
		 * Attributo di tipo <b>int</b> contenente la porta su cui � in ascolto il server
		 * 
		 * @since <b>Alberi di decisione 7.0</b>
		 */
		public static final int PORT = 61234;
		//realizzare il modulo per porta dinamica
		
		
//		HashMap<Integer, ServerOneClient> clients = new HashMap<>();

		/**
		 * Questo membro � il <b>costruttore della classe</b>.<br />
		 * Avvia il thread (usando il metodo <b>start()</b>) e stampa sulla console il messaggio "Server avviato"
		 * 
		 * @since <b>Alberi di decisione 7.0</b>
		 */
		public MultiServer( /* /ServerUi server/**/){
//			serverUi = server;
//			serverUi.appendLogServer("...:::DecisionTree Server:::...\n\nServer in ascolto sui seguenti IP:\n", Color.BLUE);
//			try {
//				serverUi.appendLogServer(getUsingIPAddresses() + "\n\n ...In attesa di connessioni...\n", Color.BLUE);
//			} catch (NoNetworkConnectionException e) {
//				JOptionPane.showMessageDialog(new JDialog(), "Impossibile connettersi alla rete", "Connessione assente", JOptionPane.ERROR_MESSAGE);
//				serverUi.appendLogServer("***Impossibile connettersi alla rete***", Color.RED);
//				serverUi.appendLogServer("\n\n ...In attesa di connessioni da localhost...\n", Color.BLUE);
//			}
			start();
		}
		public static final int PORTUDP = 61235;
		private class NetworkReceiver extends Thread{
			
			private String ipAddress;
			private DatagramSocket dsocket;
			private DatagramPacket dPacketSend;
			private DatagramPacket dPacketRec;
			
			
	        byte[] buf = new byte[65536];
			public NetworkReceiver() {
//				ipAddress=ip;
				start();
			}
			DatagramSocket socket;
		
			@Override
			  public void run() {
				
				String discover="DISCOVER";
				String discovered="DISCOVERED";
				
			    try {
			      //Keep a socket open to listen to all the UDP trafic that is destined for this port
			      socket = new DatagramSocket(PORTUDP, InetAddress.getByName("0.0.0.0"));
			      socket.setBroadcast(true);

			      while (true) {
//			        System.out.println(getClass().getName() + ">>>Ready to receive broadcast packets!");

			        //Receive a packet
			        byte[] recvBuf = new byte[15000];
			        DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
			        socket.receive(packet);

//			        //Packet received
//			        System.out.println(getClass().getName() + ">>>Discovery packet received from: " + packet.getAddress().getHostAddress());
//			        System.out.println(getClass().getName() + ">>>Packet received; data: " + new String(packet.getData()));

			        //See if the packet holds the right command (message)
			        String message = new String(packet.getData()).trim();
			        if (message.equals(discover)) {
			          byte[] sendData = discovered.getBytes();

			          //Send a response
			          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, packet.getAddress(), packet.getPort());
			          socket.send(sendPacket);

//			          System.out.println(getClass().getName() + ">>>Sent packet to: " + sendPacket.getAddress().getHostAddress());
			        }
			      }
			    } catch (IOException ex) {
//			      Logger.getLogger(DiscoveryThread.class.getName()).log(Level.SEVERE, null, ex);
			    }
			  }
//			private void setAddress(InetAddress address) {
//				if (IPServer==null)
//					IPServer=dPacketRec.getAddress();
//			}

			public String getAddress() {
				return ipAddress;
			}
			
		}
		
		
		/**
		 * Questo membro � il metodo utilizzato per avviare una socket che si mette in attesa di nuove connessioni.
		 * <br />
		 * Crea e associa un oggetto di classe <b>ServerOneClient</b> ad ogni nuova connessione 
		 * 
		 * @since <b>Alberi di decisione 7.0</b>
		 */
		@SuppressWarnings("unused")
		public void run(){
			//creare le socket e gestire il tutto
			ServerSocket serverSocket=null;
			try {
				
				new NetworkReceiver();
				
////				serverUi.accessToDatabase();
				serverSocket = new ServerSocket(PORT);
//				serverSocket = new ServerSocket(0);
				
				try{
					while (true){
						//in attesa di connessioni
						Socket socket = serverSocket.accept();
						try{
							//accept connessione
//							ServerOneClient client = new ServerOneClient(socket, serverUi);
							
							ServerOneClient client = new ServerOneClient(socket);
//							, clients.size()+1);
							
//							clients.put(client.getMyID(), client);
//							Text txt= new Text();
//							txt.setStyle("-fx-fill: red;");
//							txt.setText(client.getMyID() + "");
//							txtLog.getChildren().add(txt);
							
							txtLogOld.setText(txtLogOld.getText() + "Nuovo client connesso. ID=" + client.getMyID() + "\n");
//							
//							ArrayList<String> array= new ArrayList<>();
//							array.add("Nuovo client connesso. ID=" + client.getMyID() + "\n");
//							
//							mapClient.put(client.getMyID(), array);
//							datiClient.add("Client_ID = " + client.getMyID());
//							datiOperazioni.addAll(array);
							
						}catch(Exception e){
//							e.printStackTrace();
							//errore: accept connessione fallito
							socket.close();						
						}
						
					}
				}finally{
					//chiusura server
					serverSocket.close();
				}
			}
			catch (IOException e) {
				//errore: impossibile mettersi in ascolto sulla porta indicata
			}
		}
		
		
		
//		private String getUsingIPAddresses () throws NoNetworkConnectionException{
//			String listIPs="";
//			try{
//				for (Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements();) {
//		    		NetworkInterface iface = ifaces.nextElement();
//		    		for (Enumeration<InetAddress> addresses = iface.getInetAddresses(); addresses.hasMoreElements();) {
//		    	    	InetAddress address = addresses.nextElement();
//		    	    	if (address instanceof Inet4Address && !address.getHostAddress().equals("127.0.0.1")){
//		    	    		listIPs+=address.getHostAddress() + "\n";
//		    	    	}
//		    	    }
//		  	  	}
//			} catch (SocketException e){
//				e.printStackTrace();
//			}
//			
//			if (listIPs.length()==0)
//				throw new NoNetworkConnectionException();
//				
//			listIPs=""+listIPs.substring(0, listIPs.length()-1);//"pulizia" dell'ultimo ritorno a capo
//			
//			
//			return listIPs;
//		}
		
		
	}	
	
	
	
	
	
	

	
	
	
	@FXML private TextArea txtLogOld;
//	@FXML private TextFlow txtLog;
	
	private HashMap<Integer, ArrayList<String>> mapClient = new HashMap<>();
	
//	@FXML private ListView<String> lstClient;
//	private ObservableList<String> datiClient = FXCollections.observableArrayList();

//	@FXML private ListView<String> lstOperazioni;
//	private ObservableList<String> datiOperazioni= FXCollections.observableArrayList();

	
	
	
	private Administrator admin=null;
	private MultiServer server;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		server = new MultiServer();
//		lstOperazioni.setItems(datiOperazioni);
//		lstClient.setItems(datiClient);
		
	}
	
//	@FXML
//	public void btnNuovoCliente(ActionEvent e){
//		Command cmd=new Command();
//		cmd.setService(ServiceType.nuovo);
//		cmd.setDto(new Cliente());
//		
//		execute(cmd,e);
//		
//	}
	
	@FXML
	public void btnStatistiche(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.analisi);
		cmd.setDto(new Documento());
		
		execute(cmd,e);
		
	}
	@FXML
	public void btnElencoCliente(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Cliente());
		
		execute(cmd,e);
		
	}
	@FXML
	public void btnElencoSettori(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Settore());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
//	@FXML
//	public void btnNuovoFornitore(ActionEvent e){
//		Command cmd=new Command();
//		cmd.setService(ServiceType.nuovo);
//		cmd.setDto(new Fornitore());
//		
//		execute(cmd,e);
//		
//	}
	@FXML
	public void btnElencoFornitore(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Fornitore());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
//	@FXML
//	public void btnNuovoContatto(ActionEvent e){
//		Command cmd=new Command();
//		cmd.setService(ServiceType.nuovo);
//		cmd.setDto(new Collaboratore());
//		
//		execute(cmd,e);
//		
//	}
	@FXML
	public void btnElencoSubagente(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new SubAgente());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoSegnalatore(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Segnalatore());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoAltro(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Altro());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoGruppoSoc(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new GruppoSocietario());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoConsorzio(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Consorzio());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoPagamento(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Pagamento());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoTrasporto(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Trasporto());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoMinimo(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Minimo());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoCap(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new CAP());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoCitta(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Citta());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoProvincia(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Provincia());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoRegione(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Regione());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoNazione(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Nazione());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoProdotto(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Prodotto());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoGruppoProdotto(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new GruppoProdotto());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoSottoruppoProdotto(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new SottoGruppoProdotto());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoPercentualeF(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new PercentualeFornitore());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoPercentualeC(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new PercentualeCollaboratore());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoFormaGiuridica(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new FormaGiuridica());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoUM(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new UM());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoValidita(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Validita());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoMagazzino(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Magazzino());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoCausaleTrasporto(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new CausaleTrasporto());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
//	@FXML
//	public void btnNuovoProdotto(ActionEvent e){
//		Command cmd=new Command();
//		cmd.setService(ServiceType.nuovo);
//		cmd.setDto(new Prodotto());
//		
//		execute(cmd,e);
//		
//	}
//	@FXML
//	public void btnElencoProdotto(ActionEvent e){
//		Command cmd=new Command();
//		cmd.setService(ServiceType.lista);
//		cmd.setDto(new Prodotto());
//		
//		execute(cmd,e);
//		
//	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
//	@FXML
//	public void btnNuovoProdotto(ActionEvent e){
//		Command cmd=new Command();
//		cmd.setService(ServiceType.nuovo);
//		cmd.setDto(new Prodotto());
//		
//		execute(cmd,e);
//		
//	}
	@FXML
	public void btnElencoDocumento(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Documento());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
//	@FXML
//	public void btnNuovoProdotto(ActionEvent e){
//		Command cmd=new Command();
//		cmd.setService(ServiceType.nuovo);
//		cmd.setDto(new Prodotto());
//		
//		execute(cmd,e);
//		
//	}
	@FXML
	public void btnElencoTipoDocumento(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new TipoDocumento());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
	@FXML
	public void btnElencoIva(ActionEvent e){
		Command cmd=new Command();
		cmd.setService(ServiceType.lista);
		cmd.setDto(new Iva());
		
		execute(cmd,e);
		
	}
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////	

	@Override
	public void injectElement(DTOBase dto) {
		admin=(Administrator) dto;
	}

	@Override
	public void reloadTables() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void discard() {
		// TODO Auto-generated method stub
		
	}
	
}
	
