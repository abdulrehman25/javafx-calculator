/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator3;

import com.sun.org.apache.xalan.internal.lib.ExsltMath;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Abdul Rehman
 */
public class Calculator3 extends Application {
    String answer = "";
    String input1;
    String input2;
    String mathOpr;
    Boolean answered = false;
    TextField txtInput = new TextField();
    Button btnDot = new Button(".");
    Button btnZero = new Button("0");
    Button btnOne = new Button("1");
    Button btnTwo = new Button("2");
    Button btnThree = new Button("3");
    Button btnFour = new Button("4");
    Button btnFive = new Button("5");
    Button btnSix = new Button("6");
    Button btnSeven = new Button("7");
    Button btnEight = new Button("8");
    Button btnNine = new Button("9");
    
    Button btnHistory = new Button("H");
    Button btnClear = new Button("C");
    Button btnRemove = new Button("x");
    //Mathematical operations buttons
    Button btnSign = new Button("+/-");
    Button btnEqual = new Button("=");
    Button btnPlus = new Button("+");
    Button btnSub = new Button("-");
    Button btnMul = new Button("*");
    Button btnDiv = new Button("/");
    Button btnMod = new Button("%");
    Button btnSquare = new Button("Sqr");
    Button btnSquareRoot = new Button("√");
    Button btnOneByX = new Button("1/x");
    Button btnCube = new Button("Cub");
        
