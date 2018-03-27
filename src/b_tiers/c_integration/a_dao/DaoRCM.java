package b_tiers.c_integration.a_dao;


import java.util.HashMap;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

import javafx.fxml.FXMLLoader;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
//import org.hibernate.engine.transaction.spi.LocalStatus;
//import org.hibernate.criterion.ProjectionList;
//import org.hibernate.criterion.Projections;
import org.hibernate.exception.JDBCConnectionException;
//import org.hibernate.transform.Transformers;








import org.hibernate.transform.Transformers;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import a_main.RCMException;
import c_dto.OLD___a_abstract.DTOBase;

/**
*
* 
* @author Rosario
*
*/
@Deprecated
public class DaoRCM{
//	private Class<?> objClass;
//	private String xmlClass;
	
	
	//strumento per accedere al db
//	private static final HibernateUtil hibUtil= new HibernateUtil();
//	/**
//	 * @deprecated
//	 */
	private Class<? extends DTOBase> c;
//    private static AccessDatabase singleton=null;
    
	private Session session=null;
	private Transaction transaction=null;
    private SessionFactory sessionFactory;
    private Configuration configuration;
    private StandardServiceRegistryBuilder serviceRegistryBuilder;
    
    
    
    
	private SAXBuilder builder;
	private Document document/* /, document2/**/;
//	private File fields;
	private Element rootNode/* /, rootNode2/**/;
//	private FXMLLoader loader, loader2;	
    
//    private static DAOUtil singleton=null;
    
	public DaoRCM(Class<? extends DTOBase> c){
    	try{
    		
    		BasicConfigurator.configure();
    		Logger.getRootLogger().setLevel(Level.FATAL);
    		
        	configuration = new Configuration().configure();
//        	configuration.setProperty(propertyName, value)
        	serviceRegistryBuilder  = new StandardServiceRegistryBuilder();
        	serviceRegistryBuilder.applySettings(configuration.getProperties());
        	sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
        	this.c=c;
        	
        	
			//inizializzo gli oggetti per la lettura dei dati dall'XML
//////			fields = new File("src\\b_tiers\\c_integration\\a_dao\\filterList.xml");
////			fields = new File("res\\filterList.xml");
//			fields = new File("/src/b_tiers/c_integration/a_dao/filterList.xml");
			InputStream inputStreamFile = this.getClass().getResourceAsStream("/filterList.xml");
//        	URL url = 	getClass().getResource("filterList.xml");
//			fields = new File(url.toURI());
			builder= new SAXBuilder();
//			document= builder.build(fields);
			document= builder.build(inputStreamFile);
			rootNode=null;
			
			/* /
			document2= builder.build(fields);
			rootNode2=null;
			/**/
			
			
//			///////////////////////////////////////////////////////////////////////////////////
//			//disattivazione logging
//			List<Logger> loggers = Collections.<Logger>list(LogManager.getCurrentLoggers());
//			loggers.add(LogManager.getRootLogger());
//			for ( Logger logger : loggers ) {
/////////////////////////////////////////////////////////				
//			    logger.setLevel(Level.ALL);
/////////////////////////////////////////////////////////				
////			    logger.setLevel(Level.DEBUG);
////			    logger.setLevel(Level.ERROR);
////			    logger.setLevel(Level.FATAL);
////			    logger.setLevel(Level.INFO);
////			    logger.setLevel(Level.TRACE);
////			    logger.setLevel(Level.WARN);
/////////////////////////////////////////////////////////				
//			}			
//			///////////////////////////////////////////////////////////////////////////////////
		}
    	catch (Exception e){
			RCMException.showException(e);
    	}
    }
    
//    public static synchronized DAOUtil getInstance(DTOBase dto){
//    	if (singleton==null){
//    		singleton = new DAOUtil();
//    	}
//    	return singleton;
//    }
//    public static synchronized AccessDatabase getInstance(){
//    	if (singleton==null){
//    		singleton = new AccessDatabase();
//    	}
//    	return singleton;
//    }
    
	
	
//	/**
//	 * @deprecated
//	 * @param c
//	 */
//    public DAOUtil(Class<?> c) {
//    	this.c=c;
//
//    	configuration = new Configuration().configure();
//    	serviceRegistryBuilder  = new StandardServiceRegistryBuilder();
//    	serviceRegistryBuilder.applySettings(configuration.getProperties());
//    	sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
////		this.objClass = c;
////		String[] swap = this.objClass.getName().toString().split("\\.");
////		this.xmlClass= swap[swap.length-1];
//	}

	///////////////////////////////////////////////////////ok
		/**
		 * 
		 * @param dto
		 */
		public void create(DTOBase dto) {
	//		hibUtil.add(dto);
			
			//apro la sessione
			openSession();
			try{
//			session.persist(dto);
			session.save(dto);
			}catch (Exception e){
				RCMException.showException(e);
			}
			//chiudo la sessione
			closeSession();
	
		}

//		public static void main(String[] args) {
//			DAOUtil dao = new DAOUtil();
//			Iscrizione i = new Iscrizione();
////			i.setId(1);
//			Partecipante p = new Partecipante();
//			p.setId(4);
//			
//			Competizione c = new Competizione();
//			c.setId(1);
//			
//			i.setCompetizione(c);
//			i.setData(Calendar.getInstance().getTime());
//			i.setOptional(null);
//			i.setPartecipante(p);
//			
//			dao.create(i);
//			
//		}
		
