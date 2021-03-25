import { PolymerElement } from '@polymer/polymer/polymer-element';
import { html } from '@polymer/polymer/lib/utils/html-tag';
import '@vaadin/vaadin-text-field';
import '@vaadin/vaadin-button';

class HelloWorldView extends PolymerElement {
  static get template() {
    return html`
      <h1>Willkommen!</h1><br />
      <p>Dies ist der KanjiSheetWriter 0.1.0.
      <div class="question"><p>Wie verwendet man dieses Tool?</p></div>
      <div class="answer"><p>Auf der nächsten Seite einfach ein Kanji eingeben und auf Kanji-Sheet generieren klicken! <br >
      Hier mal einige Beispiel-Kanjis: <br />
        雨 母 語 猫</p></div></p>
    `;
  }

  static get is() {
    return 'hello-world-view';
  }
}

customElements.define(HelloWorldView.is, HelloWorldView);