    @Override
    public void start(Stage ps) {
        //Controls
        
//        txtInput.setPadding(new Insets(20,20,20,20));
        txtInput.getStyleClass().add("custom");
        txtInput.editableProperty().set(false);
//        txtInput.setMaxSize(200, 50);
       
        
        btnStyle(btnHistory, "btnOpr");
        btnStyle(btnClear, "btnOpr");
        btnStyle(btnRemove, "btnOpr");
//        btnClear.setPadding(new Insets(20,20,20,20));
        btnStyle(btnSign, "btnOpr");
        btnStyle(btnEqual, "btnOpr");
        btnStyle(btnPlus, "btnOpr");
        btnStyle(btnSub, "btnOpr");
        btnStyle(btnMul, "btnOpr");
        btnStyle(btnDiv, "btnOpr");
        btnStyle(btnMod, "btnOpr");
        btnStyle(btnSquare, "btnOpr");
        btnStyle(btnSquareRoot, "btnOpr");
        btnStyle(btnDot, "btnOpr");
        btnStyle(btnOneByX, "btnOpr");
        btnStyle(btnCube, "btnOpr");
       //Digits buttons
       
        btnStyle(btnOne, "btnNo");
        btnStyle(btnTwo, "btnNo");
        btnStyle(btnThree, "btnNo");
        btnStyle(btnFour, "btnNo");
        btnStyle(btnFive, "btnNo");
        btnStyle(btnSix, "btnNo");
        btnStyle(btnSeven, "btnNo");
        btnStyle(btnEight, "btnNo");
        btnStyle(btnNine, "btnNo");
        btnStyle(btnZero, "btnNo");
        
        //Clear the screen
        btnClear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                txtInput.setText("");
                mathOpr = "";
                input1 = "";
                input2 = "";
                answer = "";
                answered = false;
                txtInput.editableProperty().set(false);
            }
        });
        //Adding values from respective button Using setNumber() function
        setNumber(btnZero, "0");
        setNumber(btnOne, "1");
        setNumber(btnTwo, "2");
        setNumber(btnThree, "3");
        setNumber(btnFour, "4");
        setNumber(btnFive, "5");
        setNumber(btnSix, "6");
        setNumber(btnSeven, "7");
        setNumber(btnEight, "8");
        setNumber(btnNine, "9");
        setNumber(btnDot, ".");
        //perform mathematical operations on numbers
        performOperation(btnPlus, "+");
        performOperation(btnSub, "-");
        performOperation(btnMul, "*");
        performOperation(btnDiv, "/");
        performOperation(btnMod, "%");
        
        //Calculate the Answer
        btnEqual.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                if(txtInput.getText() == "")
                {
                    
                }
                else
                {
                    input2 = txtInput.getText();
                    
                    if((isDorPresent(input1)) && (isDorPresent(input2)))
                    {
                        Double firstPara = Double.parseDouble(input1);
                        Double secondPara = Double.parseDouble(input2);
                        
                        System.out.println(firstPara);
                        System.out.println(secondPara);
                   
                        switch(mathOpr)
                        {
                            case "+":
                                answer = String.valueOf(firstPara + secondPara);
                                break;
                            case "-":
                                answer = String.valueOf(firstPara - secondPara);
                                break;
                            case "*":
                                answer = String.valueOf(firstPara * secondPara);
                                break;
                            case "/":
                                answer = String.valueOf(firstPara / secondPara);
                                break;
                            case "%":
                                answer = String.valueOf(firstPara % secondPara);
                                break;
                            case "sqr":
                                answer = String.valueOf(firstPara * firstPara);
                                break;
                            case "sqrt":
                                answer = String.valueOf(ExsltMath.power(firstPara, 0.5));
                                break;
                            default:
                                txtInput.setText("");
                                break;
                        }
                    }
                    else if((isDorPresent(input1) == false) && (isDorPresent(input1) == false))
                    {
                        Integer firstPara = Integer.parseInt(input1);
                        Integer secondPara = Integer.parseInt(input2);
                        
                        System.out.println(firstPara);
                        System.out.println(secondPara);

                        switch(mathOpr)
                        {
                            case "+":
                                answer = String.valueOf(firstPara + secondPara);
                                break;
                            case "-":
                                answer = String.valueOf(firstPara - secondPara);
                                break;
                            case "*":
                                answer = String.valueOf(firstPara * secondPara);
                                break;
                            case "/":
                                answer = String.valueOf(firstPara / secondPara);
                                break;
                            case "%":
                                answer = String.valueOf(firstPara % secondPara);
                                break;
                            case "sqr":
                                answer = String.valueOf(firstPara * firstPara);
                                break;
                            case "sqrt":
                                answer = String.valueOf(ExsltMath.power(firstPara, 0.5));
                                break;
                            default:
                                txtInput.setText("");
                                break;
                        }
                    }
                    
                    else if((isDorPresent(input1)) && (isDorPresent(input2) == false))
                    {
                        Double firstPara = Double.parseDouble(input1);
                        Integer secondPara = Integer.parseInt(input2);
                        
                        System.out.println(firstPara);
                        System.out.println(secondPara);

                        switch(mathOpr)
                        {
                            case "+":
                                answer = String.valueOf(firstPara + secondPara);
                                break;
                            case "-":
                                answer = String.valueOf(firstPara - secondPara);
                                break;
                            case "*":
                                answer = String.valueOf(firstPara * secondPara);
                                break;
                            case "/":
                                answer = String.valueOf(firstPara / secondPara);
                                break;
                            case "%":
                                answer = String.valueOf(firstPara % secondPara);
                                break;
                            case "sqr":
                                answer = String.valueOf(firstPara * firstPara);
                                break;
                            case "sqrt":
                                answer = String.valueOf(ExsltMath.power(firstPara, 0.5));
                                break;
                            default:
                                txtInput.setText("");
                                break;
                        }
                    }
                    
                    else if((isDorPresent(input1) == false) && (isDorPresent(input2)))
                    {
                        Integer firstPara = Integer.parseInt(input1);
                        Double secondPara = Double.parseDouble(input2);
                        
                        System.out.println(firstPara);
                        System.out.println(secondPara);

                        switch(mathOpr)
                        {
                            case "+":
                                answer = String.valueOf(firstPara + secondPara);
                                break;
                            case "-":
                                answer = String.valueOf(firstPara - secondPara);
                                break;
                            case "*":
                                answer = String.valueOf(firstPara * secondPara);
                                break;
                            case "/":
                                answer = String.valueOf(firstPara / secondPara);
                                break;
                            case "%":
                                answer = String.valueOf(firstPara % secondPara);
                                break;
                            case "sqr":
                                answer = String.valueOf(firstPara * firstPara);
                                break;
                            case "sqrt":
                                answer = String.valueOf(ExsltMath.power(firstPara, 0.5));
                                break;
                            default:
                                txtInput.setText("");
                                break;
                        }
                    }
                   
                    if(answer != "")
                    {
                        answered = true;
                        txtInput.setText(answer);
                    }
                }
                txtInput.editableProperty().set(false);
            }
        });
//Calculate the Square Answer
        btnSquare.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                if(txtInput.getText() == "")
                {
                    
                }
                else
                {
                    input1 = txtInput.getText();
                    Double firstPara = Double.parseDouble(input1);
                    System.out.println(firstPara);
                    String answer = "";
                    answer = String.valueOf(firstPara * firstPara);
                    if(answer != "")
                    {
                        txtInput.setText(answer);
                    }
                }
                txtInput.editableProperty().set(false);
            }
        });