	///////////////////////////////////////////////////////ok
			/**
			 * 
			 * @param dto
			 */
			public void update(DTOBase dto) {
		//		hibUtil.update(dto);
				openSession();
				try{
					
					
//					DTOBase newMergedDto = (DTOBase) session.merge(dto);
//					session.saveOrUpdate(newMergedDto);
//					session.flush();
					
//					DTOBase swapDto=(DTOBase)session.get(dto.getClass(), dto.getId());
//					swapDto=dto;
//					session.update(swapDto);
//					session.update(dto);
//					session.flush();
					
					session.merge(dto);
					
					
					
				}
				catch(Exception e){
					RCMException.showException(e);
				}
//				session.flush();
				closeSession();
		
			}

		///////////////////////////////////////////////////////ok
			/**
			 * 
			 * @param dto
			 */
			public void delete(DTOBase dto) {
		//		hibUtil.delete(dto);
				openSession();
				session.delete(dto);
				
				//session.update(dto);
				closeSession();
		
			}

	///////////////////////////////////////////////////////ok
				/**
				 * 
				 * @param id
				 * @return
				 */
//				public DTOBase readById(int id){
				public DTOBase read(DTOBase id){
			//		return hibUtil.getById(this.objClass, id);
					openSession();
//					DTOBase dto=(DTOBase)session.get(c, id);
					DTOBase dto=(DTOBase)session.get(id.getClass(), id.getId());
					
					//imposta che l'oggetto � stato interamente caricato dal database
					dto.setLoaded();
					closeSession();
					return dto;
					
				}

