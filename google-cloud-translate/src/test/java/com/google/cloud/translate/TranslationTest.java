/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.translate;

import static org.junit.Assert.assertEquals;

import com.google.api.services.translate.model.TranslationsResource;

import org.junit.Test;

public class TranslationTest {

  private static final String TRANSLATED_TEXT = "Hello world";
  private static final String SOURCE_LANGUAGE = "en";
  private static final TranslationsResource TRANSLATION_PB = new TranslationsResource()
      .setTranslatedText(TRANSLATED_TEXT)
      .setDetectedSourceLanguage(SOURCE_LANGUAGE);
  private static final Translation TRANSLATION = Translation.fromPb(TRANSLATION_PB);

  @Test
  public void testFromPb() {
    assertEquals(TRANSLATED_TEXT, TRANSLATION.translatedText());
    assertEquals(SOURCE_LANGUAGE, TRANSLATION.sourceLanguage());
    compareTranslation(TRANSLATION, Translation.fromPb(TRANSLATION_PB));
  }

  private void compareTranslation(Translation expected, Translation value) {
    assertEquals(expected, value);
    assertEquals(expected.translatedText(), value.translatedText());
    assertEquals(expected.sourceLanguage(), value.sourceLanguage());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
