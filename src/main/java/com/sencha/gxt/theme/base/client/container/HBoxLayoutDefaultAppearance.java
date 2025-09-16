/**
 * Sencha GXT 3.1.1 - Sencha for GWT
 * Copyright(c) 2007-2014, Sencha, Inc.
 * licensing@sencha.com
 *
 * http://www.sencha.com/products/gxt/license/
 */
package com.sencha.gxt.theme.base.client.container;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutContainerAppearance;


public class HBoxLayoutDefaultAppearance extends BoxLayoutDefaultAppearance implements HBoxLayoutContainerAppearance {

  public interface HBoxLayoutBaseResources extends BoxLayoutBaseResources {
    @Override
    @Source({"BoxLayout.css", "HBoxLayout.css"})
    HBoxLayoutStyle style();

    @Source("more.gif")
    ImageResource moreIcon();
  }

  public interface HBoxLayoutStyle extends BoxLayoutStyle {
    String moreIcon();
  }

  private HBoxLayoutBaseResources resources;
  private HBoxLayoutStyle style;

  public HBoxLayoutDefaultAppearance() {
    this(GWT.<HBoxLayoutBaseResources>create(HBoxLayoutBaseResources.class));
  }

  public HBoxLayoutDefaultAppearance(HBoxLayoutBaseResources resources) {
    super(resources);
    this.resources = resources;
    this.style = resources.style();
  }

  @Override
  public ImageResource moreIcon() {
    return resources.moreIcon();
  }

  @Override
  public String moreButtonStyle() {
    return style.moreIcon();
  }
}
