import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-button';

class HelloWorldView extends PolymerElement {
  _attachDom(dom) {
    // Do not use a shadow root
    this.appendChild(dom);
  }
  static get template() {
    return html`
      <vaadin-text-field id="name" label="Your name"></vaadin-text-field>
      <vaadin-button id="sayHello">Say hello</vaadin-button>
    `;
  }

  static get is() {
    return 'hello-world-view';
  }
}

customElements.define(HelloWorldView.is, HelloWorldView);
