package adminlte.navigation_menu.business;

import adminlte.html_template_renderer.HtmlTemplateRendererService;
import adminlte.navigation_menu.communication.AbstractMenu;
import adminlte.navigation_menu.communication.MenuTemplate;
import adminlte.navigation_menu.communication.menu_item.IMenuItem;
import adminlte.navigation_menu.communication.menu_item.MenuItemTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MenuRenderer {
    private HtmlTemplateRendererService htmlTemplateRendererService;

    public MenuRenderer(HtmlTemplateRendererService htmlTemplateRendererService)
    {
        this.htmlTemplateRendererService = htmlTemplateRendererService;
    }

    public String render(AbstractMenu menu)
    {
        var menuItems = new ArrayList<String>();

        for(IMenuItem menuItem: menu.menuItems) {
            menuItems.add(this.renderMenuItem(menuItem));
        }

        var menuTemplate = new MenuTemplate(menuItems);
        return this.htmlTemplateRendererService.renderTemplate(menuTemplate);
    }

    private String renderMenuItem(IMenuItem menuItem) {
        var menuItemTemplate = new MenuItemTemplate(menuItem.getTitle(), menuItem.getUrl(), menuItem.getTemplatePath());
        return this.htmlTemplateRendererService.renderTemplate(menuItemTemplate);
    }
}
