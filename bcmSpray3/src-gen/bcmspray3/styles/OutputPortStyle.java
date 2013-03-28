/**
 * This is a generated Style class for Spray.
 */
package bcmspray3.styles;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.graphiti.mm.algorithms.styles.AdaptedGradientColoredAreas;
import org.eclipse.graphiti.util.IGradientType;
import org.eclipse.graphiti.mm.algorithms.styles.StylesFactory;
import org.eclipse.graphiti.util.IPredefinedRenderingStyle;
import org.eclipselabs.spray.styles.generator.util.GradientUtilClass;

/**
 * This is a generated Style class for Spray.
 * Description: the shape for an output
 */
@SuppressWarnings("all")
public class OutputPortStyle extends org.eclipselabs.spray.runtime.graphiti.styles.DefaultSprayStyle {

    /**
     * This method creates a Style and returns the defined style.
     * Description: the shape for an output
     */
    @Override
    public Style newStyle(Diagram diagram) {
        IGaService gaService = Graphiti.getGaService();

        // Creating Style with given id and description
        Style style = super.newStyle(diagram);
        style.setId("OutputPortStyle");
        style.setDescription("the shape for an output");

        // transparency value

        // background attributes
        style.setFilled(true);
        style.setBackground(gaService.manageColor(diagram, IColorConstant.YELLOW));

        // line attributes

        // font attributes
        String fontName = style.getFont().getName();
        int fontSize = 12;
        boolean fontItalic = style.getFont().isItalic();
        boolean fontBold = style.getFont().isBold();
        style.setFont(gaService.manageFont(diagram, fontName, fontSize, fontItalic, fontBold));

        return style;
    }

    /**
     * This method returns the font color for the style. 
     * The font color will be returned separated, because Graphiti allows just the foreground color.
     * The foreground color will be used for lines and fonts at the same time.
     */
    @Override
    public Color getFontColor(Diagram diagram) {
        return super.getFontColor(diagram);
    }

    /**
     * This method returns Color Schema of the Style
     */
    public AdaptedGradientColoredAreas getColorSchema() {
        return null;
    }
}
