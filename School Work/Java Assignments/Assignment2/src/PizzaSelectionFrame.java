import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PizzaSelectionFrame extends JFrame
{
    String orderSize = "small";
    String orderToppings = "chicken";
    String orderPizza = "chicken";
    String orderMushrooms ="";
    String orderBacon = "";
    public PizzaSelectionFrame()
    {
        setLayout(new FlowLayout());


        //combobox String
        String[] pizzas = {"Chicken", "Veggie", "Pepperoni"};
        this.setTitle("Order Pizza");
        JComboBox pizzaList = new JComboBox(pizzas);
        add(pizzaList);
        this.setBackground(Color.LIGHT_GRAY);

        ImageIcon  pizzaPic = new ImageIcon("C:\\Users\\Samuel\\IdeaProjects\\Java 2\\Assigment2\\src\\chicken.png");
        JLabel pizzaLabel = new JLabel(pizzaPic);
        pizzaLabel.setIcon(pizzaPic);

        //action listener else if for picture and selected items
        pizzaList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                if(pizzaList.getSelectedIndex() == 0)
                {
                    ImageIcon temppic = new ImageIcon("C:\\Users\\Samuel\\IdeaProjects\\Java 2\\Assigment2\\src\\chicken.png");
                   pizzaLabel.setIcon(temppic);
                   orderPizza = "chicken";
                }
                else if (pizzaList.getSelectedIndex() == 1)
                {
                    ImageIcon temppic = new ImageIcon("C:\\Users\\Samuel\\IdeaProjects\\Java 2\\Assigment2\\src\\veggie.png");
                    pizzaLabel.setIcon(temppic);
                    orderPizza = "veggie";
                }
                else
                {
                    ImageIcon temppic = new ImageIcon("C:\\Users\\Samuel\\IdeaProjects\\Java 2\\Assigment2\\src\\pepperoni.png");
                    pizzaLabel.setIcon(temppic);
                    orderPizza = "pepperoni";
                }


            }
        });
        //radio button grous and action listeners
        JLabel sizeSelect = new JLabel("Select Size:");
        JRadioButton small = new JRadioButton("Small");
        small.setSelected(true);
        small.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(small.isSelected())
                {
                     orderSizeString("small size");


                }
            }
        });


        JRadioButton medium = new JRadioButton("Medium");
        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                orderSizeString("medium size");
            }
        });
        JRadioButton large = new JRadioButton("Large");
        large.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                orderSizeString("large size");
            }
        });
        //button group
        ButtonGroup size = new ButtonGroup();
        size.add(small);
        size.add(medium);
        size.add(large);



        //toppings buttons and action listeners
        JLabel toppings = new JLabel("Select Topping(s): ");
        JCheckBox mushroom = new JCheckBox("Mushroom");
        mushroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderMushrooms = "Mushrooms";
            }
        });
        JCheckBox bacon = new JCheckBox("Bacon");
        bacon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(orderMushrooms == "Mushrooms")
                {
                    orderBacon = "and Bacon";
                }
                else
                {
                    orderBacon = "Bacon";
                }

            }
        });


        //submit button and action listener
        JButton submit = new JButton("Submit Order");


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String orderSummary = ("Order Summary: "+orderSize+" "+orderPizza+" with "+orderMushrooms+" " +orderBacon);
                int x = JOptionPane.showConfirmDialog(submit, orderSummary, "Confirmation", JOptionPane.OK_CANCEL_OPTION);
                if (x == 0)
                {
                    PaymentFrame pframe = new PaymentFrame();
                    pframe.setBackground(Color.LIGHT_GRAY);
                    pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    pframe.setSize(600, 200);
                    pframe.setVisible(true);
                }

            }
        });

        //adding all componenets
        add(pizzaLabel);
        add(pizzaList);
        add(sizeSelect);
        add(small);
        add(medium);
        add(large);
        add(toppings);
        add(mushroom);
        add(bacon);
        add(submit);
    }


    public void orderSizeString(String str)
    {
        orderSize = str;

    }
}