				/**
					 * 
					 * @return
					 */
					public HashMap<Integer, DTOBase> readAll(/*Class<?> myClass*/){
				////	public HashMap<Integer, DTOBase> getAll(){
				//		return hibUtil.getAll(this.objClass);
				
						
						HashMap<Integer, DTOBase> map = new HashMap<>();
//						TreeMap<Integer, DTOBase> map = new TreeMap<>();
						openSession();
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////

						
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
						
						
				
//						Criteria filter = session.createCriteria(c);
				
///////////////////////////////////////////////////////////////////////////////////////
//						ProjectionList filterList = Projections.projectionList();
////						
////						for (String str: XmlUtil.getFields(myClass)){
//							filterList.add(Projections.property("id"),"id");
////						}
////				
//						filter.setProjection(filterList).setResultTransformer(Transformers.aliasToBean(c)); 
///////////////////////////////////////////////////////////////////////////////////////

						Criteria filter;
							filter = session.createCriteria(c);
//							if(c.equals(Documento.class)){
//								System.out.println("");
//							}
							try{
								rootNode = document.getRootElement();
								/**/ProjectionList/**/ filterList = Projections.projectionList();
								filterList.add(Projections.property(rootNode.getAttributeValue("default")), rootNode.getAttributeValue("default"));
								
								Element subNode=rootNode.getChild(c.getSimpleName().toLowerCase());
								
								
								
								DetachedCriteria subCrit=null;
//								DetachedCriteria subQuery=null;
								for (String str: subNode.getValue().split(", ")){
//									String nameAndAlias[]=str.split("=");
									/* /
									//cerco il "riferimento" all'oggetto
									rootNode2=document2.getRootElement().getChild(str);
									
									if (rootNode2==null){//se si tratta solo di una stringa
										/**/
									
									if (!str.contains("_")){
										filterList.add(Projections.property(str),str);
									}
									else{
										String subPojo[] = str.split("_");
										
										filterList.add(Projections.property(subPojo[0]),subPojo[0]);
										
										subCrit=addSubQuery(subPojo[1]);
//										filter.createAlias(subPojo[0], subPojo[0]);
//										for (int i=1; i< subPojo.length; i++){
//											filterList.add(Projections.property(subPojo[0] + "." + subPojo[i]),subPojo[0] + "." + subPojo[i]);
////											filter.setProjection(Projections.property(subPojo[0] + "." + subPojo[i]));
//										}
									}
									
										/* /
									}
									else{
										//str indica il nome dell'attributo o della classe di mio interesse
										//per cui devo verificare se str risulta essere "riferimento" ad un oggetto
										//di mio interesse
										crit=subQueries(rootNode2);
										
									}
									/**/
									
									
									
								}
								/* /
								filter.setProjection(filterList);
								filter.add((Criterion) crit).setResultTransformer(Transformers.aliasToBean(c));/**/
								
								Criteria b = filter.setProjection(filterList);
								
								if (subCrit!=null)
								b.add(Subqueries.exists(subCrit));
								
								b.setResultTransformer(Transformers.aliasToBean(c)); 
//								if (subQuery!=null){
//									filter.add(Subqueries.exists(subQuery));
//								}
//								if (rootNode.getAttribute("list")!=null){
//									String lists[] = rootNode.getAttribute("list").getValue().split(", ");
//									
//									for (String s : lists){
//										String fields[] = s.split("|");
//										
//										DetachedCriteria dcriteria = DetachedCriteria.forClass(Class.forName(fields[0]));
//										for (int i=1; i< fields.length;i++){
////											Property p = Property.forName(fields[i]);
////											dcriteria.add((Criterion) p);
//											dcriteria.setProjection(Projections.property(fields[i]));
//										}
//										filter.add(Subqueries.propertyIn(propertyName, dc))
//										
//									}
//								}
								
								
								
							}
							catch(Exception e){
//								e.printStackTrace();
								System.out.println("exception: " + c.getSimpleName());
							}
							
						
						
						try{
							for (Object obj : filter.list()){
								map.put(((DTOBase)obj).getId(), (DTOBase)obj);
							}
						}catch(Exception e){
							RCMException.showException(e);
						}
						
						
						closeSession();
				
						return map;		
					}
//					private ProjectionList filterList;
					
			
	/* 	/				
			private DetachedCriteria subQueries(Element rootNode){
				DetachedCriteria subQuery=null;
//				ProjectionList filterList;
				ProjectionList filterList = Projections.projectionList();
				
				Class<?> cls=null;
				try {
					cls = Class.forName(document2.getRootElement().getAttributeValue("path") + rootNode.getAttributeValue("class"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
			RCMException.showException(e);
				}
				subQuery = DetachedCriteria.forClass(cls);
				
				DetachedCriteria crit=null;

				for (String str: rootNode.getValue().split(", ")){
					
					//cerco il "riferimento" all'oggetto
					rootNode2=document2.getRootElement().getChild(str);
					
					if (rootNode2==null){//se si tratta solo di una stringa
						filterList.add(Projections.property(str),str);
					}
					else{
						//str indica il nome dell'attributo o della classe di mio interesse
						//per cui devo verificare se str risulta essere "riferimento" ad un oggetto
						//di mio interesse
						crit=subQueries(rootNode2);
						
					}
					
				}
				subQuery.setProjection(filterList);
				if (crit!=null){
					subQuery.add((Criterion) crit);
				}
				return subQuery;
				
			}
			/**/
				
				
			private DetachedCriteria addSubQuery(String subPojo_1) {
				
				DetachedCriteria carCriteria = null;
				ProjectionList detachedFilterList = Projections.projectionList();
				
				Class<?> c=null;
				DetachedCriteria b = null;
				try {
					c=Class.forName(rootNode.getAttributeValue("path") + subPojo_1);
					carCriteria = DetachedCriteria.forClass(c);
					
					Element subNode=rootNode.getChild(subPojo_1.toLowerCase());
					
					DetachedCriteria subCrit=null;
					for (String str: subNode.getValue().split(", ")){
						
						if (!str.contains("_")){
							detachedFilterList.add(Projections.property(str),str);
						}
						else{
							String subPojo[] = str.split("_");
							
							detachedFilterList.add(Projections.property(subPojo[0]),subPojo[0]);
							
							subCrit=addSubQuery(subPojo[1]);
						}
					}
					
					b = carCriteria.setProjection(detachedFilterList);
					
					if (subCrit!=null)
					b.add(Subqueries.exists(subCrit));

//					carCriteria.setProjection(projection)
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					RCMException.showException(e);
				}
				return b;
				
				
					
				}

			private void openSession(){
				//////////////////////////////////////////////////////////////
//				if(session == null || !session.isOpen()){
//					session = sessionFactory.openSession();
//				}
//				else{
//					session = sessionFactory.getCurrentSession();
//				}
//				try{
//					if (transaction!=null){
//						transaction.commit();
//						transaction=null;
//					}
//					try{
//						transaction = session.beginTransaction();
//					}
//						catch(SessionException e){
//							session = sessionFactory.openSession();
//							transaction = session.beginTransaction();
//						}
//				}
//				catch(JDBCConnectionException e){
////				catch(Exception e){
//					e.printStackTrace();
//					transaction.rollback();
//				}
				//////////////////////////////////////////////////////////////
//				session = sessionFactory.openSession();
				session = sessionFactory.getCurrentSession();
				if(session == null || !session.isOpen()){
					session = sessionFactory.openSession();
				}
//				else{
//					session = sessionFactory.getCurrentSession();
//				}
				transaction = session.beginTransaction();
				//////////////////////////////////////////////////////////////
			}

			private void closeSession(){
				transaction.commit();
				try{
					session.close();
				}
				catch(Exception e){
					System.out.println("sessione gia' chiusa");
				}
			}

//				private void nothingToDO(){}
//	/**
//	 * 
//	 * @return
//	 */
//	public Class<?> getDtoClass(){
////		return this.objClass;
//		return this.c;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public String getXmlClass(){
//		return c.getSimpleName();
//	}
//	
}