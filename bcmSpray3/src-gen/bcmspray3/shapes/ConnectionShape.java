/**
 * This is a generated Shape for Spray
 */
package bcmspray3.shapes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.algorithms.styles.*;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

import org.eclipselabs.spray.runtime.graphiti.ISprayConstants;
import org.eclipselabs.spray.runtime.graphiti.styles.ISprayStyle;
import org.eclipselabs.spray.runtime.graphiti.shape.DefaultSprayConnection;

@SuppressWarnings("all")
public class ConnectionShape extends DefaultSprayConnection {

    private IGaService       gaService       = Graphiti.getGaService();
    private IPeService       peService       = Graphiti.getPeService();
    private IPeCreateService peCreateService = Graphiti.getPeCreateService();

    public static enum TextIds {
        assocText
    }

    public ConnectionShape(final IFeatureProvider fp) {
        super(fp);
    }

    @Override
    public Connection getConnection(final Diagram diagram, final ISprayStyle sprayStyle, final Anchor startAnchor, final Anchor endAnchor) {
        final Connection newConnection = peCreateService.createFreeFormConnection(diagram);
        newConnection.setStart(startAnchor);
        newConnection.setEnd(endAnchor);

        final Polyline polyline = gaService.createPolyline(newConnection);
        polyline.setStyle(sprayStyle.getStyle(diagram));

        // Define general layout of connection
        polyline.setLineStyle(LineStyle.SOLID);

        // Set the Placings of the connection
        {
            ConnectionDecorator decorator = peCreateService.createConnectionDecorator(newConnection, false, 0.5, true);
            decorator.setActive(true);
            Text element = gaService.createText(decorator);
            ISprayStyle style = sprayStyle;
            element.setStyle(style.getStyle(diagram));
            element.setForeground(style.getFontColor(diagram));
            gaService.setLocationAndSize(element, 0, -10, 60, 20);
            element.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
            element.setVerticalAlignment(Orientation.ALIGNMENT_TOP);
            element.setValue("");
            peService.setPropertyValue(element, ISprayConstants.TEXT_ID, TextIds.assocText.name());
            IDirectEditingInfo deinfo = getFeatureProvider().getDirectEditingInfo();
            deinfo.setMainPictogramElement(newConnection);
            deinfo.setPictogramElement(decorator);
            deinfo.setGraphicsAlgorithm(element);
        }
        {
            ConnectionDecorator decorator = peCreateService.createConnectionDecorator(newConnection, false, 1.0, true);
            List<Point> pointList = new ArrayList<Point>();
            pointList.add(gaService.createPoint(-10, 10, 0, 0));
            pointList.add(gaService.createPoint(0, 0, 0, 0));
            pointList.add(gaService.createPoint(-10, -10, 0, 0));
            Polygon element = gaService.createPolygon(decorator, pointList);
            ISprayStyle style = sprayStyle;
            element.setStyle(style.getStyle(diagram));
            element.setBackground(gaService.manageColor(diagram, IColorConstant.BLACK));
        }

        return newConnection;
    }
}
