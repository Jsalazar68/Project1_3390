import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

    public class DeciderGUI extends JFrame {

        private JPanel panel, lowerPanel;
        private JButton addButton, removeButton, decideButton;
        private DefaultListModel<String> choiceListData, weightListData;
        private JList<String> choiceList;
        private JLabel Options, Choices;
        private JTextField inputOption;
        private Random random;

        public DeciderGUI(){
            panel = new JPanel(new BorderLayout());
            lowerPanel = new JPanel();
            setContentPane(panel);
            setTitle("Indecision Machine");
            setSize(500,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            inputOption = new JTextField(15);
            Options = new JLabel("Options");
            Choices = new JLabel("Choices");

            choiceListData = new DefaultListModel<>();
            choiceList = new JList<>(choiceListData);
            addButton = new JButton("Add");
            addButton.addActionListener(e -> AddItem());
            removeButton = new JButton("Remove");
            removeButton.addActionListener(e -> RemoveItem());
            decideButton = new JButton("Decide");
            decideButton.addActionListener(e-> MakeChoice());
            lowerPanel.add(decideButton);
            lowerPanel.add(removeButton);
            lowerPanel.add(addButton);
            lowerPanel.add(Options);
            lowerPanel.add(inputOption);
            JScrollPane scrollPane = new JScrollPane(choiceList);
            panel.add(Choices, BorderLayout.NORTH);
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(lowerPanel, BorderLayout.SOUTH);

        }
        private void AddItem() {

                String optionText = inputOption.getText();



                if (optionText.isBlank()) {
                    return;
                }

                String element = String.format("%s", optionText);
                choiceListData.addElement(element);


                inputOption.setText("");

            }


        private void RemoveItem() {

            int choiceIndex = choiceList.getSelectedIndex();

            if (choiceIndex >= 0) {
                choiceListData.remove(choiceIndex);

            }
        }
        private void MakeChoice() {
            int count = choiceList.getModel().getSize();

            if(count != 0) {
                random = new Random();
                int index = random.nextInt(count);

                String item = choiceList.getModel().getElementAt(index);
                JOptionPane.showMessageDialog(null, "You should: " + item);
            }
            else {
                JOptionPane.showMessageDialog(null, "Its a free day");

            }

        }