//Calculate the Cube Answer
        btnCube.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                if(txtInput.getText() == "")
                {
                    
                }
                else
                {
                    input1 = txtInput.getText();
                    Double firstPara = Double.parseDouble(input1);
                    System.out.println(firstPara);
                    String answer = "";
                    answer = String.valueOf(Math.pow(firstPara, 3));
                    if(answer != "")
                    {
                        txtInput.setText(answer);
                    }
                }
                txtInput.editableProperty().set(false);
            }
        });        
//Change the Sign
        btnSign.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                if(txtInput.getText() == "")
                {
                    
                }
                else
                {
                    input1 = txtInput.getText();
                    Double firstPara = Double.parseDouble(input1);
                    if(firstPara > 0)
                    {
                        firstPara = firstPara * -1;
                    }
                    else if (firstPara < 0)
                    {
                        firstPara = firstPara * -1; 
                    }
                    System.out.println(firstPara);
                    String answer = "";
                    answer = String.valueOf(firstPara);
                    if(answer != "")
                    {
                        txtInput.setText(answer);
                    }
                }
                txtInput.editableProperty().set(false);
            }
        });        
//Change the Sign
        btnOneByX.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                if(txtInput.getText() == "")
                {
                    
                }
                else
                {
                    input1 = txtInput.getText();
                    Double firstPara = Double.parseDouble(input1);
                    System.out.println(firstPara);
                    String answer = "";
                    answer = String.valueOf(1/firstPara);
                    if(answer != "")
                    {
                        txtInput.setText(answer);
                    }
                }
                txtInput.editableProperty().set(false);
            }
        });        
//Calculate the Square Root Answer
        btnSquareRoot.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                if(txtInput.getText() == "")
                {
                    
                }
                else
                {
                    input1 = txtInput.getText();
                    Double firstPara = Double.parseDouble(input1);
                    System.out.println(firstPara);
                    String answer = "";
                    answer = String.valueOf(ExsltMath.power(firstPara, 0.5));
                    if(answer != "")
                    {
                        txtInput.setText(answer);
                    }
                }
                txtInput.editableProperty().set(false);
            }
        });
        //Calculate the Answer
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                String any = txtInput.getText();
                txtInput.setText("");
                Integer a = any.length();
                String subInput = any.substring(0, a-1);
                txtInput.setText(subInput);
                txtInput.editableProperty().set(false);
            }
        });
        GridPane hPane1 = new GridPane();
        hPane1.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
//       hPane1.setAlignment(Pos.CENTER);
        hPane1.setGridLinesVisible(true);
//        hPane1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        ColumnConstraints column1 = new ColumnConstraints();

column1.setPercentWidth(100);

ColumnConstraints column2 = new ColumnConstraints();

column2.setPercentWidth(100);
ColumnConstraints column3 = new ColumnConstraints();

column3.setPercentWidth(100);

ColumnConstraints column4 = new ColumnConstraints();

column4.setPercentWidth(100);

//ColumnConstraints column5 = new ColumnConstraints();
//
//column5.setPercentWidth(100);


hPane1.getColumnConstraints().addAll(column1, column2,column3,column4);

RowConstraints rowConstraints1=new RowConstraints();
rowConstraints1.setPercentHeight(100);

RowConstraints rowConstraints2=new RowConstraints();
rowConstraints2.setPercentHeight(100);

RowConstraints rowConstraints3=new RowConstraints();
rowConstraints3.setPercentHeight(100);

RowConstraints rowConstraints4=new RowConstraints();
rowConstraints4.setPercentHeight(100);

RowConstraints rowConstraints5=new RowConstraints();
rowConstraints5.setPercentHeight(100);

RowConstraints rowConstraints6=new RowConstraints();
rowConstraints6.setPercentHeight(100);
RowConstraints rowConstraints7=new RowConstraints();
rowConstraints7.setPercentHeight(100);

hPane1.getRowConstraints().
//
addAll(rowConstraints1,rowConstraints2,rowConstraints3,rowConstraints4,rowConstraints5,rowConstraints6,rowConstraints7);
        
        txtInput.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        hPane1.add(txtInput,0,0,4,1);
