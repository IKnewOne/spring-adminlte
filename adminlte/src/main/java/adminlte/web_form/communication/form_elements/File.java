package adminlte.web_form.communication.form_elements;

import java.util.HashMap;
import java.util.Map;

public class File extends AbstractFormFieldElement<File, String> {
    private final String templatePath = "web_form/form_elements/file.html";
    private String accept;
    private Boolean multiple = false;
    private Boolean hasUpdateUrlInput = false;
    private Boolean hasDeleteButton = true;

    public File(String accept) {
        this.accept = accept;
    }

    @Override
    public String getTemplatePath() { return this.templatePath; }

    public File setMultiple(Boolean multiple) {
        this.multiple = multiple;
        return this;
    }

    public File setHasUpdateUrlInput(Boolean hasUpdateUrlInput) {
        this.hasUpdateUrlInput = hasUpdateUrlInput;
        return this;
    }

    public File setHasDeleteButton(Boolean delete) {
        this.hasDeleteButton = delete;
        return this;
    }

    public Map<String, Object> getContextVariables() {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("accept", this.accept);
        contextVariables.put("multiple", this.multiple);
        contextVariables.put("hasDeleteButton", this.hasDeleteButton);
        contextVariables.put("hasUpdateUrlInput", this.hasUpdateUrlInput);
        contextVariables.put("id", this.id);
        return contextVariables;
    }
}
