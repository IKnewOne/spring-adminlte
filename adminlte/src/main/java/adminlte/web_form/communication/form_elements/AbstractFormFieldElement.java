package adminlte.web_form.communication.form_elements;


import adminlte.web_form.communication.validators.RequiredFieldValidator;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFormFieldElement<T extends AbstractFormFieldElement<T, TValueType>, TValueType> extends AbstractFormElement<T, TValueType> implements WebFormFieldElementInterface<TValueType> {
    public String label;
    protected boolean required = false;
    protected boolean nullable = false;
    protected String id;

    public T setLabel(String label)
    {
        this.label = label;
        return this.casted();
    }

    public String getLabel()
    {
        return this.label;
    }

    public T setRequired()
    {
        this.addValidator(new RequiredFieldValidator());
        this.required = true;
        return this.casted();
    }

    public T setRequired(boolean value)
    {
        this.addValidator(new RequiredFieldValidator());
        this.required = value;
        return this.casted();
    }

    public T setNullable()
    {
        this.nullable = true;
        return this.casted();
    }

    public T setNullable(boolean value)
    {
        this.nullable = value;
        return this.casted();
    }

    public T setId(String id)
    {
        this.id = id;
        return this.casted();
    }

    public Map<String, Object> getContextVariables() {
        var contextVariables = new HashMap<String, Object>();
        contextVariables.put("id", this.id);
        return contextVariables;
    }
}
