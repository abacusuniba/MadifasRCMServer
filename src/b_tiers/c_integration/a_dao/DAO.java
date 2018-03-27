package b_tiers.c_integration.a_dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Generated;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jgroups.tests.perf.UPerf.Results;

import com.mysql.jdbc.Connection;

import a_main.RCMException;
import c_dto.a_abstract.Azienda;
//import b_tiers.c_integration.a_dao.DAO.Elements;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.b_real.Cliente;
import c_dto.b_real.Documento;
import c_dto.b_real.Fornitore;
import c_dto.b_real.Layout;
import c_dto.b_real.Lingua;
import c_dto.b_real.RettangoloPDF;
import c_dto.b_real.RettangoloPDFText;
import c_dto.b_real.Riferimento;
import c_dto.b_real.Strada;
import c_dto.b_real.TipoDocumento;
import c_dto.c_enum.IDCampo;
import c_dto.c_enum.Movimentazione;
import c_dto.c_enum.Stato;
import c_dto.c_enum.TextAlign;
import c_dto.c_enum.TipoAzienda;
import d_utils.StringBuilderQuery;

@SuppressWarnings("unused")
public class DAO {
	
	private static void printToConsole1(StringBuilderQuery q) {
		System.out.println(q.toString());
	}
	private static void printToConsole(String q) {
		System.out.println(q);
	}
	
	private static class Mapper{
		private class Discriminator{
			private String discriminatorValue = "";
			private String discriminatorColumn = "";
			
			public Discriminator(String value, String column) {
				discriminatorValue =value;
				discriminatorColumn=column;
			}

			public String getDiscriminatorValue() {
				return discriminatorValue;
			}

			public String getDiscriminatorColumn() {
				return discriminatorColumn;
			}
		}
		@Deprecated
		private class Target{
			private String targetTable = "";
			private String targetColumn = "";
			
			public Target(String table, String column) {
				targetTable =table;
				targetColumn=column;
			}

			public String getTargetTable() {
				return targetTable;
			}

			public String getTargetColumn() {
				return targetColumn;
			}
		}
		private class CoupleID{
			private String field="";
			public String getField() {
				return field;
			}

			public String getColumn() {
				return column;
			}

			private String column="";
			
			public CoupleID(String tField, String tColumn) {
				// TODO Auto-generated constructor stub
				field=tField;
				column=tColumn;
			}
		}
		
		private String tableName="";
//		private List<String> preloadFields = new ArrayList<>();
		private HashMap<String, String> preloadFields = new HashMap<>();
		public HashMap<String, String> subClass = new HashMap<>();
		private HashMap<String, String> fieldList = new HashMap<>();
		private Discriminator discriminator =null;
		
		@Deprecated
		private Target target =null;
		private HashMap<String, String> targets=new HashMap<>();
		private String externalKey;
		private CoupleID coupleId=null;
		public CoupleID getCoupleId() {
			return coupleId;
		}
		public String getTableName() {
			return tableName;
		}
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		public HashMap<String, String> getPreloadFields() {
			return preloadFields;
		}
		public void addPreloadField(String field, String column) {
			preloadFields.put(field, column);
		}
		public HashMap<String, String> getFieldList() {
			return fieldList;
		}
		public void addField(String field, String column) {
			fieldList.put(field, column);
		}
		
		public void setDiscriminator(String value, String column) {
			this.discriminator = new Discriminator(value, column);
		}
		public Discriminator getDiscriminator() {
			return discriminator;
		}
		public void setTarget(String table, String column) {
			this.target = new Target(table, column);
		}
		public Target getTarget() {
			return target;
		}
		public boolean containsPreloadedKey(String key){
//			boolean contain=false;
//			
//			contain = preloadFields.containsKey(key);
//			
			return preloadFields.containsKey(key);
		}
		public void setIDField(String field, String column) {
			coupleId=new CoupleID(field, column);
		}
		
//		@Override
//		public String toString() {
//			String s="";
//			
//			s+="{" + tableName + " [";
//			for (String st : preloadFields){
//				s+=st + ", ";
//			}
//			s=s.substring(0, s.length()-2) + "] (";
//			
//			Iterator<Entry<String, String>> iterator = fieldList.entrySet().iterator();
//			while (iterator.hasNext()){
//				Entry<String, String> el = iterator.next();
//				s+= el.getKey() + "=" + el.getValue() + ", ";
//			}
//			s=s.substring(0, s.length()-2);
//			
//			s+=")}";
//			return s;
//		}
		
		
	}
	
	
	private static final String createQuery="insert into ? (?) values (?);";
	private static final String updateQuery="update ? set ? where ?";
	private static final String deleteQuery="delete from ? where ?";
	private static final String readQuery="select ? from ? where ?";
	private static final String readAllQuery="select ? from ?";
	
	
	private static InputStream inputStreamFile=null;
	private static SAXBuilder builder=null;
	private static SAXBuilder builder2=null;
	private static Document document=null;
	private static Document document2=null;
	private static Element rootNode=null;
	private static Element rootNode2=null;

	
	
//	static{
////		inputStreamFile = DAO.class.getClassLoader().getResourceAsStream("dtiers/cintegration/adao/filterList.xml");
//		inputStreamFile = DAO.class.getClassLoader().getResourceAsStream("b_tiers/c_integration/a_dao/filterList.xml");
//		builder = new SAXBuilder();
//		try {
//			document=builder.build(inputStreamFile);
//		} catch (JDOMException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Deprecated
//	private static final HashMap<Class<?>, HashMap<Long, DTOBase>> memory = new HashMap<>();
	
	
//	@Deprecated
//	public static HashMap<Long, DTOBase> getMemory(Class<?> cls) {
//		return memory.get(cls);
//	}
//	@Deprecated
//	public static void updateMemory(Class<?> cls, HashMap<Long, DTOBase> partial){
//		memory.put(cls, partial);
//	}
	
	

	private static final String DRIVER_CLASS_NAME="org.gjt.mm.mysql.Driver";
	private static final String DBMS="jdbc:mysql";
	private static final String SERVER="localhost";
	private static final String PORT="3306";
	
//	private static final String DATABASE="cooking";
	private static final String DATABASE="databasercm";

	private static final String USER_ID="root";
	private static final String PASSWORD="";
	
	private static Statement statement;
	private static Statement statement2;
	private static ResultSet rs;
	
	private static Connection dataBaseConnection;
	
	
	
	
	
	
	
//////DATABASE CONNECTION
	private static Connection getConnection() {
		
		if (dataBaseConnection==null)
			initConnection();
		
		return dataBaseConnection;
	}
	
	private static void initConnection() {
	        try {
	        	Class.forName(DRIVER_CLASS_NAME);
	            dataBaseConnection = (Connection) DriverManager.getConnection(DBMS+"://"+SERVER+":"+PORT+"/"+DATABASE,USER_ID,PASSWORD);
	        }
	        catch (ClassNotFoundException | SQLException e) {
	            try {
					dataBaseConnection = (Connection) DriverManager.getConnection(DBMS+"://"+SERVER+":"+PORT+"/"+DATABASE,"acs","acs");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
		            try {
						dataBaseConnection = (Connection) DriverManager.getConnection(DBMS+"://"+SERVER+":"+PORT+"/"+DATABASE,"root","root");
					} catch (SQLException e2) {
			            try {
							dataBaseConnection = (Connection) DriverManager.getConnection(DBMS+"://"+SERVER+":"+PORT+"/"+DATABASE,"root","acs");
						} catch (SQLException e3) {
							// TODO Auto-generated catch block
//							e1.printStackTrace();
						}
					}
				}
	        }
	}

////READ
//	@Deprecated
//	public static ResultSet oldRead(DTOBase o){
//		try{
//			statement = getConnection().createStatement1();
//			rs = statement.executeQuery(o.getReadQuery());
//		} 
//		catch (SQLException | NullPointerException e) {
//		} 
//		
//		return rs;
//	}
	
//	@Deprecated
//	public static ResultSet readAll(DTOBase o){
//		try{
//			statement = getConnection().createStatement1();
//			rs = statement.executeQuery(o.getReadAllQuery());
//		}
//		catch (SQLException | NullPointerException e) {
//		} 
//		
//		return rs;
//	}
//	@Deprecated
//	public static ResultSet readAll(Class<?> cls){
////		try{
////			statement = getConnection().createStatement1();
////			rs = statement.executeQuery(o.getReadAllQuery());
////		}
////		catch (SQLException | NullPointerException e) {
////		} 
////		
////		return rs;
//		return null;
//	}

//	//UPDATE
//	@Deprecated
//	public static void oldUpdate(DTOBase o){
//		try {
//			statement = getConnection().createStatement1();
//			statement.execute1(o.getUpdateQuery());
//			statement.execute1Update(o.getSubQuery());
//		}
//		catch (SQLException | NullPointerException e) {
//		}
//	}

	//DELETE
	public static void delete(DTOBase o){
		
		
		deleteNew(o);
		
		
//		try {
//		HashMap<String, String> fields = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).fieldList;
//		StringBuilderQuery myQuery=null;
//		
////		if (fields.size()==0){
//		fields.putAll(fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).preloadFields);
//		
//		boolean found=false;
//		for (Entry<String, String> s : fields.entrySet()){
//			Field f = retrieveField(s.getKey(), o.getClass());
//			//lo rendo accessibile
//			f.setAccessible(true);
//			
//			if (f.getType().isEnum()){
//				
//				String atomicClassName = f.getType().getSimpleName().toLowerCase();
//				switch(atomicClassName){
//				case "stato":
//					found=true;
//					myQuery= new StringBuilderQuery(updateQuery);
//					myQuery.setField(1, getTable(o));
//					myQuery.setField(2, s.getValue() + "=" + Stato.fromName(Stato.Archiviato));
//					myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
//					
//					getConnection().createStatement1().execute1Update(myQuery.toString());
//					
////					System.out.println();
////					f.set(o, Stato.fromValue(rs2.getInt(s.getValue())));
//					break;
//				default:
//					break;
//				}
//			}
//			
//		}
//		
//		
//		if (found==false){
//			myQuery= new StringBuilderQuery(deleteQuery);
//			myQuery.setField(1, getTable(o));
//			myQuery.setField(2, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
////			System.out.println();
//			getConnection().createStatement1().execute1Update(myQuery.toString());
//		}
//		
//		
////			statement = getConnection().createStatement1();
////			String s = o.getDeleteQuery();
////			statement.execute1(s);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	
	
	private void ____________________________________________0OK(){}
	
	
//	@Deprecated
//	private static HashMap<String, Mapper> fieldMapper;
	
	
	
	private static BaseMapper myMapper;
	
//	@Deprecated
//	public static String getColumn(String it, Class<?> myClass) {
//		String column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).preloadFields.get(it);
//		
//		if (column==null){
//			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
//			if (column==null){
//				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
//			}
//		}
//		return column;
//	}
	
	
	
	
	HashMap<DTOBase, Object> tutteLeSubQueries = new HashMap<>();
	
	static {
		
		
		Logger.getLogger("ac.biu.nlp.nlp.engineml").setLevel(Level.OFF);
		Logger.getLogger("org.BIU.utils.logging.ExperimentLogger").setLevel(Level.OFF);
		Logger.getRootLogger().setLevel(Level.OFF);
//		fieldMapper = new HashMap<>();
//		try {
////			InputStream inputStreamFile = this.getClass().getResourceAsStream("fieldColumn.xml");
//			InputStream inputStreamFile = DAO.class.getResourceAsStream("fieldColumn.xml");
//			builder= new SAXBuilder();
////			document= builder.build(forms);
//			document= builder.build(inputStreamFile);
//			rootNode=document.getRootElement();
//			
//			for (Element el : rootNode.getChildren()){
//				//istanzio la classe Mapper
//				Mapper map = new Mapper();
//				
//				
//				//verifica la presenza dell'attributo discriminatore
//				Element dscrmntr = el.getChild("discriminator");
//				if (dscrmntr!=null){
//					map.setDiscriminator(dscrmntr.getAttributeValue("value"), dscrmntr.getAttributeValue("column"));
//				}
////				String trgt = el.getName();
////				if (trgt.equals("target")){
////					map.targets.put(el.getAttributeValue("table"), el.getAttributeValue("column"));
//////					map.setTarget(trgt.getAttributeValue("table"), trgt.getAttributeValue("column"));
////				}
//				
//				//imposto la chiave nell'hashmap
//				fieldMapper.put(el.getAttributeValue("class"), map);
//				///////////////////////////////
//				//imposto il nome della tabella
//				map.setTableName(el.getAttributeValue("table"));
//				
//				//imposto i campi da dover pre-caricare
//				//gli id sono di default su tutti
////				map.addPreloadField(rootNode.getAttributeValue("field"), rootNode.getAttributeValue("column"));
//				map.setIDField(rootNode.getAttributeValue("field"),rootNode.getAttributeValue("column"));
//				
//				
//				String preloadFields = el.getAttributeValue("preload");
//				//ricavo tutti gli elementi relativi agli attributi (field)
//				for (Element elemento : el.getChildren("field")){
//					String fieldName = elemento.getAttributeValue("name");
//					String columnName = elemento.getAttributeValue("column");
//					if (preloadFields.contains(fieldName)){
//						map.addPreloadField(fieldName, columnName);
//					}
//					else{
//						map.addField(fieldName, columnName);
//					}
//				}
//				
//				
//				
//				//ricavo tutti gli elementi relativi alle chiavi esterne (target)
//				for (Element elemento : el.getChildren("target")){
//					String tableName = elemento.getAttributeValue("table");
//					String columnName = elemento.getAttributeValue("column");
//					if (tableName!=null){
//						map.targets.put(tableName, columnName);
//					}
//					else{
//						map.externalKey= columnName;
//					}
//				}
////				
////				
////				
////				
////				
////				
////				//gli attributi delle classi (con le colonne associate)
////				for(String fieldName : el.getAttributeValue("preload").split(", ")){
////					List<Element> list = el.getChildren();
////					for (int i=0; i< list.size(); i++){
//////						if (fieldName.equals(list.get(i).getAttributeValue("name"))){
//////							map.addPreloadField(fieldName, list.get(i).getAttributeValue("column"));
//////							i=list.size();
//////						}
//////						
//////						
////						String trgt = list.get(i).getName();
////						if (trgt.equals("target")){
////							String table = list.get(i).getAttributeValue("table");
////							if (table!=null){
////								map.targets.put(table, list.get(i).getAttributeValue("column"));
////							}
////							else{
//////								System.out.println();
////								map.externalKey= list.get(i).getAttributeValue("column");
////							}
////						}
////						else{
////							if (fieldName.equals(list.get(i).getAttributeValue("name"))){
////								map.addPreloadField(fieldName, list.get(i).getAttributeValue("column"));
////								i=list.size();
////							}
////						}
////						
////					}
//////					String col = "";
//////
//////					for (Element sub : el.getChildren()){
//////						if (fieldName.equals(sub.getAttributeValue("name"))){
//////							col=sub.getAttributeValue("column");
////////							map.addField(sub.getAttributeValue("name"), sub.getAttributeValue("column"));
//////						}
//////					}
//////					map.addPreloadField(fieldName, col);
////				}
////				
////				//imposto la mappatura dei campi rimanenti con le relative colonne
////				for (Element sub : el.getChildren()){
////					String key = sub.getAttributeValue("name");
////					String value=sub.getAttributeValue("column");
////					if (value!=null){
////						if (!map.containsPreloadedKey(key) && key!=null)
////							map.addField(key, value);
////					}
////					else{
////							map.subClass.put(key, sub.getAttributeValue("class"));
////					}
////				}
////				
//////				map.addField(rootNode.getAttributeValue("dField"), rootNode.getAttributeValue("dColumn"));
//////				for (Element sub : el.getChildren()){
//////					map.addField(sub.getAttributeValue("name"), sub.getAttributeValue("column"));
//////				}
//////				
//////				fieldMapper.put(el.getAttributeValue("class"), map);
//			}
////			System.out.print("");
//			
//		} catch (JDOMException | IOException e) {
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		//passaggio rifatto
		myMapper = new BaseMapper();
		try {
//			InputStream inputStreamFile2 = this.getClass().getResourceAsStream("fieldColumn.xml");
			InputStream inputStreamFile2 = DAO.class.getResourceAsStream("fieldColumn2.xml");
			builder2= new SAXBuilder();
//			document= builder.build(forms);
			document2= builder2.build(inputStreamFile2);
			rootNode2=document2.getRootElement();
			
			myMapper.basePath=rootNode2.getAttributeValue("basepath");
			
			
//			for (Element commons: rootNode2.getChild("common").getChildren()) {
//				
//				myMapper.commons.put(commons.getAttributeValue("name"), commons.getAttributeValue("column"));
//			}
			
				
				
			for (Element entity: rootNode2.getChildren("entity")) {
				DTOMapper entityMapper = new DTOMapper();
				entityMapper.table=entity.getAttributeValue("table");
//				if (entityMapper.table.equals("nazione")){
//					System.out.print("");
//				}
				
//				Element subElement = entity.getChild("secondarytables");
//				if (subElement!=null) {
//					List<Element> subElements = subElement.getChildren("table");
//					for (Element subElem: subElements) {
//						
//						String tableName = subElem.getAttributeValue("name");
//						
//						
//						Secondaries secondaryClass = new Secondaries();
//						
//						Element subSubElement = subElem.getChild("id");
//						secondaryClass.id= new Identifier();
//						secondaryClass.id.column=subSubElement.getAttributeValue("column");
//						secondaryClass.id.field=subSubElement.getAttributeValue("name");
//						
//						
//						
//						
//						List<Element> secondarySubList = subElem.getChildren("priority");
//						
//						for (Element e : secondarySubList) {
//							Elements elements=new Elements();
//							
//							for (Element sub1: e.getChildren("field")) {
//								elements.fields.put(sub1.getAttributeValue("name"), sub1.getAttributeValue("column"));
//							}
//							for (Element sub1: e.getChildren("sub")) {
//								elements.subs.put(sub1.getAttributeValue("name"), sub1.getAttributeValue("column"));
//							}
//							for (Element sub1: e.getChildren("enum")) {
//								elements.enums.put(sub1.getAttributeValue("name"), sub1.getAttributeValue("column"));
//							}
//							for (Element sub1: e.getChildren("list")) {
//								elements.lists.add(sub1.getAttributeValue("name"));
//							}
////							
////							
////							
////							
//							secondaryClass.elements.put(Integer.parseInt(e.getAttributeValue("value")), elements);
//						}
//						
//						
//						
//						
//						
//						
//						entityMapper.secondaries.put(tableName, secondaryClass);
//						
//						
//					}
//					
//					
////					entityMapper.discriminator= new Discriminator();
////					entityMapper.discriminator.column=subElement.getAttributeValue("column");
////					entityMapper.discriminator.value=Integer.parseInt(subElement.getAttributeValue("value"));
//				}
				Element subElement = entity.getChild("discriminator");
				if (subElement!=null) {
					entityMapper.discriminator= new Discriminator();
					entityMapper.discriminator.column=subElement.getAttributeValue("column");
					entityMapper.discriminator.value=Integer.parseInt(subElement.getAttributeValue("value"));
				}
				subElement = entity.getChild("id");
				if (subElement!=null) {
					entityMapper.id= new Identifier();
					entityMapper.id.column=subElement.getAttributeValue("column");
					entityMapper.id.field=subElement.getAttributeValue("name");
				}
				subElement = entity.getChild("father");
				if (subElement!=null) {
					entityMapper.father=subElement.getAttributeValue("column");
					if (subElement.getAttributeValue("ref")!=null)
						entityMapper.refFather=subElement.getAttributeValue("ref");
				}
				List<Element> subList = entity.getChildren("manytomany");
				if (subList!=null && subList.size()>0) {
					entityMapper.manyToMany=new ArrayList<>();
					for (Element elem: subList) {
						MToM relation = new MToM();
						relation.destinationClass=elem.getAttributeValue("class");
						relation.column=elem.getAttributeValue("column");
						relation.table=elem.getAttributeValue("table");
						entityMapper.manyToMany.add(relation);
					}
//					entityMapper.father=subElement.getAttributeValue("column");
				}

				
				subList = entity.getChildren("priority");
				
				for (Element e : subList) {
					Elements elements=new Elements();
					
					for (Element sub1: e.getChildren("field")) {
						elements.fields.put(sub1.getAttributeValue("name"), sub1.getAttributeValue("column"));
					}
					for (Element sub1: e.getChildren("sub")) {
						elements.subs.put(sub1.getAttributeValue("name"), sub1.getAttributeValue("column"));
					}
					for (Element sub1: e.getChildren("enum")) {
						elements.enums.put(sub1.getAttributeValue("name"), sub1.getAttributeValue("column"));
					}
					for (Element sub1: e.getChildren("list")) {
						elements.lists.add(sub1.getAttributeValue("name"));
					}
//					
//					
//					
//					
					entityMapper.elements.put(Integer.parseInt(e.getAttributeValue("value")), elements);
				}
				
				
				
				
				
				myMapper.mapper.put(entity.getAttributeValue("class"), entityMapper);
			}
				
			
			
			
//			System.out.println(myMapper);
//			for (Element el : rootNode2.getChildren()){
//				
//				
//				
////				//istanzio la classe Mapper
////				Mapper map = new Mapper();
////				
////				
////				//verifica la presenza dell'attributo discriminatore
////				Element dscrmntr = el.getChild("discriminator");
////				if (dscrmntr!=null){
////					map.setDiscriminator(dscrmntr.getAttributeValue("value"), dscrmntr.getAttributeValue("column"));
////				}
//////				String trgt = el.getName();
//////				if (trgt.equals("target")){
//////					map.targets.put(el.getAttributeValue("table"), el.getAttributeValue("column"));
////////					map.setTarget(trgt.getAttributeValue("table"), trgt.getAttributeValue("column"));
//////				}
////				
////				//imposto la chiave nell'hashmap
////				fieldMapper.put(el.getAttributeValue("class"), map);
////				///////////////////////////////
////				//imposto il nome della tabella
////				map.setTableName(el.getAttributeValue("table"));
////				
////				//imposto i campi da dover pre-caricare
////				//gli id sono di default su tutti
//////				map.addPreloadField(rootNode.getAttributeValue("field"), rootNode.getAttributeValue("column"));
////				map.setIDField(rootNode2.getAttributeValue("field"),rootNode2.getAttributeValue("column"));
////				
////				
////				String preloadFields = el.getAttributeValue("preload");
////				//ricavo tutti gli elementi relativi agli attributi (field)
////				for (Element elemento : el.getChildren("field")){
////					String fieldName = elemento.getAttributeValue("name");
////					String columnName = elemento.getAttributeValue("column");
////					if (preloadFields.contains(fieldName)){
////						map.addPreloadField(fieldName, columnName);
////					}
////					else{
////						map.addField(fieldName, columnName);
////					}
////				}
////				
////				
////				
////				//ricavo tutti gli elementi relativi alle chiavi esterne (target)
////				for (Element elemento : el.getChildren("target")){
////					String tableName = elemento.getAttributeValue("table");
////					String columnName = elemento.getAttributeValue("column");
////					if (tableName!=null){
////						map.targets.put(tableName, columnName);
////					}
////					else{
////						map.externalKey= columnName;
////					}
////				}
//			}
		} catch (JDOMException | IOException e) {
			RCMException.showException(e);
		}
		
		
	}
	
	
//	private static String getFields(DTOBase o){
//		String className = o.getClass().getSimpleName().toLowerCase();
//		String fields = "";
//		Iterator<Entry<String, String>> i = fieldMapper.get(className).getFieldList().entrySet().iterator();
//		
//		while (i.hasNext()){
//			fields += i.next().getKey() + ", ";
//		}
//		fields = fields.substring(0, fields.length()-2);
//		
//		return fields;
//	}
//	private static String getColumns(DTOBase o){
//		String className = o.getClass().getSimpleName().toLowerCase();
//		String fields = "";
//		Iterator<Entry<String, String>> i = fieldMapper.get(className).getFieldList().entrySet().iterator();
//		
//		while (i.hasNext()){
//			fields += i.next().getValue() + ", ";
//		}
//		fields = fields.substring(0, fields.length()-2);
//		
//		return fields;
//	}
	
//	@Deprecated
//	public static String getColumnFiltered(Object[] array){
//		String column=fieldMapper.get(array[0]).preloadFields.get(array[1]);
//		
//		return column;
//	}
	
//	public static String getFilteredColumns(Class<?> c){
//		String className = c.getSimpleName().toLowerCase();
//		String fields = "";
//		
//		for (String s : fieldMapper.get(className).getPreloadFields().values()){
//			fields += s + ", ";
//		}
//		
////		Iterator<Entry<String, String>> i = fieldMapper.get(className).getPreloadFields();
////		
////		while (i.hasNext()){
////			fields += i.next().getValue() + ", ";
////		}
//		fields = fields.substring(0, fields.length()-2);
//		fields+= ", " + fieldMapper.get(className).coupleId.getColumn();
//		
//		return fields;
//	}
//	public static String getFilteredFields(Class<?> c){
//		String className = c.getSimpleName().toLowerCase();
////		String fields = "";
//		String fields = fieldMapper.get(className).getCoupleId().getField() + ", ";
//		
//		for (String s : fieldMapper.get(className).getPreloadFields().keySet()){
//			fields += s + ", ";
//		}
//		
////		Iterator<Entry<String, String>> i = fieldMapper.get(className).getPreloadFields();
////		
////		while (i.hasNext()){
////			fields += i.next().getValue() + ", ";
////		}
//		fields = fields.substring(0, fields.length()-2);
//		
//		return fields;
//	}
//	private static String getIDs() {
//		return 
//	}
//	public static String getAllFields(Class<?> c){
//		String className = c.getSimpleName().toLowerCase();
//		String fields = "";
//		
//		for (String s : fieldMapper.get(className).getPreloadFields().keySet()){
//			fields += s + ", ";
//		}
//		String keys[] = fields.split(", ");
//		boolean found =false;
//		for (String s : fieldMapper.get(className).getFieldList().keySet()){
//			for (int i=0; i< keys.length && !found;i++){
//				found = s.equals(keys[i]);
//			}
//			if (!found)
//				fields += s + ", ";
//			else
//				found=false;
//		}
//		
//		keys = fields.split(", ");
//		found=false;
//		for (String s : fieldMapper.get(className).subClass.keySet()){
////			if(s!=null && !fields.contains(", " + s))
////			fields += s + ", ";
//			for (int i=0; i< keys.length && !found;i++){
//				found = s.equals(keys[i]);
//			}
//			if (!found)
//			fields += s + ", ";
//			else
//				found=false;
//		}
//		
////		Iterator<Entry<String, String>> i = fieldMapper.get(className).getPreloadFields();
////		
////		while (i.hasNext()){
////			fields += i.next().getValue() + ", ";
////		}
//		fields = fields.substring(0, fields.length()-2);
//		
//		return fields;
//	}
//	public static String getAllColumns(Class<?> c){
//		String className = c.getSimpleName().toLowerCase();
//		String fields = "";
//		
//		for (String s : fieldMapper.get(className).getPreloadFields().values()){
//			if(s!=null /*&& !fields.contains(", " + s)*/)
//			fields += s + ", ";
//		}
//		
//		String keys[] = fields.split(", ");
//		boolean found =false;
//		for (String s : fieldMapper.get(className).getFieldList().values()){
//			for (int i=0; i< keys.length && !found;i++){
//				if (s!=null)
//					found = s.equals(keys[i]);
//			}
//			if (!found && s!=null)
//			fields += s + ", ";
//		}
//		
//		keys = fields.split(", ");
//		found =false;
//		for (String s : fieldMapper.get(className).subClass.values()){
//			for (int i=0; i< keys.length && !found;i++){
//				if (s!=null)
//					found = s.equals(keys[i]);
//			}
//			if (!found && s!=null)
//			fields += s + ", ";
//		}
//		
//		
//		
////		for (String s : fieldMapper.get(className).getFieldList().values()){
////			if(s!=null && !fields.contains(", " + s))
////			fields += s + ", ";
////		}
////		for (String s : fieldMapper.get(className).subClass.values()){
////			if(s!=null && !fields.contains(", " + s))
////			fields += s + ", ";
////		}
//		
////		Iterator<Entry<String, String>> i = fieldMapper.get(className).getPreloadFields();
////		
////		while (i.hasNext()){
////			fields += i.next().getValue() + ", ";
////		}
//		fields = fields.substring(0, fields.length()-2);
//		
//		return fields;
//	}
//	
//	private static String getTable(DTOBase o){
//		String className = o.getClass().getSimpleName().toLowerCase();
//		return fieldMapper.get(className).getTableName();
//	}
//	private static String getTable(Class<?> c){
//		String className = c.getSimpleName().toLowerCase();
//		return fieldMapper.get(className).getTableName();
//	}
//	private static String getValues (DTOBase o){
//		String value ="";
//		String className = o.getClass().getSimpleName().toLowerCase();
//		
//		String[] fields = getFields(o).split(", ");
//		
//		for (String fieldName : fields){
//			Field field=null;
////			String fieldValue="";
//			try {
////				Field field = o.getClass().getField(fieldName);
//				Class<?> superClass = o.getClass();
//				boolean found = false;
//				while(!found){
//					try {
//						field = superClass.getDeclaredField(fieldName);
//						found=true;
//					} catch (NoSuchFieldException | SecurityException e1) {
//						superClass = superClass.getSuperclass();
//					}
//					
//				}
//				
//				
//				field.setAccessible(true);
//				String fieldType = field.getType().getSimpleName().toLowerCase();
////				String fieldValue="";
//				
//				switch (fieldType){
//				case "string"1:
//					value += "'" + field.get(o) + "'";					
//					break;
//				case "stato":
//					value += "" + Stato.fromName((Stato) field.get(o)) + "";					
//					break;
//				case "tipoazienda":
//					value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
//					break;
//				case "movimentazione":
//					value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//					break;
//				}
//				value +=", ";
//				
////				if (fieldType.equals("string")){
////					fieldValue = "'" + field.get(o) + "'";					
////				}
////				else if (fieldType.equals("")){
////					fieldValue = "'" + field.get(o) + "'";					
////				}
//				
//			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
//				e.printStackTrace();
//////				e.printStackTrace();
////				Class<?> superClass = o.getClass().getSuperclass();
////				while(!found){
////					try {
////						Field field = superClass.getDeclaredField(fieldName);
////					} catch (NoSuchFieldException | SecurityException e1) {
////						superClass = superClass.getSuperclass();
////					}
////					
////				}
////				
//			}
//			
//		}
//		value=value.substring(0, value.length()-2);
//		
//		return value;
//	}
	
	private static  Field retrieveField(String it, Class<?> type) {
		Field f = null;
		Class<?> superClass = type;
		boolean found = false;
		while(!found){
			try {
				f = superClass.getDeclaredField(it);
				found=true;
			} catch (Exception/*NoSuchFieldException | SecurityException*/ e1) {
				superClass = superClass.getSuperclass();
			}
		}
		return f;
	}
	
	
	//////CRUD
			//CREATE
	
//	@Deprecated
//	static
//	ArrayList<StringBuilderQuery> subQueries=new ArrayList<>();
	
	static HashMap<DTOBase, HashMap<DTOBase, StringBuilderQuery>> newSubQueries = new HashMap<>();
	
			@Deprecated public static void create(DTOBase o){
				
				createNew(o);
				
//				
//				//ricavare l'elenco degli attributi
//				String columnList="";
//				String valueList="";
//				
//				
//				
//				try {
//				
//				for (String it: DAO.getAllFields(o.getClass()).split(", ")){
//					//ricavo l'attributo sulla base del nome
//					Field f = retrieveField(it, o.getClass());
//					//lo rendo accessibile
//					f.setAccessible(true);
////					System.out.println();
//					
//					
//					if (!List.class.isAssignableFrom(f.getType())){
//						//e lo vado ad avvalorare
//						//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//						String column = DAO.getColumn(it, o.getClass());
//						
//						columnList+=column + ", ";
//						
////					if (f.getType() instanceof ArrayList<?>){
//						if (!DTOBase.class.isAssignableFrom(f.getType())){
////							if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//								//valuta attributo atomico
//								String atomicClassName = f.getType().getSimpleName().toLowerCase();
////								String column = DAO.getColumn(it, o.getClass());
//								if (f.getType().isEnum()){
//									switch(atomicClassName){
//									case "stato":
//											valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////										f.set(o, Stato.fromValue(rs.getInt(column)));
//										break;
//									case "tipoazienda":
//										valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//										break;
//									case "movimentazione":
//										valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//										break;
//									default:
//										break;
//									}
//								}
//								else{
//									switch(atomicClassName){
//									case "string"1:
//										valueList+= "'" + f.get(o) + "', ";
////										f.set(o, rs.getString(column));
//										break;
//									case "long":
////										f.set(o, rs.getLong(column));
//										break;
//									case "int":
//										valueList+= "" + f.get(o) + ", ";
//										break;
//									case "boolean":
//										valueList+= "" + f.get(o) + ", ";
//										break;
//									case "float":
//										valueList+= "" + f.get(o) + ", ";
//										break;
//									case "double":
//										valueList+= "" + f.get(o) + ", ";
//										break;
//									default:
//										break;
//									}
//								}
//							}
//							else{
//								//caricare i campi "filtrati" del sottotipo
//								//si tratta di un oggetto di cui devo ricavare solo l'ID
//								try{
//								valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//								}
//								catch(NullPointerException e){
//									valueList+= " NULL , ";
//								}
////								HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////								f.set(o, subElements.get(rs.getLong(column)));
//							}
//					}
//					else{
//						//gestire gli array
//						@SuppressWarnings("unused")
//						StringBuilderQuery subQuery = new StringBuilderQuery(createQuery);
//						
//						ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(o);
//						
//			            Type type = f.getGenericType();
//
//			            if (type instanceof ParameterizedType) {
//
//			                ParameterizedType pType = (ParameterizedType)type;
//			                Type[] arr = pType.getActualTypeArguments();
//			                Class<?> innerClass = (Class<?>) arr[0];
//			                
//			                
//			                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//			                
////			                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
//			                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
//			                
//			                
////			        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
//			        		
//			                
//			                if (externalKey!=null){
//				        		for (DTOBase elem: lista){
//				        			
////				        			subQueries.addAll(extractSubQueries(elem));
//				        			
//				        			HashMap lista2 = newSubQueries.get(o);
//			        				Object partial = extractCreateSubQueries(elem);
//			        				
//			        				if (partial instanceof StringBuilderQuery){
//			        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
//			        				}
////					        		for (StringBuilderQuery subs : partial){
////										subs.replaceAll("__", externalKey);
////					        		}
//				        			try{
////					        			lista2.addAll(partial);
//					        			lista2.put(elem, partial);
////					        			newSubQueries.put(o, lista2);
//				        			}
//				        			catch(Exception e){
//				        				lista2 = new HashMap<>();
//					        			lista2.put(elem, partial);
//					        			newSubQueries.put(o, lista2);
//				        			}
//				        			
//				        			
//				        			
////				        			newSubQueries.put(elem, extractSubQueries(elem));
//				        			
//				        			
////					        		subQuery.setTable(1, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).tableName);
////
////					        		String subColumns = externalKey + ", ";// + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////					        		
////									for (String subIt: DAO.getAllFields(f.getType()).split(", ")){
////										
////									}
//					        		
////					        		subQuery.setField(2, subColumns);
////					        		
////					        		String subValues = "";
//////					        		for (DTOBase elem: lista){
////					        			subValues += elem.getId() + ", ??";
//////					        		subValues=subValues.substring(0, subValues.length()-4);
//////					        		String subValues = o.getId() + ", ??";
//////					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////					        		
////					        		subQuery.setField(3, subValues);
////					        		subQueries.add(subQuery);
////					        		subQuery = new StringBuilderQuery(createQuery);
//					        		}
//				        		
//				        		
//				        		
//////				        		for (StringBuilderQuery subs : subQueries){
//////									subs.replaceAll("__", externalKey);
//////				        		}
////								for (Object subs : newSubQueries.values()){
////									if (subs instanceof StringBuilderQuery)
////										((StringBuilderQuery)subs).replaceAll("__", externalKey);
////								}
//				        		
//				        		
//			                	
//			                }else{
//			                	Entry<String, String> iter=entries.next();
//			                	
//			                	HashMap<String, String> trgt = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets;
//				                String key= iter.getKey();
//			                	while (!trgt.containsKey(key)){
//			                		iter=entries.next();
//			                		key= iter.getKey();
//			                	}
//			                	
//				                String value=iter.getValue();
//				        		for (DTOBase elem: lista){
//					        		subQuery.setTable(1, key);
//					        		
//					        		String subColumns = value + ", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
//					        		subQuery.setField(2, subColumns);
//					        		
//					        		String subValues = "";
////					        		for (DTOBase elem: lista){
//					        			subValues += elem.getId() + ", ??";
////					        		subValues=subValues.substring(0, subValues.length()-4);
////					        		String subValues = o.getId() + ", ??";
////					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
//					        		
//					        		subQuery.setField(3, subValues);
//////					        		subQueries.add(subQuery);
////					        		newSubQueries.put(subQuery, null);
//					        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(o);
//				        			try{
////					        			lista2.addAll(partial);
//				        				sbQuery.put(elem, subQuery);
////					        			newSubQueries.put(o, lista2);
//				        			}
//				        			catch(Exception e){
//				        				sbQuery = new HashMap<>();
//				        				sbQuery.put(elem, subQuery);
//					        			newSubQueries.put(o, sbQuery);
//				        			}
//					        		subQuery = new StringBuilderQuery(createQuery);
//					        		}
//			                }
//			                
////			        		System.out.println();
////			        		System.out.println();
////			        		System.out.println();
//			        		
////			        		if (column==null){
////			        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
////			        			if (column==null){
////			        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
////			        			}
////			        		}
//////			                for (Type tp: arr) {
//////			                    Class<?> clzz = (Class<?>)tp;
//////			                    System.out.println(clzz.getName());
//////			                }
//			            }
//						
//					}
//					
//				}
//				
//				columnList=columnList.substring(0,columnList.length()-2);
////				System.out.println();
//				valueList=valueList.substring(0,valueList.length()-2);
//				
//				
//				if (fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
//					columnList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
//					valueList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//				}
//				
//				
//				
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//				
//				StringBuilderQuery myQuery=new StringBuilderQuery(createQuery);
//				
//				myQuery.setTable(1, getTable(o));
////				myQuery.setField(2, getColumns(o));
////				myQuery.setField(3, getValues(o));
//				myQuery.setField(2, columnList);
//				myQuery.setField(3, valueList);
//				
//				
//				
//				
//				try {
//					statement = getConnection().createStatement1();
////					statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//					statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//					ResultSet rs = statement.getGeneratedKeys();
//					rs.next();
//					o.setId(rs.getLong(1));
//					
////					for (StringBuilderQuery subs : subQueries){
////						subs.replaceAll("??", o.getId());
////						statement.execute1Update(subs.toString());
////					}
//					
//					HashMap<DTOBase, StringBuilderQuery> firstPass = newSubQueries.get(o);
//					if (firstPass!=null){
//						newSubQueries.remove(o);
//						for (DTOBase subKey : firstPass.keySet()){
//							StringBuilderQuery subElementQuery = firstPass.get(subKey);
//							subElementQuery.replaceAll("??", o.getId());
//							
//							if (newSubQueries.containsKey(subKey)){
//								statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//								ResultSet rs2 = statement.getGeneratedKeys();
//								rs2.next();
//								subKey.setId(rs2.getLong(1));
//							}
//							else{
//								statement.execute1Update(subElementQuery.toString());
//							}
//							
//							
//						}
//					}
//					
//					
//					
//					for (DTOBase subs : newSubQueries.keySet()){
//						HashMap<DTOBase, StringBuilderQuery> subElement = newSubQueries.get(subs);
//						
//						for (DTOBase subKey : subElement.keySet()){
//							StringBuilderQuery subElementQuery = subElement.get(subKey);
//							subElementQuery.replaceAll("??", subs.getId());
//							
//							if (newSubQueries.containsKey(subKey)){
//								statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//								ResultSet rs2 = statement.getGeneratedKeys();
//								rs2.next();
//								subKey.setId(rs2.getLong(1));
//							}
//							else{
//								statement.execute1Update(subElementQuery.toString());
//							}
//							
//							
//						}
//						
//						
////						if (subs instanceof StringBuilderQuery){
////							((StringBuilderQuery) subs).replaceAll("??", o.getId());
////							statement.execute1Update(subs.toString());
////						}
//					}
//					
//					
//					
//					
////					statement.execute1Update(o.getSubQuery());
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				newSubQueries=new HashMap<>();
//	//			try{
//	//				statement = getConnection().createStatement1();
//	//				
//	//				StringBuilderQuery query = new StringBuilderQuery(createQuery);//"insert into ? (?) values (?);"
//	//				query.setTable(1, extractTable(o));
//	//				query.setTable(2, extractOnlyFields(o));
//	//				query.setTable(3, extractFieldValues(o));
//	//	//			query.setTable(1, getTable());
//	//	////			query.append(getTable());
//	//	//			query.setValue(2, getId());
//	//	////			query.append(getId());
//	//	//					
//	//	//			return query.toString();
//	//				
//	//				
//	//				
//	////				statement.execute1Update(getAllFields(o),Statement.RETURN_GENERATED_KEYS);
//	//				statement.execute1Update(query.toString(),Statement.RETURN_GENERATED_KEYS);
//	//				ResultSet rs = statement.getGeneratedKeys();
//	//				rs.next();
//	//				o.setId(rs.getLong(1));
//	//			}
//	//			catch (SQLException | NullPointerException e) {
//	//				e.printStackTrace();
//	//			} 
			}
			
//	private static ArrayList<StringBuilderQuery> extractSubQueries(DTOBase elem) {
//	private static Object extractCreateSubQueries(DTOBase elem) {
//		//ricavare l'elenco degli attributi
//		String columnList="";
//		String valueList="";
//		Object subQueries=null;
//		try {
//		
//		for (String it: DAO.getAllFields(elem.getClass()).split(", ")){
//			//ricavo l'attributo sulla base del nome
//			Field f = retrieveField(it, elem.getClass());
//			//lo rendo accessibile
//			f.setAccessible(true);
////			System.out.println();
//			
//			
//			if (!List.class.isAssignableFrom(f.getType())){
//				//e lo vado ad avvalorare
//				//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//				
//				
//				String column = DAO.getColumn(it, elem.getClass());
//				
//				columnList+=column + ", ";
//				
////			if (f.getType() instanceof ArrayList<?>){
//				if (!DTOBase.class.isAssignableFrom(f.getType())){
////					if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//						//valuta attributo atomico
//						String atomicClassName = f.getType().getSimpleName().toLowerCase();
////						String column = DAelem.getColumn(it, elem.getClass());
//						if (f.getType().isEnum()){
//							switch(atomicClassName){
//							case "stato":
////									valueList+= Stato.fromName((Stato) f.get(elem)) + ", ";
//									try{
//										valueList+= Stato.fromName((Stato) f.get(elem)) + ", ";
//									}
//									catch(NullPointerException e){
//										valueList+= Stato.fromName(Stato.Attivo) + ", ";
//									}
////								f.set(o, Statelem.fromValue(rs.getInt(column)));
//								break;
//							case "tipoazienda":
//								valueList+= TipoAzienda.fromName((TipoAzienda) f.get(elem)) + ", ";
//								break;
//							case "movimentazione":
//								valueList+= Movimentazione.fromName((Movimentazione) f.get(elem)) + ", ";
//								break;
//							default:
//								break;
//							}
//						}
//						else{
//							switch(atomicClassName){
//							case "string"1:
//								valueList+= "'" + f.get(elem) + "', ";
////								f.set(o, rs.getString(column));
//								break;
//							case "long":
////								f.set(o, rs.getLong(column));
//								break;
//							case "double":
//								valueList+= "" + f.get(elem) + ", ";
//								break;
//							default:
//								break;
//							}
//						}
//					}
//					else{
//						//caricare i campi "filtrati" del sottotipo
//						//si tratta di un oggetto di cui devo ricavare solo l'ID
////						valueList+= "" + ((DTOBase)f.get(elem)).getId() + ", ";
//						try{
//							valueList+= "" + ((DTOBase)f.get(elem)).getId() + ", ";
//						}
//						catch(NullPointerException e){
//							valueList+= " NULL , ";
//						}
////						HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////						f.set(o, subElements.get(rs.getLong(column)));
//					}
//			}
//			else{
//				//gestire gli array
//				@SuppressWarnings("unused")
//				StringBuilderQuery subQuery = new StringBuilderQuery(createQuery);
//				
//				ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(elem);
//				
//	            Type type = f.getGenericType();
//
//	            if (type instanceof ParameterizedType) {
//
//	                ParameterizedType pType = (ParameterizedType)type;
//	                Type[] arr = pType.getActualTypeArguments();
//	                Class<?> innerClass = (Class<?>) arr[0];
//	                
//	                
//	                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//	                
////	                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
//	                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
//	                
//	                
////	        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
//	        		
//	                
//	                if (externalKey!=null){
//		        		for (DTOBase elem2: lista){
//		        			HashMap lista2 = newSubQueries.get(elem);
//	        				Object partial = extractCreateSubQueries(elem2);
//	        				
//	        				if (partial instanceof StringBuilderQuery){
//	        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
//	        				}
////			        		for (StringBuilderQuery subs : partial){
////								subs.replaceAll("__", externalKey);
////			        		}
//		        			try{
////			        			lista2.addAll(partial);
//			        			lista2.put(elem2, partial);
////			        			newSubQueries.put(o, lista2);
//		        			}
//		        			catch(Exception e){
//		        				lista2 = new HashMap<>();
//			        			lista2.put(elem2, partial);
//			        			newSubQueries.put(elem, lista2);
//		        			}
//			        		
////			        		subQuery.setField(2, subColumns);
////			        		
////			        		String subValues = "";
//////			        		for (DTOBase elem: lista){
////			        			subValues += elem.getId() + ", ??";
//////			        		subValues=subValues.substring(0, subValues.length()-4);
//////			        		String subValues = elem.getId() + ", ??";
//////			        		fieldMapper.get(elem.getClass().getSimpleName().toLowerCase());
////			        		
////			        		subQuery.setField(3, subValues);
////			        		subQueries.add(subQuery);
////			        		subQuery = new StringBuilderQuery(createQuery);
//			        		}
//	                	
//	                }else{
//	                	Entry<String, String> iter=entries.next();
//	                	
//	                	HashMap<String, String> trgt = fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).targets;
//		                String key= iter.getKey();
//	                	while (!trgt.containsKey(key)){
//	                		iter=entries.next();
//	                		key= iter.getKey();
//	                	}
//	                	
//		                String value=iter.getValue();
//		        		for (DTOBase elem2: lista){
//			        		subQuery.setTable(1, key);
//			        		
//			        		String subColumns = value + ", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).targets.get(key);
//			        		subQuery.setField(2, subColumns);
//			        		
//			        		String subValues = "";
////			        		for (DTOBase elem: lista){
//			        			subValues += elem2.getId() + ", ??";
////			        		subValues=subValues.substring(0, subValues.length()-4);
////			        		String subValues = elem.getId() + ", ??";
////			        		fieldMapper.get(elem.getClass().getSimpleName().toLowerCase());
//			        		
//			        		subQuery.setField(3, subValues);
//			        		//TODO
////			        		subQueries.add(subQuery);
//			        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(elem);
//		        			try{
////			        			lista2.addAll(partial);
//		        				sbQuery.put(elem2, subQuery);
////			        			newSubQueries.put(o, lista2);
//		        			}
//		        			catch(Exception e){
//		        				sbQuery = new HashMap<>();
//		        				sbQuery.put(elem2, subQuery);
//			        			newSubQueries.put(elem, sbQuery);
//		        			}
//			        		subQuery = new StringBuilderQuery(createQuery);
//			        		}
//	                }
//	                
////	        		System.out.println();
////	        		System.out.println();
////	        		System.out.println();
//	        		
////	        		if (column==null){
////	        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
////	        			if (column==null){
////	        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
////	        			}
////	        		}
//////	                for (Type tp: arr) {
//////	                    Class<?> clzz = (Class<?>)tp;
//////	                    System.out.println(clzz.getName());
//////	                }
//	            }
//				
//			}
//			
//		}
//		
//		columnList+="__";
//		valueList+="??";
//		
//		
//		if (fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
//			columnList+=", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
//			valueList+=", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//		}
//		
//		
//		
//		} catch (IllegalArgumentException | IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		StringBuilderQuery myQuery=new StringBuilderQuery(createQuery);
//		
//		myQuery.setTable(1, getTable(elem));
////		myQuery.setField(2, getColumns(o));
////		myQuery.setField(3, getValues(o));
//		myQuery.setField(2, columnList);
//		myQuery.setField(3, valueList);
//		subQueries=myQuery;
//		//TODO
////		subQueries.add(myQuery);
//		
//		
////		try {
////			statement = getConnection().createStatement1();
//////			statement.execute1Update(elem.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
////			statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////			ResultSet rs = statement.getGeneratedKeys();
////			rs.next();
////			elem.setId(rs.getLong(1));
////			
////			for (StringBuilderQuery subs : subQueries){
////				subs.replaceAll("??", elem.getId());
////				statement.execute1Update(subs.toString());
////			}
////			
//////			statement.execute1Update(elem.getSubQuery());
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		return subQueries;
//	}
	
	@Deprecated
	@SuppressWarnings("unchecked")
	public static void update(DTOBase o){
		
		updateNew(o);
		
//		
//		
//		
//		
//		
//		
//					//ricavare l'elenco degli attributi
//					String columnList="";
//					String valueList="";
//					
//					
//					
//					try {
//					
//					for (String it: DAO.getAllFields(o.getClass()).split(", ")){
//						//ricavo l'attributo sulla base del nome
//						Field f = retrieveField(it, o.getClass());
//						//lo rendo accessibile
//						f.setAccessible(true);
//	//					System.out.println();
//						
//						
//						if (!List.class.isAssignableFrom(f.getType())){
//							//e lo vado ad avvalorare
//							//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//							String column = DAO.getColumn(it, o.getClass());
//							
////							columnList+=column + ", ";
//							
//	//					if (f.getType() instanceof ArrayList<?>){
//							if (!DTOBase.class.isAssignableFrom(f.getType())){
//	//							if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//									//valuta attributo atomico
//									String atomicClassName = f.getType().getSimpleName().toLowerCase();
//	//								String column = DAO.getColumn(it, o.getClass());
//									if (f.getType().isEnum()){
//										switch(atomicClassName){
//										case "stato":
//											column+="=" +  Stato.fromName((Stato) f.get(o)) + ", ";
//	//										f.set(o, Stato.fromValue(rs.getInt(column)));
//											break;
//										case "tipoazienda":
//											column+="=" +  TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//											break;
//										case "movimentazione":
//											column+="=" +  Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//											break;
//										default:
//											break;
//										}
//									}
//									else{
//										switch(atomicClassName){
//										case "string"1:
//											Object x = f.get(o);
//											if (x!=null)
//											 column+="='" + x + "', ";
//											else
//												 column+="=" + x + ", ";
//	//										f.set(o, rs.getString(column));
//											break;
//										case "long":
//	//										f.set(o, rs.getLong(column));
//											break;
//										case "int":
//											column+="=" + f.get(o) + ", ";
//											break;
//										case "boolean":
//											column+="=" + f.get(o) + ", ";
//											break;
//										case "float":
//											column+="=" + f.get(o) + ", ";
//											break;
//										case "double":
//											column+="=" + f.get(o) + ", ";
//											break;
//										default:
//											break;
//										}
//									}
//								}
//								else{
//									//caricare i campi "filtrati" del sottotipo
//									//si tratta di un oggetto di cui devo ricavare solo l'ID
//									try{
//										column+="=" + ((DTOBase)f.get(o)).getId() + ", ";
////									column+="=" + f.get(o) + ", ";
//									}
//									catch(NullPointerException e){
////										valueList+= " NULL , ";
//										column+="=NULL, ";
//									}
//	//								HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
//	//								f.set(o, subElements.get(rs.getLong(column)));
//								}
//							columnList+=column;
//						}
//						else{
//							//gestire gli array
////							@SuppressWarnings("unused")
//							StringBuilderQuery subQuery = new StringBuilderQuery(updateQuery);
//							
//							ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(o);
//							
//				            Type type = f.getGenericType();
//	
//				            if (type instanceof ParameterizedType) {
//	
//				                ParameterizedType pType = (ParameterizedType)type;
//				                Type[] arr = pType.getActualTypeArguments();
//				                Class<?> innerClass = (Class<?>) arr[0];
//				                
//				                
//				                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//				                
//	//			                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
//				                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
//				                
//				                
//	//			        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
//				        		
//				                
//				                if (externalKey!=null){
//					        		for (DTOBase elem: lista){
//					        			if (elem.getId()==0){
//////						        			extractUpdateSubQuery(elem);
////					        				//l'elemento deve essere inserito come "nuovo"
////					        				
////					        			}
////					        			else{
//					        				//l'elemento deve essere inserito come "nuovo"
//					        				StringBuilderQuery partial = (StringBuilderQuery) extractCreateSubQueries(elem);
//					        				
//					        				partial.replaceAll("__", externalKey);
//					        				partial.replaceAll("??", o.getId());
//					        				Statement statmnt;
//											try {
//												statmnt = getConnection().createStatement1();
//												statmnt.execute1Update(partial.toString(),Statement.RETURN_GENERATED_KEYS);
//												ResultSet rs = statmnt.getGeneratedKeys();
//												rs.next();
//												elem.setId(rs.getLong(1));
//											} catch (SQLException e) {
//												// TODO Auto-generated catch block
//												e.printStackTrace();
//											}
////					        				System.out.print("");
////					        				System.out.print("");
////					        				System.out.print("");
//					        			}
//					        			else{
////					        				if (f.getName()=="riferimenti")
//					        				updateSubObject(elem);
//					        			}
//					        			
////					        			StringBuilderQuery subQury = extractUpdateSubQuery(elem);
//					        			
////					        			try {
////											getConnection().createStatement1().execute1Update(subQury.toString());
////										} catch (SQLException e1) {
////											// TODO Auto-generated catch block
////											e1.printStackTrace();
////										}
//					        			
//	//				        			subQueries.addAll(extractSubQueries(elem));
//					        			
////					        			HashMap lista2 = newSubQueries.get(o);
////				        				Object partial = extractUpdateSubQueries(elem);
//				        				
////				        				if (partial instanceof StringBuilderQuery){
////				        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
////				        				}
//	//					        		for (StringBuilderQuery subs : partial){
//	//										subs.replaceAll("__", externalKey);
//	//					        		}
////					        			try{
////	//					        			lista2.addAll(partial);
////						        			lista2.put(elem, partial);
////	//					        			newSubQueries.put(o, lista2);
////					        			}
////					        			catch(Exception e){
////					        				lista2 = new HashMap<>();
////						        			lista2.put(elem, partial);
////						        			newSubQueries.put(o, lista2);
////					        			}
//					        			
//					        			
//					        			
//	//				        			newSubQueries.put(elem, extractSubQueries(elem));
//					        			
//					        			
//	//					        		subQuery.setTable(1, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).tableName);
//	//
//	//					        		String subColumns = externalKey + ", ";// + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
//	//					        		
//	//									for (String subIt: DAO.getAllFields(f.getType()).split(", ")){
//	//										
//	//									}
//						        		
//	//					        		subQuery.setField(2, subColumns);
//	//					        		
//	//					        		String subValues = "";
//	////					        		for (DTOBase elem: lista){
//	//					        			subValues += elem.getId() + ", ??";
//	////					        		subValues=subValues.substring(0, subValues.length()-4);
//	////					        		String subValues = o.getId() + ", ??";
//	////					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
//	//					        		
//	//					        		subQuery.setField(3, subValues);
//	//					        		subQueries.add(subQuery);
//	//					        		subQuery = new StringBuilderQuery(createQuery);
//						        		}
//					        		
//					        		
//					        		//verifica degli elementi da eliminare
//			        				StringBuilderQuery partial = new StringBuilderQuery(readQuery);
//			        				partial.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//			        				partial.setField(2, getTable(innerClass));
//			        				partial.setField(3, externalKey + "=" + o.getId());
//			        				try {
//										ResultSet rs_new = getConnection().createStatement1().executeQuery(partial.toString());
//										
//										ArrayList<StringBuilderQuery> deleteQueries = new ArrayList<>();
//										boolean found = false;
//										while (rs_new.next()){
////											for (DTOBase el: lista){
//											for (int i=0; i< lista.size() && !found; i++){
//												DTOBase el = lista.get(i);
//												if (el.getId()==rs_new.getLong(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column)){
//													found=true;
//												}
//											}
//											if (!found){
////												Field fx = retrieveField("stato", innerClass);
////												StringBuilderQuery dltQuery = null;
////												if (fx==null){
////													dltQuery = new StringBuilderQuery(deleteQuery);
////													dltQuery.setField(1, getTable(innerClass));
////													dltQuery.setField(2, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column + "=" + rs_new.getLong(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column));
////													deleteQueries.add(dltQuery);
////												}else{
//////													DTOBase deletedItem = (DTOBase) innerClass.newInstance();
////													//lo rendo accessibile
////													fx.setAccessible(true);
////													dltQuery = new StringBuilderQuery(updateQuery);
////													
////													if (fx.getType().isEnum()){
////														
////														String atomicClassName = f.getType().getSimpleName().toLowerCase();
//////														switch(atomicClassName){
//////														case "stato":
//////															found=true;
////														dltQuery.setField(1, getTable(innerClass));
////														dltQuery.setField(2, "stato=" + Stato.fromName(Stato.Archiviato));
////														dltQuery.setField(3, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column + "=" + rs_new.getLong(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column));
////														deleteQueries.add(dltQuery);
////						
////													}
////												}
//												
//												
////												if (f.getName().equals("scheda") || f.getName().equals("condizioni")){
//								                	boolean found2=false;
//								                	subQuery = new StringBuilderQuery(readQuery);
//									                subQuery.setField(1, "stato");
//									                subQuery.setField(2, getTable(innerClass));
//								                	subQuery.setField(3, externalKey + "=" + o.getId());
//								                	try{
//								                		ResultSet myRS = getConnection().createStatement1().executeQuery(subQuery.toString());
//								                		found2=true;
//								                	}catch(SQLException e){
//								                		//
//								                		System.out.print("");
//								                		System.out.print("");
//								                	}
//								                	
//								                	if (found2==true){
//									                	subQuery = new StringBuilderQuery(updateQuery);
////										                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//										                subQuery.setField(1, getTable(innerClass));
////									                	subQuery.setField(2, externalKey + "=" + o.getId());
//									                	subQuery.setField(2, " stato=" + Stato.fromName(Stato.Archiviato));
//										                subQuery.setField(3, "id=" + rs_new.getLong(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column));
//								                	}
//								                	else{
//									                	subQuery = new StringBuilderQuery(deleteQuery);
//										                subQuery.setField(1, getTable(innerClass));
//										                subQuery.setField(2, "id=" + rs_new.getLong(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column));
//								                	}
//								                	deleteQueries.add(subQuery);
////												}
//												
//											}
//											found=false;
//										}
//										for (StringBuilderQuery qry: deleteQueries){
//											getConnection().createStatement1().execute1Update(qry.toString());
//										}
//										
//									} catch (SQLException e) {
//										// TODO Auto-generated catch block
//										e.printStackTrace();
//									}
//
//					        		
//					        		
//					        		
//					        		
//	////				        		for (StringBuilderQuery subs : subQueries){
//	////									subs.replaceAll("__", externalKey);
//	////				        		}
//	//								for (Object subs : newSubQueries.values()){
//	//									if (subs instanceof StringBuilderQuery)
//	//										((StringBuilderQuery)subs).replaceAll("__", externalKey);
//	//								}
//					        		
//					        		
//				                	
//				                }else{
//				                	Entry<String, String> iter=entries.next();
//				                	
//				                	HashMap<String, String> trgt = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets;
//					                String key= iter.getKey();
//				                	while (!trgt.containsKey(key)){
//				                		iter=entries.next();
//				                		key= iter.getKey();
//				                	}
//				                	
//					                String value=iter.getValue();
//					        		for (DTOBase elem: lista){
//					        			
//				        				StringBuilderQuery partial1 = new StringBuilderQuery(readQuery);
//					        			partial1.setField(1, value + " as id");
//					        			partial1.setField(2, key);
//					        			partial1.setField(3, trgt.get(key) + "=" + o.getId());
//					        			
//					        			try {
//											ResultSet newRS = getConnection().createStatement1().executeQuery(partial1.toString());
//											boolean found=false;
//											while (newRS.next() && !found){
//											//cancello gli indirizzi rimossi	
//												if (elem.getId()==newRS.getLong("id"))
//													found=true;
//											}
//											
//											if(!found){
//												partial1 = new StringBuilderQuery(createQuery);	
//							        			partial1.setField(1, key);
//							        			partial1.setField(2, value + ", " + trgt.get(key));
//							        			partial1.setField(3, elem.getId() + ", " + o.getId());
//							        			
//							        			getConnection().createStatement1().execute1Update(partial1.toString());
//											}
//						        			
//											
//										} catch (SQLException e1) {
//											// TODO Auto-generated catch block
//											e1.printStackTrace();
//										}
//					        			
//					        			
////						        		subQuery.setTable(1, key);
////						        		
////						        		String subColumns = value + ", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////						        		subQuery.setField(2, subColumns);
////						        		
////						        		String subValues = "";
////	//					        		for (DTOBase elem: lista){
////						        			subValues += elem.getId() + ", ??";
////	//					        		subValues=subValues.substring(0, subValues.length()-4);
////	//					        		String subValues = o.getId() + ", ??";
////	//					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////						        		
////						        		subQuery.setField(3, subValues);
////	////					        		subQueries.add(subQuery);
////	//					        		newSubQueries.put(subQuery, null);
////						        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(o);
////					        			try{
////	//					        			lista2.addAll(partial);
////					        				sbQuery.put(elem, subQuery);
////	//					        			newSubQueries.put(o, lista2);
////					        			}
////					        			catch(Exception e){
////					        				sbQuery = new HashMap<>();
////					        				sbQuery.put(elem, subQuery);
////						        			newSubQueries.put(o, sbQuery);
////					        			}
////						        		subQuery = new StringBuilderQuery(updateQuery);
//						        		}
//					        		
//					        		
//					        		
//									try {
//				        				StringBuilderQuery partial1 = new StringBuilderQuery(readQuery);
//					        			partial1.setField(1, value + " as id");
//					        			partial1.setField(2, key);
//					        			partial1.setField(3, trgt.get(key) + "=" + o.getId());
//					        			
//										ResultSet newRS = getConnection().createStatement1().executeQuery(partial1.toString());
//										
//										DTOBase elem=null;
////										long id=0;
//										ArrayList<StringBuilderQuery> deleteQueries = new ArrayList<>();
//										while(newRS.next()){
////											id=newRS.getLong("id");
//											boolean found=false;
//											for (int i=0; i< lista.size() && !found;i++){
//												elem=lista.get(i);
////												id=elem.getId();
//											//cancello gli indirizzi rimossi	
//												if (elem.getId()==newRS.getLong("id"))
//													found=true;
//											}
//											if(!found){
//												partial1 = new StringBuilderQuery(deleteQuery);	
//							        			partial1.setField(1, key);
//							        			partial1.setField(2, value + "=" + newRS.getLong("id") + " and " + trgt.get(key) + "=" + o.getId());
//							        			deleteQueries.add(partial1);
////							        			getConnection().createStatement1().execute1Update(partial1.toString());
//											}
//											
//										}
//										
//										for (StringBuilderQuery delQuery : deleteQueries){
//						        			getConnection().createStatement1().execute1Update(delQuery.toString());
//										}
//										
//										
//									} catch (SQLException e) {
//										// TODO Auto-generated catch block
//										e.printStackTrace();
//									}
//       		
//					        		
//					        		
//					        		
//				                }
//				                
//	//			        		System.out.println();
//	//			        		System.out.println();
//	//			        		System.out.println();
//				        		
//	//			        		if (column==null){
//	//			        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
//	//			        			if (column==null){
//	//			        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
//	//			        			}
//	//			        		}
//	////			                for (Type tp: arr) {
//	////			                    Class<?> clzz = (Class<?>)tp;
//	////			                    System.out.println(clzz.getName());
//	////			                }
//				            }
//							
//						}
//						
//					}
//					
//					columnList=columnList.substring(0,columnList.length()-2);
////	//				System.out.println();
////					valueList=valueList.substring(0,valueList.length()-2);
//					
//					
//					if (fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
//						columnList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn() + "=" + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
////						valueList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//					}
//					
//					
//					
//					} catch (IllegalArgumentException | IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					
//					
//					StringBuilderQuery myQuery=new StringBuilderQuery(updateQuery);
//					
//					myQuery.setTable(1, getTable(o));
//	//				myQuery.setField(2, getColumns(o));
//	//				myQuery.setField(3, getValues(o));
//					myQuery.setField(2, columnList);
//					myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
//					
//					
//					
//					
//					try {
//						statement = getConnection().createStatement1();
////						statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//						statement.execute1Update(myQuery.toString());
//////						ResultSet rs = statement.getGeneratedKeys();
//////						rs.next();
//////						o.setId(rs.getLong(1));
////						
////	//					for (StringBuilderQuery subs : subQueries){
////	//						subs.replaceAll("??", o.getId());
////	//						statement.execute1Update(subs.toString());
////	//					}
////						
////						HashMap<DTOBase, StringBuilderQuery> firstPass = newSubQueries.get(o);
////						if (firstPass!=null){
////							newSubQueries.remove(o);
////							for (DTOBase subKey : firstPass.keySet()){
////								StringBuilderQuery subElementQuery = firstPass.get(subKey);
////								subElementQuery.replaceAll("??", o.getId());
////								
////								if (newSubQueries.containsKey(subKey)){
////									statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////									ResultSet rs2 = statement.getGeneratedKeys();
////									rs2.next();
////									subKey.setId(rs2.getLong(1));
////								}
////								else{
////									statement.execute1Update(subElementQuery.toString());
////								}
////								
////								
////							}
////						}
////						
////						
////						
////						for (DTOBase subs : newSubQueries.keySet()){
////							HashMap<DTOBase, StringBuilderQuery> subElement = newSubQueries.get(subs);
////							
////							for (DTOBase subKey : subElement.keySet()){
////								StringBuilderQuery subElementQuery = subElement.get(subKey);
////								subElementQuery.replaceAll("??", subs.getId());
////								
////								if (newSubQueries.containsKey(subKey)){
////									statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////									ResultSet rs2 = statement.getGeneratedKeys();
////									rs2.next();
////									subKey.setId(rs2.getLong(1));
////								}
////								else{
////									statement.execute1Update(subElementQuery.toString());
////								}
////								
////								
////							}
////							
////							
////	//						if (subs instanceof StringBuilderQuery){
////	//							((StringBuilderQuery) subs).replaceAll("??", o.getId());
////	//							statement.execute1Update(subs.toString());
////	//						}
////						}
//						
//						
//						
//						
//	//					statement.execute1Update(o.getSubQuery());
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					newSubQueries=new HashMap<>();
//		//			try{
//		//				statement = getConnection().createStatement1();
//		//				
//		//				StringBuilderQuery query = new StringBuilderQuery(createQuery);//"insert into ? (?) values (?);"
//		//				query.setTable(1, extractTable(o));
//		//				query.setTable(2, extractOnlyFields(o));
//		//				query.setTable(3, extractFieldValues(o));
//		//	//			query.setTable(1, getTable());
//		//	////			query.append(getTable());
//		//	//			query.setValue(2, getId());
//		//	////			query.append(getId());
//		//	//					
//		//	//			return query.toString();
//		//				
//		//				
//		//				
//		////				statement.execute1Update(getAllFields(o),Statement.RETURN_GENERATED_KEYS);
//		//				statement.execute1Update(query.toString(),Statement.RETURN_GENERATED_KEYS);
//		//				ResultSet rs = statement.getGeneratedKeys();
//		//				rs.next();
//		//				o.setId(rs.getLong(1));
//		//			}
//		//			catch (SQLException | NullPointerException e) {
//		//				e.printStackTrace();
//		//			} 
				}
//	private static void updateSubObject(DTOBase o) {
//		//ricavare l'elenco degli attributi
//		String columnList="";
//		String valueList="";
//		
//		
//		
//		try {
//		
//		for (String it: DAO.getAllFields(o.getClass()).split(", ")){
//			//ricavo l'attributo sulla base del nome
//			Field f = retrieveField(it, o.getClass());
//			//lo rendo accessibile
//			f.setAccessible(true);
////					System.out.println();
//			
//			
//			if (!List.class.isAssignableFrom(f.getType())){
//				//e lo vado ad avvalorare
//				//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//				String column = DAO.getColumn(it, o.getClass());
//				
////				columnList+=column + ", ";
//				
////					if (f.getType() instanceof ArrayList<?>){
//				if (!DTOBase.class.isAssignableFrom(f.getType())){
////							if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//						//valuta attributo atomico
//						String atomicClassName = f.getType().getSimpleName().toLowerCase();
////								String column = DAO.getColumn(it, o.getClass());
//						if (f.getType().isEnum()){
//							switch(atomicClassName){
//							case "stato":
//								column+="=" +  Stato.fromName((Stato) f.get(o)) + ", ";
////										f.set(o, Stato.fromValue(rs.getInt(column)));
//								break;
//							case "tipoazienda":
//								column+="=" +  TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//								break;
//							case "movimentazione":
//								column+="=" +  Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//								break;
//							default:
//								break;
//							}
//						}
//						else{
//							switch(atomicClassName){
//							case "string"1:
//								Object x = f.get(o);
//								if (x!=null)
//								 column+="='" + x + "', ";
//								else
//									 column+="=" + x + ", ";
////										f.set(o, rs.getString(column));
//								break;
//							case "long":
////										f.set(o, rs.getLong(column));
//								break;
//							case "int":
//								column+="=" + f.get(o) + ", ";
//								break;
//							case "boolean":
//								column+="=" + f.get(o) + ", ";
//								break;
//							case "float":
//								column+="=" + f.get(o) + ", ";
//								break;
//							case "double":
//								column+="=" + f.get(o) + ", ";
//								break;
//							default:
//								break;
//							}
//						}
//					}
//					else{
//						//caricare i campi "filtrati" del sottotipo
//						//si tratta di un oggetto di cui devo ricavare solo l'ID
//						try{
//							column+="=" + ((DTOBase)f.get(o)).getId() + ", ";
////						column+="=" + f.get(o) + ", ";
//						}
//						catch(NullPointerException e){
////							valueList+= " NULL , ";
//							column+="=NULL, ";
//						}
////								HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////								f.set(o, subElements.get(rs.getLong(column)));
//					}
//				columnList+=column;
//			}
//			else{
//				//gestire gli array
////				@SuppressWarnings("unused")
//				StringBuilderQuery subQuery = new StringBuilderQuery(updateQuery);
//				
//				ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(o);
//				
//	            Type type = f.getGenericType();
//
//	            if (type instanceof ParameterizedType) {
//
//	                ParameterizedType pType = (ParameterizedType)type;
//	                Type[] arr = pType.getActualTypeArguments();
//	                Class<?> innerClass = (Class<?>) arr[0];
//	                
//	                
//	                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//	                
////			                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
//	                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
//	                
//	                
////			        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
//	        		
//	                
//	                if (externalKey!=null){
//		        		for (DTOBase elem: lista){
//		        			if (elem.getId()==0){
//////			        			extractUpdateSubQuery(elem);
////		        				//l'elemento deve essere inserito come "nuovo"
////		        				
////		        			}
////		        			else{
//		        				//l'elemento deve essere inserito come "nuovo"
//		        				StringBuilderQuery partial = (StringBuilderQuery) extractCreateSubQueries(elem);
//		        				
//		        				partial.replaceAll("__", externalKey);
//		        				partial.replaceAll("??", o.getId());
//		        				Statement statmnt;
//								try {
//									statmnt = getConnection().createStatement1();
//									statmnt.execute1Update(partial.toString(),Statement.RETURN_GENERATED_KEYS);
//									ResultSet rs = statmnt.getGeneratedKeys();
//									rs.next();
//									elem.setId(rs.getLong(1));
//								} catch (SQLException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
////		        				System.out.print("");
////		        				System.out.print("");
////		        				System.out.print("");
//		        			}
//		        			else{
//		        				
//		        				updateSubObject(elem);
//		        			}
//		        			
////		        			StringBuilderQuery subQury = extractUpdateSubQuery(elem);
//		        			
////		        			try {
////								getConnection().createStatement1().execute1Update(subQury.toString());
////							} catch (SQLException e1) {
////								// TODO Auto-generated catch block
////								e1.printStackTrace();
////							}
//		        			
////				        			subQueries.addAll(extractSubQueries(elem));
//		        			
////		        			HashMap lista2 = newSubQueries.get(o);
////	        				Object partial = extractUpdateSubQueries(elem);
//	        				
////	        				if (partial instanceof StringBuilderQuery){
////	        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
////	        				}
////					        		for (StringBuilderQuery subs : partial){
////										subs.replaceAll("__", externalKey);
////					        		}
////		        			try{
//////					        			lista2.addAll(partial);
////			        			lista2.put(elem, partial);
//////					        			newSubQueries.put(o, lista2);
////		        			}
////		        			catch(Exception e){
////		        				lista2 = new HashMap<>();
////			        			lista2.put(elem, partial);
////			        			newSubQueries.put(o, lista2);
////		        			}
//		        			
//		        			
//		        			
////				        			newSubQueries.put(elem, extractSubQueries(elem));
//		        			
//		        			
////					        		subQuery.setTable(1, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).tableName);
////
////					        		String subColumns = externalKey + ", ";// + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////					        		
////									for (String subIt: DAO.getAllFields(f.getType()).split(", ")){
////										
////									}
//			        		
////					        		subQuery.setField(2, subColumns);
////					        		
////					        		String subValues = "";
//////					        		for (DTOBase elem: lista){
////					        			subValues += elem.getId() + ", ??";
//////					        		subValues=subValues.substring(0, subValues.length()-4);
//////					        		String subValues = o.getId() + ", ??";
//////					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////					        		
////					        		subQuery.setField(3, subValues);
////					        		subQueries.add(subQuery);
////					        		subQuery = new StringBuilderQuery(createQuery);
//			        		}
//		        		
//		        		
//		        		//verifica degli elementi da eliminare
//        				StringBuilderQuery partial = new StringBuilderQuery(readQuery);
//        				partial.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//        				partial.setField(2, getTable(innerClass));
//        				partial.setField(3, externalKey + "=" + o.getId());
//        				try {
//							ResultSet rs_new = getConnection().createStatement1().executeQuery(partial.toString());
//							
//							ArrayList<StringBuilderQuery> deleteQueries = new ArrayList<>();
//							boolean found = false;
//							while (rs_new.next()){
////								for (DTOBase el: lista){
//								for (int i=0; i< lista.size() && !found; i++){
//									DTOBase el = lista.get(i);
//									if (el.getId()==rs_new.getLong(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column)){
//										found=true;
//									}
//								}
//								if (!found){
//									StringBuilderQuery dltQuery = new StringBuilderQuery(deleteQuery);
//									dltQuery.setField(1, getTable(innerClass));
//									dltQuery.setField(2, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column + "=" + rs_new.getLong(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column));
//									deleteQueries.add(dltQuery);
//								}
//								found=false;
//							}
//							for (StringBuilderQuery qry: deleteQueries){
//								getConnection().createStatement1().execute1Update(qry.toString());
//							}
//							
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//		        		
//		        		
//		        		
//		        		
//////				        		for (StringBuilderQuery subs : subQueries){
//////									subs.replaceAll("__", externalKey);
//////				        		}
////								for (Object subs : newSubQueries.values()){
////									if (subs instanceof StringBuilderQuery)
////										((StringBuilderQuery)subs).replaceAll("__", externalKey);
////								}
//		        		
//		        		
//	                	
//	                }else{
//	                	Entry<String, String> iter=entries.next();
//	                	
//	                	HashMap<String, String> trgt = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets;
//		                String key= iter.getKey();
//	                	while (!trgt.containsKey(key)){
//	                		iter=entries.next();
//	                		key= iter.getKey();
//	                	}
//	                	
//		                String value=iter.getValue();
//		        		for (DTOBase elem: lista){
//		        			
//	        				StringBuilderQuery partial1 = new StringBuilderQuery(readQuery);
//		        			partial1.setField(1, value + " as id");
//		        			partial1.setField(2, key);
//		        			partial1.setField(3, trgt.get(key) + "=" + o.getId());
//		        			
//		        			try {
//								ResultSet newRS = getConnection().createStatement1().executeQuery(partial1.toString());
//								boolean found=false;
//								while (newRS.next() && !found){
//								//cancello gli indirizzi rimossi	
//									if (elem.getId()==newRS.getLong("id"))
//										found=true;
//								}
//								
//								if(!found){
//									partial1 = new StringBuilderQuery(createQuery);	
//				        			partial1.setField(1, key);
//				        			partial1.setField(2, value + ", " + trgt.get(key));
//				        			partial1.setField(3, elem.getId() + ", " + o.getId());
//				        			
//				        			getConnection().createStatement1().execute1Update(partial1.toString());
//								}
//			        			
//								
//							} catch (SQLException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//		        			
//		        			
////			        		subQuery.setTable(1, key);
////			        		
////			        		String subColumns = value + ", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////			        		subQuery.setField(2, subColumns);
////			        		
////			        		String subValues = "";
//////					        		for (DTOBase elem: lista){
////			        			subValues += elem.getId() + ", ??";
//////					        		subValues=subValues.substring(0, subValues.length()-4);
//////					        		String subValues = o.getId() + ", ??";
//////					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////			        		
////			        		subQuery.setField(3, subValues);
////////					        		subQueries.add(subQuery);
//////					        		newSubQueries.put(subQuery, null);
////			        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(o);
////		        			try{
//////					        			lista2.addAll(partial);
////		        				sbQuery.put(elem, subQuery);
//////					        			newSubQueries.put(o, lista2);
////		        			}
////		        			catch(Exception e){
////		        				sbQuery = new HashMap<>();
////		        				sbQuery.put(elem, subQuery);
////			        			newSubQueries.put(o, sbQuery);
////		        			}
////			        		subQuery = new StringBuilderQuery(updateQuery);
//			        		}
//		        		
//		        		
//		        		
//						try {
//	        				StringBuilderQuery partial1 = new StringBuilderQuery(readQuery);
//		        			partial1.setField(1, value + " as id");
//		        			partial1.setField(2, key);
//		        			partial1.setField(3, trgt.get(key) + "=" + o.getId());
//		        			
//							ResultSet newRS = getConnection().createStatement1().executeQuery(partial1.toString());
//							
//							DTOBase elem=null;
////							long id=0;
//							ArrayList<StringBuilderQuery> deleteQueries = new ArrayList<>();
//							while(newRS.next()){
////								id=newRS.getLong("id");
//								boolean found=false;
//								for (int i=0; i< lista.size() && !found;i++){
//									elem=lista.get(i);
////									id=elem.getId();
//								//cancello gli indirizzi rimossi	
//									if (elem.getId()==newRS.getLong("id"))
//										found=true;
//								}
//								if(!found){
//									partial1 = new StringBuilderQuery(deleteQuery);	
//				        			partial1.setField(1, key);
//				        			partial1.setField(2, value + "=" + newRS.getLong("id") + " and " + trgt.get(key) + "=" + o.getId());
//				        			deleteQueries.add(partial1);
////				        			getConnection().createStatement1().execute1Update(partial1.toString());
//								}
//								
//							}
//							
//							for (StringBuilderQuery delQuery : deleteQueries){
//			        			getConnection().createStatement1().execute1Update(delQuery.toString());
//							}
//							
//							
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//	
//		        		
//		        		
//		        		
//	                }
//	                
////			        		System.out.println();
////			        		System.out.println();
////			        		System.out.println();
//	        		
////			        		if (column==null){
////			        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
////			        			if (column==null){
////			        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
////			        			}
////			        		}
//////			                for (Type tp: arr) {
//////			                    Class<?> clzz = (Class<?>)tp;
//////			                    System.out.println(clzz.getName());
//////			                }
//	            }
//				
//			}
//			
//		}
//		
//		columnList=columnList.substring(0,columnList.length()-2);
//////				System.out.println();
////		valueList=valueList.substring(0,valueList.length()-2);
//		
//		
//		if (fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
//			columnList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn() + "=" + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
////			valueList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//		}
//		
//		
//		
//		} catch (IllegalArgumentException | IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		StringBuilderQuery myQuery=new StringBuilderQuery(updateQuery);
//		
//		myQuery.setTable(1, getTable(o));
////				myQuery.setField(2, getColumns(o));
////				myQuery.setField(3, getValues(o));
//		myQuery.setField(2, columnList);
//		myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
//		
//		
//		
//		
//		try {
//			statement = getConnection().createStatement1();
////			statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//			statement.execute1Update(myQuery.toString());
//////			ResultSet rs = statement.getGeneratedKeys();
//////			rs.next();
//////			o.setId(rs.getLong(1));
////			
//////					for (StringBuilderQuery subs : subQueries){
//////						subs.replaceAll("??", o.getId());
//////						statement.execute1Update(subs.toString());
//////					}
////			
////			HashMap<DTOBase, StringBuilderQuery> firstPass = newSubQueries.get(o);
////			if (firstPass!=null){
////				newSubQueries.remove(o);
////				for (DTOBase subKey : firstPass.keySet()){
////					StringBuilderQuery subElementQuery = firstPass.get(subKey);
////					subElementQuery.replaceAll("??", o.getId());
////					
////					if (newSubQueries.containsKey(subKey)){
////						statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////						ResultSet rs2 = statement.getGeneratedKeys();
////						rs2.next();
////						subKey.setId(rs2.getLong(1));
////					}
////					else{
////						statement.execute1Update(subElementQuery.toString());
////					}
////					
////					
////				}
////			}
////			
////			
////			
////			for (DTOBase subs : newSubQueries.keySet()){
////				HashMap<DTOBase, StringBuilderQuery> subElement = newSubQueries.get(subs);
////				
////				for (DTOBase subKey : subElement.keySet()){
////					StringBuilderQuery subElementQuery = subElement.get(subKey);
////					subElementQuery.replaceAll("??", subs.getId());
////					
////					if (newSubQueries.containsKey(subKey)){
////						statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////						ResultSet rs2 = statement.getGeneratedKeys();
////						rs2.next();
////						subKey.setId(rs2.getLong(1));
////					}
////					else{
////						statement.execute1Update(subElementQuery.toString());
////					}
////					
////					
////				}
////				
////				
//////						if (subs instanceof StringBuilderQuery){
//////							((StringBuilderQuery) subs).replaceAll("??", o.getId());
//////							statement.execute1Update(subs.toString());
//////						}
////			}
//			
//			
//			
//			
////					statement.execute1Update(o.getSubQuery());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		newSubQueries=new HashMap<>();
////			try{
////				statement = getConnection().createStatement1();
////				
////				StringBuilderQuery query = new StringBuilderQuery(createQuery);//"insert into ? (?) values (?);"
////				query.setTable(1, extractTable(o));
////				query.setTable(2, extractOnlyFields(o));
////				query.setTable(3, extractFieldValues(o));
////	//			query.setTable(1, getTable());
////	////			query.append(getTable());
////	//			query.setValue(2, getId());
////	////			query.append(getId());
////	//					
////	//			return query.toString();
////				
////				
////				
//////				statement.execute1Update(getAllFields(o),Statement.RETURN_GENERATED_KEYS);
////				statement.execute1Update(query.toString(),Statement.RETURN_GENERATED_KEYS);
////				ResultSet rs = statement.getGeneratedKeys();
////				rs.next();
////				o.setId(rs.getLong(1));
////			}
////			catch (SQLException | NullPointerException e) {
////				e.printStackTrace();
////			} 
//	}
//	private static void /*StringBuilderQuery*/ extractUpdateSubQuery(DTOBase elem) {
//
//		//ricavare l'elenco degli attributi
//		String columnList="";
//		String valueList="";
//		
//		
//		
//		try {
//		
//		for (String it: DAO.getAllFields(elem.getClass()).split(", ")){
//			//ricavo l'attributo sulla base del nome
//			Field f = retrieveField(it, elem.getClass());
//			//lo rendo accessibile
//			f.setAccessible(true);
////					System.out.println();
//			
//			
//			if (!List.class.isAssignableFrom(f.getType())){
//				//e lo vado ad avvalorare
//				//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//				String column = DAO.getColumn(it, elem.getClass());
//				
////				columnList+=column + ", ";
//				
////					if (f.getType() instanceof ArrayList<?>){
//				if (!DTOBase.class.isAssignableFrom(f.getType())){
////							if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//						//valuta attributo atomico
//						String atomicClassName = f.getType().getSimpleName().toLowerCase();
////								String column = DAO.getColumn(it, o.getClass());
//						if (f.getType().isEnum()){
//							switch(atomicClassName){
//							case "stato":
//								column+="=" +  Stato.fromName((Stato) f.get(elem)) + ", ";
////										f.set(o, Stato.fromValue(rs.getInt(column)));
//								break;
//							case "tipoazienda":
//								column+="=" +  TipoAzienda.fromName((TipoAzienda) f.get(elem)) + ", ";
//								break;
//							case "movimentazione":
//								column+="=" +  Movimentazione.fromName((Movimentazione) f.get(elem)) + ", ";
//								break;
//							default:
//								break;
//							}
//						}
//						else{
//							switch(atomicClassName){
//							case "string"1:
//								Object x = f.get(elem);
//								if (x!=null)
//								 column+="='" + x + "', ";
//								else
//									 column+="=" + x + ", ";
////										f.set(o, rs.getString(column));
//								break;
//							case "long":
////										f.set(o, rs.getLong(column));
//								break;
//							case "int":
//								column+="=" + f.get(elem) + ", ";
//								break;
//							case "boolean":
//								column+="=" + f.get(elem) + ", ";
//								break;
//							case "float":
//								column+="=" + f.get(elem) + ", ";
//								break;
//							case "double":
//								column+="=" + f.get(elem) + ", ";
//								break;
//							default:
//								break;
//							}
//						}
//					}
//					else{
//						//caricare i campi "filtrati" del sottotipo
//						//si tratta di un oggetto di cui devo ricavare solo l'ID
//						try{
//							column+="=" + ((DTOBase)f.get(elem)).getId() + ", ";
////						column+="=" + f.get(o) + ", ";
//						}
//						catch(NullPointerException e){
//							valueList+= " NULL , ";
//						}
////								HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////								f.set(o, subElements.get(rs.getLong(column)));
//					}
//				columnList+=column;
//			}
//			else{
//				//gestire gli array
//				@SuppressWarnings("unused")
//				StringBuilderQuery subQuery = new StringBuilderQuery(updateQuery);
//				
//				ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(elem);
//				
//	            Type type = f.getGenericType();
//
//	            if (type instanceof ParameterizedType) {
//
//	                ParameterizedType pType = (ParameterizedType)type;
//	                Type[] arr = pType.getActualTypeArguments();
//	                Class<?> innerClass = (Class<?>) arr[0];
//	                
//	                
//	                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//	                
////			                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
//	                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
//	                
//	                
////			        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
//	        		
//	                
//	                if (externalKey!=null){
//		        		for (DTOBase elem2: lista){
//		        			
////		        			StringBuilderQuery subQury = extractUpdateSubQuery(elem2);
//		        			extractUpdateSubQuery(elem2);
//		        			
////		        			try {
////								getConnection().createStatement1().execute1Update(subQury.toString());
////							} catch (SQLException e1) {
////								// TODO Auto-generated catch block
////								e1.printStackTrace();
////							}
//		        			
//			        		}
//		        		
//		        		
//		        		
//	                	
//	                }else{
//	                	Entry<String, String> iter=entries.next();
//	                	
//	                	HashMap<String, String> trgt = fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).targets;
//		                String key= iter.getKey();
//	                	while (!trgt.containsKey(key)){
//	                		iter=entries.next();
//	                		key= iter.getKey();
//	                	}
//	                	
//		                String value=iter.getValue();
//		        		for (DTOBase elem2: lista){
//			        		subQuery.setTable(1, key);
//			        		
//			        		String subColumns = value + ", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).targets.get(key);
//			        		subQuery.setField(2, subColumns);
//			        		
//			        		String subValues = "";
////					        		for (DTOBase elem2: lista){
//			        			subValues += elem2.getId() + ", ??";
////					        		subValues=subValues.substring(0, subValues.length()-4);
////					        		String subValues = o.getId() + ", ??";
////					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
//			        		
//			        		subQuery.setField(3, subValues);
//////					        		subQueries.add(subQuery);
////					        		newSubQueries.put(subQuery, null);
//			        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(elem);
//		        			try{
////					        			lista2.addAll(partial);
//		        				sbQuery.put(elem2, subQuery);
////					        			newSubQueries.put(o, lista2);
//		        			}
//		        			catch(Exception e){
//		        				sbQuery = new HashMap<>();
//		        				sbQuery.put(elem2, subQuery);
//			        			newSubQueries.put(elem, sbQuery);
//		        			}
//			        		subQuery = new StringBuilderQuery(updateQuery);
//			        		}
//	                }
//	                
////			        		System.out.println();
////			        		System.out.println();
////			        		System.out.println();
//	        		
////			        		if (column==null){
////			        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
////			        			if (column==null){
////			        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
////			        			}
////			        		}
//////			                for (Type tp: arr) {
//////			                    Class<?> clzz = (Class<?>)tp;
//////			                    System.out.println(clzz.getName());
//////			                }
//	            }
//				
//			}
//			
//		}
//		
//		columnList=columnList.substring(0,columnList.length()-2);
//////				System.out.println();
////		valueList=valueList.substring(0,valueList.length()-2);
//		
//		
//		if (fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
//			columnList+=", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
//			valueList+=", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//		}
//		
//		
//		
//		} catch (IllegalArgumentException | IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		StringBuilderQuery myQuery=new StringBuilderQuery(updateQuery);
//		
//		myQuery.setTable(1, getTable(elem));
////				myQuery.setField(2, getColumns(o));
////				myQuery.setField(3, getValues(o));
//		myQuery.setField(2, columnList);
//		myQuery.setField(3, fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + elem.getId());
//		
//		
//		
//		
//		try {
//			statement = getConnection().createStatement1();
////			statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//			statement.execute1Update(myQuery.toString());
//////			ResultSet rs = statement.getGeneratedKeys();
//////			rs.next();
//////			o.setId(rs.getLong(1));
////			
//////					for (StringBuilderQuery subs : subQueries){
//////						subs.replaceAll("??", o.getId());
//////						statement.execute1Update(subs.toString());
//////					}
////			
////			HashMap<DTOBase, StringBuilderQuery> firstPass = newSubQueries.get(o);
////			if (firstPass!=null){
////				newSubQueries.remove(o);
////				for (DTOBase subKey : firstPass.keySet()){
////					StringBuilderQuery subelem2entQuery = firstPass.get(subKey);
////					subelem2entQuery.replaceAll("??", o.getId());
////					
////					if (newSubQueries.containsKey(subKey)){
////						statement.execute1Update(subelem2entQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////						ResultSet rs2 = statement.getGeneratedKeys();
////						rs2.next();
////						subKey.setId(rs2.getLong(1));
////					}
////					else{
////						statement.execute1Update(subelem2entQuery.toString());
////					}
////					
////					
////				}
////			}
////			
////			
////			
////			for (DTOBase subs : newSubQueries.keySet()){
////				HashMap<DTOBase, StringBuilderQuery> subelem2ent = newSubQueries.get(subs);
////				
////				for (DTOBase subKey : subelem2ent.keySet()){
////					StringBuilderQuery subelem2entQuery = subelem2ent.get(subKey);
////					subelem2entQuery.replaceAll("??", subs.getId());
////					
////					if (newSubQueries.containsKey(subKey)){
////						statement.execute1Update(subelem2entQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////						ResultSet rs2 = statement.getGeneratedKeys();
////						rs2.next();
////						subKey.setId(rs2.getLong(1));
////					}
////					else{
////						statement.execute1Update(subelem2entQuery.toString());
////					}
////					
////					
////				}
////				
////				
//////						if (subs instanceof StringBuilderQuery){
//////							((StringBuilderQuery) subs).replaceAll("??", o.getId());
//////							statement.execute1Update(subs.toString());
//////						}
////			}
//			
//			
//			
//			
////					statement.execute1Update(o.getSubQuery());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		newSubQueries=new HashMap<>();
////			try{
////				statement = getConnection().createStatement1();
////				
////				StringBuilderQuery query = new StringBuilderQuery(createQuery);//"insert into ? (?) values (?);"
////				query.setTable(1, extractTable(o));
////				query.setTable(2, extractOnlyFields(o));
////				query.setTable(3, extractFieldValues(o));
////	//			query.setTable(1, getTable());
////	////			query.append(getTable());
////	//			query.setValue(2, getId());
////	////			query.append(getId());
////	//					
////	//			return query.toString();
////				
////				
////				
//////				statement.execute1Update(getAllFields(o),Statement.RETURN_GENERATED_KEYS);
////				statement.execute1Update(query.toString(),Statement.RETURN_GENERATED_KEYS);
////				ResultSet rs = statement.getGeneratedKeys();
////				rs.next();
////				o.setId(rs.getLong(1));
////			}
////			catch (SQLException | NullPointerException e) {
////				e.printStackTrace();
////			} 
////		return null;
//	}

		
		//	private static ArrayList<StringBuilderQuery> extractSubQueries(DTOBase elem) {
//		private static Object extractUpdateSubQueries(DTOBase elem) {
//			//ricavare l'elenco degli attributi
//			String columnList="";
//			String valueList="";
//			Object subQueries=null;
//			try {
//			
//			for (String it: DAO.getAllFields(elem.getClass()).split(", ")){
//				//ricavo l'attributo sulla base del nome
//				Field f = retrieveField(it, elem.getClass());
//				//lo rendo accessibile
//				f.setAccessible(true);
//	//			System.out.println();
//				
//				
//				if (!List.class.isAssignableFrom(f.getType())){
//					//e lo vado ad avvalorare
//					//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//					
//					
//					String column = DAO.getColumn(it, elem.getClass());
//					
//					columnList+=column + ", ";
//					
//	//			if (f.getType() instanceof ArrayList<?>){
//					if (!DTOBase.class.isAssignableFrom(f.getType())){
//	//					if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//							//valuta attributo atomico
//							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//	//						String column = DAelem.getColumn(it, elem.getClass());
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//	//									valueList+= Stato.fromName((Stato) f.get(elem)) + ", ";
//										try{
//											valueList+= Stato.fromName((Stato) f.get(elem)) + ", ";
//										}
//										catch(NullPointerException e){
//											valueList+= Stato.fromName(Stato.Attivo) + ", ";
//										}
//	//								f.set(o, Statelem.fromValue(rs.getInt(column)));
//									break;
//								case "tipoazienda":
//									valueList+= TipoAzienda.fromName((TipoAzienda) f.get(elem)) + ", ";
//									break;
//								case "movimentazione":
//									valueList+= Movimentazione.fromName((Movimentazione) f.get(elem)) + ", ";
//									break;
//								default:
//									break;
//								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//									valueList+= "'" + f.get(elem) + "', ";
//	//								f.set(o, rs.getString(column));
//									break;
//								case "long":
//	//								f.set(o, rs.getLong(column));
//									break;
//								case "double":
//									valueList+= "" + f.get(elem) + ", ";
//									break;
//								default:
//									break;
//								}
//							}
//						}
//						else{
//							//caricare i campi "filtrati" del sottotipo
//							//si tratta di un oggetto di cui devo ricavare solo l'ID
//	//						valueList+= "" + ((DTOBase)f.get(elem)).getId() + ", ";
//							try{
//								valueList+= "" + ((DTOBase)f.get(elem)).getId() + ", ";
//							}
//							catch(NullPointerException e){
//								valueList+= " NULL , ";
//							}
//	//						HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
//	//						f.set(o, subElements.get(rs.getLong(column)));
//						}
//				}
//				else{
//					//gestire gli array
//					@SuppressWarnings("unused")
//					StringBuilderQuery subQuery = new StringBuilderQuery(updateQuery);
//					
//					ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(elem);
//					
//		            Type type = f.getGenericType();
//	
//		            if (type instanceof ParameterizedType) {
//	
//		                ParameterizedType pType = (ParameterizedType)type;
//		                Type[] arr = pType.getActualTypeArguments();
//		                Class<?> innerClass = (Class<?>) arr[0];
//		                
//		                
//		                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//		                
//	//	                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
//		                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
//		                
//		                
//	//	        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
//		        		
//		                
//		                if (externalKey!=null){
//			        		for (DTOBase elem2: lista){
//			        			HashMap lista2 = newSubQueries.get(elem);
//		        				Object partial = extractUpdateSubQueries(elem2);
//		        				
//		        				if (partial instanceof StringBuilderQuery){
//		        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
//		        				}
//	//			        		for (StringBuilderQuery subs : partial){
//	//								subs.replaceAll("__", externalKey);
//	//			        		}
//			        			try{
//	//			        			lista2.addAll(partial);
//				        			lista2.put(elem2, partial);
//	//			        			newSubQueries.put(o, lista2);
//			        			}
//			        			catch(Exception e){
//			        				lista2 = new HashMap<>();
//				        			lista2.put(elem2, partial);
//				        			newSubQueries.put(elem, lista2);
//			        			}
//				        		
//	//			        		subQuery.setField(2, subColumns);
//	//			        		
//	//			        		String subValues = "";
//	////			        		for (DTOBase elem: lista){
//	//			        			subValues += elem.getId() + ", ??";
//	////			        		subValues=subValues.substring(0, subValues.length()-4);
//	////			        		String subValues = elem.getId() + ", ??";
//	////			        		fieldMapper.get(elem.getClass().getSimpleName().toLowerCase());
//	//			        		
//	//			        		subQuery.setField(3, subValues);
//	//			        		subQueries.add(subQuery);
//	//			        		subQuery = new StringBuilderQuery(createQuery);
//				        		}
//		                	
//		                }else{
//		                	Entry<String, String> iter=entries.next();
//		                	
//		                	HashMap<String, String> trgt = fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).targets;
//			                String key= iter.getKey();
//		                	while (!trgt.containsKey(key)){
//		                		iter=entries.next();
//		                		key= iter.getKey();
//		                	}
//		                	
//			                String value=iter.getValue();
//			        		for (DTOBase elem2: lista){
//				        		subQuery.setTable(1, key);
//				        		
//				        		String subColumns = value + ", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).targets.get(key);
//				        		subQuery.setField(2, subColumns);
//				        		
//				        		String subValues = "";
//	//			        		for (DTOBase elem: lista){
//				        			subValues += elem2.getId() + ", ??";
//	//			        		subValues=subValues.substring(0, subValues.length()-4);
//	//			        		String subValues = elem.getId() + ", ??";
//	//			        		fieldMapper.get(elem.getClass().getSimpleName().toLowerCase());
//				        		
//				        		subQuery.setField(3, subValues);
//				        		//TODO
//	//			        		subQueries.add(subQuery);
//				        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(elem);
//			        			try{
//	//			        			lista2.addAll(partial);
//			        				sbQuery.put(elem2, subQuery);
//	//			        			newSubQueries.put(o, lista2);
//			        			}
//			        			catch(Exception e){
//			        				sbQuery = new HashMap<>();
//			        				sbQuery.put(elem2, subQuery);
//				        			newSubQueries.put(elem, sbQuery);
//			        			}
//				        		subQuery = new StringBuilderQuery(updateQuery);
//				        		}
//		                }
//		                
//	//	        		System.out.println();
//	//	        		System.out.println();
//	//	        		System.out.println();
//		        		
//	//	        		if (column==null){
//	//	        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
//	//	        			if (column==null){
//	//	        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
//	//	        			}
//	//	        		}
//	////	                for (Type tp: arr) {
//	////	                    Class<?> clzz = (Class<?>)tp;
//	////	                    System.out.println(clzz.getName());
//	////	                }
//		            }
//					
//				}
//				
//			}
//			
//			columnList+="__";
//			valueList+="??";
//			
//			
//			if (fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
//				columnList+=", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
//				valueList+=", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//			}
//			
//			
//			
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
//			StringBuilderQuery myQuery=new StringBuilderQuery(updateQuery);
//			
//			myQuery.setTable(1, getTable(elem));
//	//		myQuery.setField(2, getColumns(o));
//	//		myQuery.setField(3, getValues(o));
//			myQuery.setField(2, columnList);
//			myQuery.setField(3, valueList);
//			subQueries=myQuery;
//			//TODO
//	//		subQueries.add(myQuery);
//			
//			
//	//		try {
//	//			statement = getConnection().createStatement1();
//	////			statement.execute1Update(elem.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//	//			statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//	//			ResultSet rs = statement.getGeneratedKeys();
//	//			rs.next();
//	//			elem.setId(rs.getLong(1));
//	//			
//	//			for (StringBuilderQuery subs : subQueries){
//	//				subs.replaceAll("??", elem.getId());
//	//				statement.execute1Update(subs.toString());
//	//			}
//	//			
//	////			statement.execute1Update(elem.getSubQuery());
//	//		} catch (SQLException e) {
//	//			// TODO Auto-generated catch block
//	//			e.printStackTrace();
//	//		}
//			
//			return subQueries;
//		}
//	private static boolean hasDiscriminator(Class<?> claz){
//		
//		return (fieldMapper.get(claz.getSimpleName().toLowerCase()).getDiscriminator()!=null);
//	}
//	private static String getDiscriminatorColumn(Class<?> claz){
//		return fieldMapper.get(claz.getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
//	}
//			
//	private static String getDiscriminatorValue(Class<?> claz){
//		return fieldMapper.get(claz.getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//	}
			
//	public static ResultSet loadAll(Class<?> claz){
//		StringBuilderQuery myQuery=new StringBuilderQuery(readAllQuery);
//		
//		myQuery.setField(1, getFilteredColumns(claz));
//		myQuery.setTable(2, getTable(claz));
//		
//		if (hasDiscriminator(claz)){
//			myQuery.append(" where " + getDiscriminatorColumn(claz) + " = " + getDiscriminatorValue(claz));
//		}
//		ResultSet rs=executeQuery(myQuery.toString());
//		
//		return rs;
//		
//	}
			
	public static ResultSet executeQuery(String query){
				ResultSet rs = null;
				try {
					DAO.printToConsole(query);
					statement = getConnection().createStatement();
					rs = statement.executeQuery(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				
				
				
				return rs;
			}
	private void ____________________________________________1OK(){}
	
	private void ____________________________________________0(){}
	
	private static String extractTable(DTOBase o){
			String className = o.getClass().getSimpleName().toLowerCase();
			Element tab=document.getRootElement().getChild(className);
				
			return tab.getAttributeValue("tableName");
		}
		private static String extractOnlyFields(DTOBase o){
			String className = o.getClass().getSimpleName().toLowerCase();
			Element tab=document.getRootElement().getChild(className);
			String fields="";
			
			for (Element sub : tab.getChildren()){
				fields+=sub.getAttributeValue("columnName") + ", ";
			}
			fields=fields.substring(0,fields.length()-2);
			
			
			return fields;
		}
		private static String extractIdAndFields(DTOBase o){
			String fields=document.getRootElement().getAttributeValue("default") + ", " + extractOnlyFields(o);
			
			return fields;
		}
		private static String extractFieldValues(DTOBase o){
			Class<?> clazz = o.getClass();
			String className = clazz.getSimpleName().toLowerCase();
			Element tab=document.getRootElement().getChild(className);
			String fields="";
			String attribute = "";
			
			for (Element sub : tab.getChildren()){
				attribute = sub.getAttributeValue("attributeName");
				Field field=null;
				try {
					field =clazz.getDeclaredField(attribute);
					field.setAccessible(true);
					
					if (field.get(o) instanceof String)
						fields += "'" + field.get(o) + "'";
					
					if (field.get(o) instanceof DTOBase)
						fields += ((DTOBase)field.get(o)).getId();
					
					if (field.get(o) instanceof Stato)
						fields += Stato.fromName((Stato) field.get(o));
					
//					else{
//						fields += field.get(o);
//					}
					fields+= ", ";
//					field.setAccessible(false);
				}
				catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//					 TODO Auto-generated catch block
//					e.printStackTrace();
					boolean found = false;
					Class<?> superClazz = clazz.getSuperclass();
					
					while(!found){
						try {
							field =superClazz.getDeclaredField(attribute);
							field.setAccessible(true);
							found=true;
							if (field.get(o) instanceof String)
								fields += "'" + field.get(o) + "'";
							
							if (field.get(o) instanceof DTOBase)
								fields += ((DTOBase)field.get(o)).getId();
							
							if (field.get(o) instanceof Stato)
								fields += Stato.fromName((Stato) field.get(o));
							
//							else{
//								fields += field.get(o);
//							}
							fields+= ", ";
							
							
						} catch (NoSuchFieldException | SecurityException e1) {
							// TODO Auto-generated catch block
//							e1.printStackTrace();
							superClazz = superClazz.getSuperclass();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							RCMException.showException(e1);
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							RCMException.showException(e1);
						}
						
						
					}
					
					
					
					
					
//					fields +=extractFieldValuesFromSuperClass(className, clazz.getSuperclass());
				}
				
//				fields+=sub.getAttributeValue("attributeName") + ", ";
			}
			fields=fields.substring(0,fields.length()-2);
			
			
			return fields;
		}
		private static String extractFieldValuesFromSuperClass(String className, Class<?> actualSuperClass){
			Element tab=document.getRootElement().getChild(className);
//			String fields="";
//			String attribute = "";
//			
//			for (Element sub : tab.getChildren()){
//				attribute = sub.getAttributeValue("attributeName");
//				Field field=null;
//				try {
//					field =clazz.getDeclaredField(attribute);
//					field.setAccessible(true);
//					
//					if (field.get(o) instanceof String){
//						fields += "'" + field.get(o) + "'";
//					}else{
//						fields += field.get(o);
//					}
//					fields+= ", ";
////					field.setAccessible(false);
//				}
//				catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
////					 TODO Auto-generated catch block
////					e.printStackTrace();
//					
//					fields +=
//				}
//				
////				fields+=sub.getAttributeValue("attributeName") + ", ";
//			}
//			fields=fields.substring(0,fields.length()-2);
//			
//			
			return "";
		}
		private static String extractIdAndFieldValues(DTOBase o){
//			String fields=document.getRootElement().getAttributeValue("default") + ", " + extractOnlyFields(o);
//			
//			return fields;
			return "";
		}
//	private Element getXmlElement(Class<? extends DTOBase> cls){
//		
//		return document.getRootElement().getChild(cls.getSimpleName().toLowerCase());
//		
//	}
	
	private void ___________________________________________00(){}
	public static ResultSet loadDefault(Class<? extends DTOBase> cls){
//		boolean found=false;
		
		//elemento radice di tutte le classi
		rootNode = document.getRootElement();
		List<Element> children = rootNode.getChildren();
		StringBuilderQuery myQuery=null;
		
		for (int i=0; i < children.size()/* / && !found/**/; i++){
			Element child = children.get(i);
			if (child.getAttributeValue("className").equals(cls.getSimpleName().toLowerCase())){
				myQuery = new StringBuilderQuery("select ? from ?");
				
				myQuery.setField(1, getDefaultFields(child));
				myQuery.setField(2, child.getAttributeValue("tableName"));
				
				i=children.size()+1;
			}
		}
		
		ResultSet rs=DAO.executeQuery(myQuery.toString());
		
//		for (Element child: rootNode.getChildren()){
//			if (child.getAttribute("className").equals(cls.getSimpleName().toLowerCase())){
//				StringBuilderQuery myQuery = new StringBuilderQuery("select ? from ?");
//				
//				String fieldsString = child.getAttributeValue("defaultFields");
//				myQuery.setField(1, rootNode.getAttributeValue("default") + ", " + fieldsString);
//				myQuery.setField(2, child.getAttributeValue("tableName"));
//			}
//		}
		
		
		
		
		return rs;
	}
	
	private static String getDefaultFields(Element child){
		
		String defaultFields=child.getParentElement().getAttributeValue("default") + ", " + child.getAttributeValue("defaultFields");
		
		return defaultFields;
	}
	
	@Deprecated
	private static String getAllFields(DTOBase element){
		
		
		
		
		
		
//		String defaultFields=child.getParentElement().getAttributeValue("default") + ", " + child.getAttributeValue("defaultFields");
		
		return "";
	}
	
	
	private String extractCreateQuery(DTOBase dto){
		String query="";
		
		
		
		return query;
	}
	
	
	private void ____________________________________________1(){}
//	public static void read(DTOBase o, HashMap<Class<?>, HashMap<Long, DTOBase>> memory2){
//		try{
//		String columnList="";
//		ResultSet rs=null;
//		StringBuilderQuery myQuery=new StringBuilderQuery(readQuery);
//		
//		HashMap<String, String> fields = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).fieldList;
////		if (fields.size()==0)
////			fields = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).preloadFields;
//		
//		if (fields.size()>0){
//			
//			for (String column : fields.values()){
//				if (column!=null)
//				columnList+= column + ", ";
//			}
//			columnList=columnList.substring(0,columnList.length()-2);
//			myQuery.setField(1, columnList);
//			myQuery.setTable(2, getTable(o));
//			myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.field + "=" + o.getId());
////			try {
//				statement = getConnection().createStatement1();
//				rs = statement.executeQuery(myQuery.toString());
//				rs.next();
////			} catch (SQLException e1) {
////				// TODO Auto-generated catch block
////				e1.printStackTrace();
////			}
//			
//			
//			for (Entry<String, String> s : fields.entrySet()){
//				Field f = retrieveField(s.getKey(), o.getClass());
//				
////				if (f.getName().toLowerCase().equals("condizioni"))
////					System.out.print("");
//				
//				//lo rendo accessibile
//				f.setAccessible(true);
//				
//				
//				if (!List.class.isAssignableFrom(f.getType())){
//					if (!DTOBase.class.isAssignableFrom(f.getType())){
//							//valuta attributo atomico
//							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//		//								valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
//									f.set(o, Stato.fromValue(rs.getInt(s.getValue())));
//									break;
//								case "tipoazienda":
//									f.set(o, TipoAzienda.fromValue(rs.getInt(s.getValue())));
//									break;
//								case "movimentazione":
//									f.set(o, Movimentazione.fromValue(rs.getInt(s.getValue())));
//									break;
//								default:
//									break;
//								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//		//							valueList+= "'" + f.get(o) + "', ";
//									try {
//										f.set(o, rs.getString(s.getValue()));
////										rs.previous();
//									} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
//										// TODO Auto-generated catch block
//										f.set(o, "");
//									}
//									break;
//								case "long":
//									break;
//								case "int":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(o, rs.getInt(s.getValue()));
//									break;
//								case "boolean":
//									f.set(o, rs.getBoolean(s.getValue()));
//									break;
//								case "float":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(o, rs.getFloat(s.getValue()));
//									break;
//								case "double":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(o, rs.getDouble(s.getValue()));
//									break;
//								default:
//									break;
//								}
//							}
//						}
//						else{
//		//					//caricare i campi "filtrati" del sottotipo
//		//					//si tratta di un oggetto di cui devo ricavare solo l'ID
//							
//		//					for (String column : fields.values()){
//		//						columnList+= column + ", ";
//		//					}
//		//					columnList=columnList.substring(0,columnList.length()-2);
//							
//							
//	//						myQuery.setField(1, s.getValue());
//	//						myQuery.setTable(2, getTable(o));
//	//						myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.field + "=" + o.getId());
//							
////							try {
////	//							statement = getConnection().createStatement1();
////	//							ResultSet rs = statement.executeQuery(myQuery.toString());
////	//							rs.next();
////								
//								DTOBase subObject = memory2.get(f.getType()).get(rs.getLong(s.getValue()));
//								
//								if (subObject!=null)
//									read(subObject, memory2);
//								
//								f.set(o, subObject);
////							} catch (SQLException e) {
////								// TODO Auto-generated catch block
////								e.printStackTrace();
////							} catch (IllegalArgumentException e) {
////								// TODO Auto-generated catch block
////								e.printStackTrace();
////							} catch (IllegalAccessException e) {
////								// TODO Auto-generated catch block
////								e.printStackTrace();
////							}
//							
//		//					try{
//		//					valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//		//					}
//		//					catch(NullPointerException e){
//		//						valueList+= " NULL , ";
//		//					}
//		////					HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
//		////					f.set(o, subElements.get(rs.getLong(column)));
//						}
//					
//			}
//			else{
////				if (s.getKey().equals("riferimenti")){
////					System.out.print("");
////				}
//				
//				ResultSet rs2=null;
//				//gestire gli array
//				@SuppressWarnings("unused")
//				StringBuilderQuery subQuery = new StringBuilderQuery(readQuery);
//				
//				ArrayList<DTOBase> lista = new ArrayList<>();// (ArrayList<DTOBase>) f.get(o);
//				
//	            Type type = f.getGenericType();
//
//	            if (type instanceof ParameterizedType) {
//
//	                ParameterizedType pType = (ParameterizedType)type;
//	                Type[] arr = pType.getActualTypeArguments();
//	                Class<?> innerClass = (Class<?>) arr[0];
//	                
////	                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
////	                subQuery.setField(2, getTable(innerClass));
//	                
//	                String externalID = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//	                
////	                if(f.getName().toLowerCase().equals("riferimenti")){
////	                	System.out.print("");
////	                }
//	                
//	                
//                	ArrayList<StringBuilderQuery> subQueries = new ArrayList<>();
//	                if (externalID!=null){
////	                	Field innerField = retrieveField("stato", innerClass);
//	                	boolean found=false;
//		                subQuery.setField(1, "stato");
//		                subQuery.setField(2, getTable(innerClass));
//	                	subQuery.setField(3, externalID + "=" + o.getId());
//	                	try{
//	                		ResultSet myRS = getConnection().createStatement1().executeQuery(subQuery.toString());
//	                		found=true;
//	                	}catch(SQLException e){
//	                		//
//	                		System.out.print("");
//	                	}
//	                	
//	                	subQuery = new StringBuilderQuery(readQuery);
//		                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//		                subQuery.setField(2, getTable(innerClass));
//	                	subQuery.setField(3, externalID + "=" + o.getId());
//	                	if (found==true){
//	                		subQuery.append(" and stato=" + Stato.fromName(Stato.Attivo));
//	                	}
//	                	
//////	                	Field innerField = retrieveField("stato", innerClass);
////	                	
////		                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
////		                subQuery.setField(2, getTable(innerClass));
////	                	subQuery.setField(3, externalID + "=" + o.getId());
//////	                	if (innerField!=null){
//////	                		subQuery.append(" and stato=" + Stato.fromName(Stato.Attivo));
//////	                	}
//	                	
//	                }
//	                else{
////	                	Entry<String, String> external = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
////		                subQuery.setField(2, getTable(innerClass) + ", " + external.getKey());
////	                	externalID = external.getValue();
////	                	
////	                	String externalID2 = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.get(external.getKey());
//////	                	for (Integer iter : fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets)
//////	                	fieldMapper.get(innerClass.getSimpleName().toLowerCase());
////	                	
////	                	
////		                subQuery.setField(3, externalID + "=" + o.getId() + " and " + externalID2 + "=" + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).tableName + "." + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//	                	Iterator<Entry<String, String>> external = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.entrySet().iterator();
//	                	HashMap<String, String> external2 = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets;
////	                	String xtrnlID = "";
//	                	
//	                	
//	                	boolean found =false;
//	                	while (!found){
//	                		Entry<String, String> x = external.next();
//	                		
//	                		if (external2.containsKey(x.getKey())){
//	                			found=true;
//	    	                	subQuery.setField(1, external2.get(x.getKey()) + " as id");
//	    		                subQuery.setField(2, x.getKey());
//	    		                subQuery.setField(3, x.getValue() + "=" + o.getId());
//	                		}
//	                	}
//	                	
//	                	
////	                	subQuery.setField(1, external2.get(external.getKey()) + " as id");
////		                subQuery.setField(2, external.getKey());
////		                subQuery.setField(3, external.getValue() + "=" + o.getId());
//	                	
//		                ResultSet rs4 = getConnection().createStatement1().executeQuery(subQuery.toString());
//		                String columns = getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column;
//		                String table = getTable(innerClass);
//
//		                while(rs4.next()){
//////		                rs4.next();
////		                if (rs4.next()){
////		                	rs4.beforeFirst();
//							subQuery = new StringBuilderQuery(readQuery);
////			                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
////			                subQuery.setField(2, getTable(innerClass));
//			                subQuery.setField(1, columns);
//			                subQuery.setField(2, table);
//		                	String ids ="id=" + rs4.getString("id");
////		                	while(rs4.next()){
////		                		ids+="id=" + rs4.getString("id") + " and ";
////		                	}
////		                	ids=ids.substring(0,ids.length()-5);
//		                	
//		                	subQuery.setField(3, ids);
//		                	subQueries.add(subQuery);
//		                }
//		                subQuery=null;
//
////		                else{
////		                	subQuery=null;
////		                }
//		                
//	                }
//	                	
//	                
////	                try {
//	                if (subQuery!=null){
////		    			statement2 = getConnection().createStatement1();
//							rs2=getConnection().createStatement1().executeQuery(subQuery.toString());
//							
//							lista = subRead(innerClass, rs2, memory2);
//	                }
//	                else{
//	                	for (StringBuilderQuery query : subQueries){
//	                		rs2=getConnection().createStatement1().executeQuery(query.toString());
//	                		lista.addAll(subRead(innerClass, rs2, memory2));
//	                	}
//	                }
//						f.set(o, lista);
////						if (f.getName().toLowerCase().equals("condizioni"))
////							System.out.print(lista.size());
//						
////						while (rs2.next()){
////							
////							DTOBase item = (DTOBase) innerClass.newInstance();
////							item.setId(rs2.getLong("id"));
////							
////							subRead(lista, rs2);
////							
////							read(item, memory2);
////							lista.add(item);
//////							System.out.println();
////							
////							
//////							f.set(item, getSubElement(item, memory2));
////							
////							
//////							DTOBase item = (DTOBase) innerClass.newInstance();
//////										
//////							for (String it: (getAllFields(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.field).split(", ")){
//////								
//////								//ricavo l'attributo sulla base del nome
//////								Field f2 = retrieveField(it, innerClass);
//////								
//////								//lo rendo accessibile
//////								f2.setAccessible(true);
//////								
//////								//e lo vado ad avvalorare
//////								//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//////								String column = DAO.getColumn(it, innerClass);
//////								
//////								if (!DTOBase.class.isAssignableFrom(f2.getType())){
////////								if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//////									//valuta attributo atomico
//////									String atomicClassName = f2.getType().getSimpleName().toLowerCase();
////////									String column = DAO.getColumn(it, myClass);
//////									if (f.getType().isEnum()){
//////										switch(atomicClassName){
//////										case "stato":
//////											f2.set(item, Stato.fromValue(rs2.getInt(column)));
//////											break;
//////										default:
//////											break;
//////										}
//////									}
//////									else{
//////										switch(atomicClassName){
//////										case "string"1:
//////											f2.set(item, rs2.getString(column));
//////											break;
//////										case "long":
//////											f2.set(item, rs2.getLong(column));
//////											break;
//////											f2.set(item, rs2.getInt(column));
//////											break;
//////										default:
//////											break;
//////										}
//////									}
//////								}
//////								else{
//////									//caricare i campi "filtrati" del sottotipo
//////////									DTOBase subItem = loadSubMemory(f.getType())
////////									HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////////									f.set(item, subElements.get(rs2.getLong(column)));
//////////									f.set(item, loadSubMemory(f.getType()));
//////									
//////									f2.set(item, getSubElement((DTOBase) f2.get(item), memory2));
//////									
//////									
//////									
//////								}
//////								
//////							}
//////							lista.add(item);
////////							addElement((DTOBase) item);
////						}
//						
//						
//						
////					} catch (SQLException | IllegalArgumentException | IllegalAccessException | InstantiationException e1) {
////						// TODO Auto-generated catch block
////						e1.printStackTrace();
////					}
//	                
//	                
//	                
//	                
//
//	                
////	                HashMap<String, String> externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).fieldList;
////	                
//////	                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
////	                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
////	                
////	                
////	                if (externalKey!=null){
////		        		for (DTOBase elem: lista){
////		        			
//////		        			subQueries.addAll(extractSubQueries(elem));
////		        			
////		        			HashMap lista2 = newSubQueries.get(o);
////	        				Object partial = extractCreateSubQueries(elem);
////	        				
//////	        				if (partial instanceof StringBuilderQuery){
//////	        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
//////	        				}
////		        			try{
//////			        			lista2.addAll(partial);
////			        			lista2.put(elem, partial);
//////			        			newSubQueries.put(o, lista2);
////		        			}
////		        			catch(Exception e){
////		        				lista2 = new HashMap<>();
////			        			lista2.put(elem, partial);
////			        			newSubQueries.put(o, lista2);
////		        			}
////		        			
////		        			
////		        			
////			        		
////			        		}
////		        		
////		        		
////		        		
////	                }else{
////	                	Entry<String, String> iter=entries.next();
////	                	
////	                	HashMap<String, String> trgt = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets;
////		                String key= iter.getKey();
////	                	while (!trgt.containsKey(key)){
////	                		iter=entries.next();
////	                		key= iter.getKey();
////	                	}
////	                	
////		                String value=iter.getValue();
////		        		for (DTOBase elem: lista){
////			        		subQuery.setTable(1, key);
////			        		
////			        		String subColumns = value + ", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////			        		subQuery.setField(2, subColumns);
////			        		
////			        		String subValues = "";
////			        			subValues += elem.getId() + ", ??";
////			        		
////			        		subQuery.setField(3, subValues);
////			        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(o);
////		        			try{
////		        				sbQuery.put(elem, subQuery);
////		        			}
////		        			catch(Exception e){
////		        				sbQuery = new HashMap<>();
////		        				sbQuery.put(elem, subQuery);
////			        			newSubQueries.put(o, sbQuery);
////		        			}
////			        		subQuery = new StringBuilderQuery(createQuery);
////			        		}
////	                }
//	                
//	            }
//				
//			}
//				
//				
//				
//				
//			}
//		}	
////		else{
////			o = memory2.get(o.getClass()).get(o.getId());
////		}
//		
//		
//		
//		
//		
////					//ricavare l'elenco degli attributi
////					String columnList="";
////					String valueList="";
////					
////					
////					
////					try {
////					
////					for (String it: DAO.getAllFields(o.getClass()).split(", ")){
////						//ricavo l'attributo sulla base del nome
////						Field f = retrieveField(it, o.getClass());
////						//lo rendo accessibile
////						f.setAccessible(true);
////	//					System.out.println();
////						
////						
////						if (!List.class.isAssignableFrom(f.getType())){
////							//e lo vado ad avvalorare
////							//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
////							String column = DAO.getColumn(it, o.getClass());
////							
////							columnList+=column + ", ";
////							
////	//					if (f.getType() instanceof ArrayList<?>){
////							if (!DTOBase.class.isAssignableFrom(f.getType())){
////	//							if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
////									//valuta attributo atomico
////									String atomicClassName = f.getType().getSimpleName().toLowerCase();
////	//								String column = DAO.getColumn(it, o.getClass());
////									if (f.getType().isEnum()){
////										switch(atomicClassName){
////										case "stato":
////												valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////	//										f.set(o, Stato.fromValue(rs.getInt(column)));
////											break;
////										default:
////											break;
////										}
////									}
////									else{
////										switch(atomicClassName){
////										case "string"1:
////											valueList+= "'" + f.get(o) + "', ";
////	//										f.set(o, rs.getString(column));
////											break;
////										case "long":
////	//										f.set(o, rs.getLong(column));
////											break;
////											valueList+= "" + f.get(o) + ", ";
////											break;
////										case "double":
////											valueList+= "" + f.get(o) + ", ";
////											break;
////										default:
////											break;
////										}
////									}
////								}
////								else{
////									//caricare i campi "filtrati" del sottotipo
////									//si tratta di un oggetto di cui devo ricavare solo l'ID
////									try{
////									valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
////									}
////									catch(NullPointerException e){
////										valueList+= " NULL , ";
////									}
////	//								HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////	//								f.set(o, subElements.get(rs.getLong(column)));
////								}
////						}
////						else{
////							//gestire gli array
////							@SuppressWarnings("unused")
////							StringBuilderQuery subQuery = new StringBuilderQuery(createQuery);
////							
////							ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(o);
////							
////				            Type type = f.getGenericType();
////	
////				            if (type instanceof ParameterizedType) {
////	
////				                ParameterizedType pType = (ParameterizedType)type;
////				                Type[] arr = pType.getActualTypeArguments();
////				                Class<?> innerClass = (Class<?>) arr[0];
////				                
////				                
////				                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
////				                
////	//			                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
////				                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
////				                
////				                
////	//			        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
////				        		
////				                
////				                if (externalKey!=null){
////					        		for (DTOBase elem: lista){
////					        			
////	//				        			subQueries.addAll(extractSubQueries(elem));
////					        			
////					        			HashMap lista2 = newSubQueries.get(o);
////				        				Object partial = extractReadSubQueries(elem);
////				        				
////				        				if (partial instanceof StringBuilderQuery){
////				        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
////				        				}
////	//					        		for (StringBuilderQuery subs : partial){
////	//										subs.replaceAll("__", externalKey);
////	//					        		}
////					        			try{
////	//					        			lista2.addAll(partial);
////						        			lista2.put(elem, partial);
////	//					        			newSubQueries.put(o, lista2);
////					        			}
////					        			catch(Exception e){
////					        				lista2 = new HashMap<>();
////						        			lista2.put(elem, partial);
////						        			newSubQueries.put(o, lista2);
////					        			}
////					        			
////					        			
////					        			
////	//				        			newSubQueries.put(elem, extractSubQueries(elem));
////					        			
////					        			
////	//					        		subQuery.setTable(1, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).tableName);
////	//
////	//					        		String subColumns = externalKey + ", ";// + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////	//					        		
////	//									for (String subIt: DAO.getAllFields(f.getType()).split(", ")){
////	//										
////	//									}
////						        		
////	//					        		subQuery.setField(2, subColumns);
////	//					        		
////	//					        		String subValues = "";
////	////					        		for (DTOBase elem: lista){
////	//					        			subValues += elem.getId() + ", ??";
////	////					        		subValues=subValues.substring(0, subValues.length()-4);
////	////					        		String subValues = o.getId() + ", ??";
////	////					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////	//					        		
////	//					        		subQuery.setField(3, subValues);
////	//					        		subQueries.add(subQuery);
////	//					        		subQuery = new StringBuilderQuery(createQuery);
////						        		}
////					        		
////					        		
////					        		
////	////				        		for (StringBuilderQuery subs : subQueries){
////	////									subs.replaceAll("__", externalKey);
////	////				        		}
////	//								for (Object subs : newSubQueries.values()){
////	//									if (subs instanceof StringBuilderQuery)
////	//										((StringBuilderQuery)subs).replaceAll("__", externalKey);
////	//								}
////					        		
////					        		
////				                	
////				                }else{
////				                	Entry<String, String> iter=entries.next();
////				                	
////				                	HashMap<String, String> trgt = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets;
////					                String key= iter.getKey();
////				                	while (!trgt.containsKey(key)){
////				                		iter=entries.next();
////				                		key= iter.getKey();
////				                	}
////				                	
////					                String value=iter.getValue();
////					        		for (DTOBase elem: lista){
////						        		subQuery.setTable(1, key);
////						        		
////						        		String subColumns = value + ", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////						        		subQuery.setField(2, subColumns);
////						        		
////						        		String subValues = "";
////	//					        		for (DTOBase elem: lista){
////						        			subValues += elem.getId() + ", ??";
////	//					        		subValues=subValues.substring(0, subValues.length()-4);
////	//					        		String subValues = o.getId() + ", ??";
////	//					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////						        		
////						        		subQuery.setField(3, subValues);
////	////					        		subQueries.add(subQuery);
////	//					        		newSubQueries.put(subQuery, null);
////						        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(o);
////					        			try{
////	//					        			lista2.addAll(partial);
////					        				sbQuery.put(elem, subQuery);
////	//					        			newSubQueries.put(o, lista2);
////					        			}
////					        			catch(Exception e){
////					        				sbQuery = new HashMap<>();
////					        				sbQuery.put(elem, subQuery);
////						        			newSubQueries.put(o, sbQuery);
////					        			}
////						        		subQuery = new StringBuilderQuery(createQuery);
////						        		}
////				                }
////				                
////	//			        		System.out.println();
////	//			        		System.out.println();
////	//			        		System.out.println();
////				        		
////	//			        		if (column==null){
////	//			        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
////	//			        			if (column==null){
////	//			        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
////	//			        			}
////	//			        		}
////	////			                for (Type tp: arr) {
////	////			                    Class<?> clzz = (Class<?>)tp;
////	////			                    System.out.println(clzz.getName());
////	////			                }
////				            }
////							
////						}
////						
////					}
////					
////					columnList=columnList.substring(0,columnList.length()-2);
////	//				System.out.println();
////					valueList=valueList.substring(0,valueList.length()-2);
////					
////					
////					if (fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
////						columnList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
////						valueList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
////					}
////					
////					
////					
////					} catch (IllegalArgumentException | IllegalAccessException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////					
////					
////					
////					StringBuilderQuery myQuery=new StringBuilderQuery(createQuery);
////					
////					myQuery.setTable(1, getTable(o));
////	//				myQuery.setField(2, getColumns(o));
////	//				myQuery.setField(3, getValues(o));
////					myQuery.setField(2, columnList);
////					myQuery.setField(3, valueList);
////					
////					
////					
////					
////					try {
////						statement = getConnection().createStatement1();
////	//					statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
////						statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////						ResultSet rs = statement.getGeneratedKeys();
////						rs.next();
////						o.setId(rs.getLong(1));
////						
////	//					for (StringBuilderQuery subs : subQueries){
////	//						subs.replaceAll("??", o.getId());
////	//						statement.execute1Update(subs.toString());
////	//					}
////						
////						HashMap<DTOBase, StringBuilderQuery> firstPass = newSubQueries.get(o);
////						if (firstPass!=null){
////							newSubQueries.remove(o);
////							for (DTOBase subKey : firstPass.keySet()){
////								StringBuilderQuery subElementQuery = firstPass.get(subKey);
////								subElementQuery.replaceAll("??", o.getId());
////								
////								if (newSubQueries.containsKey(subKey)){
////									statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////									ResultSet rs2 = statement.getGeneratedKeys();
////									rs2.next();
////									subKey.setId(rs2.getLong(1));
////								}
////								else{
////									statement.execute1Update(subElementQuery.toString());
////								}
////								
////								
////							}
////						}
////						
////						
////						
////						for (DTOBase subs : newSubQueries.keySet()){
////							HashMap<DTOBase, StringBuilderQuery> subElement = newSubQueries.get(subs);
////							
////							for (DTOBase subKey : subElement.keySet()){
////								StringBuilderQuery subElementQuery = subElement.get(subKey);
////								subElementQuery.replaceAll("??", subs.getId());
////								
////								if (newSubQueries.containsKey(subKey)){
////									statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////									ResultSet rs2 = statement.getGeneratedKeys();
////									rs2.next();
////									subKey.setId(rs2.getLong(1));
////								}
////								else{
////									statement.execute1Update(subElementQuery.toString());
////								}
////								
////								
////							}
////							
////							
////	//						if (subs instanceof StringBuilderQuery){
////	//							((StringBuilderQuery) subs).replaceAll("??", o.getId());
////	//							statement.execute1Update(subs.toString());
////	//						}
////						}
////						
////						
////						
////						
////	//					statement.execute1Update(o.getSubQuery());
////					} catch (SQLException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////					newSubQueries=new HashMap<>();
////		//			try{
////		//				statement = getConnection().createStatement1();
////		//				
////		//				StringBuilderQuery query = new StringBuilderQuery(createQuery);//"insert into ? (?) values (?);"
////		//				query.setTable(1, extractTable(o));
////		//				query.setTable(2, extractOnlyFields(o));
////		//				query.setTable(3, extractFieldValues(o));
////		//	//			query.setTable(1, getTable());
////		//	////			query.append(getTable());
////		//	//			query.setValue(2, getId());
////		//	////			query.append(getId());
////		//	//					
////		//	//			return query.toString();
////		//				
////		//				
////		//				
////		////				statement.execute1Update(getAllFields(o),Statement.RETURN_GENERATED_KEYS);
////		//				statement.execute1Update(query.toString(),Statement.RETURN_GENERATED_KEYS);
////		//				ResultSet rs = statement.getGeneratedKeys();
////		//				rs.next();
////		//				o.setId(rs.getLong(1));
////		//			}
////		//			catch (SQLException | NullPointerException e) {
////		//				e.printStackTrace();
////		//			} 
//		
//		
//		
//		
//		} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
////		System.out.println();
//				}
//	private static ArrayList<DTOBase> subRead(Class<?> innerClass, ResultSet rs2, HashMap<Class<?>, HashMap<Long, DTOBase>> memory2) {
//		// TODO Auto-generated method stub
//		
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		String columnList="";
//		DTOBase item = null;
//		StringBuilderQuery myQuery=new StringBuilderQuery(readQuery);
//		try {
////			rs2.previous();
//			
//			HashMap<String, String> fields = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).fieldList;
//			
////			if (fields.size()==0){
//			fields.putAll(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).preloadFields);
////			}
//			
////			fields.put(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.field, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//			
//			
////			for (String column : fields.values()){
////				if (column!=null)
////				columnList+= column + ", ";
////			}
////			columnList=columnList.substring(0,columnList.length()-2);
////			myQuery.setField(1, columnList);
////			myQuery.setTable(2, getTable(item));
////			myQuery.setField(3, fieldMapper.get(item.getClass().getSimpleName().toLowerCase()).coupleId.field + "=" + item.getId());
////				statement = getConnection().createStatement1();
////				rs = statement.executeQuery(myQuery.toString());
////				rs.next();
//			
////			if (rs2.next()){
////				rs2.previous();
////				lista=new ArrayList<>();
////			}
//			while (rs2.next()){
//				item = (DTOBase) innerClass.newInstance();
//				//settaggio degli id (a priori)
//				Field f = retrieveField(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.field, item.getClass());
//				f.setAccessible(true);
//				f.set(item, rs2.getLong(fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column));
//
//				for (Entry<String, String> s : fields.entrySet()){
//				/*Field*/ f = retrieveField(s.getKey(), item.getClass());
//				//lo rendo accessibile
//				f.setAccessible(true);
//				
//				
//				if (!List.class.isAssignableFrom(f.getType())){
//					if (!DTOBase.class.isAssignableFrom(f.getType())){
//							//valuta attributo atomico
//							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//		//								valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
//									f.set(item, Stato.fromValue(rs2.getInt(s.getValue())));
//									break;
//								case "tipoazienda":
//									f.set(item, TipoAzienda.fromValue(rs2.getInt(s.getValue())));
//									break;
//								case "movimentazione":
//									f.set(item, Movimentazione.fromValue(rs2.getInt(s.getValue())));
//									break;
//								default:
//									break;
//								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//		//							valueList+= "'" + f.get(o) + "', ";
//									try {
//										f.set(item, rs2.getString(s.getValue()));
////										rs.previous();
//									} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
//										// TODO Auto-generated catch block
////										e.printStackTrace();
//										f.set(item, "");
//									}
//									break;
//								case "long":
//									f.set(item, rs2.getLong(s.getValue()));
//									break;
//								case "int":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(item, rs2.getInt(s.getValue()));
//									break;
//								case "boolean":
//									f.set(item, rs2.getBoolean(s.getValue()));
//									break;
//								case "float":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(item, rs2.getFloat(s.getValue()));
//									break;
//								case "double":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(item, rs2.getDouble(s.getValue()));
//									break;
//								default:
//									break;
//								}
//							}
//						}
//						else{
//		//					//caricare i campi "filtrati" del sottotipo
//		//					//si tratta di un oggetto di cui devo ricavare solo l'ID
//							
//								DTOBase subObject =null;
//								
//								try{
//									subObject =memory2.get(f.getType()).get(rs2.getLong(s.getValue()));
//									
//									if (subObject!=null)
//										read(subObject, memory2);
//									
//									f.set(item, subObject);
//								}
//								catch(Exception e2){
//									subObject = (DTOBase) f.getType().newInstance();
//									subObject.setId(rs2.getLong(s.getValue()));
//									read(subObject, memory2);
//									f.set(item, subObject);
//								}
//								
//								
//								
//						}
//					
//			}
//			else{
//				ResultSet rs3=null;
//				//gestire gli array
//				@SuppressWarnings("unused")
//				StringBuilderQuery subQuery = new StringBuilderQuery(readQuery);
//				
//				ArrayList<DTOBase> lista2 = new ArrayList<>();// (ArrayList<DTOBase>) f.get(o);
//				
//	            Type type = f.getGenericType();
//
//	            if (type instanceof ParameterizedType) {
//
//	                ParameterizedType pType = (ParameterizedType)type;
//	                Type[] arr = pType.getActualTypeArguments();
//	                Class<?> innerClass2 = (Class<?>) arr[0];
//	                
////	                subQuery.setField(1, getAllColumns(innerClass2) + ", " + fieldMapper.get(innerClass2.getSimpleName().toLowerCase()).coupleId.column);
////	                subQuery.setField(2, getTable(innerClass2));
//	                
//	                String externalID = fieldMapper.get(innerClass2.getSimpleName().toLowerCase()).externalKey;
//                	ArrayList<StringBuilderQuery> subQueries = new ArrayList<>();
//	                
//	                if (externalID!=null){
////	                	Field innerField = retrieveField("stato", innerClass);
//	                	boolean found=false;
//		                subQuery.setField(1, "stato");
//		                subQuery.setField(2, getTable(innerClass2));
//	                	subQuery.setField(3, externalID + "=" + item.getId());
//	                	try{
//	                		ResultSet myRS = getConnection().createStatement1().executeQuery(subQuery.toString());
//	                		found=true;
//	                	}catch(SQLException e){
//	                		//
//	                		System.out.print("");
//	                	}
//	                	
//	                	
//	                	subQuery = new StringBuilderQuery(readQuery);
//		                subQuery.setField(1, getAllColumns(innerClass2) + ", " + fieldMapper.get(innerClass2.getSimpleName().toLowerCase()).coupleId.column);
//		                subQuery.setField(2, getTable(innerClass2));
//	                	subQuery.setField(3, externalID + "=" + item.getId());
//	                	
//	                	if (found==true){
//	                		subQuery.append(" and stato=" + Stato.fromName(Stato.Attivo));
//	                	}
//	                }
//	                else{
////	                	Entry<String, String> external = fieldMapper.get(item.getClass().getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
////	                	HashMap<String, String> external2 = fieldMapper.get(innerClass2.getSimpleName().toLowerCase()).targets;
////	                	
////	                	
////	                	subQuery.setField(1, external2.get(external.getKey()) + " as id");
////		                subQuery.setField(2, external.getKey());
////		                subQuery.setField(3, external.getValue() + "=" + item.getId());
//
//		                
//	                	Iterator<Entry<String, String>> external = fieldMapper.get(item.getClass().getSimpleName().toLowerCase()).targets.entrySet().iterator();
//	                	HashMap<String, String> external2 = fieldMapper.get(innerClass2.getSimpleName().toLowerCase()).targets;
////	                	String xtrnlID = "";
//	                	
//	                	
//	                	boolean found =false;
//	                	while (!found){
//	                		Entry<String, String> x = external.next();
//	                		
//	                		if (external2.containsKey(x.getKey())){
//	                			found=true;
//	    	                	subQuery.setField(1, external2.get(x.getKey()) + " as id");
//	    		                subQuery.setField(2, x.getKey());
//	    		                subQuery.setField(3, x.getValue() + "=" + item.getId());
//	                		}
//	                	}
//	                	
//	                	
////	                	subQuery.setField(1, external2.get(external.getKey()) + " as id");
////		                subQuery.setField(2, external.getKey());
////		                subQuery.setField(3, external.getValue() + "=" + o.getId());
//		                
//		                
//		                
//		                
//		                ResultSet rs4 = getConnection().createStatement1().executeQuery(subQuery.toString());
//		                String columns = getAllColumns(innerClass2) + ", " + fieldMapper.get(innerClass2.getSimpleName().toLowerCase()).coupleId.column;
//		                String table = getTable(innerClass2);
//
//		                while(rs4.next()){
//////		                rs4.next();
////		                if (rs4.next()){
////		                	rs4.beforeFirst();
//							subQuery = new StringBuilderQuery(readQuery);
////			                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
////			                subQuery.setField(2, getTable(innerClass));
//			                subQuery.setField(1, columns);
//			                subQuery.setField(2, table);
//		                	String ids ="id=" + rs4.getString("id");
////		                	while(rs4.next()){
////		                		ids+="id=" + rs4.getString("id") + " and ";
////		                	}
////		                	ids=ids.substring(0,ids.length()-5);
//		                	
//		                	subQuery.setField(3, ids);
//		                	subQueries.add(subQuery);
//		                }
//		                subQuery=null;
////		                else{
////		                	subQuery=null;
////		                }
//		                
//	                }
//	                	
//	                
////	                try {
//	                if (subQuery!=null){
//						rs3=getConnection().createStatement1().executeQuery(subQuery.toString());
//						lista2 = subRead(innerClass2, rs3, memory2);
//	                }
//	                else{
//	                	for (StringBuilderQuery query : subQueries){
//							rs3=getConnection().createStatement1().executeQuery(query.toString());
//							lista2.addAll(subRead(innerClass2, rs3, memory2));
//	                	}
//	                }
//					f.set(item, lista2);
//	            }						
////				ResultSet rs2=null;
////				//gestire gli array
////				@SuppressWarnings("unused")
////				StringBuilderQuery subQuery = new StringBuilderQuery(readQuery);
////				
////				ArrayList<DTOBase> lista = new ArrayList<>();// (ArrayList<DTOBase>) f.get(o);
////				
////	            Type type = f.getGenericType();
////
////	            if (type instanceof ParameterizedType) {
////
////	                ParameterizedType pType = (ParameterizedType)type;
////	                Type[] arr = pType.getActualTypeArguments();
////	                Class<?> innerClass = (Class<?>) arr[0];
////	                
////	                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//////	                subQuery.setField(2, getTable(innerClass));
////	                
////	                String externalID = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
////	                
////	                if (externalID!=null){
////		                subQuery.setField(2, getTable(innerClass));
////	                	subQuery.setField(3, externalID + "=" + o.getId());
////	                }
////	                else{
////	                	Entry<String, String> external = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
////		                subQuery.setField(2, getTable(innerClass) + ", " + external.getKey());
////	                	externalID = external.getValue();
////	                	
////	                	String externalID2 = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.get(external.getKey());
////	                	
////		                subQuery.setField(3, externalID + "=" + o.getId() + " and " + externalID2 + "=" + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).tableName + "." + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
////	                }
////	    			statement2 = getConnection().createStatement1();
////						rs2=statement2.executeQuery(subQuery.toString());
////						
////						lista = subRead(innerClass, rs2);
////						f.set(o, lista);
////						
////	            }
////				
//					}
//					
//				}
//			lista.add(item);
//			}
//			
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return lista;
//	}
//	private static Object getSubElement(DTOBase item, HashMap<Class<?>, HashMap<Long, DTOBase>> memory2) {
//		try{
//		String columnList="";
//		ResultSet rs=null;
//		StringBuilderQuery myQuery=new StringBuilderQuery(readQuery);
//		
//		HashMap<String, String> fields = fieldMapper.get(item.getClass().getSimpleName().toLowerCase()).fieldList;
//		
//		if (fields.size()>0){
//			
//			for (String column : fields.values()){
//				if (column!=null)
//				columnList+= column + ", ";
//			}
//			columnList=columnList.substring(0,columnList.length()-2);
//			myQuery.setField(1, columnList);
//			myQuery.setTable(2, getTable(item));
//			myQuery.setField(3, fieldMapper.get(item.getClass().getSimpleName().toLowerCase()).coupleId.field + "=" + item.getId());
////			try {
//				statement = getConnection().createStatement1();
//				rs = statement.executeQuery(myQuery.toString());
//				rs.next();
////			} catch (SQLException e1) {
////				// TODO Auto-generated catch block
////				e1.printStackTrace();
////			}
//			
//			
//			for (Entry<String, String> s : fields.entrySet()){
//				Field f = retrieveField(s.getKey(), item.getClass());
//				//lo rendo accessibile
//				f.setAccessible(true);
//				
//				
//				if (!List.class.isAssignableFrom(f.getType())){
//					if (!DTOBase.class.isAssignableFrom(f.getType())){
//							//valuta attributo atomico
//							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//		//								valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
//									break;
//								case "tipoazienda":
////									f.set(item, TipoAzienda.fromValue(rs2.getInt(s.getValue())));
//									break;
//								case "movimentazione":
////									f.set(item, Movimentazione.fromValue(rs2.getInt(s.getValue())));
//									break;
//								default:
//									break;
//								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//		//							valueList+= "'" + f.get(o) + "', ";
////									try {
//										f.set(item, rs.getString(s.getValue()));
////										rs.previous();
////									} catch (IllegalArgumentException | IllegalAccessException | SQLException e) {
////										// TODO Auto-generated catch block
////										e.printStackTrace();
////									}
//									break;
//								case "long":
//									break;
//								case "int":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(item, rs.getInt(s.getValue()));
//									break;
//								case "boolean":
//									f.set(item, rs.getBoolean(s.getValue()));
//									break;
//								case "float":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(item, rs.getFloat(s.getValue()));
//									break;
//								case "double":
//		//							valueList+= "" + f.get(o) + ", ";
//									f.set(item, rs.getDouble(s.getValue()));
//									break;
//								default:
//									break;
//								}
//							}
//						}
//						else{
//		//					//caricare i campi "filtrati" del sottotipo
//		//					//si tratta di un oggetto di cui devo ricavare solo l'ID
//							
//		//					for (String column : fields.values()){
//		//						columnList+= column + ", ";
//		//					}
//		//					columnList=columnList.substring(0,columnList.length()-2);
//							
//							
//	//						myQuery.setField(1, s.getValue());
//	//						myQuery.setTable(2, getTable(o));
//	//						myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.field + "=" + o.getId());
//							
////							try {
////	//							statement = getConnection().createStatement1();
////	//							ResultSet rs = statement.executeQuery(myQuery.toString());
////	//							rs.next();
////								
//								DTOBase subObject = memory2.get(f.getType()).get(rs.getLong(s.getValue()));
//								read(subObject, memory2);
//								
//								f.set(item, subObject);
////							} catch (SQLException e) {
////								// TODO Auto-generated catch block
////								e.printStackTrace();
////							} catch (IllegalArgumentException e) {
////								// TODO Auto-generated catch block
////								e.printStackTrace();
////							} catch (IllegalAccessException e) {
////								// TODO Auto-generated catch block
////								e.printStackTrace();
////							}
//							
//		//					try{
//		//					valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//		//					}
//		//					catch(NullPointerException e){
//		//						valueList+= " NULL , ";
//		//					}
//		////					HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
//		////					f.set(o, subElements.get(rs.getLong(column)));
//						}
//					
//			}
//			else{
//				ResultSet rs2=null;
//				//gestire gli array
//				@SuppressWarnings("unused")
//				StringBuilderQuery subQuery = new StringBuilderQuery(readQuery);
//				
//				ArrayList<DTOBase> lista = new ArrayList<>();// (ArrayList<DTOBase>) f.get(o);
//				
//	            Type type = f.getGenericType();
//
//	            if (type instanceof ParameterizedType) {
//
//	                ParameterizedType pType = (ParameterizedType)type;
//	                Type[] arr = pType.getActualTypeArguments();
//	                Class<?> innerClass = (Class<?>) arr[0];
//	                
//	                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//	                subQuery.setField(2, getTable(innerClass));
//	                
//	                String externalID = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//	                
//	                subQuery.setField(3, externalID + "=" + item.getId());
//	                
////	                try {
//	    			statement2 = getConnection().createStatement1();
//						rs2=statement2.executeQuery(subQuery.toString());
//						
//						
//						while (rs2.next()){
//							
////							DTOBase item = (DTOBase) innerClass.newInstance();
////							f.set(item, getSubElement(item, memory2));
//							
//							
//							DTOBase item2 = (DTOBase) innerClass.newInstance();
//										
//							for (String it: (getAllFields(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.field).split(", ")){
//								
//								//ricavo l'attributo sulla base del nome
//								Field f2 = retrieveField(it, innerClass);
//								
//								//lo rendo accessibile
//								f2.setAccessible(true);
//								
//								//e lo vado ad avvalorare
//								//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//								String column = DAO.getColumn(it, innerClass);
//								
//								if (!DTOBase.class.isAssignableFrom(f2.getType())){
////								if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//									//valuta attributo atomico
//									String atomicClassName = f2.getType().getSimpleName().toLowerCase();
////									String column = DAO.getColumn(it, myClass);
//									if (f.getType().isEnum()){
//										switch(atomicClassName){
//										case "stato":
//											f2.set(item2, Stato.fromValue(rs2.getInt(column)));
//											break;
//										case "tipoazienda":
//											f2.set(item2, TipoAzienda.fromValue(rs2.getInt(column)));
//											break;
//										case "movimentazione":
//											f2.set(item2, Movimentazione.fromValue(rs2.getInt(column)));
//											break;
//										default:
//											break;
//										}
//									}
//									else{
//										switch(atomicClassName){
//										case "string"1:
//											f2.set(item2, rs2.getString(column));
//											break;
//										case "long":
//											f2.set(item2, rs2.getLong(column));
//											break;
//										case "float":
//											f2.set(item2, rs2.getFloat(column));
//											break;
//										case "double":
//											f2.set(item2, rs2.getDouble(column));
//											break;
//										case "int":
//											f2.set(item2, rs2.getInt(column));
//											break;
//										case "boolean":
//											f2.set(item2, rs2.getBoolean(column));
//											break;
//										default:
//											break;
//										}
//									}
//								}
//								else{
//									//caricare i campi "filtrati" del sottotipo
//////									DTOBase subitem2 = loadSubMemory(f.getType())
////									HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////									f.set(item2, subElements.get(rs2.getLong(column)));
//////									f.set(item2, loadSubMemory(f.getType()));
//									
//									f2.set(item2, getSubElement(item2, memory2));
//									
//									
//									
//								}
//								
//							}
//							lista.add(item2);
////							addElement((DTOBase) item);
//						}
//						f.set(item, lista);
//						
//						
//						
////					} catch (SQLException | IllegalArgumentException | IllegalAccessException | InstantiationException e1) {
////						// TODO Auto-generated catch block
////						e1.printStackTrace();
////					}
//	                
//	                
//	                
//	                
//
//	                
////	                HashMap<String, String> externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).fieldList;
////	                
//////	                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
////	                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
////	                
////	                
////	                if (externalKey!=null){
////		        		for (DTOBase elem: lista){
////		        			
//////		        			subQueries.addAll(extractSubQueries(elem));
////		        			
////		        			HashMap lista2 = newSubQueries.get(o);
////	        				Object partial = extractCreateSubQueries(elem);
////	        				
//////	        				if (partial instanceof StringBuilderQuery){
//////	        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
//////	        				}
////		        			try{
//////			        			lista2.addAll(partial);
////			        			lista2.put(elem, partial);
//////			        			newSubQueries.put(o, lista2);
////		        			}
////		        			catch(Exception e){
////		        				lista2 = new HashMap<>();
////			        			lista2.put(elem, partial);
////			        			newSubQueries.put(o, lista2);
////		        			}
////		        			
////		        			
////		        			
////			        		
////			        		}
////		        		
////		        		
////		        		
////	                }else{
////	                	Entry<String, String> iter=entries.next();
////	                	
////	                	HashMap<String, String> trgt = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets;
////		                String key= iter.getKey();
////	                	while (!trgt.containsKey(key)){
////	                		iter=entries.next();
////	                		key= iter.getKey();
////	                	}
////	                	
////		                String value=iter.getValue();
////		        		for (DTOBase elem: lista){
////			        		subQuery.setTable(1, key);
////			        		
////			        		String subColumns = value + ", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////			        		subQuery.setField(2, subColumns);
////			        		
////			        		String subValues = "";
////			        			subValues += elem.getId() + ", ??";
////			        		
////			        		subQuery.setField(3, subValues);
////			        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(o);
////		        			try{
////		        				sbQuery.put(elem, subQuery);
////		        			}
////		        			catch(Exception e){
////		        				sbQuery = new HashMap<>();
////		        				sbQuery.put(elem, subQuery);
////			        			newSubQueries.put(o, sbQuery);
////		        			}
////			        		subQuery = new StringBuilderQuery(createQuery);
////			        		}
////	                }
//	                
//	            }
//				
//			}
//				
//				
//				
//				
//			}
//		}	
//		
//		
//		
//		
//		
////					//ricavare l'elenco degli attributi
////					String columnList="";
////					String valueList="";
////					
////					
////					
////					try {
////					
////					for (String it: DAO.getAllFields(o.getClass()).split(", ")){
////						//ricavo l'attributo sulla base del nome
////						Field f = retrieveField(it, o.getClass());
////						//lo rendo accessibile
////						f.setAccessible(true);
////	//					System.out.println();
////						
////						
////						if (!List.class.isAssignableFrom(f.getType())){
////							//e lo vado ad avvalorare
////							//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
////							String column = DAO.getColumn(it, o.getClass());
////							
////							columnList+=column + ", ";
////							
////	//					if (f.getType() instanceof ArrayList<?>){
////							if (!DTOBase.class.isAssignableFrom(f.getType())){
////	//							if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
////									//valuta attributo atomico
////									String atomicClassName = f.getType().getSimpleName().toLowerCase();
////	//								String column = DAO.getColumn(it, o.getClass());
////									if (f.getType().isEnum()){
////										switch(atomicClassName){
////										case "stato":
////												valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////	//										f.set(o, Stato.fromValue(rs.getInt(column)));
////											break;
////										default:
////											break;
////										}
////									}
////									else{
////										switch(atomicClassName){
////										case "string"1:
////											valueList+= "'" + f.get(o) + "', ";
////	//										f.set(o, rs.getString(column));
////											break;
////										case "long":
////	//										f.set(o, rs.getLong(column));
////											break;
////											valueList+= "" + f.get(o) + ", ";
////											break;
////										case "double":
////											valueList+= "" + f.get(o) + ", ";
////											break;
////										default:
////											break;
////										}
////									}
////								}
////								else{
////									//caricare i campi "filtrati" del sottotipo
////									//si tratta di un oggetto di cui devo ricavare solo l'ID
////									try{
////									valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
////									}
////									catch(NullPointerException e){
////										valueList+= " NULL , ";
////									}
////	//								HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////	//								f.set(o, subElements.get(rs.getLong(column)));
////								}
////						}
////						else{
////							//gestire gli array
////							@SuppressWarnings("unused")
////							StringBuilderQuery subQuery = new StringBuilderQuery(createQuery);
////							
////							ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(o);
////							
////				            Type type = f.getGenericType();
////	
////				            if (type instanceof ParameterizedType) {
////	
////				                ParameterizedType pType = (ParameterizedType)type;
////				                Type[] arr = pType.getActualTypeArguments();
////				                Class<?> innerClass = (Class<?>) arr[0];
////				                
////				                
////				                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
////				                
////	//			                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
////				                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
////				                
////				                
////	//			        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
////				        		
////				                
////				                if (externalKey!=null){
////					        		for (DTOBase elem: lista){
////					        			
////	//				        			subQueries.addAll(extractSubQueries(elem));
////					        			
////					        			HashMap lista2 = newSubQueries.get(o);
////				        				Object partial = extractReadSubQueries(elem);
////				        				
////				        				if (partial instanceof StringBuilderQuery){
////				        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
////				        				}
////	//					        		for (StringBuilderQuery subs : partial){
////	//										subs.replaceAll("__", externalKey);
////	//					        		}
////					        			try{
////	//					        			lista2.addAll(partial);
////						        			lista2.put(elem, partial);
////	//					        			newSubQueries.put(o, lista2);
////					        			}
////					        			catch(Exception e){
////					        				lista2 = new HashMap<>();
////						        			lista2.put(elem, partial);
////						        			newSubQueries.put(o, lista2);
////					        			}
////					        			
////					        			
////					        			
////	//				        			newSubQueries.put(elem, extractSubQueries(elem));
////					        			
////					        			
////	//					        		subQuery.setTable(1, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).tableName);
////	//
////	//					        		String subColumns = externalKey + ", ";// + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////	//					        		
////	//									for (String subIt: DAO.getAllFields(f.getType()).split(", ")){
////	//										
////	//									}
////						        		
////	//					        		subQuery.setField(2, subColumns);
////	//					        		
////	//					        		String subValues = "";
////	////					        		for (DTOBase elem: lista){
////	//					        			subValues += elem.getId() + ", ??";
////	////					        		subValues=subValues.substring(0, subValues.length()-4);
////	////					        		String subValues = o.getId() + ", ??";
////	////					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////	//					        		
////	//					        		subQuery.setField(3, subValues);
////	//					        		subQueries.add(subQuery);
////	//					        		subQuery = new StringBuilderQuery(createQuery);
////						        		}
////					        		
////					        		
////					        		
////	////				        		for (StringBuilderQuery subs : subQueries){
////	////									subs.replaceAll("__", externalKey);
////	////				        		}
////	//								for (Object subs : newSubQueries.values()){
////	//									if (subs instanceof StringBuilderQuery)
////	//										((StringBuilderQuery)subs).replaceAll("__", externalKey);
////	//								}
////					        		
////					        		
////				                	
////				                }else{
////				                	Entry<String, String> iter=entries.next();
////				                	
////				                	HashMap<String, String> trgt = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets;
////					                String key= iter.getKey();
////				                	while (!trgt.containsKey(key)){
////				                		iter=entries.next();
////				                		key= iter.getKey();
////				                	}
////				                	
////					                String value=iter.getValue();
////					        		for (DTOBase elem: lista){
////						        		subQuery.setTable(1, key);
////						        		
////						        		String subColumns = value + ", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////						        		subQuery.setField(2, subColumns);
////						        		
////						        		String subValues = "";
////	//					        		for (DTOBase elem: lista){
////						        			subValues += elem.getId() + ", ??";
////	//					        		subValues=subValues.substring(0, subValues.length()-4);
////	//					        		String subValues = o.getId() + ", ??";
////	//					        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////						        		
////						        		subQuery.setField(3, subValues);
////	////					        		subQueries.add(subQuery);
////	//					        		newSubQueries.put(subQuery, null);
////						        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(o);
////					        			try{
////	//					        			lista2.addAll(partial);
////					        				sbQuery.put(elem, subQuery);
////	//					        			newSubQueries.put(o, lista2);
////					        			}
////					        			catch(Exception e){
////					        				sbQuery = new HashMap<>();
////					        				sbQuery.put(elem, subQuery);
////						        			newSubQueries.put(o, sbQuery);
////					        			}
////						        		subQuery = new StringBuilderQuery(createQuery);
////						        		}
////				                }
////				                
////	//			        		System.out.println();
////	//			        		System.out.println();
////	//			        		System.out.println();
////				        		
////	//			        		if (column==null){
////	//			        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
////	//			        			if (column==null){
////	//			        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
////	//			        			}
////	//			        		}
////	////			                for (Type tp: arr) {
////	////			                    Class<?> clzz = (Class<?>)tp;
////	////			                    System.out.println(clzz.getName());
////	////			                }
////				            }
////							
////						}
////						
////					}
////					
////					columnList=columnList.substring(0,columnList.length()-2);
////	//				System.out.println();
////					valueList=valueList.substring(0,valueList.length()-2);
////					
////					
////					if (fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
////						columnList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
////						valueList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
////					}
////					
////					
////					
////					} catch (IllegalArgumentException | IllegalAccessException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////					
////					
////					
////					StringBuilderQuery myQuery=new StringBuilderQuery(createQuery);
////					
////					myQuery.setTable(1, getTable(o));
////	//				myQuery.setField(2, getColumns(o));
////	//				myQuery.setField(3, getValues(o));
////					myQuery.setField(2, columnList);
////					myQuery.setField(3, valueList);
////					
////					
////					
////					
////					try {
////						statement = getConnection().createStatement1();
////	//					statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
////						statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////						ResultSet rs = statement.getGeneratedKeys();
////						rs.next();
////						o.setId(rs.getLong(1));
////						
////	//					for (StringBuilderQuery subs : subQueries){
////	//						subs.replaceAll("??", o.getId());
////	//						statement.execute1Update(subs.toString());
////	//					}
////						
////						HashMap<DTOBase, StringBuilderQuery> firstPass = newSubQueries.get(o);
////						if (firstPass!=null){
////							newSubQueries.remove(o);
////							for (DTOBase subKey : firstPass.keySet()){
////								StringBuilderQuery subElementQuery = firstPass.get(subKey);
////								subElementQuery.replaceAll("??", o.getId());
////								
////								if (newSubQueries.containsKey(subKey)){
////									statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////									ResultSet rs2 = statement.getGeneratedKeys();
////									rs2.next();
////									subKey.setId(rs2.getLong(1));
////								}
////								else{
////									statement.execute1Update(subElementQuery.toString());
////								}
////								
////								
////							}
////						}
////						
////						
////						
////						for (DTOBase subs : newSubQueries.keySet()){
////							HashMap<DTOBase, StringBuilderQuery> subElement = newSubQueries.get(subs);
////							
////							for (DTOBase subKey : subElement.keySet()){
////								StringBuilderQuery subElementQuery = subElement.get(subKey);
////								subElementQuery.replaceAll("??", subs.getId());
////								
////								if (newSubQueries.containsKey(subKey)){
////									statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
////									ResultSet rs2 = statement.getGeneratedKeys();
////									rs2.next();
////									subKey.setId(rs2.getLong(1));
////								}
////								else{
////									statement.execute1Update(subElementQuery.toString());
////								}
////								
////								
////							}
////							
////							
////	//						if (subs instanceof StringBuilderQuery){
////	//							((StringBuilderQuery) subs).replaceAll("??", o.getId());
////	//							statement.execute1Update(subs.toString());
////	//						}
////						}
////						
////						
////						
////						
////	//					statement.execute1Update(o.getSubQuery());
////					} catch (SQLException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////					newSubQueries=new HashMap<>();
////		//			try{
////		//				statement = getConnection().createStatement1();
////		//				
////		//				StringBuilderQuery query = new StringBuilderQuery(createQuery);//"insert into ? (?) values (?);"
////		//				query.setTable(1, extractTable(o));
////		//				query.setTable(2, extractOnlyFields(o));
////		//				query.setTable(3, extractFieldValues(o));
////		//	//			query.setTable(1, getTable());
////		//	////			query.append(getTable());
////		//	//			query.setValue(2, getId());
////		//	////			query.append(getId());
////		//	//					
////		//	//			return query.toString();
////		//				
////		//				
////		//				
////		////				statement.execute1Update(getAllFields(o),Statement.RETURN_GENERATED_KEYS);
////		//				statement.execute1Update(query.toString(),Statement.RETURN_GENERATED_KEYS);
////		//				ResultSet rs = statement.getGeneratedKeys();
////		//				rs.next();
////		//				o.setId(rs.getLong(1));
////		//			}
////		//			catch (SQLException | NullPointerException e) {
////		//				e.printStackTrace();
////		//			} 
//		
//		
//		
//		
//		} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		return item;
//		
//				}
	//	private static ArrayList<StringBuilderQuery> extractSubQueries(DTOBase elem) {
//		private static Object extractReadSubQueries(DTOBase elem) {
//			//ricavare l'elenco degli attributi
//			String columnList="";
//			String valueList="";
//			Object subQueries=null;
//			try {
//			
//			for (String it: DAO.getAllFields(elem.getClass()).split(", ")){
//				//ricavo l'attributo sulla base del nome
//				Field f = retrieveField(it, elem.getClass());
//				//lo rendo accessibile
//				f.setAccessible(true);
//	//			System.out.println();
//				
//				
//				if (!List.class.isAssignableFrom(f.getType())){
//					//e lo vado ad avvalorare
//					//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//					
//					
//					String column = DAO.getColumn(it, elem.getClass());
//					
//					columnList+=column + ", ";
//					
//	//			if (f.getType() instanceof ArrayList<?>){
//					if (!DTOBase.class.isAssignableFrom(f.getType())){
//	//					if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//							//valuta attributo atomico
//							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//	//						String column = DAelem.getColumn(it, elem.getClass());
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//	//									valueList+= Stato.fromName((Stato) f.get(elem)) + ", ";
//										try{
//											valueList+= Stato.fromName((Stato) f.get(elem)) + ", ";
//										}
//										catch(NullPointerException e){
//											valueList+= Stato.fromName(Stato.Attivo) + ", ";
//										}
//	//								f.set(o, Statelem.fromValue(rs.getInt(column)));
//									break;
//								case "tipoazienda":
//									valueList+= TipoAzienda.fromName((TipoAzienda) f.get(elem)) + ", ";
//									break;
//								case "movimentazione":
//									valueList+= Movimentazione.fromName((Movimentazione) f.get(elem)) + ", ";
//									break;
//								default:
//									break;
//								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//									valueList+= "'" + f.get(elem) + "', ";
//	//								f.set(o, rs.getString(column));
//									break;
//								case "long":
//	//								f.set(o, rs.getLong(column));
//									break;
//								case "double":
//									valueList+= "" + f.get(elem) + ", ";
//									break;
//								default:
//									break;
//								}
//							}
//						}
//						else{
//							//caricare i campi "filtrati" del sottotipo
//							//si tratta di un oggetto di cui devo ricavare solo l'ID
//	//						valueList+= "" + ((DTOBase)f.get(elem)).getId() + ", ";
//							try{
//								valueList+= "" + ((DTOBase)f.get(elem)).getId() + ", ";
//							}
//							catch(NullPointerException e){
//								valueList+= " NULL , ";
//							}
//	//						HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
//	//						f.set(o, subElements.get(rs.getLong(column)));
//						}
//				}
//				else{
//					//gestire gli array
//					@SuppressWarnings("unused")
//					StringBuilderQuery subQuery = new StringBuilderQuery(createQuery);
//					
//					ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(elem);
//					
//		            Type type = f.getGenericType();
//	
//		            if (type instanceof ParameterizedType) {
//	
//		                ParameterizedType pType = (ParameterizedType)type;
//		                Type[] arr = pType.getActualTypeArguments();
//		                Class<?> innerClass = (Class<?>) arr[0];
//		                
//		                
//		                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//		                
//	//	                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
//		                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
//		                
//		                
//	//	        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
//		        		
//		                
//		                if (externalKey!=null){
//			        		for (DTOBase elem2: lista){
//			        			HashMap lista2 = newSubQueries.get(elem);
//		        				Object partial = extractReadSubQueries(elem2);
//		        				
//		        				if (partial instanceof StringBuilderQuery){
//		        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
//		        				}
//	//			        		for (StringBuilderQuery subs : partial){
//	//								subs.replaceAll("__", externalKey);
//	//			        		}
//			        			try{
//	//			        			lista2.addAll(partial);
//				        			lista2.put(elem2, partial);
//	//			        			newSubQueries.put(o, lista2);
//			        			}
//			        			catch(Exception e){
//			        				lista2 = new HashMap<>();
//				        			lista2.put(elem2, partial);
//				        			newSubQueries.put(elem, lista2);
//			        			}
//				        		
//	//			        		subQuery.setField(2, subColumns);
//	//			        		
//	//			        		String subValues = "";
//	////			        		for (DTOBase elem: lista){
//	//			        			subValues += elem.getId() + ", ??";
//	////			        		subValues=subValues.substring(0, subValues.length()-4);
//	////			        		String subValues = elem.getId() + ", ??";
//	////			        		fieldMapper.get(elem.getClass().getSimpleName().toLowerCase());
//	//			        		
//	//			        		subQuery.setField(3, subValues);
//	//			        		subQueries.add(subQuery);
//	//			        		subQuery = new StringBuilderQuery(createQuery);
//				        		}
//		                	
//		                }else{
//		                	Entry<String, String> iter=entries.next();
//		                	
//		                	HashMap<String, String> trgt = fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).targets;
//			                String key= iter.getKey();
//		                	while (!trgt.containsKey(key)){
//		                		iter=entries.next();
//		                		key= iter.getKey();
//		                	}
//		                	
//			                String value=iter.getValue();
//			        		for (DTOBase elem2: lista){
//				        		subQuery.setTable(1, key);
//				        		
//				        		String subColumns = value + ", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).targets.get(key);
//				        		subQuery.setField(2, subColumns);
//				        		
//				        		String subValues = "";
//	//			        		for (DTOBase elem: lista){
//				        			subValues += elem2.getId() + ", ??";
//	//			        		subValues=subValues.substring(0, subValues.length()-4);
//	//			        		String subValues = elem.getId() + ", ??";
//	//			        		fieldMapper.get(elem.getClass().getSimpleName().toLowerCase());
//				        		
//				        		subQuery.setField(3, subValues);
//				        		//TODO
//	//			        		subQueries.add(subQuery);
//				        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(elem);
//			        			try{
//	//			        			lista2.addAll(partial);
//			        				sbQuery.put(elem2, subQuery);
//	//			        			newSubQueries.put(o, lista2);
//			        			}
//			        			catch(Exception e){
//			        				sbQuery = new HashMap<>();
//			        				sbQuery.put(elem2, subQuery);
//				        			newSubQueries.put(elem, sbQuery);
//			        			}
//				        		subQuery = new StringBuilderQuery(createQuery);
//				        		}
//		                }
//		                
//	//	        		System.out.println();
//	//	        		System.out.println();
//	//	        		System.out.println();
//		        		
//	//	        		if (column==null){
//	//	        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
//	//	        			if (column==null){
//	//	        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
//	//	        			}
//	//	        		}
//	////	                for (Type tp: arr) {
//	////	                    Class<?> clzz = (Class<?>)tp;
//	////	                    System.out.println(clzz.getName());
//	////	                }
//		            }
//					
//				}
//				
//			}
//			
//			columnList+="__";
//			valueList+="??";
//			
//			
//			if (fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
//				columnList+=", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
//				valueList+=", " + fieldMapper.get(elem.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//			}
//			
//			
//			
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
//			StringBuilderQuery myQuery=new StringBuilderQuery(createQuery);
//			
//			myQuery.setTable(1, getTable(elem));
//	//		myQuery.setField(2, getColumns(o));
//	//		myQuery.setField(3, getValues(o));
//			myQuery.setField(2, columnList);
//			myQuery.setField(3, valueList);
//			subQueries=myQuery;
//			//TODO
//	//		subQueries.add(myQuery);
//			
//			
//	//		try {
//	//			statement = getConnection().createStatement1();
//	////			statement.execute1Update(elem.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//	//			statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//	//			ResultSet rs = statement.getGeneratedKeys();
//	//			rs.next();
//	//			elem.setId(rs.getLong(1));
//	//			
//	//			for (StringBuilderQuery subs : subQueries){
//	//				subs.replaceAll("??", elem.getId());
//	//				statement.execute1Update(subs.toString());
//	//			}
//	//			
//	////			statement.execute1Update(elem.getSubQuery());
//	//		} catch (SQLException e) {
//	//			// TODO Auto-generated catch block
//	//			e.printStackTrace();
//	//		}
//			
//			return subQueries;
//		}

		

		
		
		
		private static class Elements{
			HashMap<String, String> fields=new HashMap<>();
			HashMap<String, String> subs=new HashMap<>();
			HashMap<String, String> enums=new HashMap<>();
			ArrayList< String> lists=new ArrayList<>();
			
		}
//		@Deprecated
//		private static class Secondaries{
////			String table="";
//			Identifier id=null;
//			HashMap<Integer, Elements> elements = new HashMap<>();
//			
//		}
		private static class Discriminator{
			Integer value;
			String column;
		}
		private static class MToM{
			String destinationClass;
			String table;
			String column;
		}
		private static class Identifier{
			String field;
			String column;
		}
		private static class DTOMapper{
			
			String table;
			
			HashMap<Integer, Elements> elements = new HashMap<>();
			
			
//			HashMap<String, Secondaries> secondaries = new HashMap<>();
			
			Discriminator discriminator=null;
			
			String father;
			String refFather;
			
			ArrayList<MToM> manyToMany=null;
			
//			@Deprecated
			Identifier id=null;
			
//			HashMap<String, Identifier> subIdentifiers = new HashMap<>();
			
			
			
			@Override
			public String toString() {
				
				String result="";
				
				result= ""
									+ "Table ------------------> " + table + "";
				
				if (discriminator!=null) {
					result += "\n      Discriminator value ----> " + discriminator.value;
				}
				if (father!=null) {
					result += "\n      Father column ----------> " + father;
				}
				if (manyToMany!=null) {
					result += "\n      Relations\n      {";
					
					for (MToM el: manyToMany) {
						result += "\n        {";
						result += "\n          Table:  " + el.table;
						result += "\n          Column: " + el.column;
						
						result += "\n        }";
					}
					result += "\n      }";
				}
				
				Iterator<Entry<Integer, Elements>> iterator = elements.entrySet().iterator();
				
				while(iterator.hasNext()) {
					Entry<Integer, Elements> it = iterator.next();
					
					result += "\n      Priority: " + it.getKey();
					result += "\n      {";
					result += "\n        Enums";
					result += "\n        {";
					Elements e = it.getValue();
					
					Iterator<Entry<String, String>> iter = e.enums.entrySet().iterator();
					while (iter.hasNext()) {
						Entry<String, String> subIter = iter.next();
						result += "\n          {";
						result += "\n            Key:   " + subIter.getKey();
						result += "\n            Value: " + subIter.getValue();
						result += "\n          {";
					}
					result += "\n        }";
					result += "\n        Fields";
					result += "\n        {";
					iter = e.subs.entrySet().iterator();
					while (iter.hasNext()) {
						Entry<String, String> subIter = iter.next();
						result += "\n          {";
						result += "\n            Key:   " + subIter.getKey();
						result += "\n            Value: " + subIter.getValue();
						result += "\n          {";
					}
					result += "\n        }";
					result += "\n        Sub-Objects";
					result += "\n        {";
					iter = e.subs.entrySet().iterator();
					while (iter.hasNext()) {
						Entry<String, String> subIter = iter.next();
						result += "\n          {";
						result += "\n            Class: " + subIter.getKey();
						result += "\n            Value: " + subIter.getValue();
						result += "\n          {";
					}
					result += "\n        }";
					result += "\n        Lists";
					result += "\n        {";
					Iterator<String> iter2 = e.lists.iterator();
					while (iter2.hasNext()) {
						String subIter = iter2.next();
						result += "\n          {";
						result += "\n            Name: " + subIter;
						result += "\n          {";
					}
					result += "\n        }";

					result += "\n      }";
					
					
					
				}
				

				
				
//						+ "\n\nCommon fields:\n{\n";
				
				
				return result;
			}
			
			
			
		}
		private static class BaseMapper{
			
			String basePath;
			
//			@Deprecated
//			HashMap<String, String> commons = new HashMap<>();
			
			HashMap<String, DTOMapper> mapper = new HashMap<>();
			
			
			
			@Override
			public String toString() {
				
				String result;
				
				result= ""
						+ "BasePath ----> " + basePath + "";
//						+ "\n\nCommon fields:\n{\n";
//				
//				Iterator<Entry<String, String>> it = commons.entrySet().iterator();
//				
//				
//				while (it.hasNext()) {
//					Entry<String, String> element = it.next();
//					
//					result+= "  {\n    Key:   " + element.getKey() + ""
//						   + "\n    Value: " + element.getValue() + "\n  }\n";
//				}
//				
//				result+="}\n\n";
				Iterator<Entry<String, DTOMapper>> it2 = mapper.entrySet().iterator();
				
				result+="\n\nMapper:\n{\n";
				while (it2.hasNext()) {
					Entry<String, DTOMapper> element = it2.next();
					
					result+= "  {\n    Key:   " + element.getKey() + "";
					
					result+= "\n    Value:\n    {\n      " + element.getValue() + "\n    }\n  }\n";
//						   + "Value: " + element.getValue();
				}
				
				result+="}\n\n";
//				result+="}";
				
				
				return result;

			}
			
			
			
			
			
		}
		private static final HashMap<Class<?>, HashMap<Long, DTOBase>> daoMemory = new HashMap<>();
		public static HashMap<Long, DTOBase> retreiveMemory(Class<?> myClass) {
			
//			myClass=Cliente.class;
			HashMap<Long, DTOBase> partialMemory = daoMemory.get(myClass);
			
			if (partialMemory==null) {
				DTOBase swapElement =null;
				int priority;
				try {
					swapElement = (DTOBase) myClass.newInstance();
//					if (swapElement instanceof Layout)
//						System.out.print("");
					
					
					priority=swapElement.getPriority();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				
				partialMemory = new HashMap<>();
				daoMemory.put(myClass, partialMemory);
			
				StringBuilderQuery myQuery=new StringBuilderQuery(readAllQuery);
				
				myQuery.setField(1, mapperColumns(swapElement,null));
				myQuery.setField(2, mapperTable(swapElement));
//				myQuery.setTable(2, getTable(claz));
//				
				if (hasDiscriminator(swapElement)){
					myQuery.append(" where " + extractDiscriminator(swapElement));
				}
				ResultSet rs=executeQuery(myQuery.toString());
				
				
				try {
					while (rs.next()){
						DTOBase item = (DTOBase) myClass.newInstance();
						
						String fields=mapperEnums(item, null);
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperFields(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, myClass);
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							String myColumn = extractColumn(fieldName, item, null);
							
							//valuta attributo atomico
							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//							String column = DAO.getColumn(it, myClass);
//							if (f.getType().isEnum()){
								switch(atomicClassName){
								case "stato":
									f.set(item, Stato.fromValue(rs.getInt(myColumn)));
									break;
								case "tipoazienda":
									f.set(item, TipoAzienda.fromValue(rs.getInt(myColumn)));
//									value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
									break;
								case "movimentazione":
									f.set(item, Movimentazione.fromValue(rs.getInt(myColumn)));
//									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
									break;
								case "textalign":
									f.set(item, TextAlign.fromValue(rs.getInt(myColumn)));
//									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
									break;
								case "idcampo":
									f.set(item, IDCampo.fromValue(rs.getInt(myColumn)));
//									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
									break;
								default:
									break;
								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//									f.set(item, rs.getString(myColumn));
//									break;
//								case "long":
//									f.set(item, rs.getLong(myColumn));
//									break;
//								case "double":
//									f.set(item, rs.getDouble(myColumn));
//									break;
//								case "float":
//									f.set(item, rs.getFloat(myColumn));
//									break;
//								case "int":
//									f.set(item, rs.getInt(myColumn));
//									break;
//								case "boolean":
//									f.set(item, rs.getBoolean(myColumn));
//									break;
//								default:
//									break;
//								}
//							}
							
							
						}
						fields=mapperFields(item,null);
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperFields(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, myClass);
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							String myColumn = extractColumn(fieldName, item, null);
							
//							System.out.println();
							
							//valuta attributo atomico
							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//							String column = DAO.getColumn(it, myClass);
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//									f.set(item, Stato.fromValue(rs.getInt(myColumn)));
//									break;
//								case "tipoazienda":
//									f.set(item, TipoAzienda.fromValue(rs.getInt(myColumn)));
////									value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
//									break;
//								case "movimentazione":
//									f.set(item, Movimentazione.fromValue(rs.getInt(myColumn)));
////									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//									break;
//								default:
//									break;
//								}
//							}
//							else{
								switch(atomicClassName){
								case "string":
									String txt =rs.getString(myColumn);
									if (txt!=null) {
										txt=txt.replaceAll("\'", "'");
									}
									f.set(item, txt);
									break;
								case "long":
									f.set(item, rs.getLong(myColumn));
									break;
								case "double":
									f.set(item, rs.getDouble(myColumn));
									break;
								case "float":
									f.set(item, rs.getFloat(myColumn));
									break;
								case "int":
									f.set(item, rs.getInt(myColumn));
									break;
								case "boolean":
									f.set(item, rs.getBoolean(myColumn));
									break;
								default:
									break;
								}
//							}
							
							
						}
						
						
						if (item.getId()==46 && item instanceof Fornitore) {
							System.out.print("");
						}
						
						fields=mapperSubs(item,null);
						if (item instanceof Documento)
							System.out.print("");
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperSubs(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, myClass);
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							String myColumn = extractColumn(fieldName, item, null);
							
							
//							long idElem = rs.getLong(myColumn);
//							if (idElem>0) {
//								StringBuilderQuery subQuery=new StringBuilderQuery(readQuery);
//								subQuery.setField(1, mapperColumns((DTOBase) f.getType().newInstance()));
//								subQuery.setField(2, mapperTable((DTOBase) f.getType().newInstance()));
//								
//								subQuery.setField(3, "id = " + idElem);
//							}
//							long idObj = rs.getLong(myColumn);
							DTOBase subElement = null;
//							if (idObj!=0) {
								 subElement = retreiveSubMemory(f.getType(),null,null).get(rs.getLong(myColumn));
//								 if (subElement==null) {
//									 subElement	 =new DTOBase();
//									 subElement.setId(rs.getLong(myColumn));
//									 partialMemory.put(idObj, (DTOBase) subElement);
//								 }
//							}
							
							if (subElement instanceof Strada) {
								System.out.print("");
							}
							
							f.set(item, subElement);
						
							
						}
						fields=mapperLists(item,null);
//						if (item instanceof Cliente) {
//							if (fields.contains("riferimenti"))
//							System.out.print("");
//						}
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperSubs(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, myClass);
							
							//lo rendo accessibile
							f.setAccessible(true);
							
//							if (fieldName.equals("riferimenti") && item instanceof Cliente) {
//								System.out.println(fieldName);
//							}
							
							StringBuilderQuery mySubQuery=new StringBuilderQuery(readQuery);
							
							Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
							DTOBase swapSubElement = (DTOBase) type.newInstance();
							
							MToM[] relation = getManyToMany(swapSubElement, item);
							
							if (item.getId()==60 && (item instanceof Cliente))
							System.out.print("");
							
							if (relation!=null) {
//								gestire le liste con i many to many
								mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
								mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
								mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + item.getId());
							}
							else {
//								mySubQuery.setField(1, mapperColumns(swapSubElement,null) + mapperFatherReference(swapSubElement));
								mySubQuery.setField(1, mapperColumns(swapSubElement,null));
								mySubQuery.setField(2, mapperTable(swapSubElement));
								
								
								
								mySubQuery.setField(3, mapperFather(swapSubElement));
								mySubQuery.append("=" +item.getId());
							}
//							if (item.getId()==1600 && item instanceof Cliente) {
//								System.out.print("");
//							}
							if (mapperFatherReference(swapSubElement).length()>0) {
								f.set(item, extractList(type,executeQuery(mySubQuery.toString()), item));
							}
							else {
								f.set(item, extractList(type,executeQuery(mySubQuery.toString()), null));
							}
							
							
							
							
							
							
							
//							System.out.println(type);
							
//							String myColumn = extractColumn(fieldName, item);
//							
//							DTOBase subElement = retreiveSubMemory(f.getType()).get(rs.getLong(myColumn));
//							
//							f.set(item, subElement);
						
							
						}
						
						
						
						
						
						//lettura degli elementi nelle tabelle secondarie
						
//						String secondaryTables=secondaryTables(item);
//						
//						if (secondaryTables.length()>0) {
//							for (String secondaryTable: secondaryTables.split(", ")) {
//								
//								myQuery=new StringBuilderQuery(readQuery);
//								
//								myQuery.setField(1, mapperColumns(swapElement,secondaryTable));
//								myQuery.setField(2, secondaryTable);
//								myQuery.setField(3, "id=" + item.getId());
//								
//								
//								ResultSet rs2=executeQuery(myQuery.toString());
//								rs2.next();
//								
//							fields=mapperEnums(item,secondaryTable);
//							if (fields.length()>0)
//							for (String fieldName: fields.split(", ")) {
////							for (String fieldName: mapperFields(swapElement).split(", ")) {
//								//ricavo l'attributo sulla base del nome
//								Field f = retrieveField(fieldName, myClass);
//								
//								//lo rendo accessibile
//								f.setAccessible(true);
//								
//								String myColumn = extractColumn(fieldName, item,secondaryTable);
//								
//								//valuta attributo atomico
//								String atomicClassName = f.getType().getSimpleName().toLowerCase();
////								String column = DAO.getColumn(it, myClass);
////								if (f.getType().isEnum()){
//									switch(atomicClassName){
//									case "stato":
//										f.set(item, Stato.fromValue(rs2.getInt(myColumn)));
//										break;
//									case "tipoazienda":
//										f.set(item, TipoAzienda.fromValue(rs2.getInt(myColumn)));
////										value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
//										break;
//									case "movimentazione":
//										f.set(item, Movimentazione.fromValue(rs2.getInt(myColumn)));
////										value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//										break;
//									default:
//										break;
//									}
//								
//							}
//							fields=mapperFields(item, secondaryTable);
//							if (fields.length()>0)
//							for (String fieldName: fields.split(", ")) {
////							for (String fieldName: mapperFields(swapElement).split(", ")) {
//								//ricavo l'attributo sulla base del nome
//								Field f = retrieveField(fieldName, myClass);
//								
//								//lo rendo accessibile
//								f.setAccessible(true);
//								
//								String myColumn = extractColumn(fieldName, item,secondaryTable);
//								
//								//valuta attributo atomico
//								String atomicClassName = f.getType().getSimpleName().toLowerCase();
//									switch(atomicClassName){
//									case "string"1:
//										f.set(item, rs2.getString(myColumn));
//										break;
//									case "long":
//										f.set(item, rs2.getLong(myColumn));
//										break;
//									case "double":
//										f.set(item, rs2.getDouble(myColumn));
//										break;
//									case "float":
//										f.set(item, rs2.getFloat(myColumn));
//										break;
//									case "int":
//										f.set(item, rs2.getInt(myColumn));
//										break;
//									case "boolean":
//										f.set(item, rs2.getBoolean(myColumn));
//										break;
//									default:
//										break;
//									}
////								}
//								
//								
//							}
//							fields=mapperSubs(item, secondaryTable);
//							if (fields.length()>0)
//							for (String fieldName: fields.split(", ")) {
////							for (String fieldName: mapperSubs(swapElement).split(", ")) {
//								//ricavo l'attributo sulla base del nome
//								Field f = retrieveField(fieldName, myClass);
//								
//								//lo rendo accessibile
//								f.setAccessible(true);
//								
//								String myColumn = extractColumn(fieldName, item,secondaryTable);
//								
//								
////								long idElem = rs2.getLong(myColumn);
////								if (idElem>0) {
////									StringBuilderQuery subQuery=new StringBuilderQuery(readQuery);
////									subQuery.setField(1, mapperColumns((DTOBase) f.getType().newInstance()));
////									subQuery.setField(2, mapperTable((DTOBase) f.getType().newInstance()));
////									
////									subQuery.setField(3, "id = " + idElem);
////								}
//								
//								
//								
//								DTOBase subElement = retreiveSubMemory(f.getType(), item,secondaryTable).get(rs2.getLong(myColumn));
//								
//								f.set(item, subElement);
//							
//								
//							}
//							fields=mapperLists(item, secondaryTable);
//							if (fields.length()>0)
//							for (String fieldName: fields.split(", ")) {
////							for (String fieldName: mapperSubs(swapElement).split(", ")) {
//								//ricavo l'attributo sulla base del nome
//								Field f = retrieveField(fieldName, myClass);
//								
//								//lo rendo accessibile
//								f.setAccessible(true);
//								
//								
//								StringBuilderQuery mySubQuery=new StringBuilderQuery(readQuery);
//								
//								Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
//								DTOBase swapSubElement = (DTOBase) type.newInstance();
//								
//								MToM[] relation = getManyToMany(swapSubElement, item);
//								
//								
//								
//								if (relation!=null) {
////									gestire le liste con i many to many
//									mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
//									mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
//									mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + item.getId());
//								}
//								else {
//									mySubQuery.setField(1, mapperColumns(swapSubElement,null));
//									mySubQuery.setField(2, mapperTable(swapSubElement));
//									mySubQuery.setField(3, mapperFather(swapSubElement));
//									mySubQuery.append("=" +item.getId());
//								}
//								
//								
//								
//								
//								f.set(item, extractList(type,executeQuery(mySubQuery.toString())));
//								
//								
//								
//								
//								
////								System.out.println(type);
//								
////								String myColumn = extractColumn(fieldName, item);
////								
////								DTOBase subElement = retreiveSubMemory(f.getType()).get(rs.getLong(myColumn));
////								
////								f.set(item, subElement);
//							
//								
//							}
//						}
					
						
						
						
						
//						}
						item.incPriority();
						
						partialMemory.put(item.getId(), item);
					}
				} catch (SQLException | InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				
				
//				
//				return rs;
//				
//				
//				myMapper.
				
				
				
//				daoMemory.put(myClass, partialMemory);
			}
			
			
			
			return partialMemory;
		}
		
//		private static String secondaryTables(DTOBase item) {
//			String className = item.getClass().getSimpleName().toLowerCase();
//			
//			
//			DTOMapper classMapper = myMapper.mapper.get(className);
//			
//			String fields = "";
//			
//			if (item.getPriority()<classMapper.elements.size()) {
//				
//			for (String s: classMapper.secondaries.keySet())
//				fields += s + ", ";
//			}
//			if (fields.length()>0)
//			fields = fields.substring(0, fields.length()-2);
//			
//			
//			return fields;
//		}

		private static String extractDiscriminator(DTOBase swapElement) {
			return (myMapper.mapper.get(swapElement.getClass().getSimpleName().toLowerCase()).discriminator.column + "=" + myMapper.mapper.get(swapElement.getClass().getSimpleName().toLowerCase()).discriminator.value);
		}
		private static String extractDiscriminatorColumn(DTOBase swapElement) {
			return (myMapper.mapper.get(swapElement.getClass().getSimpleName().toLowerCase()).discriminator.column);
		}
		private static Integer extractDiscriminatorValue(DTOBase swapElement) {
			return (myMapper.mapper.get(swapElement.getClass().getSimpleName().toLowerCase()).discriminator.value);
		}
		private static boolean hasDiscriminator(DTOBase swapElement) {
			
			
			return (myMapper.mapper.get(swapElement.getClass().getSimpleName().toLowerCase()).discriminator!=null);
		}
		private static MToM[] getManyToMany(DTOBase swapElement, DTOBase item) {
			
//			boolean hasRelation = false;
			MToM[] fatherRelation=null;
			
			String subElementName=swapElement.getClass().getSimpleName().toLowerCase();
			String fatherElementName=item.getClass().getSimpleName().toLowerCase();
			
			
			ArrayList<MToM> subElementList=myMapper.mapper.get(subElementName).manyToMany;
			ArrayList<MToM> fatherElementList=myMapper.mapper.get(fatherElementName).manyToMany;
			
			if (subElementList!=null && fatherElementList!=null) {
				//una volta appurato che entrambi non sono nulli, passo al confronto di tutti gli elementi
				
				
				Iterator<MToM> iter = subElementList.iterator();
				Iterator<MToM> subIter = null;
				
				while (iter.hasNext() && fatherRelation==null) {
					MToM sub = iter.next();
					
					subIter = fatherElementList.iterator();
					while (subIter.hasNext() && fatherRelation==null) {
						MToM sub2 = subIter.next();
						
						if (sub.table.equals(sub2.table)) {
//							hasRelation=true;
//							fatherRelation = sub2;
							
							fatherRelation = new MToM[2];
							fatherRelation[0]=sub2;
							fatherRelation[1]=sub;
						}
						
						
					}
				}
				
				
			}
			
//			System.out.println();
			
			
//			return (myMapper.mapper.get(swapElement.getClass().getSimpleName().toLowerCase()).manyToMany!=null);
			return fatherRelation;
		}
		
		
		
		private static Object extractList(Class<?> type, ResultSet rs, DTOBase item2) {
			
//			myClass=Cliente.class;
			HashMap<Long, DTOBase> partialHashMapMemory = daoMemory.get(type);
			ArrayList<DTOBase> partialMemory = new ArrayList<>();
			boolean read=false;
			
				DTOBase swapElement =null;
				int priority;
				try {
					swapElement = (DTOBase) type.newInstance();
					priority=swapElement.getPriority();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				
//				partialMemory = new HashMap<>();
				
//				StringBuilderQuery myQuery=new StringBuilderQuery(readAllQuery);
//				
//				myQuery.setField(1, mapperColumns(swapElement));
//				myQuery.setField(2, mapperTable(swapElement));
////				myQuery.setTable(2, getTable(claz));
////				
////				if (hasDiscriminator(claz)){
////					myQuery.append(" where " + getDiscriminatorColumn(claz) + " = " + getDiscriminatorValue(claz));
////				}
//				ResultSet rs=executeQuery(myQuery.toString());
//				
				
				try {
					while (rs.next()){
						DTOBase item = (DTOBase) type.newInstance();
						
						String fields=mapperEnums(item,null);
//						fields=mapperColumns(o);
						if (fields.length()>0) {
							read=true;
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperFields(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, item.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
//							if (!identifier(fieldName,o)) {
								String myColumn = extractColumn(fieldName, item, null);
								
								//valuta attributo atomico
								String atomicClassName = f.getType().getSimpleName().toLowerCase();
//								String column = DAO.getColumn(it, myClass);
//								if (f.getType().isEnum()){
									switch(atomicClassName){
									case "stato":
											f.set(item, Stato.fromValue(rs.getInt(myColumn)));
										break;
									case "tipoazienda":
										f.set(item, TipoAzienda.fromValue(rs.getInt(myColumn)));
//										value += "" + TipoAzienda.fromName((TipoAzienda) field.get(item)) + "";					
										break;
									case "movimentazione":
										f.set(item, Movimentazione.fromValue(rs.getInt(myColumn)));
//										value += "" + Movimentazione.fromName((Movimentazione) field.get(item)) + "";					
										break;
									case "textalign":
										f.set(item, TextAlign.fromValue(rs.getInt(myColumn)));
//										value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
										break;
									case "idcampo":
										f.set(item, IDCampo.fromValue(rs.getInt(myColumn)));
//										value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
										break;
									default:
										break;
									}
//								}
//								else{
//									switch(atomicClassName){
//									case "string"1:
//										f.set(o, rs.getString(myColumn));
//										break;
//									case "long":
//										f.set(o, rs.getLong(myColumn));
//										break;
//									case "double":
//										f.set(o, rs.getDouble(myColumn));
//										break;
//									case "float":
//										f.set(o, rs.getFloat(myColumn));
//										break;
//									case "int":
//										f.set(o, rs.getInt(myColumn));
//										break;
//									case "boolean":
//										f.set(o, rs.getBoolean(myColumn));
//										break;
//									default:
//										break;
//									}
//								}
//							}
							
							
						}
						}
						fields=mapperFields(item,null);
//						fields=mapperColumns(o);
						if (fields.length()>0) {
							read=true;
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperFields(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, item.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
//							if (!identifier(fieldName,item)) {
								String myColumn = extractColumn(fieldName, item, null);
								
								//valuta attributo atomico
								String atomicClassName = f.getType().getSimpleName().toLowerCase();
//								String column = DAO.getColumn(it, myClass);
//								if (f.getType().isEnum()){
//									switch(atomicClassName){
//									case "stato":
//											f.set(o, Stato.fromValue(rs.getInt(myColumn)));
//										break;
//									case "tipoazienda":
//										f.set(o, TipoAzienda.fromValue(rs.getInt(myColumn)));
////										value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
//										break;
//									case "movimentazione":
//										f.set(o, Movimentazione.fromValue(rs.getInt(myColumn)));
////										value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//										break;
//									default:
//										break;
//									}
//								}
//								else{
									switch(atomicClassName){
									case "string":
										String txt =rs.getString(myColumn);
										if (txt!=null) {
											txt=txt.replaceAll("\'", "'");
										}
										f.set(item, txt);
										break;
									case "long":
										f.set(item, rs.getLong(myColumn));
										break;
									case "double":
										f.set(item, rs.getDouble(myColumn));
										break;
									case "float":
										f.set(item, rs.getFloat(myColumn));
										break;
									case "int":
										f.set(item, rs.getInt(myColumn));
										break;
									case "boolean":
										f.set(item, rs.getBoolean(myColumn));
										break;
									default:
										break;
									}
//								}
							}
							
							
//						}
						}
//						String fields=mapperFields(item,null);
//						if (fields.length()>0)
//						for (String fieldName: fields.split(", ")) {
////						for (String fieldName: mapperFields(swapElement).split(", ")) {
//							//ricavo l'attributo sulla base del nome
//							Field f = retrieveField(fieldName, type);
//							
//							//lo rendo accessibile
//							f.setAccessible(true);
//							
//							String myColumn = extractColumn(fieldName, item);
//							
//							//valuta attributo atomico
//							String atomicClassName = f.getType().getSimpleName().toLowerCase();
////							String column = DAO.getColumn(it, myClass);
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//									f.set(item, Stato.fromValue(rs.getInt(myColumn)));
//									break;
//								default:
//									break;
//								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//									f.set(item, rs.getString(myColumn));
//									break;
//								case "long":
//									f.set(item, rs.getLong(myColumn));
//									break;
//								case "double":
//									f.set(item, rs.getDouble(myColumn));
//									break;
//								case "float":
//									f.set(item, rs.getFloat(myColumn));
//									break;
//								case "int":
//									f.set(item, rs.getInt(myColumn));
//									break;
//								default:
//									break;
//								}
//							}
//							
//							
//						}
						fields=mapperSubs(item,null);
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperSubs(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, type);
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							String myColumn = extractColumn(fieldName, item, null);
							
							
//							long idElem = rs.getLong(myColumn);
//							if (idElem>0) {
//								StringBuilderQuery subQuery=new StringBuilderQuery(readQuery);
//								subQuery.setField(1, mapperColumns((DTOBase) f.getType().newInstance()));
//								subQuery.setField(2, mapperTable((DTOBase) f.getType().newInstance()));
//								
//								subQuery.setField(3, "id = " + idElem);
//							}
							
//							if (item instanceof Azienda)
//								System.out.print("");
							
							DTOBase subElement;
							if (!Modifier.isAbstract(f.getType().getModifiers())) {
								subElement = retreiveSubMemory(f.getType(),null,null).get(rs.getLong(myColumn));
								f.set(item, subElement);
							}
							else {
////								subElement=null;
								subElement=findSubObject(f.getType(), rs.getLong(myColumn));
								if (subElement!=null) {
									f.set(item, subElement);
								}
								else {
									f.set(item, item2);
								}
							}
							
//							f.set(item, subElement);
						
							
						}
						
//						if (item2!=null) {
////							System.out.print("");
////							mapperFatherReference(item);
//							Field f2 = retrieveField(mapperFatherReference(item), type);
//							f2.setAccessible(true);
//							f2.set(item, item2);
//						}
						
						
//						fields=mapperLists(item,null);
						fields=allMapperLists(item);
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperSubs(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							if ((fieldName.equals("indirizzi") ||fieldName.equals("cellulare")) &&item.getId()==2831) {
								System.out.print("");
							}
							Field f = retrieveField(fieldName, type);
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							
							StringBuilderQuery mySubQuery=new StringBuilderQuery(readQuery);
							
							Class<?> subType = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
							DTOBase swapSubElement = (DTOBase) subType.newInstance();
							
//							mySubQuery.setField(1, mapperColumns(swapSubElement));
//							mySubQuery.setField(2, mapperTable(swapSubElement));
//							mySubQuery.setField(3, mapperFather(swapSubElement));
//							mySubQuery.append("=" +item.getId());
//							
							
							
							
							
							
							
							MToM[] relation = getManyToMany(swapSubElement, item);
							
							
							
							if (relation!=null) {
//								gestire le liste con i many to many
								mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
								mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
								mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + item.getId());
							}
							else {
								mySubQuery.setField(1, mapperColumns(swapSubElement,null));
								mySubQuery.setField(2, mapperTable(swapSubElement));
								mySubQuery.setField(3, mapperFather(swapSubElement));
								mySubQuery.append("=" +item.getId());
							}
							
							
							
							
							f.set(item, extractList(subType,executeQuery(mySubQuery.toString()),null));
							
							
							
							
							
//							System.out.println(type);
							
//							String myColumn = extractColumn(fieldName, item);
//							
//							DTOBase subElement = retreiveSubMemory(f.getType()).get(rs.getLong(myColumn));
//							
//							f.set(item, subElement);
						
							
						}
						if (read==true) {
							item.incPriority();
							partialMemory.add(item);
//							daoMemory.get(o.getClass()).put(o.getId(), o);
						}
//						item.incPriority();
						
						
						
						
//						partialMemory.put(item.getId(), item);
					}
				} catch (SQLException | InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
			if (partialHashMapMemory!=null) {
				System.out.print("");
				
				if (partialMemory.size()>0) {
//					ArrayList<DTOBase> swapArray = new ArrayList<>();
					for(DTOBase dto : partialMemory) {
						DTOBase innerDto = partialHashMapMemory.get(dto.getId());
//						swapArray.add(partialHashMapMemory.get(dto.getId()));
						partialMemory.set(partialMemory.indexOf(innerDto), innerDto);
//						swapArray.add(innerDto);
						System.out.print("");
						
						
					}
//					partialMemory=swapArray;
				}
				
			}
				
				
//				
//				return rs;
//				
//				
//				myMapper.
				
				
				
//				daoMemory.put(myClass, partialMemory);
//			}
			
			
			
			return partialMemory;

		}
//		@Deprecated
		private static DTOBase findSubObject(Class<?> class1, long long1) {
			// TODO Auto-generated method stub
			DTOBase findfoundObject=null;
			
			Iterator<Entry<Class<?>, HashMap<Long, DTOBase>>> map = daoMemory.entrySet().iterator();
			
			while (findfoundObject==null && map.hasNext()) {
				Entry<Class<?>, HashMap<Long, DTOBase>> subMap = map.next();
				
				DTOBase swapElement = subMap.getValue().get(long1);
//				if (swapElement instanceof Azienda)
//					System.out.print("");
				if (swapElement!=null && class1.isAssignableFrom(swapElement.getClass())) {
//					System.out.print("");
					findfoundObject=swapElement;
				}
//				if (swapElement.getClass(). class1) {
//					
//				}
				
				
			}
			
			return findfoundObject;
			
		}

		public static HashMap<Long, DTOBase> retreiveSubMemory(Class<?> myClass, DTOBase item2, String secondaryTable) {
			
//			myClass=TipoDocumento.class;
			HashMap<Long, DTOBase> partialMemory = daoMemory.get(myClass);
			
			
			
			
			if (secondaryTable!=null) {
				
//				System.out.print("");
				DTOBase swapElement =null;
				try {
					
//					if (myClass.getSimpleName().toLowerCase().equals("azienda")) {
////					if (Modifier.isAbstract(myClass.getModifiers())) {
//						System.out.print("");
//					}					
//					else {
						swapElement = (DTOBase) myClass.newInstance();
//					}

					
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				partialMemory = new HashMap<>();
//				daoMemory.put(myClass, partialMemory);
				StringBuilderQuery myQuery=new StringBuilderQuery(readAllQuery);
				
				myQuery.setField(1, mapperColumns(item2,secondaryTable));
				myQuery.setField(2, secondaryTable);
				myQuery.append(" where id=" + item2.getId());
				
				
				
				ResultSet rs=executeQuery(myQuery.toString());
				
				
				
				try {
					while (rs.next()){
						DTOBase item = (DTOBase) myClass.newInstance();
						
						String fields=mapperEnums(item2,secondaryTable);
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperFields(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, item2.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							String myColumn = extractColumn(fieldName, item2, secondaryTable);
							
							//valuta attributo atomico
							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//							String column = DAO.getColumn(it, myClass);
//							if (f.getType().isEnum()){
								switch(atomicClassName){
								case "stato":
									f.set(item, Stato.fromValue(rs.getInt(myColumn)));
									break;
								case "tipoazienda":
									f.set(item, TipoAzienda.fromValue(rs.getInt(myColumn)));
//									value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
									break;
								case "movimentazione":
									f.set(item, Movimentazione.fromValue(rs.getInt(myColumn)));
//									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
									break;
								case "textalign":
									f.set(item, TextAlign.fromValue(rs.getInt(myColumn)));
//									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
									break;
								case "idcampo":
									f.set(item, IDCampo.fromValue(rs.getInt(myColumn)));
//									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
									break;
								default:
									break;
								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//									f.set(item, rs.getString(myColumn));
//									break;
//								case "long":
//									f.set(item, rs.getLong(myColumn));
//									break;
//								case "double":
//									f.set(item, rs.getDouble(myColumn));
//									break;
//								case "float":
//									f.set(item, rs.getFloat(myColumn));
//									break;
//								case "int":
//									f.set(item, rs.getInt(myColumn));
//									break;
//								case "boolean":
//									f.set(item, rs.getBoolean(myColumn));
//									break;
//								default:
//									break;
//								}
//							}
							
							
						}
						fields=mapperFields(item2,secondaryTable);
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperFields(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, item2.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							String myColumn = extractColumn(fieldName, item2, secondaryTable);
							
							
							System.out.print("");
							//valuta attributo atomico
							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//							String column = DAO.getColumn(it, myClass);
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//									f.set(item, Stato.fromValue(rs.getInt(myColumn)));
//									break;
//								case "tipoazienda":
//									f.set(item, TipoAzienda.fromValue(rs.getInt(myColumn)));
////									value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
//									break;
//								case "movimentazione":
//									f.set(item, Movimentazione.fromValue(rs.getInt(myColumn)));
////									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//									break;
//								default:
//									break;
//								}
//							}
//							else{
								switch(atomicClassName){
								case "string":
									String txt =rs.getString(myColumn);
									if (txt!=null) {
										txt=txt.replaceAll("\'", "'");
									}
									f.set(item, txt);
									break;
								case "long":
									f.set(item, rs.getLong(myColumn));
									break;
								case "double":
									f.set(item, rs.getDouble(myColumn));
									break;
								case "float":
									f.set(item, rs.getFloat(myColumn));
									break;
								case "int":
									f.set(item, rs.getInt(myColumn));
									break;
								case "boolean":
									f.set(item, rs.getBoolean(myColumn));
									break;
								default:
									break;
								}
//							}
							
							
						}
						fields=mapperSubs(item2,secondaryTable);
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperSubs(item,null).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, item2.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							String myColumn = extractColumn(fieldName, item2, secondaryTable);
							
//							DTOBase subElement = (DTOBase) f.getType().newInstance();
							DTOBase subElement = retreiveSubMemory(f.getType(),null,null).get(rs.getLong(myColumn));
							
							f.set(item, subElement);
							
//							//valuta attributo atomico
//							String atomicClassName = f.getType().getSimpleName().toLowerCase();
////							String column = DAO.getColumn(it, myClass);
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//									f.set(item, Stato.fromValue(rs.getInt(myColumn)));
//									break;
//								default:
//									break;
//								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//									f.set(item, rs.getString(myColumn));
//									break;
//								case "long":
//									f.set(item, rs.getLong(myColumn));
//									break;
//								case "double":
//									f.set(item, rs.getDouble(myColumn));
//									break;
//								case "float":
//									f.set(item, rs.getFloat(myColumn));
//									break;
//								case "int":
//									f.set(item, rs.getInt(myColumn));
//									break;
//								default:
//									break;
//								}
//							}
							
							
						}
						fields=mapperLists(item2,secondaryTable);
						if (fields.length()>0)
						for (String fieldName: fields.split(", ")) {
//						for (String fieldName: mapperSubs(swapElement).split(", ")) {
							//ricavo l'attributo sulla base del nome
							Field f = retrieveField(fieldName, item2.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							
							StringBuilderQuery mySubQuery=new StringBuilderQuery(readQuery);
							
							Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
							DTOBase swapSubElement = (DTOBase) type.newInstance();
							
							mySubQuery.setField(1, mapperColumns(swapSubElement,null));
							mySubQuery.setField(2, mapperTable(swapSubElement));
							mySubQuery.setField(3, mapperFather(swapSubElement));
							mySubQuery.append("=" +item.getId());
							
							
							f.set(item, extractList(type,executeQuery(mySubQuery.toString()),null));
							
							
							
							
							
//							System.out.println(type);
							
//							String myColumn = extractColumn(fieldName, item);
//							
//							DTOBase subElement = retreiveSubMemory(f.getType()).get(rs.getLong(myColumn));
//							
//							f.set(item, subElement);
						
							
						}
						item.incPriority();
						
						
						
						
						partialMemory.put(item.getId(), item);
					}
				} catch (SQLException | InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				
				
				
			}
			else {
				
				
				
//				while (item2.getPriority()<myMapper.mapper.get(item2.getClass().getSimpleName().toLowerCase()).elements.size()) {
//					
//				}
				
				if (partialMemory==null) {
					DTOBase swapElement =null;
					int priority;
					try {
						swapElement = (DTOBase) myClass.newInstance();
						priority=swapElement.getPriority();
					} catch (InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						RCMException.showException(e);
					}
					
					partialMemory = new HashMap<>();
					
					StringBuilderQuery myQuery=new StringBuilderQuery(readAllQuery);
					
					myQuery.setField(1, mapperColumns(swapElement,null));
					myQuery.setField(2, mapperTable(swapElement));
//					myQuery.setTable(2, getTable(claz));
//					
//					if (hasDiscriminator(claz)){
//						myQuery.append(" where " + getDiscriminatorColumn(claz) + " = " + getDiscriminatorValue(claz));
//					}
					ResultSet rs=executeQuery(myQuery.toString());
//					if (swapElement instanceof TipoDocumento) {
//					System.out.print("");	
//					}

					
					try {
						while (rs.next()){
							DTOBase item = (DTOBase) myClass.newInstance();
							
							String fields=mapperEnums(item,null);
							if (fields.length()>0)
							for (String fieldName: fields.split(", ")) {
//							for (String fieldName: mapperFields(swapElement).split(", ")) {
								//ricavo l'attributo sulla base del nome
								Field f = retrieveField(fieldName, myClass);
								
								//lo rendo accessibile
								f.setAccessible(true);
								
								String myColumn = extractColumn(fieldName, item, null);
								
								//valuta attributo atomico
								String atomicClassName = f.getType().getSimpleName().toLowerCase();
//								String column = DAO.getColumn(it, myClass);
//								if (f.getType().isEnum()){
									switch(atomicClassName){
									case "stato":
										f.set(item, Stato.fromValue(rs.getInt(myColumn)));
										break;
									case "tipoazienda":
										f.set(item, TipoAzienda.fromValue(rs.getInt(myColumn)));
//										value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
										break;
									case "movimentazione":
										f.set(item, Movimentazione.fromValue(rs.getInt(myColumn)));
//										value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
										break;
									case "textalign":
										f.set(item, TextAlign.fromValue(rs.getInt(myColumn)));
//										value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
										break;
									case "idcampo":
										f.set(item, IDCampo.fromValue(rs.getInt(myColumn)));
//										value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
										break;
									default:
										break;
									}
//								}
//								else{
//									switch(atomicClassName){
//									case "string"1:
//										f.set(item, rs.getString(myColumn));
//										break;
//									case "long":
//										f.set(item, rs.getLong(myColumn));
//										break;
//									case "double":
//										f.set(item, rs.getDouble(myColumn));
//										break;
//									case "float":
//										f.set(item, rs.getFloat(myColumn));
//										break;
//									case "int":
//										f.set(item, rs.getInt(myColumn));
//										break;
//									case "boolean":
//										f.set(item, rs.getBoolean(myColumn));
//										break;
//									default:
//										break;
//									}
//								}
								
								
							}
							fields=mapperFields(item,null);
							if (fields.length()>0)
							for (String fieldName: fields.split(", ")) {
//							for (String fieldName: mapperFields(swapElement).split(", ")) {
								//ricavo l'attributo sulla base del nome
								Field f = retrieveField(fieldName, myClass);
								
								//lo rendo accessibile
								f.setAccessible(true);
								
								String myColumn = extractColumn(fieldName, item, null);
								
								//valuta attributo atomico
								String atomicClassName = f.getType().getSimpleName().toLowerCase();
//								String column = DAO.getColumn(it, myClass);
//								if (f.getType().isEnum()){
//									switch(atomicClassName){
//									case "stato":
//										f.set(item, Stato.fromValue(rs.getInt(myColumn)));
//										break;
//									case "tipoazienda":
//										f.set(item, TipoAzienda.fromValue(rs.getInt(myColumn)));
////										value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
//										break;
//									case "movimentazione":
//										f.set(item, Movimentazione.fromValue(rs.getInt(myColumn)));
////										value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//										break;
//									default:
//										break;
//									}
//								}
//								else{
									switch(atomicClassName){
									case "string":
										String txt =rs.getString(myColumn);
										if (txt!=null) {
											txt=txt.replaceAll("\'", "'");
										}
										f.set(item, txt);
										break;
									case "long":
										f.set(item, rs.getLong(myColumn));
										break;
									case "double":
										f.set(item, rs.getDouble(myColumn));
										break;
									case "float":
										f.set(item, rs.getFloat(myColumn));
										break;
									case "int":
										f.set(item, rs.getInt(myColumn));
										break;
									case "boolean":
										f.set(item, rs.getBoolean(myColumn));
										break;
									default:
										break;
									}
//								}
								
								
							}
							fields=mapperSubs(item,null);
							if (fields.length()>0)
							for (String fieldName: fields.split(", ")) {
//							for (String fieldName: mapperSubs(item,null).split(", ")) {
								//ricavo l'attributo sulla base del nome
								Field f = retrieveField(fieldName, myClass);
								
								//lo rendo accessibile
								f.setAccessible(true);
								
								String myColumn = extractColumn(fieldName, item, null);
								
////								DTOBase subElement = (DTOBase) f.getType().newInstance();
//								DTOBase subElement = retreiveSubMemory(f.getType(),null,null).get(rs.getLong(myColumn));
//								
//								f.set(item, subElement);
								
								
								
								
								DTOBase subElement;
								if (!Modifier.isAbstract(f.getType().getModifiers())) {
									subElement = retreiveSubMemory(f.getType(),null,null).get(rs.getLong(myColumn));
									f.set(item, subElement);
								}
								else {
////									subElement=null;
									subElement=findSubObject(f.getType(), rs.getLong(myColumn));
									if (subElement!=null) {
										f.set(item, subElement);
									}
									else {
										f.set(item, item2);
									}
								}
								
								
								
//								//valuta attributo atomico
//								String atomicClassName = f.getType().getSimpleName().toLowerCase();
////								String column = DAO.getColumn(it, myClass);
//								if (f.getType().isEnum()){
//									switch(atomicClassName){
//									case "stato":
//										f.set(item, Stato.fromValue(rs.getInt(myColumn)));
//										break;
//									default:
//										break;
//									}
//								}
//								else{
//									switch(atomicClassName){
//									case "string"1:
//										f.set(item, rs.getString(myColumn));
//										break;
//									case "long":
//										f.set(item, rs.getLong(myColumn));
//										break;
//									case "double":
//										f.set(item, rs.getDouble(myColumn));
//										break;
//									case "float":
//										f.set(item, rs.getFloat(myColumn));
//										break;
//									case "int":
//										f.set(item, rs.getInt(myColumn));
//										break;
//									default:
//										break;
//									}
//								}
								
								
							}
							fields=mapperLists(item,null);
							if (fields.length()>0)
							for (String fieldName: fields.split(", ")) {
//							for (String fieldName: mapperSubs(swapElement).split(", ")) {
								//ricavo l'attributo sulla base del nome
								Field f = retrieveField(fieldName, myClass);
								
								//lo rendo accessibile
								f.setAccessible(true);
								
								
								StringBuilderQuery mySubQuery=new StringBuilderQuery(readQuery);
								
								Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
								DTOBase swapSubElement = (DTOBase) type.newInstance();
								
								mySubQuery.setField(1, mapperColumns(swapSubElement,null));
								mySubQuery.setField(2, mapperTable(swapSubElement));
								mySubQuery.setField(3, mapperFather(swapSubElement));
								mySubQuery.append("=" +item.getId());
								
								
								f.set(item, extractList(type,executeQuery(mySubQuery.toString()),null));
								
								
								
								
								
//								System.out.println(type);
								
//								String myColumn = extractColumn(fieldName, item);
//								
//								DTOBase subElement = retreiveSubMemory(f.getType()).get(rs.getLong(myColumn));
//								
//								f.set(item, subElement);
							
								
							}
							item.incPriority();
							
							
							
							
							partialMemory.put(item.getId(), item);
						}
					} catch (SQLException | InstantiationException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						RCMException.showException(e);
					}
					
					
//					
//					return rs;
//					
//					
//					myMapper.
					
					
					
					daoMemory.put(myClass, partialMemory);
				}
			}
			
			
			
			return partialMemory;
		}
		
		
		private static String extractColumn/*extractFieldColumn*/(String fieldName, DTOBase item, String secondaryTable) {
			String columnName=null;
			
			
			
			
			
//			if (secondaryTable!=null) {
//				Iterator<Entry<String, Secondaries>> secondaries = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).secondaries.entrySet().iterator();
//				
//				while(secondaries.hasNext() && columnName==null) {
//					Entry<String, Secondaries> subElement = secondaries.next();
//					
//					
//					if (fieldName.equals(subElement.getValue().id.field))
//					columnName=subElement.getValue().id.column;
//					
//					Iterator<Entry<Integer, Elements>> iterator = subElement.getValue().elements.entrySet().iterator();
//					
//					
//					
//					while(iterator.hasNext() && columnName==null) {
//						Entry<Integer, Elements> subSubElement = iterator.next();
//						
//						columnName = subSubElement.getValue().fields.get(fieldName);
//					}
////					columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).fields.get(fieldName);
//					
//					
//					if (columnName==null) {
//						iterator = subElement.getValue().elements.entrySet().iterator();
//						
//						while(iterator.hasNext() && columnName==null) {
//							Entry<Integer, Elements> subSubElement = iterator.next();
//							
//							columnName = subSubElement.getValue().subs.get(fieldName);
//						}
////						columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).subs.get(fieldName);
//						if (columnName==null) {
//							iterator = subElement.getValue().elements.entrySet().iterator();
//							
//							while(iterator.hasNext() && columnName==null) {
//								Entry<Integer, Elements> subSubElement = iterator.next();
//								
//								columnName = subSubElement.getValue().enums.get(fieldName);
//							}
////							columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).subs.get(fieldName);
//						}
//					}
//					
////					columnName = subElement.getValue().  .get(fieldName);
//				}
//
//			}
//			else {
//				columnName=myMapper.commons.get(fieldName);
//				boolean found=false;
				
			
			Identifier id = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).id;
			if (id!=null && fieldName.equals(id.field)) {
				columnName=id.column;
			}
			
			
				if (columnName==null) {
					Iterator<Entry<Integer, Elements>> iterator = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.entrySet().iterator();
					
					while(iterator.hasNext() && columnName==null) {
						Entry<Integer, Elements> subElement = iterator.next();
						
						columnName = subElement.getValue().fields.get(fieldName);
					}
//					columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).fields.get(fieldName);
					
					
					if (columnName==null) {
						iterator = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.entrySet().iterator();
						
						while(iterator.hasNext() && columnName==null) {
							Entry<Integer, Elements> subElement = iterator.next();
							
							columnName = subElement.getValue().subs.get(fieldName);
						}
//						columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).subs.get(fieldName);
						if (columnName==null) {
							iterator = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.entrySet().iterator();
							
							while(iterator.hasNext() && columnName==null) {
								Entry<Integer, Elements> subElement = iterator.next();
								
								columnName = subElement.getValue().enums.get(fieldName);
							}
							if (columnName==null) {
								DTOMapper innerMapper = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase());
								
								if (innerMapper.refFather!=null)
									columnName = innerMapper.father;
							}
//							columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).subs.get(fieldName);
						}
					}
				}
//			}
			
			
			
	
			return columnName;
		}
//		private static String extractSubColumn(String fieldName, DTOBase item) {
//			String columnName=myMapper.commons.get(fieldName);
//			
////			boolean found=false;
//			
////			if (columnName==null) {
////				Iterator<Entry<Integer, Elements>> iterator = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.entrySet().iterator();
////				
////				while(iterator.hasNext() && columnName==null) {
////					Entry<Integer, Elements> subElement = iterator.next();
////					
////					columnName = subElement.getValue().fields.get(fieldName);
////				}
//////				columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).fields.get(fieldName);
////				
////				
//				if (columnName==null) {
//					Iterator<Entry<Integer, Elements>> iterator = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.entrySet().iterator();
//					
//					while(iterator.hasNext() && columnName==null) {
//						Entry<Integer, Elements> subElement = iterator.next();
//						
//						columnName = subElement.getValue().subs.get(fieldName);
//					}
////					columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).subs.get(fieldName);
//				}
////			}
//	
//			return columnName;
//		}
		private static String extractFather(Class<?> cls) {
			
			return myMapper.mapper.get(cls.getSimpleName().toLowerCase()).father;
//			
//			
//			String columnName=myMapper.commons.get(fieldName);
//			
////			boolean found=false;
//			
//			if (columnName==null) {
//				Iterator<Entry<Integer, Elements>> iterator = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.entrySet().iterator();
//				
//				while(iterator.hasNext() && columnName==null) {
//					Entry<Integer, Elements> subElement = iterator.next();
//					
//					columnName = subElement.getValue().fields.get(fieldName);
//				}
////				columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).fields.get(fieldName);
//				
//				
//				if (columnName==null) {
//					iterator = myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.entrySet().iterator();
//					
//					while(iterator.hasNext() && columnName==null) {
//						Entry<Integer, Elements> subElement = iterator.next();
//						
//						columnName = subElement.getValue().subs.get(fieldName);
//					}
////					columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).subs.get(fieldName);
//				}
//			}
////			else {
////			else {
////				//è una lista!
//////					columnName=myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).elements.get(item.getPriority()).subs.get(fieldName);
////			}
////			}
//	
//	
//	
//	
//			return columnName;
		}
		//		public static String getFilteredColumns(Class<?> c){
//			String className = c.getSimpleName().toLowerCase();
//			String fields = "";
//			
//			for (String s : fieldMapper.get(className).getPreloadFields().values()){
//				fields += s + ", ";
//			}
//			
////			Iterator<Entry<String, String>> i = fieldMapper.get(className).getPreloadFields();
////			
////			while (i.hasNext()){
////				fields += i.next().getValue() + ", ";
////			}
//			fields = fields.substring(0, fields.length()-2);
//			fields+= ", " + fieldMapper.get(className).coupleId.getColumn();
//			
//			return fields;
//		}
		private static String mapperColumns (DTOBase swapElement, String secondaryTable) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
//			if (secondaryTable!=null) {
////				classMapper.secondaries=null;
//				
//				Secondaries secondaries = classMapper.secondaries.get(className);
//				
//				fields += secondaries.id.column + ", ";
//			
//					
//				for (String s: secondaries.elements.get(swapElement.getPriority()).fields.values())
//					fields += s + ", ";
//				
//				for (String s: secondaries.elements.get(swapElement.getPriority()).subs.values())
//					fields += s + ", ";
//				
//				for (String s: secondaries.elements.get(swapElement.getPriority()).enums.values())
//					fields += s + ", ";
//					
//			}
//			else {
//	//			fields += myMapper.commons.values();
//				for (String s: myMapper.commons.values())
//					fields += s + ", ";
				Identifier id = classMapper.id;
				if (id!=null) {
					fields += id.column + ", ";
				}
				
				for (String s: classMapper.elements.get(swapElement.getPriority()).fields.values())
					fields += s + ", ";
				
//				int i=0;
//				while (i<swapElement.getPriority()) {
//					for (String s: classMapper.elements.get(i++).subs.values())
//						fields += s + ", ";
//				}
				for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
					fields += s + ", ";
				
				for (String s: classMapper.elements.get(swapElement.getPriority()).enums.values())
					fields += s + ", ";
				
				String s = classMapper.refFather;
				if (s!=null) {
					s = classMapper.father;
					fields += s + ", ";
				}
				
				
//			}
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}

		private static String fullMapperColumns (DTOBase swapElement) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
//			if (secondaryTable!=null) {
////				classMapper.secondaries=null;
//				
//				Secondaries secondaries = classMapper.secondaries.get(className);
//				
//				fields += secondaries.id.column + ", ";
//			
//					
//				for (String s: secondaries.elements.get(swapElement.getPriority()).fields.values())
//					fields += s + ", ";
//				
//				for (String s: secondaries.elements.get(swapElement.getPriority()).subs.values())
//					fields += s + ", ";
//				
//				for (String s: secondaries.elements.get(swapElement.getPriority()).enums.values())
//					fields += s + ", ";
//					
//			}
//			else {
//	//			fields += myMapper.commons.values();
//				for (String s: myMapper.commons.values())
//					fields += s + ", ";
				Identifier id = classMapper.id;
				if (id!=null) {
					fields += id.column + ", ";
				}
				
				HashMap<Integer, Elements> field = classMapper.elements;
				
				for (Elements elem : classMapper.elements.values()) {
					for (String s : elem.fields.values())
						fields += s + ", ";
					for (String s : elem.subs.values())
						fields += s + ", ";
					for (String s : elem.enums.values())
						fields += s + ", ";
				}
				
				String s = classMapper.refFather;
				if (s!=null) {
					s = classMapper.father;
					fields += s + ", ";
				}
				
				
//			}
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}

		
		
		
		private static String mapperTableWithColumns (DTOBase swapElement) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			String tableName = classMapper.table;
			
			String fields = "";
			
////			fields += myMapper.commons.values();
//			for (String s: myMapper.commons.values())
//				fields += tableName + "." + s + " as "  + s + ", ";
			
			Identifier id = classMapper.id;
			if (id!=null) {
				fields += tableName + "." + id.column + " as "  + id.column + ", ";
			}
			
			for (String s: classMapper.elements.get(swapElement.getPriority()).fields.values())
				fields += tableName + "." + s + " as "  + s + ", ";
			
			for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
				fields += tableName + "." + s +  " as "  + s + ", ";
			
			for (String s: classMapper.elements.get(swapElement.getPriority()).enums.values())
				fields += tableName + "." + s +  " as "  + s + ", ";
			
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String mapperFields (DTOBase swapElement, String secondaryTable) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
			
//			if (secondaryTable!=null) {
////				classMapper.secondaries=null;
//				
//				Secondaries secondaries = classMapper.secondaries.get(className);
//				
//				
//				if (swapElement.getPriority()<secondaries.elements.size()) {
//						fields += secondaries.id.field + ", ";
//					
//					for (String s: secondaries.elements.get(swapElement.getPriority()).fields.keySet())
//						fields += s + ", ";
//					
//				}
//			}
//			else {
				if (swapElement.getPriority()<classMapper.elements.size()) {
					
					
//	//				fields += myMapper.commons.values();
//					for (String s: myMapper.commons.values())
//						fields += s + ", ";
					
					Identifier id = classMapper.id;
					if (id!=null) {
						fields += id.column + ", ";
					}
					
					
					for (String s: classMapper.elements.get(swapElement.getPriority()).fields.keySet())
						fields += s + ", ";
					
	//				for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
	//					fields += s + ", ";
	//				
	//				for (String s: classMapper.elements.get(swapElement.getPriority()).lists)
	//					fields += s + ", ";
				}
//			}
			
			if (fields.length()>0)
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String mapperEnums (DTOBase swapElement, String secondaryTable) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
			
			
			
//			if (secondaryTable!=null) {
////				classMapper.secondaries=null;
//				
//				Secondaries secondaries = classMapper.secondaries.get(className);
//				
//				
//				if (swapElement.getPriority()<secondaries.elements.size()) {
//					
//					for (String s: secondaries.elements.get(swapElement.getPriority()).enums.keySet())
//						fields += s + ", ";
//					
//				}
//			}
//			else {
				if (swapElement.getPriority()<classMapper.elements.size()) {
					
					
//					fields += myMapper.commons.values();
//					for (String s: myMapper.commons.values())
//						fields += s + ", ";
					
					for (String s: classMapper.elements.get(swapElement.getPriority()).enums.keySet())
						fields += s + ", ";
					
//					for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
//						fields += s + ", ";
//					
//					for (String s: classMapper.elements.get(swapElement.getPriority()).lists)
//						fields += s + ", ";
				}
//			}
			
			if (fields.length()>0)
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String mapperSubs (DTOBase swapElement, String secondaryTable) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
//			if (secondaryTable!=null) {
////				classMapper.secondaries=null;
//				
//				Secondaries secondaries = classMapper.secondaries.get(className);
//				
//				
//				if (swapElement.getPriority()<secondaries.elements.size()) {
//					
//					for (String s: secondaries.elements.get(swapElement.getPriority()).subs.keySet())
//						fields += s + ", ";
//					
//				}
//			}
//			else {
				if (swapElement.getPriority()<classMapper.elements.size()) {
	//			fields += myMapper.commons.values();
	//			for (String s: myMapper.commons.values())
	//				fields += s + ", ";
				
	//			for (String s: classMapper.elements.get(swapElement.getPriority()).fields.values())
	//				fields += s + ", ";
	//			
				for (String s: classMapper.elements.get(swapElement.getPriority()).subs.keySet())
					fields += s + ", ";
				
				
				if (classMapper.refFather!=null) {
					fields += classMapper.refFather + ", ";
				}
				
				
				
				
	//			for (String s: classMapper.elements.get(swapElement.getPriority()).lists)
	//				fields += s + ", ";
				}
//			}
			if (fields.length()>0)
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String mapperLists (DTOBase swapElement, String secondaryTable) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
//			if (secondaryTable!=null) {
////				classMapper.secondaries=null;
//				
//				Secondaries secondaries = classMapper.secondaries.get(className);
//				
//				
//				if (swapElement.getPriority()<secondaries.elements.size()) {
//					
//					for (String s: secondaries.elements.get(swapElement.getPriority()).lists)
//						fields += s + ", ";
//					
//				}
//			}
//			else {
				if (swapElement.getPriority()<classMapper.elements.size()) {
	//			fields += myMapper.commons.values();
	//			for (String s: myMapper.commons.values())
	//				fields += s + ", ";
				
	//			for (String s: classMapper.elements.get(swapElement.getPriority()).fields.values())
	//				fields += s + ", ";
	//			
	//			for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
	//				fields += s + ", ";
	//			
				for (String s: classMapper.elements.get(swapElement.getPriority()).lists)
					fields += s + ", ";
				}
//			}
			if (fields.length()>0)
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String mapperTable (DTOBase swapElement) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = classMapper.table;
			
////			fields += myMapper.commons.values();
//			for (String s: myMapper.commons.values())
//				fields += s + ", ";
//			
//			for (String s: classMapper.elements.get(swapElement.getPriority()).fields.values())
//				fields += s + ", ";
//			
//			for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
//				fields += s + ", ";
//			
//			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String mapperFather(DTOBase swapElement) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = classMapper.father;
			
////			fields += myMapper.commons.values();
//			for (String s: myMapper.commons.values())
//				fields += s + ", ";
//			
//			for (String s: classMapper.elements.get(swapElement.getPriority()).fields.values())
//				fields += s + ", ";
//			
//			for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
//				fields += s + ", ";
//			
//			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String mapperFatherReference(DTOBase swapElement) {
			String className = swapElement.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = classMapper.refFather;
			
			if (fields==null)
				fields="";
//			else
//				fields = ", " + fields;
				
				
				
				
////			fields += myMapper.commons.values();
//			for (String s: myMapper.commons.values())
//				fields += s + ", ";
//			
//			for (String s: classMapper.elements.get(swapElement.getPriority()).fields.values())
//				fields += s + ", ";
//			
//			for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
//				fields += s + ", ";
//			
//			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		public static void read(DTOBase o) {
			boolean read=false;
			ResultSet subRs;
			
			
			if (o instanceof Documento) {
				System.out.print("");
			}
			
			
////			if (o.getPriority()<myMapper.mapper.get(o.getClass().getSimpleName().toLowerCase()).elements.size()) {
//			StringBuilderQuery subReadQuery = new StringBuilderQuery(readQuery);
			StringBuilderQuery subReadQuery = null;
			while (o.getPriority()<myMapper.mapper.get(o.getClass().getSimpleName().toLowerCase()).elements.size()) {
				
				 subReadQuery = new StringBuilderQuery(readQuery);
				
			try {
				
				
			subReadQuery.setField(2, mapperTable(o));
			subReadQuery.setField(1, mapperColumns(o,null));
			subReadQuery.setField(3, "id=" + o.getId());
//			System.out.print("");
//			try {
			DAO.printToConsole1(subReadQuery);
			
			System.out.println();
				statement = getConnection().createStatement();
//				statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
				subRs = statement.executeQuery(subReadQuery.toString());
				subRs.next();
				
				
				
				
//				,Statement.RETURN_GENERATED_KEYS);
//				subRs = statement.getGeneratedKeys();
			
//			DTOBase item = (DTOBase) myClass.newInstance();
			
				String fields=mapperEnums(o,null);
//				fields=mapperColumns(o);
				if (fields.length()>0) {
					read=true;
				for (String fieldName: fields.split(", ")) {
//				for (String fieldName: mapperFields(swapElement).split(", ")) {
					//ricavo l'attributo sulla base del nome
					Field f = retrieveField(fieldName, o.getClass());
					
					//lo rendo accessibile
					f.setAccessible(true);
					
//					if (!identifier(fieldName,o)) {
						String myColumn = extractColumn(fieldName, o, null);
						
						//valuta attributo atomico
						String atomicClassName = f.getType().getSimpleName().toLowerCase();
//						String column = DAO.getColumn(it, myClass);
//						if (f.getType().isEnum()){
							switch(atomicClassName){
							case "stato":
									f.set(o, Stato.fromValue(subRs.getInt(myColumn)));
								break;
							case "tipoazienda":
								f.set(o, TipoAzienda.fromValue(subRs.getInt(myColumn)));
//								value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
								break;
							case "movimentazione":
								f.set(o, Movimentazione.fromValue(subRs.getInt(myColumn)));
//								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
								break;
							case "textalign":
								f.set(o, TextAlign.fromValue(subRs.getInt(myColumn)));
//								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
								break;
							case "idcampo":
								f.set(o, IDCampo.fromValue(subRs.getInt(myColumn)));
//								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
								break;
							default:
								break;
							}
//						}
//						else{
//							switch(atomicClassName){
//							case "string"1:
//								f.set(o, subRs.getString(myColumn));
//								break;
//							case "long":
//								f.set(o, subRs.getLong(myColumn));
//								break;
//							case "double":
//								f.set(o, subRs.getDouble(myColumn));
//								break;
//							case "float":
//								f.set(o, subRs.getFloat(myColumn));
//								break;
//							case "int":
//								f.set(o, subRs.getInt(myColumn));
//								break;
//							case "boolean":
//								f.set(o, subRs.getBoolean(myColumn));
//								break;
//							default:
//								break;
//							}
//						}
//					}
					
					
				}
				}
				fields=mapperFields(o,null);
//				fields=mapperColumns(o);
				if (fields.length()>0) {
					read=true;
				for (String fieldName: fields.split(", ")) {
//				for (String fieldName: mapperFields(swapElement).split(", ")) {
					//ricavo l'attributo sulla base del nome
					Field f = retrieveField(fieldName, o.getClass());
					
					//lo rendo accessibile
					f.setAccessible(true);
					
					if (!identifier(fieldName,o)) {
						String myColumn = extractColumn(fieldName, o, null);
						
						//valuta attributo atomico
						String atomicClassName = f.getType().getSimpleName().toLowerCase();
//						String column = DAO.getColumn(it, myClass);
//						if (f.getType().isEnum()){
//							switch(atomicClassName){
//							case "stato":
//									f.set(o, Stato.fromValue(subRs.getInt(myColumn)));
//								break;
//							case "tipoazienda":
//								f.set(o, TipoAzienda.fromValue(subRs.getInt(myColumn)));
////								value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
//								break;
//							case "movimentazione":
//								f.set(o, Movimentazione.fromValue(subRs.getInt(myColumn)));
////								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//								break;
//							default:
//								break;
//							}
//						}
//						else{
							switch(atomicClassName){
							case "string":
								String txt =subRs.getString(myColumn);
								if (txt!=null) {
									txt=txt.replaceAll("\'", "'");
								}
								f.set(o, txt);
								break;
							case "long":
								f.set(o, subRs.getLong(myColumn));
								break;
							case "double":
								f.set(o, subRs.getDouble(myColumn));
								break;
							case "float":
								f.set(o, subRs.getFloat(myColumn));
								break;
							case "int":
								f.set(o, subRs.getInt(myColumn));
								break;
							case "boolean":
								f.set(o, subRs.getBoolean(myColumn));
								break;
							default:
								break;
							}
						}
					}
					
					
//				}
				}
				fields=mapperSubs(o,null);
//				fields=allMapperSubs(o);
			if (fields.length()>0) {
				read=true;
			for (String fieldName: fields.split(", ")) {
//			for (String fieldName: mapperSubs(swapElement).split(", ")) {
				//ricavo l'attributo sulla base del nome
				Field f = retrieveField(fieldName, o.getClass());
				
				//lo rendo accessibile
				f.setAccessible(true);
				
				String myColumn = extractColumn(fieldName, o, null);
				
				
//				long idElem = rs.getLong(myColumn);
//				if (idElem>0) {
//					StringBuilderQuery subQuery=new StringBuilderQuery(readQuery);
//					subQuery.setField(1, mapperColumns((DTOBase) f.getType().newInstance()));
//					subQuery.setField(2, mapperTable((DTOBase) f.getType().newInstance()));
//					
//					subQuery.setField(3, "id = " + idElem);
//				}
				
				if (f.getType()==TipoDocumento.class) {
					System.out.print("");
				}
				
				DTOBase subElement = retreiveSubMemory(f.getType(),null,null).get(subRs.getLong(myColumn));
//				read(subElement);
				
				
				f.set(o, subElement);
			
				
			}
			}
//			fields=mapperLists(o,null);
			fields=allMapperLists(o);
			if (fields.length()>0) {
				read=true;
			for (String fieldName: fields.split(", ")) {
//			for (String fieldName: mapperSubs(swapElement).split(", ")) {
				//ricavo l'attributo sulla base del nome
				Field f = retrieveField(fieldName, o.getClass());
				
				//lo rendo accessibile
				f.setAccessible(true);
				
				
				StringBuilderQuery mySubQuery=new StringBuilderQuery(readQuery);
				
				Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
				DTOBase swapSubElement = (DTOBase) type.newInstance();
				
//				mySubQuery.setField(1, mapperColumns(swapSubElement));
//				mySubQuery.setField(2, mapperTable(swapSubElement));
//				mySubQuery.setField(3, mapperFather(swapSubElement));
//				mySubQuery.append("=" +o.getId());
				

				
				
				
				
				MToM[] relation = getManyToMany(swapSubElement, o);
				
				
				
				if (relation!=null) {
//					gestire le liste con i many to many
					mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
					mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
					mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + o.getId());
				}
				else {
					mySubQuery.setField(1, mapperColumns(swapSubElement,null));
					mySubQuery.setField(2, mapperTable(swapSubElement));
					mySubQuery.setField(3, mapperFather(swapSubElement));
					mySubQuery.append("=" +o.getId());
				}
				
				
				
				
				if (o.getId()==1600 && o instanceof Cliente) {
				System.out.print("");
				}
				
				if (type.equals(Strada.class)) {
					System.out.print("");
				}
				f.set(o, extractList(type,executeQuery(mySubQuery.toString()),null));
				
				
				
				
				
//				System.out.println(type);
				
//				String myColumn = extractColumn(fieldName, item);
//				
//				DTOBase subElement = retreiveSubMemory(f.getType()).get(rs.getLong(myColumn));
//				
//				f.set(item, subElement);
			
				
			}
			}
			if (read==true) {
				o.incPriority();
//				if (!o.isLocked())
//					o.lock();
				daoMemory.get(o.getClass()).put(o.getId(), o);
				o=daoMemory.get(o.getClass()).get(o.getId());
				
				
				
				
			}
			
			
			
//			partialMemory.put(item.getId(), item);
			
			} catch (IllegalArgumentException | IllegalAccessException | SQLException | InstantiationException e) {
				// TODO Auto-generated catch block
				RCMException.showException(e);
			}
			}
			
//			if (read==false) {
//				HashMap<Long, DTOBase> mem = daoMemory.get(o.getClass());
//				if (mem!=null)
//					o=mem.get(o.getId());
//			}
			
			
			
			
		}
		
//		public static void replicate(DTOBase src, DTOBase dst) {
//			boolean read=false;
////			ResultSet subRs;
//			
//			
////			if (o instanceof TipoDocumento) {
////				System.out.print("");
////			}
//			
//			
//////			if (o.getPriority()<myMapper.mapper.get(o.getClass().getSimpleName().toLowerCase()).elements.size()) {
////			StringBuilderQuery subReadQuery = new StringBuilderQuery(readQuery);
//////			while (o.getPriority()<myMapper.mapper.get(o.getClass().getSimpleName().toLowerCase()).elements.size()) {
//			try {
////			subReadQuery.setField(2, mapperTable(o));
////			subReadQuery.setField(1, fullMapperColumns(o));
////			subReadQuery.setField(3, "id=" + o.getId());
//////			System.out.print("");
//////			try {
////			DAO.printToConsole1(subReadQuery);
////			
////				statement = getConnection().createStatement();
//////				statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
////				subRs = statement.executeQuery(subReadQuery.toString());
////				subRs.next();
//				
//				
//				
//				
//////				,Statement.RETURN_GENERATED_KEYS);
//////				subRs = statement.getGeneratedKeys();
////			
//////			DTOBase item = (DTOBase) myClass.newInstance();
////			Field fP = retrieveField("priority", o.getClass());
////			fP.setAccessible(true);
////			fP.set(o, 0);
//
//				String fields=allMapperEnums(src);
////				fields=mapperColumns(o);
//				if (fields.length()>0) {
//					read=true;
//				for (String fieldName: fields.split(", ")) {
////				for (String fieldName: mapperFields(swapElement).split(", ")) {
//					//ricavo l'attributo sulla base del nome
//					Field fSrc = retrieveField(fieldName, src.getClass());
//					Field fDst = retrieveField(fieldName, dst.getClass());
//					
//					//lo rendo accessibile
//					fSrc.setAccessible(true);
//					fDst.setAccessible(true);
//					
//////					if (!identifier(fieldName,o)) {
////						String myColumn = extractColumn(fieldName, o, null);
//						
//						//valuta attributo atomico
//						String atomicClassName = fSrc.getType().getSimpleName().toLowerCase();
////						String column = DAO.getColumn(it, myClass);
////						if (f.getType().isEnum()){
//							switch(atomicClassName){
//							case "stato":
//								fDst.set(dst, Stato.fromValue((int)fSrc.get(src)));
//								break;
//							case "tipoazienda":
//								fDst.set(dst, TipoAzienda.fromValue((int)fSrc.get(src)));
////								value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
//								break;
//							case "movimentazione":
//								fDst.set(dst, Movimentazione.fromValue((int)fSrc.get(src)));
////								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//								break;
//							case "textalign":
//								fDst.set(dst, TextAlign.fromValue((int)fSrc.get(src)));
////								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//								break;
//							case "idcampo":
//								fDst.set(dst, IDCampo.fromValue((int)fSrc.get(src)));
////								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//								break;
//							default:
//								break;
//							}
////						}
////						else{
////							switch(atomicClassName){
////							case "string"1:
////								f.set(o, subRs.getString(myColumn));
////								break;
////							case "long":
////								f.set(o, subRs.getLong(myColumn));
////								break;
////							case "double":
////								f.set(o, subRs.getDouble(myColumn));
////								break;
////							case "float":
////								f.set(o, subRs.getFloat(myColumn));
////								break;
////							case "int":
////								f.set(o, subRs.getInt(myColumn));
////								break;
////							case "boolean":
////								f.set(o, subRs.getBoolean(myColumn));
////								break;
////							default:
////								break;
////							}
////						}
////					}
//					
//					
//				}
//				}
//				fields=allMapperFields(src);
////				fields=mapperColumns(o);
//				if (fields.length()>0) {
//					read=true;
//				for (String fieldName: fields.split(", ")) {
////				for (String fieldName: mapperFields(swapElement).split(", ")) {
//					//ricavo l'attributo sulla base del nome
//					Field fSrc = retrieveField(fieldName, src.getClass());
//					Field fDst= retrieveField(fieldName, dst.getClass());
//					
//					//lo rendo accessibile
//					fSrc.setAccessible(true);
//					fDst.setAccessible(true);
//					
//					if (!identifier(fieldName,src)) {
////						String myColumn = extractColumn(fieldName, o, null);
//						
//						//valuta attributo atomico
//						String atomicClassName = fSrc.getType().getSimpleName().toLowerCase();
////						String column = DAO.getColumn(it, myClass);
////						if (f.getType().isEnum()){
////							switch(atomicClassName){
////							case "stato":
////									f.set(o, Stato.fromValue(subRs.getInt(myColumn)));
////								break;
////							case "tipoazienda":
////								f.set(o, TipoAzienda.fromValue(subRs.getInt(myColumn)));
//////								value += "" + TipoAzienda.fromName((TipoAzienda) field.get(o)) + "";					
////								break;
////							case "movimentazione":
////								f.set(o, Movimentazione.fromValue(subRs.getInt(myColumn)));
//////								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
////								break;
////							default:
////								break;
////							}
////						}
////						else{
//							switch(atomicClassName){
//							case "string":
//								String txt =(String) fSrc.get(src);
//								if (txt!=null) {
//									txt=txt.replaceAll("\'", "'");
//								}
//								fDst.set(dst, txt);
//								break;
//							case "long":
//								fDst.set(dst, (long)fSrc.get(src));
//								break;
//							case "double":
//								fDst.set(dst, (double)fSrc.get(src));
//								break;
//							case "float":
//								fDst.set(dst, (float)fSrc.get(src));
//								break;
//							case "int":
//								fDst.set(dst, (int)fSrc.get(src));
//								break;
//							case "boolean":
//								fDst.set(dst, (boolean)fSrc.get(src));
//								break;
//							default:
//								break;
//							}
//						}
//					}
//					
//					
////				}
//				}
//				fields=allMapperSubs(src);
////				fields=allMapperSubs(o);
//			if (fields.length()>0) {
//				read=true;
//			for (String fieldName: fields.split(", ")) {
////			for (String fieldName: mapperSubs(swapElement).split(", ")) {
//				//ricavo l'attributo sulla base del nome
//				Field fDst = retrieveField(fieldName, dst.getClass());
//				Field fSrc = retrieveField(fieldName, src.getClass());
//				
//				//lo rendo accessibile
//				fDst.setAccessible(true);
//				fSrc.setAccessible(true);
//				
////				String myColumn = extractColumn(fieldName, o, null);
////				
////				
//////				long idElem = rs.getLong(myColumn);
//////				if (idElem>0) {
//////					StringBuilderQuery subQuery=new StringBuilderQuery(readQuery);
//////					subQuery.setField(1, mapperColumns((DTOBase) f.getType().newInstance()));
//////					subQuery.setField(2, mapperTable((DTOBase) f.getType().newInstance()));
//////					
//////					subQuery.setField(3, "id = " + idElem);
//////				}
////				
////				if (f.getType()==TipoDocumento.class) {
////					System.out.print("");
////				}
//				
////				DTOBase subElement = retreiveSubMemory(f.getType(),null,null).get(src.getId());
////				read(subElement);
//				
//				
//				fDst.set(dst, fSrc.get(src));
//			
//				
//			}
//			}
////			fields=mapperLists(o,null);
//			fields=allMapperLists(src);
//			if (fields.length()>0) {
//				read=true;
//			for (String fieldName: fields.split(", ")) {
////			for (String fieldName: mapperSubs(swapElement).split(", ")) {
//				//ricavo l'attributo sulla base del nome
//				Field fDst = retrieveField(fieldName, dst.getClass());
//				Field fSrc = retrieveField(fieldName, src.getClass());
//				
//				//lo rendo accessibile
//				fDst.setAccessible(true);
//				fSrc.setAccessible(true);
//				
//				
////				StringBuilderQuery mySubQuery=new StringBuilderQuery(readQuery);
//				
////				Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
////				DTOBase swapSubElement = (DTOBase) type.newInstance();
//				
////				mySubQuery.setField(1, mapperColumns(swapSubElement));
////				mySubQuery.setField(2, mapperTable(swapSubElement));
////				mySubQuery.setField(3, mapperFather(swapSubElement));
////				mySubQuery.append("=" +o.getId());
//				
//
//				
//				
//				
//				
////				MToM[] relation = getManyToMany(swapSubElement, o);
////				
////				
////				
////				if (relation!=null) {
//////					gestire le liste con i many to many
////					mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
////					mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
////					mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + o.getId());
////				}
////				else {
////					mySubQuery.setField(1, mapperColumns(swapSubElement,null));
////					mySubQuery.setField(2, mapperTable(swapSubElement));
////					mySubQuery.setField(3, mapperFather(swapSubElement));
////					mySubQuery.append("=" +o.getId());
////				}
//				
//				
//				
//				
////				if (o.getId()==1600 && o instanceof Cliente) {
////				System.out.print("");
////				}
//				
////				fDst.set(dst, f.get(src));
//				fDst.set(dst, fSrc.get(src));
//			
//				
//				
//				
//				
////				System.out.println(type);
//				
////				String myColumn = extractColumn(fieldName, item);
////				
////				DTOBase subElement = retreiveSubMemory(f.getType()).get(rs.getLong(myColumn));
////				
////				f.set(item, subElement);
//			
//				
//			}
//			}
////			if (read==true) {
////				o.incPriority();
////				daoMemory.get(o.getClass()).put(o.getId(), o);
////				o=daoMemory.get(o.getClass()).get(o.getId());
////			}
//			
//			
//			
////			partialMemory.put(item.getId(), item);
//			
////			} catch (IllegalArgumentException | IllegalAccessException | SQLException | InstantiationException e) {
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				RCMException.showException(e);
//			}
////			}
//		}
//		
		
		private static boolean identifier(String fieldName, DTOBase item) {
			
			String className = item.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			
			
			
			return myMapper.mapper.get(item.getClass().getSimpleName().toLowerCase()).id.field.equals(fieldName)?true:false;
		}
		public static Iterator<Entry<Long, DTOBase>> getAll(Class<?> persistentClass) {
			
			
			return daoMemory.get(persistentClass).entrySet().iterator();
			
			
//			return null;
			

		}
		public static void updateNew(DTOBase o) {
			
			
			if (o instanceof Documento) {
				System.out.print("");
			}
			String fields="";//allMapperFields(o);
			StringBuilderQuery fullQuery = new StringBuilderQuery(updateQuery);
			
			fullQuery.setField(1, mapperTable(o));
			fullQuery.setField(3, "id="+o.getId());
			
/********************************************************************************/			
			
			//ricavare l'elenco degli attributi
//			String columnList="";
			String valueList="";
			
			
			
			try {
				fields=allMapperEnums(o);
				if (fields.length()>0)
				for (String s : fields.split(", ")) {
					Field f = retrieveField(s, o.getClass());
					
					//lo rendo accessibile
					f.setAccessible(true);
					
					valueList+=extractColumn(s, o,null) + "=";
					
					String atomicClassName = f.getType().getSimpleName().toLowerCase();
//					String column = DAO.getColumn(it, o.getClass());
//					if (f.getType().isEnum()){
						switch(atomicClassName){
						case "stato":
								valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
//							f.set(o, Stato.fromValue(rs.getInt(column)));
							break;
						case "tipoazienda":
							valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
							break;
						case "movimentazione":
							valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
							break;
						case "textalign":
							valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
							break;
						case "idcampo":
							valueList+= IDCampo.fromName((IDCampo) f.get(o)) + ", ";
//							value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
							break;
						default:
							break;
						}
					
				}
				
				fields=allMapperFields(o);
				if (fields.length()>0)
				for (String s : fields.split(", ")) {
					Field f = retrieveField(s, o.getClass());
					
					//lo rendo accessibile
					f.setAccessible(true);
					
					valueList+=extractColumn(s, o,null) + "=";
					
					String atomicClassName = f.getType().getSimpleName().toLowerCase();
						switch(atomicClassName){
						case "string":
							String txt = (String) f.get(o);
							if (txt!=null) {
								txt=txt.replaceAll("'", "\'");
								txt=txt.replaceAll("|", "");
							}
							valueList+= "'" + txt + "', ";
//							f.set(o, rs.getString(column));
							break;
						case "long":
							valueList+= "" + f.get(o) + ", ";
							break;
						case "int":
							valueList+= "" + f.get(o) + ", ";
							break;
						case "boolean":
							valueList+= "" + f.get(o) + ", ";
							break;
						case "float":
							valueList+= "" + f.get(o) + ", ";
							break;
						case "double":
							valueList+= "" + f.get(o) + ", ";
							break;
						default:
							System.out.print("");
//							System.out.print("");
							break;
						}
					
				}
				
				
				
				
				
				
//				if (fields.length()>0)
//				for (String s : fields.split(", ")) {
//					Field f = retrieveField(s, o.getClass());
//					
//					//lo rendo accessibile
//					f.setAccessible(true);
//					
//					valueList+=extractColumn(s, o,null) + "=";
//					
//					String atomicClassName = f.getType().getSimpleName().toLowerCase();
////					String column = DAO.getColumn(it, o.getClass());
//					if (f.getType().isEnum()){
//						switch(atomicClassName){
//						case "stato":
//								valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////							f.set(o, Stato.fromValue(rs.getInt(column)));
//							break;
//						case "tipoazienda":
//							valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//							break;
//						case "movimentazione":
//							valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//							break;
//						default:
//							break;
//						}
//					}
//					else{
//						switch(atomicClassName){
//						case "string"1:
//							valueList+= "'" + f.get(o) + "', ";
////							f.set(o, rs.getString(column));
//							break;
//						case "long":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						case "int":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						case "boolean":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						case "float":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						case "double":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						default:
//							System.out.print("");
////							System.out.print("");
//							break;
//						}
//					}
////					columnList=columnList.substring(0,columnList.length()-2);
////					valueList=valueList.substring(0,valueList.length()-2);
//					
//				}
				
				fields=allMapperSubs(o);
				if (fields.length()>0)
					for (String s : fields.split(", ")) {
						Field f = retrieveField(s, o.getClass());
						
						//lo rendo accessibile
						f.setAccessible(true);
						
						valueList+=extractColumn(s, o,null) + "=";
						
						
						try{
						valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
						}
						catch(NullPointerException e){
							valueList+= " NULL , ";
						}
						
					}
				
//				columnList=columnList.substring(0,columnList.length()-2);
				valueList=valueList.substring(0,valueList.length()-2);
				
//				fullQuery.setField(2, columnList);
				fullQuery.setField(2, valueList);
//				fullQuery.setField(3, "id=" + o.getId());

				
				
				try {
					DAO.printToConsole1(fullQuery);
					statement = getConnection().createStatement();
////					statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//					statement.execute1Update(fullQuery.toString(),Statement.RETURN_GENERATED_KEYS);
					statement.executeUpdate(fullQuery.toString());
//					ResultSet rs = statement.getGeneratedKeys();
//					rs.next();
//					o.setId(rs.getLong(1));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					RCMException.showException(e1);
				}
				
				
				
				
//				fields=allMapperLists(o);
//				if (fields.length()>0)
//					for (String s : fields.split(", ")) {
//						Field f = retrieveField(s, o.getClass());
//						
//						//lo rendo accessibile
//						f.setAccessible(true);
//						
//						
////						StringBuilderQuery subQueries = new StringBuilderQuery(extractSubQueries((ArrayList<DTOBase>) f.get(o)));
//						
//			            Type type = f.getGenericType();
//
//		                ParameterizedType pType = (ParameterizedType)type;
//		                Type[] arr = pType.getActualTypeArguments();
//		                Class<?> innerClass = (Class<?>) arr[0];
//		                
//						String myColumn=extractFather(innerClass);
//						subUpdateNew((ArrayList<DTOBase>) f.get(o), myColumn, o.getId());
//					}
				
				
				
				
				fields=allMapperLists(o);
				if (fields.length()>0)
					for (String s : fields.split(", ")) {
						Field f = retrieveField(s, o.getClass());
						
						//lo rendo accessibile
						f.setAccessible(true);
						
						
//						StringBuilderQuery subQueries = new StringBuilderQuery(extractSubQueries((ArrayList<DTOBase>) f.get(o)));
						
			            Type type = f.getGenericType();

		                ParameterizedType pType = (ParameterizedType)type;
		                Type[] arr = pType.getActualTypeArguments();
		                Class<?> innerClass = (Class<?>) arr[0];
		                DTOBase swapSubElement=null;
						try {
							swapSubElement = (DTOBase) innerClass.newInstance();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							RCMException.showException(e);
						}
		                
						
						if (s.equals("indirizzi"))
							System.out.print("");
						MToM[] relation = getManyToMany(swapSubElement, o);
						
						
						
//						for (DTOBase arrayElement:lista) {
//							if (arrayElement.getId()==0)
//								nuovi.add(arrayElement);
//						}
//						lista.removeAll(nuovi);
						
						
						
						
						
						
						ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(o);
						ArrayList<DTOBase> nuovi=null;
						
						
						if (relation!=null) {
							ArrayList<DTOBase> subLista = new ArrayList<>();
							subLista.addAll(lista);
							
							
							
							//una volta aggiornati gli elementi
							subUpdateMToM(subLista, relation, o.getId());
							//inserisco quelli nuovi
							subCreateMToM(subLista, relation, o.getId());
							nuovi=subLista;
						}
						else {
							nuovi = new ArrayList<>();
							
							for (DTOBase arrayElement:lista) {
								if (arrayElement.getId()==0)
									nuovi.add(arrayElement);
							}
							lista.removeAll(nuovi);
							
							String myColumn=extractFather(innerClass);
							subUpdateNew(lista, myColumn, o.getId());
							subCreateNew(nuovi, myColumn, o.getId());
							lista.addAll(nuovi);
							
							
							
							
							
							
//							subUpdateNew_old(lista, innerClass, o.getId());
							
							
							
						}
						
						
						
//						if (relation!=null) {
//							subCreateMToM(nuovi, relation, o.getId());
//						}
//						else {
//							String myColumn=extractFather(innerClass);
//							subCreateNew(nuovi, myColumn, o.getId());
//						}
					}
				
				
//				DTOBase k = daoMemory.get(o.getClass()).get(o.getId());
//				replicate(o, k);
//				
//				o.unlock();
				daoMemory.get(o.getClass()).put(o.getId(), o);
				
/********************************************************************************/			
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				RCMException.showException(e);
			}
		}
//private static void replicate(DTOBase src, DTOBase dst) {
//			// TODO Auto-generated method stub
//			
//		}
//		@Deprecated
//		private static void subDeleteNew(ArrayList<DTOBase> arrayList, String fatherColumn, long l) {
//			
//			
//			String fields = allMapperLists(d);
//			if (fields.length()>0)
//				for (String s : fields.split(", ")) {
//					Field f = retrieveField(s, d.getClass());
//					
//					//lo rendo accessibile
//					f.setAccessible(true);
//					
//					
////					StringBuilderQuery subQueries = new StringBuilderQuery(extractSubQueries((ArrayList<DTOBase>) f.get(o)));
//					
//		            Type type = f.getGenericType();
//
//	                ParameterizedType pType = (ParameterizedType)type;
//	                Type[] arr = pType.getActualTypeArguments();
//	                Class<?> innerClass = (Class<?>) arr[0];
//	                
//	                DTOBase swapSubElement=null;
//					try {
//						swapSubElement = (DTOBase) innerClass.newInstance();
//					} catch (InstantiationException | IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	                
//					MToM[] relation = getManyToMany(swapSubElement, d);
//					
//					
//					
//					if (relation!=null) {
////						gestire le liste con i many to many
////						mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
////						mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
////						mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + o.getId());
//						try {
//							subCreateMToM((ArrayList<DTOBase>) f.get(d), relation, d.getId());
//						} catch (IllegalArgumentException | IllegalAccessException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//					else {
//						String myColumn=extractFather(innerClass);
//						try {
//							subCreateNew((ArrayList<DTOBase>) f.get(d), myColumn, d.getId());
//						} catch (IllegalArgumentException | IllegalAccessException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//	                
//					
//				}
//			
//		
//			
//			
//			
//			
//		}
//
		private static void subUpdateNew_old(ArrayList<DTOBase> arrayList, Class<?> innerClass2, long id) {
			
			
//            Type type = arrayList.getClass().getGenericSuperclass()
//        	
//            ParameterizedType pType = (ParameterizedType)type;
//            Type[] arr = pType.getActualTypeArguments();
//            Class<?> innerClass = (Class<?>) arr[0];
//            
//			String myColumn=extractFather(innerClass);
			ArrayList<Long> ids=new ArrayList<>();
			ArrayList<Long> idsRemove=new ArrayList<>();
			StringBuilderQuery mySubQuery=null;
			ResultSet rs = null;
			
			DTOBase myDTO = null;
			
			mySubQuery= new StringBuilderQuery(readQuery);
			mySubQuery.setField(1, "id");
			try {
				myDTO = 	(DTOBase) innerClass2.newInstance();
				mySubQuery.setField(2, mapperTable(myDTO));
				mySubQuery.setField(3, extractFather(innerClass2) + "=" + id);// + " and " + relation[1].column + "=" + o.getId());
				statement = getConnection().createStatement();
	//			statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
				DAO.printToConsole1(mySubQuery);
				rs = statement.executeQuery(mySubQuery.toString());
			} catch (InstantiationException | IllegalAccessException | SQLException e2) {
				// TODO Auto-generated catch block
				RCMException.showException(e2);
			}
			
			if (rs!=null) {
				boolean found=false;
				DTOBase o2=null;
				Iterator<DTOBase> it = null;
				
				try {
					while (rs.next()) {
						it = arrayList.iterator();
						while (it.hasNext() && !found) {
							o2 = it.next();
							
							if (o2.getId()==rs.getLong(1)) {
								found=true;
								ids.add(rs.getLong(1));
//								System.out.println();
							}
							
//							System.out.println("--: " + o.getId());
						}
						if (!found) {
							idsRemove.add(rs.getLong(1));
						}
						found=false;
					}
					found=false;//a scanso di ogni equivoco, lo setto a false
					
					String fields2=allMapperEnums(myDTO);
					if (fields2.length()>0)
					for (String s : fields2.split(", ")) {
						Field f = retrieveField(s, innerClass2);
						
						//lo rendo accessibile
						f.setAccessible(true);
						
//						valueList+=extractColumn(s, o,null) + "=";
						
						String atomicClassName = f.getType().getSimpleName().toLowerCase();
//						String column = DAO.getColumn(it, o.getClass());
//						if (f.getType().isEnum()){
						StringBuilderQuery myQuery;
							switch(atomicClassName){
							case "stato":
								found=true;
								
								 myQuery= new StringBuilderQuery(updateQuery);
								myQuery.setField(1, mapperTable(myDTO));
//								myQuery.setField(2, s.getValue() + "=" + Stato.fromName(Stato.Archiviato));
//								myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
								
								DAO.printToConsole1(myQuery);
								getConnection().createStatement().executeUpdate(myQuery.toString());

								
								break;
//							case "textalign":
//								found=true;
//								
//								 myQuery= new StringBuilderQuery(updateQuery);
//								myQuery.setField(1, mapperTable(o2));
//								myQuery.setField(2, s + "=" + TextAlign.fromName((TextAlign) f.get(o2)));
//								myQuery.setField(3, "id =" + o2.getId());
//								
//								getConnection().createStatement1().execute1Update(myQuery.toString());
//								
//								
//								break;
							default:
								break;
							}
						
					}
					
//					System.out.print("");
					if (!found){
						for (Long ident : idsRemove) {
							StringBuilderQuery myQuery= new StringBuilderQuery(deleteQuery);
							myQuery.setField(1, mapperTable(myDTO));
							myQuery.setField(2, "id =" + ident);
							DAO.printToConsole1(myQuery);
							getConnection().createStatement().executeUpdate(myQuery.toString());
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				
//				for (DTOBase dto : arrayList) {
//					
//				}
			}
			
			
			
			
//			if (arrayList!= null && arrayList.size()>0) {
//				DTOBase swapElem = arrayList.get(0);
//				
//				try {
//					statement = getConnection().createStatement1();
////					statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//					rs = statement.executeQuery(mySubQuery.toString());
//					
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
			
			
			
			
			
//			try {
//				if (rs!=null) {
//					boolean found=false;
//					DTOBase o2=null;
//					Iterator<DTOBase> it = null;
					
//				while (rs.next()) {
					
					
////					System.out.println(rs.getLong(relation[1].column) + ":--");
//					it = arrayList.iterator();
//					while (it.hasNext() && !found) {
//						o2 = it.next();
//						
//						if (o2.getId()==rs.getLong(1)) {
//							found=true;
//							ids.add(rs.getLong(1));
////							System.out.println();
//						}
//						
////						System.out.println("--: " + o.getId());
//					}
//					if (!found) {
//						idsRemove.add(rs.getLong(1));
//					}
//					found=false;
					
					
					
////					idsRemove.add(e)
//					System.out.print("");
//					Iterator<DTOBase> it = arrayList.iterator();
//					
//					while (it.hasNext() && !found) {
////					for (DTOBase o : arrayList) {
//						o = it.next();
//						if (rs.getLong(relation[1].column)==o.getId()) {
//							ids.add(rs.getLong(1));
//							found=true;
//						}
//					}
//					if (!found)
//						idsRemove.add(rs.getLong(1));
//				}
				
				
//				found=false;//a scanso di ogni equivoco, lo setto a false
//				
//				String fields2=allMapperEnums(o2);
//				if (fields2.length()>0)
//				for (String s : fields2.split(", ")) {
//					Field f = retrieveField(s, o2.getClass());
//					
//					//lo rendo accessibile
//					f.setAccessible(true);
//					
////					valueList+=extractColumn(s, o,null) + "=";
//					
//					String atomicClassName = f.getType().getSimpleName().toLowerCase();
////					String column = DAO.getColumn(it, o.getClass());
////					if (f.getType().isEnum()){
//					StringBuilderQuery myQuery;
//						switch(atomicClassName){
//						case "stato":
//							found=true;
//							
//							 myQuery= new StringBuilderQuery(updateQuery);
//							myQuery.setField(1, mapperTable(o2));
////							myQuery.setField(2, s.getValue() + "=" + Stato.fromName(Stato.Archiviato));
////							myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
//							
//							getConnection().createStatement1().execute1Update(myQuery.toString());
//							
//							
//							break;
////						case "textalign":
////							found=true;
////							
////							 myQuery= new StringBuilderQuery(updateQuery);
////							myQuery.setField(1, mapperTable(o2));
////							myQuery.setField(2, s + "=" + TextAlign.fromName((TextAlign) f.get(o2)));
////							myQuery.setField(3, "id =" + o2.getId());
////							
////							getConnection().createStatement1().execute1Update(myQuery.toString());
////							
////							
////							break;
//						default:
//							break;
//						}
//					
//				}
//				
//				System.out.print("");
//				if (!found){
//					for (Long ident : idsRemove) {
//						StringBuilderQuery myQuery= new StringBuilderQuery(deleteQuery);
//						myQuery.setField(1, mapperTable(o2));
//						myQuery.setField(2, "id =" + ident);
//						getConnection().createStatement1().execute1Update(myQuery.toString());
//					}
//				}
				
//				}
			
			
			
			
//			StringBuilderQuery mySubQuery= new StringBuilderQuery(readQuery);
//			mySubQuery.setField(1, "id");
////			mySubQuery.setField(2, relation[0].table);
//			mySubQuery.setField(3, fatherColumn + "=" + id);// + " and " + relation[1].column + "=" + o.getId());
			
			
			
			
//			
//			for (DTOBase o : arrayList) {
//				
//				//effettuare la pulizia degli elementi eliminati dalla lista
//				StringBuilderQuery fullQuery=null;
//				String fields=allMapperFields(o);
//				String columnList="";
//				String valueList="";
//				try {
//				if (o.getId()>0) {
//					fullQuery = new StringBuilderQuery(updateQuery);
//					fullQuery.setField(1, mapperTable(o));
//					
//					if (fields.length()>0)
//					for (String s : fields.split(", ")) {
//						Field f = retrieveField(s, o.getClass());
//						
//						//lo rendo accessibile
//						f.setAccessible(true);
//						
//						valueList+=extractColumn(s, o,null) + "=";
//						
//						String atomicClassName = f.getType().getSimpleName().toLowerCase();
////						String column = DAO.getColumn(it, o.getClass());
//						if (f.getType().isEnum()){
//							switch(atomicClassName){
//							case "stato":
//									valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////								f.set(o, Stato.fromValue(rs.getInt(column)));
//								break;
//							case "tipoazienda":
//								valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//								break;
//							case "movimentazione":
//								valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//								break;
//							case "textalign":
//								valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
//								break;
//							case "idcampo":
//								valueList+= IDCampo.fromName((IDCampo) f.get(o)) + ", ";
////								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//								break;
//							default:
//								break;
//							}
//						}
//						else{
//							switch(atomicClassName){
//							case "string"1:
//								valueList+= "'" + f.get(o) + "', ";
////								f.set(o, rs.getString(column));
//								break;
//							case "long":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							case "int":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							case "boolean":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							case "float":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							case "double":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							default:
////								System.out.print("");
////								System.out.print("");
//								break;
//							}
//						}
////						columnList=columnList.substring(0,columnList.length()-2);
////						valueList=valueList.substring(0,valueList.length()-2);
//						
//					}
//					
//					fields=allMapperSubs(o);
//					if (fields.length()>0)
//						for (String s : fields.split(", ")) {
//							Field f = retrieveField(s, o.getClass());
//							
//							//lo rendo accessibile
//							f.setAccessible(true);
//							
//							valueList+=extractColumn(s, o,null) + "=";
//							
//							
//							try{
//							valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//							}
//							catch(NullPointerException e){
//								valueList+= " NULL , ";
//							}
//							
//						}
//					
//					valueList=valueList.substring(0,valueList.length()-2);
//					fullQuery.setField(2, valueList);
//					fullQuery.setField(3, "id=" + o.getId());
//					try {
//						statement = getConnection().createStatement1();
////						statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//						statement.execute1Update(fullQuery.toString());
////						,Statement.RETURN_GENERATED_KEYS);
////						ResultSet rs = statement.getGeneratedKeys();
////						rs.next();
////						o.setId(rs.getLong(1));
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					fields=allMapperLists(o);
//					if (fields.length()>0)
//						for (String s : fields.split(", ")) {
//							Field f = retrieveField(s, o.getClass());
//							
//							//lo rendo accessibile
//							f.setAccessible(true);
//							
//							
////							StringBuilderQuery subQueries = new StringBuilderQuery(extractSubQueries((ArrayList<DTOBase>) f.get(o)));
//							
//				            Type type = f.getGenericType();
//	
//			                ParameterizedType pType = (ParameterizedType)type;
//			                Type[] arr = pType.getActualTypeArguments();
//			                Class<?> innerClass = (Class<?>) arr[0];
//			                
//							String myColumn=extractFather(innerClass);
//							subUpdateNew((ArrayList<DTOBase>) f.get(o), myColumn, o.getId());
//							
//							
//							
//						}
//				}else {
//					fullQuery = new StringBuilderQuery(createQuery);
//					fullQuery.setField(1, mapperTable(o));
//					columnList=innerClass2 + ", ";
//					valueList=id + ", ";
//					
//					if (fields.length()>0)
//					for (String s : fields.split(", ")) {
//						Field f = retrieveField(s, o.getClass());
//						
//						//lo rendo accessibile
//						f.setAccessible(true);
//						
//						columnList+=extractColumn(s, o,null) + ", ";
//						
//						String atomicClassName = f.getType().getSimpleName().toLowerCase();
////						String column = DAO.getColumn(it, o.getClass());
//						if (f.getType().isEnum()){
//							switch(atomicClassName){
//							case "stato":
//									valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////								f.set(o, Stato.fromValue(rs.getInt(column)));
//								break;
//							case "tipoazienda":
//								valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//								break;
//							case "movimentazione":
//								valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//								break;
//							case "textalign":
//								valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
//								break;
//							case "idcampo":
//								valueList+= IDCampo.fromName((IDCampo) f.get(o)) + ", ";
////								value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//								break;
//							default:
//								break;
//							}
//						}
//						else{
//							switch(atomicClassName){
//							case "string"1:
//								valueList+= "'" + f.get(o) + "', ";
////								f.set(o, rs.getString(column));
//								break;
//							case "long":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							case "int":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							case "boolean":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							case "float":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							case "double":
//								valueList+= "" + f.get(o) + ", ";
//								break;
//							default:
//								System.out.print("");
////								System.out.print("");
//								break;
//							}
//						}
////						columnList=columnList.substring(0,columnList.length()-2);
////						valueList=valueList.substring(0,valueList.length()-2);
//						
//					}
//					
//					fields=allMapperSubs(o);
//					if (fields.length()>0)
//						for (String s : fields.split(", ")) {
//							Field f = retrieveField(s, o.getClass());
//							
//							//lo rendo accessibile
//							f.setAccessible(true);
//							
//							columnList+=extractColumn(s, o,null) + ", ";
//							
//							
//							try{
//							valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//							}
//							catch(NullPointerException e){
//								valueList+= " NULL , ";
//							}
//							
//						}
//					
//					columnList=columnList.substring(0,columnList.length()-2);
//					valueList=valueList.substring(0,valueList.length()-2);
//					
//					fullQuery.setField(2, columnList);
//					fullQuery.setField(3, valueList);
//					
//					
//					try {
//						statement = getConnection().createStatement1();
////						statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//						statement.execute1Update(fullQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//						rs = statement.getGeneratedKeys();
//						rs.next();
//						o.setId(rs.getLong(1));
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					
//					fields=allMapperLists(o);
//					if (fields.length()>0)
//						for (String s : fields.split(", ")) {
//							Field f = retrieveField(s, o.getClass());
//							
//							//lo rendo accessibile
//							f.setAccessible(true);
//							
//							
////							StringBuilderQuery subQueries = new StringBuilderQuery(extractSubQueries((ArrayList<DTOBase>) f.get(o)));
//							
//				            Type type = f.getGenericType();
//	
//			                ParameterizedType pType = (ParameterizedType)type;
//			                Type[] arr = pType.getActualTypeArguments();
//			                Class<?> innerClass = (Class<?>) arr[0];
//			                
//							String myColumn=extractFather(innerClass);
//							subCreateNew((ArrayList<DTOBase>) f.get(o), myColumn, o.getId());
//							
//							
//							
//						}
//				}
//				
//					
//					
//					
//					
//					
//					
//					
//					
//					
//					
////					daoMemory.get(o.getClass()).put(o.getId(), o);
//					
//	/********************************************************************************/			
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				}
//			}
//			catch(Exception ex) {}
		}
			
			
			
			
			
		public static void deleteNew(DTOBase o) {
			
			String fields="";
			StringBuilderQuery fullQuery=null;
//			StringBuilderQuery fullDeleteQuery = new StringBuilderQuery(deleteQuery);
//			StringBuilderQuery fullUpdateQuery = new StringBuilderQuery(updateQuery);
			
//			fullDeleteQuery.setField(1, mapperTable(o));
//			fullUpdateQuery.setField(1, mapperTable(o));
			
/********************************************************************************/			
			
			//ricavare l'elenco degli attributi
			String columnList="";
			String valueList="";
			
//			boolean found=false;
			
			try {
				fields=allMapperEnums(o);
				if (fields.length()>0)
				for (String s : fields.split(", ")) {
					Field f = retrieveField(s, o.getClass());
					
					//lo rendo accessibile
					f.setAccessible(true);
					
					columnList=extractColumn(s, o,null) + ", ";
					
					String atomicClassName = f.getType().getSimpleName().toLowerCase();
//					String column = DAO.getColumn(it, o.getClass());
//					if (f.getType().isEnum()){
						switch(atomicClassName){
						case "stato":
								valueList= Stato.fromName(Stato.Archiviato) + ", ";
//							f.set(o, Stato.fromValue(rs.getInt(column)));
							break;
//						case "tipoazienda":
//							valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//							break;
//						case "movimentazione":
//							valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//							break;
//						case "textalign":
//							valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
//							break;
//						case "idcampo":
//							valueList+= IDCampo.fromName((IDCampo) f.get(o)) + ", ";
////							value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
//							break;
						default:
							break;
						}
				}
				
//				valueList="";
				
				if (valueList.length()==0) {
					//effettuare la cancellazione
					fullQuery= new StringBuilderQuery(deleteQuery);
					fullQuery.setField(1, mapperTable(o));
					fullQuery.setField(2, "id=" + o.getId());
					DAO.printToConsole1(fullQuery);
				}
				else {
					//effettuare l'update
					
					fullQuery= new StringBuilderQuery(updateQuery);
					fullQuery.setField(1, mapperTable(o));
					columnList=columnList.substring(0,columnList.length()-2);
					valueList=valueList.substring(0,valueList.length()-2);
					fullQuery.setField(2, columnList + "=" + valueList);
					fullQuery.setField(3, "id=" + o.getId());
					DAO.printToConsole1(fullQuery);
					
				}
				
				
//				fullDeleteQuery.setField(2, columnList);
//				fullDeleteQuery.setField(3, valueList);

				
				
				try {
					statement = getConnection().createStatement();
					statement.executeUpdate(fullQuery.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					RCMException.showException(e1);
				}
				
				
				
				
				daoMemory.get(o.getClass()).remove(o.getId());
//				daoMemory.get(o.getClass()).put(o.getId(), o);
				
/********************************************************************************/			
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				RCMException.showException(e);
			}
		}
		
		
		
		
		public static void createNew(DTOBase o) {
			
			String fields="";
			StringBuilderQuery fullQuery = new StringBuilderQuery(createQuery);
			
			fullQuery.setField(1, mapperTable(o));
			
/********************************************************************************/			
			
			//ricavare l'elenco degli attributi
			String columnList="";
			String valueList="";
			
			
			
			try {
				fields=allMapperEnums(o);
				if (fields.length()>0)
				for (String s : fields.split(", ")) {
					Field f = retrieveField(s, o.getClass());
					
					//lo rendo accessibile
					f.setAccessible(true);
					
					columnList+=extractColumn(s, o,null) + ", ";
					
					String atomicClassName = f.getType().getSimpleName().toLowerCase();
//					String column = DAO.getColumn(it, o.getClass());
//					if (f.getType().isEnum()){
						switch(atomicClassName){
						case "stato":
								valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
//							f.set(o, Stato.fromValue(rs.getInt(column)));
							break;
						case "tipoazienda":
							valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
							break;
						case "movimentazione":
							valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
							break;
						case "textalign":
							valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
							break;
						case "idcampo":
							valueList+= IDCampo.fromName((IDCampo) f.get(o)) + ", ";
//							value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
							break;
						default:
							break;
						}
//					}
//					else{
//						switch(atomicClassName){
//						case "string"1:
//							valueList+= "'" + f.get(o) + "', ";
////							f.set(o, rs.getString(column));
//							break;
//						case "long":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						case "int":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						case "boolean":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						case "float":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						case "double":
//							valueList+= "" + f.get(o) + ", ";
//							break;
//						default:
//							System.out.print("");
////							System.out.print("");
//							break;
//						}
//					}
//					columnList=columnList.substring(0,columnList.length()-2);
//					valueList=valueList.substring(0,valueList.length()-2);
					
				}
				fields=allMapperFields(o);
				if (fields.length()>0)
				for (String s : fields.split(", ")) {
					Field f = retrieveField(s, o.getClass());
					
					//lo rendo accessibile
					f.setAccessible(true);
					
					columnList+=extractColumn(s, o,null) + ", ";
					
					String atomicClassName = f.getType().getSimpleName().toLowerCase();
//					String column = DAO.getColumn(it, o.getClass());
//					if (f.getType().isEnum()){
//						switch(atomicClassName){
//						case "stato":
//								valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////							f.set(o, Stato.fromValue(rs.getInt(column)));
//							break;
//						case "tipoazienda":
//							valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//							break;
//						case "movimentazione":
//							valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//							break;
//						default:
//							break;
//						}
//					}
//					else{
						switch(atomicClassName){
						case "string":
							String txt = (String) f.get(o);
							if (txt!=null) {
								txt=txt.replaceAll("'", "\'");
								txt=txt.replaceAll("|", "");
							}
							valueList+= "'" + txt + "', ";
//							f.set(o, rs.getString(column));
							break;
						case "long":
							valueList+= "" + f.get(o) + ", ";
							break;
						case "int":
							valueList+= "" + f.get(o) + ", ";
							break;
						case "boolean":
							valueList+= "" + f.get(o) + ", ";
							break;
						case "float":
							valueList+= "" + f.get(o) + ", ";
							break;
						case "double":
							valueList+= "" + f.get(o) + ", ";
							break;
						default:
							System.out.print("");
//							System.out.print("");
							break;
						}
//					}
//					columnList=columnList.substring(0,columnList.length()-2);
//					valueList=valueList.substring(0,valueList.length()-2);
					
				}
				
				fields=allMapperSubs(o);
				if (fields.length()>0)
					for (String s : fields.split(", ")) {
						Field f = retrieveField(s, o.getClass());
						
						//lo rendo accessibile
						f.setAccessible(true);
						
						columnList+=extractColumn(s, o,null) + ", ";
						
						
						try{
						valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
						}
						catch(NullPointerException e){
							valueList+= " NULL , ";
						}
						
					}
				
				
				
				if (hasDiscriminator(o)) {
					columnList+=extractDiscriminatorColumn(o) + ", ";
					valueList+=extractDiscriminatorValue(o) + ", ";
				}
				
				columnList=columnList.substring(0,columnList.length()-2);
				valueList=valueList.substring(0,valueList.length()-2);
				
				fullQuery.setField(2, columnList);
				fullQuery.setField(3, valueList);

				
				
				try {
					statement = getConnection().createStatement();
					DAO.printToConsole1(fullQuery);
					statement.executeUpdate(fullQuery.toString(),Statement.RETURN_GENERATED_KEYS);
					ResultSet rs = statement.getGeneratedKeys();
					rs.next();
					o.setId(rs.getLong(1));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					RCMException.showException(e1);
				}
				
				
				
				
				fields=allMapperLists(o);
				if (fields.length()>0)
					for (String s : fields.split(", ")) {
						Field f = retrieveField(s, o.getClass());
						
						//lo rendo accessibile
						f.setAccessible(true);
						
						
//						StringBuilderQuery subQueries = new StringBuilderQuery(extractSubQueries((ArrayList<DTOBase>) f.get(o)));
						
			            Type type = f.getGenericType();

		                ParameterizedType pType = (ParameterizedType)type;
		                Type[] arr = pType.getActualTypeArguments();
		                Class<?> innerClass = (Class<?>) arr[0];
		                DTOBase swapSubElement=null;
						try {
							swapSubElement = (DTOBase) innerClass.newInstance();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							RCMException.showException(e);
						}
		                
						MToM[] relation = getManyToMany(swapSubElement, o);
						
						
						
						if (relation!=null) {
//							gestire le liste con i many to many
//							mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
//							mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
//							mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + o.getId());
							subCreateMToM((ArrayList<DTOBase>) f.get(o), relation, o.getId());
						}
						else {
							String myColumn=extractFather(innerClass);
							if (s.equals("testo"))
								System.out.print("");
							subCreateNew((ArrayList<DTOBase>) f.get(o), myColumn, o.getId());
						}
	                
		                
		                
						
						
						
		                
		                
//		                ArrayList<DTOBase> list = (ArrayList<DTOBase>) f.get(o);

						
//						for (DTOBase subElementInList : (ArrayList<DTOBase>) f.get(o)) {
//							Field f2 = retrieveField(s, o.getClass());
//							
//							
//						}
						
						
//						for (f.get)
//							f.set(o, rs.getString(myColumn));
						
						
						
						
//						try{
//						valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//						}
//						catch(NullPointerException e){
//							valueList+= " NULL , ";
//						}
						
					}
				
				
				
				
				
				
				
				
				
				daoMemory.get(o.getClass()).put(o.getId(), o);
				
/********************************************************************************/			
//			
//			for (String it: DAO.getAllFields(o.getClass()).split(", ")){
//				//ricavo l'attributo sulla base del nome
//				Field f = retrieveField(it, o.getClass());
//				//lo rendo accessibile
//				f.setAccessible(true);
////				System.out.println();
//				
//				
//				if (!List.class.isAssignableFrom(f.getType())){
//					//e lo vado ad avvalorare
//					//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
//					String column = DAO.getColumn(it, o.getClass());
//					
//					columnList+=column + ", ";
//					
////				if (f.getType() instanceof ArrayList<?>){
//					if (!DTOBase.class.isAssignableFrom(f.getType())){
////						if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
//							//valuta attributo atomico
//							String atomicClassName = f.getType().getSimpleName().toLowerCase();
////							String column = DAO.getColumn(it, o.getClass());
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//										valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////									f.set(o, Stato.fromValue(rs.getInt(column)));
//									break;
//								case "tipoazienda":
//									valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//									break;
//								case "movimentazione":
//									valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//									break;
//								default:
//									break;
//								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//									valueList+= "'" + f.get(o) + "', ";
////									f.set(o, rs.getString(column));
//									break;
//								case "long":
////									f.set(o, rs.getLong(column));
//									break;
//								case "int":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								case "boolean":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								case "float":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								case "double":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								default:
//									break;
//								}
//							}
//						}
//						else{
//							//caricare i campi "filtrati" del sottotipo
//							//si tratta di un oggetto di cui devo ricavare solo l'ID
//							try{
//							valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//							}
//							catch(NullPointerException e){
//								valueList+= " NULL , ";
//							}
////							HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////							f.set(o, subElements.get(rs.getLong(column)));
//						}
//				}
//				else{
//					//gestire gli array
//					@SuppressWarnings("unused")
//					StringBuilderQuery subQuery = new StringBuilderQuery(createQuery);
//					
//					ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(o);
//					
//		            Type type = f.getGenericType();
//
//		            if (type instanceof ParameterizedType) {
//
//		                ParameterizedType pType = (ParameterizedType)type;
//		                Type[] arr = pType.getActualTypeArguments();
//		                Class<?> innerClass = (Class<?>) arr[0];
//		                
//		                
//		                String externalKey = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//		                
////		                Entry<String, String> entries = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator().next();
//		                Iterator<Entry<String, String>> entries =fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets.entrySet().iterator();
//		                
//		                
////		        		String table=fieldMapper.get(innerClass.getSimpleName().toLowerCase()).getTarget().targetTable;
//		        		
//		                
//		                if (externalKey!=null){
//			        		for (DTOBase elem: lista){
//			        			
////			        			subQueries.addAll(extractSubQueries(elem));
//			        			
//			        			HashMap lista2 = newSubQueries.get(o);
//		        				Object partial = extractCreateSubQueries(elem);
//		        				
//		        				if (partial instanceof StringBuilderQuery){
//		        					((StringBuilderQuery) partial).replaceAll("__", externalKey);
//		        				}
////				        		for (StringBuilderQuery subs : partial){
////									subs.replaceAll("__", externalKey);
////				        		}
//			        			try{
////				        			lista2.addAll(partial);
//				        			lista2.put(elem, partial);
////				        			newSubQueries.put(o, lista2);
//			        			}
//			        			catch(Exception e){
//			        				lista2 = new HashMap<>();
//				        			lista2.put(elem, partial);
//				        			newSubQueries.put(o, lista2);
//			        			}
//			        			
//			        			
//			        			
////			        			newSubQueries.put(elem, extractSubQueries(elem));
//			        			
//			        			
////				        		subQuery.setTable(1, fieldMapper.get(innerClass.getSimpleName().toLowerCase()).tableName);
////
////				        		String subColumns = externalKey + ", ";// + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
////				        		
////								for (String subIt: DAO.getAllFields(f.getType()).split(", ")){
////									
////								}
//				        		
////				        		subQuery.setField(2, subColumns);
////				        		
////				        		String subValues = "";
//////				        		for (DTOBase elem: lista){
////				        			subValues += elem.getId() + ", ??";
//////				        		subValues=subValues.substring(0, subValues.length()-4);
//////				        		String subValues = o.getId() + ", ??";
//////				        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
////				        		
////				        		subQuery.setField(3, subValues);
////				        		subQueries.add(subQuery);
////				        		subQuery = new StringBuilderQuery(createQuery);
//				        		}
//			        		
//			        		
//			        		
//////			        		for (StringBuilderQuery subs : subQueries){
//////								subs.replaceAll("__", externalKey);
//////			        		}
////							for (Object subs : newSubQueries.values()){
////								if (subs instanceof StringBuilderQuery)
////									((StringBuilderQuery)subs).replaceAll("__", externalKey);
////							}
//			        		
//			        		
//		                	
//		                }else{
//		                	Entry<String, String> iter=entries.next();
//		                	
//		                	HashMap<String, String> trgt = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets;
//			                String key= iter.getKey();
//		                	while (!trgt.containsKey(key)){
//		                		iter=entries.next();
//		                		key= iter.getKey();
//		                	}
//		                	
//			                String value=iter.getValue();
//			        		for (DTOBase elem: lista){
//				        		subQuery.setTable(1, key);
//				        		
//				        		String subColumns = value + ", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.get(key);
//				        		subQuery.setField(2, subColumns);
//				        		
//				        		String subValues = "";
////				        		for (DTOBase elem: lista){
//				        			subValues += elem.getId() + ", ??";
////				        		subValues=subValues.substring(0, subValues.length()-4);
////				        		String subValues = o.getId() + ", ??";
////				        		fieldMapper.get(o.getClass().getSimpleName().toLowerCase());
//				        		
//				        		subQuery.setField(3, subValues);
//////				        		subQueries.add(subQuery);
////				        		newSubQueries.put(subQuery, null);
//				        		HashMap<DTOBase, StringBuilderQuery> sbQuery = newSubQueries.get(o);
//			        			try{
////				        			lista2.addAll(partial);
//			        				sbQuery.put(elem, subQuery);
////				        			newSubQueries.put(o, lista2);
//			        			}
//			        			catch(Exception e){
//			        				sbQuery = new HashMap<>();
//			        				sbQuery.put(elem, subQuery);
//				        			newSubQueries.put(o, sbQuery);
//			        			}
//				        		subQuery = new StringBuilderQuery(createQuery);
//				        		}
//		                }
//		                
////		        		System.out.println();
////		        		System.out.println();
////		        		System.out.println();
//		        		
////		        		if (column==null){
////		        			column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).fieldList.get(it);
////		        			if (column==null){
////		        				column=fieldMapper.get(myClass.getSimpleName().toLowerCase()).coupleId.column;
////		        			}
////		        		}
//////		                for (Type tp: arr) {
//////		                    Class<?> clzz = (Class<?>)tp;
//////		                    System.out.println(clzz.getName());
//////		                }
//		            }
//					
//				}
//				
//			}
//			
//			columnList=columnList.substring(0,columnList.length()-2);
////			System.out.println();
//			valueList=valueList.substring(0,valueList.length()-2);
//			
//			
//			if (fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator()!=null){
//				columnList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorColumn();
//				valueList+=", " + fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).getDiscriminator().getDiscriminatorValue();
//			}
//			
//			
//			
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				RCMException.showException(e);
			}
//			
//			
//			
//			StringBuilderQuery myQuery=new StringBuilderQuery(createQuery);
//			
//			myQuery.setTable(1, getTable(o));
////			myQuery.setField(2, getColumns(o));
////			myQuery.setField(3, getValues(o));
//			myQuery.setField(2, columnList);
//			myQuery.setField(3, valueList);
//			
//			
//			
//			
//			try {
//				statement = getConnection().createStatement1();
////				statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//				statement.execute1Update(myQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//				ResultSet rs = statement.getGeneratedKeys();
//				rs.next();
//				o.setId(rs.getLong(1));
//				
////				for (StringBuilderQuery subs : subQueries){
////					subs.replaceAll("??", o.getId());
////					statement.execute1Update(subs.toString());
////				}
//				
//				HashMap<DTOBase, StringBuilderQuery> firstPass = newSubQueries.get(o);
//				if (firstPass!=null){
//					newSubQueries.remove(o);
//					for (DTOBase subKey : firstPass.keySet()){
//						StringBuilderQuery subElementQuery = firstPass.get(subKey);
//						subElementQuery.replaceAll("??", o.getId());
//						
//						if (newSubQueries.containsKey(subKey)){
//							statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//							ResultSet rs2 = statement.getGeneratedKeys();
//							rs2.next();
//							subKey.setId(rs2.getLong(1));
//						}
//						else{
//							statement.execute1Update(subElementQuery.toString());
//						}
//						
//						
//					}
//				}
//				
//				
//				
//				for (DTOBase subs : newSubQueries.keySet()){
//					HashMap<DTOBase, StringBuilderQuery> subElement = newSubQueries.get(subs);
//					
//					for (DTOBase subKey : subElement.keySet()){
//						StringBuilderQuery subElementQuery = subElement.get(subKey);
//						subElementQuery.replaceAll("??", subs.getId());
//						
//						if (newSubQueries.containsKey(subKey)){
//							statement.execute1Update(subElementQuery.toString(),Statement.RETURN_GENERATED_KEYS);
//							ResultSet rs2 = statement.getGeneratedKeys();
//							rs2.next();
//							subKey.setId(rs2.getLong(1));
//						}
//						else{
//							statement.execute1Update(subElementQuery.toString());
//						}
//						
//						
//					}
//					
//					
////					if (subs instanceof StringBuilderQuery){
////						((StringBuilderQuery) subs).replaceAll("??", o.getId());
////						statement.execute1Update(subs.toString());
////					}
//				}
//				
//				
//				
//				
////				statement.execute1Update(o.getSubQuery());
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			newSubQueries=new HashMap<>();
////			try{
////				statement = getConnection().createStatement1();
////				
////				StringBuilderQuery query = new StringBuilderQuery(createQuery);//"insert into ? (?) values (?);"
////				query.setTable(1, extractTable(o));
////				query.setTable(2, extractOnlyFields(o));
////				query.setTable(3, extractFieldValues(o));
////	//			query.setTable(1, getTable());
////	////			query.append(getTable());
////	//			query.setValue(2, getId());
////	////			query.append(getId());
////	//					
////	//			return query.toString();
////				
////				
////				
//////				statement.execute1Update(getAllFields(o),Statement.RETURN_GENERATED_KEYS);
////				statement.execute1Update(query.toString(),Statement.RETURN_GENERATED_KEYS);
////				ResultSet rs = statement.getGeneratedKeys();
////				rs.next();
////				o.setId(rs.getLong(1));
////			}
////			catch (SQLException | NullPointerException e) {
////				e.printStackTrace();
////			} 
		}
		private static void subCreateMToM(ArrayList<DTOBase> arrayList, MToM[] relation, long id) {
			// TODO Auto-generated method stub
			
//			StringBuilderQuery mySubQuery=new StringBuilderQuery(createQuery);
			for (DTOBase o : arrayList) {
				
				StringBuilderQuery mySubQuery=new StringBuilderQuery(createQuery);
				mySubQuery.setField(1, relation[0].table);
				mySubQuery.setField(2, relation[0].column + ", " +relation[1].column );
				mySubQuery.setField(3, id + ", " +o.getId() );
				
				
				try {
					statement = getConnection().createStatement();
//					statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
					DAO.printToConsole1(mySubQuery);
					statement.executeUpdate(mySubQuery.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					RCMException.showException(e1);
				}
				
//				System.out.println();
			}
			
//			Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
//			DTOBase swapSubElement = (DTOBase) type.newInstance();
//			
//			MToM[] relation = getManyToMany(swapSubElement, item);
//			
//			
//			
//			if (relation!=null) {
////				gestire le liste con i many to many
//				mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
//				mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
//				mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + item.getId());
//			System.out.println();
			
		}
		private static void subUpdateMToM(ArrayList<DTOBase> arrayList, MToM[] relation, long id) {
			// TODO Auto-generated method stub
			
//			StringBuilderQuery mySubQuery=new StringBuilderQuery(createQuery);
			ArrayList<Long> ids=new ArrayList<>();
			ArrayList<Long> idsRemove=new ArrayList<>();
			ArrayList<DTOBase> arrayListToRemove = new ArrayList<>();
			
			StringBuilderQuery mySubQuery= new StringBuilderQuery(readQuery);
			ResultSet rs = null;
			DTOBase o=null;
			if (arrayList!= null && arrayList.size()>0) {
				o=arrayList.get(0);
			mySubQuery.setField(1, "id, " + relation[1].column);
			mySubQuery.setField(2, relation[0].table);
			mySubQuery.setField(3, relation[0].column + "=" + id);// + " and " + relation[1].column + "=" + o.getId());
			
			
			
			try {
				
				
				
				
				
				statement = getConnection().createStatement();
//				statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
				DAO.printToConsole1(mySubQuery);
				rs = statement.executeQuery(mySubQuery.toString());
				
			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				RCMException.showException(e1);
			try {
				o=arrayList.get(0);
				mySubQuery= new StringBuilderQuery(readQuery);
			mySubQuery.setField(1, relation[1].column);
			mySubQuery.setField(2, relation[0].table);
			mySubQuery.setField(3, relation[0].column + "=" + id);// + " and " + relation[1].column + "=" + o.getId());
				statement = getConnection().createStatement();
//				statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
				DAO.printToConsole1(mySubQuery);
				rs = statement.executeQuery(mySubQuery.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			}			
			
			try {
				if (rs!=null) {
				boolean found=false;
//				DTOBase o=null;
				Iterator<DTOBase> it = null;
				
			while (rs.next()) {
				
				
//				System.out.println(rs.getLong(relation[1].column) + ":--");
				it = arrayList.iterator();
				while (it.hasNext() && !found) {
					o = it.next();
					
					if (o.getId()==rs.getLong(relation[1].column)) {
						found=true;
						ids.add(rs.getLong(1));
						arrayListToRemove.add(o);
					}
					
//					System.out.println("--: " + o.getId());
				}
				if (!found) {
					idsRemove.add(rs.getLong(1));
				}
				found=false;
				
				
				
////				idsRemove.add(e)
//				System.out.print("");
//				Iterator<DTOBase> it = arrayList.iterator();
//				
//				while (it.hasNext() && !found) {
////				for (DTOBase o : arrayList) {
//					o = it.next();
//					if (rs.getLong(relation[1].column)==o.getId()) {
//						ids.add(rs.getLong(1));
//						found=true;
//					}
//				}
//				if (!found)
//					idsRemove.add(rs.getLong(1));
			}
			
			arrayList.removeAll(arrayListToRemove);
			
			
			found=false;//a scanso di ogni equivoco, lo setto a false
			
//			String fields=allMapperEnums(o);
//			if (fields.length()>0)
//			for (String s : fields.split(", ")) {
//				Field f = retrieveField(s, o.getClass());
//				
//				//lo rendo accessibile
//				f.setAccessible(true);
//				
//				String valueList=extractColumn(s, o,null);// + "=";
//				
//				String atomicClassName = f.getType().getSimpleName().toLowerCase();
////				String column = DAO.getColumn(it, o.getClass());
////				if (f.getType().isEnum()){
//					switch(atomicClassName){
//					case "stato":
//						found=true;
//						
//						StringBuilderQuery myQuery= new StringBuilderQuery(updateQuery);
//						myQuery.setField(1, relation[0].table);
//						myQuery.setField(2, valueList + "=" + Stato.fromName(Stato.Archiviato));
//						myQuery.setField(3, "id=" + o.getId());
//						
//						getConnection().createStatement1().execute1Update(myQuery.toString());
//						
//						
////							valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////						f.set(o, Stato.fromValue(rs.getInt(column)));
//						break;
////					case "tipoazienda":
////						valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
////						break;
////					case "movimentazione":
////						valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
////						break;
//					default:
//						break;
//					}
//				
//			}
//			
//			System.out.print("");
			if (!found){
				for (Long ident : idsRemove) {
					StringBuilderQuery myQuery= new StringBuilderQuery(deleteQuery);
					myQuery.setField(1, relation[0].table);
					myQuery.setField(2, "id =" + ident);
					DAO.printToConsole1(myQuery);
					getConnection().createStatement().executeUpdate(myQuery.toString());

				}
//			myQuery.setField(2, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
//			System.out.println();
//			getConnection().createStatement1().execute1Update(myQuery.toString());
			}
				}
			
			
			
//			try {
//			HashMap<String, String> fields = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).fieldList;
//			StringBuilderQuery myQuery=null;
//			
////			if (fields.size()==0){
//			fields.putAll(fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).preloadFields);
//			
//			boolean found=false;
//			for (Entry<String, String> s : fields.entrySet()){
//				Field f = retrieveField(s.getKey(), o.getClass());
//				//lo rendo accessibile
//				f.setAccessible(true);
//				
//				if (f.getType().isEnum()){
//					
//					String atomicClassName = f.getType().getSimpleName().toLowerCase();
//					switch(atomicClassName){
//					case "stato":
//						found=true;
//						myQuery= new StringBuilderQuery(updateQuery);
//						myQuery.setField(1, getTable(o));
//						myQuery.setField(2, s.getValue() + "=" + Stato.fromName(Stato.Archiviato));
//						myQuery.setField(3, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
//						
//						getConnection().createStatement1().execute1Update(myQuery.toString());
//						
////						System.out.println();
////						f.set(o, Stato.fromValue(rs2.getInt(s.getValue())));
//						break;
//					default:
//						break;
//					}
//				}
//				
//			}
//			
//			
//			if (found==false){
//				myQuery= new StringBuilderQuery(deleteQuery);
//				myQuery.setField(1, getTable(o));
//				myQuery.setField(2, fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).coupleId.column + "=" + o.getId());
////				System.out.println();
//				getConnection().createStatement1().execute1Update(myQuery.toString());
//			}
//			
//			
////				statement = getConnection().createStatement1();
////				String s = o.getDeleteQuery();
////				statement.execute1(s);
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
			
			
			
			
			
			
			
			
			
			
//			for (DTOBase o : arrayList) {
//				
//				
//					boolean found=false;
////					while (rs.next() && !found) {
////						if (rs.getLong(relation[1].column)==o.getId()) {
////							ids+= rs.getString(1) + ", ";
////							found=true;
////						}
////					}
////					if (!found) {
////						idsRemove+= rs.getString(1) + ", ";
////					}
//					
//					
//					
//			}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					RCMException.showException(e1);
				}
				
				
				
				
				
				
//				System.out.println();
			
//			Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
//			DTOBase swapSubElement = (DTOBase) type.newInstance();
//			
//			MToM[] relation = getManyToMany(swapSubElement, item);
//			
//			
//			
//			if (relation!=null) {
////				gestire le liste con i many to many
//				mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
//				mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
//				mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + item.getId());
//			System.out.println();
			
		}

		private static void subCreateNew(ArrayList<DTOBase> arrayList, String fatherColumn, long id) {
			
			for (DTOBase o : arrayList) {
				
				StringBuilderQuery fullQuery = new StringBuilderQuery(createQuery);
				
				fullQuery.setField(1, mapperTable(o));
				//ricavare l'elenco degli attributi
				String columnList=fatherColumn + ", ";
				String valueList=id + ", ";
				
				
				
				try {
					String fields=allMapperEnums(o);
					if (fields.length()>0)
					for (String s : fields.split(", ")) {
						Field f = retrieveField(s, o.getClass());
						
						//lo rendo accessibile
						f.setAccessible(true);
						
						columnList+=extractColumn(s, o,null) + ", ";
						
						String atomicClassName = f.getType().getSimpleName().toLowerCase();
//						String column = DAO.getColumn(it, o.getClass());
						
//						if (f.get(o)==null) {
//							valueList+= " NULL , ";
//
//						}
//						else {
////							if (f.getType().isEnum()){
								switch(atomicClassName){
								case "stato":
//									valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
									valueList+= Stato.fromName(Stato.Attivo) + ", ";
////									f.set(o, Stato.fromValue(rs.getInt(column)));
									break;
								case "tipoazienda":
									valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
									break;
								case "movimentazione":
									valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
									break;
								case "textalign":
									valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
									break;
								case "idcampo":
									valueList+= IDCampo.fromName((IDCampo) f.get(o)) + ", ";
//									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
									break;
								default:
									break;
								}
////							}
////							else{
////								switch(atomicClassName){
////								case "string"1:
////									valueList+= "'" + f.get(o) + "', ";
//////									f.set(o, rs.getString(column));
////									break;
////								case "long":
////									valueList+= "" + f.get(o) + ", ";
////									break;
////								case "int":
////									valueList+= "" + f.get(o) + ", ";
////									break;
////								case "boolean":
////									valueList+= "" + f.get(o) + ", ";
////									break;
////								case "float":
////									valueList+= "" + f.get(o) + ", ";
////									break;
////								case "double":
////									valueList+= "" + f.get(o) + ", ";
////									break;
////								default:
////									System.out.print("");
//////									System.out.print("");
////									break;
////								}
////							}
////							columnList=columnList.substring(0,columnList.length()-2);
////							valueList=valueList.substring(0,valueList.length()-2);
//						}
						
						
						
					}
					fields=allMapperFields(o);
					if (fields.length()>0)
					for (String s : fields.split(", ")) {
						Field f = retrieveField(s, o.getClass());
						
						//lo rendo accessibile
						f.setAccessible(true);
						
						columnList+=extractColumn(s, o,null) + ", ";
						
						String atomicClassName = f.getType().getSimpleName().toLowerCase();
//						String column = DAO.getColumn(it, o.getClass());
						
						if (f.get(o)==null) {
							valueList+= " NULL , ";

						}
						else {
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//										valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////									f.set(o, Stato.fromValue(rs.getInt(column)));
//									break;
//								case "tipoazienda":
//									valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//									break;
//								case "movimentazione":
//									valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//									break;
//								case "textalign":
//									valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
//									break;
//								default:
//									break;
//								}
//							}
//							else{
								switch(atomicClassName){
								case "string":
									String txt = (String) f.get(o);
									if (txt!=null) {
										txt=txt.replaceAll("'", "\'");
										txt=txt.replaceAll("|", "");
									}
									valueList+= "'" + txt + "', ";
//									f.set(o, rs.getString(column));
									break;
								case "long":
									valueList+= "" + f.get(o) + ", ";
									break;
								case "int":
									valueList+= "" + f.get(o) + ", ";
									break;
								case "boolean":
									valueList+= "" + f.get(o) + ", ";
									break;
								case "float":
									valueList+= "" + f.get(o) + ", ";
									break;
								case "double":
									valueList+= "" + f.get(o) + ", ";
									break;
								default:
									System.out.print("");
//									System.out.print("");
									break;
								}
//							}
//							columnList=columnList.substring(0,columnList.length()-2);
//							valueList=valueList.substring(0,valueList.length()-2);
						}
						
						
						
					}
					
					fields=allMapperSubs(o);
					if (fields.length()>0)
						for (String s : fields.split(", ")) {
							Field f = retrieveField(s, o.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							columnList+=extractColumn(s, o,null) + ", ";
							
							
							try{
							valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
							}
							catch(NullPointerException e){
								valueList+= " NULL , ";
							}
							
						}
					
					columnList=columnList.substring(0,columnList.length()-2);
					valueList=valueList.substring(0,valueList.length()-2);
					
					fullQuery.setField(2, columnList);
					fullQuery.setField(3, valueList);
	
					
					
					try {
						statement = getConnection().createStatement();
						DAO.printToConsole1(fullQuery);

//						statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
						statement.executeUpdate(fullQuery.toString(),Statement.RETURN_GENERATED_KEYS);
						ResultSet rs = statement.getGeneratedKeys();
						rs.next();
						o.setId(rs.getLong(1));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						RCMException.showException(e1);
					}
					
					
					
					
					fields=allMapperLists(o);
					if (fields.length()>0)
						for (String s : fields.split(", ")) {
							Field f = retrieveField(s, o.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							
//							StringBuilderQuery subQueries = new StringBuilderQuery(extractSubQueries((ArrayList<DTOBase>) f.get(o)));
							
				            Type type = f.getGenericType();
	
			                ParameterizedType pType = (ParameterizedType)type;
			                Type[] arr = pType.getActualTypeArguments();
			                Class<?> innerClass = (Class<?>) arr[0];
			                
			                DTOBase swapSubElement=null;
							try {
								swapSubElement = (DTOBase) innerClass.newInstance();
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								RCMException.showException(e);
							}
			                
							MToM[] relation = getManyToMany(swapSubElement, o);
							
							
							
							if (relation!=null) {
//								gestire le liste con i many to many
//								mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
//								mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
//								mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + o.getId());
								subCreateMToM((ArrayList<DTOBase>) f.get(o), relation, o.getId());
							}
							else {
								String myColumn=extractFather(innerClass);
								subCreateNew((ArrayList<DTOBase>) f.get(o), myColumn, o.getId());
							}
//							String myColumn=extractFather(innerClass);
//							subCreateNew((ArrayList<DTOBase>) f.get(o), myColumn, o.getId());
							
							
							
			                
			                
////			                ArrayList<DTOBase> list = (ArrayList<DTOBase>) f.get(o);
//	
//							
//							for (DTOBase subElementInList : (ArrayList<DTOBase>) f.get(o)) {
//								Field f2 = retrieveField(s, o.getClass());
//								
//								
//							}
//							
//							
////							for (f.get)
////								f.set(o, rs.getString(myColumn));
//							
//							
//							
//							
//							try{
//							valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//							}
//							catch(NullPointerException e){
//								valueList+= " NULL , ";
//							}
							
						}
					
					
					
					
					
					
					
					
					
//					daoMemory.get(o.getClass()).put(o.getId(), o);
					
	/********************************************************************************/			
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
			}
			
/********************************************************************************/			
			
		}
	
		private static void subUpdateNew(ArrayList<DTOBase> arrayList, String fatherColumn, long id) {
			
			for (DTOBase o : arrayList) {
				
				StringBuilderQuery fullQuery = new StringBuilderQuery(updateQuery);
				
				fullQuery.setField(1, mapperTable(o));
				//ricavare l'elenco degli attributi
//				String columnList=fatherColumn + ", ";
				String valueList="";
//				=fatherColumn + "=" + id + ", ";
				
				
				
				try {
					String fields=allMapperEnums(o);
					if (fields.length()>0)
					for (String s : fields.split(", ")) {
						Field f = retrieveField(s, o.getClass());
						
						//lo rendo accessibile
						f.setAccessible(true);
						
//						columnList+=extractColumn(s, o,null) + ", ";
						valueList+=extractColumn(s, o,null) + "=";
						
						String atomicClassName = f.getType().getSimpleName().toLowerCase();
//						String column = DAO.getColumn(it, o.getClass());
						
						if (f.get(o)==null) {
							switch(atomicClassName){
							case "stato":
									valueList+= Stato.fromName(Stato.Attivo) + ", ";
//								f.set(o, Stato.fromValue(rs.getInt(column)));
								break;
							}
						}
						else {
//							if (f.getType().isEnum()){
								switch(atomicClassName){
								case "stato":
										valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
//									f.set(o, Stato.fromValue(rs.getInt(column)));
									break;
								case "tipoazienda":
									valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
									break;
								case "movimentazione":
									valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
									break;
								case "textalign":
									valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
									break;
								case "idcampo":
									valueList+= IDCampo.fromName((IDCampo) f.get(o)) + ", ";
//									value += "" + Movimentazione.fromName((Movimentazione) field.get(o)) + "";					
									break;
								default:
									break;
								}
//							}
//							else{
//								switch(atomicClassName){
//								case "string"1:
//									valueList+= "'" + f.get(o) + "', ";
//									if (valueList.contains("Titolo 2")) {
//										System.out.print("");
//									}
////									f.set(o, rs.getString(column));
//									break;
//								case "long":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								case "int":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								case "boolean":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								case "float":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								case "double":
//									valueList+= "" + f.get(o) + ", ";
//									break;
//								default:
////									System.out.print("");
////									System.out.print("");
//									break;
//								}
//							}
//							columnList=columnList.substring(0,columnList.length()-2);
//							valueList=valueList.substring(0,valueList.length()-2);
						}
						
						
						
					}
					fields=allMapperFields(o);
					if (fields.length()>0)
					for (String s : fields.split(", ")) {
						Field f = retrieveField(s, o.getClass());
						
						//lo rendo accessibile
						f.setAccessible(true);
						
//						columnList+=extractColumn(s, o,null) + ", ";
						valueList+=extractColumn(s, o,null) + "=";
						
						String atomicClassName = f.getType().getSimpleName().toLowerCase();
//						String column = DAO.getColumn(it, o.getClass());
						
						if (f.get(o)==null) {
							valueList+= " NULL , ";

						}
						else {
//							if (f.getType().isEnum()){
//								switch(atomicClassName){
//								case "stato":
//										valueList+= Stato.fromName((Stato) f.get(o)) + ", ";
////									f.set(o, Stato.fromValue(rs.getInt(column)));
//									break;
//								case "tipoazienda":
//									valueList+= TipoAzienda.fromName((TipoAzienda) f.get(o)) + ", ";
//									break;
//								case "movimentazione":
//									valueList+= Movimentazione.fromName((Movimentazione) f.get(o)) + ", ";
//									break;
//								case "textalign":
//									valueList+= TextAlign.fromName((TextAlign) f.get(o)) + ", ";
//									break;
//								default:
//									break;
//								}
//							}
//							else{
								switch(atomicClassName){
								case "string":
									String txt = (String) f.get(o);
									if (txt!=null) {
										txt=txt.replaceAll("'", "\'");
										txt=txt.replaceAll("|", "");
									}
									valueList+= "'" + txt + "', ";
//									if (valueList.contains("Titolo 2")) {
//										System.out.print("");
//									}
//									f.set(o, rs.getString(column));
									break;
								case "long":
									valueList+= "" + f.get(o) + ", ";
									break;
								case "int":
									valueList+= "" + f.get(o) + ", ";
									break;
								case "boolean":
									valueList+= "" + f.get(o) + ", ";
									break;
								case "float":
									valueList+= "" + f.get(o) + ", ";
									break;
								case "double":
									valueList+= "" + f.get(o) + ", ";
									break;
								default:
//									System.out.print("");
//									System.out.print("");
									break;
								}
//							}
//							columnList=columnList.substring(0,columnList.length()-2);
//							valueList=valueList.substring(0,valueList.length()-2);
						}
						
						
						
					}
					
					fields=allMapperSubs(o);
					if (fields.length()>0)
						for (String s : fields.split(", ")) {
							Field f = retrieveField(s, o.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
//							columnList+=extractColumn(s, o,null) + ", ";
							valueList+=extractColumn(s, o,null) + "=";
							
							
							try{
							valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
							}
							catch(NullPointerException e){
								valueList+= " NULL , ";
							}
							
						}
					
					
					
					
					
//					columnList=columnList.substring(0,columnList.length()-2);
					valueList +=fatherColumn + "=" + id + ", ";
					valueList=valueList.substring(0,valueList.length()-2);
					
//					fullQuery.setField(2, columnList);
					fullQuery.setField(2, valueList);
					fullQuery.setField(3, "id=" + o.getId());
	
					
					
					try {
						statement = getConnection().createStatement();
						DAO.printToConsole1(fullQuery);

////						statement.execute1Update(o.getCreateQuery(),Statement.RETURN_GENERATED_KEYS);
//						statement.execute1Update(fullQuery.toString(),Statement.RETURN_GENERATED_KEYS);
						statement.executeUpdate(fullQuery.toString());
//						ResultSet rs = statement.getGeneratedKeys();
//						rs.next();
//						o.setId(rs.getLong(1));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						RCMException.showException(e1);
					}
					
					
					
					
					fields=allMapperLists(o);
					if (fields.length()>0)
						for (String s : fields.split(", ")) {
							Field f = retrieveField(s, o.getClass());
							
							//lo rendo accessibile
							f.setAccessible(true);
							
							
//							StringBuilderQuery subQueries = new StringBuilderQuery(extractSubQueries((ArrayList<DTOBase>) f.get(o)));
							
				            Type type = f.getGenericType();
	
			                ParameterizedType pType = (ParameterizedType)type;
			                Type[] arr = pType.getActualTypeArguments();
			                Class<?> innerClass = (Class<?>) arr[0];
			                
			                DTOBase swapSubElement=null;
							try {
								swapSubElement = (DTOBase) innerClass.newInstance();
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								RCMException.showException(e);
							}
			                
							MToM[] relation = getManyToMany(swapSubElement, o);
							
//							if (swapSubElement instanceof Riferimento)
//								System.out.print("");
							
							
							
							
							
							
							
//							if (relation!=null) {
////								gestire le liste con i many to many
////								mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
////								mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
////								mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + o.getId());
//								subCreateMToM((ArrayList<DTOBase>) f.get(o), relation, o.getId());
//							}
//							else {
//								String myColumn=extractFather(innerClass);
//								subCreateNew((ArrayList<DTOBase>) f.get(o), myColumn, o.getId());
//							}
							ArrayList<DTOBase> lista = (ArrayList<DTOBase>) f.get(o);
							ArrayList<DTOBase> nuovi=null;
							
							
							if (relation!=null) {
								ArrayList<DTOBase> subLista = new ArrayList<>();
								subLista.addAll(lista);
								
								
								
								//una volta aggiornati gli elementi
								subUpdateMToM(subLista, relation, o.getId());
								//inserisco quelli nuovi
								subCreateMToM(subLista, relation, o.getId());
								nuovi=subLista;
							}
							else {
								nuovi = new ArrayList<>();
								
								for (DTOBase arrayElement:lista) {
									if (arrayElement.getId()==0)
										nuovi.add(arrayElement);
								}
								lista.removeAll(nuovi);
								
								String myColumn=extractFather(innerClass);
								subUpdateNew(lista, myColumn, o.getId());
								subCreateNew(nuovi, myColumn, o.getId());
								lista.addAll(nuovi);
								
								
								
								
								
								
//								subUpdateNew_old(lista, innerClass, o.getId());
								
								
								
							}
							
							
//							String myColumn=extractFather(innerClass);
//							subCreateNew((ArrayList<DTOBase>) f.get(o), myColumn, o.getId());
							
							
							
			                
			                
////			                ArrayList<DTOBase> list = (ArrayList<DTOBase>) f.get(o);
//	
//							
//							for (DTOBase subElementInList : (ArrayList<DTOBase>) f.get(o)) {
//								Field f2 = retrieveField(s, o.getClass());
//								
//								
//							}
//							
//							
////							for (f.get)
////								f.set(o, rs.getString(myColumn));
//							
//							
//							
//							
//							try{
//							valueList+= "" + ((DTOBase)f.get(o)).getId() + ", ";
//							}
//							catch(NullPointerException e){
//								valueList+= " NULL , ";
//							}
							
						}
					
					
					
					
					
					
					
					
					
//					daoMemory.get(o.getClass()).put(o.getId(), o);
					
	/********************************************************************************/			
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
			}
			
			
			
			
			
			
			
			
/********************************************************************************/			
			
		}
	
		
		
		private static String extractSubQueries(ArrayList<DTOBase> arrayList) {
			// TODO Auto-generated method stub
			return null;
		}
		private static String allMapperLists(DTOBase o) {
			String className = o.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
			
////			if (o.getPriority()<classMapper.elements.size()) {
//				
//				
////				fields += myMapper.commons.values();
//				for (String s: myMapper.commons.values())
//					fields += s + ", ";
				
				
				Iterator<Entry<Integer, Elements>> it= classMapper.elements.entrySet().iterator();
				
				while(it.hasNext()) {
//					Elements elem = it.next().getValue();
					
					for (String s: it.next().getValue().lists) {
						fields += s + ", ";
					}
					
				}
				
//				for (String s: classMapper.elements.get(o.getPriority()).fields.keySet())
//					fields += s + ", ";
				
//				for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
//					fields += s + ", ";
//				
//				for (String s: classMapper.elements.get(swapElement.getPriority()).lists)
//					fields += s + ", ";
//			}
			
			if (fields.length()>0)
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String allMapperFields(DTOBase o) {
			String className = o.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
			
////			if (o.getPriority()<classMapper.elements.size()) {
//				
//				
////				fields += myMapper.commons.values();
//				for (String s: myMapper.commons.values())
//					fields += s + ", ";
				
				
				Iterator<Entry<Integer, Elements>> it= classMapper.elements.entrySet().iterator();
				
				while(it.hasNext()) {
//					Elements elem = it.next().getValue();
					
					for (String s: it.next().getValue().fields.keySet()) {
						fields += s + ", ";
					}
					
				}
//				it= classMapper.elements.entrySet().iterator();
//				while(it.hasNext()) {
////					Elements elem = it.next().getValue();
//					
//					for (String s: it.next().getValue().subs.keySet()) {
//						fields += s + ", ";
//					}
//					
//				}
				
//				for (String s: classMapper.elements.get(o.getPriority()).fields.keySet())
//					fields += s + ", ";
				
//				for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
//					fields += s + ", ";
//				
//				for (String s: classMapper.elements.get(swapElement.getPriority()).lists)
//					fields += s + ", ";
//			}
			
			if (fields.length()>0)
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String allMapperEnums(DTOBase o) {
			String className = o.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
			
////			if (o.getPriority()<classMapper.elements.size()) {
//				
//				
////				fields += myMapper.commons.values();
//				for (String s: myMapper.commons.values())
//					fields += s + ", ";
				
				
				Iterator<Entry<Integer, Elements>> it= classMapper.elements.entrySet().iterator();
				
				while(it.hasNext()) {
//					Elements elem = it.next().getValue();
					
					for (String s: it.next().getValue().enums.keySet()) {
						fields += s + ", ";
					}
					
				}
//				it= classMapper.elements.entrySet().iterator();
//				while(it.hasNext()) {
////					Elements elem = it.next().getValue();
//					
//					for (String s: it.next().getValue().subs.keySet()) {
//						fields += s + ", ";
//					}
//					
//				}
				
//				for (String s: classMapper.elements.get(o.getPriority()).fields.keySet())
//					fields += s + ", ";
				
//				for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
//					fields += s + ", ";
//				
//				for (String s: classMapper.elements.get(swapElement.getPriority()).lists)
//					fields += s + ", ";
//			}
			
			if (fields.length()>0)
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		private static String allMapperSubs(DTOBase o) {
			String className = o.getClass().getSimpleName().toLowerCase();
			
			
			DTOMapper classMapper = myMapper.mapper.get(className);
			
			String fields = "";
			
			
////			if (o.getPriority()<classMapper.elements.size()) {
//				
//				
////				fields += myMapper.commons.values();
//				for (String s: myMapper.commons.values())
//					fields += s + ", ";
				
				
				Iterator<Entry<Integer, Elements>> it= classMapper.elements.entrySet().iterator();
				
				while(it.hasNext()) {
//					Elements elem = it.next().getValue();
					
					for (String s: it.next().getValue().subs.keySet()) {
						fields += s + ", ";
					}
					
				}
				
//				for (String s: classMapper.elements.get(o.getPriority()).fields.keySet())
//					fields += s + ", ";
				
//				for (String s: classMapper.elements.get(swapElement.getPriority()).subs.values())
//					fields += s + ", ";
//				
//				for (String s: classMapper.elements.get(swapElement.getPriority()).lists)
//					fields += s + ", ";
//			}
			
			if (fields.length()>0)
			fields = fields.substring(0, fields.length()-2);
			
			
			return fields;
		}
		public static void complete(DTOBase o) {
			try {
			String fields=allMapperSubs(o);
//			fields=allMapperSubs(o);
		if (fields.length()>0) {
			
//			read=true;
		for (String fieldName: fields.split(", ")) {
//		for (String fieldName: mapperSubs(swapElement).split(", ")) {
			//ricavo l'attributo sulla base del nome
			Field f = retrieveField(fieldName, o.getClass());
			
			//lo rendo accessibile
			f.setAccessible(true);
			
//			String myColumn = extractColumn(fieldName, o, null);
			DTOBase innerItem;
				innerItem = (DTOBase) f.get(o);
				DTOBase subElement = null;
				if (innerItem!=null)
				subElement = retreiveSubMemory(f.getType(),null,null).get(innerItem.getId());
//				complete(subElement);
//				read(subElement);
				
				
				f.set(o, subElement);
			
//			long idElem = rs.getLong(myColumn);
//			if (idElem>0) {
//				StringBuilderQuery subQuery=new StringBuilderQuery(readQuery);
//				subQuery.setField(1, mapperColumns((DTOBase) f.getType().newInstance()));
//				subQuery.setField(2, mapperTable((DTOBase) f.getType().newInstance()));
//				
//				subQuery.setField(3, "id = " + idElem);
//			}
			
//			if (f.getType()==TipoDocumento.class) {
//				System.out.print("");
//			}
			
		
			
		}
		}
		
		

		fields=allMapperLists(o);
		if (fields.length()>0) {
//			read=true;
		for (String fieldName: fields.split(", ")) {
//		for (String fieldName: mapperSubs(swapElement).split(", ")) {
			//ricavo l'attributo sulla base del nome
			Field f = retrieveField(fieldName, o.getClass());
			
			//lo rendo accessibile
			f.setAccessible(true);
			
			
			ArrayList<DTOBase> subList = (ArrayList<DTOBase>) f.get(o);
			ArrayList<DTOBase> newList = new ArrayList<>();
			
			for (DTOBase d : subList) {
				System.out.print("");
				System.out.print("");
				
				HashMap<Long, DTOBase> mem = daoMemory.get(d.getClass());
				
				if (mem!=null) {
					d=mem.get(d.getId());
					complete(d);
				}
				
				newList.add(d);
//				read(d);
				System.out.print("");
				System.out.print("");
			}
			f.set(o, newList);
			
//			StringBuilderQuery mySubQuery=new StringBuilderQuery(readQuery);
//			
//			Class<?> type = (Class<?>) ((ParameterizedType)f.getGenericType()).getActualTypeArguments()[0];
//			DTOBase swapSubElement = (DTOBase) type.newInstance();
//			
////			mySubQuery.setField(1, mapperColumns(swapSubElement));
////			mySubQuery.setField(2, mapperTable(swapSubElement));
////			mySubQuery.setField(3, mapperFather(swapSubElement));
////			mySubQuery.append("=" +o.getId());
//			
//
//			
//			
//			
//			
//			MToM[] relation = getManyToMany(swapSubElement, o);
//			
//			
//			
//			if (relation!=null) {
////				gestire le liste con i many to many
//				mySubQuery.setField(1, mapperTableWithColumns(swapSubElement));
//				mySubQuery.setField(2, mapperTable(swapSubElement) + ", " + relation[1].table);
//				mySubQuery.setField(3, mapperTable(swapSubElement) + ".id=" + relation[1].table + "." + relation[1].column + " and " + relation[0].table + "." + relation[0].column + "=" + o.getId());
//			}
//			else {
//				mySubQuery.setField(1, mapperColumns(swapSubElement,null));
//				mySubQuery.setField(2, mapperTable(swapSubElement));
//				mySubQuery.setField(3, mapperFather(swapSubElement));
//				mySubQuery.append("=" +o.getId());
//			}
//			
//			
//			
//			
//			if (o.getId()==1600 && o instanceof Cliente) {
//			System.out.print("");
//			}
//			
//			if (type.equals(Strada.class)) {
//				System.out.print("");
//			}
//			f.set(o, extractList(type,executeQuery(mySubQuery.toString()),null));
//			
//			
//			
//			
//			
////			System.out.println(type);
//			
////			String myColumn = extractColumn(fieldName, item);
////			
////			DTOBase subElement = retreiveSubMemory(f.getType()).get(rs.getLong(myColumn));
////			
////			f.set(item, subElement);
		
			
		}
		}
		
		
		
		
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		
		
		
		
		
		
		}
		
//	public static void addInMemory(DTOBase o){
//		HashMap<Long, DTOBase> partial = memory.get(o.getClass());
//		
//		try{
//			partial.put(o.getId(), o);
//		}
//		catch(NullPointerException e){
//			partial = new HashMap<>();
//			partial.put(o.getId(), o);
//			memory.put(o.getClass(), partial);
//		}
//		
//		
//	}
	

}
