import java.awt.*;
import  java.awt.event.*;
import javax.swing.*;

// struct
class Model
{
    class Fruit
    {
        int count;
        int min = 0;
        int max = 8;

        boolean can_increment()
        {
            return count < max;
        }

        boolean can_decrement()
        {
            return count > min;
        }
    };
    Fruit fruit = new Fruit();
}

class Controller implements ActionListener
{
    IView view;
    Model model;
    
    Controller(Model model, IView view)
    {
        this.model = model;
        this.view  = view;
    }

    void register_fruit_count_change()
    {
        String label = String.format("%d", model.fruit.count);
        view.fruit_count_set_text(label);
        view.fruit_increment_button_set_enabled(model.fruit.can_increment());
        view.fruit_decrement_button_set_enabled(model.fruit.can_decrement());
    }

    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if(command == "+")
        {
                System.out.println("Dont let me down!");
                if(model.fruit.can_increment())
                {
                    ++model.fruit.count;
                    register_fruit_count_change();
                }
        }
        else if (command == "-")
        {
                System.out.println("Dont stop me now!");
                if(model.fruit.can_decrement())
                {
                    --model.fruit.count;
                    register_fruit_count_change();
                }
        }
    };
}

interface IView
{ 
    void fruit_count_set_text(String text);
    void fruit_increment_button_set_enabled(boolean enabled);
    void fruit_decrement_button_set_enabled(boolean enabled);
}

class VueGSwing extends JFrame implements IView
{
    public JLabel  fruit_count;
    public JButton fruit_increment_button;
    public JButton fruit_decrement_button;
    public VueGSwing(String title)
    {
        super(title);
    }

    @Override // IView
    public void fruit_count_set_text(String text)
    {
        fruit_count.setText(text);
    }

    @Override // IView
    public void fruit_increment_button_set_enabled(boolean enabled)
    {
        fruit_increment_button.setEnabled(enabled);
    }
    
    @Override // IView
    public void fruit_decrement_button_set_enabled(boolean enabled)
    {
        fruit_decrement_button.setEnabled(enabled);
    }
}

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello, World");
        
        VueGSwing view;
        Container pane;
        {
            view = new VueGSwing("Basket");
            view.setSize(1280, 720);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pane = view.getContentPane();
        }

        Model      model      = new Model();
        Controller controller = new Controller(model, view);

        {
            {
                JButton button = new JButton("+");
                button.setPreferredSize(new Dimension(200, 100));
                button.addActionListener(controller);
                pane.add(button, BorderLayout.NORTH);
                view.fruit_increment_button = button;
            }
            {
                String label = String.format("%d", model.fruit.count);
                JLabel fruit_count = new JLabel(label, SwingConstants.CENTER);
                fruit_count.setPreferredSize(new Dimension(200, 100));
                pane.add(fruit_count, BorderLayout.CENTER);
                view.fruit_count = fruit_count;
            }
            {
                JButton button = new JButton("-");
                button.setPreferredSize(new Dimension(200, 100));
                button.addActionListener(controller);
                pane.add(button, BorderLayout.SOUTH);
                view.fruit_decrement_button = button;
            }
        }

        controller.register_fruit_count_change();

        view.setVisible(true);
    }
}