//        hPane1.add(btnHistory,4,0);
        
        hPane1.add(btnClear,0,1);
        hPane1.add(btnSquareRoot,1,1);
        hPane1.add(btnMod,2,1);
        hPane1.add(btnOneByX,3,1);
        
        hPane1.add(btnRemove,0,2);
        hPane1.add(btnCube,1,2);
        hPane1.add(btnSquare,2,2);
        hPane1.add(btnDiv,3,2);
        
        
//second row
        hPane1.add(btnSeven,0,3);
        hPane1.add(btnEight,1,3);
        hPane1.add(btnNine,2,3);
        hPane1.add(btnMul,3,3);
// 3rd row
        hPane1.add(btnFour,0,4);
        hPane1.add(btnFive,1,4);
        hPane1.add(btnSix,2,4);
        hPane1.add(btnSub,3,4);        
//4th row        
        hPane1.add(btnOne,0,5);
        hPane1.add(btnTwo,1,5);
        hPane1.add(btnThree,2,5);
        hPane1.add(btnPlus,3,5);
// 5th row       
        hPane1.add(btnSign,0,6);
        hPane1.add(btnZero,1,6);
        hPane1.add(btnDot,2,6);
        hPane1.add(btnEqual,3,6);
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: rgba(0,0,0,0);");
        Scene scene = new Scene(hPane1);

////Menu bar Working
//// create a menu 
//        Menu m = new Menu("View"); 
//        Menu h = new Menu("History");
//        // create menuitems 
//        MenuItem m1 = new MenuItem("menu item 1"); 
//        MenuItem m2 = new MenuItem("menu item 2"); 
//        MenuItem m3 = new MenuItem("menu item 3"); 
//  // create menuitems 
//        MenuItem h1 = new MenuItem("menu item 1"); 
//        MenuItem h2 = new MenuItem("menu item 2"); 
//        MenuItem h3 = new MenuItem("menu item 3"); 
//        // add menu items to menu 
//        m.getItems().add(m1); 
//        m.getItems().add(m2); 
//        m.getItems().add(m3); 
//        // add menu items to menu 
//        h.getItems().add(h1); 
//        h.getItems().add(h2); 
//        h.getItems().add(h3); 
//  
//        // create a menubar 
//        MenuBar mb = new MenuBar(); 
//  
//        // add menu to menubar 
//        mb.getMenus().add(m); 
//          // add menu to menubar 
//        mb.getMenus().add(h);
//        // create a VBox 
//        VBox vb = new VBox(mb);
//        hPane1.add(vb,0,0);
        //Setup the icon or logo of the App
        Image icon = new Image(getClass().getResourceAsStream("/resources/icon.png"));
        ps.getIcons().add(icon);
        scene.getStylesheets().add(getClass().getResource("/resources/style.css").toExternalForm());
        GridPane.setHgrow(hPane1, Priority.ALWAYS);
        GridPane.setVgrow(hPane1, Priority.ALWAYS);
        hPane1.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #dc143c, #32cd32);");
        ps.initStyle(StageStyle.DECORATED);
        ps.setTitle("Calculator");
        ps.setX(100);
        ps.setY(100);
        ps.setMinWidth(400);
        ps.setMinHeight(600);
        
        ps.setMaxWidth(400);
        ps.setMaxHeight(600);
        
        ps.setScene(scene);
        ps.show();
    }
    public boolean isDorPresent(String inputStr)
    {
        for(int i=0; i< inputStr.length(); i++)
        {
            if(inputStr.charAt(i) == '.')
            {
                return true;
            }
        }
        return false;
    }
    public void btnStyle(Button btnSelect,String abc)
    {
        btnSelect.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        btnSelect.setPadding(new Insets(10,10,10,10));
        btnSelect.getStyleClass().add(abc);
    }
    public void setNumber(Button btnSelect,String inputNo)
    {
        btnSelect.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                txtInput.editableProperty().set(true);
                String abc = txtInput.getText();
                if(answered == true)
                {
                    txtInput.setText("");
                }
                if(abc != "")
                {
                    if(abc == "0")
                    {
                        txtInput.setText(inputNo);
                    }
                    else
                    {
                        txtInput.setText(abc + inputNo);
                    }
                }
                else
                {
                    txtInput.setText(inputNo);
                }
                txtInput.editableProperty().set(false);
            }
        });
    }
    public void performOperation(Button btnSelect,String opr)
    {
        btnSelect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                txtInput.editableProperty().set(true);
                mathOpr = opr;
                input1 = txtInput.getText();
                txtInput.setText("");
                txtInput.editableProperty().set(false);
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}