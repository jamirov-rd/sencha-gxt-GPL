/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.theme.base.client.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.cell.core.client.form.SpinnerFieldCell.SpinnerFieldAppearance;

public class SpinnerFieldDefaultAppearance extends TwinTriggerFieldDefaultAppearance implements SpinnerFieldAppearance {

  public interface SpinnerFieldResources extends TwinTriggerFieldResources {
    @Override
    @Source("spinnerUp.png")
    public ImageResource triggerArrow();

    @Override
    @Source("spinnerUpFocusClick.png")
    public ImageResource triggerArrowClick();

    @Override
    @Source("spinnerUpFocusOver.png")
    public ImageResource triggerArrowOver();

    @Override
    @Source("spinnerUpFocus.png")
    public ImageResource triggerArrowFocus();

    @Source("spinnerDown.png")
    public ImageResource twinTriggerArrow();

    @Source("spinnerDownFocusClick.png")
    public ImageResource twinTriggerArrowClick();

    @Source("spinnerDownFocusOver.png")
    public ImageResource twinTriggerArrowOver();

    @Source("spinnerDownFocus.png")
    public ImageResource twinTriggerArrowFocus();


    @Override
    @Source({"ValueBaseField.css", "TextField.css", "TriggerField.css", "SpinnerField.css"})
    SpinnerFieldStyle css();
  }

  public interface SpinnerFieldStyle extends TwinTriggerFieldStyle {

  }

  public SpinnerFieldDefaultAppearance() {
    this(GWT.<SpinnerFieldResources> create(SpinnerFieldResources.class));
  }

  public SpinnerFieldDefaultAppearance(TwinTriggerFieldResources res) {
    super(res);
  }
}
