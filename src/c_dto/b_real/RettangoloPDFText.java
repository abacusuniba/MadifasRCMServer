package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

//import b_tiers.a_presentation.b_dispatcher.forms.administrator.controller.ControllerDatiLayout.Rettangolo;
//import b_tiers.a_presentation.b_dispatcher.forms.administrator.controller.ControllerDatiLayout.S;
//import b_tiers.a_presentation.b_dispatcher.forms.administrator.controller.ControllerDatiLayout.TitoloForma;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.IDCampo;
import c_dto.c_enum.Stato;
import c_dto.c_enum.TextAlign;
import d_utils.StringBuilderQuery;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class RettangoloPDFText extends Primary{
	
//	private AnchorPane panelBase=null;
//	public void setCanvas(AnchorPane panel) {
//		panelBase=panel;
//	}
	
	
//	private static Content rettangolo=null;
//	private EventHandler<MouseEvent> panelMouseClicked = new EventHandler<MouseEvent>() {
//		@Override
//		public void handle(MouseEvent t) {
//			if (rettangolo!=null)
//			{
//				rettangolo.setStroke(Color.BLACK);
//				rettangolo=null;
////				if (rettangolo.isOutOfBounds(t)) {
//////					if (!selectedNode.isResizing() && !selectedNode.isDragging())
////					closeRettangolo();
////				}
//			}
//		}};
//	 private TextField txtX;
//	 private TextField txtY;
//	 private TextField txtWidth;
//	 private TextField txtHeight;
//	
//	 private ColorPicker clrBordo;
//	 private ColorPicker clrSfondo;
	
	
//	private static AnchorPane panel=null;
//	public void setCanvas(AnchorPane p) {
//		if (panel==null) {
//			panel=p;
////			panel.setMouseTransparent(true);
////			panel.setOnMouseClicked(panelMouseClicked);
//			panel.setOnMouseClicked(new EventHandler<MouseEvent>() {
//				@Override
//				public void handle(MouseEvent t) {
//					if (rettangolo!=null)
//					{
//						rettangolo.setStroke(Color.BLACK);
//						rettangolo=null;
////						if (rettangolo.isOutOfBounds(t)) {
//////							if (!selectedNode.isResizing() && !selectedNode.isDragging())
////							closeRettangolo();
////						}
//					}
//				}});
//			panel.toBack();
//		}
//		
//	}
	
//	private Content content;
	
	
//	public Content getContent() {
//		return content;
//	}
	
	
	private boolean showSplittable;
	
	
	public boolean isShowSplittable() {
		return showSplittable;
	}
	public void setShowSplittable(boolean showSplittable) {
		this.showSplittable = showSplittable;
	}

	private IDCampo campo;
	
	
	public IDCampo getIDCampo() {
		return campo;
	}
	public void setIDCampo(IDCampo campo) {
		this.campo = campo;
	}

	private TextAlign allineatitolo;
	public TextAlign getTitleAlignment() {
		return allineatitolo;
	}
	public void setTitleAlignment(TextAlign l) {
		allineatitolo=l;
	}

	double x;
	double y;
	double width;
	double height;
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
//	public void setTitolo(String titolo) {
//		this.titolo = titolo;
//	}

//	String titolo;
//	private String root;
	
	public RettangoloPDFText(double x1, double y1, double w, double h) {
		x=x1;
		y=y1;
		width=w;
		height=h;
//		titolo=t;
		allineatitolo=TextAlign.LEFT;
//		setTable("nazione");
	}
	public RettangoloPDFText() {
	}
	
	
	
	
	
//	private String nome;
//	private Stato stato;
//	
//	
//	public Stato getStato() {
//		return stato;
//	}
//
//	public void setStato(Stato stato) {
//		this.stato = stato;
//	}
	
//	public Nazione() {
//		setTable("nazione");
//	}

	
//	private Stato stato;
//	
//	public Stato getStato() {
//		return stato;
//	}
//
//	public void setStato(Stato stato) {
//		this.stato = stato;
//	}

//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
	
//	@Override
//	public String toString() {
//		return getNome();
//	}

//	public boolean contains(String s){
//		boolean contain=false;
//		
//		String stringForFilter = toString();
//		
//		
//		
//		stringForFilter=stringForFilter.toLowerCase();
//		
//		if (stringForFilter.indexOf(s.toLowerCase())>-1)
//			contain=true;
//		
//		
//		return contain;
//}

//	@Override
//	public int compareTo(Primary o) {
//		Nazione n = (Nazione) o;
//		
//		
//		//=0: le stringhe sono uguali
//		//>0: o < this
//		//<0: o > this
//		
//		int compare;
//		
//		compare=nome.toLowerCase().compareTo(n.getNome().toLowerCase());
//		
//		if (compare==0)
//		{
////			compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
////			if (compare==0)
////			{
//				compare=(int) (this.getId()-o.getId());
////			}
//		}
//		
//		
//		return compare;
//		
//	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

//	public String getTitolo() {
//		return titolo;
//	}

	

//	@Override
//	public String getReadQuery() {
//		
//		StringBuilderQuery query = new StringBuilderQuery("select * from " + getTable() + " where id=?");
//		query.setValue(1, getId());
//				
//		return query.toString();
//	}
//
//	@Override
//	public String getReadAllQuery() {
//		StringBuilderQuery query = new StringBuilderQuery("select * from " + getTable() + "");
////		query.setTable(1, getTable());
//				
//		return query.toString();
//	}

//	public String getRoot() {
//		return root;
//	}
//
//	public void setRoot(String root) {
//		this.root = root;
//	}

	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		RettangoloPDFText n = (RettangoloPDFText) o;
		int compare=0;
		if (getX()>n.getX())
			compare++;
		else if(getX()<n.getX())
			compare--;
		
//		compare=getNome().toLowerCase().compareTo(n.getNome().toLowerCase());
//		if (compare==0){
//			compare=super.compareTo(o);
//		}
		
		return compare;
	}
	

//	@Override
//	public String getDeleteQuery() {
//		
////		StringBuilderQuery query = new StringBuilderQuery("update ? set stato=? where id=?");
////		query.setTable(1, getTable());
//////		query.append(getTable());
////		
////		query.setValue(2, 2);
////		//1: attivo
////		//2: annullato
////		
////		query.setValue(3, getId());
//////		query.append(getId());
////				
////		return query.toString();
//		return null;
//	}

	
	
	
	
	
	
