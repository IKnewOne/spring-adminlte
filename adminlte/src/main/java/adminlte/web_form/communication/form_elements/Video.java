package adminlte.web_form.communication.form_elements;

import java.util.HashMap;
import java.util.Map;

public class Video extends AbstractFormFieldElement<Video, String> {
    private final String templatePath = "web_form/form_elements/video.html";

    private Boolean hasUpdateUrlInput = false;

    public Video() {
    }

    public Video setHasUpdateUrlInput(Boolean hasUpdateUrlInput) {
        this.hasUpdateUrlInput = hasUpdateUrlInput;
        return this;
    }

    @Override
    public String getTemplatePath() {
        return this.templatePath;
    }

    public Map<String, Object> getContextVariables() {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("hasUpdateUrlInput", this.hasUpdateUrlInput);
        contextVariables.put("id", this.id);
        return contextVariables;
    }
}
