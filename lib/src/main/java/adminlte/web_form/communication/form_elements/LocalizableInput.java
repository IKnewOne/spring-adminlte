package adminlte.web_form.communication.form_elements;


import adminlte.web_form.WebFormDependencyProviderInterface;
import adminlte.web_form.business.glossary.IGlossaryFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalizableInput extends AbstractFormElement implements Localizable {
    private final String glossaryKey;
    private final List<String> languages;
    private final Map<String, String> textMapByLanguage;
    private WebFormDependencyProviderInterface dependencyProvider;

    public LocalizableInput(String glossaryKey, IGlossaryFacade glossaryFacade) {
        this.glossaryKey = glossaryKey;
        this.languages = this.dependencyProvider.getAvailableLanguages();
        this.textMapByLanguage = glossaryFacade.getGlossaryTextMapByLanguage(this.glossaryKey);

        for (var language : languages) {
            if (!this.textMapByLanguage.containsKey(language)) {
                this.textMapByLanguage.put(language, "");
            }
        }
    }

    public LocalizableInput() {
        this.glossaryKey = "";
        this.languages = this.dependencyProvider.getAvailableLanguages();
        this.textMapByLanguage = new HashMap<>();

        for (var language : languages) {
            if (!this.textMapByLanguage.containsKey(language)) {
                this.textMapByLanguage.put(language, "");
            }
        }
    }

    public String getGlossaryKey() {
        return glossaryKey;
    }

    @Override
    public String getTemplatePath() {
        return "web_form/form_elements/localizable_input.html";
    }

    public WebFormElementInterface addLanguage(String language) {
        this.languages.add(language);
        return this;
    }

    public Map<String, Object> getContextVariables() {
        return Map.of(
            "glossaryKey", this.glossaryKey,
            "languages", this.languages,
            "textMapByLanguage", this.textMapByLanguage
        );
    }

    public LocalizableInput setValue(Map<String, String> value) {
        if (value == null) {
            return this;
        }
        this.textMapByLanguage.putAll(value);
        return this;
    }
}
