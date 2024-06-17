import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DengueChecker extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> sexComboBox;
    private JCheckBox feverCheckBox;
    private JCheckBox headacheCheckBox;
    private JCheckBox musclePainCheckBox;
    private JCheckBox redSpotsCheckBox;
    private JCheckBox vomitingCheckBox;
    private JCheckBox nauseaCheckBox;
    private JCheckBox abdominalPainCheckBox;
    private JTextArea resultArea;

    public DengueChecker() {
        setTitle("Checador de Sintomas de Dengue");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel nameLabel = new JLabel("Nome:");
        nameLabel.setBounds(20, 20, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 165, 25);
        add(nameField);

        JLabel ageLabel = new JLabel("Idade:");
        ageLabel.setBounds(20, 60, 80, 25);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(100, 60, 165, 25);
        add(ageField);

        JLabel sexLabel = new JLabel("Sexo:");
        sexLabel.setBounds(20, 100, 80, 25);
        add(sexLabel);

        String[] sexOptions = {"Masculino", "Feminino", "Outro"};
        sexComboBox = new JComboBox<>(sexOptions);
        sexComboBox.setBounds(100, 100, 165, 25);
        add(sexComboBox);

        feverCheckBox = new JCheckBox("Febre");
        feverCheckBox.setBounds(20, 140, 250, 25);
        add(feverCheckBox);

        headacheCheckBox = new JCheckBox("Dor de cabeça");
        headacheCheckBox.setBounds(20, 170, 250, 25);
        add(headacheCheckBox);

        musclePainCheckBox = new JCheckBox("Dor corpo / articulações");
        musclePainCheckBox.setBounds(20, 200, 250, 25);
        add(musclePainCheckBox);

        redSpotsCheckBox = new JCheckBox("Manchas vermelhas no corpo");
        redSpotsCheckBox.setBounds(20, 230, 250, 25);
        add(redSpotsCheckBox);

        vomitingCheckBox = new JCheckBox("Vômitos");
        vomitingCheckBox.setBounds(20, 260, 250, 25);
        add(vomitingCheckBox);

        nauseaCheckBox = new JCheckBox("Náusea");
        nauseaCheckBox.setBounds(20, 290, 250, 25);
        add(nauseaCheckBox);

        abdominalPainCheckBox = new JCheckBox("Dor abdominal intensa e contínua");
        abdominalPainCheckBox.setBounds(20, 320, 250, 25);
        add(abdominalPainCheckBox);

        JButton checkButton = new JButton("Verificar");
        checkButton.setBounds(20, 360, 100, 25);
        add(checkButton);

        resultArea = new JTextArea();
        resultArea.setBounds(20, 400, 340, 80);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setEditable(false);
        add(resultArea);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkDengue();
            }
        });
    }

    private void checkDengue() {
        String name = nameField.getText().trim();
        String age = ageField.getText().trim();
        String sex = (String) sexComboBox.getSelectedItem();

        if (name.isEmpty() || age.isEmpty() || sex == null) {
            resultArea.setText("Os campos (Nome, Idade e Sexo) são obrigatórios.");
            return;
        }

        int symptomsCount = 0;
        boolean hasSevereSymptoms = false;
        if (feverCheckBox.isSelected()) symptomsCount++;
        if (headacheCheckBox.isSelected()) symptomsCount++;
        if (musclePainCheckBox.isSelected()) symptomsCount++;
        if (redSpotsCheckBox.isSelected()) symptomsCount++;
        if (vomitingCheckBox.isSelected()) {
            symptomsCount++;
            hasSevereSymptoms = true;
        }
        if (nauseaCheckBox.isSelected()) symptomsCount++;
        if (abdominalPainCheckBox.isSelected()) {
            symptomsCount++;
            hasSevereSymptoms = true;
        }

        if (hasSevereSymptoms) {
            resultArea.setText("Possibilidade de dengue com sintomas graves. Procure o posto de saúde mais próximo para atendimento imediatamente.");
        } else if (symptomsCount >= 3) {
            resultArea.setText("Possibilidade de dengue. Procure o posto de saúde mais próximo para atendimento.");
        } else {
            resultArea.setText("Baixa possibilidade de dengue, mas procure um posto de saúde caso sinta necessidade e fique atento ao surgimento de mais sintomas.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DengueChecker().setVisible(true);
            }
        });
    }
}
