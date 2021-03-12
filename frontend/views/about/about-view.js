import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-group.js';
import '@vaadin/vaadin-radio-button/src/vaadin-radio-button.js';

class AboutView extends PolymerElement {
  static get template() {
    return html`
<div id="div">
 <vaadin-text-field placeholder="Search" id="kanjiSearchTextField">
  <iron-icon icon="lumo:search" slot="prefix"></iron-icon>
 </vaadin-text-field>
 <vaadin-radio-group value="foo" id="radioGroupGridSelect">
  <vaadin-radio-button name="foo" id="radioButtonBigGrid">
    Großes Grid 
  </vaadin-radio-button>
  <vaadin-radio-button name="bar" id="radioButtonSmallGrid">
    Kleines Grid 
  </vaadin-radio-button>
 </vaadin-radio-group>
 <vaadin-button id="buttonGenerateSheet">
   Kanji-Sheet generieren 
 </vaadin-button>
</div>
<div style="width: 100%; height: 100%;">
  Div 
</div>
`;
  }

  static get is() {
    return 'about-view';
  }
}

customElements.define(AboutView.is, AboutView);
