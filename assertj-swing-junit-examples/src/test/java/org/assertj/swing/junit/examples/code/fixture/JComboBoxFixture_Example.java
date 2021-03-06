package org.assertj.swing.junit.examples.code.fixture;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.assertj.swing.aut.code.fixture.ComboboxFrame;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JComboBoxFixture;
import org.assertj.swing.junit.SwingJUnitExamples;
import org.junit.Test;

public class JComboBoxFixture_Example extends SwingJUnitExamples {
  private FrameFixture window;
  private JComboBoxFixture comboBox;

  @Override
  protected void onSetUp() {
    JFrame frame = GuiActionRunner.execute(() -> new ComboboxFrame());
    window = new FrameFixture(robot(), frame);
    window.show();
    comboBox = window.comboBox();
  }

  @Test
  public void enterText() throws InvocationTargetException, InterruptedException {
    SwingUtilities.invokeAndWait(() -> comboBox.target().setEditable(true));

    comboBox.enterText("some value");
  }
}