//	
//	
//	private static enum S {
//	    DEFAULT,
//	    DRAG,
//	    NW_RESIZE,
//	    SW_RESIZE,
//	    NE_RESIZE,
//	    SE_RESIZE,
//	    E_RESIZE,
//	    W_RESIZE,
//	    N_RESIZE,
//	    S_RESIZE;
//	}
//	
//	private class TitoloForma extends Text{
//		
//	}
//	
//	private class Rettangolo extends Rectangle{
//        double translatedX;
//        double translatedY;
//        
//        
//		Rettangolo qst=null;
//		
//		TitoloForma testo = new TitoloForma();
////		Button btnClose = new Button("X");
//		
//	    public TitoloForma getTitolo() {
//			return testo;
//		}
//
//		public void setTitolo(TitoloForma titolo) {
//			this.testo = titolo;
//		}
//		private S state = S.DEFAULT;
//	    private static final float MARGIN = 3.0f;
//
//
////	    private double parentX(double localX) {
////	        return nodeX() + localX;
////	    }
////
////	    private double parentY(double localY) {
////	        return nodeY() + localY;
////	    }
//	    private double nodeX() {
////	        return node.getBoundsInParent().getMinX();
//	        return getBoundsInParent().getMinX();
//	    }
//
//	    private double nodeY() {
////	        return node.getBoundsInParent().getMinY();
//	        return getBoundsInParent().getMinY();
//	    }
//	    
//	    private boolean isDragging() {
//	    		return dragZone;
//	    }
//	    private boolean isResizing() {
//	    		return resizeZone;
//	    }
//	    private boolean isOutOfBounds(MouseEvent event) {
//	    	boolean result=true;
//		    	boolean res1, res2, res3, res4;
//		        double xPos = event.getX();
//		        double yPos = event.getY();
//		        
//		        double xRect = getX()+translatedX;
//		        double yRect = getY()+translatedY;
//		    	
//		        
//		        res1 = (xPos>=xRect);
//		        res2 = (xPos<= xRect+getWidth());
//		        res3 = (yPos>= yRect);
//		        res4 = (yPos <= yRect + getHeight());
//		        
//		        if ( res1 && res2 && res3 && res4) {
//		        		result=false;
//		        }
//		        
////		        if (((xPos< getX()) || (xPos > (getX()+getWidth())))  && ((yPos < getY()) || (yPos>(getY()+getHeight()))) )
////		        		result=true;
//		    	
//		    	
//		    	return result;
//	    }
//	    
//	    
//	    
//	    private boolean isInDragZone(MouseEvent event) {
////	        double xPos = parentX(event.getX());
////	        double yPos = parentY(event.getY());
//	        double xPos = event.getSceneX();
//	        double yPos = event.getSceneY();
//	        double nodeX = nodeX() + MARGIN;
//	        double nodeY = nodeY() + MARGIN;
//	        double nodeX0 = nodeX() + nodeW() - MARGIN;
//	        double nodeY0 = nodeY() + nodeH() - MARGIN;
//
//	        return (xPos > nodeX && xPos < nodeX0) && (yPos > nodeY && yPos < nodeY0);
//	    }
//	    private S currentMouseState(MouseEvent event) {
//	        S state = S.DEFAULT;
//	        boolean left = isLeftResizeZone(event);
//	        boolean right = isRightResizeZone(event);
//	        boolean top = isTopResizeZone(event);
//	        boolean bottom = isBottomResizeZone(event);
//
//	        if (left && top) state = S.NW_RESIZE;
//	        else if (left && bottom) state = S.SW_RESIZE;
//	        else if (right && top) state = S.NE_RESIZE;
//	        else if (right && bottom) state = S.SE_RESIZE;
//	        else if (right) state = S.E_RESIZE;
//	        else if (left) state = S.W_RESIZE;
//	        else if (top) state = S.N_RESIZE;
//	        else if (bottom) state = S.S_RESIZE;
//	        else if (isInDragZone(event)) state = S.DRAG;
//
//	        return state;
//	    }
//	    private boolean isInResizeZone(MouseEvent event) {
//	        return isLeftResizeZone(event) || isRightResizeZone(event)
//	                || isBottomResizeZone(event) || isTopResizeZone(event);
//	    }
//	    private boolean isLeftResizeZone(MouseEvent event) {
////	        return intersect(0, event.getX());
//	        return intersect(getX(), event.getX());
//	    }
//
//	    private boolean isRightResizeZone(MouseEvent event) {
////	        return intersect(nodeW(), event.getX());
//	        return intersect(getX()+getWidth(), event.getX());
//	    }
//
//	    private boolean isTopResizeZone(MouseEvent event) {
////	        return intersect(0, event.getY());
//	        return intersect(getY(), event.getY());
//	    }
//
//	    private boolean isBottomResizeZone(MouseEvent event) {
////	        return intersect(nodeH(), event.getY());
//	        return intersect(getY() + getHeight(), event.getY());
//	    }
//	    private boolean intersect(double side, double point) {
//	        return side + MARGIN > point && side - MARGIN < point;
//	    }
//	    private double nodeW() {
////	        return node.getBoundsInParent().getWidth();
//	        return getBoundsInParent().getWidth();
//	    }
//
//	    private double nodeH() {
////	        return node.getBoundsInParent().getHeight();
//	        return getBoundsInParent().getHeight();
//	    }
////	    private Node node;
//	    private double clickX, clickY, nodeX, nodeY, nodeH, nodeW;
//	    private void setNewInitialEventCoordinates(MouseEvent event) {
//	        nodeX = nodeX();
//	        nodeY = nodeY();
//	        nodeH = nodeH();
//	        nodeW = nodeW();
//	        clickX = event.getX();
//	        clickY = event.getY();
//	    }
//	    
//		private boolean resizeZone=false;
////		private boolean stopResize=false;
//		private boolean dragZone=false;
//		private boolean mousePressed=false;
////		private boolean closeButton=false;
//		private double originalWidth;
//		private double originalHeight;
////		private double limitWidth=15;
////		private double limitHeight=15;
//		
//		private long counter=0;
//		private S globalPosition;
//		
//		ContextMenu dropDownMenu = new ContextMenu();
//		MenuItem mnuDelete = new MenuItem("Elimina");
////		MenuItem mnuCambiaTitolo = new MenuItem("Cambia Titolo");
////		ColorPicker colorssPicker = new ColorPicker();
////		MenuItem mnuColoreBordo = new MenuItem("Colore bordo");
////		MenuItem mnuColoreBordo = new MenuItem(null, colorssPicker);
//		
//		
//	    public Rettangolo(double x, double y, double width, double height) {
//		super(x,y,width,height);
////		System.out.println(getX());
////		System.out.println(getLayoutX());
////	    colorssPicker.setStyle("-fx-background-color: transparent;");		
////	    colorssPicker.setPromptText("Colore bordo");
//		qst=this;
////		btnClose.setMaxWidth(3);
////		btnClose.setMaxHeight(3);
//		
//		
////		dropDownMenu.getItems().add(mnuCambiaTitolo);
//		dropDownMenu.getItems().add(mnuDelete);
////		dropDownMenu.getItems().add(mnuColoreBordo);
//		
////		mnuCambiaTitolo.setOnAction(new EventHandler<ActionEvent>() {
////
////			@Override
////			public void handle(ActionEvent event) {
////				TextInputDialog dialog = new TextInputDialog(getTitolo().getText());
//////				dialog.setTitle("Text Input Dialog");
////				dialog.setHeaderText("Modifica del titolo");
////				dialog.setContentText("Nuovo titolo");
////				// Traditional way to get the response value.
////				Optional<String> result = dialog.showAndWait();
////				if (result.isPresent()){
////				TitoloForma tit = getTitolo();
////				tit.setText(result.get());
//////				tit.relocate(tit.getLayoutX(), tit.getLayoutY());
//////				    System.out.println("Your name: " + result.get());
////				}
////				
////			}
////		});
//		mnuDelete.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				panelBase.getChildren().remove(qst);
//				panelBase.getChildren().remove(qst.getTitolo());
//				
//				listaRects.remove(qst);
////				System.out.println(listaRects.size());
////				TextInputDialog dialog = new TextInputDialog(getTitolo().getText());
//////				dialog.setTitle("Text Input Dialog");
////				dialog.setHeaderText("Modifica del titolo");
////				dialog.setContentText("Nuovo titolo");
////				// Traditional way to get the response value.
////				Optional<String> result = dialog.showAndWait();
////				if (result.isPresent()){
////				TitoloForma tit = getTitolo();
////				tit.setText(result.get());
//////				tit.relocate(tit.getLayoutX(), tit.getLayoutY());
//////				    System.out.println("Your name: " + result.get());
////				}
//				
//			}
//		});
//		
//		//btnClose.setVisible(false);
////		btnClose.setMinHeight(3);
////		btnClose.setMinWidth(3);
////		btnClose.setPrefHeight(20);
////		btnClose.setPrefWidth(20);
////		btnClose.setAlignment(Pos.CENTER);
////		btnClose.setStyle("-fx-font-size:9; -fx-padding:0;");
//    		testo.setText("Titolo");
//		testo.setX(x+2);
//		testo.setY(y+11);
//		panelBase.getChildren().add(testo);
//		isDrawing=false;
////		btnClose.setLayoutY(y-1);
////		btnClose.setLayoutX(x+getWidth()-1);
////		btnClose.setOnMouseClicked(new EventHandler<MouseEvent>() {
////
////			@Override
////			public void handle(MouseEvent event) {
////				
////				System.out.println("mouse cliccato");
////				
////			}
////		});
////		btnClose.setOnMouseEntered(new EventHandler<MouseEvent>() {
////
////			@Override
////			public void handle(MouseEvent event) {
//////				closeButton=true;
////				setCursor(Cursor.DEFAULT);
////				
////			}
////		});
////		btnClose.setOnMouseMoved(new EventHandler<MouseEvent>() {
////
////			@Override
////			public void handle(MouseEvent event) {
////				setCursor(Cursor.DEFAULT);
////				
////			}
////		});
////		btnClose.setOnMouseExited(new EventHandler<MouseEvent>() {
////
////			@Override
////			public void handle(MouseEvent t) {
////				setCursor(getCursorForState(currentMouseState(t)));
//////				closeButton=false;
////				
////			}
////		});
////		panelBase.getChildren().add(btnClose);
//
//		setFill(Color.TRANSPARENT);
//		setStroke(Color.BLACK);
//		setStrokeWidth(1);
//		
////        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
////            @Override
////            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
////            	
////            		if (newValue) {
////            			//focus acquisito
////            			if (textField!=null) {
////    	                	Prodotto p = lstProdotti.getSelectionModel().getSelectedItem();
////    	                	if (p!=null)
////    	                    commitEdit(p.getCodice());
////            			}
////            		}
////            		else {
////            			//focus perso
////            			cancelEdit();
////            			isEditing=false;
////            		}
////            	
//
//		setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				if (event.getCode()==KeyCode.ESCAPE) {
//					System.out.println("Escape");
//				}
//				
//			}
//		});
//		
//		setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent t) {
////				if (event.getButton()!=MouseButton.SECONDARY) {
//					if (t.getClickCount()==2) {
//						selectedNode=(Rettangolo)(t.getSource());
//						openRettangolo(selectedNode);
////						txtTitolo.setText(selectedNode.getTitolo().getText());
////						selectedNode.setStroke(Color.BLUE);
////						selectedNode.getStrokeDashArray().addAll(5.0,5.0,5.0,5.0);
//					}
////					else if(event.getClickCount()==1) {
////						if (dropDownMenu.isShowing()) {
////							dropDownMenu.hide();
////						}
////					}
////				}
////				else {
////					Rettangolo rect = (Rettangolo)(event.getSource());
////					rect.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
////
////						@Override
////						public void handle(ContextMenuEvent event) {
////							dropDownMenu.show((Node)event.getSource(), event.getScreenX(), event.getScreenY());
////						}
////					});
//////					dropDownMenu.show((Node)event.getSource(), event.getSceneX(), event.getSceneY());
//////					panelBase.getChildren().add((Node)dropDownMenu);
////				}
//				
//			}
//
//			private void openRettangolo(Rettangolo selectedNode) {
//				txtTitolo.setDisable(false);
//				txtTitolo.setText(selectedNode.getTitolo().getText());
//				
//				Color borderColor = (Color) selectedNode.getStroke();
//				clrBordo.setValue(borderColor);
//				clrBordo.setDisable(false);
//				Color fillerColor = (Color) selectedNode.getFill();
//				clrSfondo.setValue(fillerColor);
//				clrSfondo.setDisable(false);
//				txtX.setText(selectedNode.getX() + translatedX+ "");
//				txtY.setText(selectedNode.getY() + translatedY + "");
//				txtX.setDisable(false);
//				txtY.setDisable(false);
//				txtWidth.setText(selectedNode.getWidth() + "");
//				txtHeight.setText(selectedNode.getHeight() + "");
//				txtWidth.setDisable(false);
//				txtHeight.setDisable(false);
//				
//				
//			}});
//		
//		setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
//
//			@Override
//			public void handle(ContextMenuEvent event) {
//				dropDownMenu.show((Node)event.getSource(), event.getScreenX(), event.getScreenY());
//			}
//		});
//		
//		
//		setOnMouseExited(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//
//				if(!mousePressed && !(isInResizeZone(event) || isInDragZone(event))) {
//					//btnClose.setVisible(false);
//					setCursor(Cursor.DEFAULT);
//					if (dropDownMenu.isShowing()) {
//						dropDownMenu.hide();
//					}
//				}
//				
//			}});
//		setOnMouseMoved(new EventHandler<MouseEvent>() {
////		setOnMouseEntered(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent t) {
//				//btnClose.setVisible(true);
//				if(!mousePressed) {
//					if (isInResizeZone(t)) {
//						setCursor(getCursorForState(currentMouseState(t)));
//						resizeZone=true;
//						dragZone=false;
//						Rettangolo rect = (Rettangolo)(t.getSource());
//						originalWidth = rect.getWidth();
//						originalHeight = rect.getHeight();
//						
////						System.out.println("Resize zone");
//					}
//					else if(isInDragZone(t)) {
//						setCursor(Cursor.OPEN_HAND);
//						resizeZone=false;
//						dragZone=true;
////						System.out.println("Drag zone");
//					}
//				}
//			}
//		});
//		
//		
//		setOnMouseReleased(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent t) {
//				mousePressed=false;
////				stopResize=false;
//				if (isInResizeZone(t)) {
//					setCursor(getCursorForState(currentMouseState(t)));
//					resizeZone=true;
//					dragZone=false;
//					Rettangolo rect = (Rettangolo)(t.getSource());
//					originalWidth = rect.getWidth();
//					
//					
////					btnClose.setLayoutX(t.getSceneX()+rect.getWidth());
////					btnClose.setLayoutY(rect.getLayoutY());
//					
////					System.out.println("Resize zone");
//				}
//				else if(isInDragZone(t)) {
//					setCursor(Cursor.OPEN_HAND);
//					resizeZone=false;
//					dragZone=true;
////					System.out.println("Drag zone");
//				}
//			}
//			
//		});
//		//gestisco la pressione del mouse
//		setOnMousePressed(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent t) {
//				mousePressed=true;
//				
//				if (resizeZone) {
//					globalPosition=currentMouseState(t);
//				}
//				else if (dragZone) {
//					setCursor(Cursor.CLOSED_HAND);
//					if (dropDownMenu.isShowing()) {
//						dropDownMenu.hide();
//					}
//				}
//				Rettangolo rect = (Rettangolo)(t.getSource());
//				
//				
////				if (isInResizeZone(t)) {
////					resizeZone=true;
////					dragZone=false;
////					originalWidth = rect.getWidth();
////					originalHeight=rect.getHeight();
////					
////				}
////				else if (isInDragZone(t)) {
////					resizeZone=false;
////					dragZone=true;
////				}
//				
////		        if (isInResizeZone(t)) {
////		            setNewInitialEventCoordinates(t);
////		            state = currentMouseState(t);
////		        } else if (isInDragZone(t)) {
////		            setNewInitialEventCoordinates(t);
////		            state = S.DRAG;
////		        } else {
////		            state = S.DEFAULT;
////		        }
//				
//	            orgSceneX = t.getSceneX();
////	            orgSceneX2 = btnClose.getLayoutX();
//	            orgSceneY = t.getSceneY();
////	            orgSceneY2 = btnClose.getLayoutY();
//	            orgTranslateX = ((Rettangolo)(t.getSource())).getTranslateX();
//	            orgTranslateY = ((Rettangolo)(t.getSource())).getTranslateY();
//			}
//		});
//		
//		
//		
//		
////		setOnMouseClicked(new EventHandler<MouseEvent>() {
////
////			@Override
////			public void handle(MouseEvent t) {
////				// TODO Auto-generated method stub
////				if (isInResizeZone(t)) {
////					System.out.println("Resize zone");
////				}
////				else if(isInDragZone(t)) {
////					System.out.println("Drag zone");
////				}
////				
////			}
////		});
//		
////		
////		setOnMouseExited(new EventHandler<MouseEvent>() {
////
////			@Override
////			public void handle(MouseEvent t) {
////				// TODO Auto-generated method stub
////				while (mousePressed)
////				if (resizeZone) {
////					Rettangolo rect = (Rettangolo)(t.getSource());
////					S position = currentMouseState(t);
////					double offsetX;
////					double newTranslateX;
////					
////		            double mouseX = t.getSceneX();
////		            double mouseY = t.getSceneY();
////
////					
////					switch (position) {
////					case NW_RESIZE:
////						//
////						break;
////					case SW_RESIZE:
////						//
////						break;
////					case NE_RESIZE:
////						//
////						break;
////					case SE_RESIZE:
////						//
////						break;
////					case E_RESIZE:
////						//dx
////			            offsetX = t.getSceneX() - orgSceneX;
//////			            double offsetY = t.getSceneY() - orgSceneY;
////			            newTranslateX = orgTranslateX + offsetX;
//////			            double newTranslateY = orgTranslateY + offsetY;
////			             
//////			            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
////			            
//////			            ((Rettangolo)(t.getSource())).setWidth(originalWidth+offsetX);
////			            rect.setWidth(originalWidth+offsetX);
////			            
//////			            ((Rettangolo)(t.getSource())).setWidth(((Rettangolo)(t.getSource())).getWidth()+1);
////			            
//////			            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
////						break;
////					case W_RESIZE:
////						//sx
////			            offsetX = t.getSceneX() - orgSceneX;
//////			            double offsetY = t.getSceneY() - orgSceneY;
////			            newTranslateX = orgTranslateX + offsetX;
//////			            double newTranslateY = orgTranslateY + offsetY;
////			             
////			            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
////			            
////			            ((Rettangolo)(t.getSource())).setWidth(originalWidth-offsetX);
//////			            ((Rettangolo)(t.getSource())).setWidth(((Rettangolo)(t.getSource())).getWidth()+1);
////			            
//////			            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
////						break;
////					case N_RESIZE:
////						//su
////						break;
////					default:
////						//S_RESIZE
////						break;
////					}
////				}
////			}});
////		
//		
//		//trascinamento del mouse
//		setOnMouseDragged(new EventHandler<MouseEvent>() {
//
//
//			@Override
//			public void handle(MouseEvent t) {
//				
//				
//				
//				if (selectedNode!=null) {
//					
//				Rettangolo rect = (Rettangolo)(t.getSource());
//				
//				
//				if (resizeZone) {
//					
////					if (!stopResize) {
//					
//					
////				S position = currentMouseState(t);
//					double offsetX;
//					double newTranslateX=0;
//					double offsetY;
//					double newTranslateY=0;
////					double offsetX2;
////					double newTranslateX2;
////					double offsetY2;
////					double newTranslateY2;
//				
//	            double mouseX = t.getSceneX();
//	            double mouseY = t.getSceneY();
//
//				
//				switch (globalPosition) {
//				case NW_RESIZE:
//					//
////		            offsetY2 = t.getSceneX() - orgSceneY2;
////		            newTranslateY2 = orgTranslateX + offsetY2;
//		            
//		            
//		            offsetX = t.getSceneX() - orgSceneX;
////		            double offsetY = t.getSceneY() - orgSceneY;
//		            newTranslateX = orgTranslateX + offsetX;
////		            double newTranslateY = orgTranslateY + offsetY;
//		             
//		            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
//		            
//		            ((Rettangolo)(t.getSource())).setWidth(originalWidth-offsetX);
//		            offsetY = t.getSceneY() - orgSceneY;
////		            double offsetY = t.getSceneY() - orgSceneY;
//		            newTranslateY = orgTranslateY + offsetY;
////		            double newTranslateY = orgTranslateY + offsetY;
//		             
//		            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
//		            
//		            ((Rettangolo)(t.getSource())).setHeight(originalHeight-offsetY);
//		            ((Rettangolo)(t.getSource())).getTitolo().setTranslateX(newTranslateX);
//		            ((Rettangolo)(t.getSource())).getTitolo().setTranslateY(newTranslateY);
////		            btnClose.setTranslateY(newTranslateY2);
////					txtX.setText(rect.getX()+newTranslateX + "");
////					txtY.setText(rect.getY()+newTranslateY + "");
//					break;
//				case SW_RESIZE:
//					//
//		            offsetX = t.getSceneX() - orgSceneX;
////		            double offsetY = t.getSceneY() - orgSceneY;
//		            newTranslateX = orgTranslateX + offsetX;
////		            double newTranslateY = orgTranslateY + offsetY;
//		             
//		            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
//		            
//		            ((Rettangolo)(t.getSource())).setWidth(originalWidth-offsetX);
//		            rect.setHeight(t.getY()-rect.getY());
//		            ((Rettangolo)(t.getSource())).getTitolo().setTranslateX(newTranslateX);
////					txtX.setText(rect.getX()+newTranslateX + "");
//					break;
//				case NE_RESIZE:
//					//
//					rect.setWidth(t.getX()-rect.getX());
//		            offsetY = t.getSceneY() - orgSceneY;
//		            newTranslateY = orgTranslateY + offsetY;
//		             
//		            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
//		            
//		            ((Rettangolo)(t.getSource())).setHeight(originalHeight-offsetY);
//		            ((Rettangolo)(t.getSource())).getTitolo().setTranslateY(newTranslateY);
//		            
////		            offsetX = t.getSceneX() - orgSceneX;
////		            newTranslateX = orgTranslateX + offsetX;
//		            
////		            offsetX2 = t.getSceneX() - orgSceneX2;
////		            newTranslateX2 = orgTranslateX + offsetX2;
////		            offsetY2 = t.getSceneY() - orgSceneY2;
////		            newTranslateY2 = orgTranslateY + offsetY2;
////		            
////		            btnClose.setTranslateX(newTranslateX2);
////		            btnClose.setTranslateY(newTranslateY2);
//		            
////					txtY.setText(rect.getY()+newTranslateY + "");
//					break;
//				case SE_RESIZE:
//					//
//					rect.setWidth(t.getX()-rect.getX());
//		            rect.setHeight(t.getY()-rect.getY());
////		            offsetX2 = t.getSceneX() - orgSceneX2;
////		            newTranslateX2 = orgTranslateX + offsetX2;
////		            btnClose.setTranslateX(newTranslateX2);
//					break;
//				case E_RESIZE:
//					//dx
////		            offsetX = t.getSceneX() - orgSceneX;
//////		            double offsetY = t.getSceneY() - orgSceneY;
////		            newTranslateX = orgTranslateX + offsetX;
//////		            double newTranslateY = orgTranslateY + offsetY;
////		             
//////		            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
////		            
//////		            ((Rettangolo)(t.getSource())).setWidth(originalWidth+offsetX);
////		            rect.setWidth(originalWidth+offsetX);
////		            
//////		            ((Rettangolo)(t.getSource())).setWidth(((Rettangolo)(t.getSource())).getWidth()+1);
////		            
//////		            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
//					
////					if (rect.getWidth()>limitWidth)
////		            offsetX2 = t.getSceneX() - orgSceneX2;
////		            newTranslateX2 = orgTranslateX + offsetX2;
////		            btnClose.setTranslateX(newTranslateX2);
//						rect.setWidth(t.getX()-rect.getX());
////					else {
////						rect.setWidth(limitWidth+1);
////						stopResize=true;
////					}
//						
//					break;
//				case W_RESIZE:
////					if (rect.getWidth()>limitWidth) {
//						//sx
//			            offsetX = t.getSceneX() - orgSceneX;
////			            double offsetY = t.getSceneY() - orgSceneY;
//			            newTranslateX = orgTranslateX + offsetX;
////			            double newTranslateY = orgTranslateY + offsetY;
//			             
//			            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
//			            
//			            ((Rettangolo)(t.getSource())).setWidth(originalWidth-offsetX);
////			            rect.setWidth(rect.getWidth()+newTranslateX);
////			            ((Rettangolo)(t.getSource())).setWidth(((Rettangolo)(t.getSource())).getWidth()+1);
//			            
////			            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
////					}
////					else {
////						rect.setWidth(limitWidth+1);
////						rect.setX(rect.getX()-1);
////						stopResize=true;
////					}
//					
//			            ((Rettangolo)(t.getSource())).getTitolo().setTranslateX(newTranslateX);
////						txtX.setText(rect.getX()+newTranslateX + "");
//					break;
//				case N_RESIZE:
////					if (rect.getHeight()>limitHeight) {
//						//su
//			            offsetY = t.getSceneY() - orgSceneY;
////			            double offsetY = t.getSceneY() - orgSceneY;
//			            newTranslateY = orgTranslateY + offsetY;
////			            double newTranslateY = orgTranslateY + offsetY;
//			             
//			            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
//			            
//			            ((Rettangolo)(t.getSource())).setHeight(originalHeight-offsetY);
////			            rect.setWidth(rect.getWidth()+newTranslateX);
////			            ((Rettangolo)(t.getSource())).setWidth(((Rettangolo)(t.getSource())).getWidth()+1);
//			            
////			            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
////					}
////					else {
////						rect.setHeight(limitHeight+1);
////						rect.setY(rect.getY()-1);
////						stopResize=true;
////					}
//			            ((Rettangolo)(t.getSource())).getTitolo().setTranslateY(newTranslateY);
////			            offsetY2 = t.getSceneY() - orgSceneY2;
////			            newTranslateY2 = orgTranslateY + offsetY2;
////			            
////			            btnClose.setTranslateY(newTranslateY2);
////						txtY.setText(rect.getY()+newTranslateY + "");
//					break;
//				default:
//					//S_RESIZE
////					if (rect.getHeight()>limitHeight)
//		            rect.setHeight(t.getY()-rect.getY());
////					else {
////						rect.setHeight(limitHeight+1);
////						stopResize=true;
////					}
//					break;
//				}
//	            if (selectedNode!=null) {
//					txtX.setText(rect.getX()+translatedX + "");
//					txtY.setText(rect.getY()+translatedY + "");
//					txtWidth.setText(rect.getWidth() + "");
//					txtHeight.setText(rect.getHeight() + "");
//	            }
////				}
//				
//				
//				}
//				else if(dragZone) {
//		            double offsetX = t.getSceneX() - orgSceneX;
//		            double offsetY = t.getSceneY() - orgSceneY;
//		            double newTranslateX = orgTranslateX + offsetX;
//		            double newTranslateY = orgTranslateY + offsetY;
//		            translatedX=newTranslateX;
//		            translatedY=newTranslateY;
//		             
//		            rect.setTranslateX(newTranslateX);
//		            rect.setTranslateY(newTranslateY);
//		            rect.getTitolo().setTranslateX(newTranslateX);
//		            rect.getTitolo().setTranslateY(newTranslateY);
//		            
//		            if (selectedNode!=null) {
//						txtX.setText(rect.getX()+newTranslateX + "");
//						txtY.setText(rect.getY()+newTranslateY + "");
//		            }
//				}
//			}
//				
//				
////				Rettangolo rect = (Rettangolo)(t.getSource());
////				
////				
////				if (isInResizeZone(t)) {
////					System.out.println("Resize zone");
////				}
////				else if(isInDragZone(t)) {
////		            double offsetX = t.getSceneX() - orgSceneX;
////		            double offsetY = t.getSceneY() - orgSceneY;
////		            double newTranslateX = orgTranslateX + offsetX;
////		            double newTranslateY = orgTranslateY + offsetY;
////		             
////		            rect.setTranslateX(newTranslateX);
////		            rect.setTranslateY(newTranslateY);
////				}
////				
////				
//////				if (resizeZone) {
//////					Rettangolo rect = (Rettangolo)(t.getSource());
//////					
//////					S position = currentMouseState(t);
//////					double offsetX;
//////					double offsetY;
//////					double newTranslateX;
//////		            double newTranslateY;
//////					switch (position) {
//////					case NW_RESIZE:
//////						//
//////						break;
//////					case SW_RESIZE:
//////						//
//////						break;
//////					case NE_RESIZE:
//////						//
//////						break;
//////					case SE_RESIZE:
//////						//
//////						break;
//////					case E_RESIZE:
//////						//dx
//////			            offsetX = t.getSceneX() - orgSceneX;
////////			            double offsetY = t.getSceneY() - orgSceneY;
//////			            newTranslateX = orgTranslateX + offsetX;
////////			            double newTranslateY = orgTranslateY + offsetY;
//////			             
////////			            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
//////			            
////////			            ((Rettangolo)(t.getSource())).setWidth(originalWidth+offsetX);
//////			            rect.setWidth(originalWidth+offsetX);
////////			            ((Rettangolo)(t.getSource())).setWidth(((Rettangolo)(t.getSource())).getWidth()+1);
//////			            
////////			            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
//////						break;
//////					case W_RESIZE:
//////						//sx
//////			            offsetX = t.getSceneX() - orgSceneX;
////////			            double offsetY = t.getSceneY() - orgSceneY;
//////			            newTranslateX = orgTranslateX + offsetX;
////////			            double newTranslateY = orgTranslateY + offsetY;
//////			             
//////			            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
//////			            
//////			            ((Rettangolo)(t.getSource())).setWidth(originalWidth-offsetX);
////////			            ((Rettangolo)(t.getSource())).setWidth(((Rettangolo)(t.getSource())).getWidth()+1);
//////			            
////////			            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
//////						break;
//////					case N_RESIZE:
//////						//su
//////						break;
//////					default:
//////						//S_RESIZE
//////						break;
//////					}
//////					
//////					
//////					
//////				}
//////				else if (dragZone){
//////					System.out.println("dragZone");
////					
////				
////////		        if (listener != null) {
////////		            double mouseX = parentX(t.getX());
////////		            double mouseY = parentY(t.getY());
//////		            
//////		            double mouseX = t.getX();
//////		            double mouseY = t.getY();
//////		            
//////		            
//////		            if (state == S.DRAG) {
//////			            setLayoutX(mouseX - clickX);
//////			            setLayoutY(mouseY - clickY);
////////			            // TODO find generic way to set width and height of any node
////////			            // here we cant set height and width to node directly.
////////			            // or i just cant find how to do it,
////////			            // so you have to wright resize code anyway for your Nodes...
////////			            //something like this
////////			            if (node instanceof Canvas) {
////////			                ((Canvas) node).setWidth(w);
////////			                ((Canvas) node).setHeight(h);
////////			            } else if (node instanceof Rectangle) {
////////			                ((Rectangle) node).setWidth(w);
////////			                ((Rectangle) node).setHeight(h);
////////			            }
//////			            
//////			            setWidth(nodeW);
//////			            setHeight(nodeH);
//////			            
//////			            
////////		                listener.onDrag(this, mouseX - clickX, mouseY - clickY, nodeH, nodeW);
//////		            	
////////			            double offsetX = t.getSceneX() - orgSceneX;
////////			            double offsetY = t.getSceneY() - orgSceneY;
////////			            double newTranslateX = orgTranslateX + offsetX;
////////			            double newTranslateY = orgTranslateY + offsetY;
////////			             
////////			            ((Rettangolo)(t.getSource())).setTranslateX(newTranslateX);
////////			            ((Rettangolo)(t.getSource())).setTranslateY(newTranslateY);
//////
//////		            } else if (state != S.DEFAULT) {
//////		                //resizing
//////		                double newX = nodeX;
//////		                double newY = nodeY;
//////		                double newH = nodeH;
//////		                double newW = nodeW;
//////
//////		                // Right Resize
//////		                if (state == S.E_RESIZE || state == S.NE_RESIZE || state == S.SE_RESIZE) {
//////		                    newW = mouseX - nodeX;
//////		                }
//////		                // Left Resize
//////		                if (state == S.W_RESIZE || state == S.NW_RESIZE || state == S.SW_RESIZE) {
//////		                    newX = mouseX;
//////		                    newW = nodeW + nodeX - newX;
//////		                }
//////
//////		                // Bottom Resize
//////		                if (state == S.S_RESIZE || state == S.SE_RESIZE || state == S.SW_RESIZE) {
//////		                    newH = mouseY - nodeY;
//////		                }
//////		                // Top Resize
//////		                if (state == S.N_RESIZE || state == S.NW_RESIZE || state == S.NE_RESIZE) {
//////		                    newY = mouseY;
//////		                    newH = nodeH + nodeY - newY;
//////		                }
//////
//////		                //min valid rect Size Check
//////		                if (newW < MIN_W) {
//////		                    if (state == S.W_RESIZE || state == S.NW_RESIZE || state == S.SW_RESIZE)
//////		                        newX = newX - MIN_W + newW;
//////		                    newW = MIN_W;
//////		                }
//////
//////		                if (newH < MIN_H) {
//////		                    if (state == S.N_RESIZE || state == S.NW_RESIZE || state == S.NE_RESIZE)
//////		                        newY = newY + newH - MIN_H;
//////		                    newH = MIN_H;
//////		                }
//////
//////			            setLayoutX(newX);
//////			            setLayoutY(newY);
//////			            setWidth(newW);
//////			            setHeight(newH);
////////		                listener.onResize(this, newX, newY, newH, newW);
//////		                
//////		            }
////////		        }
//////				
//////	            double offsetX = t.getSceneX() - orgSceneX;
//////	            double offsetY = t.getSceneY() - orgSceneY;
//////	            double newTranslateX = orgTranslateX + offsetX;
//////	            double newTranslateY = orgTranslateY + offsetY;
//////	             
//////	            rect.setTranslateX(newTranslateX);
//////	            rect.setTranslateY(newTranslateY);
//////			}
//////				else {
//////					System.out.println("nZone");
//////				}
//		}
//
//		});
//		
//		
//		
//		
//		
//		
////		//WTF?
////		setOnMouseMoved(new EventHandler<MouseEvent>() {
////
////			@Override
////			public void handle(MouseEvent event) {
////				
////////				isInDragZone(event);
//////				isInResizeZone(event);
////				
////				if (!resizeZone) {
////			        S state = currentMouseState(event);
////			        Cursor cursor = getCursorForState(state);
//////			        node.setCursor(cursor);
////			        setCursor(cursor);
////				}
////				
////			}});
////		
//		
//		
//		
////		//mouse rilasciato
////		setOnMouseReleased(new EventHandler<MouseEvent>() {
////
////			@Override
////			public void handle(MouseEvent event) {
////		        setCursor(Cursor.DEFAULT);
////		        state = S.DEFAULT;
////			}});
//	}
//	
//	
//	
//	}
//	

	
	
	
//	private static enum S {
//	    DEFAULT,
//	    DRAG,
//	    NW_RESIZE,
//	    SW_RESIZE,
//	    NE_RESIZE,
//	    SE_RESIZE,
//	    E_RESIZE,
//	    W_RESIZE,
//	    N_RESIZE,
//	    S_RESIZE;
//	}
	
	
//	private class Content extends Rectangle{
//		
//		private S getMouseState(MouseEvent event) {
//	        S state = S.DEFAULT;
//	        boolean left = isLeftResize(event);
//	        boolean right = isRightResize(event);
//	        boolean top = isTopResize(event);
//	        boolean bottom = isBottomResize(event);
//
//	        if (left && top) state = S.NW_RESIZE;
//	        else if (left && bottom) state = S.SW_RESIZE;
//	        else if (right && top) state = S.NE_RESIZE;
//	        else if (right && bottom) state = S.SE_RESIZE;
//	        else if (right) state = S.E_RESIZE;
//	        else if (left) state = S.W_RESIZE;
//	        else if (top) state = S.N_RESIZE;
//	        else if (bottom) state = S.S_RESIZE;
//	        else state = S.DRAG;
////		        else if (isInDragZone(event)) state = S.DRAG;
//
//	        return state;
//		}
//	    private Cursor getCursorFromState(S state) {
//	        switch (state) {
//	            case NW_RESIZE:
//	                return Cursor.NW_RESIZE;
//	            case SW_RESIZE:
//	                return Cursor.SW_RESIZE;
//	            case NE_RESIZE:
//	                return Cursor.NE_RESIZE;
//	            case SE_RESIZE:
//	                return Cursor.SE_RESIZE;
//	            case E_RESIZE:
//	                return Cursor.E_RESIZE;
//	            case W_RESIZE:
//	                return Cursor.W_RESIZE;
//	            case N_RESIZE:
//	                return Cursor.N_RESIZE;
//	            case S_RESIZE:
//	                return Cursor.S_RESIZE;
//	            case DRAG:
//	                return Cursor.OPEN_HAND;
//	            default:
//	                return Cursor.DEFAULT;
//	        }
//	    }
//	    private static final float MARGIN = 2.5f;
//	    private static final float DRAWMARGIN = 1.0f;
//		private boolean isSelected=false;
//		
//		private boolean isInResizeZone(MouseEvent event) {
//			return isLeftResize(event) || isTopResize(event) || isRightResize(event) || isBottomResize(event);
//		}
//		private boolean isBottomResize(MouseEvent event) {
//	        return intersect(getY() + getHeight(), event.getY());
//		}
//		private boolean isRightResize(MouseEvent event) {
//	        return intersect(getX()+getWidth(), event.getX());
//		}
//		private boolean isTopResize(MouseEvent event) {
//	        return intersect(getY(), event.getY());
//		}
//		private boolean isLeftResize(MouseEvent event) {
//	        return intersect(getX(), event.getX());
//		}
//	    private boolean intersect(double side, double point) {
//	        return side + MARGIN > point && side - MARGIN < point;
//	    }
////		private boolean isInDragZone() {
////			boolean dragZone=false;
////			
////			return dragZone;
////		}
//		
//////		private class TitoloForma extends Text{
//////			
//////		}
////		
//////		ChangeListener<Boolean> focusListener = new ChangeListener<Boolean>() {
//////			@Override
//////			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//////        		if (newValue) {
//////        			//focus acquisito
//////        			System.out.println("focus acquisito");
//////        		}
//////        		else {
//////        			//focus perso
//////        			System.out.println("focus perso");
//////        		}
//////			}
//////			
//////		};
//		private double orgSceneX;
//		private double orgSceneY;
//		private double orgTranslateX;
//		private double orgTranslateY;
//		private double offsetX;
//		private double offsetY;
//		private EventHandler<MouseEvent> mouseClicked = new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent t) {
//				if (t.getClickCount()==2) {
//					isSelected=true;
//					setStroke(Color.BLUE);
//					rettangolo=(Content) t.getSource();
//				}
//				
//				
//			}};
//
//			private EventHandler<MouseEvent> mousePressed = new EventHandler<MouseEvent>() {
//
//				@Override
//				public void handle(MouseEvent t) {
//					if (isDragging()) {
//						setCursor(Cursor.CLOSED_HAND);
//						
//						orgSceneX = t.getSceneX();
//						orgSceneY = t.getSceneY();
//						
//						Content rect = (Content)(t.getSource());
//						orgTranslateX=rect.getTranslateX();
//						orgTranslateY=rect.getTranslateY();
//					}
//					else {
//						
//					}
//					
//				}};
//				private EventHandler<MouseEvent> mouseReleased = new EventHandler<MouseEvent>() {
//					@Override
//					public void handle(MouseEvent event) {
//						setCursor(getCursorFromState(getMouseState(event)));
//						
//					}};
//					private EventHandler<MouseEvent> mouseDragged = new EventHandler<MouseEvent>() {
//						@Override
//						public void handle(MouseEvent t) {
//							if (rettangolo!=null) {
//					            double offsetX = t.getSceneX() - orgSceneX;
//					            double offsetY = t.getSceneY() - orgSceneY;
//					            double newTranslateX = orgTranslateX + offsetX;
//					            double newTranslateY = orgTranslateY + offsetY;
////					            translatedX=newTranslateX;
////					            translatedY=newTranslateY;
//					             
//					            setTranslateX(newTranslateX);
//					            setTranslateY(newTranslateY);
//					            getTitolo().setTranslateX(newTranslateX);
//					            getTitolo().setTranslateY(newTranslateY);
//					            
////					            if (selectedNode!=null) {
////									txtX.setText(rect.getX()+newTranslateX + "");
////									txtY.setText(rect.getY()+newTranslateY + "");
////					            }
//							}
//						}};
//			
//			
//			
//			private EventHandler<MouseEvent> mouseMoved = new EventHandler<MouseEvent>() {
//				@Override
//				public void handle(MouseEvent event) {
////					System.out.println(event.getX() + " - " + event.getY());
//					setCursor(getCursorFromState(getMouseState(event)));
//					if (isInResizeZone(event)) {
//						//resize Zone
//						setResize();
//					}
//					else {
//						//drag Zone
//						setDrag();
//					}
//					
//					
//				}
//
//				};
//		
//		
//		
//		
//		Text titolo=null;
//		private boolean dragZone=false;
//		private boolean resizeZone=false;
//
//		public Text getTitolo() {
//			return titolo;
//		}
//
//		private void setDrag() {
//			dragZone = true;
//			resizeZone=false;
//			
//		}
//		private void setResize() {
//			dragZone = false;
//			resizeZone=true;
//		}
//		
//		private boolean isResizing() {
//			return resizeZone;
//		}
//		private boolean isDragging() {
//			return dragZone;
//		}
//		
//		
//		public void setTitolo(String t) {
//			titolo = new Text(t);
//			titolo.setX(x+2);
//			titolo.setY(y+12);
//		}
//
//		public Content(double x, double y, double width, double height) {
//			super(x,y,width,height);
//			setFill(Color.TRANSPARENT);
//			setStroke(Color.BLACK);
//			setStrokeWidth(DRAWMARGIN);
//			
////	        focusedProperty().addListener(focusListener);
//			
//			
//			setOnMouseClicked(mouseClicked);
////			setOnMouseExited(null);
//			setOnMouseMoved(mouseMoved);
////			setOnMouseEntered(null);
//			setOnMouseReleased(mouseReleased);
//			setOnMousePressed(mousePressed);
//			setOnMouseDragged(mouseDragged);
//			
//		}
//	
//		
//		
//	}


//	public void drawContent() {
//		Content rect= new Content(x,y,width,height);//già colorato col colore nero di base
//		rect.setTitolo(titolo);
//		
//        panel.getChildren().add(rect.getTitolo());
//        panel.getChildren().add(rect);
//        rect.toFront();
//		
//	}
	
	
	
}