package com.d0rj.cafe.view;

import com.d0rj.cafe.order.InternetOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class OrderWindow extends JFrame {

    private final InternetOrder internetOrder;


    public OrderWindow(MainWindow parent, InternetOrder internetOrder){
        super("Оформить заказ");

        this.internetOrder = internetOrder;

        setSize(650,350);
        setResizable(false);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                parent.setVisible(true);
                parent.reset();
            }
        });

        construct();
    }


    private void construct() {
        var panel = new JPanel(new GridLayout(2, 1, 0, 10));
        add(panel);

        var textArea = new JTextArea(1, 1);
        textArea.setFont(new Font("TimesNewRoman", Font.PLAIN,18));
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.black);

        var scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);

        var sb = new StringBuilder("Позиции: \n");
        for (var menuItem : internetOrder.getItems())
            if(menuItem != null)
                sb.append('\t').append(menuItem.getName()).append(" - ").append(menuItem.getCost()).append("₽\n");

        textArea.setText(sb.toString());

        var submit = new JButton("Итого: " + internetOrder.costTotal() + '₽');
        submit.setFont(new Font("TimesNewRoman", Font.PLAIN,20));
        submit.addActionListener(e -> dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));
        panel.add(submit);
    }
}
