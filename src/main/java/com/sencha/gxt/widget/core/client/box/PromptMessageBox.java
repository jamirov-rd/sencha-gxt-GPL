/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.widget.core.client.box;

import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * A message box that prompts for input with a single line text field and OK and
 * CANCEL buttons.
 * <p />
 * Code snippet:
 * 
 * <pre>
    final PromptMessageBox mb = new PromptMessageBox("Description", "Please enter a brief description");
    mb.addDialogHideHandler(new DialogHideHandler() {
      {@literal @}Override
      public void onDialogHide(DialogHideEvent event) {
        if (event.getHideButton() == PredefinedButton.OK) {
          // perform OK action
        } else if (event.getHideButton() == PredefinedButton.CANCEL) {
          // perform CANCEL action
        }
      }
    });
    mb.setWidth(300);
    mb.show();
 * </pre>
 */
public class PromptMessageBox extends AbstractInputMessageBox {

  /**
   * Creates a message box that prompts for input with a single line text field
   * and OK and CANCEL buttons.
   * 
   * @param title the title of the message box
   * @param message the message that appears in the message box
   */
  public PromptMessageBox(String title, String message) {
    super(new TextField(), title, message);
  }

  /**
   * Returns the single line text field.
   * 
   * @return the single line text field
   */
  public TextField getTextField() {
    return (TextField) field;
  }

}
